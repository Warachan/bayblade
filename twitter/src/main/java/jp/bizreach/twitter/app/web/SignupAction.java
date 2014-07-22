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

import org.apache.commons.lang.StringUtils;
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
    protected String digestedPass;
    public String newEmail;
    public String username;
    public String accountName;
    public String password;
    public String confirmPass;
    public String groupName;
    public String status;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    public String index() {
        return "/signup.jsp";
    }

    @Execute(validate = "validate", input = "/signup.jsp")
    public String register() throws NoSuchAlgorithmException {
        password = signupForm.password;
        confirmPass = signupForm.confirmPass;
        username = signupForm.username;
        accountName = signupForm.accountName;
        groupName = signupForm.groupName;
        /* パスワード不可逆暗号化　*/
        digestedPass = passDigestLogic.build(password);
        newRegister();
        return "/home/?redirect=true";
    }

    // ===================================================================================
    //                                                                    Extracted Method
    //                                                                            ========
    /* validationに引っかからなかったら、会員登録する */
    private void newRegister() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Member member = new Member();
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
    }

    // ===================================================================================
    //                                                                          Validation
    //                                                                          ==========
    /* 会員登録画面　Validation */
    public ActionMessages validate() {
        password = signupForm.password;
        confirmPass = signupForm.confirmPass;
        username = signupForm.username;
        accountName = signupForm.accountName;
        groupName = signupForm.groupName;
        status = signupForm.status;
        ActionMessages errors = new ActionMessages();

        /* accountName */
        if (StringUtils.isEmpty(accountName)) {
            errors.add("accountName", new ActionMessage("名前が未入力です。", false));
        } else {
            if (accountName.length() > 20) {
                errors.add("accountName", new ActionMessage("名前が長すぎます。20文字以内で記入してください。", false));
            }
            String wordPtn = "[\\\"\\\':;,\\s]+";
            Pattern ptnCheck = Pattern.compile(wordPtn);
            Matcher wordMatcher = ptnCheck.matcher(accountName);
            if (wordMatcher.matches()) {
                errors.add("accountName", new ActionMessage("不正な文字が含まれています。", false));
            }
        }
        /* username */
        if (StringUtils.isEmpty(username)) {
            errors.add("username", new ActionMessage("ユーザ名が未入力です。", false));
        } else {
            String usernamePtn = "[A-Za-z0-9]+";
            Pattern ptn2 = Pattern.compile(usernamePtn);
            Matcher usernameMatcher = ptn2.matcher(username);
            if (!usernameMatcher.matches()) {
                errors.add("username", new ActionMessage("ユーザ名に不正な文字が含まれています。", false));
            }
            MemberCB check = new MemberCB();
            check.query().setUserName_Equal(username);
            int nameCount = memberBhv.selectCount(check);
            if (nameCount > 0) {
                errors.add("username", new ActionMessage("このユーザ名はすでに使われています。", false));
            }
            if (username.length() < 5 || username.length() > 100) {
                errors.add("username", new ActionMessage("ユーザ名は5文字以上、100文字以内で入力してください。", false));
            }
        }
        /* status */
        if (StringUtils.isEmpty(status)) {
            errors.add("status", new ActionMessage("どちらか選択してください。", false));
        }
        /* group */
        if (StringUtils.isEmpty(groupName)) {
            errors.add("groupName", new ActionMessage("所属企業か所属大学名が未入力です。", false));
        } else {
            if (groupName.length() > 100) {
                errors.add("groupName", new ActionMessage("記入事項が長すぎます。", false));
            }
            String wordPtn2 = "[\\\"\\\':;,\\s]+";
            Pattern ptnCheck2 = Pattern.compile(wordPtn2);
            Matcher wordMatcher2 = ptnCheck2.matcher(groupName);
            if (wordMatcher2.matches()) {
                errors.add("groupName", new ActionMessage("不正な文字が含まれています。", false));
            }
        }
        /*　password */
        if (StringUtils.isEmpty(password)) {
            errors.add("password", new ActionMessage("パスワードが未入力です。", false));
        } else {
            String pswdPtn = "[A-Za-z0-9]+";
            Pattern ptn3 = Pattern.compile(pswdPtn);
            Matcher pswdMatcher = ptn3.matcher(password);
            if (!pswdMatcher.matches()) {
                errors.add("password", new ActionMessage("アルファベットか数字を入力してください。", false));
            }
            if (password.length() > 20 || password.length() < 8) {
                errors.add("password", new ActionMessage("パスワードは8文字以上、20文字以下にしてください。", false));
            }
            if (!password.equals(signupForm.confirmPass)) {
                errors.add("password", new ActionMessage("パスワードが一致しません。", false));
            }
        }
        return errors;
    }
}
