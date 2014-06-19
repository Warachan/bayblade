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
 * The condition-query for in-line of black_company.
 * @author DBFlute(AutoGenerator)
 */
public class BlackCompanyCIQ extends AbstractBsBlackCompanyCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsBlackCompanyCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BlackCompanyCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsBlackCompanyCQ myCQ) {
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
    protected ConditionValue getCValueBlackCompanyId() { return _myCQ.getBlackCompanyId(); }
    protected ConditionValue getCValueBlackCompanyName() { return _myCQ.getBlackCompanyName(); }
    protected ConditionValue getCValueAgentCompanyName() { return _myCQ.getAgentCompanyName(); }
    protected ConditionValue getCValueZipCode() { return _myCQ.getZipCode(); }
    protected ConditionValue getCValueAddress1() { return _myCQ.getAddress1(); }
    protected ConditionValue getCValueAddress2() { return _myCQ.getAddress2(); }
    protected ConditionValue getCValueBlackCompanyStatusCd() { return _myCQ.getBlackCompanyStatusCd(); }
    public String keepBlackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatus(ClsBlackCompanyStatusCQ sq)
    { return _myCQ.keepBlackCompanyStatusCd_InScopeRelation_ClsBlackCompanyStatus(sq); }
    public String keepBlackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatus(ClsBlackCompanyStatusCQ sq)
    { return _myCQ.keepBlackCompanyStatusCd_NotInScopeRelation_ClsBlackCompanyStatus(sq); }
    protected ConditionValue getCValueInsDatetime() { return _myCQ.getInsDatetime(); }
    protected ConditionValue getCValueUpdDatetime() { return _myCQ.getUpdDatetime(); }
    protected ConditionValue getCValueInsTrace() { return _myCQ.getInsTrace(); }
    protected ConditionValue getCValueUpdTrace() { return _myCQ.getUpdTrace(); }
    protected ConditionValue getCValueVersionNo() { return _myCQ.getVersionNo(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(BlackCompanyCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(BlackCompanyCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(BlackCompanyCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(BlackCompanyCQ sq)
    { throwIICBOE("MyselfExists"); return null;}
    public String keepMyselfInScope(BlackCompanyCQ sq)
    { throwIICBOE("MyselfInScope"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return BlackCompanyCB.class.getName(); }
    protected String xinCQ() { return BlackCompanyCQ.class.getName(); }
}
