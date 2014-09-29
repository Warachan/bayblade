package org.dbflute.handson.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import org.dbflute.handson.dbflute.cbean.cq.MemberLoginCQ;

/**
 * The nest select set-upper of member_login.
 * @author DBFlute(AutoGenerator)
 */
public class MemberLoginNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberLoginCQ _query;
    public MemberLoginNss(MemberLoginCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * (会員ステータス)member_status by my LOGIN_MEMBER_STATUS_CODE, named 'memberStatus'.
     */
    public void withMemberStatus() {
        _query.doNss(new MemberLoginCQ.NssCall() { public ConditionQuery qf() { return _query.queryMemberStatus(); }});
    }
    /**
     * With nested relation columns to select clause. <br />
     * (会員)member by my MEMBER_ID, named 'member'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public MemberNss withMember() {
        _query.doNss(new MemberLoginCQ.NssCall() { public ConditionQuery qf() { return _query.queryMember(); }});
        return new MemberNss(_query.queryMember());
    }
}
