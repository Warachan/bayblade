package org.dbflute.handson.logic;

import java.util.Date;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberLoginBhv;
import org.dbflute.handson.dbflute.exbhv.MemberSecurityBhv;
import org.dbflute.handson.dbflute.exbhv.MemberServiceBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberSecurity;
import org.dbflute.handson.dbflute.exentity.MemberService;
import org.seasar.dbflute.helper.HandyDate;

/**
 * @author mayuko.sakaba
 */
public class HandsOn07Logic {

    // 【直しました】 wara Logic は src/test/java じゃなくて、src/main/java by jflute
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected MemberLoginBhv memberLoginBhv;
    @Resource
    protected MemberSecurityBhv memberSecurityBhv;
    @Resource
    protected MemberServiceBhv memberServiceBhv;

    /**
     * Member insertMyselfMember()
     * 自分自身の会員を登録
     */
    public Member insertMyselfMember() {
        Date birthdate = new HandyDate("1991/07/14").getDate();
        // 共通カラムの自動設定をしたため
        //        Timestamp registerDate = new HandyDate("2014/10/01").getTimestamp();

        Member member = new Member();
        member.setMemberName("Wara Pocket");
        member.setMemberAccount("Annie");
        member.setMemberStatusCode_正式会員();
        member.setBirthdate(birthdate);
        // 共通カラムの自動設定をしたため
        //        member.setRegisterDatetime(registerDate);
        //        member.setRegisterUser("DBFlute");
        //        member.setUpdateDatetime(registerDate);
        //        member.setUpdateUser("DBflute");
        memberBhv.insert(member);

        return member;
    }

    /**
     * Member insertYourselfMember()
     * 誰かを正式会員として登録
     * 業務的に必須の関連テーブルも登録
     */
    public Member insertYourselfMember() {
        // 【ずらしました！】wara 宣言するのは必要になる直前でいいかな by jflute

        Member member = new Member();
        member.setMemberName("Cookie Tom");
        member.setMemberAccount("RikiMaru");
        member.setMemberStatusCode_正式会員();
        // 【消しちゃいました！】wara ここは、特に会員をinsertする上では全く無関係なので、やらなくていいかな by jflute
        // テストの方でも、戻り値のmemberからsecurity取ったりはしてないしね
        memberBhv.insert(member);

        MemberSecurity security = new MemberSecurity();
        Integer memberId = member.getMemberId();
        security.setLoginPassword("password");
        security.setMemberId(memberId);
        security.setReminderQuestion("What's your name?");
        security.setReminderAnswer("Nobody");
        memberSecurityBhv.insert(security);

        MemberService service = new MemberService();
        service.setMemberId(memberId);
        service.setAkirakaniOkashiiKaramuMei(8888);
        service.setServiceRankCode_Platinum();
        memberServiceBhv.insert(service);

        // wara Serviceもカージナリティ的には必須 by jflute

        return member;
    }
}
