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
 *     MEMBER_ID, EMAIL_ADDRESS, USER_NAME, BIRTHDATE, PROFILE, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE, ACCOUNT_NAME
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
 *     member_security(AsOne), member_withdraw(AsOne)
 *
 * [referrer table]
 *     follow, login, tweet, member_security, member_withdraw
 *
 * [foreign property]
 *     memberSecurityAsOne, memberWithdrawAsOne
 *
 * [referrer property]
 *     followByMemberIdList, followByYouIdList, loginList, tweetList
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
    protected LoaderOfMemberSecurity _foreignMemberSecurityAsOneLoader;
    public LoaderOfMemberSecurity pulloutMemberSecurityAsOne() {
        if (_foreignMemberSecurityAsOneLoader != null) { return _foreignMemberSecurityAsOneLoader; }
        List<MemberSecurity> pulledList = myBhv().pulloutMemberSecurityAsOne(_selectedList);
        _foreignMemberSecurityAsOneLoader = new LoaderOfMemberSecurity().ready(pulledList, _selector);
        return _foreignMemberSecurityAsOneLoader;
    }

    protected LoaderOfMemberWithdraw _foreignMemberWithdrawAsOneLoader;
    public LoaderOfMemberWithdraw pulloutMemberWithdrawAsOne() {
        if (_foreignMemberWithdrawAsOneLoader != null) { return _foreignMemberWithdrawAsOneLoader; }
        List<MemberWithdraw> pulledList = myBhv().pulloutMemberWithdrawAsOne(_selectedList);
        _foreignMemberWithdrawAsOneLoader = new LoaderOfMemberWithdraw().ready(pulledList, _selector);
        return _foreignMemberWithdrawAsOneLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Member> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
