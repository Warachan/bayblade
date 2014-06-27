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

    public Map<String, FollowCQ> getMemberId_ExistsReferrer_FollowAsOne() { return xgetSQueMap("memberId_ExistsReferrer_FollowAsOne"); }
    public String keepMemberId_ExistsReferrer_FollowAsOne(FollowCQ sq) { return xkeepSQue("memberId_ExistsReferrer_FollowAsOne", sq); }

    public Map<String, FollowersCQ> getMemberId_ExistsReferrer_FollowersAsOne() { return xgetSQueMap("memberId_ExistsReferrer_FollowersAsOne"); }
    public String keepMemberId_ExistsReferrer_FollowersAsOne(FollowersCQ sq) { return xkeepSQue("memberId_ExistsReferrer_FollowersAsOne", sq); }

    public Map<String, LoginCQ> getMemberId_ExistsReferrer_LoginList() { return xgetSQueMap("memberId_ExistsReferrer_LoginList"); }
    public String keepMemberId_ExistsReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_ExistsReferrer_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_ExistsReferrer_MemberSecurityAsOne() { return xgetSQueMap("memberId_ExistsReferrer_MemberSecurityAsOne"); }
    public String keepMemberId_ExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_ExistsReferrer_MemberSecurityAsOne", sq); }

    public Map<String, MemberWithdrawCQ> getMemberId_ExistsReferrer_MemberWithdrawAsOne() { return xgetSQueMap("memberId_ExistsReferrer_MemberWithdrawAsOne"); }
    public String keepMemberId_ExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq) { return xkeepSQue("memberId_ExistsReferrer_MemberWithdrawAsOne", sq); }

    public Map<String, TweetCQ> getMemberId_ExistsReferrer_TweetList() { return xgetSQueMap("memberId_ExistsReferrer_TweetList"); }
    public String keepMemberId_ExistsReferrer_TweetList(TweetCQ sq) { return xkeepSQue("memberId_ExistsReferrer_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_NotExistsReferrer_FollowAsOne() { return xgetSQueMap("memberId_NotExistsReferrer_FollowAsOne"); }
    public String keepMemberId_NotExistsReferrer_FollowAsOne(FollowCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_FollowAsOne", sq); }

    public Map<String, FollowersCQ> getMemberId_NotExistsReferrer_FollowersAsOne() { return xgetSQueMap("memberId_NotExistsReferrer_FollowersAsOne"); }
    public String keepMemberId_NotExistsReferrer_FollowersAsOne(FollowersCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_FollowersAsOne", sq); }

    public Map<String, LoginCQ> getMemberId_NotExistsReferrer_LoginList() { return xgetSQueMap("memberId_NotExistsReferrer_LoginList"); }
    public String keepMemberId_NotExistsReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_NotExistsReferrer_MemberSecurityAsOne() { return xgetSQueMap("memberId_NotExistsReferrer_MemberSecurityAsOne"); }
    public String keepMemberId_NotExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_MemberSecurityAsOne", sq); }

    public Map<String, MemberWithdrawCQ> getMemberId_NotExistsReferrer_MemberWithdrawAsOne() { return xgetSQueMap("memberId_NotExistsReferrer_MemberWithdrawAsOne"); }
    public String keepMemberId_NotExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_MemberWithdrawAsOne", sq); }

    public Map<String, TweetCQ> getMemberId_NotExistsReferrer_TweetList() { return xgetSQueMap("memberId_NotExistsReferrer_TweetList"); }
    public String keepMemberId_NotExistsReferrer_TweetList(TweetCQ sq) { return xkeepSQue("memberId_NotExistsReferrer_TweetList", sq); }

    public Map<String, LoginCQ> getMemberId_SpecifyDerivedReferrer_LoginList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_LoginList"); }
    public String keepMemberId_SpecifyDerivedReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_LoginList", sq); }

    public Map<String, TweetCQ> getMemberId_SpecifyDerivedReferrer_TweetList() { return xgetSQueMap("memberId_SpecifyDerivedReferrer_TweetList"); }
    public String keepMemberId_SpecifyDerivedReferrer_TweetList(TweetCQ sq) { return xkeepSQue("memberId_SpecifyDerivedReferrer_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_InScopeRelation_FollowAsOne() { return xgetSQueMap("memberId_InScopeRelation_FollowAsOne"); }
    public String keepMemberId_InScopeRelation_FollowAsOne(FollowCQ sq) { return xkeepSQue("memberId_InScopeRelation_FollowAsOne", sq); }

    public Map<String, FollowersCQ> getMemberId_InScopeRelation_FollowersAsOne() { return xgetSQueMap("memberId_InScopeRelation_FollowersAsOne"); }
    public String keepMemberId_InScopeRelation_FollowersAsOne(FollowersCQ sq) { return xkeepSQue("memberId_InScopeRelation_FollowersAsOne", sq); }

    public Map<String, LoginCQ> getMemberId_InScopeRelation_LoginList() { return xgetSQueMap("memberId_InScopeRelation_LoginList"); }
    public String keepMemberId_InScopeRelation_LoginList(LoginCQ sq) { return xkeepSQue("memberId_InScopeRelation_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_InScopeRelation_MemberSecurityAsOne() { return xgetSQueMap("memberId_InScopeRelation_MemberSecurityAsOne"); }
    public String keepMemberId_InScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_InScopeRelation_MemberSecurityAsOne", sq); }

    public Map<String, MemberWithdrawCQ> getMemberId_InScopeRelation_MemberWithdrawAsOne() { return xgetSQueMap("memberId_InScopeRelation_MemberWithdrawAsOne"); }
    public String keepMemberId_InScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq) { return xkeepSQue("memberId_InScopeRelation_MemberWithdrawAsOne", sq); }

    public Map<String, TweetCQ> getMemberId_InScopeRelation_TweetList() { return xgetSQueMap("memberId_InScopeRelation_TweetList"); }
    public String keepMemberId_InScopeRelation_TweetList(TweetCQ sq) { return xkeepSQue("memberId_InScopeRelation_TweetList", sq); }

    public Map<String, FollowCQ> getMemberId_NotInScopeRelation_FollowAsOne() { return xgetSQueMap("memberId_NotInScopeRelation_FollowAsOne"); }
    public String keepMemberId_NotInScopeRelation_FollowAsOne(FollowCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_FollowAsOne", sq); }

    public Map<String, FollowersCQ> getMemberId_NotInScopeRelation_FollowersAsOne() { return xgetSQueMap("memberId_NotInScopeRelation_FollowersAsOne"); }
    public String keepMemberId_NotInScopeRelation_FollowersAsOne(FollowersCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_FollowersAsOne", sq); }

    public Map<String, LoginCQ> getMemberId_NotInScopeRelation_LoginList() { return xgetSQueMap("memberId_NotInScopeRelation_LoginList"); }
    public String keepMemberId_NotInScopeRelation_LoginList(LoginCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_LoginList", sq); }

    public Map<String, MemberSecurityCQ> getMemberId_NotInScopeRelation_MemberSecurityAsOne() { return xgetSQueMap("memberId_NotInScopeRelation_MemberSecurityAsOne"); }
    public String keepMemberId_NotInScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_MemberSecurityAsOne", sq); }

    public Map<String, MemberWithdrawCQ> getMemberId_NotInScopeRelation_MemberWithdrawAsOne() { return xgetSQueMap("memberId_NotInScopeRelation_MemberWithdrawAsOne"); }
    public String keepMemberId_NotInScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_MemberWithdrawAsOne", sq); }

    public Map<String, TweetCQ> getMemberId_NotInScopeRelation_TweetList() { return xgetSQueMap("memberId_NotInScopeRelation_TweetList"); }
    public String keepMemberId_NotInScopeRelation_TweetList(TweetCQ sq) { return xkeepSQue("memberId_NotInScopeRelation_TweetList", sq); }

    public Map<String, LoginCQ> getMemberId_QueryDerivedReferrer_LoginList() { return xgetSQueMap("memberId_QueryDerivedReferrer_LoginList"); }
    public String keepMemberId_QueryDerivedReferrer_LoginList(LoginCQ sq) { return xkeepSQue("memberId_QueryDerivedReferrer_LoginList", sq); }
    public Map<String, Object> getMemberId_QueryDerivedReferrer_LoginListParameter() { return xgetSQuePmMap("memberId_QueryDerivedReferrer_LoginList"); }
    public String keepMemberId_QueryDerivedReferrer_LoginListParameter(Object pm) { return xkeepSQuePm("memberId_QueryDerivedReferrer_LoginList", pm); }

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

    protected ConditionValue _emailAddress;
    public ConditionValue getEmailAddress()
    { if (_emailAddress == null) { _emailAddress = nCV(); }
      return _emailAddress; }
    protected ConditionValue getCValueEmailAddress() { return getEmailAddress(); }

    /** 
     * Add order-by as ascend. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_EmailAddress_Asc() { regOBA("EMAIL_ADDRESS"); return this; }

    /**
     * Add order-by as descend. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_EmailAddress_Desc() { regOBD("EMAIL_ADDRESS"); return this; }

    protected ConditionValue _userName;
    public ConditionValue getUserName()
    { if (_userName == null) { _userName = nCV(); }
      return _userName; }
    protected ConditionValue getCValueUserName() { return getUserName(); }

    /** 
     * Add order-by as ascend. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UserName_Asc() { regOBA("USER_NAME"); return this; }

    /**
     * Add order-by as descend. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UserName_Desc() { regOBD("USER_NAME"); return this; }

    protected ConditionValue _updateDatetime;
    public ConditionValue getUpdateDatetime()
    { if (_updateDatetime == null) { _updateDatetime = nCV(); }
      return _updateDatetime; }
    protected ConditionValue getCValueUpdateDatetime() { return getUpdateDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdateDatetime_Asc() { regOBA("UPDATE_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_UpdateDatetime_Desc() { regOBD("UPDATE_DATETIME"); return this; }

    protected ConditionValue _birthdate;
    public ConditionValue getBirthdate()
    { if (_birthdate == null) { _birthdate = nCV(); }
      return _birthdate; }
    protected ConditionValue getCValueBirthdate() { return getBirthdate(); }

    /** 
     * Add order-by as ascend. <br />
     * BIRTHDATE: {DATE(10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_Birthdate_Asc() { regOBA("BIRTHDATE"); return this; }

    /**
     * Add order-by as descend. <br />
     * BIRTHDATE: {DATE(10)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_Birthdate_Desc() { regOBD("BIRTHDATE"); return this; }

    protected ConditionValue _profile;
    public ConditionValue getProfile()
    { if (_profile == null) { _profile = nCV(); }
      return _profile; }
    protected ConditionValue getCValueProfile() { return getProfile(); }

    /** 
     * Add order-by as ascend. <br />
     * PROFILE: {VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_Profile_Asc() { regOBA("PROFILE"); return this; }

    /**
     * Add order-by as descend. <br />
     * PROFILE: {VARCHAR(200)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_Profile_Desc() { regOBD("PROFILE"); return this; }

    protected ConditionValue _regesterDatetime;
    public ConditionValue getRegesterDatetime()
    { if (_regesterDatetime == null) { _regesterDatetime = nCV(); }
      return _regesterDatetime; }
    protected ConditionValue getCValueRegesterDatetime() { return getRegesterDatetime(); }

    /** 
     * Add order-by as ascend. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RegesterDatetime_Asc() { regOBA("REGESTER_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMemberCQ addOrderBy_RegesterDatetime_Desc() { regOBD("REGESTER_DATETIME"); return this; }

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
        if (bq.hasConditionQueryFollowAsOne()) {
            uq.queryFollowAsOne().reflectRelationOnUnionQuery(bq.queryFollowAsOne(), uq.queryFollowAsOne());
        }
        if (bq.hasConditionQueryFollowersAsOne()) {
            uq.queryFollowersAsOne().reflectRelationOnUnionQuery(bq.queryFollowersAsOne(), uq.queryFollowersAsOne());
        }
        if (bq.hasConditionQueryMemberSecurityAsOne()) {
            uq.queryMemberSecurityAsOne().reflectRelationOnUnionQuery(bq.queryMemberSecurityAsOne(), uq.queryMemberSecurityAsOne());
        }
        if (bq.hasConditionQueryMemberWithdrawAsOne()) {
            uq.queryMemberWithdrawAsOne().reflectRelationOnUnionQuery(bq.queryMemberWithdrawAsOne(), uq.queryMemberWithdrawAsOne());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * follow by MEMBER_ID, named 'followAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public FollowCQ queryFollowAsOne() { return getConditionQueryFollowAsOne(); }
    public FollowCQ getConditionQueryFollowAsOne() {
        String prop = "followAsOne";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryFollowAsOne()); xsetupOuterJoinFollowAsOne(); }
        return xgetQueRlMap(prop);
    }
    protected FollowCQ xcreateQueryFollowAsOne() {
        String nrp = xresolveNRP("member", "followAsOne"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new FollowCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "followAsOne", nrp);
    }
    protected void xsetupOuterJoinFollowAsOne() { xregOutJo("followAsOne"); }
    public boolean hasConditionQueryFollowAsOne() { return xhasQueRlMap("followAsOne"); }

    /**
     * Get the condition-query for relation table. <br />
     * followers by MEMBER_ID, named 'followersAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public FollowersCQ queryFollowersAsOne() { return getConditionQueryFollowersAsOne(); }
    public FollowersCQ getConditionQueryFollowersAsOne() {
        String prop = "followersAsOne";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryFollowersAsOne()); xsetupOuterJoinFollowersAsOne(); }
        return xgetQueRlMap(prop);
    }
    protected FollowersCQ xcreateQueryFollowersAsOne() {
        String nrp = xresolveNRP("member", "followersAsOne"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new FollowersCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "followersAsOne", nrp);
    }
    protected void xsetupOuterJoinFollowersAsOne() { xregOutJo("followersAsOne"); }
    public boolean hasConditionQueryFollowersAsOne() { return xhasQueRlMap("followersAsOne"); }

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

    /**
     * Get the condition-query for relation table. <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberWithdrawCQ queryMemberWithdrawAsOne() { return getConditionQueryMemberWithdrawAsOne(); }
    public MemberWithdrawCQ getConditionQueryMemberWithdrawAsOne() {
        String prop = "memberWithdrawAsOne";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberWithdrawAsOne()); xsetupOuterJoinMemberWithdrawAsOne(); }
        return xgetQueRlMap(prop);
    }
    protected MemberWithdrawCQ xcreateQueryMemberWithdrawAsOne() {
        String nrp = xresolveNRP("member", "memberWithdrawAsOne"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberWithdrawCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberWithdrawAsOne", nrp);
    }
    protected void xsetupOuterJoinMemberWithdrawAsOne() { xregOutJo("memberWithdrawAsOne"); }
    public boolean hasConditionQueryMemberWithdrawAsOne() { return xhasQueRlMap("memberWithdrawAsOne"); }

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
