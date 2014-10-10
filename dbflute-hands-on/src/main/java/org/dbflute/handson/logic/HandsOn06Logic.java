package org.dbflute.handson.logic;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;

/**
 * @author mayuko.sakaba
 */
public class HandsOn06Logic {

    private static final Log LOG = LogFactory.getLog(HandsOn06LogicTest.class);

    @Resource
    protected MemberBhv memberBhv;

    /**
    *  ロジックのメソッド
    *  List<Member> selectSuffixMemberList(String suffix)
    *  指定された suffix で会員名称を後方一致検索
    *  会員名称の昇順で並べる
    *  suffixが無効な値なら例外: IllegalArgumentException
    *  会員名称、生年月日、正式会員日時をログに出す (Commons Logging)
    */
    public List<Member> selectSuffixMemberList(String suffix) {
        // 【消しましたー!】wara suffix.equals("")は不要かな by jflute
        if (suffix == null || suffix.trim().equals("")) {
            // 【つけましたー！】wara 無効な値の後ろに : くらい欲しい by jflute
            throw new IllegalArgumentException("無効な値:" + suffix);
        }

        MemberCB cb = new MemberCB();
        cb.query().setMemberName_LikeSearch(suffix, new LikeSearchOption().likeSuffix());
        cb.query().addOrderBy_MemberName_Asc();

        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // 本番では、デバッグログは(普通は)出ないが、文字列連結処理が走らないようにしたい。
        // なので、LOG.isDebugEnabled()で囲って上げるべし by jflute
        if (LOG.isDebugEnabled()) {
            for (Member member : memberList) {
                LOG.debug("###" + member.getBirthdate());
                LOG.debug(member.getFormalizedDatetime());
                LOG.debug(member.getMemberName());
            }
        }
        return memberList;
    }
}
