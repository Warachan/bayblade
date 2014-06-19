package org.dbflute.handson.exercise;

import java.util.Date;

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
import org.dbflute.handson.dbflute.exentity.Purchase;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.cbean.ListResultBean;
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
     * [1] 会員名称がSで始まる1968年1月1日以前に生まれた会員を検索
     * 会員ステータスも取得する
     * 生年月日の昇順で並べる
     * 会員が1968/01/01以前であることをアサート
     * 「以前」の解釈は日付によってしっかり確認すること
     * @throws Exception
     */
    public void test_secssion3_first() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        Date date = new HandyDate("1968/1/1").getDate();
        cb.setupSelect_MemberStatus();
        cb.query().setMemberName_PrefixSearch("S");
        cb.query().setBirthdate_LessEqual(date);
        cb.query().addOrderBy_Birthdate_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        for (Member member : memberList) {
            MemberStatus status = member.getMemberStatus();
            Date birthdate = member.getBirthdate();
            log(status, birthdate);
            // Q.コレだとdateを変えるとそのまま適応されてしまうのでは？
            assertTrue(birthdate.before(date) || birthdate.equals(date));
            // そのほかのやり方
            assertFalse(birthdate.after(date)); //コレだと含まない選択肢があっても、未来ではない、といっているのだから以前を考えなくていい。
            assertTrue(birthdate.compareTo(date) <= 0); // このメソッドはintegerを返してくる
            assertTrue(birthdate.getTime() <= date.getTime()); //  日付も数値的に内部で表現されているからこそ
            assertTrue(new HandyDate(birthdate).isLessEqual(date));
        }
    }

    /**[2] 会員ステータスと会員セキュリティ情報も取得して会員を検索
     * 若い順で並べる。生年月日がない人は会員IDの昇順で並ぶようにする
     * 会員ステータスと会員セキュリティ情報が存在することをアサート
     */
    public void test_secssion3_second() throws Exception {
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
            String status = member.getMemberStatus().getMemberStatusName();
            String security = member.getMemberSecurityAsOne().getRegisterUser();
            Date birthdate = member.getBirthdate();
            assertFalse(status == null && security == null);
            assertNotNull(status, security);
            // statusがなぜ必ずデータが存在するといえるか。→notNull制約・FK制約のカラムだから必すsetupSelectが存在するといえる。many to oneなので、物理的制約がある。
            // securityがなぜ必ずデータがあるといえるかカージナリティ的に"1対必ず1"だから（黒ぽちがある）必ず存在するといえる。（物理制約はない）
            // 論理的制約、論理的には制約があるけど、実際、物理的にそうとは限らない。業務制約ともいう。
            // * null が存在しうる制約をnullableと呼ぶ。
            // 必ず存在するかどうかについて、テーブルのschemaを読むのもあり。（そのテーブルが信用できるものなら）
            log(status, security, birthdate);
        }
    }

    /**
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

        // ## Assert ##
        assertHasAnyElement(memberList);
        // 四苦八苦。これでは意味ない・・・
        // MemberSecurityCB securityCB = new MemberSecurityCB();
        // securityCB.query().setReminderQuestion_LikeSearch("2", new LikeSearchOption().likeContain());
        // ListResultBean<MemberSecurity> security = memberSecurityBhv.selectList(securityCB);
        // log(member.getMemberName());
        // assertTrue(question.contains("2"));

        for (Member member : memberList) {
            MemberSecurityCB securityCB = new MemberSecurityCB();
            securityCB.query().setMemberId_Equal(member.getMemberId());
            MemberSecurity security = memberSecurityBhv.selectEntityWithDeletedCheck(securityCB);
            String question = security.getReminderQuestion();
            log(member.getMemberName(), question);
            assertTrue(question.contains("2"));
            // TODO mayuko.sakaba  SQLの発行回数を一回にしてみる。

            //　【思い出 setupSelectをしてないからできない。】
            // String question = member.getMemberSecurityAsOne().getReminderQuestion();
            // 【思い出2 あれこれやってみた。】
            // MemberSecurity security = member.getMemberSecurityAsOne();
            // boolean result = security.getReminderQuestion().contains("2");
            // log(result);

        }
    }

    // 【思い出 memberSecurityテーブルのデータを丸々持ってきてしまった。】
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
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        cb.query().addOrderBy_MemberId_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        for (Member member : memberList) {
            String name = member.getMemberName();
            Integer memberId = member.getMemberId();
            MemberStatus status = member.getMemberStatus();
            assertNull(status);
            log(name, memberId);
            // TODO mayuko.sakaba statusごとに固まって並べる
        }
    }

    /**
     *
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
        cb.setupSelect_Member().withMemberStatus(); // memberStatus
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
            String statusName = purchase.getMember().getMemberStatus().getMemberStatusName();
            String name = purchase.getMember().getMemberName();
            Date birthdate = purchase.getMember().getBirthdate();
            assertNotNull(birthdate);
            log(price, statusName, name, birthdate);
            // TODO mayuko.sakaba ログに普通に出力されているだけだけどいいのか？
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
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();

        // ## Act ##

        // ## Assert ##
    }

}
