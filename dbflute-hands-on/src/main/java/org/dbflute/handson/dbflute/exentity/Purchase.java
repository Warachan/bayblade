package org.dbflute.handson.dbflute.exentity;

import org.dbflute.handson.dbflute.bsentity.BsPurchase;

/**
 * The entity of purchase.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 * @author sakaba
 */
public class Purchase extends BsPurchase {

    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    /** MOBILE_LOGIN_COUNT: Derived Referrer Alias. */
    public static final String ALIAS_mobileLoginCount = "MOBILE_LOGIN_COUNT";

    /** MOBILE_LOGIN_COUNT: (Derived Referrer) */
    protected Integer _mobileLoginCount;

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
}
