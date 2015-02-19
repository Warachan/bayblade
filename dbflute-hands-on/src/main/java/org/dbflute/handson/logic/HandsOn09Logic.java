package org.dbflute.handson.logic;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberServiceCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exbhv.cursor.PurchaseMonthCursorCursor;
import org.dbflute.handson.dbflute.exbhv.cursor.PurchaseMonthCursorCursorHandler;
import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfPurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PurchaseMonthCursorPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpInOutParameterPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpReturnResultSetPmb;
import org.dbflute.handson.dbflute.exentity.MemberService;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfPurchaseMonthSummary;
import org.dbflute.handson.dbflute.exentity.customize.PurchaseMonthSummary;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;

// done wara JavaDoc by jflute
// done wara クラス直下は空行空けましょう by jflute
/**
 * @author mayuko.sakaba
 */
public class HandsOn09Logic {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected PurchaseBhv purchaseBhv;
    @Resource
    protected MemberServiceBhv memberServiceBhv;

    // TODO wara せっかくなので、タグコメント綺麗に入れてみよう by jflute
    // 初めての外だしSQL, 外だしSQLでページングってみる, ...
    // ===================================================================================
    //                                                                     Outside Member
    //                                                                     ===============
    /**
     * ロジックのメソッド
     * List<OutsideMember> letsOutside(OutsideMemberPmb pmb)
     * 指定された ParameterBean で会員を検索する
     * 引数の値で null は許されない
     */
    public List<OutsideMember> letsOutside(OutsideMemberPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Illegal pmb");
        }
        return memberBhv.outsideSql().selectList(pmb);
    }

    /**
     * PagingResultBean<PartOfMember> selectPartOfMember(PartOfMemberPmb pmb)
     *  指定された ParameterBean で検索して、検索結果を戻す
     *  引数の値で null は許されない
     */
    public PagingResultBean<PartOfMember> selectPartOfMember(PartOfMemberPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Illegal pmb");
        }
        return memberBhv.outsideSql().manualPaging().selectPage(pmb);
    }

    // ===================================================================================
    //                                                                    Outside Purchase
    //                                                                            ========

    /**
     * ListResultBean<PurchaseMonthSummary> selectLetsSummary(PurchaseMonthSummaryPmb pmb)
     *  指定された ParameterBean で検索して、検索結果を戻す
     *  引数の値で null は許されない
     */
    public ListResultBean<PurchaseMonthSummary> selectLetsSummary(PurchaseMonthSummaryPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }
        return purchaseBhv.outsideSql().selectList(pmb);
    }

    /**
     * PagingResultBean<PartOfPurchaseMonthSummary> selectPartOfPurchaseMonthSummary(PartOfPurchaseMonthSummaryPmb pmb)
     *  指定された ParameterBean で検索して、検索結果を戻す
     *  引数の値で null は許されない
     */
    public PagingResultBean<PartOfPurchaseMonthSummary> selectPartOfPurchaseMonthSummary(
            PartOfPurchaseMonthSummaryPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }
        return purchaseBhv.outsideSql().manualPaging().selectPage(pmb);
    }

    /**
     * void selectLetsCursor(PurchaseMonthCursorPmb pmb)
     * 指定された ParameterBean でカーソル検索する
     * 引数の値で null は許されない
     * 平均購入価格の分、その会員のサービスポイント数を足す
     * 足す際、パフォーマンス考慮のために事前selectはせず、updateだけで足す
     */
    public void selectLetsCursor(PurchaseMonthCursorPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }

        purchaseBhv.outsideSql().cursorHandling().selectCursor(pmb, new PurchaseMonthCursorCursorHandler() {
            @Override
            protected Object fetchCursor(PurchaseMonthCursorCursor cursor) throws SQLException {
                while (cursor.next()) {

                    MemberServiceCB cb = new MemberServiceCB();
                    cb.query().setMemberId_Equal(cursor.getMemberId());
                    MemberService memberService = memberServiceBhv.selectEntity(cb);

                    MemberService service = new MemberService();
                    service.setMemberServiceId(memberService.getMemberServiceId());
                    service.setMemberId(cursor.getMemberId());
                    service.setServicePointCount(cursor.getPurchasePriceAverageMonth().intValue());
                    service.setVersionNo(0L);
                    memberServiceBhv.update(service);
                }
                return null;
            }
        });
    }

    /**
     * 指定された ParameterBean で SP_IN_OUT_PARAMETER を call
     */
    public void callInOutProcedure(SpInOutParameterPmb pmb) {
        memberBhv.outsideSql().call(pmb);
    }

    /**
     * 指定された ParameterBean で SP_RETURN_RESULT_SET を call
     */
    public void callResultSetProcedure(SpReturnResultSetPmb pmb) {
        memberBhv.outsideSql().call(pmb);
    }
}