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
    public ArrayList<Object> timeLine = new ArrayList<>();
    public String account;
    public String input;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======

    // TODO mayuko.sakaba フォロー相手重複時の処理を書く。
    // TODO mayuko.sakaba 自分をフォローできないようにする。

    @Execute(validator = false, urlPattern = "{yourName}")
    public String index() {
        /*　アカウント名を表示する*/
        // TODO mayuko.sakaba  このアカウントのユーザーのプロフィールを表示できるようにする。
        MemberCB cb = new MemberCB();
        cb.query().setUserName_Equal(memberForm.yourName);
        Member member = memberBhv.selectEntity(cb);
        sessionDto.yourId = member.getMemberId();
        LOG.debug("***" + memberForm.yourName + "+" + sessionDto.yourId);
        account = memberForm.yourName;
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
        return "/twitter/member.jsp";
    }

    /* このアカウントの会員をフォロー　*/
    @Execute(validator = false, urlPattern = "{yourName}/follow")
    public String follow() {
        /* アカウント保有者のメンバーID検索 */
        Member member = selectMember();
        /* フォローテーブルに追加 */
        insertFollowingMember(member);
        return "/member/" + memberForm.yourName + "/?redirect=true";
    }

    private Member selectMember() {
        MemberCB cb = new MemberCB();
        cb.query().setUserName_Equal(memberForm.yourName);
        LOG.debug("seeUsername" + memberForm.yourName);
        Member member = memberBhv.selectEntity(cb);
        return member;
    }

    private void insertFollowingMember(Member member) {
        Date date = new Date();
        Timestamp tweetTime = new Timestamp(date.getTime());
        LOG.debug("***" + memberForm.yourName);
        //        FollowCB cb = new FollowCB();
        //        cb.query().setFollowId_Equal(sessionDto.myId);
        //        cb.query().setFollowId_Equal(sessionDto.yourId);
        //        Follow follow = followBhv.selectEntity(cb);
        //        if (follow == null) {
        Follow insertFollow = new Follow();
        insertFollow.setMeId(sessionDto.myId);
        insertFollow.setYouId(member.getMemberId());
        insertFollow.setFollowDatetime(tweetTime);
        LOG.debug("***" + member.getMemberId() + sessionDto.myId);
        followBhv.insert(insertFollow);
        //        }
    }
}
