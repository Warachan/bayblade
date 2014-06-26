package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.TweetBhv;
import jp.bizreach.twitter.dbflute.exentity.Tweet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class HomeAction {
    @ActionForm
    @Resource
    protected HomeForm homeForm;
    @Resource
    protected SessionDto sessionDto;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected TweetBhv tweetBhv;

    private static final Log LOG = LogFactory.getLog(HomeAction.class);

    @Execute(validator = false)
    public String index() {
        return "/home/twitter.jsp";
    }

    @Execute(validator = false)
    public String tweet() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        String input = homeForm.input;
        //        MemberCB cb = new MemberCB();
        //        cb.query().setMemberId_Equal(sessionDto.id);
        //        LOG.debug("***" + sessionDto.id);
        //        Member member = memberBhv.selectEntity(cb);
        Tweet tweet = new Tweet();
        tweet.setMemberId(sessionDto.id);
        tweet.setTweet(input);
        tweet.setTweetDatetime(timestamp);
        tweetBhv.insert(tweet);

        return "/home/twitter.jsp";
        // todo: tweetした瞬間のいい感じの時間を表示する。 datetimeとツィートをそろえて文字列として表示しなければならない→平分ではできない。JSONを使う。
        //        formatTime = sdf.format(date);
        //      LOG.debug(formatTime);
        //        SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
    }
}
