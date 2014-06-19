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
 * The base condition-query of black_company.
 * @author DBFlute(AutoGenerator)
 */
public class BsBlackCompanyCQ extends AbstractBsBlackCompanyCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BlackCompanyCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsBlackCompanyCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from black_company) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public BlackCompanyCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected BlackCompanyCIQ xcreateCIQ() {
        BlackCompanyCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected BlackCompanyCIQ xnewCIQ() {
        return new BlackCompanyCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join black_company on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public BlackCompanyCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        BlackCompanyCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _blackCompanyId;
    public ConditionValue getBlackCompanyId() {
        if (_blackCompanyId == null) { _blackCompanyId = nCV(); }
        return _blackCompanyId;
    }
    protected ConditionValue getCValueBlackCompanyId() { return getBlackCompanyId(); }

    /** 
     * Add order-by as ascend. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_BlackCompanyId_Asc() { regOBA("BLACK_COMPANY_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_BlackCompanyId_Desc() { regOBD("BLACK_COMPANY_ID"); return this; }

    protected ConditionValue _blackCompanyName;
    public ConditionValue getBlackCompanyName() {
        if (_blackCompanyName == null) { _blackCompanyName = nCV(); }
        return _blackCompanyName;
    }
    protected ConditionValue getCValueBlackCompanyName() { return getBlackCompanyName(); }

    /** 
     * Add order-by as ascend. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_BlackCompanyName_Asc() { regOBA("BLACK_COMPANY_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_BlackCompanyName_Desc() { regOBD("BLACK_COMPANY_NAME"); return this; }

    protected ConditionValue _agentCompanyName;
    public ConditionValue getAgentCompanyName() {
        if (_agentCompanyName == null) { _agentCompanyName = nCV(); }
        return _agentCompanyName;
    }
    protected ConditionValue getCValueAgentCompanyName() { return getAgentCompanyName(); }

    /** 
     * Add order-by as ascend. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_AgentCompanyName_Asc() { regOBA("AGENT_COMPANY_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_AgentCompanyName_Desc() { regOBD("AGENT_COMPANY_NAME"); return this; }

    protected ConditionValue _zipCode;
    public ConditionValue getZipCode() {
        if (_zipCode == null) { _zipCode = nCV(); }
        return _zipCode;
    }
    protected ConditionValue getCValueZipCode() { return getZipCode(); }

    /** 
     * Add order-by as ascend. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_ZipCode_Asc() { regOBA("ZIP_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_ZipCode_Desc() { regOBD("ZIP_CODE"); return this; }

    protected ConditionValue _address1;
    public ConditionValue getAddress1() {
        if (_address1 == null) { _address1 = nCV(); }
        return _address1;
    }
    protected ConditionValue getCValueAddress1() { return getAddress1(); }

    /** 
     * Add order-by as ascend. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_Address1_Asc() { regOBA("ADDRESS1"); return this; }

    /**
     * Add order-by as descend. <br />
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_Address1_Desc() { regOBD("ADDRESS1"); return this; }

    protected ConditionValue _address2;
    public ConditionValue getAddress2() {
        if (_address2 == null) { _address2 = nCV(); }
        return _address2;
    }
    protected ConditionValue getCValueAddress2() { return getAddress2(); }

    /** 
     * Add order-by as ascend. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_Address2_Asc() { regOBA("ADDRESS2"); return this; }

    /**
     * Add order-by as descend. <br />
     * ADDRESS2: {VARCHAR(1024)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_Address2_Desc() { regOBD("ADDRESS2"); return this; }

    protected ConditionValue _blackCompanyStatusCd;
    public ConditionValue getBlackCompanyStatusCd() {
        if (_blackCompanyStatusCd == null) { _blackCompanyStatusCd = nCV(); }
        return _blackCompanyStatusCd;
    }
    protected ConditionValue getCValueBlackCompanyStatusCd() { return getBlackCompanyStatusCd(); }

    protected Map<String, ClsBlackCompanyStatusCQ> _blackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatusMap;
    public Map<String, ClsBlackCompanyStatusCQ> getBlackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatus() { return _blackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatusMap; }
    public String keepBlackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatus(ClsBlackCompanyStatusCQ sq) {
        if (_blackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatusMap == null) { _blackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatusMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatusMap.size() + 1);
        _blackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatusMap.put(ky, sq); return "blackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatus." + ky;
    }

    protected Map<String, ClsBlackCompanyStatusCQ> _blackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatusMap;
    public Map<String, ClsBlackCompanyStatusCQ> getBlackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatus() { return _blackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatusMap; }
    public String keepBlackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatus(ClsBlackCompanyStatusCQ sq) {
        if (_blackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatusMap == null) { _blackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatusMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatusMap.size() + 1);
        _blackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatusMap.put(ky, sq); return "blackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatus." + ky;
    }

    /** 
     * Add order-by as ascend. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_BlackCompanyStatusCd_Asc() { regOBA("BLACK_COMPANY_STATUS_CD"); return this; }

    /**
     * Add order-by as descend. <br />
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_BlackCompanyStatusCd_Desc() { regOBD("BLACK_COMPANY_STATUS_CD"); return this; }

    protected ConditionValue _insDatetime;
    public ConditionValue getInsDatetime() {
        if (_insDatetime == null) { _insDatetime = nCV(); }
        return _insDatetime;
    }
    protected ConditionValue getCValueInsDatetime() { return getInsDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_InsDatetime_Asc() { regOBA("INS_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_InsDatetime_Desc() { regOBD("INS_DATETIME"); return this; }

    protected ConditionValue _updDatetime;
    public ConditionValue getUpdDatetime() {
        if (_updDatetime == null) { _updDatetime = nCV(); }
        return _updDatetime;
    }
    protected ConditionValue getCValueUpdDatetime() { return getUpdDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_UpdDatetime_Asc() { regOBA("UPD_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_UpdDatetime_Desc() { regOBD("UPD_DATETIME"); return this; }

    protected ConditionValue _insTrace;
    public ConditionValue getInsTrace() {
        if (_insTrace == null) { _insTrace = nCV(); }
        return _insTrace;
    }
    protected ConditionValue getCValueInsTrace() { return getInsTrace(); }

    /** 
     * Add order-by as ascend. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_InsTrace_Asc() { regOBA("INS_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_InsTrace_Desc() { regOBD("INS_TRACE"); return this; }

    protected ConditionValue _updTrace;
    public ConditionValue getUpdTrace() {
        if (_updTrace == null) { _updTrace = nCV(); }
        return _updTrace;
    }
    protected ConditionValue getCValueUpdTrace() { return getUpdTrace(); }

    /** 
     * Add order-by as ascend. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_UpdTrace_Asc() { regOBA("UPD_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_UpdTrace_Desc() { regOBD("UPD_TRACE"); return this; }

    protected ConditionValue _versionNo;
    public ConditionValue getVersionNo() {
        if (_versionNo == null) { _versionNo = nCV(); }
        return _versionNo;
    }
    protected ConditionValue getCValueVersionNo() { return getVersionNo(); }

    /** 
     * Add order-by as ascend. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_VersionNo_Asc() { regOBA("VERSION_NO"); return this; }

    /**
     * Add order-by as descend. <br />
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return this. (NotNull)
     */
    public BsBlackCompanyCQ addOrderBy_VersionNo_Desc() { regOBD("VERSION_NO"); return this; }

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
    public BsBlackCompanyCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsBlackCompanyCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        BlackCompanyCQ bq = (BlackCompanyCQ)bqs;
        BlackCompanyCQ uq = (BlackCompanyCQ)uqs;
        if (bq.hasConditionQueryClsBlackCompanyStatus()) {
            uq.queryClsBlackCompanyStatus().reflectRelationOnUnionQuery(bq.queryClsBlackCompanyStatus(), uq.queryClsBlackCompanyStatus());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'.
     * @return The instance of condition-query. (NotNull)
     */
    public ClsBlackCompanyStatusCQ queryClsBlackCompanyStatus() {
        return getConditionQueryClsBlackCompanyStatus();
    }
    protected ClsBlackCompanyStatusCQ _conditionQueryClsBlackCompanyStatus;
    public ClsBlackCompanyStatusCQ getConditionQueryClsBlackCompanyStatus() {
        if (_conditionQueryClsBlackCompanyStatus == null) {
            _conditionQueryClsBlackCompanyStatus = xcreateQueryClsBlackCompanyStatus();
            xsetupOuterJoinClsBlackCompanyStatus();
        }
        return _conditionQueryClsBlackCompanyStatus;
    }
    protected ClsBlackCompanyStatusCQ xcreateQueryClsBlackCompanyStatus() {
        String nrp = resolveNextRelationPath("black_company", "clsBlackCompanyStatus");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        ClsBlackCompanyStatusCQ cq = new ClsBlackCompanyStatusCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("clsBlackCompanyStatus");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinClsBlackCompanyStatus() {
        ClsBlackCompanyStatusCQ cq = getConditionQueryClsBlackCompanyStatus();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD");
        registerOuterJoin(cq, joinOnMap, "clsBlackCompanyStatus");
    }
    public boolean hasConditionQueryClsBlackCompanyStatus() {
        return _conditionQueryClsBlackCompanyStatus != null;
    }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, BlackCompanyCQ> _scalarConditionMap;
    public Map<String, BlackCompanyCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(BlackCompanyCQ sq) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(ky, sq); return "scalarCondition." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, BlackCompanyCQ> _specifyMyselfDerivedMap;
    public Map<String, BlackCompanyCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(BlackCompanyCQ sq) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(ky, sq); return "specifyMyselfDerived." + ky;
    }

    protected Map<String, BlackCompanyCQ> _queryMyselfDerivedMap;
    public Map<String, BlackCompanyCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(BlackCompanyCQ sq) {
        if (_queryMyselfDerivedMap == null) { _queryMyselfDerivedMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_queryMyselfDerivedMap.size() + 1);
        _queryMyselfDerivedMap.put(ky, sq); return "queryMyselfDerived." + ky;
    }
    protected Map<String, Object> _qyeryMyselfDerivedParameterMap;
    public Map<String, Object> getQueryMyselfDerivedParameter() { return _qyeryMyselfDerivedParameterMap; }
    public String keepQueryMyselfDerivedParameter(Object vl) {
        if (_qyeryMyselfDerivedParameterMap == null) { _qyeryMyselfDerivedParameterMap = newLinkedHashMapSized(4); }
        String ky = "subQueryParameterKey" + (_qyeryMyselfDerivedParameterMap.size() + 1);
        _qyeryMyselfDerivedParameterMap.put(ky, vl); return "queryMyselfDerivedParameter." + ky;
    }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, BlackCompanyCQ> _myselfExistsMap;
    public Map<String, BlackCompanyCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(BlackCompanyCQ sq) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(ky, sq); return "myselfExists." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, BlackCompanyCQ> _myselfInScopeMap;
    public Map<String, BlackCompanyCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(BlackCompanyCQ sq) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(ky, sq); return "myselfInScope." + ky;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return BlackCompanyCB.class.getName(); }
    protected String xCQ() { return BlackCompanyCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
