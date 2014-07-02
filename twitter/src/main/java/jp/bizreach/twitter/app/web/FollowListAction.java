package jp.bizreach.twitter.app.web;

import java.util.ArrayList;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.FollowCB;
import jp.bizreach.twitter.dbflute.exbhv.FollowBhv;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.TweetBhv;
import jp.bizreach.twitter.dbflute.exentity.Follow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */
public class FollowListAction {
    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final Log LOG = LogFactory.getLog(HomeAction.class);

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
    //public ArrayList<Integer> followIdList = new ArrayList<Integer>();
    //public ArrayList<Integer> followerMemberIdList = new ArrayList<Integer>();
    public ArrayList<String> followMemberList = new ArrayList<>();
    public ArrayList<String> followerMemberList = new ArrayList<>();
    public String noFollow;
    public String noFollower;

    // 【時間があればtodo】
    // TODO mayuko.sakaba 他の会員検索を別のactionクラスに分ける
    // TODO mayuko.sakaba 誕生日登録がまだですよー！
    // TODO mayuko.sakaba MM,ｄｄとすると、月や日付が一桁のときに0始まりで表示されてしまう。(→JSONを使う？、そもそも表示する必要があるのか？)

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false)
    public String index() {
        FollowCB followCB = new FollowCB();
        followCB.setupSelect_MemberByYouId();
        followCB.query().setMemberId_Equal(sessionDto.myId);
        followCB.query().setDelFlg_Equal("N");
        ListResultBean<Follow> selectFollowList = followBhv.selectList(followCB);
        for (Follow follow : selectFollowList) {
            String followMember = follow.getMemberByYouId().getUserName();
            LOG.debug("***" + follow);
            followMemberList.add(followMember);
        }
        FollowCB followerCB = new FollowCB();
        followerCB.setupSelect_MemberByMemberId();
        followerCB.query().setYouId_Equal(sessionDto.myId);
        ListResultBean<Follow> followerList = followBhv.selectList(followerCB);
        for (Follow follow : followerList) {
            String followerName = follow.getMemberByMemberId().getUserName();
            followerMemberList.add(followerName);
        }
        if (followMemberList.isEmpty()) {
            noFollow = "Not following yet";
        }
        if (followerMemberList.isEmpty()) {
            noFollower = "No followers yet";
        }
        return "/twitter/followlist.jsp";
    }
}
