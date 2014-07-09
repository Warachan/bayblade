package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.FollowCB;
import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.cbean.TweetCB;
import jp.bizreach.twitter.dbflute.exbhv.FollowBhv;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.TweetBhv;
import jp.bizreach.twitter.dbflute.exentity.Follow;
import jp.bizreach.twitter.dbflute.exentity.Member;
import jp.bizreach.twitter.dbflute.exentity.Tweet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class MemberAction {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(MemberAction.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected MemberForm memberForm;
    @Resource
    protected SessionDto sessionDto;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected TweetBhv tweetBhv;
    @Resource
    protected FollowBhv followBhv;

    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public ArrayList<TweetDto> timeLine = new ArrayList<>();
    public ArrayList<MemberDto> followMemberList = new ArrayList<>();
    public ArrayList<MemberDto> followerMemberList = new ArrayList<>();
    public String noFollow;
    public String noFollower;
    public String account;
    public String groupName;
    public Integer graduationYear;
    public String profile;
    public Integer status;
    public String interestedIndustry;
    public Integer recruitingNumber;
    public String relationship;
    public boolean followStatus;
    public boolean recruitStatus;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======

    @Execute(validator = false, urlPattern = "{yourName}")
    public String index() {
        /*　アカウント名を表示する */
        MemberCB memberCb = new MemberCB();
        LOG.debug("nameCheck:" + memberForm.yourName);
        memberCb.query().setUserName_Equal(memberForm.yourName);
        Member member = memberBhv.selectEntity(memberCb);
        status = member.getMemberStatusCode();
        profile = member.getProfile();
        groupName = member.getGroupName();
        interestedIndustry = member.getInterestedIndustry();
        recruitingNumber = member.getRecruitingNumber();
        graduationYear = member.getGraduationYear();
        LOG.debug("*******************************************************************************");
        if (status.equals(1)) {
            recruitStatus = new Boolean(true);
        } else if (status.equals(2)) {
            recruitStatus = new Boolean(false);
        }
        account = (member.getAccountName() + "@" + member.getUserName());
        /* ツィートタイムラインを表示　*/
        TweetCB tweetCb = new TweetCB();
        tweetCb.setupSelect_Member();
        tweetCb.query().setMemberId_Equal(member.getMemberId());
        tweetCb.query().addOrderBy_MemberId_Desc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(tweetCb);
        for (Tweet tweet : tweetList) {
            TweetDto tweetDto = new TweetDto();
            tweetDto.accountName = tweet.getMember().getAccountName();
            tweetDto.username = tweet.getMember().getUserName();
            tweetDto.tweet = tweet.getTweet();
            tweetDto.tweetTime = tweet.getTweetDatetime();
            timeLine.add(tweetDto);
        }
        /* フォローできる相手か判断する */
        FollowCB followCb = new FollowCB();
        followCb.query().setMemberId_Equal(sessionDto.myId);
        followCb.query().setYouId_Equal(member.getMemberId());
        Follow follow = followBhv.selectEntity(followCb);
        if (follow == null) {
            followStatus = new Boolean(true);
        } else if (follow.getDelFlg().equals("Y")) {
            followStatus = new Boolean(true);
        } else {
            followStatus = new Boolean(false);
            relationship = "Following";
        }
        return "/twitter/member.jsp";
    }

    /* このアカウントの会員をフォロー　*/
    @Execute(validator = false, urlPattern = "{yourName}/follow")
    public String follow() {
        /* 自分をフォローしない制約 */
        Member member = selectMember();
        Integer memberId = member.getMemberId();
        if (memberId.equals(sessionDto.myId)) {
            return "/home/?redirect=true";
        }
        /* フォローしたことのない相手を新しくフォローする */
        FollowCB followCb = new FollowCB();
        followCb.query().setYouId_Equal(member.getMemberId());
        followCb.query().setMemberId_Equal(sessionDto.myId);
        Follow selectFollow = followBhv.selectEntity(followCb);
        Follow follow = new Follow();
        if (selectFollow == null) {
            Date date = new Date();
            Timestamp tweetTime = new Timestamp(date.getTime());
            LOG.debug("***" + memberForm.yourName);
            follow.setMemberId(sessionDto.myId);
            follow.setYouId(member.getMemberId());
            follow.setInsDatetime(tweetTime);
            follow.setUpdDatetime(tweetTime);
            follow.setInsTrace("following");
            follow.setUpdTrace("following");
            LOG.debug("***" + member.getMemberId());
            followBhv.insert(follow);
        } else {
            /* フォローしたことのある相手なら削除フラグをNにする */
            Integer followId = selectFollow.getFollowId();
            follow.setFollowId(followId);
            follow.setDelFlg("N");
            followBhv.update(follow);
        }
        //        if (selectFollow.getYouId().equals(selectFollow.getMemberId())) {
        //            return "/home/?redirect=true";
        //        }
        return "/member/" + memberForm.yourName + "/?redirect=true";
    }

    /* このアカウント保有者をアンフォロー */
    @Execute(validator = false, urlPattern = "{yourName}/unfollow")
    public String unfollow() {
        /* アカウント保有者のメンバーID検索 */
        Member member = selectMember();
        FollowCB followCb = new FollowCB();
        followCb.query().setYouId_Equal(member.getMemberId());
        followCb.query().setMemberId_Equal(sessionDto.myId);
        Follow selectFollow = followBhv.selectEntity(followCb);
        Integer followId = selectFollow.getFollowId();
        LOG.debug(followId);
        Follow follow = new Follow();
        follow.setFollowId(followId);
        follow.setYouId(member.getMemberId());
        follow.setDelFlg("Y");
        followBhv.update(follow);
        return "/member/" + memberForm.yourName + "/?redirect=true";
    }

    /* このアカウントのフォロー・フォロワーの一覧を見る */
    @Execute(validator = false, urlPattern = "{yourName}/followingMember")
    public String followingMember() {
        Member member = selectMember();
        FollowCB followCB = new FollowCB();
        followCB.setupSelect_MemberByYouId();
        followCB.query().setMemberId_Equal(member.getMemberId());
        followCB.query().setDelFlg_Equal("N");
        ListResultBean<Follow> selectFollowList = followBhv.selectList(followCB);
        for (Follow follow : selectFollowList) {
            MemberDto memberDto = new MemberDto();
            memberDto.userName = follow.getMemberByYouId().getUserName();
            memberDto.accountName = follow.getMemberByYouId().getAccountName();
            memberDto.memberId = follow.getYouId();
            LOG.debug("***" + follow);
            followMemberList.add(memberDto);
        }
        FollowCB followerCB = new FollowCB();
        followerCB.setupSelect_MemberByMemberId();
        followerCB.query().setYouId_Equal(member.getMemberId());
        ListResultBean<Follow> followerList = followBhv.selectList(followerCB);
        for (Follow follow : followerList) {
            MemberDto memberDto = new MemberDto();
            memberDto.userName = follow.getMemberByMemberId().getUserName();
            memberDto.accountName = follow.getMemberByMemberId().getAccountName();
            memberDto.memberId = follow.getMemberId();
            followerMemberList.add(memberDto);
        }
        if (followMemberList.isEmpty()) {
            noFollow = "Not following yet";
        }
        if (followerMemberList.isEmpty()) {
            noFollower = "No followers yet";
        }
        return "/twitter/followlist.jsp";
    }

    private Member selectMember() {
        MemberCB cb = new MemberCB();
        cb.query().setUserName_Equal(memberForm.yourName);
        LOG.debug("seeUsername" + memberForm.yourName);
        Member member = memberBhv.selectEntity(cb);
        return member;
    }
}
