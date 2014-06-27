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

    protected ConditionValue _meId;
    public ConditionValue getMeId()
    { if (_meId == null) { _meId = nCV(); }
      return _meId; }
    protected ConditionValue getCValueMeId() { return getMeId(); }

    public Map<String, MemberCQ> getMeId_InScopeRelation_MemberByMeId() { return xgetSQueMap("meId_InScopeRelation_MemberByMeId"); }
    public String keepMeId_InScopeRelation_MemberByMeId(MemberCQ sq) { return xkeepSQue("meId_InScopeRelation_MemberByMeId", sq); }

    public Map<String, MemberCQ> getMeId_NotInScopeRelation_MemberByMeId() { return xgetSQueMap("meId_NotInScopeRelation_MemberByMeId"); }
    public String keepMeId_NotInScopeRelation_MemberByMeId(MemberCQ sq) { return xkeepSQue("meId_NotInScopeRelation_MemberByMeId", sq); }

    /** 
     * Add order-by as ascend. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_MeId_Asc() { regOBA("ME_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_MeId_Desc() { regOBD("ME_ID"); return this; }

    protected ConditionValue _followDatetime;
    public ConditionValue getFollowDatetime()
    { if (_followDatetime == null) { _followDatetime = nCV(); }
      return _followDatetime; }
    protected ConditionValue getCValueFollowDatetime() { return getFollowDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_FollowDatetime_Asc() { regOBA("FOLLOW_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsFollowCQ addOrderBy_FollowDatetime_Desc() { regOBD("FOLLOW_DATETIME"); return this; }

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
        if (bq.hasConditionQueryMemberByMeId()) {
            uq.queryMemberByMeId().reflectRelationOnUnionQuery(bq.queryMemberByMeId(), uq.queryMemberByMeId());
        }
        if (bq.hasConditionQueryMemberByYouId()) {
            uq.queryMemberByYouId().reflectRelationOnUnionQuery(bq.queryMemberByYouId(), uq.queryMemberByYouId());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * member by my ME_ID, named 'memberByMeId'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMemberByMeId() {
        return getConditionQueryMemberByMeId();
    }
    public MemberCQ getConditionQueryMemberByMeId() {
        String prop = "memberByMeId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberByMeId()); xsetupOuterJoinMemberByMeId(); }
        return xgetQueRlMap(prop);
    }
    protected MemberCQ xcreateQueryMemberByMeId() {
        String nrp = xresolveNRP("follow", "memberByMeId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberByMeId", nrp);
    }
    protected void xsetupOuterJoinMemberByMeId() { xregOutJo("memberByMeId"); }
    public boolean hasConditionQueryMemberByMeId() { return xhasQueRlMap("memberByMeId"); }

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
