package org.dbflute.handson.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import org.seasar.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.handson.dbflute.allcommon.*;
import org.dbflute.handson.dbflute.exentity.customize.*;

/**
 * The DB meta of PartOfPurchaseMonthSummary. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PartOfPurchaseMonthSummaryDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PartOfPurchaseMonthSummaryDbm _instance = new PartOfPurchaseMonthSummaryDbm();
    private PartOfPurchaseMonthSummaryDbm() {}
    public static PartOfPurchaseMonthSummaryDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgMemberName(), "memberName");
        setupEpg(_epgMap, new EpgPurchaseMonth(), "purchaseMonth");
        setupEpg(_epgMap, new EpgPurchasePriceAverageMonth(), "purchasePriceAverageMonth");
        setupEpg(_epgMap, new EpgPurchaseCountSumMonth(), "purchaseCountSumMonth");
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((PartOfPurchaseMonthSummary)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((PartOfPurchaseMonthSummary)et).setMemberId(cti(vl)); }
    }
    public static class EpgMemberName implements PropertyGateway {
        public Object read(Entity et) { return ((PartOfPurchaseMonthSummary)et).getMemberName(); }
        public void write(Entity et, Object vl) { ((PartOfPurchaseMonthSummary)et).setMemberName((String)vl); }
    }
    public static class EpgPurchaseMonth implements PropertyGateway {
        public Object read(Entity et) { return ((PartOfPurchaseMonthSummary)et).getPurchaseMonth(); }
        public void write(Entity et, Object vl) { ((PartOfPurchaseMonthSummary)et).setPurchaseMonth(ctl(vl)); }
    }
    public static class EpgPurchasePriceAverageMonth implements PropertyGateway {
        public Object read(Entity et) { return ((PartOfPurchaseMonthSummary)et).getPurchasePriceAverageMonth(); }
        public void write(Entity et, Object vl) { ((PartOfPurchaseMonthSummary)et).setPurchasePriceAverageMonth(ctb(vl)); }
    }
    public static class EpgPurchaseCountSumMonth implements PropertyGateway {
        public Object read(Entity et) { return ((PartOfPurchaseMonthSummary)et).getPurchaseCountSumMonth(); }
        public void write(Entity et, Object vl) { ((PartOfPurchaseMonthSummary)et).setPurchaseCountSumMonth(ctb(vl)); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "PartOfPurchaseMonthSummary";
    protected final String _tablePropertyName = "partOfPurchaseMonthSummary";
    protected final TableSqlName _tableSqlName = new TableSqlName("PartOfPurchaseMonthSummary", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, "会員ID", Integer.class, "memberId", null, false, false, false, "INT", 11, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberName = cci("MEMBER_NAME", "MEMBER_NAME", null, "会員名称", String.class, "memberName", null, false, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPurchaseMonth = cci("PURCHASE_MONTH", "PURCHASE_MONTH", null, null, Long.class, "purchaseMonth", null, false, false, false, "BIGINT", 2, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPurchasePriceAverageMonth = cci("PURCHASE_PRICE_AVERAGE_MONTH", "PURCHASE_PRICE_AVERAGE_MONTH", null, null, java.math.BigDecimal.class, "purchasePriceAverageMonth", null, false, false, false, "DECIMAL", 14, 4, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPurchaseCountSumMonth = cci("PURCHASE_COUNT_SUM_MONTH", "PURCHASE_COUNT_SUM_MONTH", null, null, java.math.BigDecimal.class, "purchaseCountSumMonth", null, false, false, false, "DECIMAL", 32, 0, null, false, null, null, null, null, null);

    /**
     * (会員ID)MEMBER_ID: {INT(11), refers to member.MEMBER_ID}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * (会員名称)MEMBER_NAME: {VARCHAR(200), refers to member.MEMBER_NAME}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberName() { return _columnMemberName; }
    /**
     * PURCHASE_MONTH: {BIGINT(2)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchaseMonth() { return _columnPurchaseMonth; }
    /**
     * PURCHASE_PRICE_AVERAGE_MONTH: {DECIMAL(14, 4)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchasePriceAverageMonth() { return _columnPurchasePriceAverageMonth; }
    /**
     * PURCHASE_COUNT_SUM_MONTH: {DECIMAL(32)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchaseCountSumMonth() { return _columnPurchaseCountSumMonth; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnMemberName());
        ls.add(columnPurchaseMonth());
        ls.add(columnPurchasePriceAverageMonth());
        ls.add(columnPurchaseCountSumMonth());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        throw new UnsupportedOperationException("The table does not have primary key: " + getTableDbName());
    }
    public boolean hasPrimaryKey() { return false; }
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

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "org.dbflute.handson.dbflute.exentity.customize.PartOfPurchaseMonthSummary"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<PartOfPurchaseMonthSummary> getEntityType() { return PartOfPurchaseMonthSummary.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public PartOfPurchaseMonthSummary newEntity() { return new PartOfPurchaseMonthSummary(); }
    public PartOfPurchaseMonthSummary newMyEntity() { return new PartOfPurchaseMonthSummary(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((PartOfPurchaseMonthSummary)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((PartOfPurchaseMonthSummary)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
