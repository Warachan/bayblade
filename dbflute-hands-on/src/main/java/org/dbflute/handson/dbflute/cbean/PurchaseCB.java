package org.dbflute.handson.dbflute.cbean;

import java.math.BigDecimal;

import org.dbflute.handson.dbflute.cbean.bs.BsPurchaseCB;

/**
 * The condition-bean of purchase.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 * @author sakaba
 */
public class PurchaseCB extends BsPurchaseCB {

    /** SUM_PAYMENT_AMOUNT: Derived Referrer Alias. */
    public static final String ALIAS_sumPaymentAmount = "SUM_PAYMENT_AMOUNT";
    /** SUM_PAYMENT_AMOUNT: (Derived Referrer) */
    protected BigDecimal _sumPaymentAmount;

    /**
     * [get] SUM_PAYMENT_AMOUNT: (Derived Referrer)
     * @return The value of the column 'SUM_PAYMENT_AMOUNT'. (NullAllowed)
     */
    public BigDecimal getSumPaymentAmount() {
        return _sumPaymentAmount;
    }

    /**
     * [set] SUM_PAYMENT_AMOUNT: (Derived Referrer)
     * @param sumPaymentAmount The value of the column 'SUM_PAYMENT_AMOUNT'. (NullAllowed)
     */
    public void setSumPaymentAmount(BigDecimal sumPaymentAmount) {
        _sumPaymentAmount = sumPaymentAmount;
    }
}
