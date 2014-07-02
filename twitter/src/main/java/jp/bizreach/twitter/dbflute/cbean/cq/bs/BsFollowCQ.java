package jp.bizreach.twitter.dbflute.cbean.cq.bs;

import java.util.Map;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import jp.bizreach.twitter.dbflute.cbean.cq.ciq.*;
import jp.bizreach.twitter.dbflute.cbean.*;
import jp.bizreach.twitter.dbflute.cbean.cq.*;

/**
 * The base condition-query of follow.
 * @author DBFlute(AutoGenerator)
 */
public class BsFollowCQ extends AbstractBsFollowCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected FollowCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsFollowCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from follow) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public FollowCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected FollowCIQ xcreateCIQ() {
        FollowCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected FollowCIQ xnewCIQ() {
        return new FollowCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join follow on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public FollowCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        FollowCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _followId;
    public ConditionValue getFollowId()
    { if (_followId == null) { _followId = nCV(); }
      return _followId; }
    protected ConditionValue getCValueFollowId() { return getFollowId(); }

    /** 
     * Add order-by as ascend. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_FollowId_Asc() { regOBA("FOLLOW_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_FollowId_Desc() { regOBD("FOLLOW_ID"); return this; }

    protected ConditionValue _youId;
    public ConditionValue getYouId()
    { if (_youId == null) { _youId = nCV(); }
      return _youId; }
    protected ConditionValue getCValueYouId() { return getYouId(); }

    public Map<String, MemberCQ> getYouId_InScopeRelation_MemberByYouId() { return xgetSQueMap("youId_InScopeRelation_MemberByYouId"); }
    public String keepYouId_InScopeRelation_MemberByYouId(MemberCQ sq) { return xkeepSQue("youId_InScopeRelation_MemberByYouId", sq); }

    public Map<String, MemberCQ> getYouId_NotInScopeRelation_MemberByYouId() { return xgetSQueMap("youId_NotInScopeRelation_MemberByYouId"); }
    public String keepYouId_NotInScopeRelation_MemberByYouId(MemberCQ sq) { return xkeepSQue("youId_NotInScopeRelation_MemberByYouId", sq); }

    /** 
     * Add order-by as ascend. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_YouId_Asc() { regOBA("YOU_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_YouId_Desc() { regOBD("YOU_ID"); return this; }

    protected ConditionValue _memberId;
    public ConditionValue getMemberId()
    { if (_memberId == null) { _memberId = nCV(); }
      return _memberId; }
    protected ConditionValue getCValueMemberId() { return getMemberId(); }

    public Map<String, MemberCQ> getMemberId_InScopeRelation_MemberByMemberId() { return xgetSQueMap("memberId_InScopeRelation_MemberByMemberId"); }
    public String keepMemberId_InScopeRelation_MemberByMemberId(MemberCQ sq) { return xkeepSQue("memberId_InScopeRelation_MemberByMemberId", sq); }

    public Map<String, MemberCQ> getMemberId_NotInScopeRelation_MemberByMemberId() { return xgetSQueMap("memberId_NotInScopeRelation_MemberByMemberId"); }
    public String keepMemberId_NotInScopeRelation_MemberByMemberId(MemberCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_MemberByMemberId", sq); }

    /** 
     * Add order-by as ascend. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_MemberId_Asc() { regOBA("MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_MemberId_Desc() { regOBD("MEMBER_ID"); return this; }

    protected ConditionValue _insDatetime;
    public ConditionValue getInsDatetime()
    { if (_insDatetime == null) { _insDatetime = nCV(); }
      return _insDatetime; }
    protected ConditionValue getCValueInsDatetime() { return getInsDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_InsDatetime_Asc() { regOBA("INS_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_InsDatetime_Desc() { regOBD("INS_DATETIME"); return this; }

    protected ConditionValue _updDatetime;
    public ConditionValue getUpdDatetime()
    { if (_updDatetime == null) { _updDatetime = nCV(); }
      return _updDatetime; }
    protected ConditionValue getCValueUpdDatetime() { return getUpdDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_UpdDatetime_Asc() { regOBA("UPD_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_UpdDatetime_Desc() { regOBD("UPD_DATETIME"); return this; }

    protected ConditionValue _insTrace;
    public ConditionValue getInsTrace()
    { if (_insTrace == null) { _insTrace = nCV(); }
      return _insTrace; }
    protected ConditionValue getCValueInsTrace() { return getInsTrace(); }

    /** 
     * Add order-by as ascend. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_InsTrace_Asc() { regOBA("INS_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_InsTrace_Desc() { regOBD("INS_TRACE"); return this; }

    protected ConditionValue _updTrace;
    public ConditionValue getUpdTrace()
    { if (_updTrace == null) { _updTrace = nCV(); }
      return _updTrace; }
    protected ConditionValue getCValueUpdTrace() { return getUpdTrace(); }

    /** 
     * Add order-by as ascend. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_UpdTrace_Asc() { regOBA("UPD_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_UpdTrace_Desc() { regOBD("UPD_TRACE"); return this; }

    protected ConditionValue _delFlg;
    public ConditionValue getDelFlg()
    { if (_delFlg == null) { _delFlg = nCV(); }
      return _delFlg; }
    protected ConditionValue getCValueDelFlg() { return getDelFlg(); }

    /** 
     * Add order-by as ascend. <br />
     * DEL_FLG: {NotNull, CHAR(1), default=[N]}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_DelFlg_Asc() { regOBA("DEL_FLG"); return this; }

    /**
     * Add order-by as descend. <br />
     * DEL_FLG: {NotNull, CHAR(1), default=[N]}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_DelFlg_Desc() { regOBD("DEL_FLG"); return this; }

    // ===================================================================================
    //                                                             SpecifiedDerivedOrderBy
    //                                                             =======================
    /**
     * Add order-by for specified derived column as ascend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #DD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] asc</span>
     * cb.<span style="color: #DD4747">addSpecifiedDerivedOrderBy_Asc</span>(<span style="color: #DD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsFollowCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

    /**
     * Add order-by for specified derived column as descend.
     * <pre>
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *     }
     * }, <span style="color: #DD4747">aliasName</span>);
     * <span style="color: #3F7E5E">// order by [alias-name] desc</span>
     * cb.<span style="color: #DD4747">addSpecifiedDerivedOrderBy_Desc</span>(<span style="color: #DD4747">aliasName</span>);
     * </pre>
     * @param aliasName The alias name specified at (Specify)DerivedReferrer. (NotNull)
     * @return this. (NotNull)
     */
    public BsFollowCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        FollowCQ bq = (FollowCQ)bqs;
        FollowCQ uq = (FollowCQ)uqs;
        if (bq.hasConditionQueryMemberByYouId()) {
            uq.queryMemberByYouId().reflectRelationOnUnionQuery(bq.queryMemberByYouId(), uq.queryMemberByYouId());
        }
        if (bq.hasConditionQueryMemberByMemberId()) {
            uq.queryMemberByMemberId().reflectRelationOnUnionQuery(bq.queryMemberByMemberId(), uq.queryMemberByMemberId());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * member by my YOU_ID, named 'memberByYouId'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMemberByYouId() {
        return getConditionQueryMemberByYouId();
    }
    public MemberCQ getConditionQueryMemberByYouId() {
        String prop = "memberByYouId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberByYouId()); xsetupOuterJoinMemberByYouId(); }
        return xgetQueRlMap(prop);
    }
    protected MemberCQ xcreateQueryMemberByYouId() {
        String nrp = xresolveNRP("follow", "memberByYouId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberByYouId", nrp);
    }
    protected void xsetupOuterJoinMemberByYouId() { xregOutJo("memberByYouId"); }
    public boolean hasConditionQueryMemberByYouId() { return xhasQueRlMap("memberByYouId"); }

    /**
     * Get the condition-query for relation table. <br />
     * member by my MEMBER_ID, named 'memberByMemberId'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMemberByMemberId() {
        return getConditionQueryMemberByMemberId();
    }
    public MemberCQ getConditionQueryMemberByMemberId() {
        String prop = "memberByMemberId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberByMemberId()); xsetupOuterJoinMemberByMemberId(); }
        return xgetQueRlMap(prop);
    }
    protected MemberCQ xcreateQueryMemberByMemberId() {
        String nrp = xresolveNRP("follow", "memberByMemberId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberByMemberId", nrp);
    }
    protected void xsetupOuterJoinMemberByMemberId() { xregOutJo("memberByMemberId"); }
    public boolean hasConditionQueryMemberByMemberId() { return xhasQueRlMap("memberByMemberId"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, FollowCQ> getScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(FollowCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, FollowCQ> getSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(FollowCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, FollowCQ> getQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(FollowCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> getQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, FollowCQ> _myselfExistsMap;
    public Map<String, FollowCQ> getMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(FollowCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, FollowCQ> getMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(FollowCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return FollowCB.class.getName(); }
    protected String xCQ() { return FollowCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
