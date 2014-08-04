package org.dbflute.handson.exercise;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberSecurityBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.unit.UnitContainerTestCase;

/**
 * @author mayuko.sakaba
 */
public class HandsOn04Test extends UnitContainerTestCase {
    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberSecurityBhv memberSecurityBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    /**
     * 退会会員の未払い購入を検索
     * 退会会員のステータスコードは "WDL"。ひとまずベタで
     * 支払完了フラグは "0" で未払い。ひとまずベタで
     * 購入日時の降順で並べる
     * 会員名称と商品名と一緒にログに出力
     * 購入が未払いであることをアサート
     */
    public void test_betabeta_01() throws Exception {
        // ## Arrange ##

        // ## Act ##

        // ## Assert ##
    }
}
