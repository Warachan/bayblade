package org.dbflute.handson.exercise;

import java.sql.Timestamp;

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
import org.dbflute.handson.dbflute.exentity.MemberLogin;
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
        // TODO 【修正してみました】wara こういうbooleanのときは、なぜか三単元の動詞を使うことが多い existsAddress by jflute
        boolean existsAddress = false;
        for (Member member : memberList) {
            // 【抽出してみましたー！】wara ctrl+1 -> enterで抽出 by jflute
            // 【消しましたー！】wara elseが意味が無い by jflute
            // 【アサートしてみましたー！】wara このif文に一回でも入ったことをアサートするとよい by jflute

            MemberAddress memberAddress = member.getMemberAddressAsValid();
            if (memberAddress != null) {
                String address = memberAddress.getAddress();
                String name = member.getMemberName();
                existsAddress = true;
                log(name, address);
                // 一応残しておきます。
                assertNotNull(address);
            }
        }
        assertTrue(existsAddress);
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
            // 【救出！】wara getMember()を助けてあげて (他も) by jflute
            Member purchaseMember = purchase.getMember();
            String status = purchaseMember.getMemberStatus().getMemberStatusName();

            MemberAddress memberAddress = purchaseMember.getMemberAddressAsValid();
            String address = memberAddress.getAddress();
            String region = memberAddress.getRegion().getRegionName();

            log(status, address, region);
            // 【isなのです。】wara まあ判定だけなら、MemberAddress自身がRegionIdを持っているので、isメソッド by jflute
            // e.g. purchase.getMember().getMemberAddressAsValid().isRegionId千葉()
            assertTrue(memberAddress.isRegionId千葉());
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
        // 【変えてみました】wara SQLが綺麗に並ぶようにしてみて by jflute
        // 補足: dfpropは、あくまで自動生成ツールとしてのDBFluteがみるものなので、
        // dfpropを修正してすぐにテストを動かしても反映されない (自動生成をしてあげないと)
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberLoginAsLatest().withMemberStatus();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        boolean existLatestLogin = false;
        for (Member member : memberList) {
            String name = member.getMemberName();
            MemberLogin latestLogin = member.getMemberLoginAsLatest();
            if (latestLogin != null) {
                Timestamp loginDatetime = latestLogin.getLoginDatetime();
                String status = latestLogin.getMemberStatus().getMemberStatusName();
                log("Comment: " + latestLogin, loginDatetime);
                log("Comment2: " + name, loginDatetime, status);
                existLatestLogin = true;
            } else {
                // あまり意味はないけど・・・elseの中がさびしい。。。
                assertNull(latestLogin);
            }
        }
        assertTrue(existLatestLogin);
    }

    // TODO 【ずれていました><　ちょっと修正してみました。】wara take-finally.sql, SQLはOKだけど、select句のインデントがちょっとだけズレてるー by jflute
    // TODO 【やってみました！】wara おまけチェックも考えてみてね by jflute
}
