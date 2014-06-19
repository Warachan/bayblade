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
 * The DB meta of black_company. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class BlackCompanyDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final BlackCompanyDbm _instance = new BlackCompanyDbm();
    private BlackCompanyDbm() {}
    public static BlackCompanyDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgBlackCompanyId(), "blackCompanyId");
        setupEpg(_epgMap, new EpgBlackCompanyName(), "blackCompanyName");
        setupEpg(_epgMap, new EpgAgentCompanyName(), "agentCompanyName");
        setupEpg(_epgMap, new EpgZipCode(), "zipCode");
        setupEpg(_epgMap, new EpgAddress1(), "address1");
        setupEpg(_epgMap, new EpgAddress2(), "address2");
        setupEpg(_epgMap, new EpgBlackCompanyStatusCd(), "blackCompanyStatusCd");
        setupEpg(_epgMap, new EpgInsDatetime(), "insDatetime");
        setupEpg(_epgMap, new EpgUpdDatetime(), "updDatetime");
        setupEpg(_epgMap, new EpgInsTrace(), "insTrace");
        setupEpg(_epgMap, new EpgUpdTrace(), "updTrace");
        setupEpg(_epgMap, new EpgVersionNo(), "versionNo");
    }
    public static class EpgBlackCompanyId implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getBlackCompanyId(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setBlackCompanyId(ctl(vl)); }
    }
    public static class EpgBlackCompanyName implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getBlackCompanyName(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setBlackCompanyName((String)vl); }
    }
    public static class EpgAgentCompanyName implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getAgentCompanyName(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setAgentCompanyName((String)vl); }
    }
    public static class EpgZipCode implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getZipCode(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setZipCode((String)vl); }
    }
    public static class EpgAddress1 implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getAddress1(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setAddress1((String)vl); }
    }
    public static class EpgAddress2 implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getAddress2(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setAddress2((String)vl); }
    }
    public static class EpgBlackCompanyStatusCd implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getBlackCompanyStatusCd(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setBlackCompanyStatusCd((String)vl); }
    }
    public static class EpgInsDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getInsDatetime(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setInsDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getUpdDatetime(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setUpdDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgInsTrace implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getInsTrace(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setInsTrace((String)vl); }
    }
    public static class EpgUpdTrace implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getUpdTrace(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setUpdTrace((String)vl); }
    }
    public static class EpgVersionNo implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getVersionNo(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setVersionNo(ctl(vl)); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgClsBlackCompanyStatus(), "clsBlackCompanyStatus");
    }
    public class EfpgClsBlackCompanyStatus implements PropertyGateway {
        public Object read(Entity et) { return ((BlackCompany)et).getClsBlackCompanyStatus(); }
        public void write(Entity et, Object vl) { ((BlackCompany)et).setClsBlackCompanyStatus((ClsBlackCompanyStatus)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "black_company";
    protected final String _tablePropertyName = "blackCompany";
    protected final TableSqlName _tableSqlName = new TableSqlName("black_company", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnBlackCompanyId = cci("BLACK_COMPANY_ID", "BLACK_COMPANY_ID", null, null, Long.class, "blackCompanyId", null, true, true, true, "BIGINT", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnBlackCompanyName = cci("BLACK_COMPANY_NAME", "BLACK_COMPANY_NAME", null, null, String.class, "blackCompanyName", null, false, false, true, "VARCHAR", 128, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnAgentCompanyName = cci("AGENT_COMPANY_NAME", "AGENT_COMPANY_NAME", null, null, String.class, "agentCompanyName", null, false, false, false, "VARCHAR", 128, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnZipCode = cci("ZIP_CODE", "ZIP_CODE", null, null, String.class, "zipCode", null, false, false, true, "VARCHAR", 32, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnAddress1 = cci("ADDRESS1", "ADDRESS1", null, null, String.class, "address1", null, false, false, true, "VARCHAR", 1024, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnAddress2 = cci("ADDRESS2", "ADDRESS2", null, null, String.class, "address2", null, false, false, false, "VARCHAR", 1024, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnBlackCompanyStatusCd = cci("BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", null, null, String.class, "blackCompanyStatusCd", null, false, false, true, "CHAR", 3, 0, null, false, null, null, "clsBlackCompanyStatus", null, null);
    protected final ColumnInfo _columnInsDatetime = cci("INS_DATETIME", "INS_DATETIME", null, null, java.sql.Timestamp.class, "insDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdDatetime = cci("UPD_DATETIME", "UPD_DATETIME", null, null, java.sql.Timestamp.class, "updDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsTrace = cci("INS_TRACE", "INS_TRACE", null, null, String.class, "insTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdTrace = cci("UPD_TRACE", "UPD_TRACE", null, null, String.class, "updTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnVersionNo = cci("VERSION_NO", "VERSION_NO", null, null, Long.class, "versionNo", null, false, false, true, "BIGINT", 19, 0, null, false, OptimisticLockType.VERSION_NO, null, null, null, null);

    /**
     * BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBlackCompanyId() { return _columnBlackCompanyId; }
    /**
     * BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBlackCompanyName() { return _columnBlackCompanyName; }
    /**
     * AGENT_COMPANY_NAME: {VARCHAR(128)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAgentCompanyName() { return _columnAgentCompanyName; }
    /**
     * ZIP_CODE: {NotNull, VARCHAR(32)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnZipCode() { return _columnZipCode; }
    /**
     * ADDRESS1: {NotNull, VARCHAR(1024)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAddress1() { return _columnAddress1; }
    /**
     * ADDRESS2: {VARCHAR(1024)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAddress2() { return _columnAddress2; }
    /**
     * BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBlackCompanyStatusCd() { return _columnBlackCompanyStatusCd; }
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
     * VERSION_NO: {NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnVersionNo() { return _columnVersionNo; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnBlackCompanyId());
        ls.add(columnBlackCompanyName());
        ls.add(columnAgentCompanyName());
        ls.add(columnZipCode());
        ls.add(columnAddress1());
        ls.add(columnAddress2());
        ls.add(columnBlackCompanyStatusCd());
        ls.add(columnInsDatetime());
        ls.add(columnUpdDatetime());
        ls.add(columnInsTrace());
        ls.add(columnUpdTrace());
        ls.add(columnVersionNo());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnBlackCompanyId()); }
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
     * cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignClsBlackCompanyStatus() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnBlackCompanyStatusCd(), ClsBlackCompanyStatusDbm.getInstance().columnBlackCompanyStatusCd());
        return cfi("black_company_ibfk_1", "clsBlackCompanyStatus", this, ClsBlackCompanyStatusDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "blackCompanyList");
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============
    public boolean hasIdentity() { return true; }
    public boolean hasVersionNo() { return true; }
    public ColumnInfo getVersionNoColumnInfo() { return _columnVersionNo; }

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.BlackCompany"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.BlackCompanyCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.BlackCompanyBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<BlackCompany> getEntityType() { return BlackCompany.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public BlackCompany newMyEntity() { return new BlackCompany(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((BlackCompany)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((BlackCompany)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
