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
 * The abstract condition-query of message.
 * @author DBFlute(AutoGenerator)
 */
public abstract class AbstractBsMessageCQ extends AbstractConditionQuery {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AbstractBsMessageCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
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
        return "message";
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageId The value of messageId as equal. (NullAllowed: if null, no condition)
     */
    public void setMessageId_Equal(Integer messageId) {
        doSetMessageId_Equal(messageId);
    }

    protected void doSetMessageId_Equal(Integer messageId) {
        regMessageId(CK_EQ, messageId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageId The value of messageId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setMessageId_NotEqual(Integer messageId) {
        doSetMessageId_NotEqual(messageId);
    }

    protected void doSetMessageId_NotEqual(Integer messageId) {
        regMessageId(CK_NES, messageId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageId The value of messageId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setMessageId_GreaterThan(Integer messageId) {
        regMessageId(CK_GT, messageId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageId The value of messageId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setMessageId_LessThan(Integer messageId) {
        regMessageId(CK_LT, messageId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageId The value of messageId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setMessageId_GreaterEqual(Integer messageId) {
        regMessageId(CK_GE, messageId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageId The value of messageId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setMessageId_LessEqual(Integer messageId) {
        regMessageId(CK_LE, messageId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param minNumber The min number of messageId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of messageId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setMessageId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueMessageId(), "MESSAGE_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageIdList The collection of messageId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageId_InScope(Collection<Integer> messageIdList) {
        doSetMessageId_InScope(messageIdList);
    }

    protected void doSetMessageId_InScope(Collection<Integer> messageIdList) {
        regINS(CK_INS, cTL(messageIdList), getCValueMessageId(), "MESSAGE_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @param messageIdList The collection of messageId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageId_NotInScope(Collection<Integer> messageIdList) {
        doSetMessageId_NotInScope(messageIdList);
    }

    protected void doSetMessageId_NotInScope(Collection<Integer> messageIdList) {
        regINS(CK_NINS, cTL(messageIdList), getCValueMessageId(), "MESSAGE_ID");
    }

    /**
     * IsNull {is null}. And OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setMessageId_IsNull() { regMessageId(CK_ISN, DOBJ); }

    /**
     * IsNotNull {is not null}. And OnlyOnceRegistered. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     */
    public void setMessageId_IsNotNull() { regMessageId(CK_ISNN, DOBJ); }

    protected void regMessageId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMessageId(), "MESSAGE_ID"); }
    protected abstract ConditionValue getCValueMessageId();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderId The value of senderId as equal. (NullAllowed: if null, no condition)
     */
    public void setSenderId_Equal(Integer senderId) {
        doSetSenderId_Equal(senderId);
    }

    protected void doSetSenderId_Equal(Integer senderId) {
        regSenderId(CK_EQ, senderId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderId The value of senderId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setSenderId_NotEqual(Integer senderId) {
        doSetSenderId_NotEqual(senderId);
    }

    protected void doSetSenderId_NotEqual(Integer senderId) {
        regSenderId(CK_NES, senderId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderId The value of senderId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setSenderId_GreaterThan(Integer senderId) {
        regSenderId(CK_GT, senderId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderId The value of senderId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setSenderId_LessThan(Integer senderId) {
        regSenderId(CK_LT, senderId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderId The value of senderId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setSenderId_GreaterEqual(Integer senderId) {
        regSenderId(CK_GE, senderId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderId The value of senderId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setSenderId_LessEqual(Integer senderId) {
        regSenderId(CK_LE, senderId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param minNumber The min number of senderId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of senderId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setSenderId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueSenderId(), "SENDER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderIdList The collection of senderId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setSenderId_InScope(Collection<Integer> senderIdList) {
        doSetSenderId_InScope(senderIdList);
    }

    protected void doSetSenderId_InScope(Collection<Integer> senderIdList) {
        regINS(CK_INS, cTL(senderIdList), getCValueSenderId(), "SENDER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @param senderIdList The collection of senderId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setSenderId_NotInScope(Collection<Integer> senderIdList) {
        doSetSenderId_NotInScope(senderIdList);
    }

    protected void doSetSenderId_NotInScope(Collection<Integer> senderIdList) {
        regINS(CK_NINS, cTL(senderIdList), getCValueSenderId(), "SENDER_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select SENDER_ID from member where ...)} <br />
     * member by my SENDER_ID, named 'memberBySenderId'.
     * @param subQuery The sub-query of MemberBySenderId for 'in-scope'. (NotNull)
     */
    public void inScopeMemberBySenderId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepSenderId_InScopeRelation_MemberBySenderId(cb.query());
        registerInScopeRelation(cb.query(), "SENDER_ID", "MEMBER_ID", pp, "memberBySenderId");
    }
    public abstract String keepSenderId_InScopeRelation_MemberBySenderId(MemberCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select SENDER_ID from member where ...)} <br />
     * member by my SENDER_ID, named 'memberBySenderId'.
     * @param subQuery The sub-query of MemberBySenderId for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberBySenderId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepSenderId_NotInScopeRelation_MemberBySenderId(cb.query());
        registerNotInScopeRelation(cb.query(), "SENDER_ID", "MEMBER_ID", pp, "memberBySenderId");
    }
    public abstract String keepSenderId_NotInScopeRelation_MemberBySenderId(MemberCQ sq);

    protected void regSenderId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueSenderId(), "SENDER_ID"); }
    protected abstract ConditionValue getCValueSenderId();
    
    /**
     * Equal(=). And NullIgnored, OnlyOnceRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverId The value of receiverId as equal. (NullAllowed: if null, no condition)
     */
    public void setReceiverId_Equal(Integer receiverId) {
        doSetReceiverId_Equal(receiverId);
    }

    protected void doSetReceiverId_Equal(Integer receiverId) {
        regReceiverId(CK_EQ, receiverId);
    }

    /**
     * NotEqual(&lt;&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverId The value of receiverId as notEqual. (NullAllowed: if null, no condition)
     */
    public void setReceiverId_NotEqual(Integer receiverId) {
        doSetReceiverId_NotEqual(receiverId);
    }

    protected void doSetReceiverId_NotEqual(Integer receiverId) {
        regReceiverId(CK_NES, receiverId);
    }

    /**
     * GreaterThan(&gt;). And NullIgnored, OnlyOnceRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverId The value of receiverId as greaterThan. (NullAllowed: if null, no condition)
     */
    public void setReceiverId_GreaterThan(Integer receiverId) {
        regReceiverId(CK_GT, receiverId);
    }

    /**
     * LessThan(&lt;). And NullIgnored, OnlyOnceRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverId The value of receiverId as lessThan. (NullAllowed: if null, no condition)
     */
    public void setReceiverId_LessThan(Integer receiverId) {
        regReceiverId(CK_LT, receiverId);
    }

    /**
     * GreaterEqual(&gt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverId The value of receiverId as greaterEqual. (NullAllowed: if null, no condition)
     */
    public void setReceiverId_GreaterEqual(Integer receiverId) {
        regReceiverId(CK_GE, receiverId);
    }

    /**
     * LessEqual(&lt;=). And NullIgnored, OnlyOnceRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverId The value of receiverId as lessEqual. (NullAllowed: if null, no condition)
     */
    public void setReceiverId_LessEqual(Integer receiverId) {
        regReceiverId(CK_LE, receiverId);
    }

    /**
     * RangeOf with various options. (versatile) <br />
     * {(default) minNumber &lt;= column &lt;= maxNumber} <br />
     * And NullIgnored, OnlyOnceRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param minNumber The min number of receiverId. (NullAllowed: if null, no from-condition)
     * @param maxNumber The max number of receiverId. (NullAllowed: if null, no to-condition)
     * @param rangeOfOption The option of range-of. (NotNull)
     */
    public void setReceiverId_RangeOf(Integer minNumber, Integer maxNumber, RangeOfOption rangeOfOption) {
        regROO(minNumber, maxNumber, getCValueReceiverId(), "RECEIVER_ID", rangeOfOption);
    }

    /**
     * InScope {in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverIdList The collection of receiverId as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setReceiverId_InScope(Collection<Integer> receiverIdList) {
        doSetReceiverId_InScope(receiverIdList);
    }

    protected void doSetReceiverId_InScope(Collection<Integer> receiverIdList) {
        regINS(CK_INS, cTL(receiverIdList), getCValueReceiverId(), "RECEIVER_ID");
    }

    /**
     * NotInScope {not in (1, 2)}. And NullIgnored, NullElementIgnored, SeveralRegistered. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @param receiverIdList The collection of receiverId as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setReceiverId_NotInScope(Collection<Integer> receiverIdList) {
        doSetReceiverId_NotInScope(receiverIdList);
    }

    protected void doSetReceiverId_NotInScope(Collection<Integer> receiverIdList) {
        regINS(CK_NINS, cTL(receiverIdList), getCValueReceiverId(), "RECEIVER_ID");
    }

    /**
     * Set up InScopeRelation (sub-query). <br />
     * {in (select RECEIVER_ID from member where ...)} <br />
     * member by my RECEIVER_ID, named 'memberByReceiverId'.
     * @param subQuery The sub-query of MemberByReceiverId for 'in-scope'. (NotNull)
     */
    public void inScopeMemberByReceiverId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepReceiverId_InScopeRelation_MemberByReceiverId(cb.query());
        registerInScopeRelation(cb.query(), "RECEIVER_ID", "MEMBER_ID", pp, "memberByReceiverId");
    }
    public abstract String keepReceiverId_InScopeRelation_MemberByReceiverId(MemberCQ sq);

    /**
     * Set up NotInScopeRelation (sub-query). <br />
     * {not in (select RECEIVER_ID from member where ...)} <br />
     * member by my RECEIVER_ID, named 'memberByReceiverId'.
     * @param subQuery The sub-query of MemberByReceiverId for 'not in-scope'. (NotNull)
     */
    public void notInScopeMemberByReceiverId(SubQuery<MemberCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MemberCB cb = new MemberCB(); cb.xsetupForInScopeRelation(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepReceiverId_NotInScopeRelation_MemberByReceiverId(cb.query());
        registerNotInScopeRelation(cb.query(), "RECEIVER_ID", "MEMBER_ID", pp, "memberByReceiverId");
    }
    public abstract String keepReceiverId_NotInScopeRelation_MemberByReceiverId(MemberCQ sq);

    protected void regReceiverId(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueReceiverId(), "RECEIVER_ID"); }
    protected abstract ConditionValue getCValueReceiverId();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_Equal(String messageTime) {
        doSetMessageTime_Equal(fRES(messageTime));
    }

    protected void doSetMessageTime_Equal(String messageTime) {
        regMessageTime(CK_EQ, messageTime);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_NotEqual(String messageTime) {
        doSetMessageTime_NotEqual(fRES(messageTime));
    }

    protected void doSetMessageTime_NotEqual(String messageTime) {
        regMessageTime(CK_NES, messageTime);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_GreaterThan(String messageTime) {
        regMessageTime(CK_GT, fRES(messageTime));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_LessThan(String messageTime) {
        regMessageTime(CK_LT, fRES(messageTime));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_GreaterEqual(String messageTime) {
        regMessageTime(CK_GE, fRES(messageTime));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_LessEqual(String messageTime) {
        regMessageTime(CK_LE, fRES(messageTime));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTimeList The collection of messageTime as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_InScope(Collection<String> messageTimeList) {
        doSetMessageTime_InScope(messageTimeList);
    }

    public void doSetMessageTime_InScope(Collection<String> messageTimeList) {
        regINS(CK_INS, cTL(messageTimeList), getCValueMessageTime(), "MESSAGE_TIME");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTimeList The collection of messageTime as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_NotInScope(Collection<String> messageTimeList) {
        doSetMessageTime_NotInScope(messageTimeList);
    }

    public void doSetMessageTime_NotInScope(Collection<String> messageTimeList) {
        regINS(CK_NINS, cTL(messageTimeList), getCValueMessageTime(), "MESSAGE_TIME");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessageTime_PrefixSearch(String messageTime) {
        setMessageTime_LikeSearch(messageTime, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)} <br />
     * <pre>e.g. setMessageTime_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param messageTime The value of messageTime as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMessageTime_LikeSearch(String messageTime, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(messageTime), getCValueMessageTime(), "MESSAGE_TIME", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @param messageTime The value of messageTime as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMessageTime_NotLikeSearch(String messageTime, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(messageTime), getCValueMessageTime(), "MESSAGE_TIME", likeSearchOption);
    }

    protected void regMessageTime(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMessageTime(), "MESSAGE_TIME"); }
    protected abstract ConditionValue getCValueMessageTime();

    /**
     * Equal(=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as equal. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_Equal(String message) {
        doSetMessage_Equal(fRES(message));
    }

    protected void doSetMessage_Equal(String message) {
        regMessage(CK_EQ, message);
    }

    /**
     * NotEqual(&lt;&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as notEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_NotEqual(String message) {
        doSetMessage_NotEqual(fRES(message));
    }

    protected void doSetMessage_NotEqual(String message) {
        regMessage(CK_NES, message);
    }

    /**
     * GreaterThan(&gt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as greaterThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_GreaterThan(String message) {
        regMessage(CK_GT, fRES(message));
    }

    /**
     * LessThan(&lt;). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as lessThan. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_LessThan(String message) {
        regMessage(CK_LT, fRES(message));
    }

    /**
     * GreaterEqual(&gt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as greaterEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_GreaterEqual(String message) {
        regMessage(CK_GE, fRES(message));
    }

    /**
     * LessEqual(&lt;=). And NullOrEmptyIgnored, OnlyOnceRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as lessEqual. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_LessEqual(String message) {
        regMessage(CK_LE, fRES(message));
    }

    /**
     * InScope {in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param messageList The collection of message as inScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_InScope(Collection<String> messageList) {
        doSetMessage_InScope(messageList);
    }

    public void doSetMessage_InScope(Collection<String> messageList) {
        regINS(CK_INS, cTL(messageList), getCValueMessage(), "MESSAGE");
    }

    /**
     * NotInScope {not in ('a', 'b')}. And NullOrEmptyIgnored, NullOrEmptyElementIgnored, SeveralRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param messageList The collection of message as notInScope. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_NotInScope(Collection<String> messageList) {
        doSetMessage_NotInScope(messageList);
    }

    public void doSetMessage_NotInScope(Collection<String> messageList) {
        regINS(CK_NINS, cTL(messageList), getCValueMessage(), "MESSAGE");
    }

    /**
     * PrefixSearch {like 'xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as prefixSearch. (NullAllowed: if null (or empty), no condition)
     */
    public void setMessage_PrefixSearch(String message) {
        setMessage_LikeSearch(message, cLSOP());
    }

    /**
     * LikeSearch with various options. (versatile) {like '%xxx%' escape ...}. And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)} <br />
     * <pre>e.g. setMessage_LikeSearch("xxx", new <span style="color: #DD4747">LikeSearchOption</span>().likeContain());</pre>
     * @param message The value of message as likeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of like-search. (NotNull)
     */
    public void setMessage_LikeSearch(String message, LikeSearchOption likeSearchOption) {
        regLSQ(CK_LS, fRES(message), getCValueMessage(), "MESSAGE", likeSearchOption);
    }

    /**
     * NotLikeSearch with various options. (versatile) {not like 'xxx%' escape ...} <br />
     * And NullOrEmptyIgnored, SeveralRegistered. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @param message The value of message as notLikeSearch. (NullAllowed: if null (or empty), no condition)
     * @param likeSearchOption The option of not-like-search. (NotNull)
     */
    public void setMessage_NotLikeSearch(String message, LikeSearchOption likeSearchOption) {
        regLSQ(CK_NLS, fRES(message), getCValueMessage(), "MESSAGE", likeSearchOption);
    }

    protected void regMessage(ConditionKey ky, Object vl) { regQ(ky, vl, getCValueMessage(), "MESSAGE"); }
    protected abstract ConditionValue getCValueMessage();

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

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO = (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_Equal()</span>.max(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MessageCB> scalar_Equal() {
        return xcreateSSQFunction(CK_EQ, MessageCB.class);
    }

    /**
     * Prepare ScalarCondition as equal. <br />
     * {where FOO &lt;&gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_NotEqual()</span>.max(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().setXxx... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setYyy...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MessageCB> scalar_NotEqual() {
        return xcreateSSQFunction(CK_NES, MessageCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterThan. <br />
     * {where FOO &gt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterThan()</span>.max(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MessageCB> scalar_GreaterThan() {
        return xcreateSSQFunction(CK_GT, MessageCB.class);
    }

    /**
     * Prepare ScalarCondition as lessThan. <br />
     * {where FOO &lt; (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessThan()</span>.max(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MessageCB> scalar_LessThan() {
        return xcreateSSQFunction(CK_LT, MessageCB.class);
    }

    /**
     * Prepare ScalarCondition as greaterEqual. <br />
     * {where FOO &gt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_GreaterEqual()</span>.max(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MessageCB> scalar_GreaterEqual() {
        return xcreateSSQFunction(CK_GE, MessageCB.class);
    }

    /**
     * Prepare ScalarCondition as lessEqual. <br />
     * {where FOO &lt;= (select max(BAR) from ...)
     * <pre>
     * cb.query().<span style="color: #DD4747">scalar_LessEqual()</span>.max(new SubQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB subCB) {
     *         subCB.specify().setFoo... <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setBar...
     *     }
     * });
     * </pre>
     * @return The object to set up a function. (NotNull)
     */
    public HpSSQFunction<MessageCB> scalar_LessEqual() {
        return xcreateSSQFunction(CK_LE, MessageCB.class);
    }

    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xscalarCondition(String fn, SubQuery<CB> sq, String rd, HpSSQOption<CB> op) {
        assertObjectNotNull("subQuery", sq);
        MessageCB cb = xcreateScalarConditionCB(); sq.query((CB)cb);
        String pp = keepScalarCondition(cb.query()); // for saving query-value
        op.setPartitionByCBean((CB)xcreateScalarConditionPartitionByCB()); // for using partition-by
        registerScalarCondition(fn, cb.query(), pp, rd, op);
    }
    public abstract String keepScalarCondition(MessageCQ sq);

    protected MessageCB xcreateScalarConditionCB() {
        MessageCB cb = newMyCB(); cb.xsetupForScalarCondition(this); return cb;
    }

    protected MessageCB xcreateScalarConditionPartitionByCB() {
        MessageCB cb = newMyCB(); cb.xsetupForScalarConditionPartitionBy(this); return cb;
    }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public void xsmyselfDerive(String fn, SubQuery<MessageCB> sq, String al, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageCB cb = new MessageCB(); cb.xsetupForDerivedReferrer(this);
        try { lock(); sq.query(cb); } finally { unlock(); }
        String pp = keepSpecifyMyselfDerived(cb.query());
        String pk = "MESSAGE_ID";
        registerSpecifyMyselfDerived(fn, cb.query(), pk, pk, pp, "myselfDerived", al, op);
    }
    public abstract String keepSpecifyMyselfDerived(MessageCQ sq);

    /**
     * Prepare for (Query)MyselfDerived (correlated sub-query).
     * @return The object to set up a function for myself table. (NotNull)
     */
    public HpQDRFunction<MessageCB> myselfDerived() {
        return xcreateQDRFunctionMyselfDerived(MessageCB.class);
    }
    @SuppressWarnings("unchecked")
    protected <CB extends ConditionBean> void xqderiveMyselfDerived(String fn, SubQuery<CB> sq, String rd, Object vl, DerivedReferrerOption op) {
        assertObjectNotNull("subQuery", sq);
        MessageCB cb = new MessageCB(); cb.xsetupForDerivedReferrer(this); sq.query((CB)cb);
        String pk = "MESSAGE_ID";
        String sqpp = keepQueryMyselfDerived(cb.query()); // for saving query-value.
        String prpp = keepQueryMyselfDerivedParameter(vl);
        registerQueryMyselfDerived(fn, cb.query(), pk, pk, sqpp, "myselfDerived", rd, vl, prpp, op);
    }
    public abstract String keepQueryMyselfDerived(MessageCQ sq);
    public abstract String keepQueryMyselfDerivedParameter(Object vl);

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    /**
     * Prepare for MyselfExists (correlated sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfExists(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForMyselfExists(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfExists(cb.query());
        registerMyselfExists(cb.query(), pp);
    }
    public abstract String keepMyselfExists(MessageCQ sq);

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    /**
     * Prepare for MyselfInScope (sub-query).
     * @param subQuery The implementation of sub-query. (NotNull)
     */
    public void myselfInScope(SubQuery<MessageCB> subQuery) {
        assertObjectNotNull("subQuery", subQuery);
        MessageCB cb = new MessageCB(); cb.xsetupForMyselfInScope(this);
        try { lock(); subQuery.query(cb); } finally { unlock(); }
        String pp = keepMyselfInScope(cb.query());
        registerMyselfInScope(cb.query(), pp);
    }
    public abstract String keepMyselfInScope(MessageCQ sq);

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
    protected MessageCB newMyCB() {
        return new MessageCB();
    }
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xabCQ() { return MessageCQ.class.getName(); }
    protected String xabLSO() { return LikeSearchOption.class.getName(); }
    protected String xabSSQS() { return HpSSQSetupper.class.getName(); }
}
