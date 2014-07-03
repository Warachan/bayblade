package jp.bizreach.twitter.app.web;

/**
 *
 * @author mayuko.sakaba
 *
 */
public class MemberDto {
    public Integer memberId;
    public String memberName;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
}
