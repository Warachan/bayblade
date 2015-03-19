package org.dbflute.handson.logic;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.MemberFollowingCB;
import org.dbflute.handson.dbflute.cbean.MemberLoginCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.cbean.PurchasePaymentCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.MemberStatusBhv;
import org.dbflute.handson.dbflute.exbhv.ProductBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberStatus;
import org.dbflute.handson.dbflute.exentity.Product;
import org.dbflute.handson.dbflute.exentity.Purchase;
import org.dbflute.handson.dbflute.exentity.PurchasePayment;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.ReferrerListHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.SpecifyQuery;
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
    protected MemberStatusBhv memberStatusBhv;
    @Resource
    protected PurchaseBhv purchaseBhv;
    @Resource
    protected MemberServiceBhv memberServiceBhv;
    @Resource
    protected ProductBhv productBhv;

    // 【むー。。。 】wara セクション１１は、JavaDocコメントをしっかり整備していこう by jflute
    // 例えば、こんな感じ:
    // @param memberName 部分一致検索の会員名称キーワード (NullAllowed: なければ条件なし)
    // @return 購入付き会員リスト (NotNull)
    //
    // ポイントは、丁寧に、でも細かすぎず (書き過ぎるとプログラムの変更のときにJavaDoc修正が大変になっちゃう)
    // wara タグコメント、単元ごとに切っていきましょう by jflute
    // ===================================================================================
    //                                                                      Basic Practice
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
     * @return 最終ログイン日時付会員リスト9 (NotNull)
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

    // ===================================================================================
    //                                                            On parade just the start
    //                                                                            ========
    // done sakaba param に List<Member> ? completeOnlyだよね by jflute
    // done mayuko なければ条件なしの前が全角空白 by jflute
    // done annie return に (NotNull) を by jflute
    /**
     * <pre>
     * 会員ステータス、会員サービス、サービスランク、購入、購入支払、会員ステータス経由の会員ログインも取得
     * モバイルからのログイン回数も導出して取得する
     * 指定された判定次第で未払い購入の存在しない会員だけを対象にできるように
     * 購入は商品の定価の高い順、購入価格の高い順で並べる
     * 会員ごとのログイン回数と購入一覧と購入支払一覧をログに出力する
     * 購入支払は、最も推奨されている方法のみ検索
     *  </pre>
     *  @param completeOnly 支払い完了フラグ (NullAllowed:なければ条件なし)
     *  @return サービス・ステータス・購入付き会員リスト (NotNull)
     */
    public List<Member> selectOnParadeFirstStepMember(boolean completeOnly) {
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberServiceAsOne().withServiceRank();
        cb.specify().derivedMemberLoginList().count(new SubQuery<MemberLoginCB>() {
            @Override
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnMobileLoginFlg();
            }
        }, Member.ALIAS_mobileLoginCount);

        if (completeOnly) {
            cb.query().notExistsPurchaseList(new SubQuery<PurchaseCB>() {
                @Override
                public void query(PurchaseCB subCB) {
                    subCB.query().setPaymentCompleteFlg_Equal_False();
                }
            });
        }
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            @Override
            public void setup(PurchaseCB refCB) {
                refCB.query().queryProduct().addOrderBy_RegularPrice_Desc();
                refCB.query().addOrderBy_PurchasePrice_Desc();
            }
        }).withNestedReferrer(new ReferrerListHandler<Purchase>() {
            @Override
            public void handle(List<Purchase> referrerList) {
                purchaseBhv.loadPurchasePaymentList(referrerList, new ConditionBeanSetupper<PurchasePaymentCB>() {
                    @Override
                    public void setup(PurchasePaymentCB refCB) {
                        // こっち？検索？
                        refCB.query().setPaymentMethodCode_InScope_Recommended();
                    }
                });
            }
        });
        // それぞれのメンバーにひもずいている束としてリストを取得しているだけ。
        List<MemberStatus> statusList = memberBhv.pulloutMemberStatus(memberList);
        memberStatusBhv.loadMemberLoginList(statusList, new ConditionBeanSetupper<MemberLoginCB>() {
            public void setup(MemberLoginCB cb) {
            }
        });
        // TODO wara LOG.isDebugEnabled()で囲う (メインコードなので): ループごと囲った方がいい by jflute
        for (Member member : memberList) {
            List<Purchase> purchaseList = member.getPurchaseList();
            for (Purchase purchase : purchaseList) {
                List<PurchasePayment> paymentList = purchase.getPurchasePaymentList();
                // done wara こういう日常の内容はデバッグ by jflute
                // ユーザがボタンを押す度の処理とかは日常の処理
                if (LOG.isDebugEnabled()) {
                    LOG.debug("paymentList:" + paymentList);
                    LOG.debug("purchaseList:" + purchaseList);
                    LOG.debug("mobileLoginCount:" + member.getMobileLoginCount());
                }
            }
        }
        return memberList;
    }

    // ===================================================================================
    //                                                                  On parade Continue
    //                                                                            ========
    /**
     * <pre>
     * 会員ステータス、購入と商品と購入商品種類数(*1)を一緒に検索
     * 商品ステータスが "生産中止" の商品を買ったことのある会員...もしくは(続く)
     * (続き)手渡しだけでも払い過ぎてるのに未払いになっている購入を持ってる会員にフォローされている会員
     * 購入は商品ステータスの表示順の昇順、購入日時の降順で並べる
     * 会員ごとの購入一覧と商品名称、購入商品種類数をログに出力する
     * *1: 購入商品種類数は、例えば、A, B, C という商品を買ったことがあるなら 3 (種類)
     * </pre>
     * @return 購入と商品つき会員リスト (NotNull)
     */
    public List<Member> selectOnParadeSecondStepMember() {
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        // TODO wara まあ、名前でも取れそうだけど、PRODUCT_ID で。IDなら Product まで行かなくてOK by jflute 
        cb.specify().derivedPurchaseList().countDistinct(new SubQuery<PurchaseCB>() {
            @Override
            public void query(PurchaseCB subCB) {
                subCB.specify().specifyProduct().columnProductName();
                // TODO mayuko.sakaba これだとカラムを数えるだけ。。。
            }
        }, Member.ALIAS_productTypeCount);
        cb.orScopeQuery(new OrQuery<MemberCB>() {
            @Override
            public void query(MemberCB orCB) {
                orCB.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                    @Override
                    public void query(PurchaseCB subCB) {
                        subCB.query().queryProduct().setProductStatusCode_Equal_生産中止();
                    }
                });
                // done wara ...未払いになっている購入を持ってる会員をフォローしている会員になっちゃってる by jflute
                orCB.query().existsMemberFollowingByYourMemberIdList(new SubQuery<MemberFollowingCB>() {
                    @Override
                    public void query(MemberFollowingCB subCB) {
                        // 思い出
                        //                        subCB.specify().specifyMemberByYourMemberId().derivedPurchaseList()
                        //                                .sum(new SubQuery<PurchaseCB>() {
                        //                                    public void query(PurchaseCB subCB) {
                        //                                        subCB.specify().columnPurchasePrice();
                        //                                    }
                        //                                }, PurchasePayment.ALIAS_memberPurchasePriceSummary);
                        subCB.query().queryMemberByMyMemberId().existsPurchaseList(new SubQuery<PurchaseCB>() {
                            @Override
                            public void query(PurchaseCB subCB) {
                                // ひんと「購入価格 < 手渡しの支払い金額の合計」かつ未払い by jflute
                                // これは、カラム対カラムである、という分析を先にやるの！わら！ by jflute
                                // ConditionBeanの機能を探したいときはどうする？
                                // http://dbflute.seasar.org/ja/tutorial/developer.html#howtosearch
                                subCB.query().setPaymentCompleteFlg_Equal_False();
                                subCB.columnQuery(new SpecifyQuery<PurchaseCB>() {
                                    @Override
                                    public void specify(PurchaseCB spCB) {
                                        spCB.specify().columnPurchasePrice();
                                    }
                                }).lessThan(new SpecifyQuery<PurchaseCB>() {
                                    @Override
                                    public void specify(PurchaseCB spCB) {
                                        spCB.specify().derivedPurchasePaymentList()
                                                .sum(new SubQuery<PurchasePaymentCB>() {
                                                    @Override
                                                    public void query(PurchasePaymentCB subCB) {
                                                        subCB.specify().columnPaymentAmount();
                                                    }
                                                }, null);
                                    }
                                });
                            }
                        });
                    }
                });
            }
        });
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            @Override
            public void setup(PurchaseCB refCB) {
                refCB.setupSelect_Product();
                refCB.query().queryProduct().addOrderBy_ProductStatusCode_Asc();
                refCB.query().addOrderBy_PurchaseDatetime_Desc();
            }
        });
        // TODO wara るーぷごと and debug by jflute 
        for (Member member : memberList) {
            List<Purchase> purchaseList = member.getPurchaseList();
            for (final Purchase purchase : purchaseList) {
                Product product = purchase.getProduct();
                LOG.info("ProductName : " + product.getProductName() + "ProductCategoryCode : "
                        + product.getProductCategoryCode());
                LOG.info("PurchaseList : " + purchaseList);
                LOG.info("ProductTypeList  : " + member.getProductTypeCount());
            }
        }
        return memberList;
    }

    // ===================================================================================
    //                                                                     Very On Parade!
    //                                                                            ========
    // wara Good、オンパレード会員リストっていうぼかした感じいいぞ by jflute 
    /**
     * <pre>
     * 正式会員のときにログインした最終ログイン日時とログイン回数を導出して会員を検索
     * さらに、支払済み購入の最大購入価格を導出して取得
     * もっとさらに、購入と商品と商品ステータスと商品カテゴリと親商品カテゴリ(*1)も取得
     * もっともっとさらに、会員ログイン情報も取得
     * 最終ログイン日時の降順、会員IDの昇順で並べる
     * ログイン回数が指定された回数以上で絞り込み
     * 仮会員のときにログインをしたことのある会員を検索
     * 自分だけが購入している商品を買ったことのある会員を検索
     * 購入は商品カテゴリ(*1)の親カテゴリ名称の昇順、子カテゴリ名称の昇順、購入日時の降順
     * 会員ログイン情報はログイン日時の降順
     * *1: 商品カテゴリは、二階層になっていることが前提として
     * </pre>
     * @param leastLoginCount (NullAllowed: なければ条件なし)
     * @return オンパレード会員リスト (NotNull)
     */
    public List<Member> selectOnParadeXStepMember(int leastLoginCount) {
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        // TODO wara 日時なので、Dateじゃだめ by jflute 
        // 正式会員のときにログインした最終ログイン日時とログイン回数を導出して会員を検索
        cb.specify().derivedMemberLoginList().max(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
                subCB.query().setLoginMemberStatusCode_Equal_正式会員();
            }
        }, Member.ALIAS_lastLoginDate);
        cb.specify().derivedMemberLoginList().count(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnMemberLoginId();
                subCB.query().setLoginMemberStatusCode_Equal_正式会員();
            }
        }, Member.ALIAS_loginCount);

        //さらに、支払済み購入の最大購入価格を導出して取得
        cb.specify().derivedPurchaseList().max(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.specify().columnPurchasePrice();
                subCB.query().setPaymentCompleteFlg_Equal_True();
            }
        }, Member.ALIAS_maxPaidPurchasePrice);

        // TODO mayuko.sakaba まだーーー
        // 自分だけが購入している商品を買ったことのある会員を検索
        //        cb.query().

        // TODO wara ソートは最後 by jflute
        // 最終ログイン日時の降順、会員IDの昇順で並べる
        cb.query().addSpecifiedDerivedOrderBy_Desc(Member.ALIAS_latestLoginDatetime);
        cb.query().addOrderBy_MemberId_Asc();

        // ログイン回数が指定された回数以上で絞り込み
        if (leastLoginCount > 0) {
            cb.query().derivedMemberLoginList().count(new SubQuery<MemberLoginCB>() {
                public void query(MemberLoginCB subCB) {
                    subCB.specify().columnMemberLoginId();
                }
            }).greaterEqual(leastLoginCount);
        }

        // 仮会員のときにログインをしたことのある会員を検索
        cb.query().existsMemberLoginList(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.query().setLoginMemberStatusCode_Equal_仮会員();
            }
        });
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        // もっともっとさらに、会員ログイン情報も取得
        // 会員ログイン情報はログイン日時の降順
        memberBhv.loadMemberLoginList(memberList, new ConditionBeanSetupper<MemberLoginCB>() {
            public void setup(MemberLoginCB refCB) {
                refCB.query().addOrderBy_LoginDatetime_Desc();
            }
        });
        // TODO wara 親カテゴリ名称の昇順がない by jflute 
        // 購入は商品カテゴリ(*1)の親カテゴリ名称の昇順、子カテゴリ名称の昇順、購入日時の降順
        // *1: 商品カテゴリは、二階層になっていることが前提として
        // TODO mayuko.sakaba まだーーー
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB refCB) {
                refCB.setupSelect_Product().withProductCategory();
                refCB.setupSelect_Product().withProductStatus();
                refCB.query().queryProduct().queryProductCategory().addOrderBy_ProductCategoryName_Asc();
                refCB.query().addOrderBy_PurchaseDatetime_Desc();
            }
        });
        return memberList;
    }
}
