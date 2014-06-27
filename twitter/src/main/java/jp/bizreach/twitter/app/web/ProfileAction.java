package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

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

public class ProfileAction {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(ProfileAction.class);

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected ProfileForm profileForm;
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
    public ArrayList<Object> timeLine = new ArrayList<>();
    public String account;
    public String input;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    public String index() {
        /* セッションが会員IDを保持しているか確認　*/
        if (sessionDto.myId == null) {
            LOG.debug("***" + sessionDto.myId);
            return "/?redirect=true";
        }
        /*　アカウント名を表示する*/
        MemberCB cb = new MemberCB();
        cb.query().setUserName_Equal(sessionDto.followName);
        Member member = memberBhv.selectEntity(cb);
        sessionDto.yourId = member.getMemberId();
        LOG.debug("***" + sessionDto.followName + "+" + sessionDto.yourId);
        account = sessionDto.followName;
        /* ツィートタイムラインを表示　*/
        TweetCB tweetCb = new TweetCB();
        tweetCb.query().setMemberId_Equal(sessionDto.yourId);
        LOG.debug("***" + sessionDto.yourId);
        tweetCb.query().addOrderBy_MemberId_Desc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(tweetCb);
        for (Tweet tweet : tweetList) {
            String inputTweets = tweet.getTweet();
            timeLine.add(inputTweets);
        }
        return "/follow/profile.jsp";
    }

    /* ツィートと、ツィート時間を新しく追加 */
    // TODO mayuko.sakaba jspをあわせて製作すること。
    //    @Execute(validator = false)
    //    public String myTweet() {
    //        Date date = new Date();
    //        Timestamp timestamp = new Timestamp(date.getTime());
    //        input = profileForm.input;
    //        Tweet tweet = new Tweet();
    //        tweet.setMemberId(sessionDto.yourId);
    //        tweet.setTweet(input);
    //        tweet.setTweetDatetime(timestamp);
    //        tweetBhv.insert(tweet);
    //        return "/profile/?redirect=true";
    //    }

    /* このアカウントの会員をフォロー　*/
    // TODO mayuko.sakaba フォロー相手重複時の処理を書く。
    @Execute(validator = false)
    public String follow() {
        /* アカウント保有者のメンバーID検索 */
        Member member = selectMember();
        /* フォローテーブルに追加 */
        insertFollowingMember(member);
        return "/profile/";
    }

    private Member selectMember() {
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(sessionDto.yourId);
        LOG.debug("seeUsername" + sessionDto.followName);
        Member member = memberBhv.selectEntity(cb);
        return member;
    }

    private void insertFollowingMember(Member member) {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Follow follow = new Follow();
        follow.setMeId(sessionDto.myId);
        follow.setYouId(member.getMemberId());
        follow.setFollowDatetime(timestamp);
        LOG.debug("@@@" + member.getMemberId() + sessionDto.myId);
        followBhv.insert(follow);
    }
}
