package jp.bizreach.twitter.app.web;

import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */
public class ReturnHomeAction {
    @Execute(validator = false)
    public String index() {
        return "/home/?redirect=true";
    }
}
