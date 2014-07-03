package jp.bizreach.twitter.app.web;

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
    public String regester() {

        newEmail = signupForm.newEmail;
        password = signupForm.password;
        confirmPass = signupForm.confirmPass;
        username = signupForm.username;
        Matcher emailMatcher = emailMatch();
        Matcher pswdMatcher = pswdMatch();

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
        /* 上記の問題に引っかからなかったら、会員登録する */
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        sessionDto.email = newEmail;
        Member member = insertMember(timestamp);
        sessionDto.myId = member.getMemberId();
        sessionDto.username = member.getUserName();
        LOG.debug("***" + sessionDto.myId);

        if (password.equals(confirmPass)) {
            //insertSecurity(timestamp, member);
            //                return /twitter/home.jsp";
            return "/home/?redirect=true";
        } else {
            matchError = "パスワードが一致しません。";
            return "/signup.jsp";
        }
    }

    /* Validation */
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        /* Email validate */
        String emailPtn = "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
        Pattern ptn = Pattern.compile(emailPtn);
        Matcher emailMatcher = ptn.matcher(signupForm.newEmail);
        if (!emailMatcher.matches()) {
            errors.add("newEmail", new ActionMessage("メールアドレスが不正です。", false));
        }
        if (signupForm.newEmail.length() > 30) {
            errors.add("newEmail", new ActionMessage("メールアドレスが長すぎます。", false));
        }
        MemberCB cb = new MemberCB();
        cb.query().setEmailAddress_Equal(signupForm.newEmail);
        int count = memberBhv.selectCount(cb);
        if (count > 0) {
            errors.add("newEmail", new ActionMessage("このメールアドレスはすでに登録されています。", false));
        }
        /* username */
        if (signupForm.username.length() <= 5) {
            errors.add("username", new ActionMessage("ユーザ名は五文字以上で入力してください。", false));
        }
        MemberCB check = new MemberCB();
        check.query().setUserName_Equal(signupForm.username);
        int nameCount = memberBhv.selectCount(check);
        if (nameCount > 0) {
            errors.add("username", new ActionMessage("このユーザ名はすでに使われています。", false));
        }
        /*　password */
        String pswdPtn = "[\\w]+";
        Pattern ptn2 = Pattern.compile(pswdPtn);
        Matcher pswdMatcher = ptn2.matcher(signupForm.password);
        if (!pswdMatcher.matches()) {
            errors.add("password", new ActionMessage("errors.invalid", false));
        }
        if (!signupForm.password.equals(signupForm.confirmPass)) {
            errors.add("password", new ActionMessage("パスワードが一致しません。", false));
        }
        if (signupForm.password.length() >= 20 || signupForm.password.length() <= 5) {
            errors.add("password", new ActionMessage("パスワードは5文字以上、20文字以内で入力してください。", false));
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
