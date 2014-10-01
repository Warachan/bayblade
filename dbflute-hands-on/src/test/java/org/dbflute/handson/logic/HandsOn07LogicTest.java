package org.dbflute.handson.logic;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberSecurity;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.junit.Test;

/**
 * @author mayuko.sakaba
 */
public class HandsOn07LogicTest extends UnitContainerTestCase {

    @Resource
    protected MemberBhv memberBhv;

    /**
     * 対応テストメソッド
     * test_insertMyselfMember_会員が登録されていること()
     * 登録後の Entity から主キーの値を使って検索すること
     * とりあえず、会員名称と生年月日だけアサート
     */
    @Test
    public void test_insertMyselfMember() {
        // ## Arrange ##
        HandsOn07Logic logic = new HandsOn07Logic();
        inject(logic);
        Member member = logic.insertMyselfMember();
        Integer id = member.getMemberId();

        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(id);

        // ## Act ##
        Member insertedMember = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        log(insertedMember);
        assertNotNull(insertedMember.getMemberName(), insertedMember.getBirthdate());
    }

    /**
     * test_insertYourselfMember_会員が登録されていること()
     * 登録されていることを代表的なカラムを利用してアサート
     * 関連テーブルの登録もアサート
     * 登録していない関連テーブルが登録されていないこともアサート
     */
    @Test
    public void test_insertYourselfMember() {
        // ## Arrange ##
        HandsOn07Logic logic = new HandsOn07Logic();
        inject(logic);
        Member member = logic.insertYourselfMember();

        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberSecurityAsOne();
        cb.query().setMemberId_Equal(member.getMemberId());

        // ## Act ##
        Member insertedMember = memberBhv.selectEntityWithDeletedCheck(cb);

        // ## Assert ##
        MemberSecurity security = insertedMember.getMemberSecurityAsOne();
        log("####" + insertedMember, security);
        assertNotNull(security);
        assertNotNull(insertedMember.getMemberId());
        assertNotNull(insertedMember.getMemberStatusCode());
        assertNotNull(insertedMember.getRegisterDatetime());
        assertNull(insertedMember.getMemberServiceAsOne());
    }
}
