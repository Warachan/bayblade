package jp.bizreach.twitter.app.web;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class SessionDto implements Serializable {
    public static final long serialVersionUID = 1L;
    public Integer myId;
    public String email;
    public String username;
    public String accountName;
    public Integer status;
}
