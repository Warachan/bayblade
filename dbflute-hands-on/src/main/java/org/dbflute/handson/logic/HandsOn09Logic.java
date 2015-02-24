package org.dbflute.handson.logic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbflute.handson.dbflute.cbean.MemberServiceCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exbhv.cursor.PurchaseMonthCursorCursor;
import org.dbflute.handson.dbflute.exbhv.cursor.PurchaseMonthCursorCursorHandler;
import org.dbflute.handson.dbflute.exbhv.pmbean.OutsideMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfMemberPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PartOfPurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PurchaseMonthCursorPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.PurchaseMonthSummaryPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpInOutParameterPmb;
import org.dbflute.handson.dbflute.exbhv.pmbean.SpReturnResultSetPmb;
import org.dbflute.handson.dbflute.exentity.MemberService;
import org.dbflute.handson.dbflute.exentity.customize.OutsideMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfMember;
import org.dbflute.handson.dbflute.exentity.customize.PartOfPurchaseMonthSummary;
import org.dbflute.handson.dbflute.exentity.customize.PurchaseMonthSummary;
import org.seasar.dbflute.bhv.UpdateOption;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.helper.token.file.FileMakingCallback;
import org.seasar.dbflute.helper.token.file.FileMakingOption;
import org.seasar.dbflute.helper.token.file.FileMakingRowWriter;
import org.seasar.dbflute.helper.token.file.FileToken;
import org.seasar.dbflute.jdbc.StatementConfig;
import org.seasar.dbflute.util.DfResourceUtil;

// done wara JavaDoc by jflute
// done wara クラス直下は空行空けましょう by jflute
/**
 * @author mayuko.sakaba
 */
public class HandsOn09Logic {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(HandsOn09Logic.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected PurchaseBhv purchaseBhv;
    @Resource
    protected MemberServiceBhv memberServiceBhv;

    // done wara せっかくなので、タグコメント綺麗に入れてみよう by jflute
    // 初めての外だしSQL, 外だしSQLでページングってみる, ...
    // ===================================================================================
    //                                                                     Outside Member
    //                                                                     ===============
    /**
     * <pre>
     * ロジックのメソッド
     * List<OutsideMember> letsOutside(OutsideMemberPmb pmb)
     * 指定された ParameterBean で会員を検索する
     * 引数の値で null は許されない
     * </pre>
     */
    public List<OutsideMember> letsOutside(OutsideMemberPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Illegal pmb");
        }
        return memberBhv.outsideSql().selectList(pmb);
    }

    /**
     * <pre>
     * PagingResultBean<PartOfMember> selectPartOfMember(PartOfMemberPmb pmb)
     * 指定された ParameterBean で検索して、検索結果を戻す
     * 引数の値で null は許されない
     * </pre>
     */
    public PagingResultBean<PartOfMember> selectPartOfMember(PartOfMemberPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Illegal pmb");
        }
        return memberBhv.outsideSql().manualPaging().selectPage(pmb);
    }

    // ===================================================================================
    //                                                                    Outside Purchase
    //                                                                            ========

    /**
     * <pre>
     * ListResultBean<PurchaseMonthSummary> selectLetsSummary(PurchaseMonthSummaryPmb pmb)
     *  指定された ParameterBean で検索して、検索結果を戻す
     *  引数の値で null は許されない
     * </pre>
     */
    public ListResultBean<PurchaseMonthSummary> selectLetsSummary(PurchaseMonthSummaryPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }
        return purchaseBhv.outsideSql().selectList(pmb);
    }

    // -----------------------------------------------------
    //                                                Paging
    //                                          ------------

    /**
     * <pre>
     * PagingResultBean<PartOfPurchaseMonthSummary> selectPartOfPurchaseMonthSummary(PartOfPurchaseMonthSummaryPmb pmb)
     * 指定された ParameterBean で検索して、検索結果を戻す
     * 引数の値で null は許されない
     * </pre>
     */
    public PagingResultBean<PartOfPurchaseMonthSummary> selectPartOfPurchaseMonthSummary(
            PartOfPurchaseMonthSummaryPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }
        return purchaseBhv.outsideSql().manualPaging().selectPage(pmb);
    }

    // -----------------------------------------------------
    //                                                Cursor
    //                                          ------------

    /**
     * <pre>
     * void selectLetsCursor(PurchaseMonthCursorPmb pmb)
     * 指定された ParameterBean でカーソル検索する
     * 引数の値で null は許されない
     * 平均購入価格の分、その会員のサービスポイント数を足す
     * 足す際、パフォーマンス考慮のために事前selectはせず、updateだけで足す
     * </pre>
     */
    public void selectLetsCursor(PurchaseMonthCursorPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }
        purchaseBhv.outsideSql().cursorHandling().selectCursor(pmb, new PurchaseMonthCursorCursorHandler() {
            protected Object fetchCursor(PurchaseMonthCursorCursor cursor) throws SQLException {
                while (cursor.next()) {
                    updateMemberServicePointCount(cursor);
                }
                return null;
            }

        });
    }

    // -----------------------------------------------------
    //              Save Memory (Efficiently utilize memory)
    //                                          ------------

    /**
     * <pre>
     * メモリ対策
     * outsideSql().configure() メソッドを使って、
     * StatementConfig の FetchSize に Integer.MIN_VALUE を設定して再実行してみましょう。
     * </pre>
     */
    public void selectLetsCursorSaveMemory(PurchaseMonthCursorPmb pmb) {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }
        purchaseBhv.outsideSql().configure(new StatementConfig().fetchSize(Integer.MIN_VALUE)).cursorHandling()
                .selectCursor(pmb, new PurchaseMonthCursorCursorHandler() {
                    protected Object fetchCursor(final PurchaseMonthCursorCursor cursor) throws SQLException {
                        while (cursor.next()) {
                            updateMemberServicePointCount(cursor);
                        }
                        return null;
                    }
                });
    }

    // -----------------------------------------------------
    //                                             Write CVS
    //                                          ------------

    /**
     * <pre>
     * CSV出力用(Super Bonus)
     * 出力項目 会員名称、購入月、合計購入数量
     * デリミタ文字 カンマ
     * エンコーディング UTF-8
     * 改行コード LF
     * カラムヘッダー 一行目にはカラム名のヘッダー
     * 出力ファイル [PROJECT_ROOT]/target/hands-on-outside-bonus.csv
     * CSV出力API FileToken @since DBFlute-1.0.4F (それはもう、じっくりソースを読んで...)
     * </pre>
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void selectLetsCursorWriteCSV(final PurchaseMonthCursorPmb pmb) throws FileNotFoundException, IOException {
        if (pmb == null) {
            throw new IllegalArgumentException("Invalid pmb");
        }
        String filePath = DfResourceUtil.getBuildDir(getClass()).getParent() + "/hands-on-outside-bonus.csv";
        // For header
        List<String> columnNameList = new ArrayList<String>();
        columnNameList.add("MEMBER_NAME");
        columnNameList.add("PURCHASE_MONTH");
        columnNameList.add("PURCHASE_COUNT_SUM_MONTH");

        FileToken fileToken = new FileToken();
        fileToken.make(filePath, new FileMakingCallback() {
            public void write(final FileMakingRowWriter writer) throws IOException, SQLException {
                purchaseBhv.outsideSql().cursorHandling().selectCursor(pmb, new PurchaseMonthCursorCursorHandler() {
                    protected Object fetchCursor(PurchaseMonthCursorCursor cursor) throws SQLException {
                        while (cursor.next()) {
                            try {
                                List<String> columnList = new ArrayList<String>();
                                columnList.add(cursor.getMemberName());
                                columnList.add(cursor.getPurchaseMonth().toString());
                                columnList.add(cursor.getPurchasePriceAverageMonth().toString());
                                writer.writeRow(columnList);
                            } catch (IOException e) {
                                LOG.error("Error occured when writing file : MemberId" + cursor.getMemberId(), e);
                            }
                        }
                        return null;
                    }
                });
            }
        }, new FileMakingOption().delimitateByComma().encodeAsUTF8().separateByLf().headerInfo(columnNameList));
    }

    // ===================================================================================
    //                                                                    Assistant Method
    //                                                                            ========
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void updateMemberServicePointCount(PurchaseMonthCursorCursor cursor) throws SQLException {
        // TODO mayuko.sakaba これは事前検索してる。。。
        // wara e.g service.uniqueBy(cursor.getMemberId()); でどうだい？ by jflute
        MemberService memberService = memberServiceBhv.selectByPKValueWithDeletedCheck(cursor.getMemberId());

        MemberService service = new MemberService();
        service.setMemberServiceId(memberService.getMemberId());
        service.setMemberId(cursor.getMemberId());

        UpdateOption<MemberServiceCB> option = new UpdateOption<MemberServiceCB>();
        option.self(new SpecifyQuery<MemberServiceCB>() {
            public void specify(final MemberServiceCB spCB) {
                spCB.specify().columnServicePointCount();
            }
        }).plus(cursor.getPurchasePriceAverageMonth());
        memberServiceBhv.varyingUpdateNonstrict(service, option);
    }

    // ===================================================================================
    //                                                                           Procedure
    //                                                                           =========
    /**
     * 指定された ParameterBean で SP_IN_OUT_PARAMETER を call
     */
    public void callInOutProcedure(SpInOutParameterPmb pmb) {
        memberBhv.outsideSql().call(pmb);
    }

    /**
     * 指定された ParameterBean で SP_RETURN_RESULT_SET を call
     */
    public void callResultSetProcedure(SpReturnResultSetPmb pmb) {
        memberBhv.outsideSql().call(pmb);
    }
}