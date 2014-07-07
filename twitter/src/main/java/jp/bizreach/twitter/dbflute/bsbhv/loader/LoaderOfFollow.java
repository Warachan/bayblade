package jp.bizreach.twitter.dbflute.bsbhv.loader;

import java.util.List;

import org.seasar.dbflute.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The referrer loader of follow as TABLE. <br />
 * <pre>
 * [primary key]
 *     FOLLOW_ID
 *
 * [column]
 *     FOLLOW_ID, YOU_ID, MEMBER_ID, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE, DEL_FLG
 *
 * [sequence]
 *     
 *
 * [identity]
 *     FOLLOW_ID
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
 *     memberByMemberId, memberByYouId
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfFollow {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Follow> _selectedList;
    protected BehaviorSelector _selector;
    protected FollowBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfFollow ready(List<Follow> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected FollowBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(FollowBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMember _foreignMemberByMemberIdLoader;
    public LoaderOfMember pulloutMemberByMemberId() {
        if (_foreignMemberByMemberIdLoader != null) { return _foreignMemberByMemberIdLoader; }
        List<Member> pulledList = myBhv().pulloutMemberByMemberId(_selectedList);
        _foreignMemberByMemberIdLoader = new LoaderOfMember().ready(pulledList, _selector);
        return _foreignMemberByMemberIdLoader;
    }

    protected LoaderOfMember _foreignMemberByYouIdLoader;
    public LoaderOfMember pulloutMemberByYouId() {
        if (_foreignMemberByYouIdLoader != null) { return _foreignMemberByYouIdLoader; }
        List<Member> pulledList = myBhv().pulloutMemberByYouId(_selectedList);
        _foreignMemberByYouIdLoader = new LoaderOfMember().ready(pulledList, _selector);
        return _foreignMemberByYouIdLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Follow> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
