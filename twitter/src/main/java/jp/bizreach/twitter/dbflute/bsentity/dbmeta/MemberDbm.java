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
        setupEpg(_epgMap, new EpgMemberStatusCode(), "memberStatusCode");
        setupEpg(_epgMap, new EpgUserName(), "userName");
        setupEpg(_epgMap, new EpgAccountName(), "accountName");
        setupEpg(_epgMap, new EpgGroupName(), "groupName");
        setupEpg(_epgMap, new EpgInsDatetime(), "insDatetime");
        setupEpg(_epgMap, new EpgUpdDatetime(), "updDatetime");
        setupEpg(_epgMap, new EpgInsTrace(), "insTrace");
        setupEpg(_epgMap, new EpgUpdTrace(), "updTrace");
        setupEpg(_epgMap, new EpgRecruitingNumber(), "recruitingNumber");
        setupEpg(_epgMap, new EpgInterestedIndustry(), "interestedIndustry");
        setupEpg(_epgMap, new EpgGraduationYear(), "graduationYear");
        setupEpg(_epgMap, new EpgBirthdate(), "birthdate");
        setupEpg(_epgMap, new EpgProfile(), "profile");
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((Member)et).setMemberId(cti(vl)); }
    }
    public static class EpgEmailAddress implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getEmailAddress(); }
        public void write(Entity et, Object vl) { ((Member)et).setEmailAddress((String)vl); }
    }
    public static class EpgMemberStatusCode implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getMemberStatusCode(); }
        public void write(Entity et, Object vl) { ((Member)et).setMemberStatusCode(cti(vl)); }
    }
    public static class EpgUserName implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getUserName(); }
        public void write(Entity et, Object vl) { ((Member)et).setUserName((String)vl); }
    }
    public static class EpgAccountName implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getAccountName(); }
        public void write(Entity et, Object vl) { ((Member)et).setAccountName((String)vl); }
    }
    public static class EpgGroupName implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getGroupName(); }
        public void write(Entity et, Object vl) { ((Member)et).setGroupName((String)vl); }
    }
    public static class EpgInsDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getInsDatetime(); }
        public void write(Entity et, Object vl) { ((Member)et).setInsDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getUpdDatetime(); }
        public void write(Entity et, Object vl) { ((Member)et).setUpdDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgInsTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getInsTrace(); }
        public void write(Entity et, Object vl) { ((Member)et).setInsTrace((String)vl); }
    }
    public static class EpgUpdTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getUpdTrace(); }
        public void write(Entity et, Object vl) { ((Member)et).setUpdTrace((String)vl); }
    }
    public static class EpgRecruitingNumber implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getRecruitingNumber(); }
        public void write(Entity et, Object vl) { ((Member)et).setRecruitingNumber(cti(vl)); }
    }
    public static class EpgInterestedIndustry implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getInterestedIndustry(); }
        public void write(Entity et, Object vl) { ((Member)et).setInterestedIndustry((String)vl); }
    }
    public static class EpgGraduationYear implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getGraduationYear(); }
        public void write(Entity et, Object vl) { ((Member)et).setGraduationYear(cti(vl)); }
    }
    public static class EpgBirthdate implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getBirthdate(); }
        public void write(Entity et, Object vl) { ((Member)et).setBirthdate((java.util.Date)vl); }
    }
    public static class EpgProfile implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getProfile(); }
        public void write(Entity et, Object vl) { ((Member)et).setProfile((String)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgMemberStatus(), "memberStatus");
    }
    public class EfpgMemberStatus implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getMemberStatus(); }
        public void write(Entity et, Object vl) { ((Member)et).setMemberStatus((MemberStatus)vl); }
    }
    {
        setupEfpg(_efpgMap, new EfpgMemberSecurityAsOne(), "memberSecurityAsOne");
    }
    public class EfpgMemberSecurityAsOne implements PropertyGateway {
        public Object read(Entity et) { return ((Member)et).getMemberSecurityAsOne(); }
        public void write(Entity et, Object vl) { ((Member)et).setMemberSecurityAsOne((MemberSecurity)vl); }
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
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, true, true, true, "INT", 10, 0, null, false, null, null, null, "followByYouIdList,followByMemberIdList,loginList,tweetList", null);
    protected final ColumnInfo _columnEmailAddress = cci("EMAIL_ADDRESS", "EMAIL_ADDRESS", null, null, String.class, "emailAddress", null, false, false, true, "VARCHAR", 100, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberStatusCode = cci("MEMBER_STATUS_CODE", "MEMBER_STATUS_CODE", null, null, Integer.class, "memberStatusCode", null, false, false, true, "INT", 10, 0, null, false, null, null, "memberStatus", null, null);
    protected final ColumnInfo _columnUserName = cci("USER_NAME", "USER_NAME", null, null, String.class, "userName", null, false, false, true, "VARCHAR", 100, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnAccountName = cci("ACCOUNT_NAME", "ACCOUNT_NAME", null, null, String.class, "accountName", null, false, false, true, "VARCHAR", 100, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnGroupName = cci("GROUP_NAME", "GROUP_NAME", null, null, String.class, "groupName", null, false, false, true, "VARCHAR", 100, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsDatetime = cci("INS_DATETIME", "INS_DATETIME", null, null, java.sql.Timestamp.class, "insDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdDatetime = cci("UPD_DATETIME", "UPD_DATETIME", null, null, java.sql.Timestamp.class, "updDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsTrace = cci("INS_TRACE", "INS_TRACE", null, null, String.class, "insTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdTrace = cci("UPD_TRACE", "UPD_TRACE", null, null, String.class, "updTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnRecruitingNumber = cci("RECRUITING_NUMBER", "RECRUITING_NUMBER", null, null, Integer.class, "recruitingNumber", null, false, false, false, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInterestedIndustry = cci("INTERESTED_INDUSTRY", "INTERESTED_INDUSTRY", null, null, String.class, "interestedIndustry", null, false, false, false, "VARCHAR", 100, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnGraduationYear = cci("GRADUATION_YEAR", "GRADUATION_YEAR", null, null, Integer.class, "graduationYear", null, false, false, false, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnBirthdate = cci("BIRTHDATE", "BIRTHDATE", null, null, java.util.Date.class, "birthdate", null, false, false, false, "DATE", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnProfile = cci("PROFILE", "PROFILE", null, null, String.class, "profile", null, false, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);

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
     * MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberStatusCode() { return _columnMemberStatusCode; }
    /**
     * USER_NAME: {UQ, NotNull, VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUserName() { return _columnUserName; }
    /**
     * ACCOUNT_NAME: {NotNull, VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAccountName() { return _columnAccountName; }
    /**
     * GROUP_NAME: {NotNull, VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnGroupName() { return _columnGroupName; }
    /**
     * INS_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnInsDatetime() { return _columnInsDatetime; }
    /**
     * UPD_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdDatetime() { return _columnUpdDatetime; }
    /**
     * INS_TRACE: {NotNull, VARCHAR(256)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnInsTrace() { return _columnInsTrace; }
    /**
     * UPD_TRACE: {NotNull, VARCHAR(256)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdTrace() { return _columnUpdTrace; }
    /**
     * RECRUITING_NUMBER: {INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRecruitingNumber() { return _columnRecruitingNumber; }
    /**
     * INTERESTED_INDUSTRY: {VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnInterestedIndustry() { return _columnInterestedIndustry; }
    /**
     * GRADUATION_YEAR: {INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnGraduationYear() { return _columnGraduationYear; }
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

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnEmailAddress());
        ls.add(columnMemberStatusCode());
        ls.add(columnUserName());
        ls.add(columnAccountName());
        ls.add(columnGroupName());
        ls.add(columnInsDatetime());
        ls.add(columnUpdDatetime());
        ls.add(columnInsTrace());
        ls.add(columnUpdTrace());
        ls.add(columnRecruitingNumber());
        ls.add(columnInterestedIndustry());
        ls.add(columnGraduationYear());
        ls.add(columnBirthdate());
        ls.add(columnProfile());
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
     * member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMemberStatus() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberStatusCode(), MemberStatusDbm.getInstance().columnMemberStatusCode());
        return cfi("member_ibfk_1", "memberStatus", this, MemberStatusDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "memberList");
    }
    /**
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return The information object of foreign property(referrer-as-one). (NotNull)
     */
    public ForeignInfo foreignMemberSecurityAsOne() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberSecurityDbm.getInstance().columnMemberId());
        return cfi("member_security_ibfk_1", "memberSecurityAsOne", this, MemberSecurityDbm.getInstance(), mp, 1, null, true, false, true, false, null, null, false, "member");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * follow by YOU_ID, named 'followByYouIdList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerFollowByYouIdList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), FollowDbm.getInstance().columnYouId());
        return cri("follow_ibfk_1", "followByYouIdList", this, FollowDbm.getInstance(), mp, false, "memberByYouId");
    }
    /**
     * follow by MEMBER_ID, named 'followByMemberIdList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerFollowByMemberIdList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), FollowDbm.getInstance().columnMemberId());
        return cri("follow_ibfk_2", "followByMemberIdList", this, FollowDbm.getInstance(), mp, false, "memberByMemberId");
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
