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
}
