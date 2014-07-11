package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.bizreach.twitter.dbflute.cbean.FollowCB;
import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.cbean.TweetCB;
import jp.bizreach.twitter.dbflute.exbhv.FollowBhv;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.MessageBhv;
import jp.bizreach.twitter.dbflute.exbhv.TweetBhv;
import jp.bizreach.twitter.dbflute.exentity.Follow;
import jp.bizreach.twitter.dbflute.exentity.Member;
import jp.bizreach.twitter.dbflute.exentity.Tweet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

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
    protected MessageBhv messageBhv;
    @Resource
    protected SessionDto sessionDto;
    @Resource
    protected HttpServletRequest request;

    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public ArrayList<TweetDto> timeLine = new ArrayList<TweetDto>();
    public ArrayList<MemberDto> followSuggestionList = new ArrayList<>();
    public ArrayList<Integer> followSuggestionId = new ArrayList<>();
    public ArrayList<Integer> followIdList = new ArrayList<Integer>();
    public ArrayList<TweetDto> resultList = new ArrayList<TweetDto>();
    public ArrayList<MemberDto> candidateList = new ArrayList<>();
    public ArrayList<MessageDto> sentMessageList = new ArrayList<>();
    public ArrayList<MessageDto> receiveMessageList = new ArrayList<>();
    public String nameResult;
    public String tweetResult;
    public Integer graduationYear;
    public Integer status;
    public String interestedIndustry;
    public String recruitingNumber;
    public String groupName;
    public String noMatchUsers;
    public String noMatchTweets;
    public String account;
    public String followed;
    public boolean recruitStatus;

    // 【要確認todo】
    // TODO mayuko.sakaba 共通カラム使っているのに、フォローステータスを更新するたびに更新されていない。

    // 【時間があればtodo】
    // TODO mayuko.sakaba 検索でcolumQueryを使うか判断する→久保さんに確認
    // TODO mayuko.sakaba MM,ddとすると、月や日付が一桁のときに0始まりで表示されてしまう。(→JSONを使う？、そもそも表示する必要があるのか？)

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    public String index() {
        /* トランザクショントークン */
        TokenProcessor.getInstance().saveToken(request);
        /* 自分の名前を表示させる（確認用）後に削除 */
        account = sessionDto.accountName + "@" + sessionDto.username;
        /*  自分のプロフィールを取得　*/
        MemberCB myCb = new MemberCB();
        myCb.setupSelect_MemberStatus();
        myCb.query().setMemberId_Equal(sessionDto.myId);
        Member me = memberBhv.selectEntity(myCb);
        status = sessionDto.status;
        groupName = me.getGroupName();
        if (status.equals(1)) {
            recruitStatus = new Boolean(true);
            interestedIndustry = me.getInterestedIndustry();
            graduationYear = me.getGraduationYear();
        } else if (status.equals(2)) {
            recruitStatus = new Boolean(false);
            recruitingNumber = me.getRecruitingNumber();
        }
        /* フォローしている相手を検索　*/
        selectFollowList();
        /* フォローする候補者を自動で表示 */
        followIdList.add(sessionDto.myId);
        MemberCB memberCb = new MemberCB();
        memberCb.query().setMemberId_NotInScope(followIdList);
        memberCb.paging(5, 1);
        ListResultBean<Member> selectList = memberBhv.selectList(memberCb);
        for (Member member : selectList) {
            MemberDto memberDto = new MemberDto();
            memberDto.memberId = member.getMemberId();
            memberDto.accountName = member.getAccountName();
            memberDto.userName = member.getUserName();
            followSuggestionList.add(memberDto);
        }
        showTimeline();
        return "/twitter/home.jsp";
    }

    private void selectFollowList() {
        FollowCB followCB = new FollowCB();
        followCB.query().setMemberId_Equal(sessionDto.myId);
        followCB.query().setYouId_NotEqual(sessionDto.myId);
        followCB.query().setDelFlg_Equal("N");
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
            tweetDto.accountName = tweet.getMember().getAccountName();
            tweetDto.username = tweet.getMember().getUserName();
            tweetDto.tweetTime = tweet.getTweetDatetime();
            tweetDto.tweet = tweet.getTweet();
            timeLine.add(tweetDto);
            LOG.debug("***" + timeLine);
        }
    }

    @Execute(validator = false)
    public String goFollow() {
        return "/followList/?redirect=true";
    }

    @Execute(validator = false)
    public String addFollow() {
        /* 自分をフォローしない制約 */
        LOG.debug("@@@" + homeForm.suggestFollowId);
        MemberCB cb = new MemberCB();
        cb.query().setMemberId_Equal(homeForm.suggestFollowId);
        Member member = memberBhv.selectEntity(cb);
        if (member.getMemberId().equals(sessionDto.myId)) {
            return "/home/?redirect=true";
        }
        /* フォローしたことのない相手を新しくフォローする */
        FollowCB addFollowCb = new FollowCB();
        LOG.debug("check:" + homeForm.suggestFollowId);
        addFollowCb.query().setYouId_Equal(homeForm.suggestFollowId);
        addFollowCb.query().setMemberId_Equal(sessionDto.myId);
        Follow selectFollow = followBhv.selectEntity(addFollowCb);
        Follow follow = new Follow();
        if (selectFollow == null) {
            Date date = new Date();
            Timestamp followTime = new Timestamp(date.getTime());
            follow.setMemberId(sessionDto.myId);
            follow.setYouId(homeForm.suggestFollowId);
            follow.setInsDatetime(followTime);
            follow.setUpdDatetime(followTime);
            follow.setInsTrace("***");
            follow.setUpdTrace("***");
            followBhv.insert(follow);
        } else {
            /* フォローしたことのある相手なら削除フラグをNにする */
            Integer followId = selectFollow.getFollowId();
            follow.setFollowId(followId);
            follow.setDelFlg("N");
            followBhv.update(follow);
        }
        return "/home/?redirect=true";
    }

    @Execute(validate = "validate", input = "/home/?redirect =true")
    /* ツィートと、ツィート時間を新しく追加 */
    public String tweet() {
        if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
            throw new ActionMessagesException("不正なリクエストです", false);
        }
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
        /* 検索ワードが含まれるユーザーを検索　*/
        MemberCB memberCB = new MemberCB();
        memberCB.orScopeQuery(new OrQuery<MemberCB>() {
            @Override
            public void query(MemberCB orCB) {
                orCB.query().setAccountName_LikeSearch(homeForm.searchWord, new LikeSearchOption().likeContain());
                orCB.query().setUserName_LikeSearch(homeForm.searchWord, new LikeSearchOption().likeContain());
            }
        });
        memberCB.query().setMemberId_NotEqual(sessionDto.myId);
        memberCB.query().addOrderBy_MemberId_Asc();
        LOG.debug("***" + homeForm.searchWord);
        ListResultBean<Member> memberList = memberBhv.selectList(memberCB);
        for (Member member : memberList) {
            MemberDto memberDto = new MemberDto();
            memberDto.accountName = member.getAccountName();
            memberDto.userName = member.getUserName();
            memberDto.memberId = member.getMemberId();
            LOG.debug("***" + sessionDto.myId + "," + member.getMemberId());
            candidateList.add(memberDto);
        }
        /* 検索ワードが含まれるツィートを検索 */
        TweetCB tweetCB = new TweetCB();
        tweetCB.setupSelect_Member();
        tweetCB.query().setTweet_LikeSearch(homeForm.searchWord, new LikeSearchOption().likeContain());
        // tweetCB.query().setMemberId_NotEqual(sessionDto.myId);
        tweetCB.query().addOrderBy_TweetId_Asc();
        ListResultBean<Tweet> tweetList = tweetBhv.selectList(tweetCB);
        for (Tweet tweet : tweetList) {
            LOG.debug("***" + sessionDto.myId);
            TweetDto tweetDto = new TweetDto();
            tweetDto.tweet = tweet.getTweet();
            tweetDto.accountName = tweet.getMember().getAccountName();
            tweetDto.username = tweet.getMember().getUserName();
            tweetDto.tweetTime = tweet.getTweetDatetime();
            resultList.add(tweetDto);
        }
        /* 該当する検索結果がなかった場合の処理 */
        if (candidateList.isEmpty()) {
            noMatchUsers = "検索ワードと一致するユーザーはいません。";
            LOG.debug("hit" + candidateList);
        }
        if (resultList.isEmpty()) {
            noMatchTweets = "検索ワードと一致するツィートはありません。";
            LOG.debug("hit2" + resultList);
        }
        String searchWordPtn = "[\\\"\\\':;]+";
        Pattern ptn = Pattern.compile(searchWordPtn);
        Matcher searchWordMatcher = ptn.matcher(homeForm.searchWord);
        if (homeForm.searchWord == "" || searchWordMatcher.matches()) {
            return "/home/?redirect=true";
        }
        return "/twitter/searchresult.jsp";
    }

    // ===================================================================================
    //                                                                          Validation
    //                                                                          ==========
    public ActionMessages validate() {
        /* ツィートについてのvalidation */
        ActionMessages errors = new ActionMessages();
        if (homeForm.inputTweet.length() >= 140) {
            errors.add("inputTweet", new ActionMessage("140文字以上は入力できません。", false));
        }
        if (homeForm.inputTweet == "") {
            errors.add("inputTweet", new ActionMessage("なにも入力されていませんよー！", false));
        }
        return errors;
    }
}
