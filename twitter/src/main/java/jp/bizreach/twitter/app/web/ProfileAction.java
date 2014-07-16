package jp.bizreach.twitter.app.web;

import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.util.StringUtil;
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
    @Resource
    protected HttpServletRequest request;
    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
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
    public String interestedIndustry;
    public String recruitingNumber;
    public Integer graduationYear;
    public Integer seeStatus;
    public String account;
    public boolean status;
    public boolean recruitStatus;

    // TODO mayuko.sakaba signup.jspにて、なぜゲッターメソッドがなかったのにValue=""をいれたら直ったか調べること。
    // TODO mayuko.sakaba indexActionForm に対する定義が見つかりません →　これなに？
    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======

    @Execute(validator = false)
    public String index() {
        TokenProcessor.getInstance().saveToken(request);
        if (sessionDto.status.equals(1)) {
            status = new Boolean(true);
        } else if (sessionDto.status.equals(2)) {
            status = new Boolean(false);
        }
        account = sessionDto.accountName + "@" + sessionDto.username;
        MemberCB myCb = new MemberCB();
        myCb.setupSelect_MemberStatus();
        myCb.query().setMemberId_Equal(sessionDto.myId);
        Member me = memberBhv.selectEntity(myCb);
        seeStatus = sessionDto.status;
        groupName = me.getGroupName();
        if (seeStatus.equals(1)) {
            recruitStatus = new Boolean(true);
            interestedIndustry = me.getInterestedIndustry();
            graduationYear = me.getGraduationYear();
        } else if (seeStatus.equals(2)) {
            recruitStatus = new Boolean(false);
            recruitingNumber = me.getRecruitingNumber();
        }
        return "/profile.jsp";
    }

    @Execute(validate = "validate", input = "/profile/")
    /* プロフィール編集メソッド */
    public String editProfile() throws NoSuchAlgorithmException {
        //        if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
        //            throw new ActionMessagesException("不正なリクエストです", false);
        //        }
        password = profileForm.updatePassword;
        confirmPass = profileForm.confirmPass;
        accountName = profileForm.updateName;
        groupName = profileForm.updateGroup;
        interestedIndustry = profileForm.interestedIndustry;
        graduationYear = profileForm.graduationYear;
        recruitingNumber = profileForm.recruitingNumber;
        /* パスワード不可逆暗号化　*/
        digestedPass = passDigestLogic.build(password);
        /* validationに引っかからなかったら、プロフィール編集する */
        Member member = new Member();
        member.setMemberId(sessionDto.myId);
        member.setMemberStatusCode(sessionDto.status);
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
        }
        if (interestedIndustry != "") {
            member.setInterestedIndustry(interestedIndustry);
            memberBhv.update(member);
            LOG.debug("******************************************");
        }
        if (graduationYear != null) {
            member.setGraduationYear(graduationYear);
            memberBhv.update(member);
        }
        if (recruitingNumber != "") {
            member.setRecruitingNumber(recruitingNumber);
            memberBhv.update(member);
        }
        return "/profile/?redirect=true";
    }

    /* 会員登録画面　Validation */
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        password = profileForm.updatePassword;
        confirmPass = profileForm.confirmPass;
        accountName = profileForm.updateName;
        groupName = profileForm.updateGroup;
        interestedIndustry = profileForm.interestedIndustry;
        graduationYear = profileForm.graduationYear;
        recruitingNumber = profileForm.recruitingNumber;
        /* accountName */
        if (!StringUtil.isEmpty(accountName)) {
            if (StringUtil.isBlank(accountName)) {
                errors.add("updateName", new ActionMessage("空白は入力できません。", false));
            }
            if (accountName.length() > 20) {
                errors.add("updateName", new ActionMessage("このアカウント名は長すぎます。", false));
            }
        }
        /* interestedIndustry */
        if (sessionDto.status.equals(1)) {
            if (!StringUtil.isEmpty(interestedIndustry)) {
                if (StringUtil.isBlank(interestedIndustry)) {
                    errors.add("interestedIndustry", new ActionMessage("空白は入力できません。", false));
                }
                if (profileForm.interestedIndustry.length() > 50) {
                    errors.add("interestedIndustry", new ActionMessage("文字制限(50文字）以上入力されました。", false));
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
        if (!StringUtil.isEmpty(groupName)) {
            if (StringUtil.isBlank(groupName)) {
                errors.add("updateGroup", new ActionMessage("空白は入力できません。", false));
            }
            if (groupName.length() > 100) {
                errors.add("updateGroup", new ActionMessage("所属企業名、もしくは学校名が長すぎます", false));
            }
        }
        /*　password */
        if (!StringUtil.isEmpty(password)) {
            String pswdPtn = "[\\w]+";
            Pattern ptn3 = Pattern.compile(pswdPtn);
            Matcher pswdMatcher = ptn3.matcher(profileForm.updatePassword);
            if (!pswdMatcher.matches()) {
                errors.add("updatePassword", new ActionMessage("アルファベットか数字を入力してください。", false));
            }
            if (password.length() > 20 || profileForm.updatePassword.length() < 8) {
                errors.add("updatePassword", new ActionMessage("パスワードは8文字以上、20文字以下にしてください。", false));
            }
            if (!profileForm.updatePassword.equals(profileForm.confirmPass)) {
                errors.add("updatePassword", new ActionMessage("パスワードが一致しません。", false));
            }
        }
        return errors;
    }
}
