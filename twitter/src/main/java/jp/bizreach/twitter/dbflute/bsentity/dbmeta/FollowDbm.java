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
 * The DB meta of follow. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class FollowDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final FollowDbm _instance = new FollowDbm();
    private FollowDbm() {}
    public static FollowDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgFollowId(), "followId");
        setupEpg(_epgMap, new EpgYouId(), "youId");
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgInsDatetime(), "insDatetime");
        setupEpg(_epgMap, new EpgUpdDatetime(), "updDatetime");
        setupEpg(_epgMap, new EpgInsTrace(), "insTrace");
        setupEpg(_epgMap, new EpgUpdTrace(), "updTrace");
        setupEpg(_epgMap, new EpgDelFlg(), "delFlg");
    }
    public static class EpgFollowId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getFollowId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setFollowId(cti(vl)); }
    }
    public static class EpgYouId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getYouId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setYouId(cti(vl)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setMemberId(cti(vl)); }
    }
    public static class EpgInsDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getInsDatetime(); }
        public void write(Entity et, Object vl) { ((Follow)et).setInsDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getUpdDatetime(); }
        public void write(Entity et, Object vl) { ((Follow)et).setUpdDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgInsTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getInsTrace(); }
        public void write(Entity et, Object vl) { ((Follow)et).setInsTrace((String)vl); }
    }
    public static class EpgUpdTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getUpdTrace(); }
        public void write(Entity et, Object vl) { ((Follow)et).setUpdTrace((String)vl); }
    }
    public static class EpgDelFlg implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getDelFlg(); }
        public void write(Entity et, Object vl) { ((Follow)et).setDelFlg((String)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgMemberByMemberId(), "memberByMemberId");
        setupEfpg(_efpgMap, new EfpgMemberByYouId(), "memberByYouId");
    }
    public class EfpgMemberByMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getMemberByMemberId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setMemberByMemberId((Member)vl); }
    }
    public class EfpgMemberByYouId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getMemberByYouId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setMemberByYouId((Member)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "follow";
    protected final String _tablePropertyName = "follow";
    protected final TableSqlName _tableSqlName = new TableSqlName("follow", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnFollowId = cci("FOLLOW_ID", "FOLLOW_ID", null, null, Integer.class, "followId", null, true, true, true, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnYouId = cci("YOU_ID", "YOU_ID", null, null, Integer.class, "youId", null, false, false, true, "INT", 10, 0, null, false, null, null, "memberByYouId", null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, false, false, true, "INT", 10, 0, null, false, null, null, "memberByMemberId", null, null);
    protected final ColumnInfo _columnInsDatetime = cci("INS_DATETIME", "INS_DATETIME", null, null, java.sql.Timestamp.class, "insDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdDatetime = cci("UPD_DATETIME", "UPD_DATETIME", null, null, java.sql.Timestamp.class, "updDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsTrace = cci("INS_TRACE", "INS_TRACE", null, null, String.class, "insTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdTrace = cci("UPD_TRACE", "UPD_TRACE", null, null, String.class, "updTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnDelFlg = cci("DEL_FLG", "DEL_FLG", null, null, String.class, "delFlg", null, false, false, true, "CHAR", 1, 0, "N", false, null, null, null, null, null);

    /**
     * FOLLOW_ID: {PK, ID, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFollowId() { return _columnFollowId; }
    /**
     * YOU_ID: {UQ, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnYouId() { return _columnYouId; }
    /**
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
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
     * DEL_FLG: {NotNull, CHAR(1), default=[N]}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnDelFlg() { return _columnDelFlg; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnFollowId());
        ls.add(columnYouId());
        ls.add(columnMemberId());
        ls.add(columnInsDatetime());
        ls.add(columnUpdDatetime());
        ls.add(columnInsTrace());
        ls.add(columnUpdTrace());
        ls.add(columnDelFlg());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnFollowId()); }
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
     * member by my MEMBER_ID, named 'memberByMemberId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMemberByMemberId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("follow_ibfk_1", "memberByMemberId", this, MemberDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "followByMemberIdList");
    }
    /**
     * member by my YOU_ID, named 'memberByYouId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMemberByYouId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnYouId(), MemberDbm.getInstance().columnMemberId());
        return cfi("follow_ibfk_2", "memberByYouId", this, MemberDbm.getInstance(), mp, 1, null, true, false, false, false, null, null, false, "followByYouIdAsOne");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.Follow"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.FollowCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.FollowBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Follow> getEntityType() { return Follow.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Follow newEntity() { return new Follow(); }
    public Follow newMyEntity() { return new Follow(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Follow)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Follow)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
