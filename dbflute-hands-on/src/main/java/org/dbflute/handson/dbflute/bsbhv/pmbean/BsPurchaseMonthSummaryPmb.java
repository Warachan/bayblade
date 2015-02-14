package org.dbflute.handson.dbflute.bsbhv.pmbean;

import java.util.*;

import org.seasar.dbflute.outsidesql.typed.*;
import org.seasar.dbflute.jdbc.*;
import org.seasar.dbflute.jdbc.ParameterUtil.ShortCharHandlingMode;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.util.DfTypeUtil;
import org.dbflute.handson.dbflute.allcommon.*;
import org.dbflute.handson.dbflute.exbhv.*;
import org.dbflute.handson.dbflute.exentity.customize.*;

/**
 * The base class for typed parameter-bean of PurchaseMonthSummary. <br />
 * This is related to "<span style="color: #AD4747">selectPurchaseMonthSummary</span>" on PurchaseBhv.
 * @author DBFlute(AutoGenerator)
 */
public class BsPurchaseMonthSummaryPmb implements ListHandlingPmb<PurchaseBhv, PurchaseMonthSummary>, EntityHandlingPmb<PurchaseBhv, PurchaseMonthSummary>, FetchBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The parameter of paymentCompleteTrue:cls(Flg.True). */
    protected Integer _paymentCompleteTrue = toNumber(CDef.Flg.True.code(), Integer.class);

    /** The parameter of memberName:likeContain. */
    protected String _memberName;

    /** The option of like-search for memberName. */
    protected LikeSearchOption _memberNameInternalLikeSearchOption;

    /** The parameter of purchasePaymentId. */
    protected String _purchasePaymentId;

    /** The parameter of purchasPaymentId. */
    protected Integer _purchasPaymentId;

    /** The parameter of servicePointCount. */
    protected String _servicePointCount;

    /** The parameter of greaterThanPoint. */
    protected Integer _greaterThanPoint;

    /** The parameter of paymentCompleteOnly:cls(Flg). */
    protected Boolean _paymentCompleteOnly;

    /** The max size of safety result. */
    protected int _safetyMaxResultSize;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor for the typed parameter-bean of PurchaseMonthSummary. <br />
     * This is related to "<span style="color: #AD4747">selectPurchaseMonthSummary</span>" on PurchaseBhv.
     */
    public BsPurchaseMonthSummaryPmb() {
    }

    // ===================================================================================
    //                                                                Typed Implementation
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    public String getOutsideSqlPath() {
        return "selectPurchaseMonthSummary";
    }

    /**
     * Get the type of an entity for result. (implementation)
     * @return The type instance of an entity, customize entity. (NotNull)
     */
    public Class<PurchaseMonthSummary> getEntityType() {
        return PurchaseMonthSummary.class;
    }

    // ===================================================================================
    //                                                                       Safety Result
    //                                                                       =============
    /**
     * {@inheritDoc}
     */
    public void checkSafetyResult(int safetyMaxResultSize) {
        _safetyMaxResultSize = safetyMaxResultSize;
    }

    /**
     * {@inheritDoc}
     */
    public int getSafetyMaxResultSize() {
        return _safetyMaxResultSize;
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected String filterStringParameter(String value) {
        if (isEmptyStringParameterAllowed()) {
            return value;
        }
        return convertEmptyToNull(value);
    }

    protected boolean isEmptyStringParameterAllowed() {
	    return DBFluteConfig.getInstance().isEmptyStringParameterAllowed();
    }

    protected String convertEmptyToNull(String value) {
	    return ParameterUtil.convertEmptyToNull(value);
    }

    protected String handleShortChar(String propertyName, String value, Integer size) {
        ShortCharHandlingMode mode = getShortCharHandlingMode(propertyName, value, size);
        return ParameterUtil.handleShortChar(propertyName, value, size, mode);
    }

    protected ShortCharHandlingMode getShortCharHandlingMode(String propertyName, String value, Integer size) {
        return ShortCharHandlingMode.NONE;
    }

    @SuppressWarnings("unchecked")
    protected <ELEMENT> ArrayList<ELEMENT> newArrayList(ELEMENT... elements) { // might be called by option handling
        Object obj = DfCollectionUtil.newArrayList(elements);
        return (ArrayList<ELEMENT>)obj; // to avoid the warning between JDK6 and JDK7
    }

    @SuppressWarnings("unchecked")
    protected <NUMBER extends Number> NUMBER toNumber(Object obj, Class<NUMBER> type) { // might be called by option handling
        return (NUMBER)DfTypeUtil.toNumber(obj, type);
    }

    protected Boolean toBoolean(Object obj) {
        return DfTypeUtil.toBoolean(obj);
    }

    protected Date toUtilDate(Date date) {
        return DfTypeUtil.toDate(date); // if sub class, re-create as pure date
    }

    protected String formatUtilDate(Date date) {
        String pattern = "yyyy-MM-dd";
        return DfTypeUtil.toString(date, pattern);
    }

    protected String formatByteArray(byte[] bytes) {
        return "byte[" + (bytes != null ? String.valueOf(bytes.length) : "null") + "]";
    }

    protected void assertLikeSearchOptionValid(String name, LikeSearchOption option) {
        if (option == null) {
            String msg = "The like-search option is required!";
            throw new RequiredOptionNotFoundException(msg);
        }
        if (option.isSplit()) {
            String msg = "The split of like-search is NOT available on parameter-bean.";
            msg = msg + " Don't use splitByXxx(): " + option;
            throw new IllegalOutsideSqlOperationException(msg);
        }
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * @return The display string of all parameters. (NotNull)
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(DfTypeUtil.toClassTitle(this)).append(":");
        sb.append(xbuildColumnString());
        return sb.toString();
    }
    protected String xbuildColumnString() {
        final String dm = ", ";
        final StringBuilder sb = new StringBuilder();
        sb.append(dm).append(_paymentCompleteTrue);
        sb.append(dm).append(_memberName);
        sb.append(dm).append(_purchasePaymentId);
        sb.append(dm).append(_purchasPaymentId);
        sb.append(dm).append(_servicePointCount);
        sb.append(dm).append(_greaterThanPoint);
        sb.append(dm).append(_paymentCompleteOnly);
        if (sb.length() > 0) { sb.delete(0, dm.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] paymentCompleteTrue:cls(Flg.True) <br />
     * @return The value of paymentCompleteTrue. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getPaymentCompleteTrue() {
        return _paymentCompleteTrue;
    }

    /**
     * [get] memberName:likeContain <br />
     * @return The value of memberName. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public String getMemberName() {
        return filterStringParameter(_memberName);
    }

    /**
     * [set as containSearch] memberName:likeContain <br />
     * @param memberName The value of memberName. (NullAllowed)
     */
    public void setMemberName_ContainSearch(String memberName) {
        _memberName = memberName;
        _memberNameInternalLikeSearchOption = new LikeSearchOption().likeContain();
    }

    /**
     * Get the internal option of likeSearch for memberName. {Internal Method: Don't invoke this}
     * @return The internal option of likeSearch for memberName. (NullAllowed)
     */
    public LikeSearchOption getMemberNameInternalLikeSearchOption() {
        return _memberNameInternalLikeSearchOption;
    }

    /**
     * [get] purchasePaymentId <br />
     * @return The value of purchasePaymentId. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public String getPurchasePaymentId() {
        return filterStringParameter(_purchasePaymentId);
    }

    /**
     * [set] purchasePaymentId <br />
     * @param purchasePaymentId The value of purchasePaymentId. (NullAllowed)
     */
    public void setPurchasePaymentId(String purchasePaymentId) {
        _purchasePaymentId = purchasePaymentId;
    }

    /**
     * [get] purchasPaymentId <br />
     * @return The value of purchasPaymentId. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getPurchasPaymentId() {
        return _purchasPaymentId;
    }

    /**
     * [set] purchasPaymentId <br />
     * @param purchasPaymentId The value of purchasPaymentId. (NullAllowed)
     */
    public void setPurchasPaymentId(Integer purchasPaymentId) {
        _purchasPaymentId = purchasPaymentId;
    }

    /**
     * [get] servicePointCount <br />
     * @return The value of servicePointCount. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public String getServicePointCount() {
        return filterStringParameter(_servicePointCount);
    }

    /**
     * [set] servicePointCount <br />
     * @param servicePointCount The value of servicePointCount. (NullAllowed)
     */
    public void setServicePointCount(String servicePointCount) {
        _servicePointCount = servicePointCount;
    }

    /**
     * [get] greaterThanPoint <br />
     * @return The value of greaterThanPoint. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public Integer getGreaterThanPoint() {
        return _greaterThanPoint;
    }

    /**
     * [set] greaterThanPoint <br />
     * @param greaterThanPoint The value of greaterThanPoint. (NullAllowed)
     */
    public void setGreaterThanPoint(Integer greaterThanPoint) {
        _greaterThanPoint = greaterThanPoint;
    }

    /**
     * [get] paymentCompleteOnly:cls(Flg) <br />
     * @return The value of paymentCompleteOnly. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public Boolean getPaymentCompleteOnly() {
        return _paymentCompleteOnly;
    }

    /**
     * [set as True] paymentCompleteOnly:cls(Flg) <br />
     * フラグが立っている
     */
    public void setPaymentCompleteOnly_True() {
        _paymentCompleteOnly = toBoolean(CDef.Flg.True.code());
    }

    /**
     * [set as False] paymentCompleteOnly:cls(Flg) <br />
     * フラグが立っていない
     */
    public void setPaymentCompleteOnly_False() {
        _paymentCompleteOnly = toBoolean(CDef.Flg.False.code());
    }
}
