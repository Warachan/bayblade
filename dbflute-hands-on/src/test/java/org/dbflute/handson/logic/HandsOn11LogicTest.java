package org.dbflute.handson.logic;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbflute.handson.dbflute.cbean.MemberLoginCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberLogin;
import org.dbflute.handson.dbflute.exentity.Purchase;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;

/**
 * @author mayuko.sakaba
 */
public class HandsOn11LogicTest extends UnitContainerTestCase {

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
}
