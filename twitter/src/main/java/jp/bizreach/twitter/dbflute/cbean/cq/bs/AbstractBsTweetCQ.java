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
 * The abstract condition-query of tweet.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsTweetCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsTweetCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "tweet";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetId The value of tweetId as equal. (NullAllowed: if null, no condition)
     */
    public void setTweetId_Equal(Integer tweetId) {
        doSetTweetId_Equal(tweetId);
    }

    protected void doSetTweetId_Equal(Integer tweetId) {
        regTweetId(CK_EQ, tweetId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetId The value of tweetId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setTweetId_NotEqual(Integer tweetId) {
        doSetTweetId_NotEqual(tweetId);
    }

    protected void doSetTweetId_NotEqual(Integer tweetId) {
        regTweetId(CK_NES, tweetId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetId The value of tweetId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTweetId_GreaterThan(Integer tweetId) {
        regTweetId(CK_GT, tweetId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetId The value of tweetId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTweetId_LessThan(Integer tweetId) {
        regTweetId(CK_LT, tweetId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetId The value of tweetId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTweetId_GreaterEqual(Integer tweetId) {
        regTweetId(CK_GE, tweetId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetId The value of tweetId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTweetId_LessEqual(Integer tweetId) {
        regTweetId(CK_LE, tweetId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param minNumber The min number of tweetId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of tweetId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setTweetId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueTweetId(), "TWEET_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetIdList The collection of tweetId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweetId_InScope(Collection<Integer> tweetIdList) {
        doSetTweetId_InScope(tweetIdList);
    }

    protected void doSetTweetId_InScope(Collection<Integer> tweetIdList) {
        regINS(CK_INS, cTL(tweetIdList), getCValueTweetId(), "TWEET_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @param tweetIdList The collection of tweetId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweetId_NotInScope(Collection<Integer> tweetIdList) {
        doSetTweetId_NotInScope(tweetIdList);
    }

    protected void doSetTweetId_NotInScope(Collection<Integer> tweetIdList) {
        regINS(CK_NINS, cTL(tweetIdList), getCValueTweetId(), "TWEET_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setTweetId_IsNull() { regTweetId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setTweetId_IsNotNull() { regTweetId(CK_ISNN, DOBJ); }

    protected void regTweetId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTweetId(), "TWEET_ID"); }
    protected abstract ConditionValue getCValueTweetId();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
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
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
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
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @param memberId The value of memberId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setMemberId_GreaterThan(Integer memberId) {
        regMemberId(CK_GT, memberId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @param memberId The value of memberId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setMemberId_LessThan(Integer memberId) {
        regMemberId(CK_LT, memberId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @param memberId The value of memberId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_GreaterEqual(Integer memberId) {
        regMemberId(CK_GE, memberId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @param memberId The value of memberId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setMemberId_LessEqual(Integer memberId) {
        regMemberId(CK_LE, memberId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @param minNumber The min number of memberId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of memberId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setMemberId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueMemberId(), "MEMBER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
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
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @param memberIdList The collection of memberId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMemberId_NotInScope(Collection<Integer> memberIdList) {
        doSetMemberId_NotInScope(memberIdList);
    }

    protected void doSetMemberId_NotInScope(Collection<Integer> memberIdList) {
        regINS(CK_NINS, cTL(memberIdList), getCValueMemberId(), "MEMBER_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select MEMBER_ID from member where ...)} <br />
     * member by my MEMBER_ID, named 'member'.
     * @param subQuery The sub-query of Member for 'in-scope'. (NotNull)
     */
    public void inScopeMember(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_InScopeRelation_Member(cb.query());
        registerInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "member");
    }
    public abstract String keepMemberId_InScopeRelation_Member(MemberCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select MEMBER_ID from member where ...)} <br />
     * member by my MEMBER_ID, named 'member'.
     * @param subQuery The sub-query of Member for 'not in-scope'. (NotNull)
     */
    public void notInScopeMember(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMemberId_NotInScopeRelation_Member(cb.query());
        registerNotInScopeRelation(cb.query(), "MEMBER_ID", "MEMBER_ID", pp, "member");
    }
    public abstract String keepMemberId_NotInScopeRelation_Member(MemberCQ sq);

    protected void regMemberId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMemberId(), "MEMBER_ID"); }
    protected abstract ConditionValue getCValueMemberId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_Equal(String tweet) {
        doSetTweet_Equal(fRES(tweet));
    }

    protected void doSetTweet_Equal(String tweet) {
        regTweet(CK_EQ, tweet);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_NotEqual(String tweet) {
        doSetTweet_NotEqual(fRES(tweet));
    }

    protected void doSetTweet_NotEqual(String tweet) {
        regTweet(CK_NES, tweet);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_GreaterThan(String tweet) {
        regTweet(CK_GT, fRES(tweet));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_LessThan(String tweet) {
        regTweet(CK_LT, fRES(tweet));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_GreaterEqual(String tweet) {
        regTweet(CK_GE, fRES(tweet));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_LessEqual(String tweet) {
        regTweet(CK_LE, fRES(tweet));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweetList The collection of tweet as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_InScope(Collection<String> tweetList) {
        doSetTweet_InScope(tweetList);
    }

    public void doSetTweet_InScope(Collection<String> tweetList) {
        regINS(CK_INS, cTL(tweetList), getCValueTweet(), "TWEET");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweetList The collection of tweet as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_NotInScope(Collection<String> tweetList) {
        doSetTweet_NotInScope(tweetList);
    }

    public void doSetTweet_NotInScope(Collection<String> tweetList) {
        regINS(CK_NINS, cTL(tweetList), getCValueTweet(), "TWEET");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setTweet_PrefixSearch(String tweet) {
        setTweet_LikeSearch(tweet, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)} <br />
     * <pre>e.g. setTweet_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param tweet The value of tweet as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setTweet_LikeSearch(String tweet, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(tweet), getCValueTweet(), "TWEET", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * TWEET: {NotNull, VARCHAR(140)}
     * @param tweet The value of tweet as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setTweet_NotLikeSearch(String tweet, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(tweet), getCValueTweet(), "TWEET", likeSearchOption);
    }

    protected void regTweet(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTweet(), "TWEET"); }
    protected abstract ConditionValue getCValueTweet();

    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_DATETIME: {NotNull, DATETIME(19)}
     * @param tweetDatetime The value of tweetDatetime as equal. (NullAllowed: if null, no condition)
     */
    public void setTweetDatetime_Equal(java.sql.Timestamp tweetDatetime) {
        regTweetDatetime(CK_EQ,  tweetDatetime);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_DATETIME: {NotNull, DATETIME(19)}
     * @param tweetDatetime The value of tweetDatetime as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setTweetDatetime_GreaterThan(java.sql.Timestamp tweetDatetime) {
        regTweetDatetime(CK_GT,  tweetDatetime);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_DATETIME: {NotNull, DATETIME(19)}
     * @param tweetDatetime The value of tweetDatetime as lessThan. (NullAllowed: if null, no condition)
     */
    public void setTweetDatetime_LessThan(java.sql.Timestamp tweetDatetime) {
        regTweetDatetime(CK_LT,  tweetDatetime);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_DATETIME: {NotNull, DATETIME(19)}
     * @param tweetDatetime The value of tweetDatetime as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setTweetDatetime_GreaterEqual(java.sql.Timestamp tweetDatetime) {
        regTweetDatetime(CK_GE,  tweetDatetime);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_DATETIME: {NotNull, DATETIME(19)}
     * @param tweetDatetime The value of tweetDatetime as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setTweetDatetime_LessEqual(java.sql.Timestamp tweetDatetime) {
        regTweetDatetime(CK_LE, tweetDatetime);
    }

    /**
     * FromTo with various options. (versatile) {(default) fromDatetime &lt;= column &lt;= toDatetime} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_DATETIME: {NotNull, DATETIME(19)}
     * <pre>e.g. setTweetDatetime_FromTo(fromDate, toDate, new <span style="color: #DD4747">FromToOption</span>().compareAsDate());</pre>
     * @param fromDatetime The from-datetime(yyyy/MM/dd HH:mm:ss.SSS) of tweetDatetime. (NullAllowed: if null, no from-condition)
     * @param toDatetime The to-datetime(yyyy/MM/dd HH:mm:ss.SSS) of tweetDatetime. (NullAllowed: if null, no to-condition)
     * @param fromToOption The option of from-to. (NotNull)
     */
    public void setTweetDatetime_FromTo(Date fromDatetime, Date toDatetime, FromToOption fromToOption) {
        regFTQ((fromDatetime != null ? new java.sql.Timestamp(fromDatetime.getTime()) : null), (toDatetime != null ? new java.sql.Timestamp(toDatetime.getTime()) : null), getCValueTweetDatetime(), "TWEET_DATETIME", fromToOption);
    }

    /**
     * DateFromTo. (Date means yyyy/MM/dd) {fromDate &lt;= column &lt; toDate + 1 day} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * TWEET_DATETIME: {NotNull, DATETIME(19)}
     * <pre>
     * e.g. from:{2007/04/10 08:24:53} to:{2007/04/16 14:36:29}
     *  column &gt;= '2007/04/10 00:00:00' and column <span style="color: #DD4747">&lt; '2007/04/17 00:00:00'</span>
     * </pre>
     * @param fromDate The from-date(yyyy/MM/dd) of tweetDatetime. (NullAllowed: if null, no from-condition)
     * @param toDate The to-date(yyyy/MM/dd) of tweetDatetime. (NullAllowed: if null, no to-condition)
     */
    public void setTweetDatetime_DateFromTo(Date fromDate, Date toDate) {
        setTweetDatetime_FromTo(fromDate, toDate, new FromToOption().compareAsDate());
    }

    protected void regTweetDatetime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueTweetDatetime(), "TWEET_DATETIME"); }
    protected abstract ConditionValue getCValueTweetDatetime();

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<TweetCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, TweetCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<TweetCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, TweetCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<TweetCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, TweetCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<TweetCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, TweetCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<TweetCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, TweetCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;TweetCB&gt;() {
     *     public void query(TweetCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<TweetCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, TweetCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        TweetCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(TweetCQ sq);

    protected TweetCB xcreateScalarConditionCB() {
        TweetCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected TweetCB xcreateScalarConditionPartitionByCB() {
        TweetCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<TweetCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        TweetCB cb = new TweetCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "TWEET_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(TweetCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<TweetCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(TweetCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        TweetCB cb = new TweetCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "TWEET_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(TweetCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<TweetCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        TweetCB cb = new TweetCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(TweetCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<TweetCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        TweetCB cb = new TweetCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(TweetCQ sq);

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
    protected TweetCB newMyCB() {
        return new TweetCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return TweetCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
