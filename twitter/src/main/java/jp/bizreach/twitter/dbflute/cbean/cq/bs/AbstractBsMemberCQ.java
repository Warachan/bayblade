package jp.bizreach.twitter.dbflute.cbean.cq.bs;

import java.util.*;

import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.ckey.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.cvalue.ConditionValue;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import jp.bizreach.twitter.dbflute.allcommon.*;
import jp.bizreach.twitter.dbflute.cbean.*;
import jp.bizreach.twitter.dbflute.cbean.cq.*;

/**
 * The abstract condition-query of member.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsMemberCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsMemberCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider xgetDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider();
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "member";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberId The value of memberId as equal. (NullAllowed: if null, no condition)
     */
    public void setMemberId_Equal(Integer memberId) {
        doSetMemberId_Equal(memberId);
    }

    protected void doSetMemberId_Equal(Integer memberId) {
        regMemberId(CK_EQ, memberId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberId The value of memberId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_NotEqual(Integer memberId) {
        doSetMemberId_NotEqual(memberId);
    }

    protected void doSetMemberId_NotEqual(Integer memberId) {
        regMemberId(CK_NES, memberId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberId The value of memberId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setMemberId_GreaterThan(Integer memberId) {
        regMemberId(CK_GT, memberId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberId The value of memberId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setMemberId_LessThan(Integer memberId) {
        regMemberId(CK_LT, memberId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberId The value of memberId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_GreaterEqual(Integer memberId) {
        regMemberId(CK_GE, memberId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberId The value of memberId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_LessEqual(Integer memberId) {
        regMemberId(CK_LE, memberId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param minNumber The min number of memberId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of memberId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setMemberId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueMemberId(), "MEMBER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberIdList The collection of memberId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberId_InScope(Collection<Integer> memberIdList) {
        doSetMemberId_InScope(memberIdList);
    }

    protected void doSetMemberId_InScope(Collection<Integer> memberIdList) {
        regINS(CK_INS, cTL(memberIdList), getCValueMemberId(), "MEMBER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @param memberIdList The collection of memberId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberId_NotInScope(Collection<Integer> memberIdList) {
        doSetMemberId_NotInScope(memberIdList);
    }

    protected void doSetMemberId_NotInScope(Collection<Integer> memberIdList) {
        regINS(CK_NINS, cTL(memberIdList), getCValueMemberId(), "MEMBER_ID");
    }

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsFollowAsOne</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of FollowAsOne for 'exists'. (NotNull)
     */
    public void existsFollowAsOne(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_FollowAsOne(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followAsOne");
    }
    public abstract String keepMemberId_ExistsReferrer_FollowAsOne(FollowCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_ID from followers where ...)} <br />
     * followers by MEMBER_ID, named 'followersAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsFollowersAsOne</span>(new SubQuery&lt;FollowersCB&gt;() {
     *     public void query(FollowersCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of FollowersAsOne for 'exists'. (NotNull)
     */
    public void existsFollowersAsOne(SubQuery<FollowersCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowersCB cb = new FollowersCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_FollowersAsOne(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followersAsOne");
    }
    public abstract String keepMemberId_ExistsReferrer_FollowersAsOne(FollowersCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_ID from login where ...)} <br />
     * login by MEMBER_ID, named 'loginAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsLoginList</span>(new SubQuery&lt;LoginCB&gt;() {
     *     public void query(LoginCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of LoginList for 'exists'. (NotNull)
     */
    public void existsLoginList(SubQuery<LoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        LoginCB cb = new LoginCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_LoginList(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "loginList");
    }
    public abstract String keepMemberId_ExistsReferrer_LoginList(LoginCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_ID from member_security where ...)} <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsMemberSecurityAsOne</span>(new SubQuery&lt;MemberSecurityCB&gt;() {
     *     public void query(MemberSecurityCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberSecurityAsOne for 'exists'. (NotNull)
     */
    public void existsMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_MemberSecurityAsOne(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_ExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_ID from member_withdraw where ...)} <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsMemberWithdrawAsOne</span>(new SubQuery&lt;MemberWithdrawCB&gt;() {
     *     public void query(MemberWithdrawCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberWithdrawAsOne for 'exists'. (NotNull)
     */
    public void existsMemberWithdrawAsOne(SubQuery<MemberWithdrawCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawCB cb = new MemberWithdrawCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_MemberWithdrawAsOne(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawAsOne");
    }
    public abstract String keepMemberId_ExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_ID from tweet where ...)} <br />
     * tweet by MEMBER_ID, named 'tweetAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsTweetList</span>(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of TweetList for 'exists'. (NotNull)
     */
    public void existsTweetList(SubQuery<TweetCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        TweetCB cb = new TweetCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_TweetList(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "tweetList");
    }
    public abstract String keepMemberId_ExistsReferrer_TweetList(TweetCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsFollowAsOne</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_FollowAsOne for 'not exists'. (NotNull)
     */
    public void notExistsFollowAsOne(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_FollowAsOne(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followAsOne");
    }
    public abstract String keepMemberId_NotExistsReferrer_FollowAsOne(FollowCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_ID from followers where ...)} <br />
     * followers by MEMBER_ID, named 'followersAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsFollowersAsOne</span>(new SubQuery&lt;FollowersCB&gt;() {
     *     public void query(FollowersCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_FollowersAsOne for 'not exists'. (NotNull)
     */
    public void notExistsFollowersAsOne(SubQuery<FollowersCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowersCB cb = new FollowersCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_FollowersAsOne(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followersAsOne");
    }
    public abstract String keepMemberId_NotExistsReferrer_FollowersAsOne(FollowersCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_ID from login where ...)} <br />
     * login by MEMBER_ID, named 'loginAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsLoginList</span>(new SubQuery&lt;LoginCB&gt;() {
     *     public void query(LoginCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_LoginList for 'not exists'. (NotNull)
     */
    public void notExistsLoginList(SubQuery<LoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        LoginCB cb = new LoginCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_LoginList(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "loginList");
    }
    public abstract String keepMemberId_NotExistsReferrer_LoginList(LoginCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_ID from member_security where ...)} <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsMemberSecurityAsOne</span>(new SubQuery&lt;MemberSecurityCB&gt;() {
     *     public void query(MemberSecurityCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MemberSecurityAsOne for 'not exists'. (NotNull)
     */
    public void notExistsMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_MemberSecurityAsOne(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_NotExistsReferrer_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_ID from member_withdraw where ...)} <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsMemberWithdrawAsOne</span>(new SubQuery&lt;MemberWithdrawCB&gt;() {
     *     public void query(MemberWithdrawCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MemberWithdrawAsOne for 'not exists'. (NotNull)
     */
    public void notExistsMemberWithdrawAsOne(SubQuery<MemberWithdrawCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawCB cb = new MemberWithdrawCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_MemberWithdrawAsOne(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawAsOne");
    }
    public abstract String keepMemberId_NotExistsReferrer_MemberWithdrawAsOne(MemberWithdrawCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_ID from tweet where ...)} <br />
     * tweet by MEMBER_ID, named 'tweetAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsTweetList</span>(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_TweetList for 'not exists'. (NotNull)
     */
    public void notExistsTweetList(SubQuery<TweetCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        TweetCB cb = new TweetCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_TweetList(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "tweetList");
    }
    public abstract String keepMemberId_NotExistsReferrer_TweetList(TweetCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followAsOne'.
     * @param subQuery The sub-query of FollowAsOne for 'in-scope'. (NotNull)
     */
    public void inScopeFollowAsOne(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_FollowAsOne(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followAsOne");
    }
    public abstract String keepMemberId_InScopeRelation_FollowAsOne(FollowCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from followers where ...)} <br />
     * followers by MEMBER_ID, named 'followersAsOne'.
     * @param subQuery The sub-query of FollowersAsOne for 'in-scope'. (NotNull)
     */
    public void inScopeFollowersAsOne(SubQuery<FollowersCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowersCB cb = new FollowersCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_FollowersAsOne(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followersAsOne");
    }
    public abstract String keepMemberId_InScopeRelation_FollowersAsOne(FollowersCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from login where ...)} <br />
     * login by MEMBER_ID, named 'loginAsOne'.
     * @param subQuery The sub-query of LoginList for 'in-scope'. (NotNull)
     */
    public void inScopeLoginList(SubQuery<LoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        LoginCB cb = new LoginCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_LoginList(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "loginList");
    }
    public abstract String keepMemberId_InScopeRelation_LoginList(LoginCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from member_security where ...)} <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @param subQuery The sub-query of MemberSecurityAsOne for 'in-scope'. (NotNull)
     */
    public void inScopeMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_MemberSecurityAsOne(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_InScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from member_withdraw where ...)} <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @param subQuery The sub-query of MemberWithdrawAsOne for 'in-scope'. (NotNull)
     */
    public void inScopeMemberWithdrawAsOne(SubQuery<MemberWithdrawCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawCB cb = new MemberWithdrawCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_MemberWithdrawAsOne(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawAsOne");
    }
    public abstract String keepMemberId_InScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from tweet where ...)} <br />
     * tweet by MEMBER_ID, named 'tweetAsOne'.
     * @param subQuery The sub-query of TweetList for 'in-scope'. (NotNull)
     */
    public void inScopeTweetList(SubQuery<TweetCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        TweetCB cb = new TweetCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_TweetList(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "tweetList");
    }
    public abstract String keepMemberId_InScopeRelation_TweetList(TweetCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followAsOne'.
     * @param subQuery The sub-query of FollowAsOne for 'not in-scope'. (NotNull)
     */
    public void notInScopeFollowAsOne(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_FollowAsOne(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followAsOne");
    }
    public abstract String keepMemberId_NotInScopeRelation_FollowAsOne(FollowCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from followers where ...)} <br />
     * followers by MEMBER_ID, named 'followersAsOne'.
     * @param subQuery The sub-query of FollowersAsOne for 'not in-scope'. (NotNull)
     */
    public void notInScopeFollowersAsOne(SubQuery<FollowersCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowersCB cb = new FollowersCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_FollowersAsOne(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followersAsOne");
    }
    public abstract String keepMemberId_NotInScopeRelation_FollowersAsOne(FollowersCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from login where ...)} <br />
     * login by MEMBER_ID, named 'loginAsOne'.
     * @param subQuery The sub-query of LoginList for 'not in-scope'. (NotNull)
     */
    public void notInScopeLoginList(SubQuery<LoginCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        LoginCB cb = new LoginCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_LoginList(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "loginList");
    }
    public abstract String keepMemberId_NotInScopeRelation_LoginList(LoginCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from member_security where ...)} <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @param subQuery The sub-query of MemberSecurityAsOne for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberSecurityAsOne(SubQuery<MemberSecurityCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberSecurityCB cb = new MemberSecurityCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_MemberSecurityAsOne(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberSecurityAsOne");
    }
    public abstract String keepMemberId_NotInScopeRelation_MemberSecurityAsOne(MemberSecurityCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from member_withdraw where ...)} <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @param subQuery The sub-query of MemberWithdrawAsOne for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberWithdrawAsOne(SubQuery<MemberWithdrawCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberWithdrawCB cb = new MemberWithdrawCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_MemberWithdrawAsOne(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "memberWithdrawAsOne");
    }
    public abstract String keepMemberId_NotInScopeRelation_MemberWithdrawAsOne(MemberWithdrawCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from tweet where ...)} <br />
     * tweet by MEMBER_ID, named 'tweetAsOne'.
     * @param subQuery The sub-query of TweetList for 'not in-scope'. (NotNull)
     */
    public void notInScopeTweetList(SubQuery<TweetCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        TweetCB cb = new TweetCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_TweetList(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "tweetList");
    }
    public abstract String keepMemberId_NotInScopeRelation_TweetList(TweetCQ sq);

    public void xsderiveLoginList(String fn, SubQuery<LoginCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        LoginCB cb = new LoginCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberId_SpecifyDerivedReferrer_LoginList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "loginList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_LoginList(LoginCQ sq);

    public void xsderiveTweetList(String fn, SubQuery<TweetCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        TweetCB cb = new TweetCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberId_SpecifyDerivedReferrer_TweetList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "tweetList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_TweetList(TweetCQ sq);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br />
     * {FOO &lt;= (select max(BAR) from login where ...)} <br />
     * login by MEMBER_ID, named 'loginAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedLoginList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;LoginCB&gt;() {
     *     public void query(LoginCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<LoginCB> derivedLoginList() {
        return xcreateQDRFunctionLoginList();
    }
    protected HpQDRFunction<LoginCB> xcreateQDRFunctionLoginList() {
        return new HpQDRFunction<LoginCB>(new HpQDRSetupper<LoginCB>() {
            public void setup(String fn, SubQuery<LoginCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveLoginList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveLoginList(String fn, SubQuery<LoginCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        LoginCB cb = new LoginCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepMemberId_QueryDerivedReferrer_LoginList(cb.query()); String prpp = keepMemberId_QueryDerivedReferrer_LoginListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", sqpp, "loginList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_LoginList(LoginCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_LoginListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br />
     * {FOO &lt;= (select max(BAR) from tweet where ...)} <br />
     * tweet by MEMBER_ID, named 'tweetAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedTweetList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<TweetCB> derivedTweetList() {
        return xcreateQDRFunctionTweetList();
    }
    protected HpQDRFunction<TweetCB> xcreateQDRFunctionTweetList() {
        return new HpQDRFunction<TweetCB>(new HpQDRSetupper<TweetCB>() {
            public void setup(String fn, SubQuery<TweetCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveTweetList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveTweetList(String fn, SubQuery<TweetCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        TweetCB cb = new TweetCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepMemberId_QueryDerivedReferrer_TweetList(cb.query()); String prpp = keepMemberId_QueryDerivedReferrer_TweetListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", sqpp, "tweetList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_TweetList(TweetCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_TweetListParameter(Object vl);

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setMemberId_IsNull() { regMemberId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setMemberId_IsNotNull() { regMemberId(CK_ISNN, DOBJ); }

    protected void regMemberId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberId(), "MEMBER_ID"); }
    protected abstract ConditionValue getCValueMemberId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_Equal(String emailAddress) {
        doSetEmailAddress_Equal(fRES(emailAddress));
    }

    protected void doSetEmailAddress_Equal(String emailAddress) {
        regEmailAddress(CK_EQ, emailAddress);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_NotEqual(String emailAddress) {
        doSetEmailAddress_NotEqual(fRES(emailAddress));
    }

    protected void doSetEmailAddress_NotEqual(String emailAddress) {
        regEmailAddress(CK_NES, emailAddress);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_GreaterThan(String emailAddress) {
        regEmailAddress(CK_GT, fRES(emailAddress));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_LessThan(String emailAddress) {
        regEmailAddress(CK_LT, fRES(emailAddress));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_GreaterEqual(String emailAddress) {
        regEmailAddress(CK_GE, fRES(emailAddress));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_LessEqual(String emailAddress) {
        regEmailAddress(CK_LE, fRES(emailAddress));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddressList The collection of emailAddress as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_InScope(Collection<String> emailAddressList) {
        doSetEmailAddress_InScope(emailAddressList);
    }

    public void doSetEmailAddress_InScope(Collection<String> emailAddressList) {
        regINS(CK_INS, cTL(emailAddressList), getCValueEmailAddress(), "EMAIL_ADDRESS");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddressList The collection of emailAddress as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_NotInScope(Collection<String> emailAddressList) {
        doSetEmailAddress_NotInScope(emailAddressList);
    }

    public void doSetEmailAddress_NotInScope(Collection<String> emailAddressList) {
        regINS(CK_NINS, cTL(emailAddressList), getCValueEmailAddress(), "EMAIL_ADDRESS");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setEmailAddress_PrefixSearch(String emailAddress) {
        setEmailAddress_LikeSearch(emailAddress, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)} <br />
     * <pre>e.g. setEmailAddress_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param emailAddress The value of emailAddress as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setEmailAddress_LikeSearch(String emailAddress, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(emailAddress), getCValueEmailAddress(), "EMAIL_ADDRESS", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @param emailAddress The value of emailAddress as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setEmailAddress_NotLikeSearch(String emailAddress, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(emailAddress), getCValueEmailAddress(), "EMAIL_ADDRESS", likeSearchOption);
    }

    protected void regEmailAddress(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueEmailAddress(), "EMAIL_ADDRESS"); }
    protected abstract ConditionValue getCValueEmailAddress();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_Equal(String userName) {
        doSetUserName_Equal(fRES(userName));
    }

    protected void doSetUserName_Equal(String userName) {
        regUserName(CK_EQ, userName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_NotEqual(String userName) {
        doSetUserName_NotEqual(fRES(userName));
    }

    protected void doSetUserName_NotEqual(String userName) {
        regUserName(CK_NES, userName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_GreaterThan(String userName) {
        regUserName(CK_GT, fRES(userName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_LessThan(String userName) {
        regUserName(CK_LT, fRES(userName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_GreaterEqual(String userName) {
        regUserName(CK_GE, fRES(userName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_LessEqual(String userName) {
        regUserName(CK_LE, fRES(userName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userNameList The collection of userName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_InScope(Collection<String> userNameList) {
        doSetUserName_InScope(userNameList);
    }

    public void doSetUserName_InScope(Collection<String> userNameList) {
        regINS(CK_INS, cTL(userNameList), getCValueUserName(), "USER_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userNameList The collection of userName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_NotInScope(Collection<String> userNameList) {
        doSetUserName_NotInScope(userNameList);
    }

    public void doSetUserName_NotInScope(Collection<String> userNameList) {
        regINS(CK_NINS, cTL(userNameList), getCValueUserName(), "USER_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_PrefixSearch(String userName) {
        setUserName_LikeSearch(userName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)} <br />
     * <pre>e.g. setUserName_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param userName The value of userName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setUserName_LikeSearch(String userName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(userName), getCValueUserName(), "USER_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @param userName The value of userName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setUserName_NotLikeSearch(String userName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(userName), getCValueUserName(), "USER_NAME", likeSearchOption);
    }

    protected void regUserName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUserName(), "USER_NAME"); }
    protected abstract ConditionValue getCValueUserName();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_Equal(java.sql.Timestamp updateDatetime) {
        regUpdateDatetime(CK_EQ,  updateDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_GreaterThan(java.sql.Timestamp updateDatetime) {
        regUpdateDatetime(CK_GT,  updateDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_LessThan(java.sql.Timestamp updateDatetime) {
        regUpdateDatetime(CK_LT,  updateDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_GreaterEqual(java.sql.Timestamp updateDatetime) {
        regUpdateDatetime(CK_GE,  updateDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * @param updateDatetime The value of updateDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdateDatetime_LessEqual(java.sql.Timestamp updateDatetime) {
        regUpdateDatetime(CK_LE, updateDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * <pre>e.g. setUpdateDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updateDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setUpdateDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueUpdateDatetime(), "UPDATE_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of updateDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of updateDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setUpdateDatetime_DateFromTo(Date fromDate, Date toDate) {
        setUpdateDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     */
    public void setUpdateDatetime_IsNull() { regUpdateDatetime(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * UPDATE_DATETIME: {DATETIME(19)}
     */
    public void setUpdateDatetime_IsNotNull() { regUpdateDatetime(CK_ISNN, DOBJ); }

    protected void regUpdateDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUpdateDatetime(), "UPDATE_DATETIME"); }
    protected abstract ConditionValue getCValueUpdateDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     * @param birthdate The value of birthdate as equal. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_Equal(java.util.Date birthdate) {
        regBirthdate(CK_EQ,  fCTPD(birthdate));
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     * @param birthdate The value of birthdate as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_GreaterThan(java.util.Date birthdate) {
        regBirthdate(CK_GT,  fCTPD(birthdate));
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     * @param birthdate The value of birthdate as lessThan. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_LessThan(java.util.Date birthdate) {
        regBirthdate(CK_LT,  fCTPD(birthdate));
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     * @param birthdate The value of birthdate as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_GreaterEqual(java.util.Date birthdate) {
        regBirthdate(CK_GE,  fCTPD(birthdate));
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     * @param birthdate The value of birthdate as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setBirthdate_LessEqual(java.util.Date birthdate) {
        regBirthdate(CK_LE, fCTPD(birthdate));
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     * <pre>e.g. setBirthdate_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of birthdate. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of birthdate. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setBirthdate_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ(fCTPD(fromDatetime), fCTPD(toDatetime), getCValueBirthdate(), "BIRTHDATE", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of birthdate. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of birthdate. (NullAllowed: if null, no to-condition)
     */
    public void setBirthdate_DateFromTo(Date fromDate, Date toDate) {
        setBirthdate_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     */
    public void setBirthdate_IsNull() { regBirthdate(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * BIRTHDATE: {DATE(10)}
     */
    public void setBirthdate_IsNotNull() { regBirthdate(CK_ISNN, DOBJ); }

    protected void regBirthdate(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueBirthdate(), "BIRTHDATE"); }
    protected abstract ConditionValue getCValueBirthdate();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_Equal(String profile) {
        doSetProfile_Equal(fRES(profile));
    }

    protected void doSetProfile_Equal(String profile) {
        regProfile(CK_EQ, profile);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_NotEqual(String profile) {
        doSetProfile_NotEqual(fRES(profile));
    }

    protected void doSetProfile_NotEqual(String profile) {
        regProfile(CK_NES, profile);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_GreaterThan(String profile) {
        regProfile(CK_GT, fRES(profile));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_LessThan(String profile) {
        regProfile(CK_LT, fRES(profile));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_GreaterEqual(String profile) {
        regProfile(CK_GE, fRES(profile));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_LessEqual(String profile) {
        regProfile(CK_LE, fRES(profile));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profileList The collection of profile as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_InScope(Collection<String> profileList) {
        doSetProfile_InScope(profileList);
    }

    public void doSetProfile_InScope(Collection<String> profileList) {
        regINS(CK_INS, cTL(profileList), getCValueProfile(), "PROFILE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profileList The collection of profile as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_NotInScope(Collection<String> profileList) {
        doSetProfile_NotInScope(profileList);
    }

    public void doSetProfile_NotInScope(Collection<String> profileList) {
        regINS(CK_NINS, cTL(profileList), getCValueProfile(), "PROFILE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setProfile_PrefixSearch(String profile) {
        setProfile_LikeSearch(profile, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PROFILE: {VARCHAR(200)} <br />
     * <pre>e.g. setProfile_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param profile The value of profile as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setProfile_LikeSearch(String profile, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(profile), getCValueProfile(), "PROFILE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     * @param profile The value of profile as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setProfile_NotLikeSearch(String profile, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(profile), getCValueProfile(), "PROFILE", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     */
    public void setProfile_IsNull() { regProfile(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     */
    public void setProfile_IsNullOrEmpty() { regProfile(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * PROFILE: {VARCHAR(200)}
     */
    public void setProfile_IsNotNull() { regProfile(CK_ISNN, DOBJ); }

    protected void regProfile(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueProfile(), "PROFILE"); }
    protected abstract ConditionValue getCValueProfile();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @param regesterDatetime The value of regesterDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setRegesterDatetime_Equal(java.sql.Timestamp regesterDatetime) {
        regRegesterDatetime(CK_EQ,  regesterDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @param regesterDatetime The value of regesterDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setRegesterDatetime_GreaterThan(java.sql.Timestamp regesterDatetime) {
        regRegesterDatetime(CK_GT,  regesterDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @param regesterDatetime The value of regesterDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setRegesterDatetime_LessThan(java.sql.Timestamp regesterDatetime) {
        regRegesterDatetime(CK_LT,  regesterDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @param regesterDatetime The value of regesterDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setRegesterDatetime_GreaterEqual(java.sql.Timestamp regesterDatetime) {
        regRegesterDatetime(CK_GE,  regesterDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @param regesterDatetime The value of regesterDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setRegesterDatetime_LessEqual(java.sql.Timestamp regesterDatetime) {
        regRegesterDatetime(CK_LE, regesterDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setRegesterDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of regesterDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of regesterDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setRegesterDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueRegesterDatetime(), "REGESTER_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of regesterDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of regesterDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setRegesterDatetime_DateFromTo(Date fromDate, Date toDate) {
        setRegesterDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    protected void regRegesterDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueRegesterDatetime(), "REGESTER_DATETIME"); }
    protected abstract ConditionValue getCValueRegesterDatetime();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, MemberCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MemberCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, MemberCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(MemberCQ sq);

    protected MemberCB xcreateScalarConditionCB() {
        MemberCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected MemberCB xcreateScalarConditionPartitionByCB() {
        MemberCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<MemberCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "MEMBER_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(MemberCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<MemberCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(MemberCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MemberCB cb = new MemberCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "MEMBER_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(MemberCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(MemberCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(MemberCQ sq);

    /**
     * Order along manual ordering information.
     * <pre>
     * MemberCB cb = new MemberCB();
     * ManualOrderBean mob = new ManualOrderBean();
     * mob.<span style="color: #DD4747">when_GreaterEqual</span>(priorityDate); <span style="color: #3F7E5E">// e.g. 2000/01/01</span>
     * cb.query().addOrderBy_Birthdate_Asc().<span style="color: #DD4747">withManualOrder(mob)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when BIRTHDATE &gt;= '2000/01/01' then 0</span>
     * <span style="color: #3F7E5E">//     else 1</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     *
     * MemberCB cb = new MemberCB();
     * ManualOrderBean mob = new ManualOrderBean();
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Withdrawal);
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Formalized);
     * mob.<span style="color: #DD4747">when_Equal</span>(CDef.MemberStatus.Provisional);
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #DD4747">withManualOrder(mob)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * <p>This function with Union is unsupported!</p>
     * <p>The order values are bound (treated as bind parameter).</p>
     * @param mob The bean of manual order containing order values. (NotNull)
     */
    public void withManualOrder(ManualOrderBean mob) { // is user public!
        xdoWithManualOrder(mob);
    }

    // ===================================================================================
    //                                                                          Compatible
    //                                                                          ==========
    /**
     * Order along the list of manual values. #beforejava8 <br />
     * This function with Union is unsupported! <br />
     * The order values are bound (treated as bind parameter).
     * <pre>
     * MemberCB cb = new MemberCB();
     * List&lt;CDef.MemberStatus&gt; orderValueList = new ArrayList&lt;CDef.MemberStatus&gt;();
     * orderValueList.add(CDef.MemberStatus.Withdrawal);
     * orderValueList.add(CDef.MemberStatus.Formalized);
     * orderValueList.add(CDef.MemberStatus.Provisional);
     * cb.query().addOrderBy_MemberStatusCode_Asc().<span style="color: #DD4747">withManualOrder(orderValueList)</span>;
     * <span style="color: #3F7E5E">// order by </span>
     * <span style="color: #3F7E5E">//   case</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'WDL' then 0</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'FML' then 1</span>
     * <span style="color: #3F7E5E">//     when MEMBER_STATUS_CODE = 'PRV' then 2</span>
     * <span style="color: #3F7E5E">//     else 3</span>
     * <span style="color: #3F7E5E">//   end asc, ...</span>
     * </pre>
     * @param orderValueList The list of order values for manual ordering. (NotNull)
     */
    public void withManualOrder(List<? extends Object> orderValueList) { // is user public!
        assertObjectNotNull("withManualOrder(orderValueList)", orderValueList);
        final ManualOrderBean manualOrderBean = new ManualOrderBean();
        manualOrderBean.acceptOrderValueList(orderValueList);
        withManualOrder(manualOrderBean);
    }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    protected MemberCB newMyCB() {
        return new MemberCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return MemberCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
