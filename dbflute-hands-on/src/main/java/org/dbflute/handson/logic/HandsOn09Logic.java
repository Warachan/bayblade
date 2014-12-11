package org.dbflute.handson.logic;

import java.util.List;

import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;

// TODO wara JavaDoc by jflute
// TODO wara クラス直下は空行空けましょう by jflute
public class HandsOn09Logic {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
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
}