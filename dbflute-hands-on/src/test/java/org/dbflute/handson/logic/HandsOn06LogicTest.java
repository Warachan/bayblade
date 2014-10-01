package org.dbflute.handson.logic;

import java.util.List;

import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.junit.Test;

// TODO 【つけましたー!】wara javadoc by jflute
/**
 * @author mayuko.sakaba
 */
public class HandsOn06LogicTest extends UnitContainerTestCase {

    /**
     * 対応テストメソッド
     * test_selectSuffixMemberList_指定したsuffixで検索されること()
     * suffix は "vic" で
     * テストメソッド名通りのアサート (今後ずっとそう)
     * テストが成り立っていることも(できる範囲で)アサート (今後ずっとそう)
     * test_selectSuffixMemberList_suffixが無効な値なら例外が発生すること()
     * 無効な値とは、nullと空文字とトリムして空文字になる値
     */
    @Test
    public void test_selectSuffixMemberList() {
        // ## Arrange ##
        HandsOn06Logic logic = new HandsOn06Logic();
        inject(logic);

        // TODO 【つけましたー!】wara ここがAct by jflute
        //　## Act ##
        List<Member> memberList = logic.selectSuffixMemberList("vic");

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            String name = member.getMemberName();
            log(member.getBirthdate(), member.getFormalizedDatetime(), name);
            assertTrue(name.endsWith("vic"));
        }
    }
}
