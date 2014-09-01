package org.dbflute.handson.dbflute.cbean.cq;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.cbean.PurchasePaymentCB;
import org.dbflute.handson.dbflute.cbean.cq.bs.BsMemberCQ;
import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;

/**
 * The condition-query of member.
 * <p>
 * You can implement your original methods here.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class MemberCQ extends BsMemberCQ {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    // You should NOT touch with this constructor.
    /**
     * Constructor.
     * @param referrerQuery The instance of referrer query. (NullAllowed: If null, this is base query)
     * @param sqlClause The instance of SQL clause. (NotNull)
     * @param aliasName The alias name for this query. (NotNull)
     * @param nestLevel The nest level of this query. (If zero, this is base query)
     */
    public MemberCQ(ConditionQuery referrerQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        super(referrerQuery, sqlClause, aliasName, nestLevel);
    }

    // ===================================================================================
    //                                                                       Arrange Query
    //                                                                       =============
    // You can make your arranged query methods here. e.g. public void arrangeXxx()
    public void arrangeExistsBankTransferPayment() {
        scalar_Equal().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnBirthdate();
                existsPurchaseList(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.query().existsPurchasePaymentList(new SubQuery<PurchasePaymentCB>() {
                            public void query(PurchasePaymentCB subCB) {
                                subCB.query().setPaymentMethodCode_Equal_BankTransfer();
                            }
                        });
                    }
                });
            }
        }).partitionBy(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberStatusCode();
            }
        });
    }
}
