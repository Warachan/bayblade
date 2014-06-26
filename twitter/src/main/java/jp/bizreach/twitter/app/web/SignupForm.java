package jp.bizreach.twitter.app.web;

import org.seasar.struts.annotation.Required;

public class SignupForm {

    @Required
    public String newEmail;

    @Required
    public String newPassword;

    @Required
    public String username;

    @Required
    public String confirmPass;
}
