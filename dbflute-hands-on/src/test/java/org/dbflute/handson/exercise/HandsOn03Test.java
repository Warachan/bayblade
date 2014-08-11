package org.dbflute.handson.exercise;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.MemberSecurityCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberSecurityBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberSecurity;
import org.dbflute.handson.dbflute.exentity.MemberStatus;
import org.dbflute.handson.dbflute.exentity.MemberWithdrawal;
import org.dbflute.handson.dbflute.exentity.Product;
import org.dbflute.handson.dbflute.exentity.ProductCategory;
import org.dbflute.handson.dbflute.exentity.ProductStatus;
import org.dbflute.handson.dbflute.exentity.Purchase;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.cbean.EntityRowHandler;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.ManualOrderBean;
import org.seasar.dbflute.cbean.PagingResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.coption.ColumnConversionOption;
import org.seasar.dbflute.cbean.coption.FromToOption;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.dbflute.cbean.pagenavi.PageNumberLink;
import org.seasar.dbflute.cbean.pagenavi.PageNumberLinkSetupper;
import org.seasar.dbflute.helper.HandyDate;

/**
 * @author mayuko.sakaba
 */
public class HandsOn03Test extends UnitContainerTestCase {

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberSecurityBhv memberSecurityBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    /**
     * ☆ Done
     * [1] 会員名称がSで始まる1968年1月1日以前に生まれた会員を検索
     * 会員ステータスも取得する
     * 生年月日の昇順で並べる
     * 会員が1968/01/01以前であることをアサート
     * 「以前」の解釈は日付によってしっかり確認すること
     * @throws Exception
     */
    // warachan sectionのまちがいかな？ by jflute
    public void test_number1() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        // warachan 基準の日付、対象の日付的なニュアンスの変数名がほしいかな、targetDateとか by jflute
        Date targetDate = new HandyDate("1968/1/1").getDate();
        cb.setupSelect_MemberStatus();
        cb.query().setMemberName_PrefixSearch("S");
        cb.query().setBirthdate_LessEqual(targetDate);
        cb.query().addOrderBy_Birthdate_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            MemberStatus status = member.getMemberStatus();
            Date birthdate = member.getBirthdate();
            log(status, birthdate);
            // Q.コレだとdateを変えるとそのまま適応されてしまうのでは？ →　すみません勘違いでした＞＜かなり前に納得したものがそのまま残っていました。
            // warachan　【確認済】"dateを変える" とは？？？ by jflute
            assertTrue(birthdate.before(targetDate) || birthdate.equals(targetDate));
            // warachan 【直しました】すらすらコメント微調整、// の後ろに空白を一つ入れる、二つ入ってるのもあるよ by jflute
            /* そのほかのやり方 */
            assertFalse(birthdate.after(targetDate)); // コレだと含まない選択肢があっても、未来ではない、といっているのだから以前を考えなくていい。
            assertTrue(birthdate.compareTo(targetDate) <= 0); // このメソッドはintegerを返してくる
            assertTrue(birthdate.getTime() <= targetDate.getTime()); // 日付も数値的に内部で表現されているからこそ
            assertTrue(new HandyDate(birthdate).isLessEqual(targetDate));
        }
    }

    /**
     * ☆　Done
     * [2] 会員ステータスと会員セキュリティ情報も取得して会員を検索
     * 若い順で並べる。生年月日がない人は会員IDの昇順で並ぶようにする
     * 会員ステータスと会員セキュリティ情報が存在することをアサート
     */
    public void test_number2() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberSecurityAsOne();
        cb.query().addOrderBy_Birthdate_Desc();
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            MemberStatus status = member.getMemberStatus();
            MemberSecurity security = member.getMemberSecurityAsOne();
            assertNotNull(status); // →notNull制約・FK制約のカラムだから必すsetupSelectが存在するといえる。many to oneなので、物理的制約がある。
            assertNotNull(security); // カージナリティ的に"1対必ず1"だから（黒ぽちがない）必ず存在するといえる。（物理制約はない）
            assertTrue(status != null && security != null);
            Date birthdate = member.getBirthdate();
            log(status, security, birthdate);
            // 間違い1　そもそもチェックしたいのはステータス名とユーザーではない。
            // String status = member.getMemberStatus().getMemberStatusName();
            // String security = member.getMemberSecurityAsOne().getRegisterUser();
            // 間違い2　両方同時にnullではないというしてしまうと、片方がnullでも大丈夫になってしまう。
            // assertFalse(status == null && security == null);
            // 間違い3　assertNotNullの第一引数はメッセージを入れるなので(status,security)は間違い。
            // assertNotNull(status, security);

            // 【久保さんコメント】
            // warachan "(両方同時にnull) というわけではない" というassertだと、片方nullのケースが検出できない by jflute
            // assertFalse(status == null && security == null);
            //  -> "(両方同時にnull) というわけではない" つまり 片方は null でも大丈夫になっちゃう
            // なので、
            // assertTrue(status != null && security != null);
            // という感じで "両方ともnullではない" ならOK。
            // というか、assertNotNull(status); assertNotNull(security); でOK。
            // ちなみに、assertNotNullの第一引数はメッセージを入れるところなので、assertNotNull(status, security);は間違い
            // warachan と、ここまで書いたけど、そもそもチェックしたいのは、getMemberStatusName()とgetRegisterUser()ではない by jflute
            // setupSelectをしたかどうかを証明するなら、getMemberStatus(), getMemberSecurityAsOne()の方をチェックすべし

            /* statusがなぜ必ずデータが存在するといえるか。*/
            // →notNull制約・FK制約のカラムだから必すsetupSelectが存在するといえる。many to oneなので、物理的制約がある。
            /* securityがなぜ必ずデータがあるといえるか。 */
            // カージナリティ的に"1対必ず1"だから（黒ぽちがない）必ず存在するといえる。（物理制約はない）
            // 論理的制約、論理的には制約があるけど、実際、物理的にそうとは限らない。業務制約ともいう。
            // * null が存在しうる制約をnullableと呼ぶ。
            // 必ず存在するかどうかについて、テーブルのschemaを読むのもあり。（そのテーブルが信用できるものなら）
        }
    }

    /**
     * ☆ Done
     * [3] 会員セキュリティ情報のリマインダ質問で2という文字が含まれている会員を検索
     * 会員セキュリティ情報のデータ自体は要らない
     * リマインダ質問に2が含まれていることをアサート
     * アサートするために別途検索処理を入れても誰も文句は言わない
     */
    public void test_number3() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        // 子テーブルのカラムを利用して絞り込む。
        cb.query().queryMemberSecurityAsOne().setReminderQuestion_LikeSearch("2", new LikeSearchOption().likeContain());
        //　【思い出】
        //  cb.query().existsMemberSecurityAsOne(new SubQuery<MemberSecurityCB>() {
        //     @Override
        //       public void query(MemberSecurityCB subCB) {
        //          subCB.query().setReminderQuestion_LikeSearch("2", new LikeSearchOption().likeContain());
        //          }
        //       });

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        // ************EntityのリストからPK/ユニークで一致するカラムを取得する。（こういうやり方もある）*************************
        // List<Integer> memberIdList = memberBhv.extractMemberIdList(memberList);
        //**********************************************************************************************

        // ## Assert ##
        assertHasAnyElement(memberList);
        //　→　メンバーに対応するセキュリティーを一度で取得できなければならない。
        // 何ができないかではなく、何ができなければならないのかをまず考えなければ正解を見出しにくい。
        // topdown, buttomup どっちもできるようにすること
        List<Integer> memberIDList = new ArrayList<Integer>();
        // こうも書ける ユニークキーもしくはpkのときに使える。
        // List<Integer> idList = memberBhv.extractMemberIdList(memberList);
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            memberIDList.add(memberId);
        }
        MemberSecurityCB securityCB = new MemberSecurityCB();
        securityCB.query().setMemberId_InScope(memberIDList);
        ListResultBean<MemberSecurity> securityList = memberSecurityBhv.selectList(securityCB);

        for (Member member : memberList) {
            for (MemberSecurity security : securityList) {
                if (member.getMemberId().equals(security.getMemberId())) {
                    String question = security.getReminderQuestion();
                    log(member.getMemberId(), member.getMemberName(), question);
                    assertTrue(question.contains("2"));
                    break;
                }
            }
        }
        // warachan 【直しました】HashMapをnewしたときの変数の型は、Mapインターフェースで。メモだけどしっかり直しておこう by jflute
        //  ***************************** Mapを使った場合。************************************************
        //        MemberSecurityCB securityCB = new MemberSecurityCB();
        //        securityCB.query().setMemberId_InScope(memberIDList);
        //        ListResultBean<MemberSecurity> securityList = memberSecurityBhv.selectList(securityCB);
        //        Map<Integer, MemberSecurity> securityMap = new HashMap<Integer, MemberSecurity>();
        //        for (MemberSecurity security : securityList) {
        //            securityMap.put(security.getMemberId(), security);
        //        }
        //        for (Member member : memberList) {
        //            Integer memberId = member.getMemberId();
        //            MemberSecurity security = securityMap.get(memberId);
        //            log(member.getMemberName(), security.getReminderQuestion());
        //        }
        //　*********************************************************************************************
    }

    //　思い出 setupSelectをしてないからできない。
    // String question = member.getMemberSecurityAsOne().getReminderQuestion();
    // 思い出 memberSecurityテーブルのデータを丸々持ってきてしまった。
    //        // ## Arrange ##
    //        MemberSecurityCB cb = new MemberSecurityCB();
    //        cb.setupSelect_Member();
    //        cb.query().setReminderQuestion_LikeSearch("2", new LikeSearchOption().likeContain());
    //        // ## Act ##
    //        ListResultBean<MemberSecurity> securityList = securityBhv.selectList(cb);
    //        // ## Assert ##
    //        assertHasAnyElement(securityList);
    //        for (MemberSecurity security : securityList) {
    //            String question = security.getReminderQuestion();
    //            log(question);
    //            assertTrue(question.contains("2"));
    //        }

    /**
     * ☆ On hold
     * [4] 会員ステータスの表示順カラムで会員を並べて検索
     * 会員ステータスの "表示順" カラムの昇順で並べる
     * 会員ステータスのデータ自体は要らない
     * その次には、会員の会員IDの降順で並べる
     * 会員ステータスのデータが取れていないことをアサート
     * 会員が会員ステータスごとに固まって並んでいることをアサート
     */
    public void test_No4() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        cb.query().addOrderBy_MemberId_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        // TODO wara プレゼンイベントやりましょう by jflute
        // わらちゃんが、固まって並んでいることをチェックする画期的な機能を実装した。
        // 営業さんが、お客様に説明するときに「そんなことどうやってるの？」と聞かれそう。
        // 納得してもらうためにも、そのロジックを説明したいので営業さんに説明する。
        int count = 0;
        int count2 = 0;
        int count3 = 0;
        String statusCode = "";
        ArrayList<String> orderList = new ArrayList<String>();
        for (Member member : memberList) {
            // warachan 【直しました】IDがmemberIdにするのであれば、NAMEはmemberNameかな by jflute
            String memberName = member.getMemberName();
            Integer memberId = member.getMemberId();
            MemberStatus status = member.getMemberStatus();
            assertNull(status);
            statusCode = member.getMemberStatusCode();
            if (statusCode.equals("FML")) {
                count++;
            } else if (statusCode.equals("WDL")) {
                count2++;
            } else if (statusCode.equals("PRV")) {
                count3++;
            }
            log(memberName, memberId, statusCode);
        }
        if (statusCode.equals("FML")) {
            orderList.add(statusCode);
            count--;
            assertFalse(count != 0);
        } else if (count == 0 && statusCode.equals("WDL")) {
            orderList.add(statusCode);
            count2--;
        } else if (count2 == 0 && statusCode.equals("PRV")) {
            orderList.add(statusCode);
        }
        log(statusCode, count, count2, count3);
    }

    /**
     *　☆Done
     * [5] 生年月日が存在する会員の購入を検索
     * 会員名称と会員ステータス名称と商品名も一緒に取得(ログ出力)
     * 購入日時の降順、購入価格の降順、商品IDの昇順、会員IDの昇順で並べる
     * OrderBy がたくさん追加されていることをログで確認すること
     * 購入に紐づく会員の生年月日が存在することをアサート
     * ※ログ出力は、スーパークラスの log() メソッドが利用できる。可変長引数でカンマ区切り出力になる。
     */
    public void test_No5() throws Exception {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Product();
        cb.setupSelect_Member().withMemberStatus();
        cb.query().queryMember().setBirthdate_IsNotNull();
        cb.query().addOrderBy_PurchaseDatetime_Desc();
        cb.query().addOrderBy_PurchasePrice_Asc();
        cb.query().addOrderBy_ProductId_Asc();
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (Purchase purchase : purchaseList) {
            Integer price = purchase.getPurchasePrice();
            // warachan 【直しました】getMember()が三回呼ばれているので、ctrl + 1 で助けてあげてくださいs by jflute
            Member member = purchase.getMember();
            String statusName = member.getMemberStatus().getMemberStatusName();
            String memberName = member.getMemberName();
            Date birthdate = member.getBirthdate();
            assertNotNull(birthdate);
            log(price, statusName, memberName, birthdate);
            // mayuko.sakaba ログに普通に出力されているだけだけどいいのか？
            // warachan 【確認済み】うん！ログ出力せよと言われたら、目視で確認でOK by jflute
        }
    }

    /**
     * [6] 会員名称に "vi" を含む会員を検索
     * 会員ステータスも一緒に取得
     * ただし、会員ステータス名称だけ取得できればいい (説明や表示順カラムは不要)
     * 2005年10月の1日から3日までに正式会員になった会員を検索
     * 会員名称と正式会員日時と会員ステータス名称をログに出力
     * 会員ステータスがコードと名称だけが取得されていることをアサート
     * 会員の正式会員日時が指定された条件の範囲内であることをアサート
     * ※実装できたら、こんどはスーパークラスのメソッド adjustMember_FormalizedDatetime_...() を使って、
     *   10月1日ジャスト(時分秒なし)の正式会員日時を持つ会員データを作成してテスト実行してみましょう。
     *   もともと一件しかなかった検索結果が「二件」になるはずです。
     */
    public void test_No6() throws Exception {
        // ## Arrange ##
        Date beginDate = new HandyDate("2005/10/01").getDate();
        Date endDate = new HandyDate("2005/10/03").getDate();
        adjustMember_FormalizedDatetime_FirstOnly(beginDate, "vi");
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.specify().specifyMemberStatus().columnMemberStatusName(); // できるってことだけわかっていればOK by jflute
        cb.query().setMemberName_LikeSearch("vi", new LikeSearchOption().likeContain());
        cb.query().setFormalizedDatetime_DateFromTo(beginDate, endDate);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        // 【いれましたー!】wara 素通り防止を忘れている by jflute
        assertHasAnyElement(memberList);
        // 【使いなおします。】wara コメントアウトにコメントを by jflute
        Date assertBeginDate = new HandyDate("2005/09/30").moveToDayTerminal().getDate();
        // 冗長すぎるので却下
        //  Date assertBeginDate = new HandyDate(beginDate).beginDay_Hour(toDate("2005/09/30 23:59:59")).getDate();
        Date assertEndDate = new HandyDate(endDate).addDay(1).getDate();
        for (Member member : memberList) {
            String name = member.getMemberName();
            Timestamp datetime = member.getFormalizedDatetime();
            MemberStatus status = member.getMemberStatus();
            log(name, datetime, status);
            assertContains(name, "vi");
            assertTrue(status.getDescription() == null && status.getDisplayOrder() == null);
            // 【修正しました－！】wara ハードコードせずにやってみよう by jflute
            // 【修正しましたー！】wara あと、for文の外でいいんじゃない？ by jflute
            // 【おっしゃるとおりでございます。】wara 10/01.add(-1) => 9/30 より後、だと9/30の10時のデータもOKになっちゃうよ by jflute
            // 【修正したつもりでございます】wara 10/01ぴったりが入らないでございます by jflute
            // 【微妙ですみません。。。まだしっくりくるものを考えられていないです。】wara 「10/01とぴったり同じ、もしくは、10/04 より前」ってロジック変じゃない？(。´･ω･)? by jflute
            assertTrue(datetime.after(assertBeginDate) && datetime.before(assertEndDate));

            // もし、assertBeginDateが10/1だったら、こんなかんじだよーん by jflute
            assertTrue((datetime.after(assertBeginDate) || datetime.equals(assertBeginDate))
                    && datetime.before(assertEndDate));

            // 【修正しましたー！】wara ログはできるだけアサートの前のほうがいい (落ちたときに見られないから) by jflute
        }
    }

    /**
     * [7] 正式会員になってから一週間以内の購入を検索
     * 会員と会員ステータス、会員セキュリティ情報も一緒に取得
     * 商品と商品ステータス、商品カテゴリ、さらに上位の商品カテゴリも一緒に取得
     * 上位の商品カテゴリ名が取得できていることをアサート
     * 購入日時が正式会員になってから一週間以内であることをアサート
     * ※ログ出力と書いてなくても、テストの動作を確認するためにも(自由に)ログ出力すると良い。
     * ※実装できたら、こんどはスーパークラスのメソッド adjustPurchase_PurchaseDatetime_...() を呼び出し、
     *   調整されたデータによって検索結果が一件増えるかどうか確認してみましょう。 もし増えないなら、なぜ増えないのか..
     */
    public void test_07() throws Exception {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        // wara 増えない理由をしっかり考えて来ましょう by jflute
        // TODO wara 増えない理由をここに書いてみて (漠然読みの成果) by jflute
        // 指定された範囲内でpurchase dateを持つ最初のメンバーをセレクトし、
        // そのメンバーのformalizedDatetimeに7日分足して更にもっとも新しい日付の23:59:999まで移動した日時に変更する。
        // その後、purchaseDatetimeに、変更後のfomalizedDatetimeを設定しする。
        // この変更後のpurchasedDatetimeと、メンバーのもともとのformalizedDatetimeを比較した場合、
        // 比較時の絞り込み条件はformalizedDatetimeに7日分たした時間以内にpurchasedDatetimeが存在した場合なので、
        // formalizedDatetimeの時間が23:59:999でない限り、purchasedDatetimeが一週間以内に存在することはありません。
        // つまりformalizedDatetimeの時間から23:59:999までの時分秒が余分に足されている状態。

        // TODO wara 絞り込み条件を変えて増やしてみましょう by jflute
        adjustPurchase_PurchaseDatetime_fromFormalizedDatetimeInWeek();
        cb.setupSelect_Member().withMemberSecurityAsOne();
        cb.setupSelect_Member().withMemberStatus();
        cb.setupSelect_Product().withProductCategory().withProductCategorySelf();
        cb.setupSelect_Product().withProductStatus();
        // 【消しましたー！！】wara 空行削除しちゃってOK。@Overrideも消しちゃってOK by jflute
        cb.columnQuery(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseDatetime();
            }
        }).lessThan(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().specifyMember().columnFormalizedDatetime();
            }
        }).convert(new ColumnConversionOption().addDay(8).truncTime());

        cb.columnQuery(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseDatetime();
            }
        }).greaterEqual(new SpecifyQuery<PurchaseCB>() {
            public void specify(PurchaseCB cb) {
                cb.specify().specifyMember().columnFormalizedDatetime();
            }
        });
        cb.query().queryProduct().addOrderBy_ProductCategoryCode_Desc(); // まあOK

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (Purchase purchase : purchaseList) {
            Product product = purchase.getProduct();
            ProductStatus productStatus = purchase.getProduct().getProductStatus();
            ProductCategory category = purchase.getProduct().getProductCategory();
            ProductCategory parentCategory = category.getProductCategorySelf();
            MemberStatus memberStatus = purchase.getMember().getMemberStatus();
            Timestamp formalizedDatetime = purchase.getMember().getFormalizedDatetime();
            Timestamp purchaseDatetime = purchase.getPurchaseDatetime();
            long formalizeTime = formalizedDatetime.getTime();
            long purchaseTime = purchaseDatetime.getTime();
            long weekTime = 1000 * 60 * 60 * 24 * 7;
            log(purchaseDatetime, formalizedDatetime, product.getProductName(), productStatus.getProductStatusName(),
                    category.getProductCategoryName(), parentCategory.getProductCategoryName(),
                    memberStatus.getMemberStatusName());
            assertTrue(formalizeTime + weekTime >= purchaseTime && purchaseTime >= formalizeTime);
            assertNotNull(parentCategory);
        }
    }

    /**
     * [8] 1974年までに生まれた、もしくは不明の会員を検索
     * 会員ステータス名称、リマインダ質問と回答、退会理由入力テキストも取得(ログ出力)
     * 若い順だが生年月日が null のデータを最初に並べる
     * 生年月日が指定された条件に合致することをアサート
     * 1974年生まれの人が含まれていることをアサート
     * 生まれが不明の会員が先頭になっていることをアサート
     */
    public void test_08() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberSecurityAsOne();
        cb.setupSelect_MemberStatus();
        cb.setupSelect_MemberWithdrawalAsOne();
        // wara 修行++: 1974/01/01 という文字列が画面から飛んで来たと想定してみましょう by jflute
        // Arrange内での日付操作禁止。ヒント６番
        String input = "1974/01/01";
        HandyDate inputHandy = new HandyDate(input);
        final Date targetDate = new HandyDate(input).getDate();
        // 【やってみた】wara 日付操作しちゃってる。moveToYearTerminal()は無しで実現してみよう、ヒント６番 (まで検索) by jflute
        // こっちもやってみた。→動いた
        //final Date date = new HandyDate(input).addYear(1).addDay(-1).getDate();
        // 【やってみました】wara OrScopeQueryも禁止。ヒント、その前のtodoの機能 by jflute
        //        cb.orScopeQuery(new OrQuery<MemberCB>() {
        //            public void query(MemberCB orCB) {
        //                //                orCB.query().setBirthdate_LessEqual(date);
        //                //                orCB.query().setBirthdate_IsNull();
        //                orCB.query().setBirthdate_FromTo(null, targetDate, new FromToOption().compareAsYear());
        //                orCB.query().setBirthdate_IsNull();
        //            }
        //        });
        cb.query().setBirthdate_FromTo(null, targetDate, new FromToOption().compareAsYear().orIsNull());
        cb.query().addOrderBy_Birthdate_Desc().withNullsFirst();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        Date assertDate = inputHandy.moveToYearTerminal().getDate();
        Date assertFirstDate = new HandyDate(input).addDay(-1).getDate(); // e.g. 1973/12/31
        Date assertLastDate = new HandyDate(assertDate).addDay(1).getDate(); // e.g. 1975/01/01
        // 【passedBorderに変更しました】wara わかりやすい名前にリファクタリング by jflute
        boolean passedBorder = false;
        for (Member member : memberList) {
            String name = member.getMemberName();
            Date birthdate = member.getBirthdate();
            String status = member.getMemberStatus().getMemberStatusName();
            String question = member.getMemberSecurityAsOne().getReminderQuestion();
            MemberWithdrawal withdrawal = member.getMemberWithdrawalAsOne();
            log(birthdate, name, status, question);
            if (withdrawal != null) {
                String inputText = member.getMemberWithdrawalAsOne().getWithdrawalReasonInputText();
                log("************:" + inputText);
            }
            if (birthdate != null) {
                passedBorder = true;
                assertTrue(birthdate.before(assertDate) || birthdate.equals(assertDate));
                if (birthdate.before(assertLastDate) && birthdate.after(assertFirstDate)) {
                    int assertBirthYear = new HandyDate(birthdate).getYear();
                    assertTrue(assertBirthYear == inputHandy.getYear());
                }
            } else {
                assertFalse(passedBorder);
            }
        }
    }

    /**
     * [9] 無効な条件は無視されることを確認しつつ生年月日のない会員を検索
     * 会員名称の等値条件に null を設定
     * 会員アカウントの等値条件に空文字を設定
     * 生年月日がない、という条件を設定
     * 2005年6月に正式会員になった会員は先にして、会員IDの降順で並べる
     * 会員名称や会員アカウントの条件がないことをログで確認すること
     * 検索された会員の生年月日が存在しないことをアサート
     * 2005年6月に正式会員になった会員が先に並んでいることをアサート
     */
    public void test_09() throws Exception {
        // ## Arrange ##
        // wara 修行++: 2005/06/01 だけで実現してみよう(endDate禁止)。ヒント６番 by jflute
        // 【やってみました】wara 修行+++: 日付操作、moveToMonthTerminal()は禁止で by jflute
        String input = "2005/06/01";
        Date beginDate = new HandyDate(input).getDate();
        // 思い出
        // Timestamp endDate = new HandyDate("2005/06/30").getTimestamp();
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_Equal(null);
        cb.query().setMemberAccount_Equal("");
        cb.query().setBirthdate_IsNull();
        ManualOrderBean mob = new ManualOrderBean();
        mob.when_FromTo(beginDate, beginDate, new FromToOption().compareAsMonth());
        // 思い出
        // mob.when_DateFromTo(beginDate, endDate);
        cb.query().addOrderBy_FormalizedDatetime_Asc().withManualOrder(mob);
        cb.query().addOrderBy_MemberId_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        Date assertBeginDate = new HandyDate(beginDate).addDay(-1).getDate(); // 2005/06/01
        Date assertEndDate = new HandyDate(input).moveToMonthJustAdded(1).getDate(); // 2005/07/01
        assertHasAnyElement(memberList);
        // 【結局passedBorder。統一したほうがわかりやすくなりました。。。】wara いま逆なイメージ。まあ、いい感じの名前の変更 by jflute
        boolean passedBorder = false;
        for (Member member : memberList) {
            Integer id = member.getMemberId();
            String name = member.getMemberName();
            String account = member.getMemberAccount();
            Timestamp formalizedDatetime = member.getFormalizedDatetime();
            log(formalizedDatetime, id, name, account);
            Date birthdate = member.getBirthdate();
            // 【使いましたー！】wara assertNull()を使ってみよう by jflute
            assertNull(birthdate);
            if (formalizedDatetime == null) {
                passedBorder = true;
            } else if (!(formalizedDatetime.after(assertBeginDate) && formalizedDatetime.before(assertEndDate))) {
                passedBorder = true;
            } else {
                assertFalse(passedBorder);
            }
        }
    }

    /**
     * 全ての会員をページング検索
     * 会員ステータス名称も取得
     * 会員IDの昇順で並べる
     * ページサイズは 3、ページ番号は 1 で検索すること
     * 会員ID、会員名称、会員ステータス名称をログに出力
     * SQLのログでカウント検索時と実データ検索時の違いを確認
     * 総レコード件数が会員テーブルの全件であることをアサート
     * 総ページ数が期待通りのページ数(計算で導出)であることをアサート
     * 検索結果のページサイズ、ページ番号が指定されたものであることをアサート
     * 検索結果が指定されたページサイズ分のデータだけであることをアサート
     * PageRangeを 3 にして PageNumberList を取得し、[1, 2, 3, 4]であることをアサート
     * 前のページが存在しないことをアサート
     * 次のページが存在することをアサート
     */
    public void test_paging() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().addOrderBy_MemberId_Asc();
        cb.paging(3, 1);

        // ## Act ##
        PagingResultBean<Member> memberPage = memberBhv.selectPage(cb);
        MemberCB checkTables = new MemberCB();
        int selectRecordCount = memberBhv.selectCount(checkTables);

        // ## Assert ##
        assertHasAnyElement(memberPage);
        int allRecordCount = memberPage.getAllRecordCount();
        int allPageCount = memberPage.getAllPageCount();
        int pageSize = memberPage.getPageSize();
        int pageNumber = memberPage.getCurrentPageNumber();
        boolean existPrePage = memberPage.isExistPrePage();
        boolean existNextPage = memberPage.isExistNextPage();
        boolean assertPageNumber = false;
        boolean assertRecordCount = false;
        // 【Listにしましたー！】wara 受けの型は List<Member> by jflute
        // 思い出でございまする
        // List<Member> memberList = new ArrayList<Member>();
        // 【いらないので削除しちゃいました】wara コメントアウトにはコメントを。もしくは、完全に不要なら削除 by jflute
        // 【アサート外に出しました。else文も消していいのですがログ用にひとまず残します】wara ちょっとへん by jflute
        if (selectRecordCount != allRecordCount) {
            assertRecordCount = true;
        } else {
            log(selectRecordCount, allRecordCount);
        }
        //        for (Member member : memberPage) {
        //            // 【memberPage.size()にしました】wara memberListは、サイズだけのためであれば、普通にint型の++countでOK by jflute
        //            // そもそも、memberPage.size()でOK
        //            memberList.add(member);
        //            memberListSize = memberList.size();
        //            // 【外に出しました】wara for文の中でやる必要なし by jflute
        //        }
        int memberPageSize = memberPage.size();
        if (pageNumber != 1) {
            assertPageNumber = true;
        }
        memberPage.setPageRangeSize(3);
        boolean outOfRange = false;
        List<PageNumberLink> linkList = memberPage.pageRange().buildPageNumberLinkList(
                new PageNumberLinkSetupper<PageNumberLink>() {
                    public PageNumberLink setup(int pageNumberElement, boolean current) {
                        String href = "/test/link/";
                        return new PageNumberLink().initialize(pageNumberElement, current, href);
                    }
                });
        // wara こんなかんじでも構わない by jflute
        //assertEquals(4, linkList.size());
        //assertEquals(1, linkList.get(0));
        //assertEquals(2, linkList.get(1));
        //assertEquals(3, linkList.get(2));
        //assertEquals(4, linkList.get(3));
        for (PageNumberLink link : linkList) {
            int numberElement = link.getPageNumberElement();
            // 【<= 4だと含まれるべきページまではじかれてしまう気がするのですが私の勘違いでしょうか】wara numberElement <= 4 でOK。というか、checkPageRangeという名前がわかりづらい (e.g. outOfRangeとか) by jflute
            //  -> おっとすまん、範囲外だったら印を付けるってことか。であれば、numberElement > 4 でOKOK
            if (numberElement > 4) {
                outOfRange = true;
                // 思い出
                //            } else {
                //                // wara 絶対に一ループしかしないfor文 by jflute
                //                for (int i = numberElement; i <= 4;) {
                //                    log(numberElement, i);
                //                    break;
                //                }
            }
        }
        log(assertPageNumber, outOfRange, memberPageSize, allPageCount, existPrePage, existNextPage);
        assertFalse(outOfRange);
        assertFalse(assertRecordCount);
        assertFalse(assertPageNumber);
        assertTrue(memberPageSize == 3);
        assertTrue(memberPageSize == pageSize);
        // TODO wara 今回の場合は大丈夫だけど、割り切れる場合+1しないので、割り切れてなかったら+1するってロジックを by jflute
        if (selectRecordCount % memberPageSize == 0) {
            assertTrue(allPageCount == selectRecordCount / memberPageSize);
        } else {
            assertTrue(allPageCount == selectRecordCount / memberPageSize + 1);
        }
        assertFalse(existPrePage);
        assertTrue(existNextPage);
    }

    /**
     * 会員ステータスの表示順カラムで会員を並べてカーソル検索
     * 会員ステータスの "表示順" カラムの昇順で並べる
     * 会員ステータスのデータも取得
     * その次には、会員の会員IDの降順で並べる
     * 会員ステータスが取れていることをアサート
     * 会員が会員ステータスごとに固まって並んでいることをアサート
     * 検索したデータをまるごとメモリ上に持ってはいけない
     * (要は、検索結果レコード件数と同サイズのリストや配列の作成はダメ)
     */
    public void test_cursor() throws Exception {
        // ## Arrange ##
        // TODO wara カーソル検索の小話後半どこかで by jflute
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        // 【すみません、そのとおりでございます。】wara ？？？バラバラに並べるのに試したまんまコミットしちゃったかな？ by jflute
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        cb.query().addOrderBy_MemberId_Desc();

        // ## Act ##
        // 【つけましたー】wara private付けちゃおう。ここはインスタンス変数だから by jflute
        // 【Listにしましたー】wara 受けの型はインターフェース型を習慣に。つまり、List<String> by jflute
        // finalは、statusListの中のインスタンスを差し替えることができないだけで、そのインスタンスが保持している変数は別に変更できる
        final List<String> statusList = new ArrayList<String>();
        memberBhv.selectCursor(cb, new EntityRowHandler<Member>() {
            // 【消しましたー】wara ここはインスタンス変数だから、デフォルトがfalseなので、= false なしでいいよ by jflute
            private boolean previousStatus;

            public void handle(Member entity) {
                // wara スコープ短いし、statusって短い名前にしちゃおう。というか、entity.getMemberStatus()二回やってる!? by jflute
                // 【→　for文の中のstatusとかぶってしまうので一旦保留しています。】
                // 【こっちにいれてみました。】wara 検索結果が０件のときの素通り防止を入れよう by jflute
                // wara 残念ながら素通り防止になっていないでござりまする by jflute
                // というか、でたらめな絞り込み条件とか入れて試してみたかな？(確認大事)
                assertNotNull(entity);
                MemberStatus status = entity.getMemberStatus();
                assertNotNull(status);
                String currentStatusCode = status.getMemberStatusCode();
                if (statusList.isEmpty()) {
                    statusList.add(currentStatusCode);
                } else {
                    for (String statusCode : statusList) {
                        log(statusCode, currentStatusCode);
                        if (statusCode.equals(currentStatusCode)) {
                            assertFalse(previousStatus);
                        } else if (!(statusCode.equals(currentStatusCode)) && statusList.contains(currentStatusCode)) {
                            previousStatus = true;
                        } else {
                            log("*********************" + statusList);
                            statusList.add(currentStatusCode);
                        }
                        break;
                    }
                }
            }
        });
        assertHasAnyElement(statusList);
    }
}
