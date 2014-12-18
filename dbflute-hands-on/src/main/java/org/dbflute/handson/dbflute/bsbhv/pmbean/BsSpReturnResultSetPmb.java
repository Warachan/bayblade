package org.dbflute.handson.dbflute.bsbhv.pmbean;

import java.util.*;

import org.seasar.dbflute.outsidesql.ProcedurePmb;
import org.seasar.dbflute.jdbc.*;
import org.seasar.dbflute.jdbc.ParameterUtil.ShortCharHandlingMode;
import org.seasar.dbflute.util.DfCollectionUtil;
import org.seasar.dbflute.util.DfTypeUtil;
import org.dbflute.handson.dbflute.allcommon.*;
import org.dbflute.handson.dbflute.exentity.customize.*;

/**
 * The base class for procedure parameter-bean of SpReturnResultSet. <br />
 * This is related to "<span style="color: #AD4747">SP_RETURN_RESULT_SET</span>".
 * @author DBFlute(AutoGenerator)
 */
public class BsSpReturnResultSetPmb implements ProcedurePmb, FetchBean {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    // -----------------------------------------------------
    //                                   Procedure Parameter
    //                                   -------------------
    public static final String birthdateFrom_PROCEDURE_PARAMETER = "in, 0";
    public static final String notParamResult1_PROCEDURE_PARAMETER = "notParamResult, 1000";
    public static final String notParamResult2_PROCEDURE_PARAMETER = "notParamResult, 1001";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The parameter of birthdateFrom: {DATE(10) as In}. */
    protected java.util.Date _birthdateFrom;

    /** The parameter of notParamResult1. */
    protected List<SpReturnResultSetNotParamResult1> _notParamResult1;

    /** The parameter of notParamResult2. */
    protected List<SpReturnResultSetNotParamResult2> _notParamResult2;

    /** The max size of safety result. */
    protected int _safetyMaxResultSize;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    /**
     * Constructor for the procedure parameter-bean of SpReturnResultSet. <br />
     * This is related to "<span style="color: #AD4747">SP_RETURN_RESULT_SET</span>".
     */
    public BsSpReturnResultSetPmb() {
    }

    // ===================================================================================
    //                                                            Procedure Implementation
    //                                                            ========================
    /**
     * {@inheritDoc}
     */
    public String getProcedureName() {
        return "SP_RETURN_RESULT_SET";
    }

    /**
     * {@inheritDoc}
     */
     public boolean isEscapeStatement() {
         return true; // as default
     }

    /**
     * {@inheritDoc}
     */
     public boolean isCalledBySelect() {
         return false; // resolved by generator
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
        sb.append(dm).append(formatUtilDate(_birthdateFrom));
        sb.append(dm).append(_notParamResult1);
        sb.append(dm).append(_notParamResult2);
        if (sb.length() > 0) { sb.delete(0, dm.length()); }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] birthdateFrom: {DATE(10) as In} <br />
     * @return The value of birthdateFrom. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public java.util.Date getBirthdateFrom() {
        return toUtilDate(_birthdateFrom);
    }

    /**
     * [set] birthdateFrom: {DATE(10) as In} <br />
     * @param birthdateFrom The value of birthdateFrom. (NullAllowed)
     */
    public void setBirthdateFrom(java.util.Date birthdateFrom) {
        _birthdateFrom = birthdateFrom;
    }

    /**
     * [get] notParamResult1 <br />
     * @return The value of notParamResult1. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public List<SpReturnResultSetNotParamResult1> getNotParamResult1() {
        return _notParamResult1;
    }

    /**
     * [set] notParamResult1 <br />
     * @param notParamResult1 The value of notParamResult1. (NullAllowed)
     */
    public void setNotParamResult1(List<SpReturnResultSetNotParamResult1> notParamResult1) {
        _notParamResult1 = notParamResult1;
    }

    /**
     * [get] notParamResult2 <br />
     * @return The value of notParamResult2. (NullAllowed, NotEmptyString(when String): if empty string, returns null)
     */
    public List<SpReturnResultSetNotParamResult2> getNotParamResult2() {
        return _notParamResult2;
    }

    /**
     * [set] notParamResult2 <br />
     * @param notParamResult2 The value of notParamResult2. (NullAllowed)
     */
    public void setNotParamResult2(List<SpReturnResultSetNotParamResult2> notParamResult2) {
        _notParamResult2 = notParamResult2;
    }
}
