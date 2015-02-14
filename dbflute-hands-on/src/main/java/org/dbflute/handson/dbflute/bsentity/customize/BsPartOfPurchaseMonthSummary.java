package org.dbflute.handson.dbflute.bsentity.customize;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import org.seasar.dbflute.dbmeta.accessory.CustomizeEntity;
import org.dbflute.handson.dbflute.exentity.customize.*;

/**
 * The entity of PartOfPurchaseMonthSummary. <br />
 * <pre>
 * [primary-key]
 *     
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, PURCHASE_MONTH, PURCHASE_PRICE_AVERAGE_MONTH, PURCHASE_COUNT_SUM_MONTH
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     
 * 
 * [referrer table]
 *     
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer memberId = entity.getMemberId();
 * String memberName = entity.getMemberName();
 * Integer purchaseMonth = entity.getPurchaseMonth();
 * java.math.BigDecimal purchasePriceAverageMonth = entity.getPurchasePriceAverageMonth();
 * java.math.BigDecimal purchaseCountSumMonth = entity.getPurchaseCountSumMonth();
 * entity.setMemberId(memberId);
 * entity.setMemberName(memberName);
 * entity.setPurchaseMonth(purchaseMonth);
 * entity.setPurchasePriceAverageMonth(purchasePriceAverageMonth);
 * entity.setPurchaseCountSumMonth(purchaseCountSumMonth);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsPartOfPurchaseMonthSummary extends AbstractEntity implements CustomizeEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID} */
    protected Integer _memberId;

    /** (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME} */
    protected String _memberName;

    /** PURCHASE_MONTH: {INT(2)} */
    protected Integer _purchaseMonth;

    /** PURCHASE_PRICE_AVERAGE_MONTH: {DECIMAL(14, 4)} */
    protected java.math.BigDecimal _purchasePriceAverageMonth;

    /** PURCHASE_COUNT_SUM_MONTH: {DECIMAL(32)} */
    protected java.math.BigDecimal _purchaseCountSumMonth;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "PartOfPurchaseMonthSummary";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "partOfPurchaseMonthSummary";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return org.dbflute.handson.dbflute.bsentity.customize.dbmeta.PartOfPurchaseMonthSummaryDbm.getInstance();
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        return false;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsPartOfPurchaseMonthSummary) {
            BsPartOfPurchaseMonthSummary other = (BsPartOfPurchaseMonthSummary)obj;
            if (!xSV(_memberId, other._memberId)) { return false; }
            if (!xSV(_memberName, other._memberName)) { return false; }
            if (!xSV(_purchaseMonth, other._purchaseMonth)) { return false; }
            if (!xSV(_purchasePriceAverageMonth, other._purchasePriceAverageMonth)) { return false; }
            if (!xSV(_purchaseCountSumMonth, other._purchaseCountSumMonth)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _memberId);
        hs = xCH(hs, _memberName);
        hs = xCH(hs, _purchaseMonth);
        hs = xCH(hs, _purchasePriceAverageMonth);
        hs = xCH(hs, _purchaseCountSumMonth);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        return "";
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_memberName));
        sb.append(dm).append(xfND(_purchaseMonth));
        sb.append(dm).append(xfND(_purchasePriceAverageMonth));
        sb.append(dm).append(xfND(_purchaseCountSumMonth));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        return "";
    }

    @Override
    public PartOfPurchaseMonthSummary clone() {
        return (PartOfPurchaseMonthSummary)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID} <br />
     * 会員を識別するID。連番として基本的に自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMSによって変わる。
     * @return The value of the column 'MEMBER_ID'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID} <br />
     * 会員を識別するID。連番として基本的に自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMSによって変わる。
     * @param memberId The value of the column 'MEMBER_ID'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberId(Integer memberId) {
        registerModifiedProperty("memberId");
        _memberId = memberId;
    }

    /**
     * [get] (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME} <br />
     * 会員のフルネームの名称。
     * @return The value of the column 'MEMBER_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getMemberName() {
        checkSpecifiedProperty("memberName");
        return convertEmptyToNull(_memberName);
    }

    /**
     * [set] (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME} <br />
     * 会員のフルネームの名称。
     * @param memberName The value of the column 'MEMBER_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setMemberName(String memberName) {
        registerModifiedProperty("memberName");
        _memberName = memberName;
    }

    /**
     * [get] PURCHASE_MONTH: {INT(2)} <br />
     * @return The value of the column 'PURCHASE_MONTH'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getPurchaseMonth() {
        checkSpecifiedProperty("purchaseMonth");
        return _purchaseMonth;
    }

    /**
     * [set] PURCHASE_MONTH: {INT(2)} <br />
     * @param purchaseMonth The value of the column 'PURCHASE_MONTH'. (NullAllowed: null update allowed for no constraint)
     */
    public void setPurchaseMonth(Integer purchaseMonth) {
        registerModifiedProperty("purchaseMonth");
        _purchaseMonth = purchaseMonth;
    }

    /**
     * [get] PURCHASE_PRICE_AVERAGE_MONTH: {DECIMAL(14, 4)} <br />
     * @return The value of the column 'PURCHASE_PRICE_AVERAGE_MONTH'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getPurchasePriceAverageMonth() {
        checkSpecifiedProperty("purchasePriceAverageMonth");
        return _purchasePriceAverageMonth;
    }

    /**
     * [set] PURCHASE_PRICE_AVERAGE_MONTH: {DECIMAL(14, 4)} <br />
     * @param purchasePriceAverageMonth The value of the column 'PURCHASE_PRICE_AVERAGE_MONTH'. (NullAllowed: null update allowed for no constraint)
     */
    public void setPurchasePriceAverageMonth(java.math.BigDecimal purchasePriceAverageMonth) {
        registerModifiedProperty("purchasePriceAverageMonth");
        _purchasePriceAverageMonth = purchasePriceAverageMonth;
    }

    /**
     * [get] PURCHASE_COUNT_SUM_MONTH: {DECIMAL(32)} <br />
     * @return The value of the column 'PURCHASE_COUNT_SUM_MONTH'. (NullAllowed even if selected: for no constraint)
     */
    public java.math.BigDecimal getPurchaseCountSumMonth() {
        checkSpecifiedProperty("purchaseCountSumMonth");
        return _purchaseCountSumMonth;
    }

    /**
     * [set] PURCHASE_COUNT_SUM_MONTH: {DECIMAL(32)} <br />
     * @param purchaseCountSumMonth The value of the column 'PURCHASE_COUNT_SUM_MONTH'. (NullAllowed: null update allowed for no constraint)
     */
    public void setPurchaseCountSumMonth(java.math.BigDecimal purchaseCountSumMonth) {
        registerModifiedProperty("purchaseCountSumMonth");
        _purchaseCountSumMonth = purchaseCountSumMonth;
    }
}
