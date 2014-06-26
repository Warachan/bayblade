package jp.bizreach.twitter.app.web;

import javax.annotation.Resource;

import org.seasar.struts.annotation.Execute;

public class LogoutAction {
    @Resource
    protected SessionDto sessionDto;

    // TODO mayuko.sakaba インターセプターもしくはフィルタをつくること。
    @Execute(validator = false)
    public String index() {
        sessionDto.id = null;
        sessionDto.email = null;
        return "/?redirect=true";
    }
}
