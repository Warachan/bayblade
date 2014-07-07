package jp.bizreach.twitter.dbflute.bsbhv.loader;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.exentity.*;
import jp.bizreach.twitter.dbflute.cbean.*;

/**
 * The referrer loader of member_status as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_STATUS_CODE
 *
 * [column]
 *     MEMBER_STATUS_CODE, MEMBER_STATUS_NAME
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     member
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     memberList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfMemberStatus {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<MemberStatus> _selectedList;
    protected BehaviorSelector _selector;
    protected MemberStatusBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfMemberStatus ready(List<MemberStatus> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected MemberStatusBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(MemberStatusBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    protected List<Member> _referrerMemberList;
    public NestedReferrerLoaderGateway<LoaderOfMember> loadMemberList(ConditionBeanSetupper<MemberCB> setupper) {
        myBhv().loadMemberList(_selectedList, setupper).withNestedReferrer(new ReferrerListHandler<Member>() {
            public void handle(List<Member> referrerList) { _referrerMemberList = referrerList; }
        });
        return new NestedReferrerLoaderGateway<LoaderOfMember>() {
            public void withNestedReferrer(ReferrerLoaderHandler<LoaderOfMember> handler) {
                handler.handle(new LoaderOfMember().ready(_referrerMemberList, _selector));
            }
        };
    }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<MemberStatus> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
