package jp.bizreach.twitter.app.web;

import javax.annotation.Resource;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */
public class LogoutAction {
    @Resource
    protected SessionDto sessionDto;

    @Execute(validator = false)
    @RemoveSession(name = "sessionDto")
    public String index() {
        sessionDto.myId = null;
        sessionDto.username = null;
        sessionDto.accountName = null;
        return "/?redirect=true";
    }
}
