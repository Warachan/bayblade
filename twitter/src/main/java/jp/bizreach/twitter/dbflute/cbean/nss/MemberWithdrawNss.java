package jp.bizreach.twitter.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import jp.bizreach.twitter.dbflute.cbean.cq.MemberWithdrawCQ;

/**
 * The nest select set-upper of member_withdraw.
 * @author DBFlute(AutoGenerator)
 */
public class MemberWithdrawNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberWithdrawCQ _query;
    public MemberWithdrawNss(MemberWithdrawCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * member by my MEMBER_ID, named 'member'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMember() {
        _query.doNss(new MemberWithdrawCQ.NssCall() { public ConditionQuery qf() { return _query.queryMember(); }});
        return new MemberNss(_query.queryMember());
    }
}
