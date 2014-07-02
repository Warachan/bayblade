package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
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
    public ArrayList<TweetDto> timeLine = new ArrayList<TweetDto>();
    public ArrayList<String> followSuggestions = new ArrayList<>();
    public ArrayList<Integer> followIdList = new ArrayList<Integer>();
    public ArrayList<String> followMemberList = new ArrayList<>();
    public ArrayList<TweetDto> resultList = new ArrayList<TweetDto>();
    public ArrayList<String> candidateList = new ArrayList<String>();
    public String nameResult;
    public String tweetResult;
    public String profile;
    public String noMatchUsers;
    public String noMatchTweets;

    // 【時間があればtodo】
    // TODO mayuko.sakaba 他の会員検索を別のactionクラスに分ける
    // TODO mayuko.sakaba 誕生日登録がまだですよー！
    // TODO mayuko.sakaba MM,ddとすると、月や日付が一桁のときに0始まりで表示されてしまう。(→JSONを使う？、そもそも表示する必要があるのか？)

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    public String index() {
        /* フォローしている相手を検索　*/
        selectFollowList();
        /* フォローする候補者を自動で表示 */
        //        MemberCB memberCB = new MemberCB();
        //        memberCB.columnQuery(new SpecifyQuery<MemberCB>() {
        //
        //            @Override
        //            public void specify(MemberCB cb) {
        //                cb.specify().columnMemberId();
        //
        //            }
        //        }).notEqual(new SpecifyQuery<MemberCB>() {
        //
        //            @Override
        //            public void specify(MemberCB cb) {
        //                //                cb.setupSelect_FollowByYouIdAsOne();
        //                cb.specify().columnMemberId();
        //
        //            }
        //        });
        // TODO mayuko.sakaba miloseだけ省かれている？
        // TODO mayuko.sakaba page検索ができていない。
        MemberCB memberCB = new MemberCB();
        memberCB.setupSelect_FollowByYouIdAsOne();
        memberCB.orScopeQuery(new OrQuery<MemberCB>() {
            @Override
            public void query(MemberCB orCB) {
                orCB.query().setMemberId_NotEqual(sessionDto.myId);
                orCB.query().setMemberId_NotInScope(followIdList);
            }
        });
        //        memberCB.query().setMemberId_NotEqual(sessionDto.myId);
        //        memberCB.query().setMemberId_NotInScope(followIdList);
        ListResultBean<Member> memberList = memberBhv.selectList(memberCB);
        for (Member member : memberList) {
            String userName = member.getUserName();
            followSuggestions.add(userName);
        }
        //        FollowCB followCB = new FollowCB();
        //        followCB.setupSelect_MemberByMemberId();
        //        followCB.query().setMemberId_NotEqual(sessionDto.myId);
        //        followCB.query().addOrderBy_FollowId_Asc();
        //        //followCB.query().set;
        //        ListResultBean<Follow> followList = followBhv.selectList(followCB);
        //        LOG.debug("**@" + followList.size());
        //        for (Follow follow : followList) {
        //            String toFollowMember = follow.getMemberByMemberId().getUserName();
        //            followSuggestions.add(toFollowMember);
        //        }
        /* ツィートタイムラインを表示　*/
        showTimeline();
        return "/twitter/home.jsp";
    }

    private void selectFollowList() {
        FollowCB followCB = new FollowCB();
        followCB.query().setMemberId_Equal(sessionDto.myId);
        ListResultBean<Follow> selectFollowList = followBhv.selectList(followCB);
        for (Follow follow : selectFollowList) {
            Integer followId = follow.getYouId();
            LOG.debug("***" + follow);
            followIdList.add(followId);
        }
    }

    private void showTimeline() {
        TweetCB tweetCB = new TweetCB();
        tweetCB.setupSelect_Member();
        tweetCB.orScopeQuery(new OrQuery<TweetCB>() {
            @Override
            public void query(TweetCB orCB) {
                orCB.query().setMemberId_Equal(sessionDto.myId);
                orCB.query().setMemberId_InScope(followIdList);
            }
        });
        LOG.debug("***" + followIdList);
        LOG.debug("***" + tweetCB.toDisplaySql());
        tweetCB.query().addOrderBy_TweetId_Desc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(tweetCB);
        LOG.debug("***" + tweetList);
        for (Tweet tweet : tweetList) {
            TweetDto tweetDto = new TweetDto();
            tweetDto.memberName = tweet.getMember().getUserName();
            tweetDto.tweetTime = tweet.getTweetDatetime();
            tweetDto.tweet = tweet.getTweet();
            timeLine.add(tweetDto);
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
    /* フォロー・フォロワー一覧を出す */
    @Execute(validator = false)
    public String goFollow() {
        return "/followList/?redirect=true";
    }

    @Execute(validator = false)
    /*　プロフィール登録　*/
    // TODO mayuko.sakaba ここでプロフィール登録するのはなく、別の設定ページを作る
    public String editProfile() {
        profile = homeForm.profile;
        if (profile != null) {
            Member member = new Member();
            member.setMemberId(sessionDto.myId);
            member.setProfile(profile);
            memberBhv.update(member);
            return "/home/?redirect=true";
        } else {
            return "/home/?redirect=true";
        }
    }

    @Execute(validator = false)
    /* ツィートと、ツィート時間を新しく追加 */
    public String tweet() {
        Date date = new Date();
        Timestamp tweetTime = new Timestamp(date.getTime());
        String formatTweetTime = new SimpleDateFormat("MM月dd日 HH時mm分").format(tweetTime);
        LOG.debug("**@" + formatTweetTime);
        String inputTweet = homeForm.inputTweet;
        Tweet tweet = new Tweet();
        tweet.setMemberId(sessionDto.myId);
        tweet.setTweet(inputTweet);
        tweet.setTweetDatetime(formatTweetTime);
        tweet.setInsDatetime(tweetTime);
        tweet.setInsTrace(inputTweet);
        tweet.setUpdDatetime(tweetTime);
        tweet.setUpdTrace(inputTweet);
        tweetBhv.insert(tweet);
        return "/home/?redirect = true";
    }

    @Execute(validator = false)
    public String search() {
        /* 検索ワードが含まれるユーザー名を検索　*/
        MemberCB memberCB = new MemberCB();
        memberCB.query().setUserName_LikeSearch(homeForm.searchWord, new LikeSearchOption().likeContain());
        memberCB.query().setMemberId_NotEqual(sessionDto.myId);
        memberCB.query().addOrderBy_MemberId_Asc();
        LOG.debug("***" + homeForm.searchWord);
        ListResultBean<Member> memberList = memberBhv.selectList(memberCB);
        for (Member member : memberList) {
            LOG.debug("***" + sessionDto.myId + "," + member.getMemberId());
            nameResult = member.getUserName();
            String userName = member.getUserName();
            candidateList.add(userName);
            LOG.debug("***" + nameResult);
        }
        /* 検索ワードが含まれるツィートを検索 */
        TweetCB tweetCB = new TweetCB();
        tweetCB.setupSelect_Member();
        tweetCB.query().setTweet_LikeSearch(homeForm.searchWord, new LikeSearchOption().likeContain());
        tweetCB.query().setMemberId_NotEqual(sessionDto.myId);
        tweetCB.query().addOrderBy_TweetId_Asc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(tweetCB);
        for (Tweet tweet : tweetList) {
            LOG.debug("***" + sessionDto.myId);
            TweetDto tweetDto = new TweetDto();
            tweetDto.tweet = tweet.getTweet();
            tweetDto.memberName = tweet.getMember().getUserName();
            tweetDto.tweetTime = tweet.getTweetDatetime();
            resultList.add(tweetDto);
        }
        /* 該当する検索結果がなかった場合の処理 */
        if (candidateList.isEmpty()) {
            noMatchUsers = "No matching users";
            LOG.debug("hit" + candidateList);
        }
        if (resultList.isEmpty()) {
            noMatchTweets = "No matching tweets";
            LOG.debug("hit2" + resultList);
        }
        return "/twitter/searchresult.jsp";
    }
}
