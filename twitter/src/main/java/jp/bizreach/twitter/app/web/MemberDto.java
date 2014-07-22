package jp.bizreach.twitter.app.web;

/**
 *
 * @author mayuko.sakaba
 *
 */
public class MemberDto {
    public Integer memberId;
    public String userName;
    public String accountName;
    public String status;
    public String groupName;
    public String interestedIndustry;
    public String recruitingNumber;
    public Integer graduationNumber;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
