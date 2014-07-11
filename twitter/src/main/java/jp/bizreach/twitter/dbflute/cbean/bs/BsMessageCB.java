package jp.bizreach.twitter.dbflute.cbean.bs;

import org.seasar.dbflute.cbean.AbstractConditionBean;
import org.seasar.dbflute.cbean.AndQuery;
import org.seasar.dbflute.cbean.ConditionBean;
import org.seasar.dbflute.cbean.ConditionQuery;
import org.seasar.dbflute.cbean.OrQuery;
import org.seasar.dbflute.cbean.SpecifyQuery;
import org.seasar.dbflute.cbean.SubQuery;
import org.seasar.dbflute.cbean.UnionQuery;
import org.seasar.dbflute.cbean.chelper.*;
import org.seasar.dbflute.cbean.coption.*;
import org.seasar.dbflute.cbean.sqlclause.SqlClause;
import org.seasar.dbflute.cbean.sqlclause.SqlClauseCreator;
import org.seasar.dbflute.dbmeta.DBMetaProvider;
import org.seasar.dbflute.twowaysql.factory.SqlAnalyzerFactory;
import jp.bizreach.twitter.dbflute.allcommon.DBFluteConfig;
import jp.bizreach.twitter.dbflute.allcommon.DBMetaInstanceHandler;
import jp.bizreach.twitter.dbflute.allcommon.ImplementedInvokerAssistant;
import jp.bizreach.twitter.dbflute.allcommon.ImplementedSqlClauseCreator;
import jp.bizreach.twitter.dbflute.cbean.*;
import jp.bizreach.twitter.dbflute.cbean.cq.*;
import jp.bizreach.twitter.dbflute.cbean.nss.*;

/**
 * The base condition-bean of message.
 * @author DBFlute(AutoGenerator)
 */
public class BsMessageCB extends AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MessageCQ _conditionQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMessageCB() {
        if (DBFluteConfig.getInstance().isPagingCountLater()) {
            enablePagingCountLater();
        }
        if (DBFluteConfig.getInstance().isPagingCountLeastJoin()) {
            enablePagingCountLeastJoin();
        }
        if (DBFluteConfig.getInstance().isCheckCountBeforeQueryUpdate()) {
            enableCheckCountBeforeQueryUpdate();
        }
    }

    // ===================================================================================
    //                                                                           SqlClause
    //                                                                           =========
    @Override
    protected SqlClause createSqlClause() {
        SqlClauseCreator creator = DBFluteConfig.getInstance().getSqlClauseCreator();
        if (creator != null) {
            return creator.createSqlClause(this);
        }
        return new ImplementedSqlClauseCreator().createSqlClause(this); // as default
    }

    // ===================================================================================
    //                                                                     DBMeta Provider
    //                                                                     ===============
    @Override
    protected DBMetaProvider getDBMetaProvider() {
        return DBMetaInstanceHandler.getProvider(); // as default
    }

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    public String getTableDbName() {
        return "message";
    }

    // ===================================================================================
    //                                                                 PrimaryKey Handling
    //                                                                 ===================
    /**
     * Accept the query condition of primary key as equal.
     * @param messageId : PK, ID, NotNull, INT(10). (NotNull)
     * @return this. (NotNull)
     */
    public MessageCB acceptPK(Integer messageId) {
        assertObjectNotNull("messageId", messageId);
        BsMessageCB cb = this;
        cb.query().setMessageId_Equal(messageId);
        return (MessageCB)this;
    }

    /**
     * Accept the query condition of primary key as equal. (old style)
     * @param messageId : PK, ID, NotNull, INT(10). (NotNull)
     */
    public void acceptPrimaryKey(Integer messageId) {
        assertObjectNotNull("messageId", messageId);
        BsMessageCB cb = this;
        cb.query().setMessageId_Equal(messageId);
    }

    public ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_MessageId_Asc();
        return this;
    }

    public ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_MessageId_Desc();
        return this;
    }

    // ===================================================================================
    //                                                                               Query
    //                                                                               =====
    /**
     * Prepare for various queries. <br />
     * Examples of main functions are following:
     * <pre>
     * <span style="color: #3F7E5E">// Basic Queries</span>
     * cb.query().setMemberId_Equal(value);        <span style="color: #3F7E5E">// =</span>
     * cb.query().setMemberId_NotEqual(value);     <span style="color: #3F7E5E">// !=</span>
     * cb.query().setMemberId_GreaterThan(value);  <span style="color: #3F7E5E">// &gt;</span>
     * cb.query().setMemberId_LessThan(value);     <span style="color: #3F7E5E">// &lt;</span>
     * cb.query().setMemberId_GreaterEqual(value); <span style="color: #3F7E5E">// &gt;=</span>
     * cb.query().setMemberId_LessEqual(value);    <span style="color: #3F7E5E">// &lt;=</span>
     * cb.query().setMemberName_InScope(valueList);    <span style="color: #3F7E5E">// in ('a', 'b')</span>
     * cb.query().setMemberName_NotInScope(valueList); <span style="color: #3F7E5E">// not in ('a', 'b')</span>
     * cb.query().setMemberName_PrefixSearch(value);   <span style="color: #3F7E5E">// like 'a%' escape '|'</span>
     * <span style="color: #3F7E5E">// LikeSearch with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {like ... [options]}</span>
     * cb.query().setMemberName_LikeSearch(value, option);
     * cb.query().setMemberName_NotLikeSearch(value, option); <span style="color: #3F7E5E">// not like ...</span>
     * <span style="color: #3F7E5E">// FromTo with various options: (versatile)</span>
     * <span style="color: #3F7E5E">// {(default) fromDatetime &lt;= BIRTHDATE &lt;= toDatetime}</span>
     * cb.query().setBirthdate_FromTo(fromDatetime, toDatetime, option);
     * <span style="color: #3F7E5E">// DateFromTo: (Date means yyyy/MM/dd)</span>
     * <span style="color: #3F7E5E">// {fromDate &lt;= BIRTHDATE &lt; toDate + 1 day}</span>
     * cb.query().setBirthdate_DateFromTo(fromDate, toDate);
     * cb.query().setBirthdate_IsNull();    <span style="color: #3F7E5E">// is null</span>
     * cb.query().setBirthdate_IsNotNull(); <span style="color: #3F7E5E">// is not null</span>
     * 
     * <span style="color: #3F7E5E">// ExistsReferrer: (correlated sub-query)</span>
     * <span style="color: #3F7E5E">// {where exists (select PURCHASE_ID from PURCHASE where ...)}</span>
     * cb.query().existsPurchaseList(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     *     }
     * });
     * cb.query().notExistsPurchaseList...
     * 
     * <span style="color: #3F7E5E">// InScopeRelation: (sub-query)</span>
     * <span style="color: #3F7E5E">// {where MEMBER_STATUS_CODE in (select MEMBER_STATUS_CODE from MEMBER_STATUS where ...)}</span>
     * cb.query().inScopeMemberStatus(new SubQuery&lt;MemberStatusCB&gt;() {
     *     public void query(MemberStatusCB subCB) {
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// relation sub-query condition</span>
     *     }
     * });
     * cb.query().notInScopeMemberStatus...
     * 
     * <span style="color: #3F7E5E">// (Query)DerivedReferrer: (correlated sub-query)</span>
     * cb.query().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchasePrice(); <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// referrer sub-query condition</span>
     *     }
     * }).greaterEqual(value);
     * 
     * <span style="color: #3F7E5E">// ScalarCondition: (self-table sub-query)</span>
     * cb.query().scalar_Equal().max(new SubQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB subCB) {
     *         subCB.specify().columnBirthdate(); <span style="color: #3F7E5E">// derived column for function</span>
     *         subCB.query().setXxx... <span style="color: #3F7E5E">// scalar sub-query condition</span>
     *     }
     * });
     * 
     * <span style="color: #3F7E5E">// OrderBy</span>
     * cb.query().addOrderBy_MemberName_Asc();
     * cb.query().addOrderBy_MemberName_Desc().withManualOrder(valueList);
     * cb.query().addOrderBy_MemberName_Desc().withNullsFirst();
     * cb.query().addOrderBy_MemberName_Desc().withNullsLast();
     * cb.query().addSpecifiedDerivedOrderBy_Desc(aliasName);
     * 
     * <span style="color: #3F7E5E">// Query(Relation)</span>
     * cb.query().queryMemberStatus()...;
     * cb.query().queryMemberAddressAsValid(targetDate)...;
     * </pre>
     * @return The instance of condition-query for base-point table to set up query. (NotNull)
     */
    public MessageCQ query() {
        assertQueryPurpose(); // assert only when user-public query 
        return getConditionQuery();
    }

    public MessageCQ getConditionQuery() { // public for parameter comment and internal
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected MessageCQ createLocalCQ() {
        return xcreateCQ(null, getSqlClause(), getSqlClause().getBasePointAliasName(), 0);
    }

    protected MessageCQ xcreateCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        MessageCQ cq = xnewCQ(childQuery, sqlClause, aliasName, nestLevel);
        cq.xsetBaseCB(this);
        return cq;
    }

    protected MessageCQ xnewCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        return new MessageCQ(childQuery, sqlClause, aliasName, nestLevel);
    }

    public ConditionQuery localCQ() {
        return getConditionQuery();
    }

    // ===================================================================================
    //                                                                               Union
    //                                                                               =====
    /**
     * Set up 'union' for base-point table. <br />
     * You don't need to call SetupSelect in union-query,
     * because it inherits calls before. (Don't call SetupSelect after here)
     * <pre>
     * cb.query().<span style="color: #DD4747">union</span>(new UnionQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void union(UnionQuery<MessageCB> unionQuery) {
        final MessageCB cb = new MessageCB(); cb.xsetupForUnion(this); xsyncUQ(cb); 
        try { lock(); unionQuery.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final MessageCQ cq = cb.query(); query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all' for base-point table. <br />
     * You don't need to call SetupSelect in union-query,
     * because it inherits calls before. (Don't call SetupSelect after here)
     * <pre>
     * cb.query().<span style="color: #DD4747">unionAll</span>(new UnionQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union all'. (NotNull)
     */
    public void unionAll(UnionQuery<MessageCB> unionQuery) {
        final MessageCB cb = new MessageCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionQuery.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final MessageCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }

    // ===================================================================================
    //                                                                         SetupSelect
    //                                                                         ===========
    protected MemberNss _nssMemberBySenderId;
    public MemberNss getNssMemberBySenderId() {
        if (_nssMemberBySenderId == null) { _nssMemberBySenderId = new MemberNss(null); }
        return _nssMemberBySenderId;
    }
    /**
     * Set up relation columns to select clause. <br />
     * member by my SENDER_ID, named 'memberBySenderId'.
     * <pre>
     * MessageCB cb = new MessageCB();
     * cb.<span style="color: #DD4747">setupSelect_MemberBySenderId()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * Message message = messageBhv.selectEntityWithDeletedCheck(cb);
     * ... = message.<span style="color: #DD4747">getMemberBySenderId()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public MemberNss setupSelect_MemberBySenderId() {
        assertSetupSelectPurpose("memberBySenderId");
        if (hasSpecifiedColumn()) { // if reverse call
            specify().columnSenderId();
        }
        doSetupSelect(new SsCall() { public ConditionQuery qf() { return query().queryMemberBySenderId(); } });
        if (_nssMemberBySenderId == null || !_nssMemberBySenderId.hasConditionQuery())
        { _nssMemberBySenderId = new MemberNss(query().queryMemberBySenderId()); }
        return _nssMemberBySenderId;
    }

    protected MemberNss _nssMemberByReceiverId;
    public MemberNss getNssMemberByReceiverId() {
        if (_nssMemberByReceiverId == null) { _nssMemberByReceiverId = new MemberNss(null); }
        return _nssMemberByReceiverId;
    }
    /**
     * Set up relation columns to select clause. <br />
     * member by my RECEIVER_ID, named 'memberByReceiverId'.
     * <pre>
     * MessageCB cb = new MessageCB();
     * cb.<span style="color: #DD4747">setupSelect_MemberByReceiverId()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * Message message = messageBhv.selectEntityWithDeletedCheck(cb);
     * ... = message.<span style="color: #DD4747">getMemberByReceiverId()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public MemberNss setupSelect_MemberByReceiverId() {
        assertSetupSelectPurpose("memberByReceiverId");
        if (hasSpecifiedColumn()) { // if reverse call
            specify().columnReceiverId();
        }
        doSetupSelect(new SsCall() { public ConditionQuery qf() { return query().queryMemberByReceiverId(); } });
        if (_nssMemberByReceiverId == null || !_nssMemberByReceiverId.hasConditionQuery())
        { _nssMemberByReceiverId = new MemberNss(query().queryMemberByReceiverId()); }
        return _nssMemberByReceiverId;
    }

    // [DBFlute-0.7.4]
    // ===================================================================================
    //                                                                             Specify
    //                                                                             =======
    protected HpSpecification _specification;

    /**
     * Prepare for SpecifyColumn, (Specify)DerivedReferrer. <br />
     * This method should be called after SetupSelect.
     * <pre>
     * cb.setupSelect_MemberStatus(); <span style="color: #3F7E5E">// should be called before specify()</span>
     * cb.specify().columnMemberName();
     * cb.specify().specifyMemberStatus().columnMemberStatusName();
     * cb.specify().derivedPurchaseList().max(new SubQuery&lt;PurchaseCB&gt;() {
     *     public void query(PurchaseCB subCB) {
     *         subCB.specify().columnPurchaseDatetime();
     *         subCB.query().set...
     *     }
     * }, aliasName);
     * </pre>
     * @return The instance of specification. (NotNull)
     */
    public HpSpecification specify() {
        assertSpecifyPurpose();
        if (_specification == null) { _specification = new HpSpecification(this
            , new HpSpQyCall<MessageCQ>() {
                public boolean has() { return true; }
                public MessageCQ qy() { return getConditionQuery(); }
            }
            , _purpose, getDBMetaProvider()); }
        return _specification;
    }

    public HpColumnSpHandler localSp() {
        return specify();
    }

    public boolean hasSpecifiedColumn() {
        return _specification != null && _specification.isAlreadySpecifiedRequiredColumn();
    }

    public static class HpSpecification extends HpAbstractSpecification<MessageCQ> {
        protected MemberCB.HpSpecification _memberBySenderId;
        protected MemberCB.HpSpecification _memberByReceiverId;
        public HpSpecification(ConditionBean baseCB, HpSpQyCall<MessageCQ> qyCall
                             , HpCBPurpose purpose, DBMetaProvider dbmetaProvider)
        { super(baseCB, qyCall, purpose, dbmetaProvider); }
        /**
         * MESSAGE_ID: {PK, ID, NotNull, INT(10)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnMessageId() { return doColumn("MESSAGE_ID"); }
        /**
         * SENDER_ID: {IX, NotNull, INT(10), FK to member}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnSenderId() { return doColumn("SENDER_ID"); }
        /**
         * RECEIVER_ID: {IX, NotNull, INT(10), FK to member}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnReceiverId() { return doColumn("RECEIVER_ID"); }
        /**
         * MESSAGE_TIME: {NotNull, VARCHAR(100)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnMessageTime() { return doColumn("MESSAGE_TIME"); }
        /**
         * MESSAGE: {NotNull, VARCHAR(255)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnMessage() { return doColumn("MESSAGE"); }
        /**
         * INS_DATETIME: {NotNull, DATETIME(19)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnInsDatetime() { return doColumn("INS_DATETIME"); }
        /**
         * UPD_DATETIME: {NotNull, DATETIME(19)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnUpdDatetime() { return doColumn("UPD_DATETIME"); }
        /**
         * INS_TRACE: {NotNull, VARCHAR(256)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnInsTrace() { return doColumn("INS_TRACE"); }
        /**
         * UPD_TRACE: {NotNull, VARCHAR(256)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnUpdTrace() { return doColumn("UPD_TRACE"); }
        public void everyColumn() { doEveryColumn(); }
        public void exceptRecordMetaColumn() { doExceptRecordMetaColumn(); }
        @Override
        protected void doSpecifyRequiredColumn() {
            columnMessageId(); // PK
            if (qyCall().qy().hasConditionQueryMemberBySenderId()
                    || qyCall().qy().xgetReferrerQuery() instanceof MemberCQ) {
                columnSenderId(); // FK or one-to-one referrer
            }
            if (qyCall().qy().hasConditionQueryMemberByReceiverId()
                    || qyCall().qy().xgetReferrerQuery() instanceof MemberCQ) {
                columnReceiverId(); // FK or one-to-one referrer
            }
        }
        @Override
        protected String getTableDbName() { return "message"; }
        /**
         * Prepare to specify functions about relation table. <br />
         * member by my SENDER_ID, named 'memberBySenderId'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public MemberCB.HpSpecification specifyMemberBySenderId() {
            assertRelation("memberBySenderId");
            if (_memberBySenderId == null) {
                _memberBySenderId = new MemberCB.HpSpecification(_baseCB, new HpSpQyCall<MemberCQ>() {
                    public boolean has() { return _qyCall.has() && _qyCall.qy().hasConditionQueryMemberBySenderId(); }
                    public MemberCQ qy() { return _qyCall.qy().queryMemberBySenderId(); } }
                    , _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _memberBySenderId.xsetSyncQyCall(new HpSpQyCall<MemberCQ>() {
                        public boolean has() { return xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryMemberBySenderId(); }
                        public MemberCQ qy() { return xsyncQyCall().qy().queryMemberBySenderId(); }
                    });
                }
            }
            return _memberBySenderId;
        }
        /**
         * Prepare to specify functions about relation table. <br />
         * member by my RECEIVER_ID, named 'memberByReceiverId'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public MemberCB.HpSpecification specifyMemberByReceiverId() {
            assertRelation("memberByReceiverId");
            if (_memberByReceiverId == null) {
                _memberByReceiverId = new MemberCB.HpSpecification(_baseCB, new HpSpQyCall<MemberCQ>() {
                    public boolean has() { return _qyCall.has() && _qyCall.qy().hasConditionQueryMemberByReceiverId(); }
                    public MemberCQ qy() { return _qyCall.qy().queryMemberByReceiverId(); } }
                    , _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _memberByReceiverId.xsetSyncQyCall(new HpSpQyCall<MemberCQ>() {
                        public boolean has() { return xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryMemberByReceiverId(); }
                        public MemberCQ qy() { return xsyncQyCall().qy().queryMemberByReceiverId(); }
                    });
                }
            }
            return _memberByReceiverId;
        }
        /**
         * Prepare for (Specify)MyselfDerived (SubQuery).
         * @return The object to set up a function for myself table. (NotNull)
         */
        public HpSDRFunction<MessageCB, MessageCQ> myselfDerived() {
            assertDerived("myselfDerived"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return new HpSDRFunction<MessageCB, MessageCQ>(_baseCB, _qyCall.qy(), new HpSDRSetupper<MessageCB, MessageCQ>() {
                public void setup(String fn, SubQuery<MessageCB> sq, MessageCQ cq, String al, DerivedReferrerOption op) {
                    cq.xsmyselfDerive(fn, sq, al, op); } }, _dbmetaProvider);
        }
    }

    // [DBFlute-0.9.5.3]
    // ===================================================================================
    //                                                                        Column Query
    //                                                                        ============
    /**
     * Set up column-query. {column1 = column2}
     * <pre>
     * <span style="color: #3F7E5E">// where FOO &lt; BAR</span>
     * cb.<span style="color: #DD4747">columnQuery</span>(new SpecifyQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFoo()</span>; <span style="color: #3F7E5E">// left column</span>
     *     }
     * }).lessThan(new SpecifyQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnBar()</span>; <span style="color: #3F7E5E">// right column</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can calculate for right column like '}).plus(3);'</span>
     * </pre>
     * @param leftSpecifyQuery The specify-query for left column. (NotNull)
     * @return The object for setting up operand and right column. (NotNull)
     */
    public HpColQyOperand<MessageCB> columnQuery(final SpecifyQuery<MessageCB> leftSpecifyQuery) {
        return new HpColQyOperand<MessageCB>(new HpColQyHandler<MessageCB>() {
            public HpCalculator handle(SpecifyQuery<MessageCB> rightSp, String operand) {
                return xcolqy(xcreateColumnQueryCB(), xcreateColumnQueryCB(), leftSpecifyQuery, rightSp, operand);
            }
        });
    }

    protected MessageCB xcreateColumnQueryCB() {
        MessageCB cb = new MessageCB();
        cb.xsetupForColumnQuery((MessageCB)this);
        return cb;
    }

    // ===================================================================================
    //                                                                        Dream Cruise
    //                                                                        ============
    /**
     * Welcome to the Dream Cruise for condition-bean deep world. <br />
     * This is very specialty so you can get the frontier spirit. Bon voyage!
     * @return The condition-bean for dream cruise, which is linked to main condition-bean.
     */
    public MessageCB dreamCruiseCB() {
        MessageCB cb = new MessageCB();
        cb.xsetupForDreamCruise((MessageCB) this);
        return cb;
    }

    protected ConditionBean xdoCreateDreamCruiseCB() {
        return dreamCruiseCB();
    }

    // [DBFlute-0.9.6.3]
    // ===================================================================================
    //                                                                       OrScope Query
    //                                                                       =============
    /**
     * Set up the query for or-scope. <br />
     * (Same-column-and-same-condition-key conditions are allowed in or-scope)
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or BAR = '...')</span>
     * cb.<span style="color: #DD4747">orScopeQuery</span>(new OrQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.query().setBAR_Equal...
     *     }
     * });
     * </pre>
     * @param orQuery The query for or-condition. (NotNull)
     */
    public void orScopeQuery(OrQuery<MessageCB> orQuery) {
        xorSQ((MessageCB)this, orQuery);
    }

    @Override
    protected HpCBPurpose xhandleOrSQPurposeChange() {
        return null; // means no check
    }

    /**
     * Set up the and-part of or-scope. <br />
     * (However nested or-scope query and as-or-split of like-search in and-part are unsupported)
     * <pre>
     * <span style="color: #3F7E5E">// where (FOO = '...' or (BAR = '...' and QUX = '...'))</span>
     * cb.<span style="color: #DD4747">orScopeQuery</span>(new OrQuery&lt;MessageCB&gt;() {
     *     public void query(MessageCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.<span style="color: #DD4747">orScopeQueryAndPart</span>(new AndQuery&lt;MessageCB&gt;() {
     *             public void query(MessageCB andCB) {
     *                 andCB.query().setBar_...
     *                 andCB.query().setQux_...
     *             }
     *         });
     *     }
     * });
     * </pre>
     * @param andQuery The query for and-condition. (NotNull)
     */
    public void orScopeQueryAndPart(AndQuery<MessageCB> andQuery) {
        xorSQAP((MessageCB)this, andQuery);
    }

    // ===================================================================================
    //                                                                          DisplaySQL
    //                                                                          ==========
    @Override
    protected SqlAnalyzerFactory getSqlAnalyzerFactory()
    { return new ImplementedInvokerAssistant().assistSqlAnalyzerFactory(); }
    @Override
    protected String getLogDateFormat() { return DBFluteConfig.getInstance().getLogDateFormat(); }
    @Override
    protected String getLogTimestampFormat() { return DBFluteConfig.getInstance().getLogTimestampFormat(); }

    // ===================================================================================
    //                                                                       Meta Handling
    //                                                                       =============
    public boolean hasUnionQueryOrUnionAllQuery() {
        return query().hasUnionQueryOrUnionAllQuery();
    }

    // ===================================================================================
    //                                                                        Purpose Type
    //                                                                        ============
    @Override
    protected void xprepareSyncQyCall(ConditionBean mainCB) {
        final MessageCB cb;
        if (mainCB != null) {
            cb = (MessageCB)mainCB;
        } else {
            cb = new MessageCB();
        }
        specify().xsetSyncQyCall(new HpSpQyCall<MessageCQ>() {
            public boolean has() { return true; }
            public MessageCQ qy() { return cb.query(); }
        });
    }

    // ===================================================================================
    //                                                                            Internal
    //                                                                            ========
    // very internal (for suppressing warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return MessageCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return MessageCQ.class.getName(); }
    protected String getSubQueryClassNameInternally() { return SubQuery.class.getName(); }
    protected String getConditionOptionClassNameInternally() { return ConditionOption.class.getName(); }
}
