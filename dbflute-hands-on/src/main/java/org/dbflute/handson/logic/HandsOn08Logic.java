package org.dbflute.handson.logic;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exentity.Member;

/**
 * @author mayuko.sakaba
 */
public class HandsOn08Logic {
    @Resource
    protected MemberBhv memberBhv;

    /**
     * void updateMemberChangedToFormalized(Integer memberId, Long versionNo)
     *  指定された会員を正式会員に更新する
     *  排他制御ありで更新する
     *  引数の値で null は許されない
     */
    public void updateMemberChangedToFormalized(Integer memberId, Long versionNo) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberStatusCode_正式会員();
        member.setVersionNo(0L);
        memberBhv.update(member);
    }
}
