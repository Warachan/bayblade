package org.dbflute.handson.logic;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.MemberLoginCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;

/**
 * @author mayuko.sakaba
 */
public class HandsOn11Logic {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(HandsOn11Logic.class);
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected PurchaseBhv purchaseBhv;
    @Resource
    protected MemberServiceBhv memberServiceBhv;

    // ===================================================================================
    //                                                                               Logic
    //                                                                             =======

    /**
     * <pre>
     * 指定された memberName を含んでいる会員名称の会員を検索する
     * その会員に紐づく支払済み購入のデータも取得する
     * </pre>
     */
    List<Member> selectPurchaseMemberList(String memberName) {
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_LikeSearch(memberName, new LikeSearchOption().likeContain());

        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB refCB) {
                refCB.query().setPaymentCompleteFlg_Equal_True();
            }
        });
        return memberList;
    }

    /**
     * <pre>
     * 未払い購入のある会員を検索する
     * 指定された memberName で含んでいる会員名称の会員を検索する
     * </pre>
     */
    List<Member> selectUnpaidMemberList(String memberName) {
        MemberCB cb = new MemberCB();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().setPaymentCompleteFlg_Equal_False();
            }
        });
        cb.query().setMemberName_LikeSearch(memberName, new LikeSearchOption().likeContain());
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB refCB) {
                refCB.query().setPurchaseId_IsNotNull();
                refCB.query().setPaymentCompleteFlg_Equal_False();
            }
        });
        return memberList;
    }

    /**
     * <pre>
     * 会員と最終ログイン日時を(一緒に)検索する
     * 指定された memberName で含んでいる会員名称の会員を検索する
     * </pre>
     */
    List<Member> selectLoginedMemberList(String memberName) {
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberLoginAsLatest();
        cb.query().setMemberName_LikeSearch(memberName, new LikeSearchOption().likeContain());
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            @Override
            public void query(MemberLoginCB subCB) {
                subCB.query().setMemberLoginId_IsNotNull();
                subCB.specify().columnLoginDatetime();
            }
        }, Member.ALIAS_latestLoginDatetime);
        cb.query().queryMemberLoginAsLatest().setMemberLoginId_IsNotNull();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadMemberLoginList(memberList, new ConditionBeanSetupper<MemberLoginCB>() {
            @Override
            public void setup(MemberLoginCB refCB) {
                refCB.specify().columnLoginDatetime();
            }
        });
        return memberList;
    }
}
