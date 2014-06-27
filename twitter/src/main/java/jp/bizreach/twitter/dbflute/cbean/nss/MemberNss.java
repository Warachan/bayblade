package jp.bizreach.twitter.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import jp.bizreach.twitter.dbflute.cbean.cq.MemberCQ;

/**
 * The nest select set-upper of member.
 * @author DBFlute(AutoGenerator)
 */
public class MemberNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberCQ _query;
    public MemberNss(MemberCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * follow by YOU_ID, named 'followByYouIdAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public FollowNss withFollowByYouIdAsOne() {
        _query.doNss(new MemberCQ.NssCall() { public ConditionQuery qf() { return _query.queryFollowByYouIdAsOne(); }});
        return new FollowNss(_query.queryFollowByYouIdAsOne());
    }
    /**
     * With nested relation columns to select clause. <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberSecurityNss withMemberSecurityAsOne() {
        _query.doNss(new MemberCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberSecurityAsOne(); }});
        return new MemberSecurityNss(_query.queryMemberSecurityAsOne());
    }
    /**
     * With nested relation columns to select clause. <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberWithdrawNss withMemberWithdrawAsOne() {
        _query.doNss(new MemberCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberWithdrawAsOne(); }});
        return new MemberWithdrawNss(_query.queryMemberWithdrawAsOne());
    }
}
