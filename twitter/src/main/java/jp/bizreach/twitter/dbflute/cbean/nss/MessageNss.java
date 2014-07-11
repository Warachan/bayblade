package jp.bizreach.twitter.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import jp.bizreach.twitter.dbflute.cbean.cq.MessageCQ;

/**
 * The nest select set-upper of message.
 * @author DBFlute(AutoGenerator)
 */
public class MessageNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MessageCQ _query;
    public MessageNss(MessageCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * member by my SENDER_ID, named 'memberBySenderId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMemberBySenderId() {
        _query.doNss(new MessageCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberBySenderId(); }});
        return new MemberNss(_query.queryMemberBySenderId());
    }
    /**
     * With nested relation columns to select clause. <br />
     * member by my RECEIVER_ID, named 'memberByReceiverId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMemberByReceiverId() {
        _query.doNss(new MessageCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberByReceiverId(); }});
        return new MemberNss(_query.queryMemberByReceiverId());
    }
}
