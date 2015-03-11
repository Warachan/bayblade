package org.dbflute.handson.dbflute.exentity;

import java.math.BigDecimal;

import org.dbflute.handson.dbflute.bsentity.BsPurchasePayment;

/**
 * The entity of purchase_payment.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 * @author sakaba
 */
public class PurchasePayment extends BsPurchasePayment {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;
    /** MEMBER_PURCHASE_PRICE_SUMMARY: Derived Referrer Alias. */
    public static final String ALIAS_memberPurchasePriceSummary = "MEMBER_PURCHASE_PRICE_SUMMARY";
    /** MEMBER_PURCHASE_PRICE_SUMMARY: (Derived Referrer) */
    protected BigDecimal _memberPurchasePriceSummary;

    /**
     * [get] MEMBER_PURCHASE_PRICE_SUMMARY: (Derived Referrer)
     * @return The value of the column 'MEMBER_PURCHASE_PRICE_SUMMARY'. (NullAllowed)
     */
    public BigDecimal getMemberPurchasePriceSummary() {
        return _memberPurchasePriceSummary;
    }

    /**
     * [set] MEMBER_PURCHASE_PRICE_SUMMARY: (Derived Referrer)
     * @param memberPurchasePriceSummary The value of the column 'MEMBER_PURCHASE_PRICE_SUMMARY'. (NullAllowed)
     */
    public void setMemberPurchasePriceSummary(BigDecimal memberPurchasePriceSummary) {
        _memberPurchasePriceSummary = memberPurchasePriceSummary;
    }
}
