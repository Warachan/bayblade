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
    public ArrayList<MemberDto> followMemberList = new ArrayList<>();
    public ArrayList<MemberDto> followerMemberList = new ArrayList<>();
    public String noFollow;
    public String noFollower;

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
            MemberDto memberDto = new MemberDto();
            memberDto.userName = follow.getMemberByYouId().getUserName();
            memberDto.accountName = follow.getMemberByYouId().getAccountName();
            memberDto.memberId = follow.getYouId();
            LOG.debug("***" + follow);
            followMemberList.add(memberDto);
        }
        if (followMemberList.isEmpty()) {
            noFollow = "Not following yet";
        }
        FollowCB followerCB = new FollowCB();
        followerCB.setupSelect_MemberByMemberId();
        followerCB.query().setYouId_Equal(sessionDto.myId);
        ListResultBean<Follow> followerList = followBhv.selectList(followerCB);
        for (Follow follow : followerList) {
            MemberDto memberDto = new MemberDto();
            memberDto.userName = follow.getMemberByMemberId().getUserName();
            memberDto.accountName = follow.getMemberByMemberId().getAccountName();
            memberDto.memberId = follow.getMemberId();
            followerMemberList.add(memberDto);
        }
        if (followerMemberList.isEmpty()) {
            noFollower = "No followers yet";
        }
        return "/twitter/followlist.jsp";
    }
}
