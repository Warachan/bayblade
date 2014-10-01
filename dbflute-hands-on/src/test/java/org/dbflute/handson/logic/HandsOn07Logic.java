package org.dbflute.handson.logic;

import java.util.Date;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberLoginBhv;
import org.dbflute.handson.dbflute.exbhv.MemberSecurityBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.MemberSecurity;
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

    /**
     * Member insertMyselfMember()
     * 自分自身の会員を登録
     */
    public Member insertMyselfMember() {
        Date birthdate = new HandyDate("1991/07/14").getDate();
        //        Timestamp registerDate = new HandyDate("2014/10/01").getTimestamp();

        Member member = new Member();
        member.setMemberName("Wara Pocket");
        member.setMemberAccount("Annie");
        member.setMemberStatusCode_正式会員();
        member.setBirthdate(birthdate);
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

        Member member = new Member();
        member.setMemberName("Cookie Tom");
        member.setMemberAccount("RikiMaru");
        member.setMemberStatusCode_正式会員();
        member.setMemberSecurityAsOne(security);
        memberBhv.insert(member);

        security.setLoginPassword("password");
        security.setMemberId(member.getMemberId());
        security.setReminderQuestion("What's your name?");
        security.setReminderAnswer("Nobody");
        memberSecurityBhv.insert(security);

        return member;
    }
}
