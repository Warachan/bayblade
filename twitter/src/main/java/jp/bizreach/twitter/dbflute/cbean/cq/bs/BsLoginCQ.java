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
 * The base condition-query of login.
 * @author DBFlute(AutoGenerator)
 */
public class BsLoginCQ extends AbstractBsLoginCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected LoginCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsLoginCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from login) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public LoginCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected LoginCIQ xcreateCIQ() {
        LoginCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected LoginCIQ xnewCIQ() {
        return new LoginCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join login on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public LoginCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        LoginCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _loginId;
    public ConditionValue getLoginId()
    { if (_loginId == null) { _loginId = nCV(); }
      return _loginId; }
    protected ConditionValue getCValueLoginId() { return getLoginId(); }

    /** 
     * Add order-by as ascend. <br />
     * LOGIN_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_LoginId_Asc() { regOBA("LOGIN_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * LOGIN_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_LoginId_Desc() { regOBD("LOGIN_ID"); return this; }

    protected ConditionValue _memberId;
    public ConditionValue getMemberId()
    { if (_memberId == null) { _memberId = nCV(); }
      return _memberId; }
    protected ConditionValue getCValueMemberId() { return getMemberId(); }

    public Map<String, MemberCQ> getMemberId_InScopeRelation_Member() { return xgetSQueMap("memberId_InScopeRelation_Member"); }
    public String keepMemberId_InScopeRelation_Member(MemberCQ sq) { return xkeepSQue("memberId_InScopeRelation_Member", sq); }

    public Map<String, MemberCQ> getMemberId_NotInScopeRelation_Member() { return xgetSQueMap("memberId_NotInScopeRelation_Member"); }
    public String keepMemberId_NotInScopeRelation_Member(MemberCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_Member", sq); }

    /** 
     * Add order-by as ascend. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_MemberId_Asc() { regOBA("MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_MemberId_Desc() { regOBD("MEMBER_ID"); return this; }

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
    public BsLoginCQ addOrderBy_InsDatetime_Asc() { regOBA("INS_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_InsDatetime_Desc() { regOBD("INS_DATETIME"); return this; }

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
    public BsLoginCQ addOrderBy_UpdDatetime_Asc() { regOBA("UPD_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_UpdDatetime_Desc() { regOBD("UPD_DATETIME"); return this; }

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
    public BsLoginCQ addOrderBy_InsTrace_Asc() { regOBA("INS_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_InsTrace_Desc() { regOBD("INS_TRACE"); return this; }

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
    public BsLoginCQ addOrderBy_UpdTrace_Asc() { regOBA("UPD_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsLoginCQ addOrderBy_UpdTrace_Desc() { regOBD("UPD_TRACE"); return this; }

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
    public BsLoginCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsLoginCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        LoginCQ bq = (LoginCQ)bqs;
        LoginCQ uq = (LoginCQ)uqs;
        if (bq.hasConditionQueryMember()) {
            uq.queryMember().reflectRelationOnUnionQuery(bq.queryMember(), uq.queryMember());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * member by my MEMBER_ID, named 'member'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMember() {
        return getConditionQueryMember();
    }
    public MemberCQ getConditionQueryMember() {
        String prop = "member";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMember()); xsetupOuterJoinMember(); }
        return xgetQueRlMap(prop);
    }
    protected MemberCQ xcreateQueryMember() {
        String nrp = xresolveNRP("login", "member"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "member", nrp);
    }
    protected void xsetupOuterJoinMember() { xregOutJo("member"); }
    public boolean hasConditionQueryMember() { return xhasQueRlMap("member"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, LoginCQ> getScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(LoginCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, LoginCQ> getSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(LoginCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, LoginCQ> getQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(LoginCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> getQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, LoginCQ> _myselfExistsMap;
    public Map<String, LoginCQ> getMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(LoginCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, LoginCQ> getMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(LoginCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return LoginCB.class.getName(); }
    protected String xCQ() { return LoginCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
