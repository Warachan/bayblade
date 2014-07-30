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
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.ManualOrderBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.coption.ColumnConversionOption;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
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
        //cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        cb.query().addOrderBy_MemberId_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
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
            // TODO mayuko.sakaba assert が不完全。
            if (statusCode.equals("FML")) {
                count++;
            } else if (statusCode.equals("WDL")) {
                count2++;
            } else if (statusCode.equals("PRV")) {
                count3++;
            }
            log(memberName, memberId, statusCode);
            // TODO mayuko.sakaba statusごとに固まっていることをアサート →　コレでアサーとできているのか微妙なところ。もう少し効率の良いやりかたを探せないか。。。
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
        cb.specify().specifyMemberStatus().columnMemberStatusName();
        cb.query().setFormalizedDatetime_DateFromTo(beginDate, endDate);
        cb.query().setMemberName_LikeSearch("vi", new LikeSearchOption().likeContain());

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        for (Member member : memberList) {
            String name = member.getMemberName();
            Timestamp datetime = member.getFormalizedDatetime();
            MemberStatus status = member.getMemberStatus();
            assertContains(name, "vi");
            assertTrue(status.getDescription() == null && status.getDisplayOrder() == null);
            Date assertBeginDate = new HandyDate("2005/09/30").getDate();
            Date assertEndDate = new HandyDate("2005/10/04").getDate();
            assertTrue(datetime.after(assertBeginDate) && datetime.before(assertEndDate));
            log(name, datetime, status);
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
        adjustPurchase_PurchaseDatetime_fromFormalizedDatetimeInWeek();
        cb.setupSelect_Member().withMemberSecurityAsOne();
        cb.setupSelect_Member().withMemberStatus();
        cb.setupSelect_Product().withProductCategory().withProductCategorySelf();
        cb.setupSelect_Product().withProductStatus();
        cb.columnQuery(new SpecifyQuery<PurchaseCB>() {

            @Override
            public void specify(PurchaseCB cb) {
                cb.specify().columnPurchaseDatetime();
            }
        }).lessEqual(new SpecifyQuery<PurchaseCB>() {

            @Override
            public void specify(PurchaseCB cb) {
                cb.specify().columnRegisterDatetime();
            }
        }).convert(new ColumnConversionOption().addDay(7));
        cb.query().queryProduct().addOrderBy_ProductCategoryCode_Desc();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        for (Purchase purchase : purchaseList) {
            Product product = purchase.getProduct();
            ProductStatus productStatus = purchase.getProduct().getProductStatus();
            ProductCategory category = purchase.getProduct().getProductCategory();
            ProductCategory parentCategory = category.getProductCategorySelf();
            MemberSecurity security = purchase.getMember().getMemberSecurityAsOne();
            MemberStatus memberStatus = purchase.getMember().getMemberStatus();
            Timestamp registerDatetime = purchase.getRegisterDatetime();
            Timestamp purchaseDatetime = purchase.getPurchaseDatetime();
            long registerTime = registerDatetime.getTime();
            long purchaseTime = purchaseDatetime.getTime();
            long weekTime = 1000 * 60 * 60 * 24 * 7;
            assertTrue(purchaseTime + weekTime <= registerTime);
            // TODO mayuko.sakaba アサートがまだできていない。
            log(product, productStatus, category, security, memberStatus, registerDatetime, parentCategory);
            // TODO mayuko.sakaba 米印以降がまだできていない。
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
        final Date date = new HandyDate("1974/12/31").getDate();
        cb.orScopeQuery(new OrQuery<MemberCB>() {

            @Override
            public void query(MemberCB orCB) {
                orCB.query().setBirthdate_LessEqual(date);
                orCB.query().setBirthdate_IsNull();
            }
        });
        cb.query().addOrderBy_Birthdate_Asc().withNullsFirst();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        for (Member member : memberList) {
            String name = member.getMemberName();
            Date birthdate = member.getBirthdate();
            String status = member.getMemberStatus().getMemberStatusName();
            String question = member.getMemberSecurityAsOne().getReminderQuestion();
            MemberWithdrawal withdrawal = member.getMemberWithdrawalAsOne();
            if (withdrawal != null) {
                String inputText = member.getMemberWithdrawalAsOne().getWithdrawalReasonInputText();
                log("************:" + inputText);
            }
            if (birthdate != null) {
                assertTrue(birthdate.before(date) || birthdate.equals(date));
            } else {
                assertTrue(birthdate == null);
            }
            log(birthdate, name, status, question);
            // TODO mayuko.sakaba 最後のアサート二つがまだできていない。
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
        Timestamp beginDate = new HandyDate("2005/06/01").getTimestamp();
        Timestamp endDate = new HandyDate("2005/06/30").getTimestamp();
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_Equal(null);
        cb.query().setMemberAccount_Equal("");
        cb.query().setBirthdate_IsNull();
        ManualOrderBean mob = new ManualOrderBean();
        mob.when_DateFromTo(beginDate, endDate);
        cb.query().addOrderBy_MemberId_Desc().withManualOrder(mob);

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        for (Member member : memberList) {
            String name = member.getMemberName();
            String account = member.getMemberAccount();
            log(name, account);
            Date birthdate = member.getBirthdate();
            assertTrue(birthdate == null);
            // TODO mayuko.sakaba 先に並んでいるアサートを考える。
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
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        for (Member member : memberList) {
            Integer memberId = member.getMemberId();
            String memberName = member.getMemberName();
            String statusName = member.getMemberStatus().getMemberStatusName();
            log(memberId, memberName, statusName);

        }
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
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        cb.query().addOrderBy_MemberId_Desc();
        cb.addOrderBy_PK_Desc();
        // ## Act ##

        // ## Assert ##
    }
}
