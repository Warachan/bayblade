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
        setupEpg(_epgMap, new EpgMeId(), "meId");
        setupEpg(_epgMap, new EpgFollowDatetime(), "followDatetime");
    }
    public static class EpgFollowId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getFollowId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setFollowId(cti(vl)); }
    }
    public static class EpgYouId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getYouId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setYouId(cti(vl)); }
    }
    public static class EpgMeId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getMeId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setMeId(cti(vl)); }
    }
    public static class EpgFollowDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getFollowDatetime(); }
        public void write(Entity et, Object vl) { ((Follow)et).setFollowDatetime((java.sql.Timestamp)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgMemberByMeId(), "memberByMeId");
        setupEfpg(_efpgMap, new EfpgMemberByYouId(), "memberByYouId");
    }
    public class EfpgMemberByMeId implements PropertyGateway {
        public Object read(Entity et) { return ((Follow)et).getMemberByMeId(); }
        public void write(Entity et, Object vl) { ((Follow)et).setMemberByMeId((Member)vl); }
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
    protected final ColumnInfo _columnMeId = cci("ME_ID", "ME_ID", null, null, Integer.class, "meId", null, false, false, true, "INT", 10, 0, null, false, null, null, "memberByMeId", null, null);
    protected final ColumnInfo _columnFollowDatetime = cci("FOLLOW_DATETIME", "FOLLOW_DATETIME", null, null, java.sql.Timestamp.class, "followDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);

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
     * ME_ID: {IX, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMeId() { return _columnMeId; }
    /**
     * FOLLOW_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFollowDatetime() { return _columnFollowDatetime; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnFollowId());
        ls.add(columnYouId());
        ls.add(columnMeId());
        ls.add(columnFollowDatetime());
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
     * member by my ME_ID, named 'memberByMeId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMemberByMeId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMeId(), MemberDbm.getInstance().columnMemberId());
        return cfi("follow_ibfk_1", "memberByMeId", this, MemberDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "followByMeIdList");
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
