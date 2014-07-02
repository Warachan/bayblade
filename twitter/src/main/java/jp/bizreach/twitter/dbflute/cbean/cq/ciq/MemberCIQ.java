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
 * The condition-query for in-line of member.
 * @author DBFlute(AutoGenerator)
 */
public class MemberCIQ extends AbstractBsMemberCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsMemberCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public MemberCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsMemberCQ myCQ) {
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
    protected ConditionValue getCValueMemberId() { return _myCQ.getMemberId(); }
    public String keepMemberId_ExistsReferrer_FollowByYouIdAsOne(FollowCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepMemberId_ExistsReferrer_FollowByMemberIdList(FollowCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepMemberId_ExistsReferrer_LoginList(LoginCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepMemberId_ExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepMemberId_ExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepMemberId_ExistsReferrer_TweetList(TweetCQ sq)
    { throwIICBOE("ExistsReferrer"); return null; }
    public String keepMemberId_NotExistsReferrer_FollowByYouIdAsOne(FollowCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepMemberId_NotExistsReferrer_FollowByMemberIdList(FollowCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepMemberId_NotExistsReferrer_LoginList(LoginCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepMemberId_NotExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepMemberId_NotExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepMemberId_NotExistsReferrer_TweetList(TweetCQ sq)
    { throwIICBOE("NotExistsReferrer"); return null; }
    public String keepMemberId_InScopeRelation_FollowByYouIdAsOne(FollowCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_FollowByYouIdAsOne(sq); }
    public String keepMemberId_InScopeRelation_FollowByMemberIdList(FollowCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_FollowByMemberIdList(sq); }
    public String keepMemberId_InScopeRelation_LoginList(LoginCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_LoginList(sq); }
    public String keepMemberId_InScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_MemberSecurityAsOne(sq); }
    public String keepMemberId_InScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_MemberWithdrawAsOne(sq); }
    public String keepMemberId_InScopeRelation_TweetList(TweetCQ sq)
    { return _myCQ.keepMemberId_InScopeRelation_TweetList(sq); }
    public String keepMemberId_NotInScopeRelation_FollowByYouIdAsOne(FollowCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_FollowByYouIdAsOne(sq); }
    public String keepMemberId_NotInScopeRelation_FollowByMemberIdList(FollowCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_FollowByMemberIdList(sq); }
    public String keepMemberId_NotInScopeRelation_LoginList(LoginCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_LoginList(sq); }
    public String keepMemberId_NotInScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_MemberSecurityAsOne(sq); }
    public String keepMemberId_NotInScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_MemberWithdrawAsOne(sq); }
    public String keepMemberId_NotInScopeRelation_TweetList(TweetCQ sq)
    { return _myCQ.keepMemberId_NotInScopeRelation_TweetList(sq); }
    public String keepMemberId_SpecifyDerivedReferrer_FollowByMemberIdList(FollowCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepMemberId_SpecifyDerivedReferrer_LoginList(LoginCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepMemberId_SpecifyDerivedReferrer_TweetList(TweetCQ sq)
    { throwIICBOE("(Specify)DerivedReferrer"); return null; }
    public String keepMemberId_QueryDerivedReferrer_FollowByMemberIdList(FollowCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepMemberId_QueryDerivedReferrer_FollowByMemberIdListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepMemberId_QueryDerivedReferrer_LoginList(LoginCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepMemberId_QueryDerivedReferrer_LoginListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepMemberId_QueryDerivedReferrer_TweetList(TweetCQ sq)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    public String keepMemberId_QueryDerivedReferrer_TweetListParameter(Object vl)
    { throwIICBOE("(Query)DerivedReferrer"); return null; }
    protected ConditionValue getCValueEmailAddress() { return _myCQ.getEmailAddress(); }
    protected ConditionValue getCValueUserName() { return _myCQ.getUserName(); }
    protected ConditionValue getCValueBirthdate() { return _myCQ.getBirthdate(); }
    protected ConditionValue getCValueProfile() { return _myCQ.getProfile(); }
    protected ConditionValue getCValueInsDatetime() { return _myCQ.getInsDatetime(); }
    protected ConditionValue getCValueUpdDatetime() { return _myCQ.getUpdDatetime(); }
    protected ConditionValue getCValueInsTrace() { return _myCQ.getInsTrace(); }
    protected ConditionValue getCValueUpdTrace() { return _myCQ.getUpdTrace(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(MemberCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(MemberCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(MemberCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(MemberCQ sq)
    { throwIICBOE("MyselfExists"); return null;}
    public String keepMyselfInScope(MemberCQ sq)
    { throwIICBOE("MyselfInScope"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return MemberCB.class.getName(); }
    protected String xinCQ() { return MemberCQ.class.getName(); }
}
