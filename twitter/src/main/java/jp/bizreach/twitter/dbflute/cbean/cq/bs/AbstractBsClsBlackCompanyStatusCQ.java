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
 * The abstract condition-query of cls_black_company_status.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsClsBlackCompanyStatusCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsClsBlackCompanyStatusCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "cls_black_company_status";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
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
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
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
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_GreaterThan(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_GT, fRES(blackCompanyStatusCd));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_LessThan(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_LT, fRES(blackCompanyStatusCd));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_GreaterEqual(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_GE, fRES(blackCompanyStatusCd));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_LessEqual(String blackCompanyStatusCd) {
        regBlackCompanyStatusCd(CK_LE, fRES(blackCompanyStatusCd));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
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
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
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
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setBlackCompanyStatusCd_PrefixSearch(String blackCompanyStatusCd) {
        setBlackCompanyStatusCd_LikeSearch(blackCompanyStatusCd, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)} <br />
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
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @param blackCompanyStatusCd The value of blackCompanyStatusCd as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setBlackCompanyStatusCd_NotLikeSearch(String blackCompanyStatusCd, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(blackCompanyStatusCd), getCValueBlackCompanyStatusCd(), "BLACK_COMPANY_STATUS_CD", likeSearchOption);
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select BLACK_COMPANY_STATUS_CD from black_company where ...)} <br />
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsBlackCompanyList</span>(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of BlackCompanyList for 'exists'. (NotNull)
     */
    public void existsBlackCompanyList(SubQuery<BlackCompanyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepBlackCompanyStatusCd_ExistsReferrer_BlackCompanyList(cb.query());
        registerExistsReferrer(cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", pp, "blackCompanyList");
    }
    public abstract String keepBlackCompanyStatusCd_ExistsReferrer_BlackCompanyList(BlackCompanyCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select BLACK_COMPANY_STATUS_CD from black_company where ...)} <br />
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsBlackCompanyList</span>(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of BlackCompanyStatusCd_NotExistsReferrer_BlackCompanyList for 'not exists'. (NotNull)
     */
    public void notExistsBlackCompanyList(SubQuery<BlackCompanyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepBlackCompanyStatusCd_NotExistsReferrer_BlackCompanyList(cb.query());
        registerNotExistsReferrer(cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", pp, "blackCompanyList");
    }
    public abstract String keepBlackCompanyStatusCd_NotExistsReferrer_BlackCompanyList(BlackCompanyCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select BLACK_COMPANY_STATUS_CD from black_company where ...)} <br />
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyAsOne'.
     * @param subQuery The sub-query of BlackCompanyList for 'in-scope'. (NotNull)
     */
    public void inScopeBlackCompanyList(SubQuery<BlackCompanyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepBlackCompanyStatusCd_InScopeRelation_BlackCompanyList(cb.query());
        registerInScopeRelation(cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", pp, "blackCompanyList");
    }
    public abstract String keepBlackCompanyStatusCd_InScopeRelation_BlackCompanyList(BlackCompanyCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select BLACK_COMPANY_STATUS_CD from black_company where ...)} <br />
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyAsOne'.
     * @param subQuery The sub-query of BlackCompanyList for 'not in-scope'. (NotNull)
     */
    public void notInScopeBlackCompanyList(SubQuery<BlackCompanyCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepBlackCompanyStatusCd_NotInScopeRelation_BlackCompanyList(cb.query());
        registerNotInScopeRelation(cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", pp, "blackCompanyList");
    }
    public abstract String keepBlackCompanyStatusCd_NotInScopeRelation_BlackCompanyList(BlackCompanyCQ sq);

    public void xsderiveBlackCompanyList(String fn, SubQuery<BlackCompanyCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepBlackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", pp, "blackCompanyList", al, op);
    }
    public abstract String keepBlackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyList(BlackCompanyCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br />
     * {FOO &lt;= (select max(BAR) from black_company where ...)} <br />
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedBlackCompanyList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;BlackCompanyCB&gt;() {
     *     public void query(BlackCompanyCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<BlackCompanyCB> derivedBlackCompanyList() {
        return xcreateQDRFunctionBlackCompanyList();
    }
    protected HpQDRFunction<BlackCompanyCB> xcreateQDRFunctionBlackCompanyList() {
        return new HpQDRFunction<BlackCompanyCB>(new HpQDRSetupper<BlackCompanyCB>() {
            public void setup(String fn, SubQuery<BlackCompanyCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveBlackCompanyList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveBlackCompanyList(String fn, SubQuery<BlackCompanyCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        BlackCompanyCB cb = new BlackCompanyCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyList(cb.query()); String prpp = keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", sqpp, "blackCompanyList", rd, vl, prpp, op);
    }
    public abstract String keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyList(BlackCompanyCQ sq);
    public abstract String keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     */
    public void setBlackCompanyStatusCd_IsNull() { regBlackCompanyStatusCd(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     */
    public void setBlackCompanyStatusCd_IsNotNull() { regBlackCompanyStatusCd(CK_ISNN, DOBJ); }

    protected void regBlackCompanyStatusCd(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueBlackCompanyStatusCd(), "BLACK_COMPANY_STATUS_CD"); }
    protected abstract ConditionValue getCValueBlackCompanyStatusCd();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_Equal(String codeName) {
        doSetCodeName_Equal(fRES(codeName));
    }

    protected void doSetCodeName_Equal(String codeName) {
        regCodeName(CK_EQ, codeName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_NotEqual(String codeName) {
        doSetCodeName_NotEqual(fRES(codeName));
    }

    protected void doSetCodeName_NotEqual(String codeName) {
        regCodeName(CK_NES, codeName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_GreaterThan(String codeName) {
        regCodeName(CK_GT, fRES(codeName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_LessThan(String codeName) {
        regCodeName(CK_LT, fRES(codeName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_GreaterEqual(String codeName) {
        regCodeName(CK_GE, fRES(codeName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_LessEqual(String codeName) {
        regCodeName(CK_LE, fRES(codeName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeNameList The collection of codeName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_InScope(Collection<String> codeNameList) {
        doSetCodeName_InScope(codeNameList);
    }

    public void doSetCodeName_InScope(Collection<String> codeNameList) {
        regINS(CK_INS, cTL(codeNameList), getCValueCodeName(), "CODE_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeNameList The collection of codeName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_NotInScope(Collection<String> codeNameList) {
        doSetCodeName_NotInScope(codeNameList);
    }

    public void doSetCodeName_NotInScope(Collection<String> codeNameList) {
        regINS(CK_NINS, cTL(codeNameList), getCValueCodeName(), "CODE_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeName_PrefixSearch(String codeName) {
        setCodeName_LikeSearch(codeName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)} <br />
     * <pre>e.g. setCodeName_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param codeName The value of codeName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setCodeName_LikeSearch(String codeName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(codeName), getCValueCodeName(), "CODE_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @param codeName The value of codeName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setCodeName_NotLikeSearch(String codeName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(codeName), getCValueCodeName(), "CODE_NAME", likeSearchOption);
    }

    protected void regCodeName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueCodeName(), "CODE_NAME"); }
    protected abstract ConditionValue getCValueCodeName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_Equal(String codeAlias) {
        doSetCodeAlias_Equal(fRES(codeAlias));
    }

    protected void doSetCodeAlias_Equal(String codeAlias) {
        regCodeAlias(CK_EQ, codeAlias);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_NotEqual(String codeAlias) {
        doSetCodeAlias_NotEqual(fRES(codeAlias));
    }

    protected void doSetCodeAlias_NotEqual(String codeAlias) {
        regCodeAlias(CK_NES, codeAlias);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_GreaterThan(String codeAlias) {
        regCodeAlias(CK_GT, fRES(codeAlias));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_LessThan(String codeAlias) {
        regCodeAlias(CK_LT, fRES(codeAlias));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_GreaterEqual(String codeAlias) {
        regCodeAlias(CK_GE, fRES(codeAlias));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_LessEqual(String codeAlias) {
        regCodeAlias(CK_LE, fRES(codeAlias));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAliasList The collection of codeAlias as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_InScope(Collection<String> codeAliasList) {
        doSetCodeAlias_InScope(codeAliasList);
    }

    public void doSetCodeAlias_InScope(Collection<String> codeAliasList) {
        regINS(CK_INS, cTL(codeAliasList), getCValueCodeAlias(), "CODE_ALIAS");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAliasList The collection of codeAlias as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_NotInScope(Collection<String> codeAliasList) {
        doSetCodeAlias_NotInScope(codeAliasList);
    }

    public void doSetCodeAlias_NotInScope(Collection<String> codeAliasList) {
        regINS(CK_NINS, cTL(codeAliasList), getCValueCodeAlias(), "CODE_ALIAS");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAlias_PrefixSearch(String codeAlias) {
        setCodeAlias_LikeSearch(codeAlias, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)} <br />
     * <pre>e.g. setCodeAlias_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param codeAlias The value of codeAlias as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setCodeAlias_LikeSearch(String codeAlias, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(codeAlias), getCValueCodeAlias(), "CODE_ALIAS", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @param codeAlias The value of codeAlias as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setCodeAlias_NotLikeSearch(String codeAlias, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(codeAlias), getCValueCodeAlias(), "CODE_ALIAS", likeSearchOption);
    }

    protected void regCodeAlias(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueCodeAlias(), "CODE_ALIAS"); }
    protected abstract ConditionValue getCValueCodeAlias();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNo The value of codeDisplayNo as equal. (NullAllowed: if null, no condition)
     */
    public void setCodeDisplayNo_Equal(Integer codeDisplayNo) {
        doSetCodeDisplayNo_Equal(codeDisplayNo);
    }

    protected void doSetCodeDisplayNo_Equal(Integer codeDisplayNo) {
        regCodeDisplayNo(CK_EQ, codeDisplayNo);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNo The value of codeDisplayNo as notEqual. (NullAllowed: if null, no condition)
     */
    public void setCodeDisplayNo_NotEqual(Integer codeDisplayNo) {
        doSetCodeDisplayNo_NotEqual(codeDisplayNo);
    }

    protected void doSetCodeDisplayNo_NotEqual(Integer codeDisplayNo) {
        regCodeDisplayNo(CK_NES, codeDisplayNo);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNo The value of codeDisplayNo as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setCodeDisplayNo_GreaterThan(Integer codeDisplayNo) {
        regCodeDisplayNo(CK_GT, codeDisplayNo);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNo The value of codeDisplayNo as lessThan. (NullAllowed: if null, no condition)
     */
    public void setCodeDisplayNo_LessThan(Integer codeDisplayNo) {
        regCodeDisplayNo(CK_LT, codeDisplayNo);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNo The value of codeDisplayNo as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setCodeDisplayNo_GreaterEqual(Integer codeDisplayNo) {
        regCodeDisplayNo(CK_GE, codeDisplayNo);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNo The value of codeDisplayNo as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setCodeDisplayNo_LessEqual(Integer codeDisplayNo) {
        regCodeDisplayNo(CK_LE, codeDisplayNo);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param minNumber The min number of codeDisplayNo. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of codeDisplayNo. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setCodeDisplayNo_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueCodeDisplayNo(), "CODE_DISPLAY_NO", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNoList The collection of codeDisplayNo as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeDisplayNo_InScope(Collection<Integer> codeDisplayNoList) {
        doSetCodeDisplayNo_InScope(codeDisplayNoList);
    }

    protected void doSetCodeDisplayNo_InScope(Collection<Integer> codeDisplayNoList) {
        regINS(CK_INS, cTL(codeDisplayNoList), getCValueCodeDisplayNo(), "CODE_DISPLAY_NO");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @param codeDisplayNoList The collection of codeDisplayNo as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeDisplayNo_NotInScope(Collection<Integer> codeDisplayNoList) {
        doSetCodeDisplayNo_NotInScope(codeDisplayNoList);
    }

    protected void doSetCodeDisplayNo_NotInScope(Collection<Integer> codeDisplayNoList) {
        regINS(CK_NINS, cTL(codeDisplayNoList), getCValueCodeDisplayNo(), "CODE_DISPLAY_NO");
    }

    protected void regCodeDisplayNo(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueCodeDisplayNo(), "CODE_DISPLAY_NO"); }
    protected abstract ConditionValue getCValueCodeDisplayNo();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_Equal(String codeComment) {
        doSetCodeComment_Equal(fRES(codeComment));
    }

    protected void doSetCodeComment_Equal(String codeComment) {
        regCodeComment(CK_EQ, codeComment);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_NotEqual(String codeComment) {
        doSetCodeComment_NotEqual(fRES(codeComment));
    }

    protected void doSetCodeComment_NotEqual(String codeComment) {
        regCodeComment(CK_NES, codeComment);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_GreaterThan(String codeComment) {
        regCodeComment(CK_GT, fRES(codeComment));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_LessThan(String codeComment) {
        regCodeComment(CK_LT, fRES(codeComment));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_GreaterEqual(String codeComment) {
        regCodeComment(CK_GE, fRES(codeComment));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_LessEqual(String codeComment) {
        regCodeComment(CK_LE, fRES(codeComment));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeCommentList The collection of codeComment as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_InScope(Collection<String> codeCommentList) {
        doSetCodeComment_InScope(codeCommentList);
    }

    public void doSetCodeComment_InScope(Collection<String> codeCommentList) {
        regINS(CK_INS, cTL(codeCommentList), getCValueCodeComment(), "CODE_COMMENT");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeCommentList The collection of codeComment as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_NotInScope(Collection<String> codeCommentList) {
        doSetCodeComment_NotInScope(codeCommentList);
    }

    public void doSetCodeComment_NotInScope(Collection<String> codeCommentList) {
        regINS(CK_NINS, cTL(codeCommentList), getCValueCodeComment(), "CODE_COMMENT");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeComment_PrefixSearch(String codeComment) {
        setCodeComment_LikeSearch(codeComment, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)} <br />
     * <pre>e.g. setCodeComment_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param codeComment The value of codeComment as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setCodeComment_LikeSearch(String codeComment, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(codeComment), getCValueCodeComment(), "CODE_COMMENT", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @param codeComment The value of codeComment as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setCodeComment_NotLikeSearch(String codeComment, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(codeComment), getCValueCodeComment(), "CODE_COMMENT", likeSearchOption);
    }

    protected void regCodeComment(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueCodeComment(), "CODE_COMMENT"); }
    protected abstract ConditionValue getCValueCodeComment();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_Equal(String codeAliasEn) {
        doSetCodeAliasEn_Equal(fRES(codeAliasEn));
    }

    protected void doSetCodeAliasEn_Equal(String codeAliasEn) {
        regCodeAliasEn(CK_EQ, codeAliasEn);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_NotEqual(String codeAliasEn) {
        doSetCodeAliasEn_NotEqual(fRES(codeAliasEn));
    }

    protected void doSetCodeAliasEn_NotEqual(String codeAliasEn) {
        regCodeAliasEn(CK_NES, codeAliasEn);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_GreaterThan(String codeAliasEn) {
        regCodeAliasEn(CK_GT, fRES(codeAliasEn));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_LessThan(String codeAliasEn) {
        regCodeAliasEn(CK_LT, fRES(codeAliasEn));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_GreaterEqual(String codeAliasEn) {
        regCodeAliasEn(CK_GE, fRES(codeAliasEn));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_LessEqual(String codeAliasEn) {
        regCodeAliasEn(CK_LE, fRES(codeAliasEn));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEnList The collection of codeAliasEn as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_InScope(Collection<String> codeAliasEnList) {
        doSetCodeAliasEn_InScope(codeAliasEnList);
    }

    public void doSetCodeAliasEn_InScope(Collection<String> codeAliasEnList) {
        regINS(CK_INS, cTL(codeAliasEnList), getCValueCodeAliasEn(), "CODE_ALIAS_EN");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEnList The collection of codeAliasEn as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_NotInScope(Collection<String> codeAliasEnList) {
        doSetCodeAliasEn_NotInScope(codeAliasEnList);
    }

    public void doSetCodeAliasEn_NotInScope(Collection<String> codeAliasEnList) {
        regINS(CK_NINS, cTL(codeAliasEnList), getCValueCodeAliasEn(), "CODE_ALIAS_EN");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setCodeAliasEn_PrefixSearch(String codeAliasEn) {
        setCodeAliasEn_LikeSearch(codeAliasEn, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)} <br />
     * <pre>e.g. setCodeAliasEn_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param codeAliasEn The value of codeAliasEn as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setCodeAliasEn_LikeSearch(String codeAliasEn, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(codeAliasEn), getCValueCodeAliasEn(), "CODE_ALIAS_EN", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @param codeAliasEn The value of codeAliasEn as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setCodeAliasEn_NotLikeSearch(String codeAliasEn, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(codeAliasEn), getCValueCodeAliasEn(), "CODE_ALIAS_EN", likeSearchOption);
    }

    protected void regCodeAliasEn(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueCodeAliasEn(), "CODE_ALIAS_EN"); }
    protected abstract ConditionValue getCValueCodeAliasEn();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *     public void query(ClsBlackCompanyStatusCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ClsBlackCompanyStatusCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ.getOperand(), ClsBlackCompanyStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *     public void query(ClsBlackCompanyStatusCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ClsBlackCompanyStatusCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES.getOperand(), ClsBlackCompanyStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *     public void query(ClsBlackCompanyStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ClsBlackCompanyStatusCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT.getOperand(), ClsBlackCompanyStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *     public void query(ClsBlackCompanyStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ClsBlackCompanyStatusCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT.getOperand(), ClsBlackCompanyStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *     public void query(ClsBlackCompanyStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ClsBlackCompanyStatusCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE.getOperand(), ClsBlackCompanyStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *     public void query(ClsBlackCompanyStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<ClsBlackCompanyStatusCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE.getOperand(), ClsBlackCompanyStatusCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        ClsBlackCompanyStatusCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(ClsBlackCompanyStatusCQ sq);

    protected ClsBlackCompanyStatusCB xcreateScalarConditionCB() {
        ClsBlackCompanyStatusCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected ClsBlackCompanyStatusCB xcreateScalarConditionPartitionByCB() {
        ClsBlackCompanyStatusCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<ClsBlackCompanyStatusCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "BLACK_COMPANY_STATUS_CD";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(ClsBlackCompanyStatusCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<ClsBlackCompanyStatusCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(ClsBlackCompanyStatusCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "BLACK_COMPANY_STATUS_CD";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(ClsBlackCompanyStatusCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<ClsBlackCompanyStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(ClsBlackCompanyStatusCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<ClsBlackCompanyStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(ClsBlackCompanyStatusCQ sq);

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
    protected ClsBlackCompanyStatusCB newMyCB() {
        return new ClsBlackCompanyStatusCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return ClsBlackCompanyStatusCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
