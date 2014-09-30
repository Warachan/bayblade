package org.dbflute.handson.logic;

import java.util.List;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.coption.LikeSearchOption;

public class HandsOn06Logic {

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
        // TODO wara suffix.equals("")は不要かな by jflute
        if (suffix == null || suffix.equals("") || suffix.trim().equals("")) {
            // TODO wara 無効な値の後ろに : くらい欲しい by jflute
            throw new IllegalArgumentException("無効な値" + suffix);
        }

        MemberCB cb = new MemberCB();
        cb.query().setMemberName_LikeSearch(suffix, new LikeSearchOption().likeSuffix());
        cb.query().addOrderBy_MemberName_Asc();
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        return memberList;
    }
}
