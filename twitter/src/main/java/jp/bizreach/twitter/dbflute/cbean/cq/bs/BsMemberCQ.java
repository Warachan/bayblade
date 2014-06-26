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
    public ConditionValue getMemberId() {
        if (_memberId == null) { _memberId = nCV(); }
        return _memberId;
    }
    protected ConditionValue getCValueMemberId() { return getMemberId(); }

    protected Map<String, FollowCQ> _memberId_ExistsReferrer_FollowAsOneMap;
    public Map<String, FollowCQ> getMemberId_ExistsReferrer_FollowAsOne() { return _memberId_ExistsReferrer_FollowAsOneMap; }
    public String keepMemberId_ExistsReferrer_FollowAsOne(FollowCQ sq) {
        if (_memberId_ExistsReferrer_FollowAsOneMap == null) { _memberId_ExistsReferrer_FollowAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_ExistsReferrer_FollowAsOneMap.size() + 1);
        _memberId_ExistsReferrer_FollowAsOneMap.put(ky, sq); return "memberId_ExistsReferrer_FollowAsOne." + ky;
    }

    protected Map<String, FollowersCQ> _memberId_ExistsReferrer_FollowersAsOneMap;
    public Map<String, FollowersCQ> getMemberId_ExistsReferrer_FollowersAsOne() { return _memberId_ExistsReferrer_FollowersAsOneMap; }
    public String keepMemberId_ExistsReferrer_FollowersAsOne(FollowersCQ sq) {
        if (_memberId_ExistsReferrer_FollowersAsOneMap == null) { _memberId_ExistsReferrer_FollowersAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_ExistsReferrer_FollowersAsOneMap.size() + 1);
        _memberId_ExistsReferrer_FollowersAsOneMap.put(ky, sq); return "memberId_ExistsReferrer_FollowersAsOne." + ky;
    }

    protected Map<String, LoginCQ> _memberId_ExistsReferrer_LoginListMap;
    public Map<String, LoginCQ> getMemberId_ExistsReferrer_LoginList() { return _memberId_ExistsReferrer_LoginListMap; }
    public String keepMemberId_ExistsReferrer_LoginList(LoginCQ sq) {
        if (_memberId_ExistsReferrer_LoginListMap == null) { _memberId_ExistsReferrer_LoginListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_ExistsReferrer_LoginListMap.size() + 1);
        _memberId_ExistsReferrer_LoginListMap.put(ky, sq); return "memberId_ExistsReferrer_LoginList." + ky;
    }

    protected Map<String, MemberSecurityCQ> _memberId_ExistsReferrer_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_ExistsReferrer_MemberSecurityAsOne() { return _memberId_ExistsReferrer_MemberSecurityAsOneMap; }
    public String keepMemberId_ExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq) {
        if (_memberId_ExistsReferrer_MemberSecurityAsOneMap == null) { _memberId_ExistsReferrer_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_ExistsReferrer_MemberSecurityAsOneMap.size() + 1);
        _memberId_ExistsReferrer_MemberSecurityAsOneMap.put(ky, sq); return "memberId_ExistsReferrer_MemberSecurityAsOne." + ky;
    }

    protected Map<String, MemberWithdrawCQ> _memberId_ExistsReferrer_MemberWithdrawAsOneMap;
    public Map<String, MemberWithdrawCQ> getMemberId_ExistsReferrer_MemberWithdrawAsOne() { return _memberId_ExistsReferrer_MemberWithdrawAsOneMap; }
    public String keepMemberId_ExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq) {
        if (_memberId_ExistsReferrer_MemberWithdrawAsOneMap == null) { _memberId_ExistsReferrer_MemberWithdrawAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_ExistsReferrer_MemberWithdrawAsOneMap.size() + 1);
        _memberId_ExistsReferrer_MemberWithdrawAsOneMap.put(ky, sq); return "memberId_ExistsReferrer_MemberWithdrawAsOne." + ky;
    }

    protected Map<String, TweetCQ> _memberId_ExistsReferrer_TweetListMap;
    public Map<String, TweetCQ> getMemberId_ExistsReferrer_TweetList() { return _memberId_ExistsReferrer_TweetListMap; }
    public String keepMemberId_ExistsReferrer_TweetList(TweetCQ sq) {
        if (_memberId_ExistsReferrer_TweetListMap == null) { _memberId_ExistsReferrer_TweetListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_ExistsReferrer_TweetListMap.size() + 1);
        _memberId_ExistsReferrer_TweetListMap.put(ky, sq); return "memberId_ExistsReferrer_TweetList." + ky;
    }

    protected Map<String, FollowCQ> _memberId_NotExistsReferrer_FollowAsOneMap;
    public Map<String, FollowCQ> getMemberId_NotExistsReferrer_FollowAsOne() { return _memberId_NotExistsReferrer_FollowAsOneMap; }
    public String keepMemberId_NotExistsReferrer_FollowAsOne(FollowCQ sq) {
        if (_memberId_NotExistsReferrer_FollowAsOneMap == null) { _memberId_NotExistsReferrer_FollowAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotExistsReferrer_FollowAsOneMap.size() + 1);
        _memberId_NotExistsReferrer_FollowAsOneMap.put(ky, sq); return "memberId_NotExistsReferrer_FollowAsOne." + ky;
    }

    protected Map<String, FollowersCQ> _memberId_NotExistsReferrer_FollowersAsOneMap;
    public Map<String, FollowersCQ> getMemberId_NotExistsReferrer_FollowersAsOne() { return _memberId_NotExistsReferrer_FollowersAsOneMap; }
    public String keepMemberId_NotExistsReferrer_FollowersAsOne(FollowersCQ sq) {
        if (_memberId_NotExistsReferrer_FollowersAsOneMap == null) { _memberId_NotExistsReferrer_FollowersAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotExistsReferrer_FollowersAsOneMap.size() + 1);
        _memberId_NotExistsReferrer_FollowersAsOneMap.put(ky, sq); return "memberId_NotExistsReferrer_FollowersAsOne." + ky;
    }

    protected Map<String, LoginCQ> _memberId_NotExistsReferrer_LoginListMap;
    public Map<String, LoginCQ> getMemberId_NotExistsReferrer_LoginList() { return _memberId_NotExistsReferrer_LoginListMap; }
    public String keepMemberId_NotExistsReferrer_LoginList(LoginCQ sq) {
        if (_memberId_NotExistsReferrer_LoginListMap == null) { _memberId_NotExistsReferrer_LoginListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotExistsReferrer_LoginListMap.size() + 1);
        _memberId_NotExistsReferrer_LoginListMap.put(ky, sq); return "memberId_NotExistsReferrer_LoginList." + ky;
    }

    protected Map<String, MemberSecurityCQ> _memberId_NotExistsReferrer_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_NotExistsReferrer_MemberSecurityAsOne() { return _memberId_NotExistsReferrer_MemberSecurityAsOneMap; }
    public String keepMemberId_NotExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq) {
        if (_memberId_NotExistsReferrer_MemberSecurityAsOneMap == null) { _memberId_NotExistsReferrer_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotExistsReferrer_MemberSecurityAsOneMap.size() + 1);
        _memberId_NotExistsReferrer_MemberSecurityAsOneMap.put(ky, sq); return "memberId_NotExistsReferrer_MemberSecurityAsOne." + ky;
    }

    protected Map<String, MemberWithdrawCQ> _memberId_NotExistsReferrer_MemberWithdrawAsOneMap;
    public Map<String, MemberWithdrawCQ> getMemberId_NotExistsReferrer_MemberWithdrawAsOne() { return _memberId_NotExistsReferrer_MemberWithdrawAsOneMap; }
    public String keepMemberId_NotExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq) {
        if (_memberId_NotExistsReferrer_MemberWithdrawAsOneMap == null) { _memberId_NotExistsReferrer_MemberWithdrawAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotExistsReferrer_MemberWithdrawAsOneMap.size() + 1);
        _memberId_NotExistsReferrer_MemberWithdrawAsOneMap.put(ky, sq); return "memberId_NotExistsReferrer_MemberWithdrawAsOne." + ky;
    }

    protected Map<String, TweetCQ> _memberId_NotExistsReferrer_TweetListMap;
    public Map<String, TweetCQ> getMemberId_NotExistsReferrer_TweetList() { return _memberId_NotExistsReferrer_TweetListMap; }
    public String keepMemberId_NotExistsReferrer_TweetList(TweetCQ sq) {
        if (_memberId_NotExistsReferrer_TweetListMap == null) { _memberId_NotExistsReferrer_TweetListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotExistsReferrer_TweetListMap.size() + 1);
        _memberId_NotExistsReferrer_TweetListMap.put(ky, sq); return "memberId_NotExistsReferrer_TweetList." + ky;
    }

    protected Map<String, LoginCQ> _memberId_SpecifyDerivedReferrer_LoginListMap;
    public Map<String, LoginCQ> getMemberId_SpecifyDerivedReferrer_LoginList() { return _memberId_SpecifyDerivedReferrer_LoginListMap; }
    public String keepMemberId_SpecifyDerivedReferrer_LoginList(LoginCQ sq) {
        if (_memberId_SpecifyDerivedReferrer_LoginListMap == null) { _memberId_SpecifyDerivedReferrer_LoginListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_SpecifyDerivedReferrer_LoginListMap.size() + 1);
        _memberId_SpecifyDerivedReferrer_LoginListMap.put(ky, sq); return "memberId_SpecifyDerivedReferrer_LoginList." + ky;
    }

    protected Map<String, TweetCQ> _memberId_SpecifyDerivedReferrer_TweetListMap;
    public Map<String, TweetCQ> getMemberId_SpecifyDerivedReferrer_TweetList() { return _memberId_SpecifyDerivedReferrer_TweetListMap; }
    public String keepMemberId_SpecifyDerivedReferrer_TweetList(TweetCQ sq) {
        if (_memberId_SpecifyDerivedReferrer_TweetListMap == null) { _memberId_SpecifyDerivedReferrer_TweetListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_SpecifyDerivedReferrer_TweetListMap.size() + 1);
        _memberId_SpecifyDerivedReferrer_TweetListMap.put(ky, sq); return "memberId_SpecifyDerivedReferrer_TweetList." + ky;
    }

    protected Map<String, FollowCQ> _memberId_InScopeRelation_FollowAsOneMap;
    public Map<String, FollowCQ> getMemberId_InScopeRelation_FollowAsOne() { return _memberId_InScopeRelation_FollowAsOneMap; }
    public String keepMemberId_InScopeRelation_FollowAsOne(FollowCQ sq) {
        if (_memberId_InScopeRelation_FollowAsOneMap == null) { _memberId_InScopeRelation_FollowAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_InScopeRelation_FollowAsOneMap.size() + 1);
        _memberId_InScopeRelation_FollowAsOneMap.put(ky, sq); return "memberId_InScopeRelation_FollowAsOne." + ky;
    }

    protected Map<String, FollowersCQ> _memberId_InScopeRelation_FollowersAsOneMap;
    public Map<String, FollowersCQ> getMemberId_InScopeRelation_FollowersAsOne() { return _memberId_InScopeRelation_FollowersAsOneMap; }
    public String keepMemberId_InScopeRelation_FollowersAsOne(FollowersCQ sq) {
        if (_memberId_InScopeRelation_FollowersAsOneMap == null) { _memberId_InScopeRelation_FollowersAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_InScopeRelation_FollowersAsOneMap.size() + 1);
        _memberId_InScopeRelation_FollowersAsOneMap.put(ky, sq); return "memberId_InScopeRelation_FollowersAsOne." + ky;
    }

    protected Map<String, LoginCQ> _memberId_InScopeRelation_LoginListMap;
    public Map<String, LoginCQ> getMemberId_InScopeRelation_LoginList() { return _memberId_InScopeRelation_LoginListMap; }
    public String keepMemberId_InScopeRelation_LoginList(LoginCQ sq) {
        if (_memberId_InScopeRelation_LoginListMap == null) { _memberId_InScopeRelation_LoginListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_InScopeRelation_LoginListMap.size() + 1);
        _memberId_InScopeRelation_LoginListMap.put(ky, sq); return "memberId_InScopeRelation_LoginList." + ky;
    }

    protected Map<String, MemberSecurityCQ> _memberId_InScopeRelation_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_InScopeRelation_MemberSecurityAsOne() { return _memberId_InScopeRelation_MemberSecurityAsOneMap; }
    public String keepMemberId_InScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq) {
        if (_memberId_InScopeRelation_MemberSecurityAsOneMap == null) { _memberId_InScopeRelation_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_InScopeRelation_MemberSecurityAsOneMap.size() + 1);
        _memberId_InScopeRelation_MemberSecurityAsOneMap.put(ky, sq); return "memberId_InScopeRelation_MemberSecurityAsOne." + ky;
    }

    protected Map<String, MemberWithdrawCQ> _memberId_InScopeRelation_MemberWithdrawAsOneMap;
    public Map<String, MemberWithdrawCQ> getMemberId_InScopeRelation_MemberWithdrawAsOne() { return _memberId_InScopeRelation_MemberWithdrawAsOneMap; }
    public String keepMemberId_InScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq) {
        if (_memberId_InScopeRelation_MemberWithdrawAsOneMap == null) { _memberId_InScopeRelation_MemberWithdrawAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_InScopeRelation_MemberWithdrawAsOneMap.size() + 1);
        _memberId_InScopeRelation_MemberWithdrawAsOneMap.put(ky, sq); return "memberId_InScopeRelation_MemberWithdrawAsOne." + ky;
    }

    protected Map<String, TweetCQ> _memberId_InScopeRelation_TweetListMap;
    public Map<String, TweetCQ> getMemberId_InScopeRelation_TweetList() { return _memberId_InScopeRelation_TweetListMap; }
    public String keepMemberId_InScopeRelation_TweetList(TweetCQ sq) {
        if (_memberId_InScopeRelation_TweetListMap == null) { _memberId_InScopeRelation_TweetListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_InScopeRelation_TweetListMap.size() + 1);
        _memberId_InScopeRelation_TweetListMap.put(ky, sq); return "memberId_InScopeRelation_TweetList." + ky;
    }

    protected Map<String, FollowCQ> _memberId_NotInScopeRelation_FollowAsOneMap;
    public Map<String, FollowCQ> getMemberId_NotInScopeRelation_FollowAsOne() { return _memberId_NotInScopeRelation_FollowAsOneMap; }
    public String keepMemberId_NotInScopeRelation_FollowAsOne(FollowCQ sq) {
        if (_memberId_NotInScopeRelation_FollowAsOneMap == null) { _memberId_NotInScopeRelation_FollowAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotInScopeRelation_FollowAsOneMap.size() + 1);
        _memberId_NotInScopeRelation_FollowAsOneMap.put(ky, sq); return "memberId_NotInScopeRelation_FollowAsOne." + ky;
    }

    protected Map<String, FollowersCQ> _memberId_NotInScopeRelation_FollowersAsOneMap;
    public Map<String, FollowersCQ> getMemberId_NotInScopeRelation_FollowersAsOne() { return _memberId_NotInScopeRelation_FollowersAsOneMap; }
    public String keepMemberId_NotInScopeRelation_FollowersAsOne(FollowersCQ sq) {
        if (_memberId_NotInScopeRelation_FollowersAsOneMap == null) { _memberId_NotInScopeRelation_FollowersAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotInScopeRelation_FollowersAsOneMap.size() + 1);
        _memberId_NotInScopeRelation_FollowersAsOneMap.put(ky, sq); return "memberId_NotInScopeRelation_FollowersAsOne." + ky;
    }

    protected Map<String, LoginCQ> _memberId_NotInScopeRelation_LoginListMap;
    public Map<String, LoginCQ> getMemberId_NotInScopeRelation_LoginList() { return _memberId_NotInScopeRelation_LoginListMap; }
    public String keepMemberId_NotInScopeRelation_LoginList(LoginCQ sq) {
        if (_memberId_NotInScopeRelation_LoginListMap == null) { _memberId_NotInScopeRelation_LoginListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotInScopeRelation_LoginListMap.size() + 1);
        _memberId_NotInScopeRelation_LoginListMap.put(ky, sq); return "memberId_NotInScopeRelation_LoginList." + ky;
    }

    protected Map<String, MemberSecurityCQ> _memberId_NotInScopeRelation_MemberSecurityAsOneMap;
    public Map<String, MemberSecurityCQ> getMemberId_NotInScopeRelation_MemberSecurityAsOne() { return _memberId_NotInScopeRelation_MemberSecurityAsOneMap; }
    public String keepMemberId_NotInScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq) {
        if (_memberId_NotInScopeRelation_MemberSecurityAsOneMap == null) { _memberId_NotInScopeRelation_MemberSecurityAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotInScopeRelation_MemberSecurityAsOneMap.size() + 1);
        _memberId_NotInScopeRelation_MemberSecurityAsOneMap.put(ky, sq); return "memberId_NotInScopeRelation_MemberSecurityAsOne." + ky;
    }

    protected Map<String, MemberWithdrawCQ> _memberId_NotInScopeRelation_MemberWithdrawAsOneMap;
    public Map<String, MemberWithdrawCQ> getMemberId_NotInScopeRelation_MemberWithdrawAsOne() { return _memberId_NotInScopeRelation_MemberWithdrawAsOneMap; }
    public String keepMemberId_NotInScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq) {
        if (_memberId_NotInScopeRelation_MemberWithdrawAsOneMap == null) { _memberId_NotInScopeRelation_MemberWithdrawAsOneMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotInScopeRelation_MemberWithdrawAsOneMap.size() + 1);
        _memberId_NotInScopeRelation_MemberWithdrawAsOneMap.put(ky, sq); return "memberId_NotInScopeRelation_MemberWithdrawAsOne." + ky;
    }

    protected Map<String, TweetCQ> _memberId_NotInScopeRelation_TweetListMap;
    public Map<String, TweetCQ> getMemberId_NotInScopeRelation_TweetList() { return _memberId_NotInScopeRelation_TweetListMap; }
    public String keepMemberId_NotInScopeRelation_TweetList(TweetCQ sq) {
        if (_memberId_NotInScopeRelation_TweetListMap == null) { _memberId_NotInScopeRelation_TweetListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_NotInScopeRelation_TweetListMap.size() + 1);
        _memberId_NotInScopeRelation_TweetListMap.put(ky, sq); return "memberId_NotInScopeRelation_TweetList." + ky;
    }

    protected Map<String, LoginCQ> _memberId_QueryDerivedReferrer_LoginListMap;
    public Map<String, LoginCQ> getMemberId_QueryDerivedReferrer_LoginList() { return _memberId_QueryDerivedReferrer_LoginListMap; }
    public String keepMemberId_QueryDerivedReferrer_LoginList(LoginCQ sq) {
        if (_memberId_QueryDerivedReferrer_LoginListMap == null) { _memberId_QueryDerivedReferrer_LoginListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_QueryDerivedReferrer_LoginListMap.size() + 1);
        _memberId_QueryDerivedReferrer_LoginListMap.put(ky, sq); return "memberId_QueryDerivedReferrer_LoginList." + ky;
    }
    protected Map<String, Object> _memberId_QueryDerivedReferrer_LoginListParameterMap;
    public Map<String, Object> getMemberId_QueryDerivedReferrer_LoginListParameter() { return _memberId_QueryDerivedReferrer_LoginListParameterMap; }
    public String keepMemberId_QueryDerivedReferrer_LoginListParameter(Object vl) {
        if (_memberId_QueryDerivedReferrer_LoginListParameterMap == null) { _memberId_QueryDerivedReferrer_LoginListParameterMap = newLinkedHashMapSized(4); }
        String ky = "subQueryParameterKey" + (_memberId_QueryDerivedReferrer_LoginListParameterMap.size() + 1);
        _memberId_QueryDerivedReferrer_LoginListParameterMap.put(ky, vl); return "memberId_QueryDerivedReferrer_LoginListParameter." + ky;
    }

    protected Map<String, TweetCQ> _memberId_QueryDerivedReferrer_TweetListMap;
    public Map<String, TweetCQ> getMemberId_QueryDerivedReferrer_TweetList() { return _memberId_QueryDerivedReferrer_TweetListMap; }
    public String keepMemberId_QueryDerivedReferrer_TweetList(TweetCQ sq) {
        if (_memberId_QueryDerivedReferrer_TweetListMap == null) { _memberId_QueryDerivedReferrer_TweetListMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_memberId_QueryDerivedReferrer_TweetListMap.size() + 1);
        _memberId_QueryDerivedReferrer_TweetListMap.put(ky, sq); return "memberId_QueryDerivedReferrer_TweetList." + ky;
    }
    protected Map<String, Object> _memberId_QueryDerivedReferrer_TweetListParameterMap;
    public Map<String, Object> getMemberId_QueryDerivedReferrer_TweetListParameter() { return _memberId_QueryDerivedReferrer_TweetListParameterMap; }
    public String keepMemberId_QueryDerivedReferrer_TweetListParameter(Object vl) {
        if (_memberId_QueryDerivedReferrer_TweetListParameterMap == null) { _memberId_QueryDerivedReferrer_TweetListParameterMap = newLinkedHashMapSized(4); }
        String ky = "subQueryParameterKey" + (_memberId_QueryDerivedReferrer_TweetListParameterMap.size() + 1);
        _memberId_QueryDerivedReferrer_TweetListParameterMap.put(ky, vl); return "memberId_QueryDerivedReferrer_TweetListParameter." + ky;
    }

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
    public ConditionValue getEmailAddress() {
        if (_emailAddress == null) { _emailAddress = nCV(); }
        return _emailAddress;
    }
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
    public ConditionValue getUserName() {
        if (_userName == null) { _userName = nCV(); }
        return _userName;
    }
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
    public ConditionValue getUpdateDatetime() {
        if (_updateDatetime == null) { _updateDatetime = nCV(); }
        return _updateDatetime;
    }
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
    public ConditionValue getBirthdate() {
        if (_birthdate == null) { _birthdate = nCV(); }
        return _birthdate;
    }
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
    public ConditionValue getProfile() {
        if (_profile == null) { _profile = nCV(); }
        return _profile;
    }
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
    public ConditionValue getRegesterDatetime() {
        if (_regesterDatetime == null) { _regesterDatetime = nCV(); }
        return _regesterDatetime;
    }
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
    public BsMemberCQ addSpecifiedDerivedOrderBy_Asc(String aliasName)
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
    public BsMemberCQ addSpecifiedDerivedOrderBy_Desc(String aliasName)
    { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

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
    public FollowCQ queryFollowAsOne() {
        return getConditionQueryFollowAsOne();
    }
    protected FollowCQ _conditionQueryFollowAsOne;
    public FollowCQ getConditionQueryFollowAsOne() {
        if (_conditionQueryFollowAsOne == null) {
            _conditionQueryFollowAsOne = xcreateQueryFollowAsOne();
            xsetupOuterJoinFollowAsOne();
        }
        return _conditionQueryFollowAsOne;
    }
    protected FollowCQ xcreateQueryFollowAsOne() {
        String nrp = resolveNextRelationPath("member", "followAsOne");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        FollowCQ cq = new FollowCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("followAsOne");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinFollowAsOne() {
        FollowCQ cq = getConditionQueryFollowAsOne();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "followAsOne");
    }
    public boolean hasConditionQueryFollowAsOne() {
        return _conditionQueryFollowAsOne != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * followers by MEMBER_ID, named 'followersAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public FollowersCQ queryFollowersAsOne() {
        return getConditionQueryFollowersAsOne();
    }
    protected FollowersCQ _conditionQueryFollowersAsOne;
    public FollowersCQ getConditionQueryFollowersAsOne() {
        if (_conditionQueryFollowersAsOne == null) {
            _conditionQueryFollowersAsOne = xcreateQueryFollowersAsOne();
            xsetupOuterJoinFollowersAsOne();
        }
        return _conditionQueryFollowersAsOne;
    }
    protected FollowersCQ xcreateQueryFollowersAsOne() {
        String nrp = resolveNextRelationPath("member", "followersAsOne");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        FollowersCQ cq = new FollowersCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("followersAsOne");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinFollowersAsOne() {
        FollowersCQ cq = getConditionQueryFollowersAsOne();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "followersAsOne");
    }
    public boolean hasConditionQueryFollowersAsOne() {
        return _conditionQueryFollowersAsOne != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberSecurityCQ queryMemberSecurityAsOne() {
        return getConditionQueryMemberSecurityAsOne();
    }
    protected MemberSecurityCQ _conditionQueryMemberSecurityAsOne;
    public MemberSecurityCQ getConditionQueryMemberSecurityAsOne() {
        if (_conditionQueryMemberSecurityAsOne == null) {
            _conditionQueryMemberSecurityAsOne = xcreateQueryMemberSecurityAsOne();
            xsetupOuterJoinMemberSecurityAsOne();
        }
        return _conditionQueryMemberSecurityAsOne;
    }
    protected MemberSecurityCQ xcreateQueryMemberSecurityAsOne() {
        String nrp = resolveNextRelationPath("member", "memberSecurityAsOne");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberSecurityCQ cq = new MemberSecurityCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberSecurityAsOne");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberSecurityAsOne() {
        MemberSecurityCQ cq = getConditionQueryMemberSecurityAsOne();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberSecurityAsOne");
    }
    public boolean hasConditionQueryMemberSecurityAsOne() {
        return _conditionQueryMemberSecurityAsOne != null;
    }

    /**
     * Get the condition-query for relation table. <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberWithdrawCQ queryMemberWithdrawAsOne() {
        return getConditionQueryMemberWithdrawAsOne();
    }
    protected MemberWithdrawCQ _conditionQueryMemberWithdrawAsOne;
    public MemberWithdrawCQ getConditionQueryMemberWithdrawAsOne() {
        if (_conditionQueryMemberWithdrawAsOne == null) {
            _conditionQueryMemberWithdrawAsOne = xcreateQueryMemberWithdrawAsOne();
            xsetupOuterJoinMemberWithdrawAsOne();
        }
        return _conditionQueryMemberWithdrawAsOne;
    }
    protected MemberWithdrawCQ xcreateQueryMemberWithdrawAsOne() {
        String nrp = resolveNextRelationPath("member", "memberWithdrawAsOne");
        String jan = resolveJoinAliasName(nrp, xgetNextNestLevel());
        MemberWithdrawCQ cq = new MemberWithdrawCQ(this, xgetSqlClause(), jan, xgetNextNestLevel());
        cq.xsetBaseCB(_baseCB);
        cq.xsetForeignPropertyName("memberWithdrawAsOne");
        cq.xsetRelationPath(nrp); return cq;
    }
    protected void xsetupOuterJoinMemberWithdrawAsOne() {
        MemberWithdrawCQ cq = getConditionQueryMemberWithdrawAsOne();
        Map<String, String> joinOnMap = newLinkedHashMapSized(4);
        joinOnMap.put("MEMBER_ID", "MEMBER_ID");
        registerOuterJoin(cq, joinOnMap, "memberWithdrawAsOne");
    }
    public boolean hasConditionQueryMemberWithdrawAsOne() {
        return _conditionQueryMemberWithdrawAsOne != null;
    }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    protected Map<String, MemberCQ> _scalarConditionMap;
    public Map<String, MemberCQ> getScalarCondition() { return _scalarConditionMap; }
    public String keepScalarCondition(MemberCQ sq) {
        if (_scalarConditionMap == null) { _scalarConditionMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_scalarConditionMap.size() + 1);
        _scalarConditionMap.put(ky, sq); return "scalarCondition." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    protected Map<String, MemberCQ> _specifyMyselfDerivedMap;
    public Map<String, MemberCQ> getSpecifyMyselfDerived() { return _specifyMyselfDerivedMap; }
    public String keepSpecifyMyselfDerived(MemberCQ sq) {
        if (_specifyMyselfDerivedMap == null) { _specifyMyselfDerivedMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_specifyMyselfDerivedMap.size() + 1);
        _specifyMyselfDerivedMap.put(ky, sq); return "specifyMyselfDerived." + ky;
    }

    protected Map<String, MemberCQ> _queryMyselfDerivedMap;
    public Map<String, MemberCQ> getQueryMyselfDerived() { return _queryMyselfDerivedMap; }
    public String keepQueryMyselfDerived(MemberCQ sq) {
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
    protected Map<String, MemberCQ> _myselfExistsMap;
    public Map<String, MemberCQ> getMyselfExists() { return _myselfExistsMap; }
    public String keepMyselfExists(MemberCQ sq) {
        if (_myselfExistsMap == null) { _myselfExistsMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfExistsMap.size() + 1);
        _myselfExistsMap.put(ky, sq); return "myselfExists." + ky;
    }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    protected Map<String, MemberCQ> _myselfInScopeMap;
    public Map<String, MemberCQ> getMyselfInScope() { return _myselfInScopeMap; }
    public String keepMyselfInScope(MemberCQ sq) {
        if (_myselfInScopeMap == null) { _myselfInScopeMap = newLinkedHashMapSized(4); }
        String ky = "subQueryMapKey" + (_myselfInScopeMap.size() + 1);
        _myselfInScopeMap.put(ky, sq); return "myselfInScope." + ky;
    }

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
