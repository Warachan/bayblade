package jp.bizreach.twitter.app.web;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

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
    // public String email;
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
        LOG.debug("##############################################" + sessionDto.status);
        if (sessionDto.status.equals(1)) {
            status = new Boolean(true);
        } else if (sessionDto.status.equals(2)) {
            status = new Boolean(false);
        }
        return "/profile.jsp";
    }

    @Execute(validate = "validate", input = "/profile.jsp")
    /* プロフィール編集メソッド */
    public String editProfile() throws NoSuchAlgorithmException {
        //  email = profileForm.updateEmail;
        password = profileForm.updatePassword;
        confirmPass = profileForm.confirmPass;
        accountName = profileForm.updateName;
        groupName = profileForm.updateGroup;
        /* パスワード不可逆暗号化　*/
        digestedPass = passDigestLogic.build(password);
        /* validationに引っかからなかったら、プロフィール編集する */
        Member member = new Member();
        member.setMemberId(sessionDto.myId);
        member.setMemberStatusCode(sessionDto.status);
        //        if (email != "") {
        //            member.setEmailAddress(email);
        //            memberBhv.update(member);
        //            sessionDto.email = email;
        //        }
        if (accountName != "") {
            member.setAccountName(accountName);
            memberBhv.update(member);
            sessionDto.accountName = member.getAccountName();
        }
        if (groupName != "") {
            member.setGroupName(profileForm.updateGroup);
            memberBhv.update(member);
        }
        if (password != "") {
            MemberSecurity security = new MemberSecurity();
            security.setMemberId(sessionDto.myId);
            security.setPassword(digestedPass);
            memberSecurityBhv.update(security);
            LOG.debug("***" + sessionDto.myId);
        }
        if (sessionDto.status.equals(1)) {
            if (profileForm.interestedIndustry != "") {
                member.setInterestedIndustry(profileForm.interestedIndustry);
                memberBhv.update(member);
            }
            if (profileForm.graduationYear != null) {
                LOG.debug("**************************************************************");
                member.setGraduationYear(profileForm.graduationYear);
                memberBhv.update(member);
            }
        }
        if (sessionDto.status.equals(2)) {
            if (profileForm.recruitingNumber != "") {
                member.setRecruitingNumber(profileForm.recruitingNumber);
                memberBhv.update(member);
            }
        }
        return "/profile/?redirect=true";
    }

    /* 会員登録画面　Validation */
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        /* Email
        if (profileForm.updateEmail != "") {
            String emailPtn = "[\\w\\.\\-+]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
            Pattern ptn = Pattern.compile(emailPtn);
            Matcher emailMatcher = ptn.matcher(profileForm.updateEmail);
            MemberCB cb = new MemberCB();
            cb.query().setEmailAddress_Equal(profileForm.updateEmail);
            int count = memberBhv.selectCount(cb);
            if (!emailMatcher.matches()) {
                errors.add("updateEmail", new ActionMessage("メールアドレスが不正です。", false));
            }
            if (profileForm.updateEmail.length() > 128) { // 数はv4やregionupの登録文字数を参考にして
                errors.add("uupdateEmail", new ActionMessage("メールアドレスが長すぎます。", false));
            }
            if (count > 0) {
                errors.add("updateEmail", new ActionMessage("このメールアドレスはすでに登録されています。", false));
            }
        }*/
        /* accountName */
        // TODO mayuko.sakaba 入力に許される文字列の指定がかなりあいまいです。
        if (profileForm.updateName != "") {
            if (profileForm.updateName.length() > 20) {
                errors.add("updateName", new ActionMessage("このアカウント名は長すぎます。", false));
            }
            String wordPtn = "[\\\"\\\':;,]+";
            Pattern ptnCheck = Pattern.compile(wordPtn);
            Matcher wordMatcher = ptnCheck.matcher(profileForm.updateName);
            if (wordMatcher.matches()) {
                errors.add("updatetName", new ActionMessage("不正な文字が含まれています。", false));
            }
        }
        /* interestedIndustry */
        if (sessionDto.status.equals(1)) {
            if (profileForm.interestedIndustry != "") {
                if (profileForm.interestedIndustry.length() > 50) {
                    errors.add("interestedIndustry", new ActionMessage("文字制限以上入力されました。", false));
                }
                String wordPtn3 = "[\\\"\\\':;,]+";
                Pattern ptnCheck3 = Pattern.compile(wordPtn3);
                Matcher wordMatcher3 = ptnCheck3.matcher(profileForm.updateGroup);
                if (wordMatcher3.matches()) {
                    errors.add("interestedIndustry", new ActionMessage("不正な文字が含まれています。", false));
                }
            }
        }
        /* group name */
        if (profileForm.updateGroup != "") {
            if (profileForm.updateGroup.length() > 100) {
                errors.add("updateGroup", new ActionMessage("所属企業名、もしくは学校名が長すぎます", false));
            }
            String wordPtn2 = "[\\\"\\\':;,\\s]+";
            Pattern ptnCheck2 = Pattern.compile(wordPtn2);
            Matcher wordMatcher2 = ptnCheck2.matcher(profileForm.updateGroup);
            if (profileForm.updateGroup == "" || wordMatcher2.matches()) {
                errors.add("updateGroup", new ActionMessage("不正な文字が含まれています。", false));
            }
        }
        /*　password */
        if (profileForm.updatePassword != "") {
            String pswdPtn = "[\\w]+";
            Pattern ptn3 = Pattern.compile(pswdPtn);
            Matcher pswdMatcher = ptn3.matcher(profileForm.updatePassword);
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
