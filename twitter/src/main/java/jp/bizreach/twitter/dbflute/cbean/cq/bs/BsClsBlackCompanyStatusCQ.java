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
 * The base condition-query of cls_black_company_status.
 * @author DBFlute(AutoGenerator)
 */
public class BsClsBlackCompanyStatusCQ extends AbstractBsClsBlackCompanyStatusCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected ClsBlackCompanyStatusCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsClsBlackCompanyStatusCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from cls_black_company_status) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public ClsBlackCompanyStatusCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected ClsBlackCompanyStatusCIQ xcreateCIQ() {
        ClsBlackCompanyStatusCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected ClsBlackCompanyStatusCIQ xnewCIQ() {
        return new ClsBlackCompanyStatusCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join cls_black_company_status on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public ClsBlackCompanyStatusCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        ClsBlackCompanyStatusCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _blackCompanyStatusCd;
    public ConditionValue getBlackCompanyStatusCd() {
        if (_blackCompanyStatusCd == null) { _blackCompanyStatusCd = nCV(); }
        return _blackCompanyStatusCd;
    }
    protected ConditionValue getCValueBlackCompanyStatusCd() { return getBlackCompanyStatusCd(); }

    protected Map<String, BlackCompanyCQ> _blackCompanyStatusCd_ExistsReferrer_BlackCompanyListMap;
    public Map<String, BlackCompanyCQ> getBlackCompanyStatusCd_ExistsReferrer_BlackCompanyList() { return _blackCompanyStatusCd_ExistsReferrer_BlackCompanyListMap; }
    public String keepBlackCompanyStatusCd_ExistsReferrer_BlackCompanyList(BlackCompanyCQ sq) {
        if (_blackCompanyStatusCd_ExistsReferrer_BlackCompanyListMap == null) { _blackCompanyStatusCd_ExistsReferrer_BlackCompanyListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_ExistsReferrer_BlackCompanyListMap.size() + 1);
        _blackCompanyStatusCd_ExistsReferrer_BlackCompanyListMap.put(ky, sq); return "blackCompanyStatusCd_ExistsReferrer_BlackCompanyList." + ky;
    }

    protected Map<String, BlackCompanyCQ> _blackCompanyStatusCd_NotExistsReferrer_BlackCompanyListMap;
    public Map<String, BlackCompanyCQ> getBlackCompanyStatusCd_NotExistsReferrer_BlackCompanyList() { return _blackCompanyStatusCd_NotExistsReferrer_BlackCompanyListMap; }
    public String keepBlackCompanyStatusCd_NotExistsReferrer_BlackCompanyList(BlackCompanyCQ sq) {
        if (_blackCompanyStatusCd_NotExistsReferrer_BlackCompanyListMap == null) { _blackCompanyStatusCd_NotExistsReferrer_BlackCompanyListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_NotExistsReferrer_BlackCompanyListMap.size() + 1);
        _blackCompanyStatusCd_NotExistsReferrer_BlackCompanyListMap.put(ky, sq); return "blackCompanyStatusCd_NotExistsReferrer_BlackCompanyList." + ky;
    }

    protected Map<String, BlackCompanyCQ> _blackCompanyStatusCd_InScopeRelation_BlackCompanyListMap;
    public Map<String, BlackCompanyCQ> getBlackCompanyStatusCd_InScopeRelation_BlackCompanyList() { return _blackCompanyStatusCd_InScopeRelation_BlackCompanyListMap; }
    public String keepBlackCompanyStatusCd_InScopeRelation_BlackCompanyList(BlackCompanyCQ sq) {
        if (_blackCompanyStatusCd_InScopeRelation_BlackCompanyListMap == null) { _blackCompanyStatusCd_InScopeRelation_BlackCompanyListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_InScopeRelation_BlackCompanyListMap.size() + 1);
        _blackCompanyStatusCd_InScopeRelation_BlackCompanyListMap.put(ky, sq); return "blackCompanyStatusCd_InScopeRelation_BlackCompanyList." + ky;
    }

    protected Map<String, BlackCompanyCQ> _blackCompanyStatusCd_NotInScopeRelation_BlackCompanyListMap;
    public Map<String, BlackCompanyCQ> getBlackCompanyStatusCd_NotInScopeRelation_BlackCompanyList() { return _blackCompanyStatusCd_NotInScopeRelation_BlackCompanyListMap; }
    public String keepBlackCompanyStatusCd_NotInScopeRelation_BlackCompanyList(BlackCompanyCQ sq) {
        if (_blackCompanyStatusCd_NotInScopeRelation_BlackCompanyListMap == null) { _blackCompanyStatusCd_NotInScopeRelation_BlackCompanyListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_NotInScopeRelation_BlackCompanyListMap.size() + 1);
        _blackCompanyStatusCd_NotInScopeRelation_BlackCompanyListMap.put(ky, sq); return "blackCompanyStatusCd_NotInScopeRelation_BlackCompanyList." + ky;
    }

    protected Map<String, BlackCompanyCQ> _blackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyListMap;
    public Map<String, BlackCompanyCQ> getBlackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyList() { return _blackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyListMap; }
    public String keepBlackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyList(BlackCompanyCQ sq) {
        if (_blackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyListMap == null) { _blackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyListMap.size() + 1);
        _blackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyListMap.put(ky, sq); return "blackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyList." + ky;
    }

    protected Map<String, BlackCompanyCQ> _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListMap;
    public Map<String, BlackCompanyCQ> getBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyList() { return _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListMap; }
    public String keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyList(BlackCompanyCQ sq) {
        if (_blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListMap == null) { _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListMap.size() + 1);
        _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListMap.put(ky, sq); return "blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyList." + ky;
    }
    protected Map<String, Object> _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameterMap;
    public Map<String, Object> getBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameter() { return _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameterMap; }
    public String keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameter(Object vl) {
        if (_blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameterMap == null) { _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameterMap = newLinkedHashMapSized(4); }
        String ky = "subQueryParameterKey" + (_blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameterMap.size() + 1);
        _blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameterMap.put(ky, vl); return "blackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameter." + ky;
    }

    /** 
     * Add order-by as ascend. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_BlackCompanyStatusCd_Asc() { regOBA("BLACK_COMPANY_STATUS_CD"); return this; }

    /**
     * Add order-by as descend. <br />
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_BlackCompanyStatusCd_Desc() { regOBD("BLACK_COMPANY_STATUS_CD"); return this; }

    protected ConditionValue _codeName;
    public ConditionValue getCodeName() {
        if (_codeName == null) { _codeName = nCV(); }
        return _codeName;
    }
    protected ConditionValue getCValueCodeName() { return getCodeName(); }

    /** 
     * Add order-by as ascend. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeName_Asc() { regOBA("CODE_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeName_Desc() { regOBD("CODE_NAME"); return this; }

    protected ConditionValue _codeAlias;
    public ConditionValue getCodeAlias() {
        if (_codeAlias == null) { _codeAlias = nCV(); }
        return _codeAlias;
    }
    protected ConditionValue getCValueCodeAlias() { return getCodeAlias(); }

    /** 
     * Add order-by as ascend. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeAlias_Asc() { regOBA("CODE_ALIAS"); return this; }

    /**
     * Add order-by as descend. <br />
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeAlias_Desc() { regOBD("CODE_ALIAS"); return this; }

    protected ConditionValue _codeDisplayNo;
    public ConditionValue getCodeDisplayNo() {
        if (_codeDisplayNo == null) { _codeDisplayNo = nCV(); }
        return _codeDisplayNo;
    }
    protected ConditionValue getCValueCodeDisplayNo() { return getCodeDisplayNo(); }

    /** 
     * Add order-by as ascend. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeDisplayNo_Asc() { regOBA("CODE_DISPLAY_NO"); return this; }

    /**
     * Add order-by as descend. <br />
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeDisplayNo_Desc() { regOBD("CODE_DISPLAY_NO"); return this; }

    protected ConditionValue _codeComment;
    public ConditionValue getCodeComment() {
        if (_codeComment == null) { _codeComment = nCV(); }
        return _codeComment;
    }
    protected ConditionValue getCValueCodeComment() { return getCodeComment(); }

    /** 
     * Add order-by as ascend. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeComment_Asc() { regOBA("CODE_COMMENT"); return this; }

    /**
     * Add order-by as descend. <br />
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeComment_Desc() { regOBD("CODE_COMMENT"); return this; }

    protected ConditionValue _codeAliasEn;
    public ConditionValue getCodeAliasEn() {
        if (_codeAliasEn == null) { _codeAliasEn = nCV(); }
        return _codeAliasEn;
    }
    protected ConditionValue getCValueCodeAliasEn() { return getCodeAliasEn(); }

    /** 
     * Add order-by as ascend. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeAliasEn_Asc() { regOBA("CODE_ALIAS_EN"); return this; }

    /**
     * Add order-by as descend. <br />
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsClsBlackCompanyStatusCQ addOrderBy_CodeAliasEn_Desc() { regOBD("CODE_ALIAS_EN"); return this; }

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
    public BsClsBlackCompanyStatusCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
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
    public BsClsBlackCompanyStatusCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, ClsBlackCompanyStatusCQ> _scalarConditionMap;
    public Map<String, ClsBlackCompanyStatusCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(ClsBlackCompanyStatusCQ sq) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(ky, sq); return "scalarCondition." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, ClsBlackCompanyStatusCQ> _specifyMyselfDerivedMap;
    public Map<String, ClsBlackCompanyStatusCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(ClsBlackCompanyStatusCQ sq) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(ky, sq); return "specifyMyselfDerived." + ky;
    }

    protected Map<String, ClsBlackCompanyStatusCQ> _queryMyselfDerivedMap;
    public Map<String, ClsBlackCompanyStatusCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(ClsBlackCompanyStatusCQ sq) {
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
    protected Map<String, ClsBlackCompanyStatusCQ> _myselfExistsMap;
    public Map<String, ClsBlackCompanyStatusCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(ClsBlackCompanyStatusCQ sq) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(ky, sq); return "myselfExists." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, ClsBlackCompanyStatusCQ> _myselfInScopeMap;
    public Map<String, ClsBlackCompanyStatusCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(ClsBlackCompanyStatusCQ sq) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(ky, sq); return "myselfInScope." + ky;
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return ClsBlackCompanyStatusCB.class.getName(); }
    protected String xCQ() { return ClsBlackCompanyStatusCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
