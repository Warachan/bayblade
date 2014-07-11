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
 * The condition-query for in-line of message.
 * @author DBFlute(AutoGenerator)
 */
public class MessageCIQ extends AbstractBsMessageCQ {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BsMessageCQ _myCQ;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public MessageCIQ(ConditionQuery referrerQuery, SqlClause sqlClause
                        , String aliasName, int nestLevel, BsMessageCQ myCQ) {
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
    protected ConditionValue getCValueMessageId() { return _myCQ.getMessageId(); }
    protected ConditionValue getCValueSenderId() { return _myCQ.getSenderId(); }
    public String keepSenderId_InScopeRelation_MemberBySenderId(MemberCQ sq)
    { return _myCQ.keepSenderId_InScopeRelation_MemberBySenderId(sq); }
    public String keepSenderId_NotInScopeRelation_MemberBySenderId(MemberCQ sq)
    { return _myCQ.keepSenderId_NotInScopeRelation_MemberBySenderId(sq); }
    protected ConditionValue getCValueReceiverId() { return _myCQ.getReceiverId(); }
    public String keepReceiverId_InScopeRelation_MemberByReceiverId(MemberCQ sq)
    { return _myCQ.keepReceiverId_InScopeRelation_MemberByReceiverId(sq); }
    public String keepReceiverId_NotInScopeRelation_MemberByReceiverId(MemberCQ sq)
    { return _myCQ.keepReceiverId_NotInScopeRelation_MemberByReceiverId(sq); }
    protected ConditionValue getCValueMessageTime() { return _myCQ.getMessageTime(); }
    protected ConditionValue getCValueMessage() { return _myCQ.getMessage(); }
    protected ConditionValue getCValueInsDatetime() { return _myCQ.getInsDatetime(); }
    protected ConditionValue getCValueUpdDatetime() { return _myCQ.getUpdDatetime(); }
    protected ConditionValue getCValueInsTrace() { return _myCQ.getInsTrace(); }
    protected ConditionValue getCValueUpdTrace() { return _myCQ.getUpdTrace(); }
    protected Map<String, Object> xfindFixedConditionDynamicParameterMap(String pp) { return null; }
    public String keepScalarCondition(MessageCQ sq)
    { throwIICBOE("ScalarCondition"); return null; }
    public String keepSpecifyMyselfDerived(MessageCQ sq)
    { throwIICBOE("(Specify)MyselfDerived"); return null;}
    public String keepQueryMyselfDerived(MessageCQ sq)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepQueryMyselfDerivedParameter(Object vl)
    { throwIICBOE("(Query)MyselfDerived"); return null;}
    public String keepMyselfExists(MessageCQ sq)
    { throwIICBOE("MyselfExists"); return null;}
    public String keepMyselfInScope(MessageCQ sq)
    { throwIICBOE("MyselfInScope"); return null;}

    protected void throwIICBOE(String name)
    { throw new IllegalConditionBeanOperationException(name + " at InlineView is unsupported."); }

    // ===================================================================================
    //                                                                       Very Internal
    //                                                                       =============
    // very internal (for suppressing warn about 'Not Use Import')
    protected String xinCB() { return MessageCB.class.getName(); }
    protected String xinCQ() { return MessageCQ.class.getName(); }
}
