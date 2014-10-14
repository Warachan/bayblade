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
        MemberSecurity security = new MemberSecurity();
        MemberService service = new MemberService();

        Member member = new Member();
        member.setMemberName("Cookie Tom");
        member.setMemberAccount("RikiMaru");
        member.setMemberStatusCode_正式会員();
        member.setMemberSecurityAsOne(security);
        member.setMemberServiceAsOne(service);
        memberBhv.insert(member);

        Integer memberId = member.getMemberId();
        security.setLoginPassword("password");
        security.setMemberId(memberId);
        security.setReminderQuestion("What's your name?");
        security.setReminderAnswer("Nobody");
        memberSecurityBhv.insert(security);

        service.setMemberId(memberId);
        service.setAkirakaniOkashiiKaramuMei(8888);
        service.setServiceRankCode_Platinum();
        memberServiceBhv.insert(service);

        // TODO wara Serviceもカージナリティ的には必須 by jflute

        return member;
    }
}
