package jp.bizreach.twitter.dbflute.cbean.cq.ciq;

import java.util.Map;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.ConditionOption;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.exception.IllegalConditionBeanOperationException;
import jp.bizreach.twitter.dbflute.cbean.*;
import jp.bizreach.twitter.dbflute.cbean.cq.bs.*;
import jp.bizreach.twitter.dbflute.cbean.cq.*;

/**
 * The condition-query for in-line of cls_black_company_status.
 * @author DBFlute(AutoGenerator)
 */
public class ClsBlackCompanyStatusCIQ extends AbstractBsClsBlackCompanyStatusCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsClsBlackCompanyStatusCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public ClsBlackCompanyStatusCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsClsBlackCompanyStatusCQ myCQ) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
        _myCQ = myCQ;
        _foreignPropertyName = _myCQ.xgetForeignPropertyName(); // accept foreign property name
        _relationPath = _myCQ.xgetRelationPath(); // accept relation path
        _inline = true;
    }

    // ===================================================================================
    //                                                             Override about Register
    //                                                             =======================
    protected void reflectRelationOnUnionQuery(ConditionQuery bq, ConditionQuery uq)
    { throw new IllegalConditionBeanOperationException("InlineView cannot use Union: " + bq + " : " + uq); }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col)
    { regIQ(k, v, cv, col); }

    @Override
    protected void setupConditionValueAndRegisterWhereClause(ConditionKey k, Object v, ConditionValue cv, String col, ConditionOption op)
    { regIQ(k, v, cv, col, op); }

    @Override
    protected void registerWhereClause(String wc)
    { registerInlineWhereClause(wc); }

    @Override
    protected boolean isInScopeRelationSuppressLocalAliasName() {
        if (_onClause) { throw new IllegalConditionBeanOperationException("InScopeRelation on OnClause is unsupported."); }
        return true;
    }

    // ===================================================================================
    //                                                                Override about Query
    //                                                                ====================
    protected ConditionValue getCValueBlackCompanyStatusCd() { return _myCQ.getBlackCompanyStatusCd(); }
    public String keepBlackCompanyStatusCd_ExistsReferrer_BlackCompanyList(BlackCompanyCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepBlackCompanyStatusCd_NotExistsReferrer_BlackCompanyList(BlackCompanyCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepBlackCompanyStatusCd_InScopeRelation_BlackCompanyList(BlackCompanyCQ sq)
    { return _myCQ.keepBlackCompanyStatusCd_InScopeRelation_BlackCompanyList(sq); }
    public String keepBlackCompanyStatusCd_NotInScopeRelation_BlackCompanyList(BlackCompanyCQ sq)
    { return _myCQ.keepBlackCompanyStatusCd_NotInScopeRelation_BlackCompanyList(sq); }
    public String keepBlackCompanyStatusCd_SpecifyDerivedReferrer_BlackCompanyList(BlackCompanyCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyList(BlackCompanyCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepBlackCompanyStatusCd_QueryDerivedReferrer_BlackCompanyListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue getCValueCodeName() { return _myCQ.getCodeName(); }
    protected ConditionValue getCValueCodeAlias() { return _myCQ.getCodeAlias(); }
    protected ConditionValue getCValueCodeDisplayNo() { return _myCQ.getCodeDisplayNo(); }
    protected ConditionValue getCValueCodeComment() { return _myCQ.getCodeComment(); }
    protected ConditionValue getCValueCodeAliasEn() { return _myCQ.getCodeAliasEn(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(ClsBlackCompanyStatusCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(ClsBlackCompanyStatusCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(ClsBlackCompanyStatusCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(ClsBlackCompanyStatusCQ sq)
    { throwIICBOE("MyselfExists"); return null;}
    public String keepMyselfInScope(ClsBlackCompanyStatusCQ sq)
    { throwIICBOE("MyselfInScope"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return ClsBlackCompanyStatusCB.class.getName(); }
    protected String xinCQ() { return ClsBlackCompanyStatusCQ.class.getName(); }
}
