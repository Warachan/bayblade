package org.dbflute.handson.logic;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.junit.Test;
import org.seasar.dbflute.exception.EntityAlreadyUpdatedException;
import org.seasar.dbflute.unit.core.cannonball.CannonballCar;
import org.seasar.dbflute.unit.core.cannonball.CannonballDragon;
import org.seasar.dbflute.unit.core.cannonball.CannonballOption;
import org.seasar.dbflute.unit.core.cannonball.CannonballProjectA;
import org.seasar.dbflute.unit.core.cannonball.CannonballRun;

/**
 * @author mayuko.sakaba
 */
public class HandsOn08LogicTest extends UnitContainerTestCase {

    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected PurchaseBhv purchaseBhv;

    /**
     * 対応テストメソッド
     * test_updateMemberChangedToFormalized_会員が更新されていること()
     * 任意の仮会員の会員IDとバージョンNOを渡して更新すること
     * 更新処理後、DB上のデータが更新されていることをアサート
     */
    @Test
    public void test_updateMemberChangedToFormalized_会員が更新されていること() {
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
    public void test_updateMemberChangedToFormalized_排他制御例外が発生すること() {
        //# Arrange #
        HandsOn08Logic logic = new HandsOn08Logic();

        //# Act #
        logic.updateMemberChangedToFormalized(5, 0L);
        try {
            logic.updateMemberChangedToFormalized(5, 0L);
            //# Assert #
            fail();
        } catch (EntityAlreadyUpdatedException e) {
            log(e.getMessage()); //OK
        }
    }

    /**
     * test_updateMemberChangedToFormalizedNonstrict_会員が更新されていること()
     * 任意の仮会員の会員IDを渡して更新すること
     * 更新処理後、DB上のデータが更新されていることをアサート
     */
    @Test
    public void test_updateMemberChangedToFormalizedNonstrict_会員が更新されていること() {
        //# Arrange #
        HandsOn08Logic logic = new HandsOn08Logic();
        inject(logic);

        //# Act #
        logic.updatedMembreChangedToFormailizedNonstrict(7);

        //# Assert #
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(7);
        Member updatedMember = memberBhv.selectEntityWithDeletedCheck(cb);
        assertTrue(updatedMember.isMemberStatusCode正式会員());
    }

    /**
     * test_updateMemberChangedToFormalizedNonstrict_排他制御例外が発生しないこと()
     * 通常なら排他制御例外が起きるはずの状況でも排他制御例外が発生しないことをアサート
     */
    @Test
    public void test_updateMemberChangedToFormalizedNonstrict_排他制御例外が発生しないこと() {
        //# Arrange #
        HandsOn08Logic logic = new HandsOn08Logic();
        inject(logic);

        //# Act #
        logic.updatedMembreChangedToFormailizedNonstrict(7);
        logic.updatedMembreChangedToFormailizedNonstrict(7); // コレで例外が発生しなければいい

        //# Assert #
    }

    /**
     * test_deletePurchaseSimply_購入が削除されていること()
     * 任意の正式会員の会員IDを渡して削除すること
     * 削除処理後、DB上のデータが削除されていることをアサート
     */
    @Test
    public void test_deletePurchaseSimply_購入が削除されていること() {
        //# Arrange #
        HandsOn08Logic logic = new HandsOn08Logic();
        inject(logic);

        //# Act #
        logic.deletePurchaseSimply(10);

        //# Assert #
        PurchaseCB cb = new PurchaseCB();
        cb.query().setMemberId_Equal(10);
        int purchaseCount = purchaseBhv.selectCount(cb); // dataを取得する必要がない。（存在するかのみチェック）

        assertNull(purchaseCount);
    }

    /**
     * test_IfYouLike_DeadLock()
     * cannonball()メソッドを使ってデッドロックを発生させてみること
     * 例外メッセージに "Deadlock" という文字が含まれていることをアサート
     */
    @Test
    public void test_IfYouLike_DeadLock() {
        cannonball(new CannonballRun() {
            public void drive(CannonballCar car) {
                car.projectA(new CannonballProjectA() {
                    public void plan(CannonballDragon dragon) {
                        dragon.expectNormallyDone();
                        updateFoo();
                    }
                }, 1);
                car.projectA(new CannonballProjectA() {
                    public void plan(CannonballDragon dragon) {
                        dragon.expectNormallyDone();
                        updateBar();
                    }
                }, 2);
                car.projectA(new CannonballProjectA() {
                    public void plan(CannonballDragon dragon) {
                        dragon.expectOvertime();
                        updateBar();
                    }
                }, 1);
                car.projectA(new CannonballProjectA() {
                    public void plan(CannonballDragon dragon) {
                        updateFoo();
                    }
                }, 2);
            }
        }, new CannonballOption().threadCount(2).expectExceptionAny("Deadlock"));

    }

    private void updateFoo() {
        Member member = new Member();
        member.setMemberId(7);
        member.setMemberName("I'm annie");
        memberBhv.updateNonstrict(member);
    }

    private void updateBar() {
        Member junior = new Member();
        junior.setMemberId(9);
        junior.setMemberName("Junior Annie");
        memberBhv.updateNonstrict(junior);
    }
}
