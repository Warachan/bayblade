package org.dbflute.handson.dbflute.bsbhv.cursor;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.seasar.dbflute.jdbc.ValueType;
import org.seasar.dbflute.s2dao.valuetype.TnValueTypes;

/**
 * The cursor of PurchaseMonthCursor. <br />
 * @author DBFlute(AutoGenerator)
 */
public class BsPurchaseMonthCursorCursor {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    // -----------------------------------------------------
    //                                        Column DB Name
    //                                        --------------
    /** DB name of MEMBER_ID. */
    public static final String DB_NAME_MEMBER_ID = "MEMBER_ID";

    /** DB name of MEMBER_NAME. */
    public static final String DB_NAME_MEMBER_NAME = "MEMBER_NAME";

    /** DB name of PURCHASE_MONTH. */
    public static final String DB_NAME_PURCHASE_MONTH = "PURCHASE_MONTH";

    /** DB name of PURCHASE_PRICE_AVERAGE_MONTH. */
    public static final String DB_NAME_PURCHASE_PRICE_AVERAGE_MONTH = "PURCHASE_PRICE_AVERAGE_MONTH";

    /** DB name of PURCHASE_COUNT_SUM_MONTH. */
    public static final String DB_NAME_PURCHASE_COUNT_SUM_MONTH = "PURCHASE_COUNT_SUM_MONTH";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** Wrapped result set. */
    protected ResultSet _rs;

    protected ValueType _vtMemberId = vt(Integer.class);
    protected ValueType _vtMemberName = vt(String.class);
    protected ValueType _vtPurchaseMonth = vt(Long.class);
    protected ValueType _vtPurchasePriceAverageMonth = vt(java.math.BigDecimal.class);
    protected ValueType _vtPurchaseCountSumMonth = vt(java.math.BigDecimal.class);

    protected ValueType vt(Class<?> type) {
        return TnValueTypes.getValueType(type);
    }

    protected ValueType vt(Class<?> type, String name) {
        ValueType valueType = TnValueTypes.getPluginValueType(name);
        return valueType != null ? valueType : vt(type);
    }

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsPurchaseMonthCursorCursor() {
    }

    // ===================================================================================
    //                                                                             Prepare
    //                                                                             =======
    /**
     * Accept the result set.
     * @param rs The cursor (result set) for the query, which has first pointer. (NotNull)
     */
    public void accept(ResultSet rs) {
        this._rs = rs;
    }

    // ===================================================================================
    //                                                                              Direct
    //                                                                              ======
    /**
     * Get the wrapped cursor (result set).
     * @return The instance of result set. (NotNull)
     */
    public ResultSet cursor() {
        return _rs;
    }

    // ===================================================================================
    //                                                                            Delegate
    //                                                                            ========
    /**
     * Move to next result.
     * @return Is exist next result.
     * @throws SQLException
     */
    public boolean next() throws SQLException {
        return _rs.next();
    }

    // ===================================================================================
    //                                                                  Type Safe Accessor
    //                                                                  ==================
    /**
     * [get] (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID} <br />
     * 会員を識別するID。連番として基本的に自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMSによって変わる。
     * @return The value of memberId. (NullAllowed)
     * @throws java.sql.SQLException
     */
    public Integer getMemberId() throws SQLException {
        return (Integer)_vtMemberId.getValue(_rs, DB_NAME_MEMBER_ID);
    }

    /**
     * [get] (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME} <br />
     * 会員のフルネームの名称。
     * @return The value of memberName. (NullAllowed)
     * @throws java.sql.SQLException
     */
    public String getMemberName() throws SQLException {
        return (String)_vtMemberName.getValue(_rs, DB_NAME_MEMBER_NAME);
    }

    /**
     * [get] PURCHASE_MONTH: {BIGINT(2)} <br />
     * @return The value of purchaseMonth. (NullAllowed)
     * @throws java.sql.SQLException
     */
    public Long getPurchaseMonth() throws SQLException {
        return (Long)_vtPurchaseMonth.getValue(_rs, DB_NAME_PURCHASE_MONTH);
    }

    /**
     * [get] PURCHASE_PRICE_AVERAGE_MONTH: {DECIMAL(14, 4)} <br />
     * @return The value of purchasePriceAverageMonth. (NullAllowed)
     * @throws java.sql.SQLException
     */
    public java.math.BigDecimal getPurchasePriceAverageMonth() throws SQLException {
        return (java.math.BigDecimal)_vtPurchasePriceAverageMonth.getValue(_rs, DB_NAME_PURCHASE_PRICE_AVERAGE_MONTH);
    }

    /**
     * [get] PURCHASE_COUNT_SUM_MONTH: {DECIMAL(32)} <br />
     * @return The value of purchaseCountSumMonth. (NullAllowed)
     * @throws java.sql.SQLException
     */
    public java.math.BigDecimal getPurchaseCountSumMonth() throws SQLException {
        return (java.math.BigDecimal)_vtPurchaseCountSumMonth.getValue(_rs, DB_NAME_PURCHASE_COUNT_SUM_MONTH);
    }

}
