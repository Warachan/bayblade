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
 * The DB meta of login. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class LoginDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final LoginDbm _instance = new LoginDbm();
    private LoginDbm() {}
    public static LoginDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgLoginId(), "loginId");
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgInsDatetime(), "insDatetime");
        setupEpg(_epgMap, new EpgUpdDatetime(), "updDatetime");
        setupEpg(_epgMap, new EpgInsTrace(), "insTrace");
        setupEpg(_epgMap, new EpgUpdTrace(), "updTrace");
    }
    public static class EpgLoginId implements PropertyGateway {
        public Object read(Entity et) { return ((Login)et).getLoginId(); }
        public void write(Entity et, Object vl) { ((Login)et).setLoginId(cti(vl)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((Login)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((Login)et).setMemberId(cti(vl)); }
    }
    public static class EpgInsDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Login)et).getInsDatetime(); }
        public void write(Entity et, Object vl) { ((Login)et).setInsDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Login)et).getUpdDatetime(); }
        public void write(Entity et, Object vl) { ((Login)et).setUpdDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgInsTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Login)et).getInsTrace(); }
        public void write(Entity et, Object vl) { ((Login)et).setInsTrace((String)vl); }
    }
    public static class EpgUpdTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Login)et).getUpdTrace(); }
        public void write(Entity et, Object vl) { ((Login)et).setUpdTrace((String)vl); }
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
        public Object read(Entity et) { return ((Login)et).getMember(); }
        public void write(Entity et, Object vl) { ((Login)et).setMember((Member)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "login";
    protected final String _tablePropertyName = "login";
    protected final TableSqlName _tableSqlName = new TableSqlName("login", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnLoginId = cci("LOGIN_ID", "LOGIN_ID", null, null, Integer.class, "loginId", null, true, true, true, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, false, false, true, "INT", 10, 0, null, false, null, null, "member", null, null);
    protected final ColumnInfo _columnInsDatetime = cci("INS_DATETIME", "INS_DATETIME", null, null, java.sql.Timestamp.class, "insDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdDatetime = cci("UPD_DATETIME", "UPD_DATETIME", null, null, java.sql.Timestamp.class, "updDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsTrace = cci("INS_TRACE", "INS_TRACE", null, null, String.class, "insTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdTrace = cci("UPD_TRACE", "UPD_TRACE", null, null, String.class, "updTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);

    /**
     * LOGIN_ID: {PK, ID, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnLoginId() { return _columnLoginId; }
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

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnLoginId());
        ls.add(columnMemberId());
        ls.add(columnInsDatetime());
        ls.add(columnUpdDatetime());
        ls.add(columnInsTrace());
        ls.add(columnUpdTrace());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnLoginId()); }
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
        return cfi("login_ibfk_1", "member", this, MemberDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "loginList");
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
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.Login"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.LoginCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.LoginBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Login> getEntityType() { return Login.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Login newEntity() { return new Login(); }
    public Login newMyEntity() { return new Login(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Login)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Login)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
