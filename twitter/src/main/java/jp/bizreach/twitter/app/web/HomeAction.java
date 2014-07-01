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
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */
public class HomeAction {
    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(HomeAction.class);

    private static final int OrQuery = 0;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected HomeForm homeForm;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected TweetBhv tweetBhv;
    @Resource
    protected FollowBhv followBhv;
    @Resource
    protected SessionDto sessionDto;
    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public ArrayList<Object> timeLine = new ArrayList<>();
    public ArrayList<Integer> followList = new ArrayList<Integer>();
    public ArrayList<String> candidateList = new ArrayList<String>();
    public ArrayList<Integer> monthList = new ArrayList<Integer>();
    public String toFollowMember;
    public String profile;
    public String birthday;
    public Integer birthYear;
    public Integer birthMonth;
    public Integer birthDate;
    public String account;

    // TODO mayuko.sakaba 他の会員検索を別のactionクラスに分ける
    // TODO mayuko.sakaba 写真登録がまだできていないですよー！
    // TODO mayuko.sakaba いい感じにツィート時間を表示する。 →JSONを使う？

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    public String index() {
        account = sessionDto.username;
        /*  フォローしているを検索　*/
        selectFollowList();
        /* ツィートタイムラインを表示　*/
        showTimeline();
        return "/twitter/home.jsp";
    }

    private void selectFollowList() {
        FollowCB followCB = new FollowCB();
        followCB.query().setMemberId_Equal(sessionDto.myId);
        ListResultBean<Follow> selectFollowList = followBhv.selectList(followCB);
        for (Follow follow : selectFollowList) {
            Integer follower = follow.getYouId();
            LOG.debug("***" + follower);
            followList.add(follower);
        }
    }

    private void showTimeline() {
        TweetCB tweetCB = new TweetCB();
        tweetCB.orScopeQuery(new OrQuery<TweetCB>() {
            @Override
            public void query(TweetCB orCB) {
                orCB.query().setMemberId_Equal(sessionDto.myId);
                orCB.query().setMemberId_InScope(followList);
            }
        });
        LOG.debug("**@" + followList);
        LOG.debug("*@@" + tweetCB.toDisplaySql());
        tweetCB.query().addOrderBy_TweetId_Desc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(tweetCB);
        LOG.debug("***" + tweetList);
        for (Tweet tweet : tweetList) {
            String inputTweet = tweet.getTweet();
            timeLine.add(inputTweet);
            LOG.debug("***" + timeLine);
        }
    }

    //    @Execute(validator = false)
    //    /*　誕生日登録　*/
    //    public String setBirthday() {
    //        for (int i = 1; i <= 12; i++) {
    //            monthList.add(i);
    //            LOG.debug("***" + i);
    //        }
    //        Integer birthMonth = monthList.get(homeForm.birthMonth);
    //        return "/twitter/home.jsp";
    //        String birthday = homeForm.birthday;
    //        if (birthday != null) {
    //            Member member = new Member();
    //            LOG.debug("***" + birthday);
    //            HandyDate inputDate = new HandyDate(birthday);
    //            Date editDate = inputDate.getDate();
    //            member.setMemberId(sessionDto.myId);
    //            member.setBirthdate(editDate);
    //            memberBhv.update(member);
    //            return "/twitter/home.jsp";
    //        } else {
    //            return "home/?redirect=true";
    //        }
    //    }

    @Execute(validator = true, input = "/twitter/home.jsp")
    /*　プロフィール登録　*/
    public String editProfile() {
        profile = homeForm.profile;
        if (profile != null) {
            MemberCB cb = new MemberCB();
            cb.query().setMemberId_Equal(sessionDto.myId);
            Member member = new Member();
            member.setProfile(profile);
            memberBhv.insert(member);
            return "/twitter/home.jsp";
        } else {
            return "/home/?redirect=true";
        }
    }

    @Execute(validator = false)
    /* ツィートと、ツィート時間を新しく追加 */
    public String tweet() {
        Date date = new Date();
        Timestamp tweetTime = new Timestamp(date.getTime());
        String inputTweet = homeForm.inputTweet;
        Tweet tweet = new Tweet();
        tweet.setMemberId(sessionDto.myId);
        tweet.setTweet(inputTweet);
        tweet.setInsDatetime(tweetTime);
        tweet.setInsTrace(inputTweet);
        tweet.setUpdDatetime(tweetTime);
        tweet.setUpdTrace(inputTweet);
        tweetBhv.insert(tweet);
        return "/home/?redirect = true";
        // todo: tweetした瞬間のいい感じの時間を表示する。 datetimeとツィートをそろえて文字列として表示しなければならない→平分ではできない。JSONを使う。
        //        formatTime = sdf.format(date);
        //        LOG.debug(formatTime);
        //        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    }

    @Execute(validator = false)
    /* フォロー候補者検索　*/
    public String search() {
        MemberCB cb = new MemberCB();
        cb.query().setUserName_LikeSearch(homeForm.searchName, new LikeSearchOption().likeContain());
        cb.query().addOrderBy_MemberId_Asc();
        LOG.debug("***" + homeForm.searchName);
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        for (Member member : memberList) {
            toFollowMember = member.getUserName();
            String userName = member.getUserName();
            candidateList.add(userName);
            LOG.debug("***" + toFollowMember);
        }
        return "/twitter/home.jsp";
    }
}
