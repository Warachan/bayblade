package jp.bizreach.twitter.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import jp.bizreach.twitter.dbflute.allcommon.*;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The DB meta of member. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberDbm _instance = new MemberDbm();
    private MemberDbm() {}
    public static MemberDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgEmailAddress(), "emailAddress");
        setupEpg(_epgMap, new EpgUserName(), "userName");
        setupEpg(_epgMap, new EpgBirthdate(), "birthdate");
        setupEpg(_epgMap, new EpgProfile(), "profile");
        setupEpg(_epgMap, new EpgRegesterDatetime(), "regesterDatetime");
        setupEpg(_epgMap, new EpgUpdateDatetime(), "updateDatetime");
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((Member)et).setMemberId(cti(vl)); }
    }
    public static class EpgEmailAddress implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getEmailAddress(); }
        public void write(Entity et, Object vl) { ((Member)et).setEmailAddress((String)vl); }
    }
    public static class EpgUserName implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getUserName(); }
        public void write(Entity et, Object vl) { ((Member)et).setUserName((String)vl); }
    }
    public static class EpgBirthdate implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getBirthdate(); }
        public void write(Entity et, Object vl) { ((Member)et).setBirthdate((java.util.Date)vl); }
    }
    public static class EpgProfile implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getProfile(); }
        public void write(Entity et, Object vl) { ((Member)et).setProfile((String)vl); }
    }
    public static class EpgRegesterDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getRegesterDatetime(); }
        public void write(Entity et, Object vl) { ((Member)et).setRegesterDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdateDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getUpdateDatetime(); }
        public void write(Entity et, Object vl) { ((Member)et).setUpdateDatetime((java.sql.Timestamp)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgFollowByYouIdAsOne(), "followByYouIdAsOne");
        setupEfpg(_efpgMap, new EfpgMemberSecurityAsOne(), "memberSecurityAsOne");
        setupEfpg(_efpgMap, new EfpgMemberWithdrawAsOne(), "memberWithdrawAsOne");
    }
    public class EfpgFollowByYouIdAsOne implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getFollowByYouIdAsOne(); }
        public void write(Entity et, Object vl) { ((Member)et).setFollowByYouIdAsOne((Follow)vl); }
    }
    public class EfpgMemberSecurityAsOne implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getMemberSecurityAsOne(); }
        public void write(Entity et, Object vl) { ((Member)et).setMemberSecurityAsOne((MemberSecurity)vl); }
    }
    public class EfpgMemberWithdrawAsOne implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getMemberWithdrawAsOne(); }
        public void write(Entity et, Object vl) { ((Member)et).setMemberWithdrawAsOne((MemberWithdraw)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "member";
    protected final String _tablePropertyName = "member";
    protected final TableSqlName _tableSqlName = new TableSqlName("member", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, true, true, true, "INT", 10, 0, null, false, null, null, null, "followByMeIdList,loginList,tweetList", null);
    protected final ColumnInfo _columnEmailAddress = cci("EMAIL_ADDRESS", "EMAIL_ADDRESS", null, null, String.class, "emailAddress", null, false, false, true, "VARCHAR", 100, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUserName = cci("USER_NAME", "USER_NAME", null, null, String.class, "userName", null, false, false, true, "VARCHAR", 50, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnBirthdate = cci("BIRTHDATE", "BIRTHDATE", null, null, java.util.Date.class, "birthdate", null, false, false, false, "DATE", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnProfile = cci("PROFILE", "PROFILE", null, null, String.class, "profile", null, false, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnRegesterDatetime = cci("REGESTER_DATETIME", "REGESTER_DATETIME", null, null, java.sql.Timestamp.class, "regesterDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.sql.Timestamp.class, "updateDatetime", null, false, false, false, "DATETIME", 19, 0, null, false, null, null, null, null, null);

    /**
     * MEMBER_ID: {PK, ID, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnEmailAddress() { return _columnEmailAddress; }
    /**
     * USER_NAME: {UQ, NotNull, VARCHAR(50)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUserName() { return _columnUserName; }
    /**
     * BIRTHDATE: {DATE(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBirthdate() { return _columnBirthdate; }
    /**
     * PROFILE: {VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnProfile() { return _columnProfile; }
    /**
     * REGESTER_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegesterDatetime() { return _columnRegesterDatetime; }
    /**
     * UPDATE_DATETIME: {DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnEmailAddress());
        ls.add(columnUserName());
        ls.add(columnBirthdate());
        ls.add(columnProfile());
        ls.add(columnRegesterDatetime());
        ls.add(columnUpdateDatetime());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnMemberId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * follow by YOU_ID, named 'followByYouIdAsOne'.
     * @return The information object of foreign property(referrer-as-one). (NotNull)
     */
    public ForeignInfo foreignFollowByYouIdAsOne() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), FollowDbm.getInstance().columnYouId());
        return cfi("follow_ibfk_2", "followByYouIdAsOne", this, FollowDbm.getInstance(), mp, 0, null, true, false, true, false, null, null, false, "memberByYouId");
    }
    /**
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return The information object of foreign property(referrer-as-one). (NotNull)
     */
    public ForeignInfo foreignMemberSecurityAsOne() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberSecurityDbm.getInstance().columnMemberId());
        return cfi("member_security_ibfk_1", "memberSecurityAsOne", this, MemberSecurityDbm.getInstance(), mp, 1, null, true, false, true, false, null, null, false, "member");
    }
    /**
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @return The information object of foreign property(referrer-as-one). (NotNull)
     */
    public ForeignInfo foreignMemberWithdrawAsOne() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberWithdrawDbm.getInstance().columnMemberId());
        return cfi("member_withdraw_ibfk_1", "memberWithdrawAsOne", this, MemberWithdrawDbm.getInstance(), mp, 2, null, true, false, true, false, null, null, false, "member");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * follow by ME_ID, named 'followByMeIdList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerFollowByMeIdList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), FollowDbm.getInstance().columnMeId());
        return cri("follow_ibfk_1", "followByMeIdList", this, FollowDbm.getInstance(), mp, false, "memberByMeId");
    }
    /**
     * login by MEMBER_ID, named 'loginList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerLoginList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), LoginDbm.getInstance().columnMemberId());
        return cri("login_ibfk_1", "loginList", this, LoginDbm.getInstance(), mp, false, "member");
    }
    /**
     * tweet by MEMBER_ID, named 'tweetList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerTweetList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), TweetDbm.getInstance().columnMemberId());
        return cri("tweet_ibfk_1", "tweetList", this, TweetDbm.getInstance(), mp, false, "member");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.Member"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.MemberCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.MemberBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Member> getEntityType() { return Member.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Member newEntity() { return new Member(); }
    public Member newMyEntity() { return new Member(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Member)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Member)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
