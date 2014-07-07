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

import java.security.NoSuchAlgorithmException;
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
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.RequestUtil;

/**
 * @author mayuko.sakaba
 *  ログイン画面、会員登録したければサインアップ画面に行く。
 */

public class IndexAction {
    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========

    private static final Log LOG = LogFactory.getLog(IndexAction.class);
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected IndexForm indexForm;
    @Resource
    public SessionDto sessionDto;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected LoginBhv loginBhv;
    @Resource
    protected PassDigestLogic passDigestLogic;
    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------

    public String error;
    public String overlapsError;
    public String regesterationError;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    // TODO mayuko.sakaba  ユーザ名でログインできるようにする。
    @Execute(validator = false)
    public String index() {
        // セッション破棄
        RequestUtil.getRequest().getSession().invalidate();
        return "index.jsp";
    }

    @Execute(validate = "validate", input = "index.jsp")
    public String gotoLogin() {
        LOG.debug("***" + indexForm);
        String inputEmail = indexForm.loginKey;
        Login login = new Login();
        Date loginDate = new Date();
        Timestamp loginTime = new Timestamp(loginDate.getTime());
        login.setMemberId(sessionDto.myId);
        login.setInsDatetime(loginTime);
        login.setUpdDatetime(loginTime);
        login.setInsTrace(inputEmail);
        login.setUpdTrace(inputEmail);
        loginBhv.insert(login);
        LOG.debug("***" + sessionDto.username);
        return "/home/?redirect=true";
    }

    /* ログイン validation */
    public ActionMessages validate() throws NoSuchAlgorithmException {
        ActionMessages errors = new ActionMessages();
        String digestedPass = passDigestLogic.build(indexForm.loginPassword);
        if (indexForm.loginKey == "" || indexForm.loginPassword == "") {
            errors.add("loginKey", new ActionMessage("ログインIDもしくはパスワードが未入力です。", false));
        } else {
            MemberCB cb = new MemberCB();
            cb.orScopeQuery(new OrQuery<MemberCB>() {
                @Override
                public void query(MemberCB orCB) {
                    orCB.query().setEmailAddress_Equal(indexForm.loginKey);
                    orCB.query().setUserName_Equal(indexForm.loginKey);
                }
            });
            cb.query().queryMemberSecurityAsOne().setPassword_Equal(digestedPass);
            Member member = memberBhv.selectEntity(cb);
            if (member != null) {
                sessionDto.myId = member.getMemberId();
                sessionDto.email = member.getEmailAddress();
                sessionDto.username = member.getUserName();
                sessionDto.accountName = member.getAccountName();
            } else {
                errors.add("loginKey", new ActionMessage("ログインIDもしくはパスワードが間違っています。", false));
            }
        }
        return errors;
    }

    @Execute(validator = false)
    public String gotoSignup() {
        return "/signup/?redirect=true";
    }
}