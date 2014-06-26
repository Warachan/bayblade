package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.TweetCB;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.TweetBhv;
import jp.bizreach.twitter.dbflute.exentity.Tweet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.dbflute.cbean.ListResultBean;
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
    public SessionDto sessionDto;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected TweetBhv tweetBhv;

    public ArrayList<Object> timeLine = new ArrayList<>();

    @Execute(validator = false)
    public String index() {
        if (sessionDto.id == null) {
            return "/?redirect = true";
        }
        TweetCB cb = new TweetCB();
        cb.query().setMemberId_Equal(sessionDto.id);
        cb.query().addOrderBy_TweetId_Desc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(cb);
        LOG.debug("***" + tweetList);
        for (Tweet tweet : tweetList) {
            String inputTweet = tweet.getTweet();
            // TODO mayuko.sakaba いい感じにツィート時間を表示する。
            //Timestamp tweetDatetime = tweet.getTweetDatetime();
            timeLine.add(inputTweet);
            LOG.debug("***" + timeLine);
        }
        return "/home/twitter.jsp";
    }

    @Execute(validator = false)
    public String tweet() {
        insertTweet();
        return "/home/?redirect = true";
        // todo: tweetした瞬間のいい感じの時間を表示する。 datetimeとツィートをそろえて文字列として表示しなければならない→平分ではできない。JSONを使う。
        //        formatTime = sdf.format(date);
        //      LOG.debug(formatTime);
        //        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    }

    private void insertTweet() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        String input = homeForm.input;
        Tweet tweet = new Tweet();
        tweet.setMemberId(sessionDto.id);
        tweet.setTweet(input);
        tweet.setTweetDatetime(timestamp);
        tweetBhv.insert(tweet);
    }
}
