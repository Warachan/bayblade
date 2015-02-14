package org.dbflute.handson.logic;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfPurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpInOutParameterPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpReturnResultSetPmb;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfPurchaseMonthSummary;
import org.dbflute.handson.dbflute.exentity.customize.PurchaseMonthSummary;
import org.dbflute.handson.dbflute.exentity.customize.SpReturnResultSetNotParamResult1;
import org.dbflute.handson.dbflute.exentity.customize.SpReturnResultSetNotParamResult2;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.helper.HandyDate;

// done wara JavaDoc by jflute
/**
 * @author mayuko.sakaba
 */
public class HandsOn09LogicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    protected MemberBhv memberBhv;

    // ===================================================================================
    //                                                                      Outside Member
    //                                                                            ========
    // done wara 1.0.5Nにアップグレードお願いします by jflute
    // 1. manage の upgrade (94) を叩く => downloadされる
    // 2. manage の renewal (1) を叩く => 自動生成される
    // 3. pom.xml を直して maven-eclipse => おしまい
    // done wara @Testは無しで (Junit3方式でやっているので) by jflute
    // done 【いれましたー】wara せっかくなので、タグコメント綺麗に入れてみよう by jflute
    // 初めての外だしSQL, 外だしSQLでページングってみる, ...
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

        // done wara 外だしSQL: テーブル名、カラム名は大文字で by jflute
        // done wara 外だしSQL: alias名は、mb とか serv by jflute
        // done wara 外だしSQL: ConditionBeanスタイルで書いてみましょう by jflute
        // |select ...
        // |     , ...
        // |  from MEMBER
        // |    left outer join ...
        // |    inner join ...
        // | where ...
        // |   and ...
        // | order by ...
        // done wara 【あてましたー】新しいパッチを当てると、 -- // 非必須、等値 ができるようになる by jflute
        // パッチの当て方: manageで upgrade (94) を叩いて、renewal (1) しておしまい
        OutsideMemberPmb pmb = new OutsideMemberPmb();
        pmb.setMemberName_PrefixSearch("S");
        // done wara 外だしSQLでも区分値使いたいね「外だしSQL 区分値」でぐぐる by jflute
        pmb.setMemberStatusCode_正式会員();

        // ## Act ##
        List<OutsideMember> letsOutside = logic.letsOutside(pmb);

        // ## Assert ##
        assertHasAnyElement(letsOutside);
        for (OutsideMember member : letsOutside) {
            String memberName = member.getMemberName();
            Integer okashiiKaramuMei = member.getServicePointCount();
            log(memberName, member.getMemberStatusCode(), okashiiKaramuMei);
            // done wara ログはアサートより前 by jflute
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
        // done mayuko.sakaba 全権検索アサート

        // ## Assert ##
        assertHasAnyElement(memberList);
        MemberCB cb = new MemberCB();
        int countAll = memberBhv.selectCount(cb);
        log(countAll, memberList.size());
        assertEquals(countAll, memberList.size());
    }

    // ===================================================================================
    //                                                               Outside Member Paging
    //                                                                            ========

    /**
     * test_selectPartOfMember_ページング検索されること()
     * 会員名称に "vi" を含む会員を対象に検索
     * ページサイズは 4、ページ番号は 1 で検索すること
     * 期待通りのSQLがログに出力されることを確認する
     * 検索したカラム全てのデータをログ出力
     * 検索結果がページサイズ以下のデータだけであることをアサート
     * ※実装できたら、テスト実行時の条件として、サービスポイント数が1000以上というのを追加してみましょう。実行してみて特に落ちなければOKです。
     */
    public void test_selectPartOfMember_ページング検索されること() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        // done wara 結合に関して、カウント検索のパフォーマンスを最大限考慮すること (会員サービスの結合) by jflute
        // /*IF pmb.isPaging() || pmb.servicePointCount != null*/ とやりたいところだが、複雑な条件はあまりコメント上で書きたくない。
        // なので...
        // done 【書いてみましたどきどき】wara そのとき、IFコメントに記述する条件が複雑にならないように (代理判定メソッドを使う) by jflute
        // done 【書いてみましたどきどき】wara 修行++: その代理判定メソッドの UnitTest を書いてみよう by jflute
        // TODO 【if文の位置がおかしかったです】wara setServicePointCount()すると、カウント検索のときのselect句がcount(*)じゃなくて一覧になっちゃってる by jflute
        PartOfMemberPmb pmb = new PartOfMemberPmb();
        pmb.setMemberName_ContainSearch("vi");
        // 格言「おかしいと思ったら、できてる他のものと比べる」
        //pmb.setServicePointCount("aaa"); // おもいで
        pmb.setServicePointCount(1000);
        pmb.paging(4, 1);

        // ## Act ##
        PagingResultBean<PartOfMember> memberPage = logic.selectPartOfMember(pmb);

        // ## Assert ##
        assertHasAnyElement(memberPage);
        log(memberPage, memberPage.size());
        assertTrue(memberPage.size() <= 4);
    }

    // ===================================================================================
    //                                                             Purchase Month Summary
    //                                                                            ========
    /**
     * test_selectLetsSummary_集計が検索されること()
     * 会員名称に "vi" を含む会員を対象に検索
     * 会員名称に "vi" が含まれていることをアサート
     * 期待通りのSQLがログに出力されることを確認する
     * 検索したカラム全てのデータをログ出力
     */
    public void test_selectLetsSummary() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        // done 【一度消しました】wara what? "having AVG(pur.PURCHASE_PRICE) > 1000" by jflute
        // 途中なら途中でtodo入れておこう
        // done 【使ってみました?】wara 固定の区分値を使ってみよう by jflute
        // TODO 【えい！】wara まだ by jflute
        // http://dbflute.seasar.org/ja/manual/function/generator/task/sql2entity/pmbpropoption.html#fixedclassification
        PurchaseMonthSummaryPmb pmb = new PurchaseMonthSummaryPmb();
        pmb.setMemberName_ContainSearch("vi");
        // done 【やってみました】wara setPaymentCompleteFlg_True()でもFalse()でも = 1 になっちゃう by jflute
        // COMPLETE_FLGを指定するんじゃなくて、COMPLETE_FLGの条件を有効にするかどうか？っていうパラメータにしたい
        // TODO 【変更してみました】wara CompleteOnlyであるということを示す名前にしたい (これだとどんな条件なのかが読み取りにくい) by jflute
        pmb.setPaymentCompleteOnly_True();

        // ## Act ##
        ListResultBean<PurchaseMonthSummary> summaryList = logic.selectLetsSummary(pmb);

        // ## Assert ##
        assertHasAnyElement(summaryList);
        for (PurchaseMonthSummary summary : summaryList) {
            log(summary);
            String name = summary.getMemberName();
            log(name);
            assertContains(name, "vi");
        }
    }

    // ===================================================================================
    //                                                             Outside Purchase Paging
    //                                                                            ========

    public void test_selectPartOfPurchaseMonthSummary() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        // TODO 【カウントしてもおーばーふろーで落ちる…？全部サブでくくってみた…】wara カウントの結果を確認してみて。想定通りか？ by jflute
        PartOfPurchaseMonthSummaryPmb pmb = new PartOfPurchaseMonthSummaryPmb();
        pmb.setMemberName_ContainSearch("vi");
        pmb.paging(4, 1);

        // ## Act ##
        PagingResultBean<PartOfPurchaseMonthSummary> summaryPage = logic.selectPartOfPurchaseMonthSummary(pmb);

        // ## Assert ##
        assertHasAnyElement(summaryPage);
        log(summaryPage, summaryPage.size());
        assertEquals(4, summaryPage.size());
    }

    // ===================================================================================
    //                                                                       ストアドプロシージャ
    //                                                                            ========
    /**
     * v_in_varchar に "foo" を、v_inout_varchar に "bar" を設定
     * プロシージャを呼び出した後、ParameterBeanの値が入れ替わってること
     */
    public void test_callInOutProcedure_値がへんてこりんになっていること() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        SpInOutParameterPmb pmb = new SpInOutParameterPmb();
        pmb.setVInVarchar("foo");
        pmb.setVInoutVarchar("bar");

        // ## Act ##
        logic.callInOutProcedure(pmb);

        // ## Assert ##
        String vInVarchar = pmb.getVInVarchar();
        String vInoutVarchar = pmb.getVInoutVarchar();

        log(vInoutVarchar, vInVarchar);
        assertTrue(vInoutVarchar.equals(vInVarchar));
    }

    /**
     * birthdate に1968年1月1日を設定
     * 生年月日が1968年以降であることをアサート
     * 会員名称と会員ステータス名称を一行のログで出力すること
     */
    public void test_callResultSetProcedure_検索結果が取得できてること() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        Date setDate = new HandyDate("1968/1/1").getDate();

        SpReturnResultSetPmb pmb = new SpReturnResultSetPmb();
        pmb.setBirthdateFrom(setDate);

        // ## Act ##
        logic.callResultSetProcedure(pmb);

        // ## Assert ##
        List<SpReturnResultSetNotParamResult1> pmbResult1 = pmb.getNotParamResult1();
        List<SpReturnResultSetNotParamResult2> pmbResult2 = pmb.getNotParamResult2();

        for (SpReturnResultSetNotParamResult1 result1 : pmbResult1) {
            assertTrue(result1.getBirthdate().after(setDate));
            for (SpReturnResultSetNotParamResult2 result2 : pmbResult2) {
                if (result1.getMemberStatusCode().equals(result2.getMemberStatusCode())) {
                    log(result1.getMemberName() + " " + result2.getMemberStatusName());
                }
            }
        }
    }
}
