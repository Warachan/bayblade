package org.dbflute.handson.exercise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.dbflute.handson.dbflute.allcommon.CDef;
import org.dbflute.handson.dbflute.allcommon.CDef.MemberStatus;
import org.dbflute.handson.dbflute.cbean.MemberCB;
import org.dbflute.handson.dbflute.cbean.PurchaseCB;
import org.dbflute.handson.dbflute.cbean.PurchasePaymentCB;
import org.dbflute.handson.dbflute.exbhv.MemberBhv;
import org.dbflute.handson.dbflute.exbhv.MemberSecurityBhv;
import org.dbflute.handson.dbflute.exbhv.PurchaseBhv;
import org.dbflute.handson.dbflute.exentity.Member;
import org.dbflute.handson.dbflute.exentity.ProductStatus;
import org.dbflute.handson.dbflute.exentity.Purchase;
import org.dbflute.handson.unit.UnitContainerTestCase;
import org.seasar.dbflute.bhv.ConditionBeanSetupper;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;

// 【チェック!】wara クラス宣言の直下、他のクラスでは空行空けているので、空けましょう by jflute
/**
 * @author mayuko.sakaba
 */
public class HandsOn04Test extends UnitContainerTestCase {

    @Resource
    protected MemberBhv memberBhv;

    @Resource
    protected MemberSecurityBhv memberSecurityBhv;

    @Resource
    protected PurchaseBhv purchaseBhv;

    /**
     * 【1】退会会員の未払い購入を検索
     * 退会会員のステータスコードは "WDL"。ひとまずベタで
     * 支払完了フラグは "0" で未払い。ひとまずベタで
     * 購入日時の降順で並べる
     * 会員名称と商品名と一緒にログに出力
     * 購入が未払いであることをアサート
     */
    public void test_01() throws Exception {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Member();
        cb.setupSelect_Product();
        // 【チェック!】wara まあ、使ってみたかったとのこと。まあ、それにしても、呼び出し位置は、setupSelectの直下 by jflute
        cb.specify().specifyProduct().columnProductName();
        cb.query().queryMember().setMemberStatusCode_Equal("WDL");
        cb.query().setPaymentCompleteFlg_Equal(0);
        // 【チェック!】wara orderByは最後にしよう by jflute
        cb.query().addOrderBy_PurchaseDatetime_Desc();

        // ## Act ##
        ListResultBean<Purchase> puchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(puchaseList);
        for (Purchase purchase : puchaseList) {
            log(purchase.getMember().getMemberName(), purchase.getProduct().getProductName());
            assertTrue(purchase.getPaymentCompleteFlg().equals(0));
        }
    }

    /**
     * 【2】会員退会情報も取得して会員を検索
     * 退会会員でない会員は、会員退会情報を持っていないことをアサート
     * 退会会員のステータスコードは "WDL"。ひとまずベタで
     * 不意のバグや不意のデータ不備でもテストが(できるだけ)成り立つこと
     */
    public void test_02() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberWithdrawalAsOne();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList); // 素通り防止
        // これで相当堅いテストになった。相当事前条件がぶっ壊れてもちゃんと検知できる
        boolean existsNotWDL = false;
        boolean existsWDL = false;
        for (Member member : memberList) {
            if (!member.getMemberStatusCode().equals("WDL")) { // 退会会員でないひと
                assertNull(member.getMemberWithdrawalAsOne());
                existsNotWDL = true;
            } else {
                // setupSelectされていることを保証するアサート
                // でないと、setupSelect忘れのときに、意味のないassertNull()になってしまうため
                assertNotNull(member.getMemberWithdrawalAsOne());
                existsWDL = true; // その保証が動いていることを保証する
            }
        }
        assertTrue(existsNotWDL);
        assertTrue(existsWDL);
    }

    /**
     * 【3】一番若い仮会員の会員を検索
     * 区分値メソッドの JavaDoc コメントを確認する
     * 会員ステータス名称も取得する(ログに出力)
     * 会員が仮会員であることをアサート
     * ※できれば、テストメソッド内の検索回数は一回で...
     */
    public void test_03() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        // TODO 【仮会員検索に指定しました。】wara これだけだと、「仮会員の中で一番若い」生年月日を持った会員を検索になってる by jflute
        // すると、同じ生年月日を持った正式会員も検索されてしまう、ので外側にも絞り込みが必要
        // http://dbflute.seasar.org/ja/manual/function/ormapper/conditionbean/query/scalarcondition.html#outerquery
        cb.query().setMemberStatusCode_Equal_仮会員();
        cb.query().scalar_Equal().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnBirthdate();
                subCB.query().setMemberStatusCode_Equal_仮会員();
            }
        });
        // 【やってみた！】wara 修行++: 以下は思い出にして、同じ生年月日の人がいたら、みんな検索してみよう by jflute
        // 【チェック!】wara orderByは最後 (fetchFirst()の手前) by jflute
        // 思い出
        // cb.query().setMemberStatusCode_Equal_仮会員();
        // cb.query().addOrderBy_Birthdate_Desc();
        // cb.fetchFirst(1);

        // ## Act ##
        // 【使います！】wara selectEntityWithDeteledCheck()を使おう by jflute
        // TODO 【リストに直しましたー】wara 同じ生年月日の人もいるかもしれないので、リスト検索だね by jflute
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            log(member.getMemberStatus().getMemberStatusName());
            assertTrue(member.isMemberStatusCode仮会員());
        }
    }

    /**
     * 【4】支払済みの購入の中で一番若い正式会員のものだけ検索
     * 会員ステータス名称も取得する(ログに出力)
     * 購入日時の降順で並べる
     * 購入の紐づいている会員が正式会員であることをアサート
     * ※これ難しい...かも!? (解釈に "曖昧さ" あり、実際にデータが存在している方を優先)
     */
    public void test_04() throws Exception {
        // ## Arrange ##
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Member().withMemberStatus();
        cb.query().queryMember().scalar_Equal().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnBirthdate();
                subCB.query().setMemberStatusCode_Equal_正式会員();
                subCB.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.query().setPaymentCompleteFlg_Equal_True();
                    }
                });
            }
        });
        cb.query().queryMember().setMemberStatusCode_Equal_正式会員();
        cb.query().setPaymentCompleteFlg_Equal_True();
        cb.query().addOrderBy_PurchaseDatetime_Desc();
        // 【チェック!】wara orderByは最後 by jflute
        // 【チェック!】wara getConditionQueryMemberStatus()は内部メソッドなので、queryMemberStatus()を使って by jflute
        // 【チェック!】wara というか、MemberStatusまで行く必要なし by jflute
        // 【やってみた！】wara 一番若いがない。せっかくなので、一つ前のエクササイズと同じく、fetchFirst()なしで by jflute

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (Purchase purchase : purchaseList) {
            Member member = purchase.getMember();
            String memberStatusName = member.getMemberStatus().getMemberStatusName();
            log(memberStatusName);
            assertTrue(member.isMemberStatusCode正式会員());
        }
    }

    /**
     * 【5】生産販売可能な商品の購入を検索
     * 商品ステータス名称も取得する(ログに出力)
     * 購入価格の降順で並べる
     * 購入の紐づいている商品が生産販売可能であることをアサート
     */
    public void test_05() throws Exception {
        // ## Arrange ##
        // TODO 【同じにしてみました】wara いろいろおなじ by jflute
        PurchaseCB cb = new PurchaseCB();
        cb.setupSelect_Product().withProductStatus();
        cb.query().queryProduct().getConditionQueryProductStatus().setProductStatusCode_Equal_生産販売可能();
        cb.query().addOrderBy_PurchasePrice_Desc();

        // ## Act ##
        ListResultBean<Purchase> purchaseList = purchaseBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(purchaseList);
        for (Purchase purchase : purchaseList) {
            ProductStatus status = purchase.getProduct().getProductStatus();
            log(status);
            // 【isになるです】wara is... by jflute
            assertTrue(status.isProductStatusCode生産販売可能());
        }
    }

    /**
     * 【6】正式会員と退会会員の会員を検索
     * 会員ステータスの表示順で並べる
     * 会員が正式会員と退会会員であることをアサート
     * 両方とも存在していることをアサート
     * Entity上だけで正式会員を退会会員に変更する
     * 変更した後、退会会員に変更されていることをアサート
     */
    public void test_06() throws Exception {
        // ## Arrange ##
        // wara いろいろおなじ by jflute
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        List<MemberStatus> statusList = new ArrayList<CDef.MemberStatus>();
        statusList.add(CDef.MemberStatus.正式会員);
        statusList.add(CDef.MemberStatus.退会会員);
        cb.query().setMemberStatusCode_InScope_AsMemberStatus(statusList);
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            assertTrue(member.isMemberStatusCode正式会員() || member.isMemberStatusCode退会会員());
            // wara こないよー by jflute

            if (member.isMemberStatusCode正式会員()) {
                member.setMemberStatusCode_退会会員();
                String changedStatus = member.getMemberStatus().getMemberStatusName();
                log("変更後：" + changedStatus + member.isMemberStatusCode退会会員());
                assertTrue(member.isMemberStatusCode退会会員());
                // mayuko.sakaba 変更が正しくできていないのでは。
                // wara だいじょうぶ、setMemberStatusCode_退会会員()しても変わるのはコードだけ by jflute
                // Entityの参照しているMemberStatusは何も変わらない。(データベースも何も変更されない)
            }
        }
    }

    /**
     * 【7】銀行振込で購入を支払ったことのある、会員ステータスごとに一番若い会員を検索
     * 正式会員で一番若い、仮会員で一番若い、という風にそれぞれのステータスで若い会員を検索
     * 一回の ConditionBean による検索で会員たちを検索すること (PartitionBy...)
     * ログのSQLを見て、検索が妥当であることを目視で確認すること
     * 検索結果がステータスの件数以上であることをアサート
     * ※"where句の再利用"のドキュメントをよく読んで、MemberCQクラスに arrangeExistsBankTransferPayment() というメソッドを 作ってみたいと思ったら 作ってみましょう。
     */
    public void test_07() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().arrangeExistsBankTransferPayment();
        cb.query().scalar_Equal().max(new SubQuery<MemberCB>() {
            public void query(MemberCB subCB) {
                subCB.specify().columnBirthdate();
                subCB.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
                    public void query(PurchaseCB subCB) {
                        subCB.query().existsPurchasePaymentList(new SubQuery<PurchasePaymentCB>() {
                            public void query(PurchasePaymentCB subCB) {
                                subCB.query().setPaymentMethodCode_Equal_BankTransfer();
                            }
                        });
                    }
                });
            }
        }).partitionBy(new SpecifyQuery<MemberCB>() {
            public void specify(MemberCB cb) {
                cb.specify().columnMemberStatusCode();
            }
        });
        // mayuko.sakaba 結局全部arrangeExistsBankTransferPaymentに含んでしまったけどこれはCQにメソッドを作った意味を良くわからない
        // mayuko.sakaba これでいいのでしょうか？仕組みがイマイチよくわかっていない。。。
        // TODO 【変更して見ました】wara ひとまず、銀行振込をしたことのない会員でたまたま同じ生年月日の人が同じステータス内にいたら検索されちゃう by jflute
        // http://dbflute.seasar.org/ja/manual/function/ormapper/conditionbean/query/scalarcondition.html#outerqueryagain
        // wara 先に、一番若い仮会員のエクササイズやってからだけど、これ by jflute
        // http://dbflute.seasar.org/ja/manual/function/ormapper/conditionbean/query/scalarcondition.html#outerqueryagain

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        // TODO 【おっしゃるとおりございます】wara このcountって、要は memberList.size() じゃない？ by jflute
        // TODO 【つかってみましたー！ 】wara Setを使うともっと楽かな by jflute
        Set<String> statusSet = new HashSet<String>();
        for (Member member : memberList) {
            String status = member.getMemberStatusCode();
            statusSet.add(status);
            log(member.getMemberName());
        }
        int setSize = statusSet.size();
        log(setSize);
        assertTrue(setSize <= memberList.size());
    }

    //    public void test_add_change() throws Exception {
    //        // ## Arrange ##
    //        MemberCB cb = new MemberCB();
    //        cb.setupSelect_MemberSecurityAsOne();
    //        cb.query().queryMemberStatus().setMemberStatusCode_Equal_ハンズオン();
    //
    //        // ## Act ##
    //        ListResultBean<Member> memberList = memberBhv.selectList(cb);
    //
    //        // ## Assert ##
    //        for (Member member : memberList) {
    //            String statusName = member.getMemberStatus().getMemberStatusName();
    //            log(statusName);
    //        }
    //    }
    // 区分値の追加と変更の確認。
    // masterデータの元であるエクセルにハンズオンというメンバーステータスレコードを追加する。
    // その後、replace-schemaを実行し、generateとdocをJDBCタスクを一緒に実行する。
    // replace-schema実行後、schema.htmlでメンバーステータスにハンズオンという区分値と、コメントが追加されていることを確認。
    // classificationDefinitionMap.dfpropにもメンバーステータス欄にハンズオンが追記されているか確認すべきだった。。。
    // テストメソッドでハンズオンという区分値を使ってみる。
    // その後、メンバーステータスのエクセルからハンズオンのレコードを削除し、再びreplaceーschemaを実行。
    // schema.htmlでハンズオンという区分値が消えていることを確認し、テストメソッドもコンパイルエラーになっていることを確認。
    // 存在しない区分値を指定して検索しようとしていたので、このテストメソッドがコンパイルエラーになって当然。

    /**
     * 【8】サービスが利用できる会員を検索
     * グルーピングの設定によって生成されたメソッドを利用
     * 会員ステータスの表示順で並べる
     * 会員が "サービスが利用できる会員" であることをアサート
     * ※SchemaHTMLの区分値の欄もぜひ確認してみてください。
     * ※実は既にグルーピングを利用している区分値もありますので、ぜひ確認してみてください。
     */
    public void test_08() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.setupSelect_MemberStatus();
        cb.query().setMemberStatusCode_InScope_ServiceAvailable();
        //if (正式会員 || 仮会員) {
        //}
        // が、ログインできる会員と一言で表現できるのであれば、
        // ↓
        //if (ログインできる会員) {
        //}
        // という風に書きたい。
        // でないと、そこら中でベタベタやってしまうと、ログインできる会員が増えたときに困る。
        // ということで、この機能は「DB変更に強い」を実現するためにすごく大事。
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        // 【やってみましたー引き続き整理していきます】wara dfpropを綺麗に by jflute

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            assertTrue(member.isMemberStatusCode_ServiceAvailable());
        }
    }

    /**
     * 【9】未払い購入のある会員を検索
     * 姉妹コードの設定によって生成されたメソッドを利用
     * 正式会員日時の降順(nullを後に並べる)、会員IDの昇順で並べる
     * 会員が未払いの購入を持っていることをアサート
     */
    public void test_09() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.query().existsPurchaseList(new SubQuery<PurchaseCB>() {
            public void query(PurchaseCB subCB) {
                subCB.query().setPaymentCompleteFlg_Equal_AsBoolean(false);
            }
        });
        cb.query().addOrderBy_FormalizedDatetime_Desc().withNullsLast();
        cb.query().addOrderBy_MemberId_Asc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);
        memberBhv.loadPurchaseList(memberList, new ConditionBeanSetupper<PurchaseCB>() {
            public void setup(PurchaseCB referrerCB) {
                referrerCB.query().setPaymentCompleteFlg_Equal_AsBoolean(false);
            }
        });
        // ## Assert ##
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            List<Purchase> purchaseList = member.getPurchaseList();
            // TODO 【とってみた】mayuko.sakaba purchaseListの中身が空！なぜ！？
            //  -> 取ってないから by jflute
            for (Purchase purchase : purchaseList) {
                assertHasAnyElement(purchaseList);
                assertTrue(purchase.isPaymentCompleteFlgFalse());
                // TODO mayuko.sakaba trueなのにfalseだー
            }
        }
    }

    /**
     * 【10】会員ステータスの表示順カラムで会員を並べて検索
     * 会員ステータスの "表示順" カラムの昇順で並べる
     * 会員ステータスのデータ自体は要らない
     * その次には、会員の会員IDの降順で並べる
     * 会員ステータスのデータが取れていないことをアサート
     * 会員が会員ステータスの表示順ごとに並んでいることをアサート
     */
    public void test_10() throws Exception {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        // TODO 【とってみた】mayuko.sakaba これだと独自の属性を指定した意味がよくわからない感じになっちゃってる
        //  -> まあね。でも、取っちゃいけないからね by jflute
        cb.query().queryMemberStatus().addOrderBy_DisplayOrder_Asc();
        cb.query().addOrderBy_MemberId_Desc();

        // ## Act ##
        ListResultBean<Member> memberList = memberBhv.selectList(cb);

        // ## Assert ##
        // TODO 【うーーーーー】wara 整理してみよう by jflute
        int previousOrder = 0;
        assertHasAnyElement(memberList);
        for (Member member : memberList) {
            assertNull(member.getMemberStatus());
            String displayOrder = CDef.MemberStatus.codeOf(member.getMemberStatusCode()).displayOrder();
            log("***********************" + displayOrder);
            int currentOrder = Integer.parseInt(displayOrder);
            if (currentOrder > previousOrder) {
                previousOrder = currentOrder;
            }
            log(currentOrder, previousOrder);
            assertTrue(currentOrder >= previousOrder);
            assertNull(member.getMemberStatus());
        }
    }
}
