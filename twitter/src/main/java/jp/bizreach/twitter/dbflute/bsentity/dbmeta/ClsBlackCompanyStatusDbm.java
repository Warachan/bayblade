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
 * The DB meta of cls_black_company_status. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class ClsBlackCompanyStatusDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final ClsBlackCompanyStatusDbm _instance = new ClsBlackCompanyStatusDbm();
    private ClsBlackCompanyStatusDbm() {}
    public static ClsBlackCompanyStatusDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgBlackCompanyStatusCd(), "blackCompanyStatusCd");
        setupEpg(_epgMap, new EpgCodeName(), "codeName");
        setupEpg(_epgMap, new EpgCodeAlias(), "codeAlias");
        setupEpg(_epgMap, new EpgCodeDisplayNo(), "codeDisplayNo");
        setupEpg(_epgMap, new EpgCodeComment(), "codeComment");
        setupEpg(_epgMap, new EpgCodeAliasEn(), "codeAliasEn");
    }
    public static class EpgBlackCompanyStatusCd implements PropertyGateway {
        public Object read(Entity et) { return ((ClsBlackCompanyStatus)et).getBlackCompanyStatusCd(); }
        public void write(Entity et, Object vl) { ((ClsBlackCompanyStatus)et).setBlackCompanyStatusCd((String)vl); }
    }
    public static class EpgCodeName implements PropertyGateway {
        public Object read(Entity et) { return ((ClsBlackCompanyStatus)et).getCodeName(); }
        public void write(Entity et, Object vl) { ((ClsBlackCompanyStatus)et).setCodeName((String)vl); }
    }
    public static class EpgCodeAlias implements PropertyGateway {
        public Object read(Entity et) { return ((ClsBlackCompanyStatus)et).getCodeAlias(); }
        public void write(Entity et, Object vl) { ((ClsBlackCompanyStatus)et).setCodeAlias((String)vl); }
    }
    public static class EpgCodeDisplayNo implements PropertyGateway {
        public Object read(Entity et) { return ((ClsBlackCompanyStatus)et).getCodeDisplayNo(); }
        public void write(Entity et, Object vl) { ((ClsBlackCompanyStatus)et).setCodeDisplayNo(cti(vl)); }
    }
    public static class EpgCodeComment implements PropertyGateway {
        public Object read(Entity et) { return ((ClsBlackCompanyStatus)et).getCodeComment(); }
        public void write(Entity et, Object vl) { ((ClsBlackCompanyStatus)et).setCodeComment((String)vl); }
    }
    public static class EpgCodeAliasEn implements PropertyGateway {
        public Object read(Entity et) { return ((ClsBlackCompanyStatus)et).getCodeAliasEn(); }
        public void write(Entity et, Object vl) { ((ClsBlackCompanyStatus)et).setCodeAliasEn((String)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "cls_black_company_status";
    protected final String _tablePropertyName = "clsBlackCompanyStatus";
    protected final TableSqlName _tableSqlName = new TableSqlName("cls_black_company_status", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnBlackCompanyStatusCd = cci("BLACK_COMPANY_STATUS_CD", "BLACK_COMPANY_STATUS_CD", null, null, String.class, "blackCompanyStatusCd", null, true, false, true, "CHAR", 3, 0, null, false, null, null, null, "blackCompanyList", null);
    protected final ColumnInfo _columnCodeName = cci("CODE_NAME", "CODE_NAME", null, null, String.class, "codeName", null, false, false, true, "VARCHAR", 30, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnCodeAlias = cci("CODE_ALIAS", "CODE_ALIAS", null, null, String.class, "codeAlias", null, false, false, true, "VARCHAR", 50, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnCodeDisplayNo = cci("CODE_DISPLAY_NO", "CODE_DISPLAY_NO", null, null, Integer.class, "codeDisplayNo", null, false, false, true, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnCodeComment = cci("CODE_COMMENT", "CODE_COMMENT", null, null, String.class, "codeComment", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnCodeAliasEn = cci("CODE_ALIAS_EN", "CODE_ALIAS_EN", null, null, String.class, "codeAliasEn", null, false, false, true, "VARCHAR", 50, 0, null, false, null, null, null, null, null);

    /**
     * BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBlackCompanyStatusCd() { return _columnBlackCompanyStatusCd; }
    /**
     * CODE_NAME: {NotNull, VARCHAR(30)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCodeName() { return _columnCodeName; }
    /**
     * CODE_ALIAS: {NotNull, VARCHAR(50)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCodeAlias() { return _columnCodeAlias; }
    /**
     * CODE_DISPLAY_NO: {NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCodeDisplayNo() { return _columnCodeDisplayNo; }
    /**
     * CODE_COMMENT: {NotNull, VARCHAR(256)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCodeComment() { return _columnCodeComment; }
    /**
     * CODE_ALIAS_EN: {NotNull, VARCHAR(50)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnCodeAliasEn() { return _columnCodeAliasEn; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnBlackCompanyStatusCd());
        ls.add(columnCodeName());
        ls.add(columnCodeAlias());
        ls.add(columnCodeDisplayNo());
        ls.add(columnCodeComment());
        ls.add(columnCodeAliasEn());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnBlackCompanyStatusCd()); }
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

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------
    /**
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyList'.
     * @return The information object of referrer property. (NotNull)
     */
    public ReferrerInfo referrerBlackCompanyList() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnBlackCompanyStatusCd(), BlackCompanyDbm.getInstance().columnBlackCompanyStatusCd());
        return cri("black_company_ibfk_1", "blackCompanyList", this, BlackCompanyDbm.getInstance(), mp, false, "clsBlackCompanyStatus");
    }

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.ClsBlackCompanyStatus"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.ClsBlackCompanyStatusCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.ClsBlackCompanyStatusBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<ClsBlackCompanyStatus> getEntityType() { return ClsBlackCompanyStatus.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public ClsBlackCompanyStatus newMyEntity() { return new ClsBlackCompanyStatus(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((ClsBlackCompanyStatus)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((ClsBlackCompanyStatus)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
