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
 * The base condition-bean of member.
 * @author DBFlute(AutoGenerator)
 */
public class BsMemberCB extends AbstractConditionBean {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected MemberCQ _conditionQuery;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public BsMemberCB() {
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
        return "member";
    }

    // ===================================================================================
    //                                                                 PrimaryKey Handling
    //                                                                 ===================
    /**
     * Accept the query condition of primary key as equal.
     * @param memberId : PK, ID, NotNull, INT(10). (NotNull)
     * @return this. (NotNull)
     */
    public MemberCB acceptPK(Integer memberId) {
        assertObjectNotNull("memberId", memberId);
        BsMemberCB cb = this;
        cb.query().setMemberId_Equal(memberId);
        return (MemberCB)this;
    }

    /**
     * Accept the query condition of primary key as equal. (old style)
     * @param memberId : PK, ID, NotNull, INT(10). (NotNull)
     */
    public void acceptPrimaryKey(Integer memberId) {
        assertObjectNotNull("memberId", memberId);
        BsMemberCB cb = this;
        cb.query().setMemberId_Equal(memberId);
    }

    /**
     * Accept the query condition of unique key as equal.
     * @param emailAddress : UQ, NotNull, VARCHAR(100). (NotNull)
     * @return this. (NotNull)
     */
    public MemberCB acceptUniqueOfEmailAddress(String emailAddress) {
        assertObjectNotNull("emailAddress", emailAddress);
        BsMemberCB cb = this;
        cb.query().setEmailAddress_Equal(emailAddress);
        return (MemberCB)this;
    }

    /**
     * Accept the query condition of unique key as equal.
     * @param userName : UQ, NotNull, VARCHAR(50). (NotNull)
     * @return this. (NotNull)
     */
    public MemberCB acceptUniqueOfUserName(String userName) {
        assertObjectNotNull("userName", userName);
        BsMemberCB cb = this;
        cb.query().setUserName_Equal(userName);
        return (MemberCB)this;
    }

    public ConditionBean addOrderBy_PK_Asc() {
        query().addOrderBy_MemberId_Asc();
        return this;
    }

    public ConditionBean addOrderBy_PK_Desc() {
        query().addOrderBy_MemberId_Desc();
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
    public MemberCQ query() {
        assertQueryPurpose(); // assert only when user-public query 
        return getConditionQuery();
    }

    public MemberCQ getConditionQuery() { // public for parameter comment and internal
        if (_conditionQuery == null) {
            _conditionQuery = createLocalCQ();
        }
        return _conditionQuery;
    }

    protected MemberCQ createLocalCQ() {
        return xcreateCQ(null, getSqlClause(), getSqlClause().getBasePointAliasName(), 0);
    }

    protected MemberCQ xcreateCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        MemberCQ cq = xnewCQ(childQuery, sqlClause, aliasName, nestLevel);
        cq.xsetBaseCB(this);
        return cq;
    }

    protected MemberCQ xnewCQ(ConditionQuery childQuery, SqlClause sqlClause, String aliasName, int nestLevel) {
        return new MemberCQ(childQuery, sqlClause, aliasName, nestLevel);
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
     * cb.query().<span style="color: #DD4747">union</span>(new UnionQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union'. (NotNull)
     */
    public void union(UnionQuery<MemberCB> unionQuery) {
        final MemberCB cb = new MemberCB(); cb.xsetupForUnion(this); xsyncUQ(cb); 
        try { lock(); unionQuery.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final MemberCQ cq = cb.query(); query().xsetUnionQuery(cq);
    }

    /**
     * Set up 'union all' for base-point table. <br />
     * You don't need to call SetupSelect in union-query,
     * because it inherits calls before. (Don't call SetupSelect after here)
     * <pre>
     * cb.query().<span style="color: #DD4747">unionAll</span>(new UnionQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB unionCB) {
     *         unionCB.query().setXxx...
     *     }
     * });
     * </pre>
     * @param unionQuery The query of 'union all'. (NotNull)
     */
    public void unionAll(UnionQuery<MemberCB> unionQuery) {
        final MemberCB cb = new MemberCB(); cb.xsetupForUnion(this); xsyncUQ(cb);
        try { lock(); unionQuery.query(cb); } finally { unlock(); } xsaveUCB(cb);
        final MemberCQ cq = cb.query(); query().xsetUnionAllQuery(cq);
    }

    // ===================================================================================
    //                                                                         SetupSelect
    //                                                                         ===========
    protected FollowNss _nssFollowAsOne;
    public FollowNss getNssFollowAsOne() {
        if (_nssFollowAsOne == null) { _nssFollowAsOne = new FollowNss(null); }
        return _nssFollowAsOne;
    }
    /**
     * Set up relation columns to select clause. <br />
     * follow by MEMBER_ID, named 'followAsOne'.
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.<span style="color: #DD4747">setupSelect_FollowAsOne()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * Member member = memberBhv.selectEntityWithDeletedCheck(cb);
     * ... = member.<span style="color: #DD4747">getFollowAsOne()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public FollowNss setupSelect_FollowAsOne() {
        assertSetupSelectPurpose("followAsOne");
        doSetupSelect(new SsCall() { public ConditionQuery qf() { return query().queryFollowAsOne(); } });
        if (_nssFollowAsOne == null || !_nssFollowAsOne.hasConditionQuery()) { _nssFollowAsOne = new FollowNss(query().queryFollowAsOne()); }
        return _nssFollowAsOne;
    }

    protected FollowersNss _nssFollowersAsOne;
    public FollowersNss getNssFollowersAsOne() {
        if (_nssFollowersAsOne == null) { _nssFollowersAsOne = new FollowersNss(null); }
        return _nssFollowersAsOne;
    }
    /**
     * Set up relation columns to select clause. <br />
     * followers by MEMBER_ID, named 'followersAsOne'.
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.<span style="color: #DD4747">setupSelect_FollowersAsOne()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * Member member = memberBhv.selectEntityWithDeletedCheck(cb);
     * ... = member.<span style="color: #DD4747">getFollowersAsOne()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public FollowersNss setupSelect_FollowersAsOne() {
        assertSetupSelectPurpose("followersAsOne");
        doSetupSelect(new SsCall() { public ConditionQuery qf() { return query().queryFollowersAsOne(); } });
        if (_nssFollowersAsOne == null || !_nssFollowersAsOne.hasConditionQuery()) { _nssFollowersAsOne = new FollowersNss(query().queryFollowersAsOne()); }
        return _nssFollowersAsOne;
    }

    protected MemberSecurityNss _nssMemberSecurityAsOne;
    public MemberSecurityNss getNssMemberSecurityAsOne() {
        if (_nssMemberSecurityAsOne == null) { _nssMemberSecurityAsOne = new MemberSecurityNss(null); }
        return _nssMemberSecurityAsOne;
    }
    /**
     * Set up relation columns to select clause. <br />
     * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.<span style="color: #DD4747">setupSelect_MemberSecurityAsOne()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * Member member = memberBhv.selectEntityWithDeletedCheck(cb);
     * ... = member.<span style="color: #DD4747">getMemberSecurityAsOne()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public MemberSecurityNss setupSelect_MemberSecurityAsOne() {
        assertSetupSelectPurpose("memberSecurityAsOne");
        doSetupSelect(new SsCall() { public ConditionQuery qf() { return query().queryMemberSecurityAsOne(); } });
        if (_nssMemberSecurityAsOne == null || !_nssMemberSecurityAsOne.hasConditionQuery()) { _nssMemberSecurityAsOne = new MemberSecurityNss(query().queryMemberSecurityAsOne()); }
        return _nssMemberSecurityAsOne;
    }

    protected MemberWithdrawNss _nssMemberWithdrawAsOne;
    public MemberWithdrawNss getNssMemberWithdrawAsOne() {
        if (_nssMemberWithdrawAsOne == null) { _nssMemberWithdrawAsOne = new MemberWithdrawNss(null); }
        return _nssMemberWithdrawAsOne;
    }
    /**
     * Set up relation columns to select clause. <br />
     * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.<span style="color: #DD4747">setupSelect_MemberWithdrawAsOne()</span>; <span style="color: #3F7E5E">// ...().with[nested-relation]()</span>
     * cb.query().setFoo...(value);
     * Member member = memberBhv.selectEntityWithDeletedCheck(cb);
     * ... = member.<span style="color: #DD4747">getMemberWithdrawAsOne()</span>; <span style="color: #3F7E5E">// you can get by using SetupSelect</span>
     * </pre>
     * @return The set-upper of nested relation. {setupSelect...().with[nested-relation]} (NotNull)
     */
    public MemberWithdrawNss setupSelect_MemberWithdrawAsOne() {
        assertSetupSelectPurpose("memberWithdrawAsOne");
        doSetupSelect(new SsCall() { public ConditionQuery qf() { return query().queryMemberWithdrawAsOne(); } });
        if (_nssMemberWithdrawAsOne == null || !_nssMemberWithdrawAsOne.hasConditionQuery()) { _nssMemberWithdrawAsOne = new MemberWithdrawNss(query().queryMemberWithdrawAsOne()); }
        return _nssMemberWithdrawAsOne;
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
            , new HpSpQyCall<MemberCQ>() {
                public boolean has() { return true; }
                public MemberCQ qy() { return getConditionQuery(); }
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

    public static class HpSpecification extends HpAbstractSpecification<MemberCQ> {
        protected FollowCB.HpSpecification _followAsOne;
        protected FollowersCB.HpSpecification _followersAsOne;
        protected MemberSecurityCB.HpSpecification _memberSecurityAsOne;
        protected MemberWithdrawCB.HpSpecification _memberWithdrawAsOne;
        public HpSpecification(ConditionBean baseCB, HpSpQyCall<MemberCQ> qyCall
                             , HpCBPurpose purpose, DBMetaProvider dbmetaProvider)
        { super(baseCB, qyCall, purpose, dbmetaProvider); }
        /**
         * MEMBER_ID: {PK, ID, NotNull, INT(10)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnMemberId() { return doColumn("MEMBER_ID"); }
        /**
         * EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnEmailAddress() { return doColumn("EMAIL_ADDRESS"); }
        /**
         * USER_NAME: {UQ, NotNull, VARCHAR(50)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnUserName() { return doColumn("USER_NAME"); }
        /**
         * UPDATE_DATETIME: {DATETIME(19)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnUpdateDatetime() { return doColumn("UPDATE_DATETIME"); }
        /**
         * BIRTHDATE: {DATE(10)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnBirthdate() { return doColumn("BIRTHDATE"); }
        /**
         * PROFILE: {VARCHAR(200)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnProfile() { return doColumn("PROFILE"); }
        /**
         * REGESTER_DATETIME: {NotNull, DATETIME(19)}
         * @return The information object of specified column. (NotNull)
         */
        public HpSpecifiedColumn columnRegesterDatetime() { return doColumn("REGESTER_DATETIME"); }
        public void everyColumn() { doEveryColumn(); }
        public void exceptRecordMetaColumn() { doExceptRecordMetaColumn(); }
        @Override
        protected void doSpecifyRequiredColumn() {
            columnMemberId(); // PK
        }
        @Override
        protected String getTableDbName() { return "member"; }
        /**
         * Prepare to specify functions about relation table. <br />
         * follow by MEMBER_ID, named 'followAsOne'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public FollowCB.HpSpecification specifyFollowAsOne() {
            assertRelation("followAsOne");
            if (_followAsOne == null) {
                _followAsOne = new FollowCB.HpSpecification(_baseCB, new HpSpQyCall<FollowCQ>() {
                    public boolean has() { return _qyCall.has() && _qyCall.qy().hasConditionQueryFollowAsOne(); }
                    public FollowCQ qy() { return _qyCall.qy().queryFollowAsOne(); } }
                    , _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _followAsOne.xsetSyncQyCall(new HpSpQyCall<FollowCQ>() {
                        public boolean has() { return xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryFollowAsOne(); }
                        public FollowCQ qy() { return xsyncQyCall().qy().queryFollowAsOne(); }
                    });
                }
            }
            return _followAsOne;
        }
        /**
         * Prepare to specify functions about relation table. <br />
         * followers by MEMBER_ID, named 'followersAsOne'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public FollowersCB.HpSpecification specifyFollowersAsOne() {
            assertRelation("followersAsOne");
            if (_followersAsOne == null) {
                _followersAsOne = new FollowersCB.HpSpecification(_baseCB, new HpSpQyCall<FollowersCQ>() {
                    public boolean has() { return _qyCall.has() && _qyCall.qy().hasConditionQueryFollowersAsOne(); }
                    public FollowersCQ qy() { return _qyCall.qy().queryFollowersAsOne(); } }
                    , _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _followersAsOne.xsetSyncQyCall(new HpSpQyCall<FollowersCQ>() {
                        public boolean has() { return xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryFollowersAsOne(); }
                        public FollowersCQ qy() { return xsyncQyCall().qy().queryFollowersAsOne(); }
                    });
                }
            }
            return _followersAsOne;
        }
        /**
         * Prepare to specify functions about relation table. <br />
         * member_security by MEMBER_ID, named 'memberSecurityAsOne'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public MemberSecurityCB.HpSpecification specifyMemberSecurityAsOne() {
            assertRelation("memberSecurityAsOne");
            if (_memberSecurityAsOne == null) {
                _memberSecurityAsOne = new MemberSecurityCB.HpSpecification(_baseCB, new HpSpQyCall<MemberSecurityCQ>() {
                    public boolean has() { return _qyCall.has() && _qyCall.qy().hasConditionQueryMemberSecurityAsOne(); }
                    public MemberSecurityCQ qy() { return _qyCall.qy().queryMemberSecurityAsOne(); } }
                    , _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _memberSecurityAsOne.xsetSyncQyCall(new HpSpQyCall<MemberSecurityCQ>() {
                        public boolean has() { return xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryMemberSecurityAsOne(); }
                        public MemberSecurityCQ qy() { return xsyncQyCall().qy().queryMemberSecurityAsOne(); }
                    });
                }
            }
            return _memberSecurityAsOne;
        }
        /**
         * Prepare to specify functions about relation table. <br />
         * member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
         * @return The instance for specification for relation table to specify. (NotNull)
         */
        public MemberWithdrawCB.HpSpecification specifyMemberWithdrawAsOne() {
            assertRelation("memberWithdrawAsOne");
            if (_memberWithdrawAsOne == null) {
                _memberWithdrawAsOne = new MemberWithdrawCB.HpSpecification(_baseCB, new HpSpQyCall<MemberWithdrawCQ>() {
                    public boolean has() { return _qyCall.has() && _qyCall.qy().hasConditionQueryMemberWithdrawAsOne(); }
                    public MemberWithdrawCQ qy() { return _qyCall.qy().queryMemberWithdrawAsOne(); } }
                    , _purpose, _dbmetaProvider);
                if (xhasSyncQyCall()) { // inherits it
                    _memberWithdrawAsOne.xsetSyncQyCall(new HpSpQyCall<MemberWithdrawCQ>() {
                        public boolean has() { return xsyncQyCall().has() && xsyncQyCall().qy().hasConditionQueryMemberWithdrawAsOne(); }
                        public MemberWithdrawCQ qy() { return xsyncQyCall().qy().queryMemberWithdrawAsOne(); }
                    });
                }
            }
            return _memberWithdrawAsOne;
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br />
         * {select max(FOO) from login where ...) as FOO_MAX} <br />
         * login by MEMBER_ID, named 'loginList'.
         * <pre>
         * cb.specify().<span style="color: #DD4747">derivedLoginList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;LoginCB&gt;() {
         *     public void query(LoginCB subCB) {
         *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
         *     }
         * }, Login.<span style="color: #DD4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<LoginCB, MemberCQ> derivedLoginList() {
            assertDerived("loginList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return new HpSDRFunction<LoginCB, MemberCQ>(_baseCB, _qyCall.qy(), new HpSDRSetupper<LoginCB, MemberCQ>() {
                public void setup(String fn, SubQuery<LoginCB> sq, MemberCQ cq, String al, DerivedReferrerOption op) {
                    cq.xsderiveLoginList(fn, sq, al, op); } }, _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)DerivedReferrer (correlated sub-query). <br />
         * {select max(FOO) from tweet where ...) as FOO_MAX} <br />
         * tweet by MEMBER_ID, named 'tweetList'.
         * <pre>
         * cb.specify().<span style="color: #DD4747">derivedTweetList()</span>.<span style="color: #DD4747">max</span>(new SubQuery&lt;TweetCB&gt;() {
         *     public void query(TweetCB subCB) {
         *         subCB.specify().<span style="color: #DD4747">columnFoo...</span> <span style="color: #3F7E5E">// derived column by function</span>
         *         subCB.query().setBar... <span style="color: #3F7E5E">// referrer condition</span>
         *     }
         * }, Tweet.<span style="color: #DD4747">ALIAS_foo...</span>);
         * </pre>
         * @return The object to set up a function for referrer table. (NotNull)
         */
        public HpSDRFunction<TweetCB, MemberCQ> derivedTweetList() {
            assertDerived("tweetList"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return new HpSDRFunction<TweetCB, MemberCQ>(_baseCB, _qyCall.qy(), new HpSDRSetupper<TweetCB, MemberCQ>() {
                public void setup(String fn, SubQuery<TweetCB> sq, MemberCQ cq, String al, DerivedReferrerOption op) {
                    cq.xsderiveTweetList(fn, sq, al, op); } }, _dbmetaProvider);
        }
        /**
         * Prepare for (Specify)MyselfDerived (SubQuery).
         * @return The object to set up a function for myself table. (NotNull)
         */
        public HpSDRFunction<MemberCB, MemberCQ> myselfDerived() {
            assertDerived("myselfDerived"); if (xhasSyncQyCall()) { xsyncQyCall().qy(); } // for sync (for example, this in ColumnQuery)
            return new HpSDRFunction<MemberCB, MemberCQ>(_baseCB, _qyCall.qy(), new HpSDRSetupper<MemberCB, MemberCQ>() {
                public void setup(String fn, SubQuery<MemberCB> sq, MemberCQ cq, String al, DerivedReferrerOption op) {
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
     * cb.<span style="color: #DD4747">columnQuery</span>(new SpecifyQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFoo()</span>; <span style="color: #3F7E5E">// left column</span>
     *     }
     * }).lessThan(new SpecifyQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnBar()</span>; <span style="color: #3F7E5E">// right column</span>
     *     }
     * }); <span style="color: #3F7E5E">// you can calculate for right column like '}).plus(3);'</span>
     * </pre>
     * @param leftSpecifyQuery The specify-query for left column. (NotNull)
     * @return The object for setting up operand and right column. (NotNull)
     */
    public HpColQyOperand<MemberCB> columnQuery(final SpecifyQuery<MemberCB> leftSpecifyQuery) {
        return new HpColQyOperand<MemberCB>(new HpColQyHandler<MemberCB>() {
            public HpCalculator handle(SpecifyQuery<MemberCB> rightSp, String operand) {
                return xcolqy(xcreateColumnQueryCB(), xcreateColumnQueryCB(), leftSpecifyQuery, rightSp, operand);
            }
        });
    }

    protected MemberCB xcreateColumnQueryCB() {
        MemberCB cb = new MemberCB();
        cb.xsetupForColumnQuery((MemberCB)this);
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
    public MemberCB dreamCruiseCB() {
        MemberCB cb = new MemberCB();
        cb.xsetupForDreamCruise((MemberCB) this);
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
     * cb.<span style="color: #DD4747">orScopeQuery</span>(new OrQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.query().setBAR_Equal...
     *     }
     * });
     * </pre>
     * @param orQuery The query for or-condition. (NotNull)
     */
    public void orScopeQuery(OrQuery<MemberCB> orQuery) {
        xorSQ((MemberCB)this, orQuery);
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
     * cb.<span style="color: #DD4747">orScopeQuery</span>(new OrQuery&lt;MemberCB&gt;() {
     *     public void query(MemberCB orCB) {
     *         orCB.query().setFOO_Equal...
     *         orCB.<span style="color: #DD4747">orScopeQueryAndPart</span>(new AndQuery&lt;MemberCB&gt;() {
     *             public void query(MemberCB andCB) {
     *                 andCB.query().setBar_...
     *                 andCB.query().setQux_...
     *             }
     *         });
     *     }
     * });
     * </pre>
     * @param andQuery The query for and-condition. (NotNull)
     */
    public void orScopeQueryAndPart(AndQuery<MemberCB> andQuery) {
        xorSQAP((MemberCB)this, andQuery);
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
        final MemberCB cb;
        if (mainCB != null) {
            cb = (MemberCB)mainCB;
        } else {
            cb = new MemberCB();
        }
        specify().xsetSyncQyCall(new HpSpQyCall<MemberCQ>() {
            public boolean has() { return true; }
            public MemberCQ qy() { return cb.query(); }
        });
    }

    // ===================================================================================
    //                                                                            Internal
    //                                                                            ========
    // very internal (for suppressing warn about 'Not Use Import')
    protected String getConditionBeanClassNameInternally() { return MemberCB.class.getName(); }
    protected String getConditionQueryClassNameInternally() { return MemberCQ.class.getName(); }
    protected String getSubQueryClassNameInternally() { return SubQuery.class.getName(); }
    protected String getConditionOptionClassNameInternally() { return ConditionOption.class.getName(); }
}
