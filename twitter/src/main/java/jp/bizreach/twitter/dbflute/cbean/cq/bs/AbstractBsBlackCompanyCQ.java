package jp.bizreach.twitter.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import jp.bizreach.twitter.dbflute.allcommon.*;
import jp.bizreach.twitter.dbflute.cbean.*;
import jp.bizreach.twitter.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of black_company.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsBlackCompanyCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsBlackCompanyCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "black_company";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyId The value of blackCompanyId as equal. (NullAllowed: if null, no condition)
     */
    public void setBlackCompanyId_Equal(Long blackCompanyId) {
        doSetBlackCompanyId_Equal(blackCompanyId);
    }

    protected void doSetBlackCompanyId_Equal(Long blackCompanyId) {
        regBlackCompanyId(CK_EQ, blackCompanyId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyId The value of blackCompanyId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setBlackCompanyId_NotEqual(Long blackCompanyId) {
        doSetBlackCompanyId_NotEqual(blackCompanyId);
    }

    protected void doSetBlackCompanyId_NotEqual(Long blackCompanyId) {
        regBlackCompanyId(CK_NES, blackCompanyId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyId The value of blackCompanyId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setBlackCompanyId_GreaterThan(Long blackCompanyId) {
        regBlackCompanyId(CK_GT, blackCompanyId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyId The value of blackCompanyId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setBlackCompanyId_LessThan(Long blackCompanyId) {
        regBlackCompanyId(CK_LT, blackCompanyId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyId The value of blackCompanyId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setBlackCompanyId_GreaterEqual(Long blackCompanyId) {
        regBlackCompanyId(CK_GE, blackCompanyId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyId The value of blackCompanyId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setBlackCompanyId_LessEqual(Long blackCompanyId) {
        regBlackCompanyId(CK_LE, blackCompanyId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param minNumber The min number of blackCompanyId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of blackCompanyId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setBlackCompanyId_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueBlackCompanyId(), "BLACK_COMPANY_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyIdList The collection of blackCompanyId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyId_InScope(Collection<Long> blackCompanyIdList) {
        doSetBlackCompanyId_InScope(blackCompanyIdList);
    }

    protected void doSetBlackCompanyId_InScope(Collection<Long> blackCompanyIdList) {
        regINS(CK_INS, cTL(blackCompanyIdList), getCValueBlackCompanyId(), "BLACK_COMPANY_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @param blackCompanyIdList The collection of blackCompanyId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyId_NotInScope(Collection<Long> blackCompanyIdList) {
        doSetBlackCompanyId_NotInScope(blackCompanyIdList);
    }

    protected void doSetBlackCompanyId_NotInScope(Collection<Long> blackCompanyIdList) {
        regINS(CK_NINS, cTL(blackCompanyIdList), getCValueBlackCompanyId(), "BLACK_COMPANY_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setBlackCompanyId_IsNull() { regBlackCompanyId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     */
    public void setBlackCompanyId_IsNotNull() { regBlackCompanyId(CK_ISNN, DOBJ); }

    protected void regBlackCompanyId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueBlackCompanyId(), "BLACK_COMPANY_ID"); }
    protected abstract ConditionValue getCValueBlackCompanyId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_Equal(String blackCompanyName) {
        doSetBlackCompanyName_Equal(fRES(blackCompanyName));
    }

    protected void doSetBlackCompanyName_Equal(String blackCompanyName) {
        regBlackCompanyName(CK_EQ, blackCompanyName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_NotEqual(String blackCompanyName) {
        doSetBlackCompanyName_NotEqual(fRES(blackCompanyName));
    }

    protected void doSetBlackCompanyName_NotEqual(String blackCompanyName) {
        regBlackCompanyName(CK_NES, blackCompanyName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_GreaterThan(String blackCompanyName) {
        regBlackCompanyName(CK_GT, fRES(blackCompanyName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_LessThan(String blackCompanyName) {
        regBlackCompanyName(CK_LT, fRES(blackCompanyName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_GreaterEqual(String blackCompanyName) {
        regBlackCompanyName(CK_GE, fRES(blackCompanyName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_LessEqual(String blackCompanyName) {
        regBlackCompanyName(CK_LE, fRES(blackCompanyName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyNameList The collection of blackCompanyName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_InScope(Collection<String> blackCompanyNameList) {
        doSetBlackCompanyName_InScope(blackCompanyNameList);
    }

    public void doSetBlackCompanyName_InScope(Collection<String> blackCompanyNameList) {
        regINS(CK_INS, cTL(blackCompanyNameList), getCValueBlackCompanyName(), "BLACK_COMPANY_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyNameList The collection of blackCompanyName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_NotInScope(Collection<String> blackCompanyNameList) {
        doSetBlackCompanyName_NotInScope(blackCompanyNameList);
    }

    public void doSetBlackCompanyName_NotInScope(Collection<String> blackCompanyNameList) {
        regINS(CK_NINS, cTL(blackCompanyNameList), getCValueBlackCompanyName(), "BLACK_COMPANY_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyName_PrefixSearch(String blackCompanyName) {
        setBlackCompanyName_LikeSearch(blackCompanyName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)} <br />
     * <pre>e.g. setBlackCompanyName_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param blackCompanyName The value of blackCompanyName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setBlackCompanyName_LikeSearch(String blackCompanyName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(blackCompanyName), getCValueBlackCompanyName(), "BLACK_COMPANY_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @param blackCompanyName The value of blackCompanyName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setBlackCompanyName_NotLikeSearch(String blackCompanyName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(blackCompanyName), getCValueBlackCompanyName(), "BLACK_COMPANY_NAME", likeSearchOption);
    }

    protected void regBlackCompanyName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueBlackCompanyName(), "BLACK_COMPANY_NAME"); }
    protected abstract ConditionValue getCValueBlackCompanyName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_Equal(String agentCompanyName) {
        doSetAgentCompanyName_Equal(fRES(agentCompanyName));
    }

    protected void doSetAgentCompanyName_Equal(String agentCompanyName) {
        regAgentCompanyName(CK_EQ, agentCompanyName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_NotEqual(String agentCompanyName) {
        doSetAgentCompanyName_NotEqual(fRES(agentCompanyName));
    }

    protected void doSetAgentCompanyName_NotEqual(String agentCompanyName) {
        regAgentCompanyName(CK_NES, agentCompanyName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_GreaterThan(String agentCompanyName) {
        regAgentCompanyName(CK_GT, fRES(agentCompanyName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_LessThan(String agentCompanyName) {
        regAgentCompanyName(CK_LT, fRES(agentCompanyName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_GreaterEqual(String agentCompanyName) {
        regAgentCompanyName(CK_GE, fRES(agentCompanyName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_LessEqual(String agentCompanyName) {
        regAgentCompanyName(CK_LE, fRES(agentCompanyName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyNameList The collection of agentCompanyName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_InScope(Collection<String> agentCompanyNameList) {
        doSetAgentCompanyName_InScope(agentCompanyNameList);
    }

    public void doSetAgentCompanyName_InScope(Collection<String> agentCompanyNameList) {
        regINS(CK_INS, cTL(agentCompanyNameList), getCValueAgentCompanyName(), "AGENT_COMPANY_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyNameList The collection of agentCompanyName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_NotInScope(Collection<String> agentCompanyNameList) {
        doSetAgentCompanyName_NotInScope(agentCompanyNameList);
    }

    public void doSetAgentCompanyName_NotInScope(Collection<String> agentCompanyNameList) {
        regINS(CK_NINS, cTL(agentCompanyNameList), getCValueAgentCompanyName(), "AGENT_COMPANY_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setAgentCompanyName_PrefixSearch(String agentCompanyName) {
        setAgentCompanyName_LikeSearch(agentCompanyName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)} <br />
     * <pre>e.g. setAgentCompanyName_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param agentCompanyName The value of agentCompanyName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setAgentCompanyName_LikeSearch(String agentCompanyName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(agentCompanyName), getCValueAgentCompanyName(), "AGENT_COMPANY_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @param agentCompanyName The value of agentCompanyName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setAgentCompanyName_NotLikeSearch(String agentCompanyName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(agentCompanyName), getCValueAgentCompanyName(), "AGENT_COMPANY_NAME", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     */
    public void setAgentCompanyName_IsNull() { regAgentCompanyName(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     */
    public void setAgentCompanyName_IsNullOrEmpty() { regAgentCompanyName(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     */
    public void setAgentCompanyName_IsNotNull() { regAgentCompanyName(CK_ISNN, DOBJ); }

    protected void regAgentCompanyName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueAgentCompanyName(), "AGENT_COMPANY_NAME"); }
    protected abstract ConditionValue getCValueAgentCompanyName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_Equal(String zipCode) {
        doSetZipCode_Equal(fRES(zipCode));
    }

    protected void doSetZipCode_Equal(String zipCode) {
        regZipCode(CK_EQ, zipCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_NotEqual(String zipCode) {
        doSetZipCode_NotEqual(fRES(zipCode));
    }

    protected void doSetZipCode_NotEqual(String zipCode) {
        regZipCode(CK_NES, zipCode);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_GreaterThan(String zipCode) {
        regZipCode(CK_GT, fRES(zipCode));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_LessThan(String zipCode) {
        regZipCode(CK_LT, fRES(zipCode));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_GreaterEqual(String zipCode) {
        regZipCode(CK_GE, fRES(zipCode));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_LessEqual(String zipCode) {
        regZipCode(CK_LE, fRES(zipCode));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCodeList The collection of zipCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_InScope(Collection<String> zipCodeList) {
        doSetZipCode_InScope(zipCodeList);
    }

    public void doSetZipCode_InScope(Collection<String> zipCodeList) {
        regINS(CK_INS, cTL(zipCodeList), getCValueZipCode(), "ZIP_CODE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCodeList The collection of zipCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_NotInScope(Collection<String> zipCodeList) {
        doSetZipCode_NotInScope(zipCodeList);
    }

    public void doSetZipCode_NotInScope(Collection<String> zipCodeList) {
        regINS(CK_NINS, cTL(zipCodeList), getCValueZipCode(), "ZIP_CODE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setZipCode_PrefixSearch(String zipCode) {
        setZipCode_LikeSearch(zipCode, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)} <br />
     * <pre>e.g. setZipCode_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param zipCode The value of zipCode as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setZipCode_LikeSearch(String zipCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(zipCode), getCValueZipCode(), "ZIP_CODE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @param zipCode The value of zipCode as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setZipCode_NotLikeSearch(String zipCode, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(zipCode), getCValueZipCode(), "ZIP_CODE", likeSearchOption);
    }

    protected void regZipCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueZipCode(), "ZIP_CODE"); }
    protected abstract ConditionValue getCValueZipCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_Equal(String address1) {
        doSetAddress1_Equal(fRES(address1));
    }

    protected void doSetAddress1_Equal(String address1) {
        regAddress1(CK_EQ, address1);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_NotEqual(String address1) {
        doSetAddress1_NotEqual(fRES(address1));
    }

    protected void doSetAddress1_NotEqual(String address1) {
        regAddress1(CK_NES, address1);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_GreaterThan(String address1) {
        regAddress1(CK_GT, fRES(address1));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_LessThan(String address1) {
        regAddress1(CK_LT, fRES(address1));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_GreaterEqual(String address1) {
        regAddress1(CK_GE, fRES(address1));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_LessEqual(String address1) {
        regAddress1(CK_LE, fRES(address1));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1List The collection of address1 as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_InScope(Collection<String> address1List) {
        doSetAddress1_InScope(address1List);
    }

    public void doSetAddress1_InScope(Collection<String> address1List) {
        regINS(CK_INS, cTL(address1List), getCValueAddress1(), "ADDRESS1");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1List The collection of address1 as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_NotInScope(Collection<String> address1List) {
        doSetAddress1_NotInScope(address1List);
    }

    public void doSetAddress1_NotInScope(Collection<String> address1List) {
        regINS(CK_NINS, cTL(address1List), getCValueAddress1(), "ADDRESS1");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress1_PrefixSearch(String address1) {
        setAddress1_LikeSearch(address1, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)} <br />
     * <pre>e.g. setAddress1_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param address1 The value of address1 as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setAddress1_LikeSearch(String address1, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(address1), getCValueAddress1(), "ADDRESS1", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @param address1 The value of address1 as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setAddress1_NotLikeSearch(String address1, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(address1), getCValueAddress1(), "ADDRESS1", likeSearchOption);
    }

    protected void regAddress1(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueAddress1(), "ADDRESS1"); }
    protected abstract ConditionValue getCValueAddress1();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_Equal(String address2) {
        doSetAddress2_Equal(fRES(address2));
    }

    protected void doSetAddress2_Equal(String address2) {
        regAddress2(CK_EQ, address2);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_NotEqual(String address2) {
        doSetAddress2_NotEqual(fRES(address2));
    }

    protected void doSetAddress2_NotEqual(String address2) {
        regAddress2(CK_NES, address2);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_GreaterThan(String address2) {
        regAddress2(CK_GT, fRES(address2));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_LessThan(String address2) {
        regAddress2(CK_LT, fRES(address2));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_GreaterEqual(String address2) {
        regAddress2(CK_GE, fRES(address2));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_LessEqual(String address2) {
        regAddress2(CK_LE, fRES(address2));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2List The collection of address2 as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_InScope(Collection<String> address2List) {
        doSetAddress2_InScope(address2List);
    }

    public void doSetAddress2_InScope(Collection<String> address2List) {
        regINS(CK_INS, cTL(address2List), getCValueAddress2(), "ADDRESS2");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2List The collection of address2 as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_NotInScope(Collection<String> address2List) {
        doSetAddress2_NotInScope(address2List);
    }

    public void doSetAddress2_NotInScope(Collection<String> address2List) {
        regINS(CK_NINS, cTL(address2List), getCValueAddress2(), "ADDRESS2");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setAddress2_PrefixSearch(String address2) {
        setAddress2_LikeSearch(address2, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)} <br />
     * <pre>e.g. setAddress2_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param address2 The value of address2 as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setAddress2_LikeSearch(String address2, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(address2), getCValueAddress2(), "ADDRESS2", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @param address2 The value of address2 as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setAddress2_NotLikeSearch(String address2, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(address2), getCValueAddress2(), "ADDRESS2", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     */
    public void setAddress2_IsNull() { regAddress2(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     */
    public void setAddress2_IsNullOrEmpty() { regAddress2(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * ADDRESS2: {VARCHAR(1024)}
     */
    public void setAddress2_IsNotNull() { regAddress2(CK_ISNN, DOBJ); }

    protected void regAddress2(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueAddress2(), "ADDRESS2"); }
    protected abstract ConditionValue getCValueAddress2();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_Equal(String blackCompanyStatusCd) {
        doSetBlackCompanyStatusCd_Equal(fRES(blackCompanyStatusCd));
    }

    protected void doSetBlackCompanyStatusCd_Equal(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_EQ, blackCompanyStatusCd);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_NotEqual(String blackCompanyStatusCd) {
        doSetBlackCompanyStatusCd_NotEqual(fRES(blackCompanyStatusCd));
    }

    protected void doSetBlackCompanyStatusCd_NotEqual(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_NES, blackCompanyStatusCd);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_GreaterThan(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_GT, fRES(blackCompanyStatusCd));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_LessThan(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_LT, fRES(blackCompanyStatusCd));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_GreaterEqual(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_GE, fRES(blackCompanyStatusCd));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_LessEqual(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_LE, fRES(blackCompanyStatusCd));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCdList The collection of blackCompanyStatusCd as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_InScope(Collection<String> blackCompanyStatusCdList) {
        doSetBlackCompanyStatusCd_InScope(blackCompanyStatusCdList);
    }

    public void doSetBlackCompanyStatusCd_InScope(Collection<String> blackCompanyStatusCdList) {
        regINS(CK_INS, cTL(blackCompanyStatusCdList), getCValueBlackCompanyStatusCd(), "BLACK_COMPANY_STATUS_CD");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCdList The collection of blackCompanyStatusCd as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_NotInScope(Collection<String> blackCompanyStatusCdList) {
        doSetBlackCompanyStatusCd_NotInScope(blackCompanyStatusCdList);
    }

    public void doSetBlackCompanyStatusCd_NotInScope(Collection<String> blackCompanyStatusCdList) {
        regINS(CK_NINS, cTL(blackCompanyStatusCdList), getCValueBlackCompanyStatusCd(), "BLACK_COMPANY_STATUS_CD");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_PrefixSearch(String blackCompanyStatusCd) {
        setBlackCompanyStatusCd_LikeSearch(blackCompanyStatusCd, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status} <br />
     * <pre>e.g. setBlackCompanyStatusCd_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setBlackCompanyStatusCd_LikeSearch(String blackCompanyStatusCd, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(blackCompanyStatusCd), getCValueBlackCompanyStatusCd(), "BLACK_COMPANY_STATUS_CD", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setBlackCompanyStatusCd_NotLikeSearch(String blackCompanyStatusCd, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(blackCompanyStatusCd), getCValueBlackCompanyStatusCd(), "BLACK_COMPANY_STATUS_CD", likeSearchOption);
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select BLACK_COMPANY_STATUS_CD from cls_black_company_status where ...)} <br />
     * cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'.
     * @param subQuery The sub-query of ClsBlackCompanyStatus for 'in-scope'. (NotNull)
     */
    public void inScopeClsBlackCompanyStatus(SubQuery<ClsBlackCompanyStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepBlackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatus(cb.query());
        registerInScopeRelation(cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", pp, "clsBlackCompanyStatus");
    }
    public abstract String keepBlackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatus(ClsBlackCompanyStatusCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select BLACK_COMPANY_STATUS_CD from cls_black_company_status where ...)} <br />
     * cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'.
     * @param subQuery The sub-query of ClsBlackCompanyStatus for 'not in-scope'. (NotNull)
     */
    public void notInScopeClsBlackCompanyStatus(SubQuery<ClsBlackCompanyStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepBlackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatus(cb.query());
        registerNotInScopeRelation(cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", pp, "clsBlackCompanyStatus");
    }
    public abstract String keepBlackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatus(ClsBlackCompanyStatusCQ sq);

    protected void regBlackCompanyStatusCd(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueBlackCompanyStatusCd(), "BLACK_COMPANY_STATUS_CD"); }
    protected abstract ConditionValue getCValueBlackCompanyStatusCd();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_Equal(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_EQ,  insDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_GreaterThan(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_GT,  insDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_LessThan(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_LT,  insDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_GreaterEqual(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_GE,  insDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_LessEqual(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_LE, insDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setInsDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of insDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of insDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setInsDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueInsDatetime(), "INS_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of insDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of insDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setInsDatetime_DateFromTo(Date fromDate, Date toDate) {
        setInsDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    protected void regInsDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueInsDatetime(), "INS_DATETIME"); }
    protected abstract ConditionValue getCValueInsDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_Equal(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_EQ,  updDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_GreaterThan(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_GT,  updDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_LessThan(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_LT,  updDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_GreaterEqual(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_GE,  updDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_LessEqual(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_LE, updDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setUpdDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueUpdDatetime(), "UPD_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of updDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of updDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setUpdDatetime_DateFromTo(Date fromDate, Date toDate) {
        setUpdDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    protected void regUpdDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUpdDatetime(), "UPD_DATETIME"); }
    protected abstract ConditionValue getCValueUpdDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_Equal(String insTrace) {
        doSetInsTrace_Equal(fRES(insTrace));
    }

    protected void doSetInsTrace_Equal(String insTrace) {
        regInsTrace(CK_EQ, insTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_NotEqual(String insTrace) {
        doSetInsTrace_NotEqual(fRES(insTrace));
    }

    protected void doSetInsTrace_NotEqual(String insTrace) {
        regInsTrace(CK_NES, insTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_GreaterThan(String insTrace) {
        regInsTrace(CK_GT, fRES(insTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_LessThan(String insTrace) {
        regInsTrace(CK_LT, fRES(insTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_GreaterEqual(String insTrace) {
        regInsTrace(CK_GE, fRES(insTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_LessEqual(String insTrace) {
        regInsTrace(CK_LE, fRES(insTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTraceList The collection of insTrace as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_InScope(Collection<String> insTraceList) {
        doSetInsTrace_InScope(insTraceList);
    }

    public void doSetInsTrace_InScope(Collection<String> insTraceList) {
        regINS(CK_INS, cTL(insTraceList), getCValueInsTrace(), "INS_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTraceList The collection of insTrace as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_NotInScope(Collection<String> insTraceList) {
        doSetInsTrace_NotInScope(insTraceList);
    }

    public void doSetInsTrace_NotInScope(Collection<String> insTraceList) {
        regINS(CK_NINS, cTL(insTraceList), getCValueInsTrace(), "INS_TRACE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_PrefixSearch(String insTrace) {
        setInsTrace_LikeSearch(insTrace, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)} <br />
     * <pre>e.g. setInsTrace_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param insTrace The value of insTrace as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setInsTrace_LikeSearch(String insTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(insTrace), getCValueInsTrace(), "INS_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setInsTrace_NotLikeSearch(String insTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(insTrace), getCValueInsTrace(), "INS_TRACE", likeSearchOption);
    }

    protected void regInsTrace(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueInsTrace(), "INS_TRACE"); }
    protected abstract ConditionValue getCValueInsTrace();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_Equal(String updTrace) {
        doSetUpdTrace_Equal(fRES(updTrace));
    }

    protected void doSetUpdTrace_Equal(String updTrace) {
        regUpdTrace(CK_EQ, updTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_NotEqual(String updTrace) {
        doSetUpdTrace_NotEqual(fRES(updTrace));
    }

    protected void doSetUpdTrace_NotEqual(String updTrace) {
        regUpdTrace(CK_NES, updTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_GreaterThan(String updTrace) {
        regUpdTrace(CK_GT, fRES(updTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_LessThan(String updTrace) {
        regUpdTrace(CK_LT, fRES(updTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_GreaterEqual(String updTrace) {
        regUpdTrace(CK_GE, fRES(updTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_LessEqual(String updTrace) {
        regUpdTrace(CK_LE, fRES(updTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTraceList The collection of updTrace as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_InScope(Collection<String> updTraceList) {
        doSetUpdTrace_InScope(updTraceList);
    }

    public void doSetUpdTrace_InScope(Collection<String> updTraceList) {
        regINS(CK_INS, cTL(updTraceList), getCValueUpdTrace(), "UPD_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTraceList The collection of updTrace as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_NotInScope(Collection<String> updTraceList) {
        doSetUpdTrace_NotInScope(updTraceList);
    }

    public void doSetUpdTrace_NotInScope(Collection<String> updTraceList) {
        regINS(CK_NINS, cTL(updTraceList), getCValueUpdTrace(), "UPD_TRACE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_PrefixSearch(String updTrace) {
        setUpdTrace_LikeSearch(updTrace, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)} <br />
     * <pre>e.g. setUpdTrace_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updTrace The value of updTrace as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setUpdTrace_LikeSearch(String updTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updTrace), getCValueUpdTrace(), "UPD_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setUpdTrace_NotLikeSearch(String updTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updTrace), getCValueUpdTrace(), "UPD_TRACE", likeSearchOption);
    }

    protected void regUpdTrace(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUpdTrace(), "UPD_TRACE"); }
    protected abstract ConditionValue getCValueUpdTrace();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as equal. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_Equal(Long versionNo) {
        doSetVersionNo_Equal(versionNo);
    }

    protected void doSetVersionNo_Equal(Long versionNo) {
        regVersionNo(CK_EQ, versionNo);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as notEqual. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_NotEqual(Long versionNo) {
        doSetVersionNo_NotEqual(versionNo);
    }

    protected void doSetVersionNo_NotEqual(Long versionNo) {
        regVersionNo(CK_NES, versionNo);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_GreaterThan(Long versionNo) {
        regVersionNo(CK_GT, versionNo);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as lessThan. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_LessThan(Long versionNo) {
        regVersionNo(CK_LT, versionNo);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_GreaterEqual(Long versionNo) {
        regVersionNo(CK_GE, versionNo);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNo The value of versionNo as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setVersionNo_LessEqual(Long versionNo) {
        regVersionNo(CK_LE, versionNo);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param minNumber The min number of versionNo. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of versionNo. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setVersionNo_RangeOf(Long minNumber, Long maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueVersionNo(), "VERSION_NO", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNoList The collection of versionNo as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVersionNo_InScope(Collection<Long> versionNoList) {
        doSetVersionNo_InScope(versionNoList);
    }

    protected void doSetVersionNo_InScope(Collection<Long> versionNoList) {
        regINS(CK_INS, cTL(versionNoList), getCValueVersionNo(), "VERSION_NO");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @param versionNoList The collection of versionNo as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setVersionNo_NotInScope(Collection<Long> versionNoList) {
        doSetVersionNo_NotInScope(versionNoList);
    }

    protected void doSetVersionNo_NotInScope(Collection<Long> versionNoList) {
        regINS(CK_NINS, cTL(versionNoList), getCValueVersionNo(), "VERSION_NO");
    }

    protected void regVersionNo(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueVersionNo(), "VERSION_NO"); }
    protected abstract ConditionValue getCValueVersionNo();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<BlackCompanyCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), BlackCompanyCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<BlackCompanyCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), BlackCompanyCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<BlackCompanyCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), BlackCompanyCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<BlackCompanyCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), BlackCompanyCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<BlackCompanyCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), BlackCompanyCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<BlackCompanyCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), BlackCompanyCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        BlackCompanyCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(BlackCompanyCQ sq);

    protected BlackCompanyCB xcreateScalarConditionCB() {
        BlackCompanyCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected BlackCompanyCB xcreateScalarConditionPartitionByCB() {
        BlackCompanyCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<BlackCompanyCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "BLACK_COMPANY_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(BlackCompanyCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<BlackCompanyCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(BlackCompanyCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "BLACK_COMPANY_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(BlackCompanyCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<BlackCompanyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(BlackCompanyCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<BlackCompanyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(BlackCompanyCQ sq);

    // ===================================================================================
    //                                                                          Compatible
    //                                                                          ==========
    /**
     * Order along the list of manual values. #beforejava8 <br />
     * This function with Union is unsupported! <br />
     * The order values are bound (treated as bind parameter).
     * <pre>
     * MemberCB cb = new MemberCB();
     * List&lt;CDef.MemberStatus&gt; orderValueList = new ArrayList&lt;CDef.MemberStatus&gt;();
     * orderValueList.add(CDef.MemberStatus.Withdrawal);
     * orderValueList.add(CDef.MemberStatus.Formalized);
     * orderValueList.add(CDef.MemberStatus.Provisional);
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #DD4747">withManualOrder(orderValueList)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * @param orderValueList The list of order values for manual ordering. (NotNull)
     */
    public void withManualOrder(List<? extends Object> orderValueList) { // is user public!
        assertObjectNotNull("withManualOrder(orderValueList)", orderValueList);
        final ManualOrderBean manualOrderBean = new ManualOrderBean();
        manualOrderBean.acceptOrderValueList(orderValueList);
        withManualOrder(manualOrderBean);
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected BlackCompanyCB newMyCB() {
        return new BlackCompanyCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return BlackCompanyCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
