package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.cbean.TweetCB;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.TweetBhv;
import jp.bizreach.twitter.dbflute.exentity.Member;
import jp.bizreach.twitter.dbflute.exentity.Tweet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */
public class HomeAction {
    private static final Log LOG = LogFactory.getLog(HomeAction.class);

    @ActionForm
    @Resource
    protected HomeForm homeForm;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected TweetBhv tweetBhv;
    @Resource
    public SessionDto sessionDto; //　TODO こんにちはidさんを消した後、protectedになおす

    public ArrayList<Object> timeLine = new ArrayList<>();
    public ArrayList<String> followList = new ArrayList<String>();
    public String toFollowMember;

    // TODO mayuko.sakaba ask head フォローリストを表示させるとタイムラインが消える。
    // TODO mayuko.sakaba プロフィール文、写真登録がまだできていないですよー！
    // TODO mayuko.sakaba フォローしている人のツィート
    // TODO mayuko.sakaba いい感じにツィート時間を表示する。 →JSONを使う？

    @Execute(validator = false)
    /* ツィートタイムラインを表示　*/
    public String index() {
        TweetCB tweetCb = new TweetCB();
        tweetCb.query().setMemberId_Equal(sessionDto.myId);
        tweetCb.query().addOrderBy_TweetId_Desc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(tweetCb);
        LOG.debug("***" + tweetList);
        for (Tweet tweet : tweetList) {
            String inputTweet = tweet.getTweet();
            timeLine.add(inputTweet);
            LOG.debug("***" + timeLine);
        }
        return "/twitter/home.jsp";
    }

    @Execute(validator = false)
    /* ツィートと、ツィート時間を新しく追加 */
    public String tweet() {
        Date date = new Date();
        Timestamp tweetTime = new Timestamp(date.getTime());
        String input = homeForm.inputTweet;
        Tweet tweet = new Tweet();
        tweet.setMemberId(sessionDto.myId);
        tweet.setTweet(input);
        tweet.setTweetDatetime(tweetTime);
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
            followList.add(userName);
            LOG.debug("***" + toFollowMember);
        }
        return "/twitter/home.jsp";
    }
    // TODO mayuko.sakaba <-- s:formどのタイミングで分けたらいいのか -->??
    /* 自分のプロフィールページに行く*/
    //    @Execute(validator = false)
    //    public String gotoYourpage() {
    //        return "/profile/?redirect=true";
    //    }

}
