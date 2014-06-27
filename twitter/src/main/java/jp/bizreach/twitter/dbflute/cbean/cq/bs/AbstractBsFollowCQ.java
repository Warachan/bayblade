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
 * The abstract condition-query of follow.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsFollowCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsFollowCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "follow";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followId The value of followId as equal. (NullAllowed: if null, no condition)
     */
    public void setFollowId_Equal(Integer followId) {
        doSetFollowId_Equal(followId);
    }

    protected void doSetFollowId_Equal(Integer followId) {
        regFollowId(CK_EQ, followId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followId The value of followId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setFollowId_NotEqual(Integer followId) {
        doSetFollowId_NotEqual(followId);
    }

    protected void doSetFollowId_NotEqual(Integer followId) {
        regFollowId(CK_NES, followId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followId The value of followId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setFollowId_GreaterThan(Integer followId) {
        regFollowId(CK_GT, followId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followId The value of followId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setFollowId_LessThan(Integer followId) {
        regFollowId(CK_LT, followId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followId The value of followId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setFollowId_GreaterEqual(Integer followId) {
        regFollowId(CK_GE, followId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followId The value of followId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setFollowId_LessEqual(Integer followId) {
        regFollowId(CK_LE, followId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param minNumber The min number of followId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of followId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setFollowId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueFollowId(), "FOLLOW_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followIdList The collection of followId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setFollowId_InScope(Collection<Integer> followIdList) {
        doSetFollowId_InScope(followIdList);
    }

    protected void doSetFollowId_InScope(Collection<Integer> followIdList) {
        regINS(CK_INS, cTL(followIdList), getCValueFollowId(), "FOLLOW_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @param followIdList The collection of followId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setFollowId_NotInScope(Collection<Integer> followIdList) {
        doSetFollowId_NotInScope(followIdList);
    }

    protected void doSetFollowId_NotInScope(Collection<Integer> followIdList) {
        regINS(CK_NINS, cTL(followIdList), getCValueFollowId(), "FOLLOW_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setFollowId_IsNull() { regFollowId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setFollowId_IsNotNull() { regFollowId(CK_ISNN, DOBJ); }

    protected void regFollowId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueFollowId(), "FOLLOW_ID"); }
    protected abstract ConditionValue getCValueFollowId();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youId The value of youId as equal. (NullAllowed: if null, no condition)
     */
    public void setYouId_Equal(Integer youId) {
        doSetYouId_Equal(youId);
    }

    protected void doSetYouId_Equal(Integer youId) {
        regYouId(CK_EQ, youId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youId The value of youId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setYouId_NotEqual(Integer youId) {
        doSetYouId_NotEqual(youId);
    }

    protected void doSetYouId_NotEqual(Integer youId) {
        regYouId(CK_NES, youId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youId The value of youId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setYouId_GreaterThan(Integer youId) {
        regYouId(CK_GT, youId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youId The value of youId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setYouId_LessThan(Integer youId) {
        regYouId(CK_LT, youId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youId The value of youId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setYouId_GreaterEqual(Integer youId) {
        regYouId(CK_GE, youId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youId The value of youId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setYouId_LessEqual(Integer youId) {
        regYouId(CK_LE, youId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param minNumber The min number of youId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of youId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setYouId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueYouId(), "YOU_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youIdList The collection of youId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setYouId_InScope(Collection<Integer> youIdList) {
        doSetYouId_InScope(youIdList);
    }

    protected void doSetYouId_InScope(Collection<Integer> youIdList) {
        regINS(CK_INS, cTL(youIdList), getCValueYouId(), "YOU_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @param youIdList The collection of youId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setYouId_NotInScope(Collection<Integer> youIdList) {
        doSetYouId_NotInScope(youIdList);
    }

    protected void doSetYouId_NotInScope(Collection<Integer> youIdList) {
        regINS(CK_NINS, cTL(youIdList), getCValueYouId(), "YOU_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select YOU_ID from member where ...)} <br />
     * member by my YOU_ID, named 'memberByYouId'.
     * @param subQuery The sub-query of MemberByYouId for 'in-scope'. (NotNull)
     */
    public void inScopeMemberByYouId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepYouId_InScopeRelation_MemberByYouId(cb.query());
        registerInScopeRelation(cb.query(), "YOU_ID", "MEMBER_ID", pp, "memberByYouId");
    }
    public abstract String keepYouId_InScopeRelation_MemberByYouId(MemberCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select YOU_ID from member where ...)} <br />
     * member by my YOU_ID, named 'memberByYouId'.
     * @param subQuery The sub-query of MemberByYouId for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberByYouId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepYouId_NotInScopeRelation_MemberByYouId(cb.query());
        registerNotInScopeRelation(cb.query(), "YOU_ID", "MEMBER_ID", pp, "memberByYouId");
    }
    public abstract String keepYouId_NotInScopeRelation_MemberByYouId(MemberCQ sq);

    protected void regYouId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueYouId(), "YOU_ID"); }
    protected abstract ConditionValue getCValueYouId();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meId The value of meId as equal. (NullAllowed: if null, no condition)
     */
    public void setMeId_Equal(Integer meId) {
        doSetMeId_Equal(meId);
    }

    protected void doSetMeId_Equal(Integer meId) {
        regMeId(CK_EQ, meId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meId The value of meId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setMeId_NotEqual(Integer meId) {
        doSetMeId_NotEqual(meId);
    }

    protected void doSetMeId_NotEqual(Integer meId) {
        regMeId(CK_NES, meId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meId The value of meId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setMeId_GreaterThan(Integer meId) {
        regMeId(CK_GT, meId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meId The value of meId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setMeId_LessThan(Integer meId) {
        regMeId(CK_LT, meId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meId The value of meId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setMeId_GreaterEqual(Integer meId) {
        regMeId(CK_GE, meId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meId The value of meId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setMeId_LessEqual(Integer meId) {
        regMeId(CK_LE, meId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param minNumber The min number of meId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of meId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setMeId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueMeId(), "ME_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meIdList The collection of meId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMeId_InScope(Collection<Integer> meIdList) {
        doSetMeId_InScope(meIdList);
    }

    protected void doSetMeId_InScope(Collection<Integer> meIdList) {
        regINS(CK_INS, cTL(meIdList), getCValueMeId(), "ME_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @param meIdList The collection of meId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMeId_NotInScope(Collection<Integer> meIdList) {
        doSetMeId_NotInScope(meIdList);
    }

    protected void doSetMeId_NotInScope(Collection<Integer> meIdList) {
        regINS(CK_NINS, cTL(meIdList), getCValueMeId(), "ME_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select ME_ID from member where ...)} <br />
     * member by my ME_ID, named 'memberByMeId'.
     * @param subQuery The sub-query of MemberByMeId for 'in-scope'. (NotNull)
     */
    public void inScopeMemberByMeId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMeId_InScopeRelation_MemberByMeId(cb.query());
        registerInScopeRelation(cb.query(), "ME_ID", "MEMBER_ID", pp, "memberByMeId");
    }
    public abstract String keepMeId_InScopeRelation_MemberByMeId(MemberCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select ME_ID from member where ...)} <br />
     * member by my ME_ID, named 'memberByMeId'.
     * @param subQuery The sub-query of MemberByMeId for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberByMeId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMeId_NotInScopeRelation_MemberByMeId(cb.query());
        registerNotInScopeRelation(cb.query(), "ME_ID", "MEMBER_ID", pp, "memberByMeId");
    }
    public abstract String keepMeId_NotInScopeRelation_MemberByMeId(MemberCQ sq);

    protected void regMeId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMeId(), "ME_ID"); }
    protected abstract ConditionValue getCValueMeId();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @param followDatetime The value of followDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setFollowDatetime_Equal(java.sql.Timestamp followDatetime) {
        regFollowDatetime(CK_EQ,  followDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @param followDatetime The value of followDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setFollowDatetime_GreaterThan(java.sql.Timestamp followDatetime) {
        regFollowDatetime(CK_GT,  followDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @param followDatetime The value of followDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setFollowDatetime_LessThan(java.sql.Timestamp followDatetime) {
        regFollowDatetime(CK_LT,  followDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @param followDatetime The value of followDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setFollowDatetime_GreaterEqual(java.sql.Timestamp followDatetime) {
        regFollowDatetime(CK_GE,  followDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @param followDatetime The value of followDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setFollowDatetime_LessEqual(java.sql.Timestamp followDatetime) {
        regFollowDatetime(CK_LE, followDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setFollowDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of followDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of followDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setFollowDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueFollowDatetime(), "FOLLOW_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of followDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of followDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setFollowDatetime_DateFromTo(Date fromDate, Date toDate) {
        setFollowDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    protected void regFollowDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueFollowDatetime(), "FOLLOW_DATETIME"); }
    protected abstract ConditionValue getCValueFollowDatetime();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<FollowCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, FollowCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<FollowCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, FollowCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<FollowCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, FollowCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<FollowCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, FollowCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<FollowCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, FollowCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<FollowCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, FollowCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        FollowCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(FollowCQ sq);

    protected FollowCB xcreateScalarConditionCB() {
        FollowCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected FollowCB xcreateScalarConditionPartitionByCB() {
        FollowCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<FollowCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FollowCB cb = new FollowCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "FOLLOW_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(FollowCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<FollowCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(FollowCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FollowCB cb = new FollowCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "FOLLOW_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(FollowCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(FollowCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(FollowCQ sq);

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
    protected FollowCB newMyCB() {
        return new FollowCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return FollowCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
