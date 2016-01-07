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

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import jp.bizreach.twitter.app.web.PassDigestLogic.resultWebBean;

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
    protected PassDigestLogic passDigestLogic;
    //    @Resource
    //    protected MemberBhv memberBhv;
    //    @Resource
    //    protected LoginBhv loginBhv;

    public Boolean fightFLg;
    public String winUrl;

    //    @Resource
    //    protected HttpServletRequest request;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    public String index() {
        resultWebBean bean = passDigestLogic.battle();
        fightFLg = bean.fightFlg;
        winUrl = bean.winnerUrl;
        return "index.jsp";
    }

    @Execute(validator = false, urlPattern = "put")
    public String put() {
        passDigestLogic.put(indexForm.putStr);
        return "index.jsp";
    }

    //    @Execute(validate = "validate", input = "index.jsp")
    //    public String gotoLogin() {
    //        loginWhenMatch();
    //        return "/home/?redirect=true";
    //    }
    //
    //    @Execute(validator = false)
    //    public String gotoSignup() {
    //        return "/signup/?redirect=true";
    //    }

    //    // ===================================================================================
    //    //                                                                    Extracted Method
    //    //                                                                            ========
    //    /* ログインする */
    //    private void loginWhenMatch() {
    //        Login login = new Login();
    //        Date loginDate = new Date();
    //        Timestamp loginTime = new Timestamp(loginDate.getTime());
    //        login.setMemberId(sessionDto.myId);
    //        login.setInsDatetime(loginTime);
    //        login.setUpdDatetime(loginTime);
    //        login.setInsTrace(indexForm.loginKey);
    //        login.setUpdTrace(indexForm.loginKey);
    //        loginBhv.insert(login);
    //    }
    //
    //    // ===================================================================================
    //    //                                                                          Validation
    //    //                                                                            ========
    //    /* ログイン validation */
    //    public ActionMessages validate() throws NoSuchAlgorithmException {
    //        ActionMessages errors = new ActionMessages();
    //        String digestedPass = passDigestLogic.build(indexForm.loginPassword);
    //        if (indexForm.loginKey == "" || indexForm.loginPassword == "") {
    //            errors.add("loginKey", new ActionMessage("ユーザ名もしくはパスワードが未入力です。", false));
    //        } else {
    //            MemberCB cb = new MemberCB();
    //            cb.query().setUserName_Equal(indexForm.loginKey);
    //            cb.query().queryMemberSecurityAsOne().setPassword_Equal(digestedPass);
    //            Member member = memberBhv.selectEntity(cb);
    //            if (member != null) {
    //                sessionDto.myId = member.getMemberId();
    //                sessionDto.username = member.getUserName();
    //                sessionDto.accountName = member.getAccountName();
    //                sessionDto.status = member.getMemberStatusCode();
    //            } else {
    //                errors.add("loginKey", new ActionMessage("ユーザ名もしくはパスワードが間違っています。", false));
    //            }
    //        }
    //        return errors;
    //    }

}