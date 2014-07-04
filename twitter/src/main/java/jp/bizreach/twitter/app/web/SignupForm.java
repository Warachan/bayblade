package jp.bizreach.twitter.app.web;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;

import org.seasar.struts.annotation.Required;

public class SignupForm {

    @Resource
    MemberBhv memberBhv;
    @Required
    public String newEmail;
    @Required
    public String password;
    @Required
    public String confirmPass;
    @Required
    public String username;

    //    public ActionMessages validate() {
    //        ActionMessages errors = new ActionMessages();
    //        /* Email validate */
    //        String emailPtn = "[\\w\\.\\-]+@(?:[\\w\\-]+\\.)+[\\w\\-]+";
    //        Pattern ptn = Pattern.compile(emailPtn);
    //        Matcher emailMatcher = ptn.matcher(newEmail);
    //        if (!emailMatcher.matches()) {
    //            errors.add("newEmail", new ActionMessage("メールアドレスが不正です。", false));
    //        }
    //        if (newEmail.length() > 30) {
    //            errors.add("newEmail", new ActionMessage("メールアドレスが長すぎます。", false));
    //        }
    //        //        MemberCB cb = new MemberCB();
    //        //        cb.query().setEmailAddress_Equal(newEmail);
    //        //        int count = memberBhv.selectCount(cb);
    //        //        if (count > 0) {
    //        //            errors.add("newEmail", new ActionMessage("このメールアドレスはすでに登録されています。", false));
    //        //        }
    //
    //        /* username */
    //        if (username.length() <= 5) {
    //            errors.add("usename", new ActionMessage("ユーザ名は五文字以上で入力してください。", false));
    //        }
    //        //        MemberCB check = new MemberCB();
    //        //        check.query().setUserName_Equal(username);
    //        //        int nameCount = memberBhv.selectCount(check);
    //        //        if (nameCount > 0) {
    //        //            LOG.info("********************************************************************");
    //        //            errors.add("username", new ActionMessage("このユーザ名はすでに使われています。", false));
    //        //        }
    //        /*　password */
    //        String pswdPtn = "[\\w]+";
    //        Pattern ptn2 = Pattern.compile(pswdPtn);
    //        Matcher pswdMatcher = ptn2.matcher(password);
    //        if (!pswdMatcher.matches()) {
    //            errors.add("password", new ActionMessage("errors.invalid", false));
    //        }
    //        if (!password.equals(confirmPass)) {
    //            errors.add("password", new ActionMessage("パスワードが一致しません。", false));
    //        }
    //        if (password.length() >= 20 || password.length() <= 5) {
    //            errors.add("password", new ActionMessage("パスワードは5文字以上、20文字以内で入力してください。", false));
    //        }
    //
    //        return errors;
    //    }
}
