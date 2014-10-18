package org.dbflute.handson.logic;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.junit.Test;

public class HandsOn08LogicTest extends UnitContainerTestCase {
    @Resource
    protected MemberBhv memberBhv;

    /**
     * 対応テストメソッド
     * test_updateMemberChangedToFormalizedNonstrict_会員が更新されていること()
     * 任意の仮会員の会員IDを渡して更新すること
     * 更新処理後、DB上のデータが更新されていることをアサート
     */
    @Test
    public void test_updateMemberChangedToFormalized() {
        // ## Arrange ##
        HandsOn08Logic logic = new HandsOn08Logic();
        inject(logic);

        // ## Act ##
        logic.updateMemberChangedToFormalized(5, 0L);

        // ## Assert ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(5);
        Member updatedMember = memberBhv.selectEntityWithDeletedCheck(cb);
        assertTrue(updatedMember.isMemberStatusCode正式会員());
    }

    /**
     * test_updateMemberChangedToFormalized_排他制御例外が発生すること()
     * 何かしらの方法で排他制御例外を発生させてみること
     * 排他制御例外の内容をログに出力して確認すること
     */
    @Test
    public void test_updateMemberChangedToFormalizedException() {
        //# Arrange #
        HandsOn08Logic logic = new HandsOn08Logic();

        //# Act #
        logic.updateMemberChangedToFormalized(5, 0L);

        //# Assert #
        MemberCB cb = new MemberCB();
    }

}
