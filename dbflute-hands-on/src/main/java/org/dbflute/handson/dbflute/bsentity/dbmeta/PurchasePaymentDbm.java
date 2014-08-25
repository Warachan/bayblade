package org.dbflute.handson.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import org.dbflute.handson.dbflute.allcommon.*;
import org.dbflute.handson.dbflute.exentity.*;

/**
 * The DB meta of purchase_payment. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class PurchasePaymentDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final PurchasePaymentDbm _instance = new PurchasePaymentDbm();
    private PurchasePaymentDbm() {}
    public static PurchasePaymentDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgPurchasePaymentId(), "purchasePaymentId");
        setupEpg(_epgMap, new EpgPurchaseId(), "purchaseId");
        setupEpg(_epgMap, new EpgPaymentAmount(), "paymentAmount");
        setupEpg(_epgMap, new EpgPaymentDatetime(), "paymentDatetime");
        setupEpg(_epgMap, new EpgPaymentMethodCode(), "paymentMethodCode");
        setupEpg(_epgMap, new EpgRegisterDatetime(), "registerDatetime");
        setupEpg(_epgMap, new EpgRegisterUser(), "registerUser");
        setupEpg(_epgMap, new EpgUpdateDatetime(), "updateDatetime");
        setupEpg(_epgMap, new EpgUpdateUser(), "updateUser");
    }
    public static class EpgPurchasePaymentId implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getPurchasePaymentId(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setPurchasePaymentId(ctl(vl)); }
    }
    public static class EpgPurchaseId implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getPurchaseId(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setPurchaseId(ctl(vl)); }
    }
    public static class EpgPaymentAmount implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getPaymentAmount(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setPaymentAmount(ctb(vl)); }
    }
    public static class EpgPaymentDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getPaymentDatetime(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setPaymentDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgPaymentMethodCode implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getPaymentMethodCode(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setPaymentMethodCode((String)vl); }
    }
    public static class EpgRegisterDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getRegisterDatetime(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setRegisterDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgRegisterUser implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getRegisterUser(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setRegisterUser((String)vl); }
    }
    public static class EpgUpdateDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getUpdateDatetime(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setUpdateDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdateUser implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getUpdateUser(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setUpdateUser((String)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgPurchase(), "purchase");
    }
    public class EfpgPurchase implements PropertyGateway {
        public Object read(Entity et) { return ((PurchasePayment)et).getPurchase(); }
        public void write(Entity et, Object vl) { ((PurchasePayment)et).setPurchase((Purchase)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "purchase_payment";
    protected final String _tablePropertyName = "purchasePayment";
    protected final TableSqlName _tableSqlName = new TableSqlName("purchase_payment", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnPurchasePaymentId = cci("PURCHASE_PAYMENT_ID", "PURCHASE_PAYMENT_ID", null, null, Long.class, "purchasePaymentId", null, true, true, true, "BIGINT", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPurchaseId = cci("PURCHASE_ID", "PURCHASE_ID", null, null, Long.class, "purchaseId", null, false, false, true, "BIGINT", 19, 0, null, false, null, null, "purchase", null, null);
    protected final ColumnInfo _columnPaymentAmount = cci("PAYMENT_AMOUNT", "PAYMENT_AMOUNT", null, null, java.math.BigDecimal.class, "paymentAmount", null, false, false, true, "DECIMAL", 10, 2, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPaymentDatetime = cci("PAYMENT_DATETIME", "PAYMENT_DATETIME", null, null, java.sql.Timestamp.class, "paymentDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPaymentMethodCode = cci("PAYMENT_METHOD_CODE", "PAYMENT_METHOD_CODE", null, null, String.class, "paymentMethodCode", null, false, false, true, "CHAR", 3, 0, null, false, null, null, null, null, CDef.DefMeta.PaymentMethod);
    protected final ColumnInfo _columnRegisterDatetime = cci("REGISTER_DATETIME", "REGISTER_DATETIME", null, null, java.sql.Timestamp.class, "registerDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnRegisterUser = cci("REGISTER_USER", "REGISTER_USER", null, null, String.class, "registerUser", null, false, false, true, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateDatetime = cci("UPDATE_DATETIME", "UPDATE_DATETIME", null, null, java.sql.Timestamp.class, "updateDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdateUser = cci("UPDATE_USER", "UPDATE_USER", null, null, String.class, "updateUser", null, false, false, true, "VARCHAR", 200, 0, null, false, null, null, null, null, null);

    /**
     * PURCHASE_PAYMENT_ID: {PK, ID, NotNull, BIGINT(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchasePaymentId() { return _columnPurchasePaymentId; }
    /**
     * PURCHASE_ID: {IX, NotNull, BIGINT(19), FK to purchase}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchaseId() { return _columnPurchaseId; }
    /**
     * PAYMENT_AMOUNT: {NotNull, DECIMAL(10, 2)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPaymentAmount() { return _columnPaymentAmount; }
    /**
     * PAYMENT_DATETIME: {IX+, NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPaymentDatetime() { return _columnPaymentDatetime; }
    /**
     * PAYMENT_METHOD_CODE: {NotNull, CHAR(3), classification=PaymentMethod}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPaymentMethodCode() { return _columnPaymentMethodCode; }
    /**
     * REGISTER_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterDatetime() { return _columnRegisterDatetime; }
    /**
     * REGISTER_USER: {NotNull, VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnRegisterUser() { return _columnRegisterUser; }
    /**
     * UPDATE_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateDatetime() { return _columnUpdateDatetime; }
    /**
     * UPDATE_USER: {NotNull, VARCHAR(200)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUpdateUser() { return _columnUpdateUser; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnPurchasePaymentId());
        ls.add(columnPurchaseId());
        ls.add(columnPaymentAmount());
        ls.add(columnPaymentDatetime());
        ls.add(columnPaymentMethodCode());
        ls.add(columnRegisterDatetime());
        ls.add(columnRegisterUser());
        ls.add(columnUpdateDatetime());
        ls.add(columnUpdateUser());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnPurchasePaymentId()); }
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
     * purchase by my PURCHASE_ID, named 'purchase'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignPurchase() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnPurchaseId(), PurchaseDbm.getInstance().columnPurchaseId());
        return cfi("FK_PURCHASE_PAYMENT_PURCHASE", "purchase", this, PurchaseDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "purchasePaymentList");
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
    public String getEntityTypeName() { return "org.dbflute.handson.dbflute.exentity.PurchasePayment"; }
    public String getConditionBeanTypeName() { return "org.dbflute.handson.dbflute.cbean.PurchasePaymentCB"; }
    public String getBehaviorTypeName() { return "org.dbflute.handson.dbflute.exbhv.PurchasePaymentBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<PurchasePayment> getEntityType() { return PurchasePayment.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public PurchasePayment newEntity() { return new PurchasePayment(); }
    public PurchasePayment newMyEntity() { return new PurchasePayment(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((PurchasePayment)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((PurchasePayment)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
