/*
 * Copyright 2004-2014 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.exbhv.LoginBhv;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exentity.Login;
import jp.bizreach.twitter.dbflute.exentity.Member;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */

public class IndexAction {
    @ActionForm
    @Resource
    protected IndexForm indexForm;
    @Resource
    public SessionDto sessionDto;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected LoginBhv loginBhv;

    private static final Log LOG = LogFactory.getLog(IndexAction.class);

    public String error;
    public String overlapsError;
    public String regesterationError;

    // TODO mayuko.sakaba  ユーザ名でログインできるようにする。
    @Execute(validator = false)
    public String index() {
        return "index.jsp";
    }

    @Execute(validator = false)
    public String gotoLogin() {
        LOG.debug("***" + indexForm);
        String inputEmail = indexForm.loginEmail;
        String inputPassword = indexForm.loginPassword;
        if (inputEmail != "" && inputPassword != "") {
            MemberCB cb = new MemberCB();
            cb.query().queryMemberSecurityAsOne().setPassword_Equal(inputPassword);
            cb.query().setEmailAddress_Equal(inputEmail);
            Member member = memberBhv.selectEntity(cb);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            if (member != null) {
                sessionDto.id = member.getMemberId();
                sessionDto.email = inputEmail;
                Login login = new Login();
                login.setMemberId(member.getMemberId());
                login.setLoginDatetime(timestamp);
                loginBhv.insert(login);
                return "/home/?redirect=true";
            }
        }
        error = "正しいメールアドレスとパスワードを入力してください。";
        return "index.jsp";
    }

    @Execute(validator = false)
    public String gotoSignup() {
        return "/signup/?redirect=true";
    }
}
