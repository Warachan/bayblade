package org.dbflute.handson.logic;

import java.util.List;

import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.junit.Test;

public class HandsOn09LogicTest extends UnitContainerTestCase {

    @Test
    /**
     * test_letsOutside_会員が検索されること()
     * 会員名称が "S" で始まる正式会員 (区分値メソッドを使う) で検索すること
     * 条件値を設定しなかった条件が除去されていることをログで目視確認
     * 会員サービスのサービスポイント数が取得できていることをアサート
     * 検索された会員が "S" で始まっていて、かつ、正式会員であることをアサート
     */
    public void test_letsOutside_会員が検索されること() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        OutsideMemberPmb pmb = new OutsideMemberPmb();
        pmb.setMemberName_PrefixSearch("S");
        pmb.setMemberStatusCode("FML");

        // ## Act ##
        List<OutsideMember> letsOutside = logic.letsOutside(pmb);

        // ## Assert ##
        assertHasAnyElement(letsOutside);
        for (OutsideMember member : letsOutside) {
            String memberName = member.getMemberName();
            Integer okashiiKaramuMei = member.getAkirakaniOkashiiKaramuMei();
            assertTrue(memberName.startsWith("S"));
            assertTrue(member.isMemberStatusCode正式会員());
            assertNotNull(okashiiKaramuMei);
            log(memberName, member.getMemberStatusCode(), okashiiKaramuMei);
        }
    }

    /**
     * test_letsOutside_条件値なしで全件検索されること()
     * 全ての引数を null にして実行
     * where句が存在しないことをログで目視確認
     * 検索結果が全件であることをアサート
     */
    public void test_letsOutside_条件値なしで全件検索されること() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        OutsideMemberPmb pmb = new OutsideMemberPmb();
        pmb.setMemberId(null);
        pmb.setMemberName_PrefixSearch(null);

        // ## Act ##
        List<OutsideMember> memberList = logic.letsOutside(pmb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        int count = 0;
        for (OutsideMember outsideMember : memberList) {
            count++;
        }
        log(count + ":" + memberList.size());
        assertTrue(memberList.size() == count);
    }
}
