package org.dbflute.handson.exercise;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberAddressCB;
import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.exbhv.MemberAddressBhv;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberSecurityBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberAddress;
import org.dbflute.handson.dbflute.exentity.Purchase;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.cbean.ListResultBean;

/**
 * @author mayuko.sakaba
 */
public class HandsOn05Test extends UnitContainerTestCase {

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberAddressBhv memberAddressBhv;

    @Resource
    protected MemberSecurityBhv memberSecurityBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    /**
     * 【1】会員住所情報を検索
     * 会員名称、有効開始日、有効終了日、住所、地域名称をログに出して確認する
     * 会員IDの昇順、有効開始日の降順で並べる
     */
    public void test_01() throws Exception {
        // ## Arrange ##
        MemberAddressCB cb = new MemberAddressCB();
        cb.setupSelect_Member();
        cb.setupSelect_Region();
        cb.query().addOrderBy_MemberId_Asc();
        cb.query().addOrderBy_ValidBeginDate_Asc();

        // ## Act ##
        ListResultBean<MemberAddress> addressList = memberAddressBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(addressList);
        for (MemberAddress address : addressList) {
            log(address.getMember().getMemberName(), address.getAddress(), address.getRegion(),
                    address.getValidBeginDate(), address.getValidEndDate());
        }
    }

    /**
     * 【2】会員と共に現在の住所を取得して検索
     * SetupSelectのJavaDocにcommentがあることを確認すること
     * 会員名称と住所をログに出して確認すること
     * 現在日付はスーパークラスのメソッドを利用 ("c" 始まりのメソッド)
     * 会員住所情報が取得できていることをアサート
     */
    public void test_02() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberAddressAsValid(currentDate());

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            if (member.getMemberAddressAsValid() != null) {
                String address = member.getMemberAddressAsValid().getAddress();
                String name = member.getMemberName();
                log(name, address);
                assertNotNull(address);
            } else {
                assertNull(member.getMemberAddressAsValid());
            }
        }
    }

    /**
     * 【3】千葉に住んでいる会員の支払済み購入を検索
     * 会員ステータス名称と住所をログに出して確認すること
     * 購入に紐づいている会員の住所の地域が千葉であることをアサート
     */
    public void test_03() throws Exception {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Member().withMemberAddressAsValid(currentDate()).withRegion();
        cb.setupSelect_Member().withMemberStatus();
        cb.query().setPaymentCompleteFlg_Equal_True();
        cb.query().queryMember().queryMemberAddressAsValid(currentDate()).setRegionId_Equal_千葉();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (Purchase purchase : purchaseList) {
            String status = purchase.getMember().getMemberStatus().getMemberStatusName();
            String address = purchase.getMember().getMemberAddressAsValid().getAddress();
            String region = purchase.getMember().getMemberAddressAsValid().getRegion().getRegionName();
            log(status, address, region);
            assertTrue(region.matches("千葉"));
        }
    }

    /**
     * 【4】最終ログイン時の会員ステータスを取得して会員を検索
     * SetupSelectのJavaDocに自分で設定したcommentが表示されることを目視確認
     * 会員名称と最終ログイン日時と最終ログイン時の会員ステータス名称をログに出す
     * 最終ログイン日時が取得できてることをアサート
     */
    public void test_04() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberLoginAsLatest().withMemberStatus();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        for (Member member : memberList) {

        }
    }

    /**
     * 【5】正式会員日時を持ってる仮会員がいないこと
     * まだ生まれていない会員がいないこと
     * 退会会員が退会情報を持っていることをアサート
     */
    public void test_05() throws Exception {
        // ## Arrange ##

        // ## Act ##

        // ## Assert ##
    }
}
