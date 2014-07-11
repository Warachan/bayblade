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
 * The DB meta of message. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class MessageDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final MessageDbm _instance = new MessageDbm();
    private MessageDbm() {}
    public static MessageDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgMessageId(), "messageId");
        setupEpg(_epgMap, new EpgSenderId(), "senderId");
        setupEpg(_epgMap, new EpgReceiverId(), "receiverId");
        setupEpg(_epgMap, new EpgMessageTime(), "messageTime");
        setupEpg(_epgMap, new EpgMessage(), "message");
        setupEpg(_epgMap, new EpgInsDatetime(), "insDatetime");
        setupEpg(_epgMap, new EpgUpdDatetime(), "updDatetime");
        setupEpg(_epgMap, new EpgInsTrace(), "insTrace");
        setupEpg(_epgMap, new EpgUpdTrace(), "updTrace");
    }
    public static class EpgMessageId implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getMessageId(); }
        public void write(Entity et, Object vl) { ((Message)et).setMessageId(cti(vl)); }
    }
    public static class EpgSenderId implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getSenderId(); }
        public void write(Entity et, Object vl) { ((Message)et).setSenderId(cti(vl)); }
    }
    public static class EpgReceiverId implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getReceiverId(); }
        public void write(Entity et, Object vl) { ((Message)et).setReceiverId(cti(vl)); }
    }
    public static class EpgMessageTime implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getMessageTime(); }
        public void write(Entity et, Object vl) { ((Message)et).setMessageTime((String)vl); }
    }
    public static class EpgMessage implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getMessage(); }
        public void write(Entity et, Object vl) { ((Message)et).setMessage((String)vl); }
    }
    public static class EpgInsDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getInsDatetime(); }
        public void write(Entity et, Object vl) { ((Message)et).setInsDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getUpdDatetime(); }
        public void write(Entity et, Object vl) { ((Message)et).setUpdDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgInsTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getInsTrace(); }
        public void write(Entity et, Object vl) { ((Message)et).setInsTrace((String)vl); }
    }
    public static class EpgUpdTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getUpdTrace(); }
        public void write(Entity et, Object vl) { ((Message)et).setUpdTrace((String)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    {
        setupEfpg(_efpgMap, new EfpgMemberBySenderId(), "memberBySenderId");
        setupEfpg(_efpgMap, new EfpgMemberByReceiverId(), "memberByReceiverId");
    }
    public class EfpgMemberBySenderId implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getMemberBySenderId(); }
        public void write(Entity et, Object vl) { ((Message)et).setMemberBySenderId((Member)vl); }
    }
    public class EfpgMemberByReceiverId implements PropertyGateway {
        public Object read(Entity et) { return ((Message)et).getMemberByReceiverId(); }
        public void write(Entity et, Object vl) { ((Message)et).setMemberByReceiverId((Member)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "message";
    protected final String _tablePropertyName = "message";
    protected final TableSqlName _tableSqlName = new TableSqlName("message", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMessageId = cci("MESSAGE_ID", "MESSAGE_ID", null, null, Integer.class, "messageId", null, true, true, true, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnSenderId = cci("SENDER_ID", "SENDER_ID", null, null, Integer.class, "senderId", null, false, false, true, "INT", 10, 0, null, false, null, null, "memberBySenderId", null, null);
    protected final ColumnInfo _columnReceiverId = cci("RECEIVER_ID", "RECEIVER_ID", null, null, Integer.class, "receiverId", null, false, false, true, "INT", 10, 0, null, false, null, null, "memberByReceiverId", null, null);
    protected final ColumnInfo _columnMessageTime = cci("MESSAGE_TIME", "MESSAGE_TIME", null, null, String.class, "messageTime", null, false, false, true, "VARCHAR", 100, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMessage = cci("MESSAGE", "MESSAGE", null, null, String.class, "message", null, false, false, true, "VARCHAR", 255, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsDatetime = cci("INS_DATETIME", "INS_DATETIME", null, null, java.sql.Timestamp.class, "insDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdDatetime = cci("UPD_DATETIME", "UPD_DATETIME", null, null, java.sql.Timestamp.class, "updDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsTrace = cci("INS_TRACE", "INS_TRACE", null, null, String.class, "insTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdTrace = cci("UPD_TRACE", "UPD_TRACE", null, null, String.class, "updTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);

    /**
     * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessageId() { return _columnMessageId; }
    /**
     * SENDER_ID: {IX, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnSenderId() { return _columnSenderId; }
    /**
     * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnReceiverId() { return _columnReceiverId; }
    /**
     * MESSAGE_TIME: {NotNull, VARCHAR(100)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessageTime() { return _columnMessageTime; }
    /**
     * MESSAGE: {NotNull, VARCHAR(255)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMessage() { return _columnMessage; }
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
        ls.add(columnMessageId());
        ls.add(columnSenderId());
        ls.add(columnReceiverId());
        ls.add(columnMessageTime());
        ls.add(columnMessage());
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
    protected UniqueInfo cpui() { return hpcpui(columnMessageId()); }
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
     * member by my SENDER_ID, named 'memberBySenderId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMemberBySenderId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnSenderId(), MemberDbm.getInstance().columnMemberId());
        return cfi("message_ibfk_1", "memberBySenderId", this, MemberDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "messageBySenderIdList");
    }
    /**
     * member by my RECEIVER_ID, named 'memberByReceiverId'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignMemberByReceiverId() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnReceiverId(), MemberDbm.getInstance().columnMemberId());
        return cfi("message_ibfk_2", "memberByReceiverId", this, MemberDbm.getInstance(), mp, 1, null, false, false, false, false, null, null, false, "messageByReceiverIdList");
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
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.Message"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.MessageCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.MessageBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Message> getEntityType() { return Message.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Message newEntity() { return new Message(); }
    public Message newMyEntity() { return new Message(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Message)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Message)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
