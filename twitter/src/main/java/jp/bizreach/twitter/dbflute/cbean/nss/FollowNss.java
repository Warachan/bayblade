package jp.bizreach.twitter.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import jp.bizreach.twitter.dbflute.cbean.cq.FollowCQ;

/**
 * The nest select set-upper of follow.
 * @author DBFlute(AutoGenerator)
 */
public class FollowNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected FollowCQ _query;
    public FollowNss(FollowCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * member by my ME_ID, named 'memberByMeId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMemberByMeId() {
        _query.doNss(new FollowCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberByMeId(); }});
        return new MemberNss(_query.queryMemberByMeId());
    }
    /**
     * With nested relation columns to select clause. <br />
     * member by my YOU_ID, named 'memberByYouId'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMemberByYouId() {
        _query.doNss(new FollowCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberByYouId(); }});
        return new MemberNss(_query.queryMemberByYouId());
    }
}
