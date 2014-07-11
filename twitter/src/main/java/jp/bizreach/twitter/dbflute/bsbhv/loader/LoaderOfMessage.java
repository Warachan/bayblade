package jp.bizreach.twitter.dbflute.bsbhv.loader;

import java.util.List;

import org.seasar.dbflute.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The referrer loader of message as TABLE. <br />
 * <pre>
 * [primary key]
 *     MESSAGE_ID
 *
 * [column]
 *     MESSAGE_ID, SENDER_ID, RECEIVER_ID, MESSAGE_TIME, MESSAGE, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     MESSAGE_ID
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
 *     memberBySenderId, memberByReceiverId
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMessage {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Message> _selectedList;
    protected BehaviorSelector _selector;
    protected MessageBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMessage ready(List<Message> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MessageBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MessageBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfMember _foreignMemberBySenderIdLoader;
    public LoaderOfMember pulloutMemberBySenderId() {
        if (_foreignMemberBySenderIdLoader != null) { return _foreignMemberBySenderIdLoader; }
        List<Member> pulledList = myBhv().pulloutMemberBySenderId(_selectedList);
        _foreignMemberBySenderIdLoader = new LoaderOfMember().ready(pulledList, _selector);
        return _foreignMemberBySenderIdLoader;
    }

    protected LoaderOfMember _foreignMemberByReceiverIdLoader;
    public LoaderOfMember pulloutMemberByReceiverId() {
        if (_foreignMemberByReceiverIdLoader != null) { return _foreignMemberByReceiverIdLoader; }
        List<Member> pulledList = myBhv().pulloutMemberByReceiverId(_selectedList);
        _foreignMemberByReceiverIdLoader = new LoaderOfMember().ready(pulledList, _selector);
        return _foreignMemberByReceiverIdLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<Message> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
