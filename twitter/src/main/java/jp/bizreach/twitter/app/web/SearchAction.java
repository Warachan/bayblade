//package jp.bizreach.twitter.app.web;
//
//import java.util.ArrayList;
//
//import javax.annotation.Resource;
//
//import jp.bizreach.twitter.dbflute.cbean.MemberCB;
//import jp.bizreach.twitter.dbflute.exbhv.FollowBhv;
//import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
//import jp.bizreach.twitter.dbflute.exbhv.TweetBhv;
//import jp.bizreach.twitter.dbflute.exentity.Member;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.seasar.dbflute.cbean.ListResultBean;
//import org.seasar.dbflute.cbean.coption.LikeSearchOption;
//import org.seasar.struts.annotation.ActionForm;
//import org.seasar.struts.annotation.Execute;
//
///**
// * @author mayuko.sakaba
// */
//public class SearchAction {
//    // ===================================================================================
//    //                                                                          Definition
//    //                                                                          ==========
//    private static final Log LOG = LogFactory.getLog(HomeAction.class);
//
//    // ===================================================================================
//    //                                                                           Attribute
//    //                                                                           =========
//    // -----------------------------------------------------
//    //                                          DI Component
//    //                                          ------------
//    @ActionForm
//    @Resource
//    protected HomeForm homeForm;
//    @Resource
//    protected MemberBhv memberBhv;
//    @Resource
//    protected TweetBhv tweetBhv;
//    @Resource
//    protected FollowBhv followBhv;
//    @Resource
//    protected SessionDto sessionDto;
//
//    // -----------------------------------------------------
//    //                                          Display Data
//    //                                          ------------
//    public ArrayList<TweetDto> searchTimeLine = new ArrayList<>();
//    public ArrayList<Integer> followList = new ArrayList<Integer>();
//    public ArrayList<String> candidateList = new ArrayList<String>();
//
//    // ===================================================================================
//    //                                                                             Execute
//    //                                                                             =======
//
//    @Execute(validator = false)
//    public String index() {
//        /* フォロー候補者検索　*/
//        MemberCB cb = new MemberCB();
//        cb.query().setUserName_LikeSearch(homeForm.searchName, new LikeSearchOption().likeContain());
//        cb.query().addOrderBy_MemberId_Asc();
//        LOG.debug("***" + homeForm.searchName);
//        ListResultBean<Member> memberList = memberBhv.selectList(cb);
//        for (Member member : memberList) {
//            toFollowMember = member.getUserName();
//            String userName = member.getUserName();
//            candidateList.add(userName);
//            LOG.debug("***" + toFollowMember);
//        }
//        return "/twitter/search.jsp";
//    }
//}
