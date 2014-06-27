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
 * The DB meta of followers. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class FollowersDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final FollowersDbm _instance = new FollowersDbm();
    private FollowersDbm() {}
    public static FollowersDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgFollowersid(), "followersid");
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
    }
    public static class EpgFollowersid implements PropertyGateway {
        public Object read(Entity et) { return ((Followers)et).getFollowersid(); }
        public void write(Entity et, Object vl) { ((Followers)et).setFollowersid(cti(vl)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((Followers)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((Followers)et).setMemberId(cti(vl)); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgMember(), "member");
    }
    public class EfpgMember implements PropertyGateway {
        public Object read(Entity et) { return ((Followers)et).getMember(); }
        public void write(Entity et, Object vl) { ((Followers)et).setMember((Member)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "followers";
    protected final String _tablePropertyName = "followers";
    protected final TableSqlName _tableSqlName = new TableSqlName("followers", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnFollowersid = cci("FOLLOWERSID", "FOLLOWERSID", null, null, Integer.class, "followersid", null, true, false, true, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, false, false, true, "INT", 10, 0, null, false, null, null, "member", null, null);

    /**
     * FOLLOWERSID: {PK, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFollowersid() { return _columnFollowersid; }
    /**
     * MEMBER_ID: {UQ, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnFollowersid());
        ls.add(columnMemberId());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnFollowersid()); }
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
     * member by my MEMBER_ID, named 'member'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMember() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("followers_ibfk_1", "member", this, MemberDbm.getInstance(), mp, 0, null, true, false, false, false, null, null, false, "followersAsOne");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.Followers"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.FollowersCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.FollowersBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Followers> getEntityType() { return Followers.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Followers newEntity() { return new Followers(); }
    public Followers newMyEntity() { return new Followers(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Followers)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Followers)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
