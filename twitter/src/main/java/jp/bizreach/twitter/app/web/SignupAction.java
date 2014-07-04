package jp.bizreach.twitter.app.web;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.MemberSecurityBhv;
import jp.bizreach.twitter.dbflute.exentity.Member;
import jp.bizreach.twitter.dbflute.exentity.MemberSecurity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */
public class SignupAction {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(SignupAction.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected SignupForm signupForm;
    @Resource
    protected SessionDto sessionDto;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected MemberSecurityBhv memberSecurityBhv;
    @Resource
    protected PassDigestLogic passDigestLogic;
    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public String newEmail;
    public String username;
    public String password;
    public String confirmPass;
    public String matchError;
    public String overlapsError;
    public String characterError;
    public String userError;
    public String missingError;
    protected String passDigest;

    // TODO mayuko.sakaba signup.jspにて、なぜゲッターメソッドがなかったのにValue=""をいれたら直ったか調べること。
    // TODO mayuko.sakaba indexActionForm に対する定義が見つかりません →　これなに？
    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    /* signup画面表示 */
    public String index() {
        return "/signup.jsp";
    }

    @Execute(validate = "validate", input = "/signup.jsp")
    /* 会員登録メソッド */
    public String regester() throws NoSuchAlgorithmException {

        newEmail = signupForm.newEmail;
        password = signupForm.password;
        confirmPass = signupForm.confirmPass;
        username = signupForm.username;
        //        Matcher emailMatcher = emailMatch();
        //        Matcher pswdMatcher = pswdMatch();

        /* パスワード不可逆暗号化　*/
        String digestedPass = passDigestLogic.build(password);

        /* validationに引っかからなかったら、会員登録する */
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        sessionDto.email = newEmail;
        Member member = new Member();
        member.setEmailAddress(sessionDto.email);
        member.setUserName(username);
        member.setInsDatetime(timestamp);
        member.setUpdDatetime(timestamp);
        member.setInsTrace("signedup");
        member.setUpdTrace("signedup");
        memberBhv.insert(member);

        MemberSecurity security = new MemberSecurity();
        security.setMemberId(member.getMemberId());
        security.setPassword(digestedPass);
        security.setInsDatetime(timestamp);
        security.setUpdDatetime(timestamp);
        security.setInsTrace("signedup");
        security.setUpdTrace("signedup");
        memberSecurityBhv.insert(security);
        sessionDto.myId = member.getMemberId();
        sessionDto.username = member.getUserName();
        LOG.debug("***" + sessionDto.myId);

        return "/home/?redirect =true";
    }

    // TODO mayuko.sakaba サインアップ時にログイン時間として登録するが抜けている。
    /* Validation */
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        /* Email validate */
        String emailPtn = "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
        Pattern ptn = Pattern.compile(emailPtn);
        Matcher emailMatcher = ptn.matcher(signupForm.newEmail);
        if (!emailMatcher.matches()) {
            errors.add("newEmail", new ActionMessage("Wrong Email Address", false));
        }
        if (signupForm.newEmail.length() > 30) {
            errors.add("newEmail", new ActionMessage("Your email address is too long.", false));
        }
        MemberCB cb = new MemberCB();
        cb.query().setEmailAddress_Equal(signupForm.newEmail);
        int count = memberBhv.selectCount(cb);
        if (count > 0) {
            errors.add("newEmail", new ActionMessage("This email address is already registered.", false));
        }
        /* username */
        //        if (signupForm.username.length() < 5) {
        //            errors.add("username", new ActionMessage("Username should be more than 5 characters.", false));
        //        }
        MemberCB check = new MemberCB();
        check.query().setUserName_Equal(signupForm.username);
        int nameCount = memberBhv.selectCount(check);
        if (nameCount > 0) {
            errors.add("username", new ActionMessage("This username is already used by someone else.", false));
        }
        /*　password */
        String pswdPtn = "[\\w]+";
        Pattern ptn2 = Pattern.compile(pswdPtn);
        Matcher pswdMatcher = ptn2.matcher(signupForm.password);
        if (!pswdMatcher.matches()) {
            errors.add("password", new ActionMessage("Invalid password. Only alphabets or numbers are allowed", false));
        }
        if (!signupForm.password.equals(signupForm.confirmPass)) {
            errors.add("password", new ActionMessage("Password doesn't match.", false));
        }
        if (signupForm.password.length() > 20 && signupForm.password.length() < 1) {
            errors.add("password", new ActionMessage("Please enter your password no more than 20 characters.", false));
        }
        return errors;
    }

    private Matcher pswdMatch() {
        String pswdPtn = "[\\w]+";
        Pattern ptn2 = Pattern.compile(pswdPtn);
        Matcher pswdMatcher = ptn2.matcher(password);
        return pswdMatcher;
    }

    private Matcher emailMatch() {
        String emailPtn = "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
        Pattern ptn = Pattern.compile(emailPtn);
        Matcher emailMatcher = ptn.matcher(newEmail);
        return emailMatcher;
    }

    private Member insertMember(Timestamp timestamp) {
        Member member = new Member();
        member.setEmailAddress(sessionDto.email);
        member.setUserName(username);
        member.setInsDatetime(timestamp);
        member.setUpdDatetime(timestamp);
        member.setInsTrace("signedup");
        member.setUpdTrace("signedup");
        memberBhv.insert(member);
        return member;
    }

    private int selectEmailCount() {
        MemberCB cb = new MemberCB();
        cb.query().setEmailAddress_Equal(newEmail);
        int count = memberBhv.selectCount(cb);
        return count;
    }

    private int selectNameCount() {
        MemberCB check = new MemberCB();
        check.query().setUserName_Equal(username);
        int nameCount = memberBhv.selectCount(check);
        return nameCount;
    }

    private void insertSecurity(Timestamp timestamp, Member member) {
        MemberSecurity security = new MemberSecurity();
        security.setMemberId(member.getMemberId());
        security.setPassword(password);
        security.setInsDatetime(timestamp);
        security.setUpdDatetime(timestamp);
        security.setInsTrace("signedup");
        security.setUpdTrace("signedup");
        memberSecurityBhv.insert(security);
    }

}

/** 必須項目が空欄でないことをチェック
    if (newEmail == "" || password == "" || username == "") {
        missingError = "*全ての欄は必須項目です。";
        return "/signup.jsp";
    }
 */

/* ユーザ名がすでに使われていないかチェック */
/**
    int nameCount = selectNameCount();
    if (nameCount > 0) {
        userError = "そのユーザ名はすでに使われています。";
        return "/signup.jsp";
    }
 */
