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
import org.dbflute.handson.dbflute.exentity.Purchase;
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

    // 【むー。。。 】wara セクション１１は、JavaDocコメントをしっかり整備していこう by jflute
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
    // 【失礼しました。。。publicです☆】wara 他から呼ばれる前提なのでpublicメソッドで by jflute
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
        // 【追加しましたー】wara 一応、ctrl+1で生成したとはいえ、Memberの方にauthorを by jflute
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

    /**
     * <pre>
     * 会員ステータス、会員サービス、サービスランク、購入、購入支払、会員ステータス経由の会員ログインも取得
     * モバイルからのログイン回数も導出して取得する
     * 指定された判定次第で未払い購入の存在しない会員だけを対象にできるように
     * 購入は商品の定価の高い順、購入価格の高い順で並べる
     * 会員ごとのログイン回数と購入一覧と購入支払一覧をログに出力する
     * 購入支払は、最も推奨されている方法のみ検索
     *  </pre>
     *  @param List<Member> 支払い完了フラグ(NullAllowed:　なければ条件なし)
     *  @return サービス・ステータス・購入付き会員リスト
     */
    public List<Member> selectOnParadeFirstStepMember(boolean completeOnly) {
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberServiceAsOne().withServiceRank();
        cb.specify().derivedMemberLoginList().count(new SubQuery<MemberLoginCB>() {
            @Override
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnMemberLoginId();
                subCB.query().setMobileLoginFlg_Equal_True();
            }
        }, Purchase.ALIAS_mobileLoginCount);

        if (completeOnly) {
            cb.query().notExistsPurchaseList(new SubQuery<PurchaseCB>() {
                @Override
                public void query(PurchaseCB subCB) {
                    subCB.setupSelect_Product();
                    subCB.query().addOrderBy_PurchasePrice_Desc();
                    subCB.query().queryProduct().addOrderBy_RegularPrice_Desc();
                }
            });
        }
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            @Override
            public void setup(PurchaseCB refCB) {
                refCB.setupSelect_Product();
                refCB.query().addOrderBy_PurchasePrice_Desc();
                refCB.query().queryProduct().addOrderBy_RegularPrice_Desc();
            }
        });
        return memberList;
    }
}
