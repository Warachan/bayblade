package org.dbflute.handson.logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.MemberServiceCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.cursor.PurchaseMonthCursorCursor;
import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfPurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PurchaseMonthCursorPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpInOutParameterPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpReturnResultSetPmb;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberService;
import org.dbflute.handson.dbflute.exentity.MemberStatus;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfPurchaseMonthSummary;
import org.dbflute.handson.dbflute.exentity.customize.PurchaseMonthSummary;
import org.dbflute.handson.dbflute.exentity.customize.SpReturnResultSetNotParamResult1;
import org.dbflute.handson.dbflute.exentity.customize.SpReturnResultSetNotParamResult2;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.cbean.EntityRowHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.helper.HandyDate;
import org.seasar.dbflute.helper.token.file.FileMakingCallback;
import org.seasar.dbflute.helper.token.file.FileMakingOption;
import org.seasar.dbflute.helper.token.file.FileMakingRowWriter;
import org.seasar.dbflute.helper.token.file.FileToken;
import org.seasar.dbflute.helper.token.file.FileTokenizingCallback;
import org.seasar.dbflute.helper.token.file.FileTokenizingOption;
import org.seasar.dbflute.helper.token.file.FileTokenizingRowResource;
import org.seasar.dbflute.infra.dfprop.DfPropFile;
import org.seasar.dbflute.unit.core.transaction.TransactionPerformer;
import org.seasar.dbflute.util.DfResourceUtil;
import org.seasar.framework.util.InputStreamUtil;

// done wara JavaDoc by jflute
/**
 * @author mayuko.sakaba
 */
public class HandsOn09LogicTest extends UnitContainerTestCase {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(HandsOn09LogicTest.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected MemberServiceBhv memberServiceBhv;

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
     * <pre>
     * test_letsOutside_会員が検索されること()
     * 会員名称が "S" で始まる正式会員 (区分値メソッドを使う) で検索すること
     * 条件値を設定しなかった条件が除去されていることをログで目視確認
     * 会員サービスのサービスポイント数が取得できていることをアサート
     * 検索された会員が "S" で始まっていて、かつ、正式会員であることをアサート
     * </pre>
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
     * <pre>
     * test_letsOutside_条件値なしで全件検索されること()
     * 全ての引数を null にして実行
     * where句が存在しないことをログで目視確認
     * 検索結果が全件であることをアサート
     * </pre>
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
     * <pre>
     * test_selectPartOfMember_ページング検索されること()
     * 会員名称に "vi" を含む会員を対象に検索
     * ページサイズは 4、ページ番号は 1 で検索すること
     * 期待通りのSQLがログに出力されることを確認する
     * 検索したカラム全てのデータをログ出力
     * 検索結果がページサイズ以下のデータだけであることをアサート
     * ※実装できたら、テスト実行時の条件として、サービスポイント数が1000以上というのを追加してみましょう。実行してみて特に落ちなければOKです。
     * </pre>
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
        // done 【if文の位置がおかしかったです】wara setServicePointCount()すると、カウント検索のときのselect句がcount(*)じゃなくて一覧になっちゃってる by jflute
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
     * <pre>
     * test_selectLetsSummary_集計が検索されること()
     * 会員名称に "vi" を含む会員を対象に検索
     * 会員名称に "vi" が含まれていることをアサート
     * 期待通りのSQLがログに出力されることを確認する
     * 検索したカラム全てのデータをログ出力
     * </pre>
     */
    public void test_selectLetsSummary() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        // done 【一度消しました】wara what? "having AVG(pur.PURCHASE_PRICE) > 1000" by jflute
        // 途中なら途中でtodo入れておこう
        // done 【使ってみました?】wara 固定の区分値を使ってみよう by jflute
        // done 【えい！】wara まだ by jflute
        // http://dbflute.seasar.org/ja/manual/function/generator/task/sql2entity/pmbpropoption.html#fixedclassification
        PurchaseMonthSummaryPmb pmb = new PurchaseMonthSummaryPmb();
        pmb.setMemberName_ContainSearch("vi");
        // done 【やってみました】wara setPaymentCompleteFlg_True()でもFalse()でも = 1 になっちゃう by jflute
        // COMPLETE_FLGを指定するんじゃなくて、COMPLETE_FLGの条件を有効にするかどうか？っていうパラメータにしたい
        // done 【変更してみました】wara CompleteOnlyであるということを示す名前にしたい (これだとどんな条件なのかが読み取りにくい) by jflute
        // done 【変更しました】wara (avg(pur.PURCHASE_PRICE)) は外側の括弧はなくてOK by jflute
        // done 【変更しました】wara IF pmb.paymentCompleteOnly == true は "== true" なくてOK by jflute
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

    // -----------------------------------------------------
    //                               Outside Purchase Paging
    //                                          ------------

    /**
     * お手軽じゃないお手軽チャレンジ
     */
    public void test_selectPartOfPurchaseMonthSummary() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        // done 【カウントしてもおーばーふろーで落ちる…？全部サブでくくってみた…】wara カウントの結果を確認してみて。想定通りか？ by jflute
        // おおぉ、素晴らしい♥ by jflute
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
    //                                                       Outside Purchase Month Cursor
    //                                                                            ========
    /**
     * <pre>
     * 会員名称に "vi" を含む会員を対象に検索
     * 期待通りのSQLがログに出力されることを確認する
     * 誰か一人でもサービスポイント数が増えていることをアサート
     * </pre>
     */
    public void test_selectLetsCursor_集計が検索されること() throws Exception {
        // ## Arrange ##
        HandsOn09Logic logic = new HandsOn09Logic();
        inject(logic);

        // ## Act ##
        // Before Change
        MemberServiceCB cb = new MemberServiceCB();
        ListResultBean<MemberService> serviceBeforeList = memberServiceBhv.selectList(cb);

        PurchaseMonthCursorPmb pmb = new PurchaseMonthCursorPmb();
        pmb.setMemberName_ContainSearch("vi");
        logic.selectLetsCursor(pmb);
        // After Change
        ListResultBean<MemberService> serviceAfterList = memberServiceBhv.selectList(cb);

        // ## Assert ##
        boolean pointIncreased = false;
        for (MemberService before : serviceBeforeList) {
            for (MemberService after : serviceAfterList) {
                if (before.getMemberServiceId().equals(after.getMemberServiceId())) {
                    if (after.getServicePointCount() > before.getServicePointCount()) {
                        log("Before " + before.getMemberServiceId() + "," + before.getServicePointCount() + ": After "
                                + after.getMemberServiceId() + "," + after.getServicePointCount());
                        pointIncreased = true;
                        break;
                    }
                }
            }
            // 思い出
            //            // After Change
            //            MemberServiceCB afterCb = new MemberServiceCB();
            //            afterCb.query().setMemberId_Equal(serviceBefore.getMemberId());
            //            afterCb.query().setMemberServiceId_Equal(serviceBefore.getMemberServiceId());
            //
            //            MemberService serviceAfter = memberServiceBhv.selectEntity(afterCb);
            //
            //            log("Before" + serviceBefore.getServicePointCount() + ": After" + serviceAfter.getServicePointCount());
            //            if (serviceAfter.getServicePointCount() > serviceBefore.getServicePointCount()) {
            //                pointIncreased = true;
            //            }

        }
        assertTrue(pointIncreased);
    }

    // -----------------------------------------------------
    //                                          Bonus Stage
    //                                          ------------
    /**
     * <pre>
     *  メモリ対策
     *  outsideSql().configure() メソッドを使って、
     *  StatementConfig の FetchSize に Integer.MIN_VALUE を設定して再実行してみましょう。
     * </pre>
     */
    public void test_selectLetsCursor_メモリ対策() throws Exception {
        // ## Arrange ##
        final HandsOn09Logic logic = new HandsOn09Logic() {
            @Override
            public void updateMemberServicePointCount(final PurchaseMonthCursorCursor cursor) throws SQLException {
                performNewTransaction(new TransactionPerformer() {
                    public boolean perform() throws SQLException {
                        callSuperUpdate(cursor);
                        return true;
                    }
                });
            }

            private void callSuperUpdate(final PurchaseMonthCursorCursor cursor) throws SQLException {
                super.updateMemberServicePointCount(cursor);
            }
        };
        // わらおもいで
        //final HandsOn09Logic logic = new HandsOn09Logic() {
        //    public void selectLetsCursorSaveMemory(PurchaseMonthCursorPmb pmb) {
        //        purchaseBhv.outsideSql().configure(new StatementConfig().fetchSize(Integer.MIN_VALUE)).cursorHandling()
        //                .selectCursor(pmb, new PurchaseMonthCursorCursorHandler() {
        //                    protected Object fetchCursor(final PurchaseMonthCursorCursor cursor) throws SQLException {
        //                        while (cursor.next()) {
        //                            performNewTransaction(new TransactionPerformer() {
        //                                public boolean perform() throws SQLException {
        //                                    // logic.updateMemberServicePointFromSummery(cursor.getMemberId(),
        //                                    // priceAverageMonth);
        //                                    MemberService memberService = memberServiceBhv
        //                                            .selectByPKValueWithDeletedCheck(cursor.getMemberId());
        //
        //                                    MemberService service = new MemberService();
        //                                    service.setMemberServiceId(memberService.getMemberId());
        //                                    service.setMemberId(cursor.getMemberId());
        //
        //                                    UpdateOption<MemberServiceCB> option = new UpdateOption<MemberServiceCB>();
        //                                    option.self(new SpecifyQuery<MemberServiceCB>() {
        //                                        public void specify(final MemberServiceCB spCB) {
        //                                            spCB.specify().columnServicePointCount();
        //                                        }
        //                                    }).plus(cursor.getPurchasePriceAverageMonth());
        //                                    memberServiceBhv.varyingUpdateNonstrict(service, option);
        //                                    return true;
        //                                }
        //                            });
        //                        }
        //                        return null;
        //                    }
        //                });
        //    }
        //};

        inject(logic);
        // ここ？ => うん♥
        adjustTransactionIsolationLevel_ReadCommitted();
        // Before Change
        MemberServiceCB cb = new MemberServiceCB();
        ListResultBean<MemberService> serviceBeforeList = memberServiceBhv.selectList(cb);

        // ## Act ##
        PurchaseMonthCursorPmb pmb = new PurchaseMonthCursorPmb();
        pmb.setMemberName_ContainSearch("vi");
        logic.selectLetsCursorSaveMemory(pmb);

        // ## Assert ##
        // After Change
        ListResultBean<MemberService> serviceAfterList = memberServiceBhv.selectList(cb);
        boolean pointIncreased = false;
        for (MemberService before : serviceBeforeList) {
            for (MemberService after : serviceAfterList) {
                if (before.getMemberServiceId().equals(after.getMemberServiceId())) {
                    if (after.getServicePointCount() > before.getServicePointCount()) {
                        log("Before " + before.getMemberServiceId() + "," + before.getServicePointCount() + ": After "
                                + after.getMemberServiceId() + "," + after.getServicePointCount());
                        pointIncreased = true;
                        break;
                    }
                }
            }
        }
        assertTrue(pointIncreased);
    }

    // -----------------------------------------------------
    //                                     Super Bonus Stage
    //                                          ------------
    public void test_selectLetsCursor_CSV() throws Exception {
        // ## Arrange ##
        final HandsOn09Logic logic = new HandsOn09Logic() {
            @Override
            public void updateMemberServicePointCount(final PurchaseMonthCursorCursor cursor) throws SQLException {
                performNewTransaction(new TransactionPerformer() {
                    public boolean perform() throws SQLException {
                        callSuperUpdate(cursor);
                        return true;
                    }
                });
            }

            private void callSuperUpdate(final PurchaseMonthCursorCursor cursor) throws SQLException {
                super.updateMemberServicePointCount(cursor);
            }
        };
        inject(logic);
        adjustTransactionIsolationLevel_ReadCommitted();

        // ## Act ##
        PurchaseMonthCursorPmb pmb = new PurchaseMonthCursorPmb();
        pmb.setMemberName_ContainSearch("vi");
        logic.selectLetsCursorWriteCSV(pmb);

        // ## Assert ##
        final ArrayList<String> dataList = new ArrayList<String>();

        String filePath = DfResourceUtil.getBuildDir(getClass()).getParent() + "/hands-on-outside-bonus.csv";
        FileToken fileToken = new FileToken();
        // 違った。。。
        //        fileToken.notifyAll();
        fileToken.tokenize(filePath, new FileTokenizingCallback() {
            public void handleRow(FileTokenizingRowResource resource) throws IOException, SQLException {
                String data = resource.getRowString();
                dataList.add(data);
                LOG.info(data);
            }
        }, new FileTokenizingOption().delimitateByComma().encodeAsUTF8().beginFirstLine());
        assertHasAnyElement(dataList);
    }

    // -----------------------------------------------------
    //                                   Miracle Bonus Stage
    //                                          ------------
    /**
     * <pre>
     * 出力項目 会員名称、生年月日(yyyy/MM/dd)、正式会員日時(yyyy/MM/dd HH:mm:ss)
     * デリミタ文字  タブ
     * エンコーディング UTF-8
     * 改行コード LF
     * カラムヘッダー なし
     * 出力ファイル [PROJECT_ROOT]/target/hands-on-cb-bonus.tsv
     * TSV出力API FileToken @since DBFlute-1.0.4F
     * </pre>
     * @param cursor
     * @throws FileNotFoundException
     * @throws SQLException
     */
    public void test_selectLetsCursorWriteSec3() throws FileNotFoundException, IOException {
        // ## Arrange ##
        final MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        cb.query().addOrderBy_MemberId_Desc();

        String filePath = DfResourceUtil.getBuildDir(getClass()).getParent() + "/hands-on-cb-bonus.tsv";
        // アサート用
        final List<String> statusList = new ArrayList<String>();

        // ## Act ##
        FileToken fileToken = new FileToken();
        fileToken.make(filePath, new FileMakingCallback() {
            public void write(final FileMakingRowWriter writer) throws IOException, SQLException {
                memberBhv.selectCursor(cb, new EntityRowHandler<Member>() {
                    public void handle(Member entity) {
                        try {
                            assertionForSec3(statusList, entity);
                            assertHasAnyElement(statusList);
                            writeData(writer, entity);
                        } catch (IOException e) {
                            e.printStackTrace();
                            LOG.error("Error occured when writing file : MemberId" + entity.getMemberId(), e);
                        }
                    }

                    private void assertionForSec3(final List<String> statusList, Member entity) throws IOException {
                        // ## Assert ##
                        assertNotNull(entity);
                        MemberStatus status = entity.getMemberStatus();
                        LOG.info("*********" + status);
                        assertNotNull(status);
                        String currentStatus = status.getMemberStatusCode();

                        if (!statusList.isEmpty()) {
                            log(statusList.size());
                            String lastStatus = statusList.get(statusList.size() - 1);
                            if (!lastStatus.equals(currentStatus)) { // 違ったら
                                assertFalse(statusList.contains(currentStatus));
                            }
                        }
                        statusList.add(currentStatus);
                    }

                    private void writeData(final FileMakingRowWriter writer, Member entity) throws IOException {
                        ArrayList<String> columnList = new ArrayList<String>();
                        columnList.add(entity.getMemberName());
                        if (entity.getBirthdate() != null) {
                            columnList.add(entity.getBirthdate().toString());
                        }
                        if (entity.getFormalizedDatetime() != null) {
                            columnList.add(entity.getFormalizedDatetime().toString());
                        }

                        writer.writeRow(columnList);
                    }
                });
            }
        }, new FileMakingOption().delimitateByTab().encodeAsUTF8().separateByLf());

        final ArrayList<String> dataList = new ArrayList<String>();
        fileToken.tokenize(filePath, new FileTokenizingCallback() {
            public void handleRow(FileTokenizingRowResource resource) throws IOException, SQLException {
                String data = resource.getRowString();
                dataList.add(data);
                LOG.info(data);
            }
        }, new FileTokenizingOption().delimitateByComma().encodeAsUTF8().beginFirstLine());
        assertHasAnyElement(dataList);

        DfPropFile dfPropFile = new DfPropFile();
        InputStreamUtil inputStreamUtil = new InputStreamUtil();
        //        new DfRefreshResourceRequest(projectNameList, requestUrl)
        // TODO mayuko.sakaba まだミラクルが起こせていない。。。
    }

    // ===================================================================================
    //                                                                       ストアドプロシージャ
    //                                                                            ========
    /**
     * <pre>
     * v_in_varchar に "foo" を、v_inout_varchar に "bar" を設定
     * プロシージャを呼び出した後、ParameterBeanの値が入れ替わってること
     * </pre>
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
     * <pre>
     * birthdate に1968年1月1日を設定
     * 生年月日が1968年以降であることをアサート
     * 会員名称と会員ステータス名称を一行のログで出力すること
     * </pre>
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
