package org.dbflute.handson.dbflute.exentity;

import java.sql.Timestamp;

import org.dbflute.handson.dbflute.bsentity.BsMember;

/**
 * The entity of member.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 * @author mayuko.sakaba
 */
public class Member extends BsMember {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** LATEST_LOGIN_DATETIME: Derived Referrer Alias. */
    public static final String ALIAS_latestLoginDatetime = "LATEST_LOGIN_DATETIME";

    /** LATEST_LOGIN_DATETIME: (Derived Referrer) */
    protected Timestamp _latestLoginDatetime;

    /** MOBILE_LOGIN_COUNT: Derived Referrer Alias. */
    public static final String ALIAS_mobileLoginCount = "MOBILE_LOGIN_COUNT";

    /** MOBILE_LOGIN_COUNT: (Derived Referrer) */
    protected Integer _mobileLoginCount;

    /** PRODUCT_TYPE_COUNT: Derived Referrer Alias. */
    public static final String ALIAS_productTypeCount = "PRODUCT_TYPE_COUNT";

    /** PRODUCT_TYPE_COUNT: (Derived Referrer) */
    protected Integer _productTypeCount;

    /** LOGIN_COUNT: Derived Referrer Alias. */
    public static final String ALIAS_loginCount = "LOGIN_COUNT";

    /** LOGIN_COUNT: (Derived Referrer) */
    protected Integer _loginCount;

    /** MAX_PAID_PURCHASE_PRICE: Derived Referrer Alias. */
    public static final String ALIAS_maxPaidPurchasePrice = "MAX_PAID_PURCHASE_PRICE";

    /** MAX_PAID_PURCHASE_PRICE: (Derived Referrer) */
    protected Integer _maxPaidPurchasePrice;

    /** LAST_LOGIN_COUNT: Derived Referrer Alias. */
    public static final String ALIAS_lastLoginCount = "LAST_LOGIN_COUNT";

    /** LAST_LOGIN_COUNT: (Derived Referrer) */
    protected Integer _lastLoginCount;

    /** AVG_PURCHASE_PRICE: Derived Referrer Alias. */
    public static final String ALIAS_avgPurchasePrice = "AVG_PURCHASE_PRICE";

    /** AVG_PURCHASE_PRICE: (Derived Referrer) */
    protected Integer _avgPurchasePrice;

    /**
     * [get] LATEST_LOGIN_DATETIME: (Derived Referrer)
     * @return The value of the column 'LATEST_LOGIN_DATETIME'. (NullAllowed)
     */
    public Timestamp getLatestLoginDatetime() {
        return _latestLoginDatetime;
    }

    /**
     * [set] LATEST_LOGIN_DATETIME: (Derived Referrer)
     * @param latestLoginDatetime The value of the column 'LATEST_LOGIN_DATETIME'. (NullAllowed)
     */
    public void setLatestLoginDatetime(Timestamp latestLoginDatetime) {
        _latestLoginDatetime = latestLoginDatetime;
    }

    /**
     * [get] MOBILE_LOGIN_COUNT: (Derived Referrer)
     * @return The value of the column 'MOBILE_LOGIN_COUNT'. (NullAllowed)
     */
    public Integer getMobileLoginCount() {
        return _mobileLoginCount;
    }

    /**
     * [set] MOBILE_LOGIN_COUNT: (Derived Referrer)
     * @param mobileLoginCount The value of the column 'MOBILE_LOGIN_COUNT'. (NullAllowed)
     */
    public void setMobileLoginCount(Integer mobileLoginCount) {
        _mobileLoginCount = mobileLoginCount;
    }

    /**
     * [get] PRODUCT_TYPE_COUNT: (Derived Referrer)
     * @return The value of the column 'PRODUCT_TYPE_COUNT'. (NullAllowed)
     */
    public Integer getProductTypeCount() {
        return _productTypeCount;
    }

    /**
     * [set] PRODUCT_TYPE_COUNT: (Derived Referrer)
     * @param productTypeCount The value of the column 'PRODUCT_TYPE_COUNT'. (NullAllowed)
     */
    public void setProductTypeCount(Integer productTypeCount) {
        _productTypeCount = productTypeCount;
    }

    /**
     * [get] LOGIN_COUNT: (Derived Referrer)
     * @return The value of the column 'LOGIN_COUNT'. (NullAllowed)
     */
    public Integer getLoginCount() {
        return _loginCount;
    }

    /**
     * [set] LOGIN_COUNT: (Derived Referrer)
     * @param loginCount The value of the column 'LOGIN_COUNT'. (NullAllowed)
     */
    public void setLoginCount(Integer loginCount) {
        _loginCount = loginCount;
    }

    /**
     * [get] MAX_PAID_PURCHASE_PRICE: (Derived Referrer)
     * @return The value of the column 'MAX_PAID_PURCHASE_PRICE'. (NullAllowed)
     */
    public Integer getMaxPaidPurchasePrice() {
        return _maxPaidPurchasePrice;
    }

    /**
    * [set] MAX_PAID_PURCHASE_PRICE: (Derived Referrer)
    * @param maxPaidPurchasePrice The value of the column 'MAX_PAID_PURCHASE_PRICE'. (NullAllowed)
    */
    public void setMaxPaidPurchasePrice(Integer maxPaidPurchasePrice) {
        _maxPaidPurchasePrice = maxPaidPurchasePrice;
    }

    /**
     * [get] AVG_PURCHASE_PRICE: (Derived Referrer)
     * @return The value of the column 'AVG_PURCHASE_PRICE'. (NullAllowed)
     */
    public Integer getAvgPurchasePrice() {
        return _avgPurchasePrice;
    }

    /**
     * [set] AVG_PURCHASE_PRICE: (Derived Referrer)
     * @param avgPurchasePrice The value of the column 'AVG_PURCHASE_PRICE'. (NullAllowed)
     */
    public void setAvgPurchasePrice(Integer avgPurchasePrice) {
        _avgPurchasePrice = avgPurchasePrice;
    }
}
