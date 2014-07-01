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
 * The DB meta of tweet. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class TweetDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final TweetDbm _instance = new TweetDbm();
    private TweetDbm() {}
    public static TweetDbm getInstance() { return _instance; }

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
        setupEpg(_epgMap, new EpgTweetId(), "tweetId");
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgTweet(), "tweet");
        setupEpg(_epgMap, new EpgInsDatetime(), "insDatetime");
        setupEpg(_epgMap, new EpgUpdDatetime(), "updDatetime");
        setupEpg(_epgMap, new EpgInsTrace(), "insTrace");
        setupEpg(_epgMap, new EpgUpdTrace(), "updTrace");
    }
    public static class EpgTweetId implements PropertyGateway {
        public Object read(Entity et) { return ((Tweet)et).getTweetId(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setTweetId(cti(vl)); }
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((Tweet)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setMemberId(cti(vl)); }
    }
    public static class EpgTweet implements PropertyGateway {
        public Object read(Entity et) { return ((Tweet)et).getTweet(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setTweet((String)vl); }
    }
    public static class EpgInsDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Tweet)et).getInsDatetime(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setInsDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgUpdDatetime implements PropertyGateway {
        public Object read(Entity et) { return ((Tweet)et).getUpdDatetime(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setUpdDatetime((java.sql.Timestamp)vl); }
    }
    public static class EpgInsTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Tweet)et).getInsTrace(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setInsTrace((String)vl); }
    }
    public static class EpgUpdTrace implements PropertyGateway {
        public Object read(Entity et) { return ((Tweet)et).getUpdTrace(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setUpdTrace((String)vl); }
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
        public Object read(Entity et) { return ((Tweet)et).getMember(); }
        public void write(Entity et, Object vl) { ((Tweet)et).setMember((Member)vl); }
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "tweet";
    protected final String _tablePropertyName = "tweet";
    protected final TableSqlName _tableSqlName = new TableSqlName("tweet", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnTweetId = cci("TWEET_ID", "TWEET_ID", null, null, Integer.class, "tweetId", null, true, true, true, "INT", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, Integer.class, "memberId", null, false, false, true, "INT", 10, 0, null, false, null, null, "member", null, null);
    protected final ColumnInfo _columnTweet = cci("TWEET", "TWEET", null, null, String.class, "tweet", null, false, false, true, "VARCHAR", 140, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsDatetime = cci("INS_DATETIME", "INS_DATETIME", null, null, java.sql.Timestamp.class, "insDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdDatetime = cci("UPD_DATETIME", "UPD_DATETIME", null, null, java.sql.Timestamp.class, "updDatetime", null, false, false, true, "DATETIME", 19, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnInsTrace = cci("INS_TRACE", "INS_TRACE", null, null, String.class, "insTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnUpdTrace = cci("UPD_TRACE", "UPD_TRACE", null, null, String.class, "updTrace", null, false, false, true, "VARCHAR", 256, 0, null, false, null, null, null, null, null);

    /**
     * TWEET_ID: {PK, ID, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTweetId() { return _columnTweetId; }
    /**
     * MEMBER_ID: {IX, NotNull, INT(10), FK to member}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * TWEET: {NotNull, VARCHAR(140)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnTweet() { return _columnTweet; }
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
        ls.add(columnTweetId());
        ls.add(columnMemberId());
        ls.add(columnTweet());
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
    protected UniqueInfo cpui() { return hpcpui(columnTweetId()); }
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
        return cfi("tweet_ibfk_1", "member", this, MemberDbm.getInstance(), mp, 0, null, false, false, false, false, null, null, false, "tweetList");
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
    public String getEntityTypeName() { return "jp.bizreach.twitter.dbflute.exentity.Tweet"; }
    public String getConditionBeanTypeName() { return "jp.bizreach.twitter.dbflute.cbean.TweetCB"; }
    public String getBehaviorTypeName() { return "jp.bizreach.twitter.dbflute.exbhv.TweetBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Tweet> getEntityType() { return Tweet.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Tweet newEntity() { return new Tweet(); }
    public Tweet newMyEntity() { return new Tweet(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Tweet)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Tweet)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
