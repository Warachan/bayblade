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
     * {exists (select YOU_ID from follow where ...)} <br />
     * follow by YOU_ID, named 'followByYouIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsFollowByYouIdList</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of FollowByYouIdList for 'exists'. (NotNull)
     */
    public void existsFollowByYouIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_FollowByYouIdList(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "YOU_ID", pp, "followByYouIdList");
    }
    public abstract String keepMemberId_ExistsReferrer_FollowByYouIdList(FollowCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followByMemberIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsFollowByMemberIdList</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of FollowByMemberIdList for 'exists'. (NotNull)
     */
    public void existsFollowByMemberIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_FollowByMemberIdList(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followByMemberIdList");
    }
    public abstract String keepMemberId_ExistsReferrer_FollowByMemberIdList(FollowCQ sq);

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
     * {exists (select SENDER_ID from message where ...)} <br />
     * message by SENDER_ID, named 'messageBySenderIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsMessageBySenderIdList</span>(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MessageBySenderIdList for 'exists'. (NotNull)
     */
    public void existsMessageBySenderIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_MessageBySenderIdList(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "SENDER_ID", pp, "messageBySenderIdList");
    }
    public abstract String keepMemberId_ExistsReferrer_MessageBySenderIdList(MessageCQ sq);

    /**
     * Set up ExistsReferrer (correlated sub-query). <br />
     * {exists (select RECEIVER_ID from message where ...)} <br />
     * message by RECEIVER_ID, named 'messageByReceiverIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">existsMessageByReceiverIdList</span>(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MessageByReceiverIdList for 'exists'. (NotNull)
     */
    public void existsMessageByReceiverIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_ExistsReferrer_MessageByReceiverIdList(cb.query());
        registerExistsReferrer(cb.query(), "MEMBER_ID", "RECEIVER_ID", pp, "messageByReceiverIdList");
    }
    public abstract String keepMemberId_ExistsReferrer_MessageByReceiverIdList(MessageCQ sq);

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
     * {not exists (select YOU_ID from follow where ...)} <br />
     * follow by YOU_ID, named 'followByYouIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsFollowByYouIdList</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_FollowByYouIdList for 'not exists'. (NotNull)
     */
    public void notExistsFollowByYouIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_FollowByYouIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "YOU_ID", pp, "followByYouIdList");
    }
    public abstract String keepMemberId_NotExistsReferrer_FollowByYouIdList(FollowCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followByMemberIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsFollowByMemberIdList</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_FollowByMemberIdList for 'not exists'. (NotNull)
     */
    public void notExistsFollowByMemberIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_FollowByMemberIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followByMemberIdList");
    }
    public abstract String keepMemberId_NotExistsReferrer_FollowByMemberIdList(FollowCQ sq);

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
     * {not exists (select SENDER_ID from message where ...)} <br />
     * message by SENDER_ID, named 'messageBySenderIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsMessageBySenderIdList</span>(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MessageBySenderIdList for 'not exists'. (NotNull)
     */
    public void notExistsMessageBySenderIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_MessageBySenderIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "SENDER_ID", pp, "messageBySenderIdList");
    }
    public abstract String keepMemberId_NotExistsReferrer_MessageBySenderIdList(MessageCQ sq);

    /**
     * Set up NotExistsReferrer (correlated sub-query). <br />
     * {not exists (select RECEIVER_ID from message where ...)} <br />
     * message by RECEIVER_ID, named 'messageByReceiverIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">notExistsMessageByReceiverIdList</span>(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param subQuery The sub-query of MemberId_NotExistsReferrer_MessageByReceiverIdList for 'not exists'. (NotNull)
     */
    public void notExistsMessageByReceiverIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForExistsReferrer(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotExistsReferrer_MessageByReceiverIdList(cb.query());
        registerNotExistsReferrer(cb.query(), "MEMBER_ID", "RECEIVER_ID", pp, "messageByReceiverIdList");
    }
    public abstract String keepMemberId_NotExistsReferrer_MessageByReceiverIdList(MessageCQ sq);

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
     * {in (select YOU_ID from follow where ...)} <br />
     * follow by YOU_ID, named 'followByYouIdAsOne'.
     * @param subQuery The sub-query of FollowByYouIdList for 'in-scope'. (NotNull)
     */
    public void inScopeFollowByYouIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_FollowByYouIdList(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "YOU_ID", pp, "followByYouIdList");
    }
    public abstract String keepMemberId_InScopeRelation_FollowByYouIdList(FollowCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followByMemberIdAsOne'.
     * @param subQuery The sub-query of FollowByMemberIdList for 'in-scope'. (NotNull)
     */
    public void inScopeFollowByMemberIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_FollowByMemberIdList(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followByMemberIdList");
    }
    public abstract String keepMemberId_InScopeRelation_FollowByMemberIdList(FollowCQ sq);

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
     * {in (select SENDER_ID from message where ...)} <br />
     * message by SENDER_ID, named 'messageBySenderIdAsOne'.
     * @param subQuery The sub-query of MessageBySenderIdList for 'in-scope'. (NotNull)
     */
    public void inScopeMessageBySenderIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_MessageBySenderIdList(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "SENDER_ID", pp, "messageBySenderIdList");
    }
    public abstract String keepMemberId_InScopeRelation_MessageBySenderIdList(MessageCQ sq);

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select RECEIVER_ID from message where ...)} <br />
     * message by RECEIVER_ID, named 'messageByReceiverIdAsOne'.
     * @param subQuery The sub-query of MessageByReceiverIdList for 'in-scope'. (NotNull)
     */
    public void inScopeMessageByReceiverIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_MessageByReceiverIdList(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "RECEIVER_ID", pp, "messageByReceiverIdList");
    }
    public abstract String keepMemberId_InScopeRelation_MessageByReceiverIdList(MessageCQ sq);

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
     * {not in (select YOU_ID from follow where ...)} <br />
     * follow by YOU_ID, named 'followByYouIdAsOne'.
     * @param subQuery The sub-query of FollowByYouIdList for 'not in-scope'. (NotNull)
     */
    public void notInScopeFollowByYouIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_FollowByYouIdList(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "YOU_ID", pp, "followByYouIdList");
    }
    public abstract String keepMemberId_NotInScopeRelation_FollowByYouIdList(FollowCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followByMemberIdAsOne'.
     * @param subQuery The sub-query of FollowByMemberIdList for 'not in-scope'. (NotNull)
     */
    public void notInScopeFollowByMemberIdList(SubQuery<FollowCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        FollowCB cb = new FollowCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_FollowByMemberIdList(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followByMemberIdList");
    }
    public abstract String keepMemberId_NotInScopeRelation_FollowByMemberIdList(FollowCQ sq);

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
     * {not in (select SENDER_ID from message where ...)} <br />
     * message by SENDER_ID, named 'messageBySenderIdAsOne'.
     * @param subQuery The sub-query of MessageBySenderIdList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMessageBySenderIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_MessageBySenderIdList(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "SENDER_ID", pp, "messageBySenderIdList");
    }
    public abstract String keepMemberId_NotInScopeRelation_MessageBySenderIdList(MessageCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select RECEIVER_ID from message where ...)} <br />
     * message by RECEIVER_ID, named 'messageByReceiverIdAsOne'.
     * @param subQuery The sub-query of MessageByReceiverIdList for 'not in-scope'. (NotNull)
     */
    public void notInScopeMessageByReceiverIdList(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_MessageByReceiverIdList(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "RECEIVER_ID", pp, "messageByReceiverIdList");
    }
    public abstract String keepMemberId_NotInScopeRelation_MessageByReceiverIdList(MessageCQ sq);

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

    public void xsderiveFollowByYouIdList(String fn, SubQuery<FollowCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FollowCB cb = new FollowCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberId_SpecifyDerivedReferrer_FollowByYouIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "YOU_ID", pp, "followByYouIdList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_FollowByYouIdList(FollowCQ sq);

    public void xsderiveFollowByMemberIdList(String fn, SubQuery<FollowCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FollowCB cb = new FollowCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberId_SpecifyDerivedReferrer_FollowByMemberIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "followByMemberIdList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_FollowByMemberIdList(FollowCQ sq);

    public void xsderiveLoginList(String fn, SubQuery<LoginCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        LoginCB cb = new LoginCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberId_SpecifyDerivedReferrer_LoginList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "loginList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_LoginList(LoginCQ sq);

    public void xsderiveMessageBySenderIdList(String fn, SubQuery<MessageCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageCB cb = new MessageCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberId_SpecifyDerivedReferrer_MessageBySenderIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "SENDER_ID", pp, "messageBySenderIdList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_MessageBySenderIdList(MessageCQ sq);

    public void xsderiveMessageByReceiverIdList(String fn, SubQuery<MessageCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageCB cb = new MessageCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepMemberId_SpecifyDerivedReferrer_MessageByReceiverIdList(cb.query());
        registerSpecifyDerivedReferrer(fn, cb.query(), "MEMBER_ID", "RECEIVER_ID", pp, "messageByReceiverIdList", al, op);
    }
    public abstract String keepMemberId_SpecifyDerivedReferrer_MessageByReceiverIdList(MessageCQ sq);

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
     * {FOO &lt;= (select max(BAR) from follow where ...)} <br />
     * follow by YOU_ID, named 'followByYouIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedFollowByYouIdList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<FollowCB> derivedFollowByYouIdList() {
        return xcreateQDRFunctionFollowByYouIdList();
    }
    protected HpQDRFunction<FollowCB> xcreateQDRFunctionFollowByYouIdList() {
        return new HpQDRFunction<FollowCB>(new HpQDRSetupper<FollowCB>() {
            public void setup(String fn, SubQuery<FollowCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveFollowByYouIdList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveFollowByYouIdList(String fn, SubQuery<FollowCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FollowCB cb = new FollowCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepMemberId_QueryDerivedReferrer_FollowByYouIdList(cb.query()); String prpp = keepMemberId_QueryDerivedReferrer_FollowByYouIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "YOU_ID", sqpp, "followByYouIdList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_FollowByYouIdList(FollowCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_FollowByYouIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br />
     * {FOO &lt;= (select max(BAR) from follow where ...)} <br />
     * follow by MEMBER_ID, named 'followByMemberIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedFollowByMemberIdList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;FollowCB&gt;() {
     *     public void query(FollowCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<FollowCB> derivedFollowByMemberIdList() {
        return xcreateQDRFunctionFollowByMemberIdList();
    }
    protected HpQDRFunction<FollowCB> xcreateQDRFunctionFollowByMemberIdList() {
        return new HpQDRFunction<FollowCB>(new HpQDRSetupper<FollowCB>() {
            public void setup(String fn, SubQuery<FollowCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveFollowByMemberIdList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveFollowByMemberIdList(String fn, SubQuery<FollowCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        FollowCB cb = new FollowCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepMemberId_QueryDerivedReferrer_FollowByMemberIdList(cb.query()); String prpp = keepMemberId_QueryDerivedReferrer_FollowByMemberIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "MEMBER_ID", sqpp, "followByMemberIdList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_FollowByMemberIdList(FollowCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_FollowByMemberIdListParameter(Object vl);

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
     * {FOO &lt;= (select max(BAR) from message where ...)} <br />
     * message by SENDER_ID, named 'messageBySenderIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedMessageBySenderIdList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MessageCB> derivedMessageBySenderIdList() {
        return xcreateQDRFunctionMessageBySenderIdList();
    }
    protected HpQDRFunction<MessageCB> xcreateQDRFunctionMessageBySenderIdList() {
        return new HpQDRFunction<MessageCB>(new HpQDRSetupper<MessageCB>() {
            public void setup(String fn, SubQuery<MessageCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveMessageBySenderIdList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveMessageBySenderIdList(String fn, SubQuery<MessageCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageCB cb = new MessageCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepMemberId_QueryDerivedReferrer_MessageBySenderIdList(cb.query()); String prpp = keepMemberId_QueryDerivedReferrer_MessageBySenderIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "SENDER_ID", sqpp, "messageBySenderIdList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_MessageBySenderIdList(MessageCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_MessageBySenderIdListParameter(Object vl);

    /**
     * Prepare for (Query)DerivedReferrer (correlated sub-query). <br />
     * {FOO &lt;= (select max(BAR) from message where ...)} <br />
     * message by RECEIVER_ID, named 'messageByReceiverIdAsOne'.
     * <pre>
     * cb.query().<span style="color: #DD4747">derivedMessageByReceiverIdList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
     *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
     *     }
     * }).<span style="color: #DD4747">greaterEqual</span>(123); <span style="color: #3F7E5E">// condition to derived column</span>
     * </pre>
     * @return The object to set up a function for referrer table. (NotNull)
     */
    public HpQDRFunction<MessageCB> derivedMessageByReceiverIdList() {
        return xcreateQDRFunctionMessageByReceiverIdList();
    }
    protected HpQDRFunction<MessageCB> xcreateQDRFunctionMessageByReceiverIdList() {
        return new HpQDRFunction<MessageCB>(new HpQDRSetupper<MessageCB>() {
            public void setup(String fn, SubQuery<MessageCB> sq, String rd, Object vl, DerivedReferrerOption op) {
                xqderiveMessageByReceiverIdList(fn, sq, rd, vl, op);
            }
        });
    }
    public void xqderiveMessageByReceiverIdList(String fn, SubQuery<MessageCB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageCB cb = new MessageCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String sqpp = keepMemberId_QueryDerivedReferrer_MessageByReceiverIdList(cb.query()); String prpp = keepMemberId_QueryDerivedReferrer_MessageByReceiverIdListParameter(vl);
        registerQueryDerivedReferrer(fn, cb.query(), "MEMBER_ID", "RECEIVER_ID", sqpp, "messageByReceiverIdList", rd, vl, prpp, op);
    }
    public abstract String keepMemberId_QueryDerivedReferrer_MessageByReceiverIdList(MessageCQ sq);
    public abstract String keepMemberId_QueryDerivedReferrer_MessageByReceiverIdListParameter(Object vl);

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
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCode The value of memberStatusCode as equal. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_Equal(Integer memberStatusCode) {
        doSetMemberStatusCode_Equal(memberStatusCode);
    }

    protected void doSetMemberStatusCode_Equal(Integer memberStatusCode) {
        regMemberStatusCode(CK_EQ, memberStatusCode);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCode The value of memberStatusCode as notEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_NotEqual(Integer memberStatusCode) {
        doSetMemberStatusCode_NotEqual(memberStatusCode);
    }

    protected void doSetMemberStatusCode_NotEqual(Integer memberStatusCode) {
        regMemberStatusCode(CK_NES, memberStatusCode);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCode The value of memberStatusCode as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_GreaterThan(Integer memberStatusCode) {
        regMemberStatusCode(CK_GT, memberStatusCode);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCode The value of memberStatusCode as lessThan. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_LessThan(Integer memberStatusCode) {
        regMemberStatusCode(CK_LT, memberStatusCode);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCode The value of memberStatusCode as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_GreaterEqual(Integer memberStatusCode) {
        regMemberStatusCode(CK_GE, memberStatusCode);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCode The value of memberStatusCode as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberStatusCode_LessEqual(Integer memberStatusCode) {
        regMemberStatusCode(CK_LE, memberStatusCode);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param minNumber The min number of memberStatusCode. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of memberStatusCode. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setMemberStatusCode_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueMemberStatusCode(), "MEMBER_STATUS_CODE", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCodeList The collection of memberStatusCode as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_InScope(Collection<Integer> memberStatusCodeList) {
        doSetMemberStatusCode_InScope(memberStatusCodeList);
    }

    protected void doSetMemberStatusCode_InScope(Collection<Integer> memberStatusCodeList) {
        regINS(CK_INS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @param memberStatusCodeList The collection of memberStatusCode as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberStatusCode_NotInScope(Collection<Integer> memberStatusCodeList) {
        doSetMemberStatusCode_NotInScope(memberStatusCodeList);
    }

    protected void doSetMemberStatusCode_NotInScope(Collection<Integer> memberStatusCodeList) {
        regINS(CK_NINS, cTL(memberStatusCodeList), getCValueMemberStatusCode(), "MEMBER_STATUS_CODE");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_STATUS_CODE from member_status where ...)} <br />
     * member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param subQuery The sub-query of MemberStatus for 'in-scope'. (NotNull)
     */
    public void inScopeMemberStatus(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberStatusCode_InScopeRelation_MemberStatus(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberStatus");
    }
    public abstract String keepMemberStatusCode_InScopeRelation_MemberStatus(MemberStatusCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_STATUS_CODE from member_status where ...)} <br />
     * member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param subQuery The sub-query of MemberStatus for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberStatus(SubQuery<MemberStatusCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberStatusCB cb = new MemberStatusCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberStatusCode_NotInScopeRelation_MemberStatus(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", pp, "memberStatus");
    }
    public abstract String keepMemberStatusCode_NotInScopeRelation_MemberStatus(MemberStatusCQ sq);

    protected void regMemberStatusCode(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberStatusCode(), "MEMBER_STATUS_CODE"); }
    protected abstract ConditionValue getCValueMemberStatusCode();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
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
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
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
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @param userName The value of userName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_GreaterThan(String userName) {
        regUserName(CK_GT, fRES(userName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @param userName The value of userName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_LessThan(String userName) {
        regUserName(CK_LT, fRES(userName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @param userName The value of userName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_GreaterEqual(String userName) {
        regUserName(CK_GE, fRES(userName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @param userName The value of userName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_LessEqual(String userName) {
        regUserName(CK_LE, fRES(userName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
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
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
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
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @param userName The value of userName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setUserName_PrefixSearch(String userName) {
        setUserName_LikeSearch(userName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * USER_NAME: {UQ, NotNull, VARCHAR(100)} <br />
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
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @param userName The value of userName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setUserName_NotLikeSearch(String userName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(userName), getCValueUserName(), "USER_NAME", likeSearchOption);
    }

    protected void regUserName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUserName(), "USER_NAME"); }
    protected abstract ConditionValue getCValueUserName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_Equal(String accountName) {
        doSetAccountName_Equal(fRES(accountName));
    }

    protected void doSetAccountName_Equal(String accountName) {
        regAccountName(CK_EQ, accountName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_NotEqual(String accountName) {
        doSetAccountName_NotEqual(fRES(accountName));
    }

    protected void doSetAccountName_NotEqual(String accountName) {
        regAccountName(CK_NES, accountName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_GreaterThan(String accountName) {
        regAccountName(CK_GT, fRES(accountName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_LessThan(String accountName) {
        regAccountName(CK_LT, fRES(accountName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_GreaterEqual(String accountName) {
        regAccountName(CK_GE, fRES(accountName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_LessEqual(String accountName) {
        regAccountName(CK_LE, fRES(accountName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountNameList The collection of accountName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_InScope(Collection<String> accountNameList) {
        doSetAccountName_InScope(accountNameList);
    }

    public void doSetAccountName_InScope(Collection<String> accountNameList) {
        regINS(CK_INS, cTL(accountNameList), getCValueAccountName(), "ACCOUNT_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountNameList The collection of accountName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_NotInScope(Collection<String> accountNameList) {
        doSetAccountName_NotInScope(accountNameList);
    }

    public void doSetAccountName_NotInScope(Collection<String> accountNameList) {
        regINS(CK_NINS, cTL(accountNameList), getCValueAccountName(), "ACCOUNT_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setAccountName_PrefixSearch(String accountName) {
        setAccountName_LikeSearch(accountName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)} <br />
     * <pre>e.g. setAccountName_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param accountName The value of accountName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setAccountName_LikeSearch(String accountName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(accountName), getCValueAccountName(), "ACCOUNT_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * ACCOUNT_NAME: {NotNull, VARCHAR(20)}
     * @param accountName The value of accountName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setAccountName_NotLikeSearch(String accountName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(accountName), getCValueAccountName(), "ACCOUNT_NAME", likeSearchOption);
    }

    protected void regAccountName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueAccountName(), "ACCOUNT_NAME"); }
    protected abstract ConditionValue getCValueAccountName();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_Equal(String groupName) {
        doSetGroupName_Equal(fRES(groupName));
    }

    protected void doSetGroupName_Equal(String groupName) {
        regGroupName(CK_EQ, groupName);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_NotEqual(String groupName) {
        doSetGroupName_NotEqual(fRES(groupName));
    }

    protected void doSetGroupName_NotEqual(String groupName) {
        regGroupName(CK_NES, groupName);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_GreaterThan(String groupName) {
        regGroupName(CK_GT, fRES(groupName));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_LessThan(String groupName) {
        regGroupName(CK_LT, fRES(groupName));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_GreaterEqual(String groupName) {
        regGroupName(CK_GE, fRES(groupName));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_LessEqual(String groupName) {
        regGroupName(CK_LE, fRES(groupName));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupNameList The collection of groupName as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_InScope(Collection<String> groupNameList) {
        doSetGroupName_InScope(groupNameList);
    }

    public void doSetGroupName_InScope(Collection<String> groupNameList) {
        regINS(CK_INS, cTL(groupNameList), getCValueGroupName(), "GROUP_NAME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupNameList The collection of groupName as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_NotInScope(Collection<String> groupNameList) {
        doSetGroupName_NotInScope(groupNameList);
    }

    public void doSetGroupName_NotInScope(Collection<String> groupNameList) {
        regINS(CK_NINS, cTL(groupNameList), getCValueGroupName(), "GROUP_NAME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setGroupName_PrefixSearch(String groupName) {
        setGroupName_LikeSearch(groupName, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)} <br />
     * <pre>e.g. setGroupName_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param groupName The value of groupName as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setGroupName_LikeSearch(String groupName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(groupName), getCValueGroupName(), "GROUP_NAME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @param groupName The value of groupName as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setGroupName_NotLikeSearch(String groupName, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(groupName), getCValueGroupName(), "GROUP_NAME", likeSearchOption);
    }

    protected void regGroupName(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueGroupName(), "GROUP_NAME"); }
    protected abstract ConditionValue getCValueGroupName();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_Equal(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_EQ,  insDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_GreaterThan(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_GT,  insDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_LessThan(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_LT,  insDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_GreaterEqual(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_GE,  insDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @param insDatetime The value of insDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setInsDatetime_LessEqual(java.sql.Timestamp insDatetime) {
        regInsDatetime(CK_LE, insDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setInsDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of insDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of insDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setInsDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueInsDatetime(), "INS_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of insDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of insDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setInsDatetime_DateFromTo(Date fromDate, Date toDate) {
        setInsDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    protected void regInsDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueInsDatetime(), "INS_DATETIME"); }
    protected abstract ConditionValue getCValueInsDatetime();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_Equal(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_EQ,  updDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_GreaterThan(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_GT,  updDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_LessThan(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_LT,  updDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_GreaterEqual(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_GE,  updDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @param updDatetime The value of updDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setUpdDatetime_LessEqual(java.sql.Timestamp updDatetime) {
        regUpdDatetime(CK_LE, updDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setUpdDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of updDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setUpdDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueUpdDatetime(), "UPD_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of updDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of updDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setUpdDatetime_DateFromTo(Date fromDate, Date toDate) {
        setUpdDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    protected void regUpdDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUpdDatetime(), "UPD_DATETIME"); }
    protected abstract ConditionValue getCValueUpdDatetime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_Equal(String insTrace) {
        doSetInsTrace_Equal(fRES(insTrace));
    }

    protected void doSetInsTrace_Equal(String insTrace) {
        regInsTrace(CK_EQ, insTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_NotEqual(String insTrace) {
        doSetInsTrace_NotEqual(fRES(insTrace));
    }

    protected void doSetInsTrace_NotEqual(String insTrace) {
        regInsTrace(CK_NES, insTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_GreaterThan(String insTrace) {
        regInsTrace(CK_GT, fRES(insTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_LessThan(String insTrace) {
        regInsTrace(CK_LT, fRES(insTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_GreaterEqual(String insTrace) {
        regInsTrace(CK_GE, fRES(insTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_LessEqual(String insTrace) {
        regInsTrace(CK_LE, fRES(insTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTraceList The collection of insTrace as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_InScope(Collection<String> insTraceList) {
        doSetInsTrace_InScope(insTraceList);
    }

    public void doSetInsTrace_InScope(Collection<String> insTraceList) {
        regINS(CK_INS, cTL(insTraceList), getCValueInsTrace(), "INS_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTraceList The collection of insTrace as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_NotInScope(Collection<String> insTraceList) {
        doSetInsTrace_NotInScope(insTraceList);
    }

    public void doSetInsTrace_NotInScope(Collection<String> insTraceList) {
        regINS(CK_NINS, cTL(insTraceList), getCValueInsTrace(), "INS_TRACE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setInsTrace_PrefixSearch(String insTrace) {
        setInsTrace_LikeSearch(insTrace, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)} <br />
     * <pre>e.g. setInsTrace_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param insTrace The value of insTrace as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setInsTrace_LikeSearch(String insTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(insTrace), getCValueInsTrace(), "INS_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @param insTrace The value of insTrace as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setInsTrace_NotLikeSearch(String insTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(insTrace), getCValueInsTrace(), "INS_TRACE", likeSearchOption);
    }

    protected void regInsTrace(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueInsTrace(), "INS_TRACE"); }
    protected abstract ConditionValue getCValueInsTrace();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_Equal(String updTrace) {
        doSetUpdTrace_Equal(fRES(updTrace));
    }

    protected void doSetUpdTrace_Equal(String updTrace) {
        regUpdTrace(CK_EQ, updTrace);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_NotEqual(String updTrace) {
        doSetUpdTrace_NotEqual(fRES(updTrace));
    }

    protected void doSetUpdTrace_NotEqual(String updTrace) {
        regUpdTrace(CK_NES, updTrace);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_GreaterThan(String updTrace) {
        regUpdTrace(CK_GT, fRES(updTrace));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_LessThan(String updTrace) {
        regUpdTrace(CK_LT, fRES(updTrace));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_GreaterEqual(String updTrace) {
        regUpdTrace(CK_GE, fRES(updTrace));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_LessEqual(String updTrace) {
        regUpdTrace(CK_LE, fRES(updTrace));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTraceList The collection of updTrace as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_InScope(Collection<String> updTraceList) {
        doSetUpdTrace_InScope(updTraceList);
    }

    public void doSetUpdTrace_InScope(Collection<String> updTraceList) {
        regINS(CK_INS, cTL(updTraceList), getCValueUpdTrace(), "UPD_TRACE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTraceList The collection of updTrace as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_NotInScope(Collection<String> updTraceList) {
        doSetUpdTrace_NotInScope(updTraceList);
    }

    public void doSetUpdTrace_NotInScope(Collection<String> updTraceList) {
        regINS(CK_NINS, cTL(updTraceList), getCValueUpdTrace(), "UPD_TRACE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setUpdTrace_PrefixSearch(String updTrace) {
        setUpdTrace_LikeSearch(updTrace, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)} <br />
     * <pre>e.g. setUpdTrace_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param updTrace The value of updTrace as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setUpdTrace_LikeSearch(String updTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(updTrace), getCValueUpdTrace(), "UPD_TRACE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @param updTrace The value of updTrace as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setUpdTrace_NotLikeSearch(String updTrace, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(updTrace), getCValueUpdTrace(), "UPD_TRACE", likeSearchOption);
    }

    protected void regUpdTrace(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueUpdTrace(), "UPD_TRACE"); }
    protected abstract ConditionValue getCValueUpdTrace();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_Equal(String recruitingNumber) {
        doSetRecruitingNumber_Equal(fRES(recruitingNumber));
    }

    protected void doSetRecruitingNumber_Equal(String recruitingNumber) {
        regRecruitingNumber(CK_EQ, recruitingNumber);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_NotEqual(String recruitingNumber) {
        doSetRecruitingNumber_NotEqual(fRES(recruitingNumber));
    }

    protected void doSetRecruitingNumber_NotEqual(String recruitingNumber) {
        regRecruitingNumber(CK_NES, recruitingNumber);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_GreaterThan(String recruitingNumber) {
        regRecruitingNumber(CK_GT, fRES(recruitingNumber));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_LessThan(String recruitingNumber) {
        regRecruitingNumber(CK_LT, fRES(recruitingNumber));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_GreaterEqual(String recruitingNumber) {
        regRecruitingNumber(CK_GE, fRES(recruitingNumber));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_LessEqual(String recruitingNumber) {
        regRecruitingNumber(CK_LE, fRES(recruitingNumber));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumberList The collection of recruitingNumber as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_InScope(Collection<String> recruitingNumberList) {
        doSetRecruitingNumber_InScope(recruitingNumberList);
    }

    public void doSetRecruitingNumber_InScope(Collection<String> recruitingNumberList) {
        regINS(CK_INS, cTL(recruitingNumberList), getCValueRecruitingNumber(), "RECRUITING_NUMBER");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumberList The collection of recruitingNumber as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_NotInScope(Collection<String> recruitingNumberList) {
        doSetRecruitingNumber_NotInScope(recruitingNumberList);
    }

    public void doSetRecruitingNumber_NotInScope(Collection<String> recruitingNumberList) {
        regINS(CK_NINS, cTL(recruitingNumberList), getCValueRecruitingNumber(), "RECRUITING_NUMBER");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setRecruitingNumber_PrefixSearch(String recruitingNumber) {
        setRecruitingNumber_LikeSearch(recruitingNumber, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)} <br />
     * <pre>e.g. setRecruitingNumber_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param recruitingNumber The value of recruitingNumber as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setRecruitingNumber_LikeSearch(String recruitingNumber, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(recruitingNumber), getCValueRecruitingNumber(), "RECRUITING_NUMBER", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     * @param recruitingNumber The value of recruitingNumber as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setRecruitingNumber_NotLikeSearch(String recruitingNumber, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(recruitingNumber), getCValueRecruitingNumber(), "RECRUITING_NUMBER", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     */
    public void setRecruitingNumber_IsNull() { regRecruitingNumber(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     */
    public void setRecruitingNumber_IsNullOrEmpty() { regRecruitingNumber(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * RECRUITING_NUMBER: {VARCHAR(20)}
     */
    public void setRecruitingNumber_IsNotNull() { regRecruitingNumber(CK_ISNN, DOBJ); }

    protected void regRecruitingNumber(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueRecruitingNumber(), "RECRUITING_NUMBER"); }
    protected abstract ConditionValue getCValueRecruitingNumber();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_Equal(String interestedIndustry) {
        doSetInterestedIndustry_Equal(fRES(interestedIndustry));
    }

    protected void doSetInterestedIndustry_Equal(String interestedIndustry) {
        regInterestedIndustry(CK_EQ, interestedIndustry);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_NotEqual(String interestedIndustry) {
        doSetInterestedIndustry_NotEqual(fRES(interestedIndustry));
    }

    protected void doSetInterestedIndustry_NotEqual(String interestedIndustry) {
        regInterestedIndustry(CK_NES, interestedIndustry);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_GreaterThan(String interestedIndustry) {
        regInterestedIndustry(CK_GT, fRES(interestedIndustry));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_LessThan(String interestedIndustry) {
        regInterestedIndustry(CK_LT, fRES(interestedIndustry));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_GreaterEqual(String interestedIndustry) {
        regInterestedIndustry(CK_GE, fRES(interestedIndustry));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_LessEqual(String interestedIndustry) {
        regInterestedIndustry(CK_LE, fRES(interestedIndustry));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustryList The collection of interestedIndustry as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_InScope(Collection<String> interestedIndustryList) {
        doSetInterestedIndustry_InScope(interestedIndustryList);
    }

    public void doSetInterestedIndustry_InScope(Collection<String> interestedIndustryList) {
        regINS(CK_INS, cTL(interestedIndustryList), getCValueInterestedIndustry(), "INTERESTED_INDUSTRY");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustryList The collection of interestedIndustry as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_NotInScope(Collection<String> interestedIndustryList) {
        doSetInterestedIndustry_NotInScope(interestedIndustryList);
    }

    public void doSetInterestedIndustry_NotInScope(Collection<String> interestedIndustryList) {
        regINS(CK_NINS, cTL(interestedIndustryList), getCValueInterestedIndustry(), "INTERESTED_INDUSTRY");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setInterestedIndustry_PrefixSearch(String interestedIndustry) {
        setInterestedIndustry_LikeSearch(interestedIndustry, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)} <br />
     * <pre>e.g. setInterestedIndustry_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param interestedIndustry The value of interestedIndustry as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setInterestedIndustry_LikeSearch(String interestedIndustry, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(interestedIndustry), getCValueInterestedIndustry(), "INTERESTED_INDUSTRY", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     * @param interestedIndustry The value of interestedIndustry as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setInterestedIndustry_NotLikeSearch(String interestedIndustry, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(interestedIndustry), getCValueInterestedIndustry(), "INTERESTED_INDUSTRY", likeSearchOption);
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     */
    public void setInterestedIndustry_IsNull() { regInterestedIndustry(CK_ISN, DOBJ); }

    /**
     * IsNullOrEmpty {is null or empty}. And OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     */
    public void setInterestedIndustry_IsNullOrEmpty() { regInterestedIndustry(CK_ISNOE, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * INTERESTED_INDUSTRY: {VARCHAR(50)}
     */
    public void setInterestedIndustry_IsNotNull() { regInterestedIndustry(CK_ISNN, DOBJ); }

    protected void regInterestedIndustry(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueInterestedIndustry(), "INTERESTED_INDUSTRY"); }
    protected abstract ConditionValue getCValueInterestedIndustry();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYear The value of graduationYear as equal. (NullAllowed: if null, no condition)
     */
    public void setGraduationYear_Equal(Integer graduationYear) {
        doSetGraduationYear_Equal(graduationYear);
    }

    protected void doSetGraduationYear_Equal(Integer graduationYear) {
        regGraduationYear(CK_EQ, graduationYear);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYear The value of graduationYear as notEqual. (NullAllowed: if null, no condition)
     */
    public void setGraduationYear_NotEqual(Integer graduationYear) {
        doSetGraduationYear_NotEqual(graduationYear);
    }

    protected void doSetGraduationYear_NotEqual(Integer graduationYear) {
        regGraduationYear(CK_NES, graduationYear);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYear The value of graduationYear as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setGraduationYear_GreaterThan(Integer graduationYear) {
        regGraduationYear(CK_GT, graduationYear);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYear The value of graduationYear as lessThan. (NullAllowed: if null, no condition)
     */
    public void setGraduationYear_LessThan(Integer graduationYear) {
        regGraduationYear(CK_LT, graduationYear);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYear The value of graduationYear as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setGraduationYear_GreaterEqual(Integer graduationYear) {
        regGraduationYear(CK_GE, graduationYear);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYear The value of graduationYear as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setGraduationYear_LessEqual(Integer graduationYear) {
        regGraduationYear(CK_LE, graduationYear);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param minNumber The min number of graduationYear. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of graduationYear. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setGraduationYear_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueGraduationYear(), "GRADUATION_YEAR", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYearList The collection of graduationYear as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setGraduationYear_InScope(Collection<Integer> graduationYearList) {
        doSetGraduationYear_InScope(graduationYearList);
    }

    protected void doSetGraduationYear_InScope(Collection<Integer> graduationYearList) {
        regINS(CK_INS, cTL(graduationYearList), getCValueGraduationYear(), "GRADUATION_YEAR");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     * @param graduationYearList The collection of graduationYear as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setGraduationYear_NotInScope(Collection<Integer> graduationYearList) {
        doSetGraduationYear_NotInScope(graduationYearList);
    }

    protected void doSetGraduationYear_NotInScope(Collection<Integer> graduationYearList) {
        regINS(CK_NINS, cTL(graduationYearList), getCValueGraduationYear(), "GRADUATION_YEAR");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     */
    public void setGraduationYear_IsNull() { regGraduationYear(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * GRADUATION_YEAR: {INT(10)}
     */
    public void setGraduationYear_IsNotNull() { regGraduationYear(CK_ISNN, DOBJ); }

    protected void regGraduationYear(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueGraduationYear(), "GRADUATION_YEAR"); }
    protected abstract ConditionValue getCValueGraduationYear();

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
