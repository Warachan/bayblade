package org.dbflute.handson.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.dbflute.handson.dbflute.cbean.cq.MemberServiceCQ;

/**
 * The nest select set-upper of member_service.
 * @author DBFlute(AutoGenerator)
 */
public class MemberServiceNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberServiceCQ _query;
    public MemberServiceNss(MemberServiceCQ query) { _query = query; }
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
        _query.doNss(new MemberServiceCQ.NssCall() { public ConditionQuery qf() { return _query.queryMember(); }});
        return new MemberNss(_query.queryMember());
    }
    /**
     * With nested relation columns to select clause. <br />
     * service_rank by my SERVICE_RANK_CODE, named 'serviceRank'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public ServiceRankNss withServiceRank() {
        _query.doNss(new MemberServiceCQ.NssCall() { public ConditionQuery qf() { return _query.queryServiceRank(); }});
        return new ServiceRankNss(_query.queryServiceRank());
    }

}
