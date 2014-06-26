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

public class SignupAction {

    @ActionForm
    @Resource
    protected SignupForm signupForm;
    public String newEmail;
    public String username;
    public String newPassword;
    public String confirmPass;
    public String matchError;
    public String overlapsError;
    public String characterError;
    public String userError;
    public String missingError;

    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected SessionDto sessionDto;
    @Resource
    protected MemberSecurityBhv memberSecurityBhv;

    private static final Log LOG = LogFactory.getLog(SignupAction.class);

    // TODO mayuko.sakaba signup.jspにて、なぜゲッターメソッドがなかったのにValue=""をいれたら直ったか調べること。
    // TODO mayuko.sakaba indexActionForm に対する定義が見つかりません →　これなに？

    @Execute(validator = false)
    public String index() {
        return "/signup/signup.jsp";
    }

    @Execute(validator = false)
    public String regester() {
        LOG.debug("***" + signupForm);
        newEmail = signupForm.newEmail;
        newPassword = signupForm.newPassword;
        confirmPass = signupForm.confirmPass;
        username = signupForm.username;
        String emailPtn = "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
        Pattern ptn = Pattern.compile(emailPtn);
        Matcher mc = ptn.matcher(newEmail);

        String pswdPtn = "[\\w]+";
        Pattern ptn2 = Pattern.compile(pswdPtn);
        Matcher pswd = ptn2.matcher(newPassword);
        if (newEmail == "" || newPassword == "" || username == "") {
            missingError = "*全ての欄は必須項目です。";
            return "/signup/signup.jsp";
        } else {
            if (mc.matches() && pswd.matches()) {
                MemberCB cb = new MemberCB();
                cb.query().setEmailAddress_Equal(newEmail);
                Member memberbhv = memberBhv.selectEntity(cb);
                if (memberbhv == null) {
                    Date date = new Date();
                    Timestamp timestamp = new Timestamp(date.getTime());
                    sessionDto.email = newEmail;
                    Member member = new Member();
                    member.setEmailAddress(sessionDto.email);
                    member.setRegesterDatetime(timestamp);

                    MemberCB check = new MemberCB();
                    check.query().setUserName_Equal(username);
                    Member usernameCheck = memberBhv.selectEntity(check);
                    if (usernameCheck == null) {
                        member.setUserName(username);
                    } else {
                        userError = "そのユーザ名はすでに使われています。";
                        return "/signup/signup.jsp";
                    }
                    memberBhv.insert(member);
                    sessionDto.id = member.getMemberId();
                    LOG.debug("***" + sessionDto.id);

                    MemberSecurity memberSecurity = new MemberSecurity();
                    if (newPassword.equals(confirmPass)) {
                        memberSecurity.setMemberId(member.getMemberId());
                        memberSecurity.setPassword(newPassword);
                        memberSecurity.setPasswordRegesterationDatetime(timestamp);
                        memberSecurityBhv.insert(memberSecurity);
                        return "/home/twitter.jsp";
                    } else {
                        matchError = "パスワードが一致しません。";
                        return "/signup/signup.jsp";
                    }
                } else {
                    overlapsError = "このメールアドレスはすでに登録されています。";
                    return "/signup/signup.jsp";
                }
            } else {
                characterError = "指定以外の文字が含まれています。";
                return "/signup/signup.jsp";
            }
        }
    }
}