package jp.bizreach.twitter.dbflute.cbean.nss;

import org.seasar.dbflute.cbean.ConditionQuery;
import jp.bizreach.twitter.dbflute.cbean.cq.BlackCompanyCQ;

/**
 * The nest select set-upper of black_company.
 * @author DBFlute(AutoGenerator)
 */
public class BlackCompanyNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected BlackCompanyCQ _query;
    public BlackCompanyNss(BlackCompanyCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br />
     * cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'.
     */
    public void withClsBlackCompanyStatus() {
        _query.doNss(new BlackCompanyCQ.NssCall() { public ConditionQuery qf() { return _query.queryClsBlackCompanyStatus(); }});
    }
}
