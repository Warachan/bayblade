package jp.bizreach.twitter.app.web;

import org.seasar.struts.annotation.Required;

/**
 * @author mayuko.sakaba
 */

public class IndexForm {
    @Required
    public String loginEmail;

    @Required
    public String loginPassword;

    //    @Override
    //    public String toString() {
    //        return "{" + loginEmail + "," + loginPassword + "}";
    //    }
}