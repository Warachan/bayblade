package org.dbflute.handson.logic;

import java.util.List;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpInOutParameterPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpReturnResultSetPmb;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfMember;
import org.seasar.dbflute.cbean.PagingResultBean;

// wara JavaDoc by jflute
// wara クラス直下は空行空けましょう by jflute
public class HandsOn09Logic {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @Resource
    protected MemberBhv memberBhv;

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