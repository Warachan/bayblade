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
 * The DB meta of member_withdraw. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MemberWithdrawDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MemberWithdrawDbm _instance = new MemberWithdrawDbm();
    private MemberWithdrawDbm() {}
    public static MemberWithdrawDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgWithdrawalReasonId(), "withdrawalReasonId");
        setupEpg(_epgMap, new EpgWithdrawalReasonInputText(), "withdrawalReasonInputText");
        setupEpg(_epgMap, new EpgWithdrawalDatetime(), "withdrawalDatetime");
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((MemberWithdraw)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((MemberWithdraw)et).setMemberId(cti(vl)); }
    }
    public static class EpgWithdrawalReasonId implements PropertyGateway {
        public Object read(Entity et) { return ((MemberWithdraw)et).getWithdrawalReasonId(); }
        public void write(Entity et, Object vl) { ((MemberWithdraw)et).setWithdrawalReasonId(cti(vl)); }
    }
    public static class EpgWithdrawalReasonInputText implements PropertyGateway {
        public Object read(Entity et) { return ((MemberWithdraw)et).getWithdrawalReasonInputText(); }
        public void write(Entity et, Object vl) { ((MemberWithdraw)et).setWithdrawalReasonInputText((String)vl); }
    }
    public static class EpgWithdrawalDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((MemberWithdraw)et).getWithdrawalDatetime(); }
        public void write(Entity et, Object vl) { ((MemberWithdraw)et).setWithdrawalDatetime((java.sql.Timestamp)vl); }
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
        public Object read(Entity et) { return ((MemberWithdraw)et).getMember(); }
        public void write(Entity et, Object vl) { ((MemberWithdraw)et).setMember((Member)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "member_withdraw";
    protected final String _tablePropertyName = "memberWithdraw";
    protected final TableSqlName _tableSqlName = new TableSqlName("member_withdraw", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, true, false, true, "INT", 10, 0, null, false, null, null, "member", null, null);
    protected final ColumnInfo _columnWithdrawalReasonId = cci("WITHDRAWAL_REASON_ID", "WITHDRAWAL_REASON_ID", null, null, Integer.class, "withdrawalReasonId", null, false, false, false, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnWithdrawalReasonInputText = cci("WITHDRAWAL_REASON_INPUT_TEXT", "WITHDRAWAL_REASON_INPUT_TEXT", null, null, String.class, "withdrawalReasonInputText", null, false, false, false, "TEXT", 65535, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnWithdrawalDatetime = cci("WITHDRAWAL_DATETIME", "WITHDRAWAL_DATETIME", null, null, java.sql.Timestamp.class, "withdrawalDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);

    /**
     * MEMBER_ID: {PK, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * WITHDRAWAL_REASON_ID: {INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnWithdrawalReasonId() { return _columnWithdrawalReasonId; }
    /**
     * WITHDRAWAL_REASON_INPUT_TEXT: {TEXT(65535)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnWithdrawalReasonInputText() { return _columnWithdrawalReasonInputText; }
    /**
     * WITHDRAWAL_DATETIME: {NotNull, DATETIME(19)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnWithdrawalDatetime() { return _columnWithdrawalDatetime; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnWithdrawalReasonId());
        ls.add(columnWithdrawalReasonInputText());
        ls.add(columnWithdrawalDatetime());
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
     * member by my MEMBER_ID, named 'member'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMember() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnMemberId(), MemberDbm.getInstance().columnMemberId());
        return cfi("member_withdraw_ibfk_1", "member", this, MemberDbm.getInstance(), mp, 0, null, true, false, false, false, null, null, false, "memberWithdrawAsOne");
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
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.MemberWithdraw"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.MemberWithdrawCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.MemberWithdrawBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<MemberWithdraw> getEntityType() { return MemberWithdraw.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public MemberWithdraw newEntity() { return new MemberWithdraw(); }
    public MemberWithdraw newMyEntity() { return new MemberWithdraw(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((MemberWithdraw)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((MemberWithdraw)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
