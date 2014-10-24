package org.dbflute.handson.logic;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.ProductCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.cbean.PurchasePaymentCB;
import org.dbflute.handson.dbflute.exbhv.MemberAddressBhv;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberLoginBhv;
import org.dbflute.handson.dbflute.exbhv.MemberSecurityBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.ProductBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exbhv.PurchasePaymentBhv;
import org.dbflute.handson.dbflute.exentity.Member;

/**
 * @author mayuko.sakaba
 */
public class HandsOn08Logic {
    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberSecurityBhv memberSecurityBhv;

    @Resource
    protected MemberServiceBhv memberServiceBhv;

    @Resource
    protected MemberAddressBhv memberAddressBhv;

    @Resource
    protected MemberLoginBhv memberLoginBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    @Resource
    protected PurchasePaymentBhv purchasePaymentBhv;

    @Resource
    protected ProductBhv productBhv;

    /**
     * void updateMemberChangedToFormalized(Integer memberId, Long versionNo)
     *  指定された会員を正式会員に更新する
     *  排他制御ありで更新する
     *  引数の値で null は許されない
     */
    public void updateMemberChangedToFormalized(Integer memberId, Long versionNo) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberStatusCode_正式会員();
        member.setVersionNo(0L);
        memberBhv.update(member);
    }

    /**
     * void updateMemberChangedToFormalizedNonstrict(Integer memberId)
     * 指定された会員を正式会員に更新する
     * 排他制御なしで更新する
     * 引数の値で null は許されない
     */
    public void updatedMembreChangedToFormailizedNonstrict(Integer memberId) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberStatusCode_正式会員();
        memberBhv.updateNonstrict(member);
    }

    /**
     * void deletePurchaseSimply(Integer memberId)
     * 指定された会員の購入を排他制御なしで削除する ※queryDelete(...)
     * 苦難があっても頑張って削除する
     * 引数の値は null も許される (null なら何もしない)
     */
    public void deletePurchaseSimply(Integer memberId) {
        PurchaseCB purchaseCB = new PurchaseCB();
        purchaseCB.query().setMemberId_Equal(memberId);
        purchaseBhv.queryDelete(purchaseCB);

        PurchasePaymentCB paymentCB = new PurchasePaymentCB();
        paymentCB.query().queryPurchase().setMemberId_Equal(memberId);
        purchasePaymentBhv.queryDelete(paymentCB);

        //　many to 1!
        ProductCB productCB = new ProductCB();

        // 勘違い実装
        //        MemberCB memberCB = new MemberCB();
        //        memberCB.query().setMemberId_Equal(memberId);
        //        memberBhv.queryDelete(memberCB);
        //
        //        MemberSecurityCB securityCB = new MemberSecurityCB();
        //        securityCB.query().setMemberId_Equal(memberId);
        //        memberSecurityBhv.queryDelete(securityCB);
        //
        //        MemberServiceCB serviceCB = new MemberServiceCB();
        //        serviceCB.query().setMemberId_Equal(memberId);
        //        memberServiceBhv.queryDelete(serviceCB);
        //
        //        MemberAddressCB addressCB = new MemberAddressCB();
        //        addressCB.query().setMemberId_Equal(memberId);
        //        memberAddressBhv.queryDelete(addressCB);
        //
        //        MemberLoginCB loginCB = new MemberLoginCB();
        //        loginCB.query().setMemberId_Equal(memberId);
        //        memberLoginBhv.queryDelete(loginCB);

    }
}
