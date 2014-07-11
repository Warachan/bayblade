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
 * The base condition-query of member.
 * @author DBFlute(AutoGenerator)
 */
public class BsMemberCQ extends AbstractBsMemberCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from member) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public MemberCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected MemberCIQ xcreateCIQ() {
        MemberCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected MemberCIQ xnewCIQ() {
        return new MemberCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join member on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public MemberCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        MemberCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _memberId;
    public ConditionValue getMemberId()
    { if (_memberId == null) { _memberId = nCV(); }
      return _memberId; }
    protected ConditionValue getCValueMemberId() { return getMemberId(); }

    public Map<String, FollowCQ> getMemberId_ExistsReferrer_FollowByYouIdList() { return xgetSQueMap("memberId_ExistsReferrer_FollowByYouIdList"); }
    public String keepMemberId_ExistsReferrer_FollowByYouIdList(FollowCQ sq) { return xkeepSQue("memberId_ExistsReferrer_FollowByYouIdList", sq); }

    public Map<String, FollowCQ> getMemberId_ExistsReferrer_FollowByMemberIdList() { return xgetSQueMap("memberId_ExistsReferrer_FollowByMemberIdList"); }
    public String keepMemberId_ExistsReferrer_FollowByMemberIdList(FollowCQ sq) { return xkeepSQue("memberId_ExistsReferrer_FollowByMemberIdList", sq); }

    public Map<String, LoginCQ> getMemberId_ExistsReferrer_LoginList() { return xgetSQueMap("memberId_ExistsReferrer_LoginList"); }
    public String keepMemberId_ExistsReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_ExistsReferrer_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_ExistsReferrer_MemberSecurityAsOne() { return xgetSQueMap("memberId_ExistsReferrer_MemberSecurityAsOne"); }
    public String keepMemberId_ExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_ExistsReferrer_MemberSecurityAsOne", sq); }

    public Map<String, MessageCQ> getMemberId_ExistsReferrer_MessageBySenderIdList() { return xgetSQueMap("memberId_ExistsReferrer_MessageBySenderIdList"); }
    public String keepMemberId_ExistsReferrer_MessageBySenderIdList(MessageCQ sq) { return xkeepSQue("memberId_ExistsReferrer_MessageBySenderIdList", sq); }

    public Map<String, MessageCQ> getMemberId_ExistsReferrer_MessageByReceiverIdList() { return xgetSQueMap("memberId_ExistsReferrer_MessageByReceiverIdList"); }
    public String keepMemberId_ExistsReferrer_MessageByReceiverIdList(MessageCQ sq) { return xkeepSQue("memberId_ExistsReferrer_MessageByReceiverIdList", sq); }

    public Map<String, TweetCQ> getMemberId_ExistsReferrer_TweetList() { return xgetSQueMap("memberId_ExistsReferrer_TweetList"); }
    public String keepMemberId_ExistsReferrer_TweetList(TweetCQ sq) { return xkeepSQue("memberId_ExistsReferrer_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_NotExistsReferrer_FollowByYouIdList() { return xgetSQueMap("memberId_NotExistsReferrer_FollowByYouIdList"); }
    public String keepMemberId_NotExistsReferrer_FollowByYouIdList(FollowCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_FollowByYouIdList", sq); }

    public Map<String, FollowCQ> getMemberId_NotExistsReferrer_FollowByMemberIdList() { return xgetSQueMap("memberId_NotExistsReferrer_FollowByMemberIdList"); }
    public String keepMemberId_NotExistsReferrer_FollowByMemberIdList(FollowCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_FollowByMemberIdList", sq); }

    public Map<String, LoginCQ> getMemberId_NotExistsReferrer_LoginList() { return xgetSQueMap("memberId_NotExistsReferrer_LoginList"); }
    public String keepMemberId_NotExistsReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_NotExistsReferrer_MemberSecurityAsOne() { return xgetSQueMap("memberId_NotExistsReferrer_MemberSecurityAsOne"); }
    public String keepMemberId_NotExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_MemberSecurityAsOne", sq); }

    public Map<String, MessageCQ> getMemberId_NotExistsReferrer_MessageBySenderIdList() { return xgetSQueMap("memberId_NotExistsReferrer_MessageBySenderIdList"); }
    public String keepMemberId_NotExistsReferrer_MessageBySenderIdList(MessageCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_MessageBySenderIdList", sq); }

    public Map<String, MessageCQ> getMemberId_NotExistsReferrer_MessageByReceiverIdList() { return xgetSQueMap("memberId_NotExistsReferrer_MessageByReceiverIdList"); }
    public String keepMemberId_NotExistsReferrer_MessageByReceiverIdList(MessageCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_MessageByReceiverIdList", sq); }

    public Map<String, TweetCQ> getMemberId_NotExistsReferrer_TweetList() { return xgetSQueMap("memberId_NotExistsReferrer_TweetList"); }
    public String keepMemberId_NotExistsReferrer_TweetList(TweetCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_SpecifyDerivedReferrer_FollowByYouIdList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_FollowByYouIdList"); }
    public String keepMemberId_SpecifyDerivedReferrer_FollowByYouIdList(FollowCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_FollowByYouIdList", sq); }

    public Map<String, FollowCQ> getMemberId_SpecifyDerivedReferrer_FollowByMemberIdList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_FollowByMemberIdList"); }
    public String keepMemberId_SpecifyDerivedReferrer_FollowByMemberIdList(FollowCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_FollowByMemberIdList", sq); }

    public Map<String, LoginCQ> getMemberId_SpecifyDerivedReferrer_LoginList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_LoginList"); }
    public String keepMemberId_SpecifyDerivedReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_LoginList", sq); }

    public Map<String, MessageCQ> getMemberId_SpecifyDerivedReferrer_MessageBySenderIdList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_MessageBySenderIdList"); }
    public String keepMemberId_SpecifyDerivedReferrer_MessageBySenderIdList(MessageCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_MessageBySenderIdList", sq); }

    public Map<String, MessageCQ> getMemberId_SpecifyDerivedReferrer_MessageByReceiverIdList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_MessageByReceiverIdList"); }
    public String keepMemberId_SpecifyDerivedReferrer_MessageByReceiverIdList(MessageCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_MessageByReceiverIdList", sq); }

    public Map<String, TweetCQ> getMemberId_SpecifyDerivedReferrer_TweetList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_TweetList"); }
    public String keepMemberId_SpecifyDerivedReferrer_TweetList(TweetCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_InScopeRelation_FollowByYouIdList() { return xgetSQueMap("memberId_InScopeRelation_FollowByYouIdList"); }
    public String keepMemberId_InScopeRelation_FollowByYouIdList(FollowCQ sq) { return xkeepSQue("memberId_InScopeRelation_FollowByYouIdList", sq); }

    public Map<String, FollowCQ> getMemberId_InScopeRelation_FollowByMemberIdList() { return xgetSQueMap("memberId_InScopeRelation_FollowByMemberIdList"); }
    public String keepMemberId_InScopeRelation_FollowByMemberIdList(FollowCQ sq) { return xkeepSQue("memberId_InScopeRelation_FollowByMemberIdList", sq); }

    public Map<String, LoginCQ> getMemberId_InScopeRelation_LoginList() { return xgetSQueMap("memberId_InScopeRelation_LoginList"); }
    public String keepMemberId_InScopeRelation_LoginList(LoginCQ sq) { return xkeepSQue("memberId_InScopeRelation_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_InScopeRelation_MemberSecurityAsOne() { return xgetSQueMap("memberId_InScopeRelation_MemberSecurityAsOne"); }
    public String keepMemberId_InScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_InScopeRelation_MemberSecurityAsOne", sq); }

    public Map<String, MessageCQ> getMemberId_InScopeRelation_MessageBySenderIdList() { return xgetSQueMap("memberId_InScopeRelation_MessageBySenderIdList"); }
    public String keepMemberId_InScopeRelation_MessageBySenderIdList(MessageCQ sq) { return xkeepSQue("memberId_InScopeRelation_MessageBySenderIdList", sq); }

    public Map<String, MessageCQ> getMemberId_InScopeRelation_MessageByReceiverIdList() { return xgetSQueMap("memberId_InScopeRelation_MessageByReceiverIdList"); }
    public String keepMemberId_InScopeRelation_MessageByReceiverIdList(MessageCQ sq) { return xkeepSQue("memberId_InScopeRelation_MessageByReceiverIdList", sq); }

    public Map<String, TweetCQ> getMemberId_InScopeRelation_TweetList() { return xgetSQueMap("memberId_InScopeRelation_TweetList"); }
    public String keepMemberId_InScopeRelation_TweetList(TweetCQ sq) { return xkeepSQue("memberId_InScopeRelation_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_NotInScopeRelation_FollowByYouIdList() { return xgetSQueMap("memberId_NotInScopeRelation_FollowByYouIdList"); }
    public String keepMemberId_NotInScopeRelation_FollowByYouIdList(FollowCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_FollowByYouIdList", sq); }

    public Map<String, FollowCQ> getMemberId_NotInScopeRelation_FollowByMemberIdList() { return xgetSQueMap("memberId_NotInScopeRelation_FollowByMemberIdList"); }
    public String keepMemberId_NotInScopeRelation_FollowByMemberIdList(FollowCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_FollowByMemberIdList", sq); }

    public Map<String, LoginCQ> getMemberId_NotInScopeRelation_LoginList() { return xgetSQueMap("memberId_NotInScopeRelation_LoginList"); }
    public String keepMemberId_NotInScopeRelation_LoginList(LoginCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_NotInScopeRelation_MemberSecurityAsOne() { return xgetSQueMap("memberId_NotInScopeRelation_MemberSecurityAsOne"); }
    public String keepMemberId_NotInScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_MemberSecurityAsOne", sq); }

    public Map<String, MessageCQ> getMemberId_NotInScopeRelation_MessageBySenderIdList() { return xgetSQueMap("memberId_NotInScopeRelation_MessageBySenderIdList"); }
    public String keepMemberId_NotInScopeRelation_MessageBySenderIdList(MessageCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_MessageBySenderIdList", sq); }

    public Map<String, MessageCQ> getMemberId_NotInScopeRelation_MessageByReceiverIdList() { return xgetSQueMap("memberId_NotInScopeRelation_MessageByReceiverIdList"); }
    public String keepMemberId_NotInScopeRelation_MessageByReceiverIdList(MessageCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_MessageByReceiverIdList", sq); }

    public Map<String, TweetCQ> getMemberId_NotInScopeRelation_TweetList() { return xgetSQueMap("memberId_NotInScopeRelation_TweetList"); }
    public String keepMemberId_NotInScopeRelation_TweetList(TweetCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_QueryDerivedReferrer_FollowByYouIdList() { return xgetSQueMap("memberId_QueryDerivedReferrer_FollowByYouIdList"); }
    public String keepMemberId_QueryDerivedReferrer_FollowByYouIdList(FollowCQ sq) { return xkeepSQue("memberId_QueryDerivedReferrer_FollowByYouIdList", sq); }
    public Map<String, Object> getMemberId_QueryDerivedReferrer_FollowByYouIdListParameter() { return xgetSQuePmMap("memberId_QueryDerivedReferrer_FollowByYouIdList"); }
    public String keepMemberId_QueryDerivedReferrer_FollowByYouIdListParameter(Object pm) { return xkeepSQuePm("memberId_QueryDerivedReferrer_FollowByYouIdList", pm); }

    public Map<String, FollowCQ> getMemberId_QueryDerivedReferrer_FollowByMemberIdList() { return xgetSQueMap("memberId_QueryDerivedReferrer_FollowByMemberIdList"); }
    public String keepMemberId_QueryDerivedReferrer_FollowByMemberIdList(FollowCQ sq) { return xkeepSQue("memberId_QueryDerivedReferrer_FollowByMemberIdList", sq); }
    public Map<String, Object> getMemberId_QueryDerivedReferrer_FollowByMemberIdListParameter() { return xgetSQuePmMap("memberId_QueryDerivedReferrer_FollowByMemberIdList"); }
    public String keepMemberId_QueryDerivedReferrer_FollowByMemberIdListParameter(Object pm) { return xkeepSQuePm("memberId_QueryDerivedReferrer_FollowByMemberIdList", pm); }

    public Map<String, LoginCQ> getMemberId_QueryDerivedReferrer_LoginList() { return xgetSQueMap("memberId_QueryDerivedReferrer_LoginList"); }
    public String keepMemberId_QueryDerivedReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_QueryDerivedReferrer_LoginList", sq); }
    public Map<String, Object> getMemberId_QueryDerivedReferrer_LoginListParameter() { return xgetSQuePmMap("memberId_QueryDerivedReferrer_LoginList"); }
    public String keepMemberId_QueryDerivedReferrer_LoginListParameter(Object pm) { return xkeepSQuePm("memberId_QueryDerivedReferrer_LoginList", pm); }

    public Map<String, MessageCQ> getMemberId_QueryDerivedReferrer_MessageBySenderIdList() { return xgetSQueMap("memberId_QueryDerivedReferrer_MessageBySenderIdList"); }
    public String keepMemberId_QueryDerivedReferrer_MessageBySenderIdList(MessageCQ sq) { return xkeepSQue("memberId_QueryDerivedReferrer_MessageBySenderIdList", sq); }
    public Map<String, Object> getMemberId_QueryDerivedReferrer_MessageBySenderIdListParameter() { return xgetSQuePmMap("memberId_QueryDerivedReferrer_MessageBySenderIdList"); }
    public String keepMemberId_QueryDerivedReferrer_MessageBySenderIdListParameter(Object pm) { return xkeepSQuePm("memberId_QueryDerivedReferrer_MessageBySenderIdList", pm); }

    public Map<String, MessageCQ> getMemberId_QueryDerivedReferrer_MessageByReceiverIdList() { return xgetSQueMap("memberId_QueryDerivedReferrer_MessageByReceiverIdList"); }
    public String keepMemberId_QueryDerivedReferrer_MessageByReceiverIdList(MessageCQ sq) { return xkeepSQue("memberId_QueryDerivedReferrer_MessageByReceiverIdList", sq); }
    public Map<String, Object> getMemberId_QueryDerivedReferrer_MessageByReceiverIdListParameter() { return xgetSQuePmMap("memberId_QueryDerivedReferrer_MessageByReceiverIdList"); }
    public String keepMemberId_QueryDerivedReferrer_MessageByReceiverIdListParameter(Object pm) { return xkeepSQuePm("memberId_QueryDerivedReferrer_MessageByReceiverIdList", pm); }

    public Map<String, TweetCQ> getMemberId_QueryDerivedReferrer_TweetList() { return xgetSQueMap("memberId_QueryDerivedReferrer_TweetList"); }
    public String keepMemberId_QueryDerivedReferrer_TweetList(TweetCQ sq) { return xkeepSQue("memberId_QueryDerivedReferrer_TweetList", sq); }
    public Map<String, Object> getMemberId_QueryDerivedReferrer_TweetListParameter() { return xgetSQuePmMap("memberId_QueryDerivedReferrer_TweetList"); }
    public String keepMemberId_QueryDerivedReferrer_TweetListParameter(Object pm) { return xkeepSQuePm("memberId_QueryDerivedReferrer_TweetList", pm); }

    /** 
     * Add order-by as ascend. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberId_Asc() { regOBA("MEMBER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberId_Desc() { regOBD("MEMBER_ID"); return this; }

    protected ConditionValue _memberStatusCode;
    public ConditionValue getMemberStatusCode()
    { if (_memberStatusCode == null) { _memberStatusCode = nCV(); }
      return _memberStatusCode; }
    protected ConditionValue getCValueMemberStatusCode() { return getMemberStatusCode(); }

    public Map<String, MemberStatusCQ> getMemberStatusCode_InScopeRelation_MemberStatus() { return xgetSQueMap("memberStatusCode_InScopeRelation_MemberStatus"); }
    public String keepMemberStatusCode_InScopeRelation_MemberStatus(MemberStatusCQ sq) { return xkeepSQue("memberStatusCode_InScopeRelation_MemberStatus", sq); }

    public Map<String, MemberStatusCQ> getMemberStatusCode_NotInScopeRelation_MemberStatus() { return xgetSQueMap("memberStatusCode_NotInScopeRelation_MemberStatus"); }
    public String keepMemberStatusCode_NotInScopeRelation_MemberStatus(MemberStatusCQ sq) { return xkeepSQue("memberStatusCode_NotInScopeRelation_MemberStatus", sq); }

    /** 
     * Add order-by as ascend. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberStatusCode_Asc() { regOBA("MEMBER_STATUS_CODE"); return this; }

    /**
     * Add order-by as descend. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_MemberStatusCode_Desc() { regOBD("MEMBER_STATUS_CODE"); return this; }

    protected ConditionValue _userName;
    public ConditionValue getUserName()
    { if (_userName == null) { _userName = nCV(); }
      return _userName; }
    protected ConditionValue getCValueUserName() { return getUserName(); }

    /** 
     * Add order-by as ascend. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UserName_Asc() { regOBA("USER_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UserName_Desc() { regOBD("USER_NAME"); return this; }

    protected ConditionValue _accountName;
    public ConditionValue getAccountName()
    { if (_accountName == null) { _accountName = nCV(); }
      return _accountName; }
    protected ConditionValue getCValueAccountName() { return getAccountName(); }

    /** 
     * Add order-by as ascend. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_AccountName_Asc() { regOBA("ACCOUNT_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_AccountName_Desc() { regOBD("ACCOUNT_NAME"); return this; }

    protected ConditionValue _groupName;
    public ConditionValue getGroupName()
    { if (_groupName == null) { _groupName = nCV(); }
      return _groupName; }
    protected ConditionValue getCValueGroupName() { return getGroupName(); }

    /** 
     * Add order-by as ascend. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_GroupName_Asc() { regOBA("GROUP_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_GroupName_Desc() { regOBD("GROUP_NAME"); return this; }

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
    public BsMemberCQ addOrderBy_InsDatetime_Asc() { regOBA("INS_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_InsDatetime_Desc() { regOBD("INS_DATETIME"); return this; }

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
    public BsMemberCQ addOrderBy_UpdDatetime_Asc() { regOBA("UPD_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdDatetime_Desc() { regOBD("UPD_DATETIME"); return this; }

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
    public BsMemberCQ addOrderBy_InsTrace_Asc() { regOBA("INS_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_InsTrace_Desc() { regOBD("INS_TRACE"); return this; }

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
    public BsMemberCQ addOrderBy_UpdTrace_Asc() { regOBA("UPD_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdTrace_Desc() { regOBD("UPD_TRACE"); return this; }

    protected ConditionValue _recruitingNumber;
    public ConditionValue getRecruitingNumber()
    { if (_recruitingNumber == null) { _recruitingNumber = nCV(); }
      return _recruitingNumber; }
    protected ConditionValue getCValueRecruitingNumber() { return getRecruitingNumber(); }

    /** 
     * Add order-by as ascend. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RecruitingNumber_Asc() { regOBA("RECRUITING_NUMBER"); return this; }

    /**
     * Add order-by as descend. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RecruitingNumber_Desc() { regOBD("RECRUITING_NUMBER"); return this; }

    protected ConditionValue _interestedIndustry;
    public ConditionValue getInterestedIndustry()
    { if (_interestedIndustry == null) { _interestedIndustry = nCV(); }
      return _interestedIndustry; }
    protected ConditionValue getCValueInterestedIndustry() { return getInterestedIndustry(); }

    /** 
     * Add order-by as ascend. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_InterestedIndustry_Asc() { regOBA("INTERESTED_INDUSTRY"); return this; }

    /**
     * Add order-by as descend. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_InterestedIndustry_Desc() { regOBD("INTERESTED_INDUSTRY"); return this; }

    protected ConditionValue _graduationYear;
    public ConditionValue getGraduationYear()
    { if (_graduationYear == null) { _graduationYear = nCV(); }
      return _graduationYear; }
    protected ConditionValue getCValueGraduationYear() { return getGraduationYear(); }

    /** 
     * Add order-by as ascend. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_GraduationYear_Asc() { regOBA("GRADUATION_YEAR"); return this; }

    /**
     * Add order-by as descend. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_GraduationYear_Desc() { regOBD("GRADUATION_YEAR"); return this; }

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
    public BsMemberCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsMemberCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        MemberCQ bq = (MemberCQ)bqs;
        MemberCQ uq = (MemberCQ)uqs;
        if (bq.hasConditionQueryMemberStatus()) {
            uq.queryMemberStatus().reflectRelationOnUnionQuery(bq.queryMemberStatus(), uq.queryMemberStatus());
        }
        if (bq.hasConditionQueryMemberSecurityAsOne()) {
            uq.queryMemberSecurityAsOne().reflectRelationOnUnionQuery(bq.queryMemberSecurityAsOne(), uq.queryMemberSecurityAsOne());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberStatusCQ queryMemberStatus() {
        return getConditionQueryMemberStatus();
    }
    public MemberStatusCQ getConditionQueryMemberStatus() {
        String prop = "memberStatus";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberStatus()); xsetupOuterJoinMemberStatus(); }
        return xgetQueRlMap(prop);
    }
    protected MemberStatusCQ xcreateQueryMemberStatus() {
        String nrp = xresolveNRP("member", "memberStatus"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberStatusCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberStatus", nrp);
    }
    protected void xsetupOuterJoinMemberStatus() { xregOutJo("memberStatus"); }
    public boolean hasConditionQueryMemberStatus() { return xhasQueRlMap("memberStatus"); }

    /**
     * Get the condition-query for relation table. <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberSecurityCQ queryMemberSecurityAsOne() { return getConditionQueryMemberSecurityAsOne(); }
    public MemberSecurityCQ getConditionQueryMemberSecurityAsOne() {
        String prop = "memberSecurityAsOne";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberSecurityAsOne()); xsetupOuterJoinMemberSecurityAsOne(); }
        return xgetQueRlMap(prop);
    }
    protected MemberSecurityCQ xcreateQueryMemberSecurityAsOne() {
        String nrp = xresolveNRP("member", "memberSecurityAsOne"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberSecurityCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberSecurityAsOne", nrp);
    }
    protected void xsetupOuterJoinMemberSecurityAsOne() { xregOutJo("memberSecurityAsOne"); }
    public boolean hasConditionQueryMemberSecurityAsOne() { return xhasQueRlMap("memberSecurityAsOne"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, MemberCQ> getScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(MemberCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, MemberCQ> getSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(MemberCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, MemberCQ> getQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(MemberCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> getQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, MemberCQ> _myselfExistsMap;
    public Map<String, MemberCQ> getMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(MemberCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, MemberCQ> getMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(MemberCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return MemberCB.class.getName(); }
    protected String xCQ() { return MemberCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
