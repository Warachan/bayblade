package org.dbflute.handson.logic;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbflute.handson.dbflute.bsbhv.loader.LoaderOfMember;
import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.MemberFollowingCB;
import org.dbflute.handson.dbflute.cbean.MemberLoginCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.cbean.PurchasePaymentCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberLogin;
import org.dbflute.handson.dbflute.exentity.Product;
import org.dbflute.handson.dbflute.exentity.Purchase;
import org.dbflute.handson.dbflute.exentity.PurchasePayment;
import org.dbflute.handson.dbflute.exentity.ServiceRank;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.bhv.ReferrerLoaderHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;

/**
 * @author mayuko.sakaba
 */
public class HandsOn11LogicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    // TODO wara 不要なので削除 by jflute
    private static final Log LOG = LogFactory.getLog(HandsOn11Logic.class);
    // TODO wara ここ空行 by jflute
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
    //                                                                         Logic Test
    //                                                                             =======
    /**
     * <pre>
     *  会員名称が "vi" を含んでいる会員を検索
     *  支払済み購入が取得できていることをアサート
     * @throws Exception
     */
    public void test_selectPurchaseMemberList_会員と購入が検索されていること() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        List<Member> purchaseMemberList = logic.selectPurchaseMemberList("vi");
        memberBhv.loadPurchaseList(purchaseMemberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB refCB) {
                refCB.query().setPaymentCompleteFlg_Equal_True();
            }
        });

        // ## Assert ##
        assertHasAnyElement(purchaseMemberList);
        for (Member member : purchaseMemberList) {
            List<Purchase> purchaseList = member.getPurchaseList();
            log(purchaseList.size() + ":" + member.getMemberId());
            if (!purchaseList.isEmpty()) {
                for (Purchase purchase : purchaseList) {
                    log(purchase.getPaymentCompleteFlg() + ": MemberID " + member.getMemberId());
                    assertTrue(purchase.isPaymentCompleteFlgTrue());
                }
            }
        }
    }

    /**
     * <pre>
     * 会員名称が "vi" を含んでいる会員を検索
     * 検索された会員が未払い購入を持っていることをアサート
     * </pre>
     */
    public void test_selectUnpaidMemberList_未払い購入がある会員が検索されていること() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        List<Member> unpaidMemberList = logic.selectUnpaidMemberList("vi");
        // 【えい！】wara アサートで必要なデータは、テストケース内で取得しよう by jflute
        memberBhv.loadPurchaseList(unpaidMemberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB refCB) {
                // 【えいえい！】wara 購入IDは絶対にNotNullだから、このIsNotNullは不要かな by jflute
                refCB.query().setPaymentCompleteFlg_Equal_False();
            }
        });

        // ## Assert ##
        assertHasAnyElement(unpaidMemberList);
        boolean hasIncompletePayment = false;
        for (Member member : unpaidMemberList) {
            List<Purchase> purchaseList = member.getPurchaseList();
            log("********" + purchaseList);
            for (Purchase purchase : purchaseList) {
                if (purchase.isPaymentCompleteFlgFalse()) {
                    log("**********" + purchase + ": PaymentComplete " + purchase.getPaymentCompleteFlg());
                    hasIncompletePayment = true;
                }
            }
        }
        assertTrue(hasIncompletePayment);
    }

    /**
     * <pre>
     * 会員名称が "vi" を含んでいる会員を検索
     * 会員の最終ログイン日時が本当に最終ログイン日時であることをアサート
     * </pre>
     */
    public void test_selectLoginedMemberList_会員と最終ログイン日時が検索されていること() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        List<Member> memberList = logic.selectLoginedMemberList("vi");
        memberBhv.loadMemberLoginList(memberList, new ConditionBeanSetupper<MemberLoginCB>() {
            @Override
            public void setup(MemberLoginCB refCB) {
                refCB.specify().columnLoginDatetime();
            }
        });

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            List<MemberLogin> loginList = member.getMemberLoginList();
            if (!loginList.isEmpty()) {
                MemberLogin lastLogin = loginList.get(loginList.size() - 1);
                Timestamp lastLoginTm4Compare = lastLogin.getLoginDatetime();
                Timestamp memberLastLoginTm = member.getLatestLoginDatetime();
                log("**********LIST_LAST_LOGIN_DATE" + lastLoginTm4Compare + ": MEMBER_LAST_LOGIN_DATE"
                        + memberLastLoginTm);
                assertTrue(lastLoginTm4Compare.equals(memberLastLoginTm));
            }
        }
    }

    // ===================================================================================
    //                                                       On parade just the start test
    //                                                                            ========

    /**
     * <pre>
     * 未払い購入の存在しない会員だけを検索
     * 未払い購入が存在しないことをアサート
     * 会員ステータス経由の会員ログインが取得できていることをアサート
     * 購入支払が最も推奨されている方法のみ検索されていることをアサート
     * その他、ロジックの中で出力したログを見て期待通りであることを確認
     * </pre>
     */
    public void test_selectOnParadeFirstStepMember_未払い購入の存在しない会員() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        List<Member> completPaymentMemberList = logic.selectOnParadeFirstStepMember(true);

        // ## Assert ##
        assertHasAnyElement(completPaymentMemberList);
        for (Member member : completPaymentMemberList) {
            List<MemberLogin> loginList = member.getMemberStatus().getMemberLoginList();
            assertNotNull(loginList);

            List<Purchase> purchaseList = member.getPurchaseList();
            for (Purchase purchase : purchaseList) {
                assertTrue(purchase.isPaymentCompleteFlgTrue());

                List<PurchasePayment> paymentList = purchase.getPurchasePaymentList();
                for (PurchasePayment payment : paymentList) {
                    assertTrue(payment.isPaymentMethodCode_Recommended());
                }
            }
        }
    }

    // ===================================================================================
    //                                                                  On parade Continue
    //                                                                            ========
    /**
     * <pre>
     * 商品も取得できることをアサート
     * 購入商品種類数が妥当であることをアサート
     * 生産中止の商品を買ったことのある会員が(一人でも)検索されていることをアサート
     * どんな手段でもいいので、手渡しだけでも...(略)ている会員が(一人でも)検索されていることを目視確認
     * </pre>
     */
    public void test_selectOnParadeSecondStepMember_購入のみならず商品も検索() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        List<Member> memberList = logic.selectOnParadeSecondStepMember();

        // ## Assert ##
        assertHasAnyElement(memberList);
        boolean purchasedCanceledProduct = false;
        for (Member member : memberList) {
            List<Purchase> purchaseList = member.getPurchaseList();
            Set<Integer> productTypeSet = new HashSet<Integer>();
            for (Purchase purchase : purchaseList) {
                Product product = purchase.getProduct();
                assertNotNull(product);
                productTypeSet.add(product.getProductId());
                if (product.isProductStatusCode生産中止()) {
                    purchasedCanceledProduct = true;
                }
            }
            log(productTypeSet.size());
            assertEquals(productTypeSet.size(), member.getProductTypeCount());
        }
        log(purchasedCanceledProduct);
        assertTrue(purchasedCanceledProduct);

        // 目視確認
        MemberCB cb = new MemberCB();
        cb.query().existsMemberFollowingByYourMemberIdList(new SubQuery<MemberFollowingCB>() {
            public void query(MemberFollowingCB followCB) {
                followCB.query().queryMemberByMyMemberId().existsPurchaseList(new SubQuery<PurchaseCB>() {
                    @Override
                    public void query(PurchaseCB subCB) {
                        subCB.query().setPaymentCompleteFlg_Equal_False();
                        subCB.columnQuery(new SpecifyQuery<PurchaseCB>() {
                            @Override
                            public void specify(PurchaseCB spCB) {
                                spCB.specify().columnPurchasePrice();
                            }
                        }).lessThan(new SpecifyQuery<PurchaseCB>() {
                            @Override
                            public void specify(PurchaseCB spCB) {
                                spCB.specify().derivedPurchasePaymentList().sum(new SubQuery<PurchasePaymentCB>() {
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
        ListResultBean<Member> confirmList = memberBhv.selectList(cb);
        assertHasAnyElement(confirmList);
        for (Member member : confirmList) {
            log(member.getMemberId() + member.getMemberName());
        }
    }

    // ===================================================================================
    //                                                                     Very On Parade!
    //                                                                            ========
    /**
     * ログイン回数が 2 回より多い会員を検索し、結果がその通りであることをアサート
     * 最終ログイン日時の降順と会員IDの昇順で並んでいることをアサート
     * 支払済み購入の最大購入価格が妥当であることをアサート
     * 仮会員のときにログインをしたことのある会員であることをアサート
     * 自分だけが購入している商品を買ったことのある会員であることをアサート
     * @throws Exception
     */
    public void test_selectOnParadeXStepMember_オンパレードであること() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        List<Member> memberList = logic.selectOnParadeXStepMember(2);

        // ## Assert ##
        memberBhv.load(memberList, new ReferrerLoaderHandler<LoaderOfMember>() {
            public void handle(LoaderOfMember loader) {
                loader.loadPurchaseList(new ConditionBeanSetupper<PurchaseCB>() {
                    public void setup(PurchaseCB refCB) {
                        refCB.query().setPaymentCompleteFlg_Equal_True();
                        refCB.query().addOrderBy_PurchasePrice_Desc();
                    }
                });
            }
        });
        assertHasAnyElement(memberList);
        Integer previousId = null;
        Timestamp previousLatestLoginTime = null;
        boolean existsPreMemberLogin = false;
        for (Member member : memberList) {
            // TODO wara getLoginCount()は正式会員のときのログイン回数なので正確ではない by jflute 
            assertTrue(member.getLoginCount() >= 2);
            List<Purchase> purchaseList = member.getPurchaseList();
            if (!purchaseList.isEmpty()) {
                assertEquals(purchaseList.get(0).getPurchasePrice(), member.getMaxPaidPurchasePrice());
            }
            List<MemberLogin> loginList = member.getMemberLoginList();
            for (MemberLogin login : loginList) {
                if (login.isLoginMemberStatusCode仮会員()) {
                    existsPreMemberLogin = true;
                }
            }
            Timestamp latestLoginTime = member.getLatestLoginDatetime();
            Integer memberId = member.getMemberId();
            if (previousId != null && previousLatestLoginTime != null) {
                assertTrue(memberId <= previousId);
                // TODO mayuko.sakaba ここ false
                log("########"
                        + (latestLoginTime.after(previousLatestLoginTime) + " Pre: " + latestLoginTime
                                .equals(previousLatestLoginTime)));
                assertTrue(latestLoginTime.before(previousLatestLoginTime)
                        || latestLoginTime.equals(previousLatestLoginTime));
                // TODO annie 空行削除 by jflute

            }
            previousId = memberId;
            previousLatestLoginTime = latestLoginTime;
        }
        assertTrue(existsPreMemberLogin);
    }

    // ===================================================================================
    //                                                                        Simple Logic
    //                                                                            ========
    /**
    * <pre>
    * 会員数が妥当であることをアサート
    * 検索した内容をログに綺麗に出して目視で確認すること
    * </pre>
    * @throws Exception
    */
    public void test_selectServiceRankSummary_集計されていること() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        List<ServiceRank> rankList = logic.selectServiceRankSummary();

        // ## Assert ##
        MemberCB cb = new MemberCB();
        int memberCount = memberBhv.selectCount(cb);

        assertHasAnyElement(rankList);
        int members = 0;
        for (ServiceRank rank : rankList) {
            String rankCd = rank.getServiceRankCode();
            Integer membersPerRank = rank.getMemberCountPerRank();
            log("RankCode:" + rankCd + " MemberNo:" + membersPerRank);
            members += membersPerRank;
        }
        log("Sum of members: " + members);
        assertEquals(members, memberCount);
    }

    /**
     * <pre>
     * 平均の最大価格に該当する会員が存在することをアサート
     * </pre>
     * @throws Exception
     */
    public void test_selectMaxAvgPurchasePrice_平均の最大の会員() throws Exception {
        // ## Arrange ##
        HandsOn11Logic logic = new HandsOn11Logic();
        inject(logic);

        // ## Act ##
        Integer maxAvgPrice = logic.selectMaxAvgPurchasePrice();

        // ## Assert ##
        PurchaseCB cb = new PurchaseCB();
        cb.query().setPurchasePrice_Equal(maxAvgPrice);
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);
        // TODO wara NotNullじゃなくてHasAnyElement by jflute 
        assertNotNull(purchaseList);
        for (Purchase purchase : purchaseList) {
            Integer purchasePrice = purchase.getPurchasePrice();
            log("MaxAvgPrice" + ": " + maxAvgPrice + " Actual: " + purchasePrice);
        }
    }
}
