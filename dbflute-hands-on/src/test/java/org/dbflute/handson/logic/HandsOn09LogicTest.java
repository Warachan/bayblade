package org.dbflute.handson.logic;

import java.util.List;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;
import org.dbflute.handson.unit.UnitContainerTestCase;

// TODO done wara JavaDoc by jflute
/**
 * @author mayuko.sakaba
 */
public class HandsOn09LogicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    protected MemberBhv memberBhv;

    // TODO done wara 1.0.5Nにアップグレードお願いします by jflute
    // 1. manage の upgrade (94) を叩く => downloadされる
    // 2. manage の renewal (1) を叩く => 自動生成される
    // 3. pom.xml を直して maven-eclipse => おしまい
    // TODO done wara @Testは無しで (Junit3方式でやっているので) by jflute
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

        // TODO done wara 外だしSQL: テーブル名、カラム名は大文字で by jflute
        // TODO done wara 外だしSQL: alias名は、mb とか serv by jflute
        // TODO done wara 外だしSQL: ConditionBeanスタイルで書いてみましょう by jflute
        // |select ...
        // |     , ...
        // |  from MEMBER
        // |    left outer join ...
        // |    inner join ...
        // | where ...
        // |   and ...
        // | order by ...
        OutsideMemberPmb pmb = new OutsideMemberPmb();
        pmb.setMemberName_PrefixSearch("S");
        // TODO wara 外だしSQLでも区分値使いたいね「外だしSQL 区分値」でぐぐる by jflute
        pmb.setMemberStatusCode("FML");

        // ## Act ##
        List<OutsideMember> letsOutside = logic.letsOutside(pmb);

        // ## Assert ##
        assertHasAnyElement(letsOutside);
        for (OutsideMember member : letsOutside) {
            String memberName = member.getMemberName();
            Integer okashiiKaramuMei = member.getAkirakaniOkashiiKaramuMei();
            log(memberName, member.getMemberStatusCode(), okashiiKaramuMei);
            // TODO done wara ログはアサートより前 by jflute
            assertTrue(memberName.startsWith("S"));
            assertTrue(member.isMemberStatusCode正式会員());
            assertNotNull(okashiiKaramuMei);
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
        // TODO done mayuko.sakaba 全権検索アサート

        // ## Assert ##
        assertHasAnyElement(memberList);
        MemberCB cb = new MemberCB();
        int countAll = memberBhv.selectCount(cb);
        log(countAll, memberList.size());
        assertEquals(countAll, memberList.size());
    }
}
