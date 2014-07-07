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
 * The abstract condition-query of member_status.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsMemberStatusCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsMemberStatusCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "member_status";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCode The value of memberStatusCode as equal. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_Equal(Integer memberStatusCode) {
        doSetMemberStatusCode_Equal(memberStatusCode);
    }

    protected void doSetMemberStatusCode_Equal(Integer memberStatusCode) {
        regMemberStatusCode(CK_EQ, memberStatusCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCode The value of memberStatusCode as notEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_NotEqual(Integer memberStatusCode) {
        doSetMemberStatusCode_NotEqual(memberStatusCode);
    }

    protected void doSetMemberStatusCode_NotEqual(Integer memberStatusCode) {
        regMemberStatusCode(CK_NES, memberStatusCode);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCode The value of memberStatusCode as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_GreaterThan(Integer memberStatusCode) {
        regMemberStatusCode(CK_GT, memberStatusCode);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCode The value of memberStatusCode as lessThan. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_LessThan(Integer memberStatusCode) {
        regMemberStatusCode(CK_LT, memberStatusCode);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCode The value of memberStatusCode as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_GreaterEqual(Integer memberStatusCode) {
        regMemberStatusCode(CK_GE, memberStatusCode);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCode The value of memberStatusCode as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_LessEqual(Integer memberStatusCode) {
        regMemberStatusCode(CK_LE, memberStatusCode);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param minNumber The min number of memberStatusCode. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of memberStatusCode. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setMemberStatusCode_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueMemberStatusCode(), "MEMBER_STATUS_CODE", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCodeList The collection of memberStatusCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_InScope(Collection<Integer> memberStatusCodeList) {
        doSetMemberStatusCode_InScope(memberStatusCodeList);
    }

    protected void doSetMemberStatusCode_InScope(Collection<Integer> memberStatusCodeList) {
        regINS(CK_INS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     * @param memberStatusCodeList The collection of memberStatusCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_NotInScope(Collection<Integer> memberStatusCodeList) {
        doSetMemberStatusCode_NotInScope(memberStatusCodeList);
    }

    protected void doSetMemberStatusCode_NotInScope(Collection<Integer> memberStatusCodeList) {
        regINS(CK_NINS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_STATUS_CODE from member where ...)} <br />
     * member by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsMemberList</span>(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberList for 'exists'. (NotNull)
     */
    public void existsMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberStatusCode_ExistsReferrer_MemberList(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberList");
    }
    public abstract String keepMemberStatusCode_ExistsReferrer_MemberList(MemberCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_STATUS_CODE from member where ...)} <br />
     * member by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsMemberList</span>(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberStatusCode_NotExistsReferrer_MemberList for 'not exists'. (NotNull)
     */
    public void notExistsMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberStatusCode_NotExistsReferrer_MemberList(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberList");
    }
    public abstract String keepMemberStatusCode_NotExistsReferrer_MemberList(MemberCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_STATUS_CODE from member where ...)} <br />
     * member by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * @param subQuery The sub-query of MemberList for 'in-scope'. (NotNull)
     */
    public void inScopeMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberStatusCode_InScopeRelation_MemberList(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberList");
    }
    public abstract String keepMemberStatusCode_InScopeRelation_MemberList(MemberCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_STATUS_CODE from member where ...)} <br />
     * member by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * @param subQuery The sub-query of MemberList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberList(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberStatusCode_NotInScopeRelation_MemberList(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberList");
    }
    public abstract String keepMemberStatusCode_NotInScopeRelation_MemberList(MemberCQ sq);

    public void xsderiveMemberList(String fn, SubQuery<MemberCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberStatusCode_SpecifyDerivedReferrer_MemberList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberList", al, op);
    }
    public abstract String keepMemberStatusCode_SpecifyDerivedReferrer_MemberList(MemberCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br />
     * {FOO &lt;= (select max(BAR) from member where ...)} <br />
     * member by MEMBER_STATUS_CODE, named 'memberAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedMemberList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MemberCB> derivedMemberList() {
        return xcreateQDRFunctionMemberList();
    }
    protected HpQDRFunction<MemberCB> xcreateQDRFunctionMemberList() {
        return new HpQDRFunction<MemberCB>(new HpQDRSetupper<MemberCB>() {
            public void setup(String fn, SubQuery<MemberCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveMemberList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveMemberList(String fn, SubQuery<MemberCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepMemberStatusCode_QueryDerivedReferrer_MemberList(cb.query()); String prpp = keepMemberStatusCode_QueryDerivedReferrer_MemberListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", sqpp, "memberList", rd, vl, prpp, op);
    }
    public abstract String keepMemberStatusCode_QueryDerivedReferrer_MemberList(MemberCQ sq);
    public abstract String keepMemberStatusCode_QueryDerivedReferrer_MemberListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     */
    public void setMemberStatusCode_IsNull() { regMemberStatusCode(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {PK, NotNull, INT(10)}
     */
    public void setMemberStatusCode_IsNotNull() { regMemberStatusCode(CK_ISNN, DOBJ); }

    protected void regMemberStatusCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberStatusCode(), "MEMBER_STATUS_CODE"); }
    protected abstract ConditionValue getCValueMemberStatusCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_Equal(String memberStatusName) {
        doSetMemberStatusName_Equal(fRES(memberStatusName));
    }

    protected void doSetMemberStatusName_Equal(String memberStatusName) {
        regMemberStatusName(CK_EQ, memberStatusName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_NotEqual(String memberStatusName) {
        doSetMemberStatusName_NotEqual(fRES(memberStatusName));
    }

    protected void doSetMemberStatusName_NotEqual(String memberStatusName) {
        regMemberStatusName(CK_NES, memberStatusName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_GreaterThan(String memberStatusName) {
        regMemberStatusName(CK_GT, fRES(memberStatusName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_LessThan(String memberStatusName) {
        regMemberStatusName(CK_LT, fRES(memberStatusName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_GreaterEqual(String memberStatusName) {
        regMemberStatusName(CK_GE, fRES(memberStatusName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_LessEqual(String memberStatusName) {
        regMemberStatusName(CK_LE, fRES(memberStatusName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusNameList The collection of memberStatusName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_InScope(Collection<String> memberStatusNameList) {
        doSetMemberStatusName_InScope(memberStatusNameList);
    }

    public void doSetMemberStatusName_InScope(Collection<String> memberStatusNameList) {
        regINS(CK_INS, cTL(memberStatusNameList), getCValueMemberStatusName(), "MEMBER_STATUS_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusNameList The collection of memberStatusName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_NotInScope(Collection<String> memberStatusNameList) {
        doSetMemberStatusName_NotInScope(memberStatusNameList);
    }

    public void doSetMemberStatusName_NotInScope(Collection<String> memberStatusNameList) {
        regINS(CK_NINS, cTL(memberStatusNameList), getCValueMemberStatusName(), "MEMBER_STATUS_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusName_PrefixSearch(String memberStatusName) {
        setMemberStatusName_LikeSearch(memberStatusName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)} <br />
     * <pre>e.g. setMemberStatusName_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param memberStatusName The value of memberStatusName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMemberStatusName_LikeSearch(String memberStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(memberStatusName), getCValueMemberStatusName(), "MEMBER_STATUS_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_NAME: {NotNull, VARCHAR(20)}
     * @param memberStatusName The value of memberStatusName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMemberStatusName_NotLikeSearch(String memberStatusName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(memberStatusName), getCValueMemberStatusName(), "MEMBER_STATUS_NAME", likeSearchOption);
    }

    protected void regMemberStatusName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberStatusName(), "MEMBER_STATUS_NAME"); }
    protected abstract ConditionValue getCValueMemberStatusName();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, MemberStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, MemberStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, MemberStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, MemberStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, MemberStatusCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberStatusCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, MemberStatusCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        MemberStatusCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(MemberStatusCQ sq);

    protected MemberStatusCB xcreateScalarConditionCB() {
        MemberStatusCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected MemberStatusCB xcreateScalarConditionPartitionByCB() {
        MemberStatusCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<MemberStatusCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "MEMBER_STATUS_CODE";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(MemberStatusCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<MemberStatusCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(MemberStatusCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "MEMBER_STATUS_CODE";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(MemberStatusCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(MemberStatusCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(MemberStatusCQ sq);

    /**
     * Order along manual ordering information.
     * <pre>
     * MemberCB cb = new MemberCB();
     * ManualOrderBean mob = new ManualOrderBean();
     * mob.<span style="color: #DD4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #DD4747">withManualOrder(mob)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * MemberCB cb = new MemberCB();
     * ManualOrderBean mob = new ManualOrderBean();
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #DD4747">withManualOrder(mob)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param mob The bean of manual order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderBean mob) { // is user public!
        xdoWithManualOrder(mob);
    }

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
    protected MemberStatusCB newMyCB() {
        return new MemberStatusCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return MemberStatusCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
