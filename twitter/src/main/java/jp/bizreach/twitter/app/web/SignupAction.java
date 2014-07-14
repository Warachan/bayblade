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

        // newEmail = signupForm.newEmail;
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
        // sessionDto.email = newEmail;
        Member member = new Member();
        // member.setEmailAddress(sessionDto.email);
        member.setUserName(username);
        member.setAccountName(accountName);
        member.setInsDatetime(timestamp);
        member.setUpdDatetime(timestamp);
        member.setInsTrace(username);
        member.setUpdTrace(username);
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
        security.setInsTrace(member.getUserName());
        security.setUpdTrace(member.getUserName());
        memberSecurityBhv.insert(security);
        LOG.debug("***" + sessionDto.myId);

        Login login = new Login();
        login.setMemberId(sessionDto.myId);
        login.setInsDatetime(timestamp);
        login.setUpdDatetime(timestamp);
        login.setInsTrace(sessionDto.username);
        login.setUpdTrace(sessionDto.username);
        loginBhv.insert(login);

        return "/home/?redirect =true";
    }

    /* 会員登録画面　Validation */
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();

        /* accountName */
        // TODO mayuko.sakaba 入力に許される文字列の指定がまだです。
        if (signupForm.accountName == "") {
            errors.add("accountName", new ActionMessage("名前が未入力です。", false));
        }
        if (signupForm.accountName.length() > 20) {
            errors.add("accountName", new ActionMessage("名前が長すぎます。20文字以内で記入してください。", false));
        }
        String wordPtn = "[\\\"\\\':;,]+";
        Pattern ptnCheck = Pattern.compile(wordPtn);
        Matcher wordMatcher = ptnCheck.matcher(signupForm.accountName);
        if (signupForm.accountName == "" || wordMatcher.matches()) {
            errors.add("accountName", new ActionMessage("不正な文字が含まれています。", false));
        }
        /* username */
        String usernamePtn = "[//w]+";
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
            if (signupForm.username.length() < 5 || signupForm.username.length() > 100) {
                errors.add("username", new ActionMessage("ユーザ名は5文字以上、100文字以内で入力してください。", false));
            }
        }
        /* status */
        if (signupForm.status == "") {
            errors.add("status", new ActionMessage("どちらか選択してください。", false));
        }
        /* group */
        if (signupForm.groupName == "") {
            errors.add("groupName", new ActionMessage("所属企業か所属大学名が未入力です。", false));
        }
        if (signupForm.groupName.length() > 100) {
            errors.add("groupName", new ActionMessage("記入事項が長すぎます。", false));
        }
        String wordPtn2 = "[\\\"\\\':;,]+";
        Pattern ptnCheck2 = Pattern.compile(wordPtn2);
        Matcher wordMatcher2 = ptnCheck2.matcher(signupForm.groupName);
        if (signupForm.groupName == "" || wordMatcher2.matches()) {
            errors.add("groupName", new ActionMessage("不正な文字が含まれています。", false));
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
