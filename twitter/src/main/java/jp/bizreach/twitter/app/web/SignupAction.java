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
    public String newPassword;
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

    @Execute(validator = false)
    /* 会員登録メソッド */
    public String regester() {
        LOG.debug("***" + signupForm);
        newEmail = signupForm.newEmail;
        newPassword = signupForm.newPassword;
        confirmPass = signupForm.confirmPass;
        username = signupForm.username;
        Matcher emailMatcher = emailMatch();
        Matcher pswdMatcher = pswdMatch();

        if (newEmail == "" || newPassword == "" || username == "") {
            missingError = "*全ての欄は必須項目です。";
            return "/signup.jsp";
        }
        int nameCount = selectNameCount();
        if (nameCount > 0) {
            userError = "そのユーザ名はすでに使われています。";
            return "/signup.jsp";
        }
        if (emailMatcher.matches() && pswdMatcher.matches()) {
            int count = selectEmailCount();
            if (count > 0) {
                overlapsError = "このメールアドレスはすでに登録されています。";
                return "/signup.jsp";
            }
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            sessionDto.email = newEmail;
            Member member = insertMember(timestamp);
            sessionDto.myId = member.getMemberId();
            LOG.debug("***" + sessionDto.myId);

            if (newPassword.equals(confirmPass)) {
                insertSecurity(timestamp, member);
                //                return /twitter/home.jsp";
                return "/home/?redirect=true";
            } else {
                matchError = "パスワードが一致しません。";
                return "/signup.jsp";
            }
        } else {
            overlapsError = "このメールアドレスはすでに登録されています。";
            return "/signup.jsp";
        }
    }

    private Matcher pswdMatch() {
        String pswdPtn = "[\\w]+";
        Pattern ptn2 = Pattern.compile(pswdPtn);
        Matcher pswdMatcher = ptn2.matcher(newPassword);
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
        security.setPassword(newPassword);
        security.setInsDatetime(timestamp);
        security.setUpdDatetime(timestamp);
        security.setInsTrace("signedup");
        security.setUpdTrace("signedup");
        memberSecurityBhv.insert(security);
    }

}
