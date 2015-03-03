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
}
