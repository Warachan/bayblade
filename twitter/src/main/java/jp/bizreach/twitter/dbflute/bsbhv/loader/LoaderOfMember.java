package jp.bizreach.twitter.dbflute.bsbhv.loader;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.exentity.*;
import jp.bizreach.twitter.dbflute.cbean.*;

/**
 * The referrer loader of member as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_ID
 *
 * [column]
 *     MEMBER_ID, EMAIL_ADDRESS, MEMBER_STATUS_CODE, USER_NAME, ACCOUNT_NAME, GROUP_NAME, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE, RECRUITING_NUMBER, INTERESTED_INDUSTRY, GRADUATION_YEAR, BIRTHDATE, PROFILE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     MEMBER_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     member_status, member_security(AsOne)
 *
 * [referrer table]
 *     follow, login, tweet, member_security
 *
 * [foreign property]
 *     memberStatus, memberSecurityAsOne
 *
 * [referrer property]
 *     followByYouIdList, followByMemberIdList, loginList, tweetList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMember {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Member> _selectedList;
    protected BehaviorSelector _selector;
    protected MemberBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMember ready(List<Member> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MemberBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MemberBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Follow> _referrerFollowByYouIdList;
    public NestedReferrerLoaderGateway<LoaderOfFollow> loadFollowByYouIdList(ConditionBeanSetupper<FollowCB> setupper) {
        myBhv().loadFollowByYouIdList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<Follow>() {
            public void handle(List<Follow> referrerList) { _referrerFollowByYouIdList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfFollow>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfFollow> handler) {
                handler.handle(new LoaderOfFollow().ready(_referrerFollowByYouIdList, _selector));
            }
        };
    }

    protected List<Follow> _referrerFollowByMemberIdList;
    public NestedReferrerLoaderGateway<LoaderOfFollow> loadFollowByMemberIdList(ConditionBeanSetupper<FollowCB> setupper) {
        myBhv().loadFollowByMemberIdList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<Follow>() {
            public void handle(List<Follow> referrerList) { _referrerFollowByMemberIdList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfFollow>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfFollow> handler) {
                handler.handle(new LoaderOfFollow().ready(_referrerFollowByMemberIdList, _selector));
            }
        };
    }

    protected List<Login> _referrerLoginList;
    public NestedReferrerLoaderGateway<LoaderOfLogin> loadLoginList(ConditionBeanSetupper<LoginCB> setupper) {
        myBhv().loadLoginList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<Login>() {
            public void handle(List<Login> referrerList) { _referrerLoginList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfLogin>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfLogin> handler) {
                handler.handle(new LoaderOfLogin().ready(_referrerLoginList, _selector));
            }
        };
    }

    protected List<Tweet> _referrerTweetList;
    public NestedReferrerLoaderGateway<LoaderOfTweet> loadTweetList(ConditionBeanSetupper<TweetCB> setupper) {
        myBhv().loadTweetList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<Tweet>() {
            public void handle(List<Tweet> referrerList) { _referrerTweetList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfTweet>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfTweet> handler) {
                handler.handle(new LoaderOfTweet().ready(_referrerTweetList, _selector));
            }
        };
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMemberStatus _foreignMemberStatusLoader;
    public LoaderOfMemberStatus pulloutMemberStatus() {
        if (_foreignMemberStatusLoader != null) { return _foreignMemberStatusLoader; }
        List<MemberStatus> pulledList = myBhv().pulloutMemberStatus(_selectedList);
        _foreignMemberStatusLoader = new LoaderOfMemberStatus().ready(pulledList, _selector);
        return _foreignMemberStatusLoader;
    }

    protected LoaderOfMemberSecurity _foreignMemberSecurityAsOneLoader;
    public LoaderOfMemberSecurity pulloutMemberSecurityAsOne() {
        if (_foreignMemberSecurityAsOneLoader != null) { return _foreignMemberSecurityAsOneLoader; }
        List<MemberSecurity> pulledList = myBhv().pulloutMemberSecurityAsOne(_selectedList);
        _foreignMemberSecurityAsOneLoader = new LoaderOfMemberSecurity().ready(pulledList, _selector);
        return _foreignMemberSecurityAsOneLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Member> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
