package jp.bizreach.twitter.dbflute.bsbhv.loader;

import java.util.List;

import org.seasar.dbflute.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The referrer loader of tweet as TABLE. <br />
 * <pre>
 * [primary key]
 *     TWEET_ID
 *
 * [column]
 *     TWEET_ID, MEMBER_ID, TWEET, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE, TWEET_DATETIME
 *
 * [sequence]
 *     
 *
 * [identity]
 *     TWEET_ID
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     member
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     member
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfTweet {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Tweet> _selectedList;
    protected BehaviorSelector _selector;
    protected TweetBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfTweet ready(List<Tweet> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected TweetBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(TweetBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMember _foreignMemberLoader;
    public LoaderOfMember pulloutMember() {
        if (_foreignMemberLoader != null) { return _foreignMemberLoader; }
        List<Member> pulledList = myBhv().pulloutMember(_selectedList);
        _foreignMemberLoader = new LoaderOfMember().ready(pulledList, _selector);
        return _foreignMemberLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Tweet> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
