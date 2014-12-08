package org.dbflute.handson.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import org.dbflute.handson.dbflute.allcommon.*;
import org.dbflute.handson.dbflute.exentity.customize.*;

/**
 * The DB meta of OutsideMember. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class OutsideMemberDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final OutsideMemberDbm _instance = new OutsideMemberDbm();
    private OutsideMemberDbm() {}
    public static OutsideMemberDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgBirthdate(), "birthdate");
        setupEpg(_epgMap, new EpgMemberStatusCode(), "memberStatusCode");
        setupEpg(_epgMap, new EpgAkirakaniOkashiiKaramuMei(), "akirakaniOkashiiKaramuMei");
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((OutsideMember)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((OutsideMember)et).setMemberId(cti(vl)); }
    }
    public static class EpgMemberName implements PropertyGateway {
        public Object read(Entity et) { return ((OutsideMember)et).getMemberName(); }
        public void write(Entity et, Object vl) { ((OutsideMember)et).setMemberName((String)vl); }
    }
    public static class EpgBirthdate implements PropertyGateway {
        public Object read(Entity et) { return ((OutsideMember)et).getBirthdate(); }
        public void write(Entity et, Object vl) { ((OutsideMember)et).setBirthdate((java.util.Date)vl); }
    }
    public class EpgMemberStatusCode implements PropertyGateway {
        public Object read(Entity et) { return ((OutsideMember)et).getMemberStatusCode(); }
        public void write(Entity et, Object vl) {
            ColumnInfo col = columnMemberStatusCode();
            ccls(col, vl);
            CDef.MemberStatus cls = (CDef.MemberStatus)gcls(col, vl);
            if (cls != null) {
                ((OutsideMember)et).setMemberStatusCodeAsMemberStatus(cls);
            } else {
                ((OutsideMember)et).mynativeMappingMemberStatusCode((String)vl);
            }
        }
    }
    public static class EpgAkirakaniOkashiiKaramuMei implements PropertyGateway {
        public Object read(Entity et) { return ((OutsideMember)et).getAkirakaniOkashiiKaramuMei(); }
        public void write(Entity et, Object vl) { ((OutsideMember)et).setAkirakaniOkashiiKaramuMei(cti(vl)); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "OutsideMember";
    protected final String _tablePropertyName = "outsideMember";
    protected final TableSqlName _tableSqlName = new TableSqlName("OutsideMember", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("member_id", "member_id", null, "会員ID", Integer.class, "memberId", null, false, false, false, "INT", 11, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberName = cci("member_name", "member_name", null, "会員名称", String.class, "memberName", null, false, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnBirthdate = cci("birthdate", "birthdate", null, "生年月日", java.util.Date.class, "birthdate", null, false, false, false, "DATE", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberStatusCode = cci("member_status_code", "member_status_code", null, "会員ステータスコード", String.class, "memberStatusCode", null, false, false, false, "CHAR", 3, 0, null, false, null, null, null, null, CDef.DefMeta.MemberStatus);
    protected final ColumnInfo _columnAkirakaniOkashiiKaramuMei = cci("AKIRAKANI_OKASHII_KARAMU_MEI", "AKIRAKANI_OKASHII_KARAMU_MEI", null, "サービスポイント数", Integer.class, "akirakaniOkashiiKaramuMei", null, false, false, false, "INT", 11, 0, null, false, null, null, null, null, null);

    /**
     * (会員ID)member_id: {INT(11), refers to member.MEMBER_ID}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * (会員名称)member_name: {VARCHAR(200), refers to member.MEMBER_NAME}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberName() { return _columnMemberName; }
    /**
     * (生年月日)birthdate: {DATE(10), refers to member.BIRTHDATE}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnBirthdate() { return _columnBirthdate; }
    /**
     * (会員ステータスコード)member_status_code: {CHAR(3), refers to member.MEMBER_STATUS_CODE, classification=MemberStatus}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberStatusCode() { return _columnMemberStatusCode; }
    /**
     * (サービスポイント数)AKIRAKANI_OKASHII_KARAMU_MEI: {INT(11), refers to member_service.AKIRAKANI_OKASHII_KARAMU_MEI}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnAkirakaniOkashiiKaramuMei() { return _columnAkirakaniOkashiiKaramuMei; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnMemberName());
        ls.add(columnBirthdate());
        ls.add(columnMemberStatusCode());
        ls.add(columnAkirakaniOkashiiKaramuMei());
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
    public String getEntityTypeName() { return "org.dbflute.handson.dbflute.exentity.customize.OutsideMember"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<OutsideMember> getEntityType() { return OutsideMember.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public OutsideMember newEntity() { return new OutsideMember(); }
    public OutsideMember newMyEntity() { return new OutsideMember(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((OutsideMember)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((OutsideMember)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
