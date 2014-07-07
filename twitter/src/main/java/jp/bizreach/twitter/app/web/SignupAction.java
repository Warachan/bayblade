package jp.bizreach.twitter.app.web;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.exbhv.LoginBhv;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.MemberSecurityBhv;
import jp.bizreach.twitter.dbflute.exentity.Login;
import jp.bizreach.twitter.dbflute.exentity.Member;
import jp.bizreach.twitter.dbflute.exentity.MemberSecurity;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * 性別
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
    protected LoginBhv loginBhv;
    @Resource
    protected PassDigestLogic passDigestLogic;
    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public String newEmail;
    public String username;
    public String accountName;
    public String password;
    public String confirmPass;
    public String groupName;
    public String matchError;
    public String overlapsError;
    public String characterError;
    public String userError;
    public String missingError;
    protected String digestedPass;

    // public ArrayList<Integer> yearList = new ArrayList<>();

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
        accountName = signupForm.accountName;
        groupName = signupForm.groupName;

        /* パスワード不可逆暗号化　*/
        digestedPass = passDigestLogic.build(password);

        /* validationに引っかからなかったら、会員登録する */
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        sessionDto.email = newEmail;
        Member member = new Member();
        member.setEmailAddress(sessionDto.email);
        member.setUserName(username);
        member.setAccountName(accountName);
        member.setInsDatetime(timestamp);
        member.setUpdDatetime(timestamp);
        member.setInsTrace("signedup");
        member.setUpdTrace("signedup");
        member.setGroupName(groupName);
        if (signupForm.status.equals("student")) {
            member.setMemberStatusCode(1);
        } else if (signupForm.status.equals("company")) {
            member.setMemberStatusCode(2);
        }
        memberBhv.insert(member);
        sessionDto.myId = member.getMemberId();
        sessionDto.username = member.getUserName();
        sessionDto.accountName = member.getAccountName();
        sessionDto.status = member.getMemberStatusCode();

        MemberSecurity security = new MemberSecurity();
        security.setMemberId(member.getMemberId());
        security.setPassword(digestedPass);
        security.setInsDatetime(timestamp);
        security.setUpdDatetime(timestamp);
        security.setInsTrace("signedup");
        security.setUpdTrace("signedup");
        memberSecurityBhv.insert(security);
        LOG.debug("***" + sessionDto.myId);

        Login login = new Login();
        login.setMemberId(sessionDto.myId);
        login.setInsDatetime(timestamp);
        login.setUpdDatetime(timestamp);
        login.setInsTrace(sessionDto.email);
        login.setUpdTrace(sessionDto.email);
        loginBhv.insert(login);

        return "/home/?redirect =true";
    }

    /* 会員登録画面　Validation */
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        /* Email */
        String emailPtn = "[\\w\\.\\-+]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
        Pattern ptn = Pattern.compile(emailPtn);
        Matcher emailMatcher = ptn.matcher(signupForm.newEmail);
        MemberCB cb = new MemberCB();
        cb.query().setEmailAddress_Equal(signupForm.newEmail);
        int count = memberBhv.selectCount(cb);
        if (signupForm.newEmail == "") {
            errors.add("newEmail", new ActionMessage("メールアドレスが未入力です。", false));
        } else {
            if (!emailMatcher.matches()) {
                errors.add("newEmail", new ActionMessage("メールアドレスが不正です。", false));
            }
            if (signupForm.newEmail.length() > 128) { // 数はv4やregionupの登録文字数を参考にして
                errors.add("newEmail", new ActionMessage("メールアドレスが長すぎます。", false));
            }
            if (count > 0) {
                errors.add("newEmail", new ActionMessage("このメールアドレスはすでに登録されています。", false));
            }
        }
        /* accountName */
        // TODO mayuko.sakaba 入力に許される文字列の指定がまだです。
        if (signupForm.accountName == "") {
            errors.add("accountName", new ActionMessage("名前が未入力です。", false));
        }
        /* username */
        String usernamePtn = "[\\w\\.\\-]+";
        Pattern ptn2 = Pattern.compile(usernamePtn);
        Matcher usernameMatcher = ptn2.matcher(signupForm.username);
        MemberCB check = new MemberCB();
        check.query().setUserName_Equal(signupForm.username);
        int nameCount = memberBhv.selectCount(check);
        if (signupForm.username == "") {
            errors.add("username", new ActionMessage("ユーザ名が未入力です。", false));
        } else {
            if (!usernameMatcher.matches()) {
                errors.add("username", new ActionMessage("ユーザ名に不正な文字が含まれています。", false));
            }
            if (nameCount > 0) {
                errors.add("username", new ActionMessage("このユーザ名はすでに使われています。", false));
            }
        }
        //        if (signupForm.username.length() < 5) {
        //            errors.add("username", new ActionMessage("Username should be more than 5 characters.", false));
        //        }
        /* status */
        if (signupForm.status == "") {
            errors.add("status", new ActionMessage("どちらか選択してください。", false));
        }
        /* group */
        if (signupForm.groupName == "") {
            errors.add("groupName", new ActionMessage("所属企業か所属大学名が未入力です。", false));
        }
        /*　password */
        String pswdPtn = "[\\w]+";
        Pattern ptn3 = Pattern.compile(pswdPtn);
        Matcher pswdMatcher = ptn3.matcher(signupForm.password);
        if (signupForm.password == "") {
            errors.add("password", new ActionMessage("パスワードが未入力です。", false));
        } else {
            if (!pswdMatcher.matches()) {
                errors.add("password", new ActionMessage("アルファベットか数字を入力してください。", false));
            }
            if (signupForm.password.length() > 20 || signupForm.password.length() < 8) {
                errors.add("password", new ActionMessage("パスワードは8文字以上、20文字以下にしてください。", false));
            }
            if (!signupForm.password.equals(signupForm.confirmPass)) {
                errors.add("password", new ActionMessage("パスワードが一致しません。", false));
            }
        }
        return errors;
    }
}
