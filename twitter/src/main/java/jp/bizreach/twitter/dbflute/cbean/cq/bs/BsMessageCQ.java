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
 * The base condition-query of message.
 * @author DBFlute(AutoGenerator)
 */
public class BsMessageCQ extends AbstractBsMessageCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MessageCIQ _inlineQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMessageCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                 InlineView/OrClause
    //                                                                 ===================
    /**
     * Prepare InlineView query. <br />
     * {select ... from ... left outer join (select * from message) where FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">inline()</span>.setFoo...;
     * </pre>
     * @return The condition-query for InlineView query. (NotNull)
     */
    public MessageCIQ inline() {
        if (_inlineQuery == null) { _inlineQuery = xcreateCIQ(); }
        _inlineQuery.xsetOnClause(false); return _inlineQuery;
    }

    protected MessageCIQ xcreateCIQ() {
        MessageCIQ ciq = xnewCIQ();
        ciq.xsetBaseCB(_baseCB);
        return ciq;
    }

    protected MessageCIQ xnewCIQ() {
        return new MessageCIQ(xgetReferrerQuery(), xgetSqlClause(), xgetAliasName(), xgetNestLevel(), this);
    }

    /**
     * Prepare OnClause query. <br />
     * {select ... from ... left outer join message on ... and FOO = [value] ...}
     * <pre>
     * cb.query().queryMemberStatus().<span style="color: #DD4747">on()</span>.setFoo...;
     * </pre>
     * @return The condition-query for OnClause query. (NotNull)
     * @throws IllegalConditionBeanOperationException When this condition-query is base query.
     */
    public MessageCIQ on() {
        if (isBaseQuery()) { throw new IllegalConditionBeanOperationException("OnClause for local table is unavailable!"); }
        MessageCIQ inlineQuery = inline(); inlineQuery.xsetOnClause(true); return inlineQuery;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    protected ConditionValue _messageId;
    public ConditionValue getMessageId()
    { if (_messageId == null) { _messageId = nCV(); }
      return _messageId; }
    protected ConditionValue getCValueMessageId() { return getMessageId(); }

    /** 
     * Add order-by as ascend. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_MessageId_Asc() { regOBA("MESSAGE_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_MessageId_Desc() { regOBD("MESSAGE_ID"); return this; }

    protected ConditionValue _senderId;
    public ConditionValue getSenderId()
    { if (_senderId == null) { _senderId = nCV(); }
      return _senderId; }
    protected ConditionValue getCValueSenderId() { return getSenderId(); }

    public Map<String, MemberCQ> getSenderId_InScopeRelation_MemberBySenderId() { return xgetSQueMap("senderId_InScopeRelation_MemberBySenderId"); }
    public String keepSenderId_InScopeRelation_MemberBySenderId(MemberCQ sq) { return xkeepSQue("senderId_InScopeRelation_MemberBySenderId", sq); }

    public Map<String, MemberCQ> getSenderId_NotInScopeRelation_MemberBySenderId() { return xgetSQueMap("senderId_NotInScopeRelation_MemberBySenderId"); }
    public String keepSenderId_NotInScopeRelation_MemberBySenderId(MemberCQ sq) { return xkeepSQue("senderId_NotInScopeRelation_MemberBySenderId", sq); }

    /** 
     * Add order-by as ascend. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_SenderId_Asc() { regOBA("SENDER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_SenderId_Desc() { regOBD("SENDER_ID"); return this; }

    protected ConditionValue _receiverId;
    public ConditionValue getReceiverId()
    { if (_receiverId == null) { _receiverId = nCV(); }
      return _receiverId; }
    protected ConditionValue getCValueReceiverId() { return getReceiverId(); }

    public Map<String, MemberCQ> getReceiverId_InScopeRelation_MemberByReceiverId() { return xgetSQueMap("receiverId_InScopeRelation_MemberByReceiverId"); }
    public String keepReceiverId_InScopeRelation_MemberByReceiverId(MemberCQ sq) { return xkeepSQue("receiverId_InScopeRelation_MemberByReceiverId", sq); }

    public Map<String, MemberCQ> getReceiverId_NotInScopeRelation_MemberByReceiverId() { return xgetSQueMap("receiverId_NotInScopeRelation_MemberByReceiverId"); }
    public String keepReceiverId_NotInScopeRelation_MemberByReceiverId(MemberCQ sq) { return xkeepSQue("receiverId_NotInScopeRelation_MemberByReceiverId", sq); }

    /** 
     * Add order-by as ascend. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_ReceiverId_Asc() { regOBA("RECEIVER_ID"); return this; }

    /**
     * Add order-by as descend. <br />
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_ReceiverId_Desc() { regOBD("RECEIVER_ID"); return this; }

    protected ConditionValue _messageTime;
    public ConditionValue getMessageTime()
    { if (_messageTime == null) { _messageTime = nCV(); }
      return _messageTime; }
    protected ConditionValue getCValueMessageTime() { return getMessageTime(); }

    /** 
     * Add order-by as ascend. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_MessageTime_Asc() { regOBA("MESSAGE_TIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_MessageTime_Desc() { regOBD("MESSAGE_TIME"); return this; }

    protected ConditionValue _message;
    public ConditionValue getMessage()
    { if (_message == null) { _message = nCV(); }
      return _message; }
    protected ConditionValue getCValueMessage() { return getMessage(); }

    /** 
     * Add order-by as ascend. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_Message_Asc() { regOBA("MESSAGE"); return this; }

    /**
     * Add order-by as descend. <br />
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_Message_Desc() { regOBD("MESSAGE"); return this; }

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
    public BsMessageCQ addOrderBy_InsDatetime_Asc() { regOBA("INS_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_InsDatetime_Desc() { regOBD("INS_DATETIME"); return this; }

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
    public BsMessageCQ addOrderBy_UpdDatetime_Asc() { regOBA("UPD_DATETIME"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_UpdDatetime_Desc() { regOBD("UPD_DATETIME"); return this; }

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
    public BsMessageCQ addOrderBy_InsTrace_Asc() { regOBA("INS_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_InsTrace_Desc() { regOBD("INS_TRACE"); return this; }

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
    public BsMessageCQ addOrderBy_UpdTrace_Asc() { regOBA("UPD_TRACE"); return this; }

    /**
     * Add order-by as descend. <br />
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return this. (NotNull)
     */
    public BsMessageCQ addOrderBy_UpdTrace_Desc() { regOBD("UPD_TRACE"); return this; }

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
    public BsMessageCQ addSpecifiedDerivedOrderBy_Asc(String aliasName) { registerSpecifiedDerivedOrderBy_Asc(aliasName); return this; }

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
    public BsMessageCQ addSpecifiedDerivedOrderBy_Desc(String aliasName) { registerSpecifiedDerivedOrderBy_Desc(aliasName); return this; }

    // ===================================================================================
    //                                                                         Union Query
    //                                                                         ===========
    public void reflectRelationOnUnionQuery(ConditionQuery bqs, ConditionQuery uqs) {
        MessageCQ bq = (MessageCQ)bqs;
        MessageCQ uq = (MessageCQ)uqs;
        if (bq.hasConditionQueryMemberBySenderId()) {
            uq.queryMemberBySenderId().reflectRelationOnUnionQuery(bq.queryMemberBySenderId(), uq.queryMemberBySenderId());
        }
        if (bq.hasConditionQueryMemberByReceiverId()) {
            uq.queryMemberByReceiverId().reflectRelationOnUnionQuery(bq.queryMemberByReceiverId(), uq.queryMemberByReceiverId());
        }
    }

    // ===================================================================================
    //                                                                       Foreign Query
    //                                                                       =============
    /**
     * Get the condition-query for relation table. <br />
     * member by my SENDER_ID, named 'memberBySenderId'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMemberBySenderId() {
        return getConditionQueryMemberBySenderId();
    }
    public MemberCQ getConditionQueryMemberBySenderId() {
        String prop = "memberBySenderId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberBySenderId()); xsetupOuterJoinMemberBySenderId(); }
        return xgetQueRlMap(prop);
    }
    protected MemberCQ xcreateQueryMemberBySenderId() {
        String nrp = xresolveNRP("message", "memberBySenderId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberBySenderId", nrp);
    }
    protected void xsetupOuterJoinMemberBySenderId() { xregOutJo("memberBySenderId"); }
    public boolean hasConditionQueryMemberBySenderId() { return xhasQueRlMap("memberBySenderId"); }

    /**
     * Get the condition-query for relation table. <br />
     * member by my RECEIVER_ID, named 'memberByReceiverId'.
     * @return The instance of condition-query. (NotNull)
     */
    public MemberCQ queryMemberByReceiverId() {
        return getConditionQueryMemberByReceiverId();
    }
    public MemberCQ getConditionQueryMemberByReceiverId() {
        String prop = "memberByReceiverId";
        if (!xhasQueRlMap(prop)) { xregQueRl(prop, xcreateQueryMemberByReceiverId()); xsetupOuterJoinMemberByReceiverId(); }
        return xgetQueRlMap(prop);
    }
    protected MemberCQ xcreateQueryMemberByReceiverId() {
        String nrp = xresolveNRP("message", "memberByReceiverId"); String jan = xresolveJAN(nrp, xgetNNLvl());
        return xinitRelCQ(new MemberCQ(this, xgetSqlClause(), jan, xgetNNLvl()), _baseCB, "memberByReceiverId", nrp);
    }
    protected void xsetupOuterJoinMemberByReceiverId() { xregOutJo("memberByReceiverId"); }
    public boolean hasConditionQueryMemberByReceiverId() { return xhasQueRlMap("memberByReceiverId"); }

    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String property) {
        return null;
    }

    // ===================================================================================
    //                                                                     ScalarCondition
    //                                                                     ===============
    public Map<String, MessageCQ> getScalarCondition() { return xgetSQueMap("scalarCondition"); }
    public String keepScalarCondition(MessageCQ sq) { return xkeepSQue("scalarCondition", sq); }

    // ===================================================================================
    //                                                                       MyselfDerived
    //                                                                       =============
    public Map<String, MessageCQ> getSpecifyMyselfDerived() { return xgetSQueMap("specifyMyselfDerived"); }
    public String keepSpecifyMyselfDerived(MessageCQ sq) { return xkeepSQue("specifyMyselfDerived", sq); }

    public Map<String, MessageCQ> getQueryMyselfDerived() { return xgetSQueMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerived(MessageCQ sq) { return xkeepSQue("queryMyselfDerived", sq); }
    public Map<String, Object> getQueryMyselfDerivedParameter() { return xgetSQuePmMap("queryMyselfDerived"); }
    public String keepQueryMyselfDerivedParameter(Object pm) { return xkeepSQuePm("queryMyselfDerived", pm); }

    // ===================================================================================
    //                                                                        MyselfExists
    //                                                                        ============
    protected Map<String, MessageCQ> _myselfExistsMap;
    public Map<String, MessageCQ> getMyselfExists() { return xgetSQueMap("myselfExists"); }
    public String keepMyselfExists(MessageCQ sq) { return xkeepSQue("myselfExists", sq); }

    // ===================================================================================
    //                                                                       MyselfInScope
    //                                                                       =============
    public Map<String, MessageCQ> getMyselfInScope() { return xgetSQueMap("myselfInScope"); }
    public String keepMyselfInScope(MessageCQ sq) { return xkeepSQue("myselfInScope", sq); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xCB() { return MessageCB.class.getName(); }
    protected String xCQ() { return MessageCQ.class.getName(); }
    protected String xCHp() { return HpCalculator.class.getName(); }
    protected String xCOp() { return ConditionOption.class.getName(); }
    protected String xMap() { return Map.class.getName(); }
}
