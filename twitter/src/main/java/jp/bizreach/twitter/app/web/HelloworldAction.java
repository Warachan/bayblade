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
//package jp.bizreach.twitter.app.web;
//
//import javax.annotation.Resource;
//
//import jp.bizreach.twitter.dbflute.cbean.BlackCompanyCB;
//import jp.bizreach.twitter.dbflute.exbhv.BlackCompanyBhv;
//import jp.bizreach.twitter.dbflute.exentity.BlackCompany;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.seasar.struts.annotation.ActionForm;
//import org.seasar.struts.annotation.Execute;
//
///**
// * @mayuko.sakaba
// */
//public class HelloworldAction {
//
//    private static final Log LOG = LogFactory.getLog(HelloworldAction.class);

//    // お決まり。DIするけどただのDIじゃない！「お前はアクションフォームだ！」という
//    @ActionForm
//    @Resource
//    protected HelloworldForm helloWorldForm;

//    public String abc;

//    @Resource
//    protected BlackCompanyBhv blackCompanyBhv;
//
//    @Execute(validator = true, input = "../insert.jsp")
//    public String helloworld() {
//        LOG.debug("***:" + helloWorldForm);
//        if (helloWorldForm.name != null) {
//            BlackCompanyCB cb = new BlackCompanyCB();
//            cb.query().setBlackCompanyId_IsNotNull();
//            BlackCompany blackCompany = blackCompanyBhv.selectEntity(cb);
//            abc = blackCompany != null ? blackCompany.getBlackCompanyName() : "てきとー";
//        }
//        return "../helloWorld.jsp";
// return "/mypage/?redirect=true"; // リダイレクトのやり方ridirect=true;を最後に書く。　getparameterがあるなら、  ?getparameter&redirect=true;\
//    }
//}
