package org.dbflute.handson.dbflute.exentity;

import java.math.BigDecimal;

import org.dbflute.handson.dbflute.bsentity.BsServiceRank;

/**
 * The entity of service_rank.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 * @authoer sakaba
 */
public class ServiceRank extends BsServiceRank {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;
    /** MEMBER_COUNT_PER_RANK: Derived Referrer Alias. */
    public static final String ALIAS_memberCountPerRank = "MEMBER_COUNT_PER_RANK";
    /** MEMBER_COUNT_PER_RANK: (Derived Referrer) */
    protected Integer _memberCountPerRank;
    /** PURCHASE_PRICE_SUM: Derived Referrer Alias. */
    public static final String ALIAS_purchasePriceSum = "PURCHASE_PRICE_SUM";
    /** PURCHASE_PRICE_SUM: (Derived Referrer) */
    protected BigDecimal _purchasePriceSum;
    /** AVG_PURCHASE_MAX_PRICE: Derived Referrer Alias. */
    public static final String ALIAS_avgPurchaseMaxPrice = "AVG_PURCHASE_MAX_PRICE";
    /** AVG_PURCHASE_MAX_PRICE: (Derived Referrer) */
    protected BigDecimal _avgPurchaseMaxPrice;
    /** LOGIN_COUNT_PER_RANK: Derived Referrer Alias. */
    public static final String ALIAS_loginCountPerRank = "LOGIN_COUNT_PER_RANK";
    /** LOGIN_COUNT_PER_RANK: (Derived Referrer) */
    protected Integer _loginCountPerRank;

    /**
     * [get] MEMBER_COUNT_PER_RANK: (Derived Referrer)
     * @return The value of the column 'MEMBER_COUNT_PER_RANK'. (NullAllowed)
     */
    public Integer getMemberCountPerRank() {
        return _memberCountPerRank;
    }

    /**
     * [set] MEMBER_COUNT_PER_RANK: (Derived Referrer)
     * @param memberCountPerRank The value of the column 'MEMBER_COUNT_PER_RANK'. (NullAllowed)
     */
    public void setMemberCountPerRank(Integer memberCountPerRank) {
        _memberCountPerRank = memberCountPerRank;
    }

    /**
     * [get] PURCHASE_PRICE_SUM: (Derived Referrer)
     * @return The value of the column 'PURCHASE_PRICE_SUM'. (NullAllowed)
     */
    public BigDecimal getPurchasePriceSum() {
        return _purchasePriceSum;
    }

    /**
     * [set] PURCHASE_PRICE_SUM: (Derived Referrer)
     * @param purchasePriceSum The value of the column 'PURCHASE_PRICE_SUM'. (NullAllowed)
     */
    public void setPurchasePriceSum(BigDecimal purchasePriceSum) {
        _purchasePriceSum = purchasePriceSum;
    }

    /**
     * [get] AVG_PURCHASE_MAX_PRICE: (Derived Referrer)
     * @return The value of the column 'AVG_PURCHASE_MAX_PRICE'. (NullAllowed)
     */
    public BigDecimal getAvgPurchaseMaxPrice() {
        return _avgPurchaseMaxPrice;
    }

    /**
     * [set] AVG_PURCHASE_MAX_PRICE: (Derived Referrer)
     * @param avgPurchaseMaxPrice The value of the column 'AVG_PURCHASE_MAX_PRICE'. (NullAllowed)
     */
    public void setAvgPurchaseMaxPrice(BigDecimal avgPurchaseMaxPrice) {
        _avgPurchaseMaxPrice = avgPurchaseMaxPrice;
    }

    /**
     * [get] LOGIN_COUNT_PER_RANK: (Derived Referrer)
     * @return The value of the column 'LOGIN_COUNT_PER_RANK'. (NullAllowed)
     */
    public Integer getLoginCountPerRank() {
        return _loginCountPerRank;
    }

    /**
     * [set] LOGIN_COUNT_PER_RANK: (Derived Referrer)
     * @param loginCountPerRank The value of the column 'LOGIN_COUNT_PER_RANK'. (NullAllowed)
     */
    public void setLoginCountPerRank(Integer loginCountPerRank) {
        _loginCountPerRank = loginCountPerRank;
    }
}
