package jp.bizreach.twitter.app.web;

import javax.annotation.Resource;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.Execute;

public class LogoutAction {
    @Resource
    protected SessionDto sessionDto;

    // TODO mayuko.sakaba インターセプターもしくはフィルタをつくること。
    @Execute(validator = false)
    @RemoveSession(name = "sessionDto")
    public String index() {
        sessionDto.myId = null;
        sessionDto.email = null;
        return "/?redirect=true";
    }
}
