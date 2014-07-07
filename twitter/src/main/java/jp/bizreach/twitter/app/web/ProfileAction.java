package jp.bizreach.twitter.app.web;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.exbhv.LoginBhv;
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
 * プロフィール登録
 * 誕生日登録
 * 学歴、職歴登録
 * （団体登録）
 * パスワード変更
 * メールアドレス変更
 *
 * @author mayuko.sakaba
 *
 */
public class ProfileAction {

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
    protected ProfileForm profileForm;
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
    public String email;
    public String accountName;
    public String groupName;
    public String password;
    public String confirmPass;
    public String matchError;
    public String overlapsError;
    public String characterError;
    public String userError;
    public String missingError;
    protected String digestedPass;
    public boolean status;

    // TODO mayuko.sakaba signup.jspにて、なぜゲッターメソッドがなかったのにValue=""をいれたら直ったか調べること。
    // TODO mayuko.sakaba indexActionForm に対する定義が見つかりません →　これなに？
    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======

    @Execute(validator = false)
    public String index() {
        return "/profile.jsp";
    }

    @Execute(validate = "validate", input = "/profile.jsp")
    /* プロフィール編集メソッド */
    public String editProfile() throws NoSuchAlgorithmException {
        email = profileForm.updateEmail;
        password = profileForm.updatePassword;
        confirmPass = profileForm.confirmPass;
        accountName = profileForm.updateName;
        groupName = profileForm.updateGroup;
        /* パスワード不可逆暗号化　*/
        digestedPass = passDigestLogic.build(password);
        /* validationに引っかからなかったら、プロフィール編集する */
        Member member = new Member();
        member.setMemberId(sessionDto.myId);
        if (email != "") {
            member.setEmailAddress(email);
            memberBhv.update(member);
            sessionDto.email = email;
        }
        if (accountName != "") {
            member.setAccountName(accountName);
            memberBhv.update(member);
            sessionDto.accountName = member.getAccountName();
        }
        if (groupName != "") {
            member.setGroupName(profileForm.updateGroup);
            memberBhv.update(member);
        }
        if (profileForm.updateStatus != "") {
            if (profileForm.updateStatus.equals("student")) {
                member.setMemberStatusCode(1);
                memberBhv.update(member);
                sessionDto.status = member.getMemberStatusCode();
            } else if (profileForm.updateStatus.equals("company")) {
                member.setMemberStatusCode(2);
                memberBhv.update(member);
                sessionDto.status = member.getMemberStatusCode();
            }
        }
        if (password != "") {
            MemberSecurity security = new MemberSecurity();
            security.setMemberId(sessionDto.myId);
            security.setPassword(digestedPass);
            memberSecurityBhv.update(security);
            LOG.debug("***" + sessionDto.myId);
        }
        if (sessionDto.status.equals(1)) {
            status = new Boolean(true);
        } else if (sessionDto.status.equals(2)) {
            status = new Boolean(false);
        }
        if (profileForm.interestedIndustry != "") {
            member.setInterestedIndustry(profileForm.interestedIndustry);
            memberBhv.update(member);
        }
        if (profileForm.graduationYear != null) {
            member.setGraduationYear(profileForm.graduationYear);
            memberBhv.update(member);
        }
        if (profileForm.recruitingNumber != null) {
            member.setRecruitingNumber(profileForm.recruitingNumber);
            memberBhv.update(member);
        }
        return "/profile/?redirect=true";
    }

    /* 会員登録画面　Validation */
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        /* Email */
        String emailPtn = "[\\w\\.\\-+]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
        Pattern ptn = Pattern.compile(emailPtn);
        Matcher emailMatcher = ptn.matcher(profileForm.updateEmail);
        MemberCB cb = new MemberCB();
        cb.query().setEmailAddress_Equal(profileForm.updateEmail);
        int count = memberBhv.selectCount(cb);
        if (profileForm.updateEmail != "") {
            if (!emailMatcher.matches()) {
                errors.add("updateEmail", new ActionMessage("メールアドレスが不正です。", false));
            }
            if (profileForm.updateEmail.length() > 128) { // 数はv4やregionupの登録文字数を参考にして
                errors.add("uupdateEmail", new ActionMessage("メールアドレスが長すぎます。", false));
            }
            if (count > 0) {
                errors.add("updateEmail", new ActionMessage("このメールアドレスはすでに登録されています。", false));
            }
        }
        /* accountName */
        // TODO mayuko.sakaba 入力に許される文字列の指定がまだです。
        if (profileForm.updateName != "") {
            if (profileForm.updateName.length() > 100) {
                errors.add("updateName", new ActionMessage("このアカウント名は長すぎます。", false));
            }
        }
        /* recruitingNumber */
        if (sessionDto.status.equals(2)) {
            if (profileForm.recruitingNumber > 1000) {
                errors.add("recrutingNumber", new ActionMessage("人数が多すぎます。", false));
            }
        }
        /* interestedIndustry */
        if (sessionDto.status.equals(1)) {
            if (profileForm.interestedIndustry.length() > 100) {
                errors.add("interestedIndustry", new ActionMessage("文字制限以上入力されました。", false));
            }
        }
        /*　password */
        String pswdPtn = "[\\w]+";
        Pattern ptn3 = Pattern.compile(pswdPtn);
        Matcher pswdMatcher = ptn3.matcher(profileForm.updatePassword);
        if (profileForm.updatePassword != "") {
            if (!pswdMatcher.matches()) {
                errors.add("updatePassword", new ActionMessage("アルファベットか数字を入力してください。", false));
            }
            if (profileForm.updatePassword.length() > 20 || profileForm.updatePassword.length() < 8) {
                errors.add("updatePassword", new ActionMessage("パスワードは8文字以上、20文字以下にしてください。", false));
            }
            if (!profileForm.updatePassword.equals(profileForm.confirmPass)) {
                errors.add("updatePassword", new ActionMessage("パスワードが一致しません。", false));
            }
        }
        return errors;
    }
}
