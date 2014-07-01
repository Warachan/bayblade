package jp.bizreach.twitter.dbflute.bsbhv.loader;

import java.util.List;

import org.seasar.dbflute.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The referrer loader of login as TABLE. <br />
 * <pre>
 * [primary key]
 *     LOGIN_ID
 *
 * [column]
 *     LOGIN_ID, MEMBER_ID, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE
 *
 * [sequence]
 *     
 *
 * [identity]
 *     LOGIN_ID
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
public class LoaderOfLogin {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<Login> _selectedList;
    protected BehaviorSelector _selector;
    protected LoginBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfLogin ready(List<Login> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected LoginBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(LoginBhv.class); return _myBhv; } }

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
    public List<Login> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
