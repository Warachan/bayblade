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
 * The condition-query for in-line of follow.
 * @author DBFlute(AutoGenerator)
 */
public class FollowCIQ extends AbstractBsFollowCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsFollowCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public FollowCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsFollowCQ myCQ) {
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
    protected ConditionValue getCValueFollowId() { return _myCQ.getFollowId(); }
    protected ConditionValue getCValueYouId() { return _myCQ.getYouId(); }
    public String keepYouId_InScopeRelation_MemberByYouId(MemberCQ sq)
    { return _myCQ.keepYouId_InScopeRelation_MemberByYouId(sq); }
    public String keepYouId_NotInScopeRelation_MemberByYouId(MemberCQ sq)
    { return _myCQ.keepYouId_NotInScopeRelation_MemberByYouId(sq); }
    protected ConditionValue getCValueMemberId() { return _myCQ.getMemberId(); }
    public String keepMemberId_InScopeRelation_MemberByMemberId(MemberCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_MemberByMemberId(sq); }
    public String keepMemberId_NotInScopeRelation_MemberByMemberId(MemberCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_MemberByMemberId(sq); }
    protected ConditionValue getCValueInsDatetime() { return _myCQ.getInsDatetime(); }
    protected ConditionValue getCValueUpdDatetime() { return _myCQ.getUpdDatetime(); }
    protected ConditionValue getCValueInsTrace() { return _myCQ.getInsTrace(); }
    protected ConditionValue getCValueUpdTrace() { return _myCQ.getUpdTrace(); }
    protected ConditionValue getCValueDelFlg() { return _myCQ.getDelFlg(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(FollowCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(FollowCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(FollowCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(FollowCQ sq)
    { throwIICBOE("MyselfExists"); return null;}
    public String keepMyselfInScope(FollowCQ sq)
    { throwIICBOE("MyselfInScope"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return FollowCB.class.getName(); }
    protected String xinCQ() { return FollowCQ.class.getName(); }
}
