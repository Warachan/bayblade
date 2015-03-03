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

    // TODO 【むー。。。 】wara セクション１１は、JavaDocコメントをしっかり整備していこう by jflute
    // 例えば、こんな感じ:
    // @param memberName 部分一致検索の会員名称キーワード (NullAllowed: なければ条件なし)
    // @return 購入付き会員リスト (NotNull)
    //
    // ポイントは、丁寧に、でも細かすぎず (書き過ぎるとプログラムの変更のときにJavaDoc修正が大変になっちゃう)
    // ===================================================================================
    //                                                                               Logic
    //                                                                             =======

    /**
     * <pre>
     * 指定された memberName を含んでいる会員名称の会員を検索する
     * その会員に紐づく支払済み購入のデータも取得する
     * </pre>
     * @param memberName 部分一致検索の会員名称キーワード (NullAllowed: なければ条件なし)
     * @return 購入付き会員リスト (NotNull)
     */
    // TODO 【失礼しました。。。publicです☆】wara 他から呼ばれる前提なのでpublicメソッドで by jflute
    public List<Member> selectPurchaseMemberList(String memberName) {
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_LikeSearch(memberName, new LikeSearchOption().likeContain());
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        return memberList;
    }

    /**
     * <pre>
     * 未払い購入のある会員を検索する
     * 指定された memberName で含んでいる会員名称の会員を検索する
     * </pre>
     * @param memberName 部分一致検索の会員名称キーワード (NullAllowed: なければ条件なし)
    // @return 未払い購入有り会員リスト (NotNull)
     */
    public List<Member> selectUnpaidMemberList(String memberName) {
        MemberCB cb = new MemberCB();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().setPaymentCompleteFlg_Equal_False();
            }
        });
        cb.query().setMemberName_LikeSearch(memberName, new LikeSearchOption().likeContain());
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        return memberList;
    }

    /**
     * <pre>
     * 会員と最終ログイン日時を(一緒に)検索する
     * 指定された memberName で含んでいる会員名称の会員を検索する
     * </pre>
     * @param memberName 部分一致検索の会員名称キーワード (NullAllowed: なければ条件なし)
     * @return 最終ログイン日時付会員リスト
     */
    public List<Member> selectLoginedMemberList(String memberName) {
        // TODO 【追加しましたー】wara 一応、ctrl+1で生成したとはいえ、Memberの方にauthorを by jflute
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
        return memberList;
    }
}
