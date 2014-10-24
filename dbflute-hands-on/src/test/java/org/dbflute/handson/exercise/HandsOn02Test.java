package org.dbflute.handson.exercise;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberSecurity;
import org.dbflute.handson.dbflute.exentity.MemberStatus;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.cbean.ListResultBean;

/**
 * @author mayuko.sakaba
 */
public class HandsOn02Test extends UnitContainerTestCase {

    @Resource
    protected MemberBhv memberBhv;

    public void test_firstSelect() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberName_PrefixSearch("S");

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        // warachan 素通り防止、assertHasAny...() をここでも入れておきましょう by jflute
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member.getMemberName());
        }
    }

    /**
     * 会員アカウントがPで始まる会員を検索
     * 生年月日の昇順で並べる
     * 会員ステータスのステータス名称もほしい
     * 会員セキュリティのログインパスワードを並べて
     * ログに出力せよ
     * （検索結果の）会員名称がPで始まっておることをアサート
     * @throws Exception
     */
    public void test_omake() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus(); // 関連しているテーブルからカラムを取ってきて欲しい
        cb.setupSelect_MemberSecurityAsOne();

        cb.query().setMemberName_PrefixSearch("P"); // 名前絞る条件を定義している段階
        cb.query().addOrderBy_Birthdate_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            String memberName = member.getMemberName();
            MemberStatus status = member.getMemberStatus();
            MemberSecurity security = member.getMemberSecurityAsOne();
            log(memberName, status.getMemberStatusName(), security.getLoginPassword());
            assertTrue(memberName.startsWith("P"));
        }
    }

    /**
     * 会員IDが1の会員を検索
     *一件検索として検索すること
     * 会員IDが 1 であることをアサート
     */
    public void test_IDisOne() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(1);

        // ## Act ##
        Member member = memberBhv.selectEntityWithDeletedCheck(cb);
        // 必ずデータがあるのか、それともない可能性があるのか、ないことがありえるなら、ないことを想定したプログラムをかかなければならない

        // ## Assert ##
        String memberName = member.getMemberName();
        Integer memberId = member.getMemberId();
        log(memberName);
        assertTrue(memberId.equals(1));

        // こっちのほうがnullを比較するのでベター
        // 落ちたときのエラーで実際取れてしまった値を見せてくれるのでわかりやすい
        // 引数に値と実際の値を与えられているからこの情報が出せる。
        // assertTrueではbooleanでtrue/falseしかわからないので、実際の値をわかるわけがない。
        assertEquals(1, member.getMemberId());
    }

    /**
     * 生年月日がない会員を検索
     * 更新日時の降順で並べる
     * 生年月日がないことをアサート
     */
    public void test_NoBirthDate() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().setBirthdate_IsNull();
        cb.query().addOrderBy_FormalizedDatetime_Desc();

        // ## Act ##
        // warachan 【直しました】テーブル名 + List という名前を心がけよう、e.g. memberList by jflute
        // 直すときは、変数を選択して ctrl + 1 -> enter で rename できるよ
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        // assertすることを入れる。三種類。全て同じ役割だけど、一番上が望ましい。
        assertHasAnyElement(memberList);
        assertFalse(memberList.isEmpty());
        if (memberList.isEmpty()) {
            fail();
        }

        for (Member member : memberList) {
            // warachan 【直しました】変数名のポリシーがバラバラなので統一しよう by jflute
            // name -> memberName, timestamp -> formalizedDatetime
            // カラム名を意識した名前にするか、型を意識した名前にするか、ケースバイケースではあるけど、
            // ここではカラム名を意識した方がいいかな
            String memberName = member.getMemberName();
            Timestamp formalizedDatetime = member.getFormalizedDatetime();
            Date birthdate = member.getBirthdate();
            log(memberName, formalizedDatetime, birthdate);
            assertNull(birthdate);
            assertTrue(birthdate == null);
            // もしこのデータが必ず生年月日が全員にあるとどうなる？
            // 空リストを帰ってくる
            // →空リストが帰ってきた場合、素通りになる
        }
    }
}
