package jp.bizreach.twitter.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.optional.OptionalEntity;
import org.seasar.dbflute.outsidesql.executor.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.exentity.*;
import jp.bizreach.twitter.dbflute.bsentity.dbmeta.*;
import jp.bizreach.twitter.dbflute.cbean.*;

/**
 * The behavior of cls_black_company_status as TABLE. <br />
 * <pre>
 * [primary key]
 *     BLACK_COMPANY_STATUS_CD
 *
 * [column]
 *     BLACK_COMPANY_STATUS_CD, CODE_NAME, CODE_ALIAS, CODE_DISPLAY_NO, CODE_COMMENT, CODE_ALIAS_EN
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     
 *
 * [referrer table]
 *     black_company
 *
 * [foreign property]
 *     
 *
 * [referrer property]
 *     blackCompanyList
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsClsBlackCompanyStatusBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "cls_black_company_status"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return ClsBlackCompanyStatusDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public ClsBlackCompanyStatusDbm getMyDBMeta() { return ClsBlackCompanyStatusDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public ClsBlackCompanyStatus newMyEntity() { return new ClsBlackCompanyStatus(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public ClsBlackCompanyStatusCB newMyConditionBean() { return new ClsBlackCompanyStatusCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * int count = clsBlackCompanyStatusBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(ClsBlackCompanyStatusCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(ClsBlackCompanyStatusCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(ClsBlackCompanyStatusCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    @Override
    protected int doReadCount(ConditionBean cb) {
        return selectCount(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean. #beforejava8 <br />
     * <span style="color: #AD4747; font-size: 120%">The return might be null if no data, so you should have null check.</span> <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, use selectEntityWithDeletedCheck().</span>
     * <pre>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * ClsBlackCompanyStatus clsBlackCompanyStatus = clsBlackCompanyStatusBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (clsBlackCompanyStatus != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = clsBlackCompanyStatus.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ClsBlackCompanyStatus selectEntity(ClsBlackCompanyStatusCB cb) {
        return doSelectEntity(cb, ClsBlackCompanyStatus.class);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> ENTITY doSelectEntity(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, ClsBlackCompanyStatusCB>() {
            public List<ENTITY> callbackSelectList(ClsBlackCompanyStatusCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends ClsBlackCompanyStatus> OptionalEntity<ENTITY> doSelectOptionalEntity(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    @Override
    protected Entity doReadEntity(ConditionBean cb) {
        return selectEntity(downcast(cb));
    }

    /**
     * Select the entity by the condition-bean with deleted check. <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, this method is good.</span>
     * <pre>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * ClsBlackCompanyStatus clsBlackCompanyStatus = clsBlackCompanyStatusBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = clsBlackCompanyStatus.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ClsBlackCompanyStatus selectEntityWithDeletedCheck(ClsBlackCompanyStatusCB cb) {
        return doSelectEntityWithDeletedCheck(cb, ClsBlackCompanyStatus.class);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> ENTITY doSelectEntityWithDeletedCheck(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, ClsBlackCompanyStatusCB>() {
            public List<ENTITY> callbackSelectList(ClsBlackCompanyStatusCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param blackCompanyStatusCd : PK, NotNull, CHAR(3). (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ClsBlackCompanyStatus selectByPKValue(String blackCompanyStatusCd) {
        return doSelectByPK(blackCompanyStatusCd, ClsBlackCompanyStatus.class);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> ENTITY doSelectByPK(String blackCompanyStatusCd, Class<ENTITY> entityType) {
        return doSelectEntity(xprepareCBAsPK(blackCompanyStatusCd), entityType);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> OptionalEntity<ENTITY> doSelectOptionalByPK(String blackCompanyStatusCd, Class<ENTITY> entityType) {
        return createOptionalEntity(doSelectByPK(blackCompanyStatusCd, entityType), blackCompanyStatusCd);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param blackCompanyStatusCd : PK, NotNull, CHAR(3). (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public ClsBlackCompanyStatus selectByPKValueWithDeletedCheck(String blackCompanyStatusCd) {
        return doSelectByPKWithDeletedCheck(blackCompanyStatusCd, ClsBlackCompanyStatus.class);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> ENTITY doSelectByPKWithDeletedCheck(String blackCompanyStatusCd, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(blackCompanyStatusCd), entityType);
    }

    protected ClsBlackCompanyStatusCB xprepareCBAsPK(String blackCompanyStatusCd) {
        assertObjectNotNull("blackCompanyStatusCd", blackCompanyStatusCd);
        ClsBlackCompanyStatusCB cb = newMyConditionBean(); cb.acceptPrimaryKey(blackCompanyStatusCd);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;ClsBlackCompanyStatus&gt; clsBlackCompanyStatusList = clsBlackCompanyStatusBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (ClsBlackCompanyStatus clsBlackCompanyStatus : clsBlackCompanyStatusList) {
     *     ... = clsBlackCompanyStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<ClsBlackCompanyStatus> selectList(ClsBlackCompanyStatusCB cb) {
        return doSelectList(cb, ClsBlackCompanyStatus.class);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> ListResultBean<ENTITY> doSelectList(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, ClsBlackCompanyStatusCB>() {
            public List<ENTITY> callbackSelectList(ClsBlackCompanyStatusCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
    }

    @Override
    protected ListResultBean<? extends Entity> doReadList(ConditionBean cb) {
        return selectList(downcast(cb));
    }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;ClsBlackCompanyStatus&gt; page = clsBlackCompanyStatusBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (ClsBlackCompanyStatus clsBlackCompanyStatus : page) {
     *     ... = clsBlackCompanyStatus.get...();
     * }
     * </pre>
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<ClsBlackCompanyStatus> selectPage(ClsBlackCompanyStatusCB cb) {
        return doSelectPage(cb, ClsBlackCompanyStatus.class);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> PagingResultBean<ENTITY> doSelectPage(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, ClsBlackCompanyStatusCB>() {
            public int callbackSelectCount(ClsBlackCompanyStatusCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    @Override
    protected PagingResultBean<? extends Entity> doReadPage(ConditionBean cb) {
        return selectPage(downcast(cb));
    }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;ClsBlackCompanyStatus&gt;() {
     *     public void handle(ClsBlackCompanyStatus entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @param entityRowHandler The handler of entity row of ClsBlackCompanyStatus. (NotNull)
     */
    public void selectCursor(ClsBlackCompanyStatusCB cb, EntityRowHandler<ClsBlackCompanyStatus> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, ClsBlackCompanyStatus.class);
    }

    protected <ENTITY extends ClsBlackCompanyStatus> void doSelectCursor(ClsBlackCompanyStatusCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, ClsBlackCompanyStatusCB>() {
            public void callbackSelectCursor(ClsBlackCompanyStatusCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(ClsBlackCompanyStatusCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<ClsBlackCompanyStatusCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends ClsBlackCompanyStatusCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends ClsBlackCompanyStatusCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
        return new SLFunction<CB, RESULT>(cb, tp);
    }

    protected <RESULT> SLFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) {
        return doScalarSelect(tp, newMyConditionBean());
    }

    // ===================================================================================
    //                                                                            Sequence
    //                                                                            ========
    @Override
    protected Number doReadNextVal() {
        String msg = "This table is NOT related to sequence: " + getTableDbName();
        throw new UnsupportedOperationException(msg);
    }

    // ===================================================================================
    //                                                                       Load Referrer
    //                                                                       =============
    /**
     * Load referrer of blackCompanyList by the set-upper of referrer. <br />
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyList'.
     * <pre>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">loadBlackCompanyList</span>(clsBlackCompanyStatusList, new ConditionBeanSetupper&lt;BlackCompanyCB&gt;() {
     *     public void setup(BlackCompanyCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * for (ClsBlackCompanyStatus clsBlackCompanyStatus : clsBlackCompanyStatusList) {
     *     ... = clsBlackCompanyStatus.<span style="color: #DD4747">getBlackCompanyList()</span>;
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setBlackCompanyStatusCd_InScope(pkList);
     * cb.query().addOrderBy_BlackCompanyStatusCd_Asc();
     * </pre>
     * @param clsBlackCompanyStatusList The entity list of clsBlackCompanyStatus. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<BlackCompany> loadBlackCompanyList(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, ConditionBeanSetupper<BlackCompanyCB> setupper) {
        xassLRArg(clsBlackCompanyStatusList, setupper);
        return doLoadBlackCompanyList(clsBlackCompanyStatusList, new LoadReferrerOption<BlackCompanyCB, BlackCompany>().xinit(setupper));
    }

    /**
     * Load referrer of blackCompanyList by the set-upper of referrer. <br />
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyList'.
     * <pre>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">loadBlackCompanyList</span>(clsBlackCompanyStatusList, new ConditionBeanSetupper&lt;BlackCompanyCB&gt;() {
     *     public void setup(BlackCompanyCB cb) {
     *         cb.setupSelect...();
     *         cb.query().setFoo...(value);
     *         cb.query().addOrderBy_Bar...();
     *     }
     * }); <span style="color: #3F7E5E">// you can load nested referrer from here</span>
     * <span style="color: #3F7E5E">//}).withNestedList(referrerList -&gt {</span>
     * <span style="color: #3F7E5E">//    ...</span>
     * <span style="color: #3F7E5E">//});</span>
     * ... = clsBlackCompanyStatus.<span style="color: #DD4747">getBlackCompanyList()</span>;
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has settings before callback as follows:
     * <pre>
     * cb.query().setBlackCompanyStatusCd_InScope(pkList);
     * cb.query().addOrderBy_BlackCompanyStatusCd_Asc();
     * </pre>
     * @param clsBlackCompanyStatus The entity of clsBlackCompanyStatus. (NotNull)
     * @param setupper The callback to set up referrer condition-bean for loading referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<BlackCompany> loadBlackCompanyList(ClsBlackCompanyStatus clsBlackCompanyStatus, ConditionBeanSetupper<BlackCompanyCB> setupper) {
        xassLRArg(clsBlackCompanyStatus, setupper);
        return doLoadBlackCompanyList(xnewLRLs(clsBlackCompanyStatus), new LoadReferrerOption<BlackCompanyCB, BlackCompany>().xinit(setupper));
    }

    /**
     * {Refer to overload method that has an argument of the list of entity.} #beforejava8
     * @param clsBlackCompanyStatus The entity of clsBlackCompanyStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    public NestedReferrerLoader<BlackCompany> loadBlackCompanyList(ClsBlackCompanyStatus clsBlackCompanyStatus, LoadReferrerOption<BlackCompanyCB, BlackCompany> loadReferrerOption) {
        xassLRArg(clsBlackCompanyStatus, loadReferrerOption);
        return loadBlackCompanyList(xnewLRLs(clsBlackCompanyStatus), loadReferrerOption);
    }

    /**
     * {Refer to overload method that has an argument of condition-bean setupper.} #beforejava8
     * @param clsBlackCompanyStatusList The entity list of clsBlackCompanyStatus. (NotNull)
     * @param loadReferrerOption The option of load-referrer. (NotNull)
     * @return The callback interface which you can load nested referrer by calling withNestedReferrer(). (NotNull)
     */
    @SuppressWarnings("unchecked")
    public NestedReferrerLoader<BlackCompany> loadBlackCompanyList(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, LoadReferrerOption<BlackCompanyCB, BlackCompany> loadReferrerOption) {
        xassLRArg(clsBlackCompanyStatusList, loadReferrerOption);
        if (clsBlackCompanyStatusList.isEmpty()) { return (NestedReferrerLoader<BlackCompany>)EMPTY_LOADER; }
        return doLoadBlackCompanyList(clsBlackCompanyStatusList, loadReferrerOption);
    }

    protected NestedReferrerLoader<BlackCompany> doLoadBlackCompanyList(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, LoadReferrerOption<BlackCompanyCB, BlackCompany> option) {
        final BlackCompanyBhv referrerBhv = xgetBSFLR().select(BlackCompanyBhv.class);
        return helpLoadReferrerInternally(clsBlackCompanyStatusList, option, new InternalLoadReferrerCallback<ClsBlackCompanyStatus, String, BlackCompanyCB, BlackCompany>() {
            public String getPKVal(ClsBlackCompanyStatus et)
            { return et.getBlackCompanyStatusCd(); }
            public void setRfLs(ClsBlackCompanyStatus et, List<BlackCompany> ls)
            { et.setBlackCompanyList(ls); }
            public BlackCompanyCB newMyCB() { return referrerBhv.newMyConditionBean(); }
            public void qyFKIn(BlackCompanyCB cb, List<String> ls)
            { cb.query().setBlackCompanyStatusCd_InScope(ls); }
            public void qyOdFKAsc(BlackCompanyCB cb) { cb.query().addOrderBy_BlackCompanyStatusCd_Asc(); }
            public void spFKCol(BlackCompanyCB cb) { cb.specify().columnBlackCompanyStatusCd(); }
            public List<BlackCompany> selRfLs(BlackCompanyCB cb) { return referrerBhv.selectList(cb); }
            public String getFKVal(BlackCompany re) { return re.getBlackCompanyStatusCd(); }
            public void setlcEt(BlackCompany re, ClsBlackCompanyStatus le)
            { re.setClsBlackCompanyStatus(le); }
            public String getRfPrNm() { return "blackCompanyList"; }
        });
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key blackCompanyStatusCd.
     * @param clsBlackCompanyStatusList The list of clsBlackCompanyStatus. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<String> extractBlackCompanyStatusCdList(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList) {
        return helpExtractListInternally(clsBlackCompanyStatusList, new InternalExtractCallback<ClsBlackCompanyStatus, String>() {
            public String getCV(ClsBlackCompanyStatus et) { return et.getBlackCompanyStatusCd(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * clsBlackCompanyStatus.setFoo...(value);
     * clsBlackCompanyStatus.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.set...;</span>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">insert</span>(clsBlackCompanyStatus);
     * ... = clsBlackCompanyStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param clsBlackCompanyStatus The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(ClsBlackCompanyStatus clsBlackCompanyStatus) {
        doInsert(clsBlackCompanyStatus, null);
    }

    protected void doInsert(ClsBlackCompanyStatus clsBlackCompanyStatus, InsertOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("clsBlackCompanyStatus", clsBlackCompanyStatus);
        prepareInsertOption(op);
        delegateInsert(clsBlackCompanyStatus, op);
    }

    protected void prepareInsertOption(InsertOption<ClsBlackCompanyStatusCB> op) {
        if (op == null) { return; }
        assertInsertOptionStatus(op);
        if (op.hasSpecifiedInsertColumn()) {
            op.resolveInsertColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    @Override
    protected void doCreate(Entity et, InsertOption<? extends ConditionBean> op) {
        if (op == null) { insert(downcast(et)); }
        else { varyingInsert(downcast(et), downcast(op)); }
    }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     * clsBlackCompanyStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * clsBlackCompanyStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * clsBlackCompanyStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     clsBlackCompanyStatusBhv.<span style="color: #DD4747">update</span>(clsBlackCompanyStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param clsBlackCompanyStatus The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final ClsBlackCompanyStatus clsBlackCompanyStatus) {
        doUpdate(clsBlackCompanyStatus, null);
    }

    protected void doUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus, final UpdateOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("clsBlackCompanyStatus", clsBlackCompanyStatus);
        prepareUpdateOption(op);
        helpUpdateInternally(clsBlackCompanyStatus, new InternalUpdateCallback<ClsBlackCompanyStatus>() {
            public int callbackDelegateUpdate(ClsBlackCompanyStatus et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<ClsBlackCompanyStatusCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected ClsBlackCompanyStatusCB createCBForVaryingUpdate() {
        ClsBlackCompanyStatusCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected ClsBlackCompanyStatusCB createCBForSpecifiedUpdate() {
        ClsBlackCompanyStatusCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { update(downcast(et)); }
        else { varyingUpdate(downcast(et), downcast(op)); }
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        doModify(et, op);
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param clsBlackCompanyStatus The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus) {
        doInesrtOrUpdate(clsBlackCompanyStatus, null, null);
    }

    protected void doInesrtOrUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus, final InsertOption<ClsBlackCompanyStatusCB> iop, final UpdateOption<ClsBlackCompanyStatusCB> uop) {
        helpInsertOrUpdateInternally(clsBlackCompanyStatus, new InternalInsertOrUpdateCallback<ClsBlackCompanyStatus, ClsBlackCompanyStatusCB>() {
            public void callbackInsert(ClsBlackCompanyStatus et) { doInsert(et, iop); }
            public void callbackUpdate(ClsBlackCompanyStatus et) { doUpdate(et, uop); }
            public ClsBlackCompanyStatusCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(ClsBlackCompanyStatusCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<ClsBlackCompanyStatusCB>();
            uop = uop != null ? uop : new UpdateOption<ClsBlackCompanyStatusCB>();
            varyingInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
        }
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        doCreateOrModify(et, iop, uop);
    }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     * clsBlackCompanyStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * clsBlackCompanyStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     clsBlackCompanyStatusBhv.<span style="color: #DD4747">delete</span>(clsBlackCompanyStatus);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param clsBlackCompanyStatus The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(ClsBlackCompanyStatus clsBlackCompanyStatus) {
        doDelete(clsBlackCompanyStatus, null);
    }

    protected void doDelete(ClsBlackCompanyStatus clsBlackCompanyStatus, final DeleteOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("clsBlackCompanyStatus", clsBlackCompanyStatus);
        prepareDeleteOption(op);
        helpDeleteInternally(clsBlackCompanyStatus, new InternalDeleteCallback<ClsBlackCompanyStatus>() {
            public int callbackDelegateDelete(ClsBlackCompanyStatus et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<ClsBlackCompanyStatusCB> op) {
        if (op == null) { return; }
        assertDeleteOptionStatus(op);
    }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { delete(downcast(et)); }
        else { varyingDelete(downcast(et), downcast(op)); }
    }

    @Override
    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op) {
        doRemove(et, op);
    }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #DD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * for (... : ...) {
     *     ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     *     clsBlackCompanyStatus.setFooName("foo");
     *     if (...) {
     *         clsBlackCompanyStatus.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     clsBlackCompanyStatusList.add(clsBlackCompanyStatus);
     * }
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">batchInsert</span>(clsBlackCompanyStatusList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param clsBlackCompanyStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList) {
        InsertOption<ClsBlackCompanyStatusCB> op = createInsertUpdateOption();
        return doBatchInsert(clsBlackCompanyStatusList, op);
    }

    protected int[] doBatchInsert(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, InsertOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("clsBlackCompanyStatusList", clsBlackCompanyStatusList);
        prepareBatchInsertOption(clsBlackCompanyStatusList, op);
        return delegateBatchInsert(clsBlackCompanyStatusList, op);
    }

    protected void prepareBatchInsertOption(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, InsertOption<ClsBlackCompanyStatusCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(clsBlackCompanyStatusList);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        if (op == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     *     clsBlackCompanyStatus.setFooName("foo");
     *     if (...) {
     *         clsBlackCompanyStatus.setFooPrice(123);
     *     } else {
     *         clsBlackCompanyStatus.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//clsBlackCompanyStatus.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     clsBlackCompanyStatusList.add(clsBlackCompanyStatus);
     * }
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">batchUpdate</span>(clsBlackCompanyStatusList);
     * </pre>
     * @param clsBlackCompanyStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList) {
        UpdateOption<ClsBlackCompanyStatusCB> op = createPlainUpdateOption();
        return doBatchUpdate(clsBlackCompanyStatusList, op);
    }

    protected int[] doBatchUpdate(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, UpdateOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("clsBlackCompanyStatusList", clsBlackCompanyStatusList);
        prepareBatchUpdateOption(clsBlackCompanyStatusList, op);
        return delegateBatchUpdate(clsBlackCompanyStatusList, op);
    }

    protected void prepareBatchUpdateOption(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, UpdateOption<ClsBlackCompanyStatusCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(clsBlackCompanyStatusList);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">batchUpdate</span>(clsBlackCompanyStatusList, new SpecifyQuery<ClsBlackCompanyStatusCB>() {
     *     public void specify(ClsBlackCompanyStatusCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">batchUpdate</span>(clsBlackCompanyStatusList, new SpecifyQuery<ClsBlackCompanyStatusCB>() {
     *     public void specify(ClsBlackCompanyStatusCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param clsBlackCompanyStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, SpecifyQuery<ClsBlackCompanyStatusCB> updateColumnSpec) {
        return doBatchUpdate(clsBlackCompanyStatusList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param clsBlackCompanyStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList) {
        return doBatchDelete(clsBlackCompanyStatusList, null);
    }

    protected int[] doBatchDelete(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, DeleteOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("clsBlackCompanyStatusList", clsBlackCompanyStatusList);
        prepareDeleteOption(op);
        return delegateBatchDelete(clsBlackCompanyStatusList, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(op)); }
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        return doLumpRemove(ls, op);
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;ClsBlackCompanyStatus, ClsBlackCompanyStatusCB&gt;() {
     *     public ConditionBean setup(clsBlackCompanyStatus entity, ClsBlackCompanyStatusCB intoCB) {
     *         FooCB cb = FooCB();
     *         cb.setupSelect_Bar();
     *
     *         <span style="color: #3F7E5E">// mapping</span>
     *         intoCB.specify().columnMyName().mappedFrom(cb.specify().columnFooName());
     *         intoCB.specify().columnMyCount().mappedFrom(cb.specify().columnFooCount());
     *         intoCB.specify().columnMyDate().mappedFrom(cb.specify().specifyBar().columnBarDate());
     *         entity.setMyFixedValue("foo"); <span style="color: #3F7E5E">// fixed value</span>
     *         <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     *         <span style="color: #3F7E5E">//entity.setRegisterUser(value);</span>
     *         <span style="color: #3F7E5E">//entity.set...;</span>
     *         <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<ClsBlackCompanyStatus, ClsBlackCompanyStatusCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<ClsBlackCompanyStatus, ClsBlackCompanyStatusCB> sp, InsertOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        ClsBlackCompanyStatus e = new ClsBlackCompanyStatus();
        ClsBlackCompanyStatusCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected ClsBlackCompanyStatusCB createCBForQueryInsert() {
        ClsBlackCompanyStatusCB cb = newMyConditionBean();
        cb.xsetupForQueryInsert();
        return cb;
    }

    @Override
    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> option) {
        if (option == null) { return queryInsert(downcast(setupper)); }
        else { return varyingQueryInsert(downcast(setupper), downcast(option)); }
    }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.setPK...(value);</span>
     * clsBlackCompanyStatus.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.setVersionNo(value);</span>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">queryUpdate</span>(clsBlackCompanyStatus, cb);
     * </pre>
     * @param clsBlackCompanyStatus The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus, ClsBlackCompanyStatusCB cb) {
        return doQueryUpdate(clsBlackCompanyStatus, cb, null);
    }

    protected int doQueryUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus, ClsBlackCompanyStatusCB cb, UpdateOption<ClsBlackCompanyStatusCB> op) {
        assertObjectNotNull("clsBlackCompanyStatus", clsBlackCompanyStatus); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(clsBlackCompanyStatus, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (ClsBlackCompanyStatusCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (ClsBlackCompanyStatusCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">queryDelete</span>(clsBlackCompanyStatus, cb);
     * </pre>
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(ClsBlackCompanyStatusCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(ClsBlackCompanyStatusCB cb, DeleteOption<ClsBlackCompanyStatusCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((ClsBlackCompanyStatusCB)cb); }
        else { return varyingQueryDelete((ClsBlackCompanyStatusCB)cb, downcast(op)); }
    }

    // ===================================================================================
    //                                                                      Varying Update
    //                                                                      ==============
    // -----------------------------------------------------
    //                                         Entity Update
    //                                         -------------
    /**
     * Insert the entity with varying requests. <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as insert(entity).
     * <pre>
     * ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * clsBlackCompanyStatus.setFoo...(value);
     * clsBlackCompanyStatus.setBar...(value);
     * InsertOption<ClsBlackCompanyStatusCB> option = new InsertOption<ClsBlackCompanyStatusCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">varyingInsert</span>(clsBlackCompanyStatus, option);
     * ... = clsBlackCompanyStatus.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param clsBlackCompanyStatus The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(ClsBlackCompanyStatus clsBlackCompanyStatus, InsertOption<ClsBlackCompanyStatusCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(clsBlackCompanyStatus, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     * clsBlackCompanyStatus.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * clsBlackCompanyStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * clsBlackCompanyStatus.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;ClsBlackCompanyStatusCB&gt; option = new UpdateOption&lt;ClsBlackCompanyStatusCB&gt;();
     *     option.self(new SpecifyQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *         public void specify(ClsBlackCompanyStatusCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     clsBlackCompanyStatusBhv.<span style="color: #DD4747">varyingUpdate</span>(clsBlackCompanyStatus, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param clsBlackCompanyStatus The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus, UpdateOption<ClsBlackCompanyStatusCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(clsBlackCompanyStatus, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param clsBlackCompanyStatus The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus, InsertOption<ClsBlackCompanyStatusCB> insertOption, UpdateOption<ClsBlackCompanyStatusCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(clsBlackCompanyStatus, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param clsBlackCompanyStatus The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(ClsBlackCompanyStatus clsBlackCompanyStatus, DeleteOption<ClsBlackCompanyStatusCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(clsBlackCompanyStatus, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param clsBlackCompanyStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, InsertOption<ClsBlackCompanyStatusCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(clsBlackCompanyStatusList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param clsBlackCompanyStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, UpdateOption<ClsBlackCompanyStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(clsBlackCompanyStatusList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param clsBlackCompanyStatusList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<ClsBlackCompanyStatus> clsBlackCompanyStatusList, DeleteOption<ClsBlackCompanyStatusCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(clsBlackCompanyStatusList, option);
    }

    // -----------------------------------------------------
    //                                          Query Update
    //                                          ------------
    /**
     * Insert the several entities by query with varying requests (modified-only for fixed value). <br />
     * For example, disableCommonColumnAutoSetup(), disablePrimaryKeyIdentity(). <br />
     * Other specifications are same as queryInsert(entity, setupper).
     * @param setupper The setup-per of query-insert. (NotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The inserted count.
     */
    public int varyingQueryInsert(QueryInsertSetupper<ClsBlackCompanyStatus, ClsBlackCompanyStatusCB> setupper, InsertOption<ClsBlackCompanyStatusCB> option) {
        assertInsertOptionNotNull(option);
        return doQueryInsert(setupper, option);
    }

    /**
     * Update the several entities by query with varying requests non-strictly modified-only. {NonExclusiveControl} <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), allowNonQueryUpdate(). <br />
     * Other specifications are same as queryUpdate(entity, cb).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * ClsBlackCompanyStatus clsBlackCompanyStatus = new ClsBlackCompanyStatus();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.setPK...(value);</span>
     * clsBlackCompanyStatus.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//clsBlackCompanyStatus.setVersionNo(value);</span>
     * ClsBlackCompanyStatusCB cb = new ClsBlackCompanyStatusCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;ClsBlackCompanyStatusCB&gt; option = new UpdateOption&lt;ClsBlackCompanyStatusCB&gt;();
     * option.self(new SpecifyQuery&lt;ClsBlackCompanyStatusCB&gt;() {
     *     public void specify(ClsBlackCompanyStatusCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * clsBlackCompanyStatusBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(clsBlackCompanyStatus, cb, option);
     * </pre>
     * @param clsBlackCompanyStatus The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(ClsBlackCompanyStatus clsBlackCompanyStatus, ClsBlackCompanyStatusCB cb, UpdateOption<ClsBlackCompanyStatusCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(clsBlackCompanyStatus, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of ClsBlackCompanyStatus. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(ClsBlackCompanyStatusCB cb, DeleteOption<ClsBlackCompanyStatusCB> option) {
        assertDeleteOptionNotNull(option);
        return doQueryDelete(cb, option);
    }

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    /**
     * Prepare the basic executor of outside-SQL to execute it. <br />
     * The invoker of behavior command should be not null when you call this method.
     * <pre>
     * You can use the methods for outside-SQL are as follows:
     * {Basic}
     *   o selectList()
     *   o execute()
     *   o call()
     *
     * {Entity}
     *   o entityHandling().selectEntity()
     *   o entityHandling().selectEntityWithDeletedCheck()
     *
     * {Paging}
     *   o autoPaging().selectList()
     *   o autoPaging().selectPage()
     *   o manualPaging().selectList()
     *   o manualPaging().selectPage()
     *
     * {Cursor}
     *   o cursorHandling().selectCursor()
     *
     * {Option}
     *   o dynamicBinding().selectList()
     *   o removeBlockComment().selectList()
     *   o removeLineComment().selectList()
     *   o formatSql().selectList()
     * </pre>
     * @return The basic executor of outside-SQL. (NotNull)
     */
    public OutsideSqlBasicExecutor<ClsBlackCompanyStatusBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(ClsBlackCompanyStatusCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(ClsBlackCompanyStatusCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends ClsBlackCompanyStatus> void delegateSelectCursor(ClsBlackCompanyStatusCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends ClsBlackCompanyStatus> List<ENTITY> delegateSelectList(ClsBlackCompanyStatusCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(ClsBlackCompanyStatus et, InsertOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(ClsBlackCompanyStatus et, UpdateOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(ClsBlackCompanyStatus et, UpdateOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(ClsBlackCompanyStatus et, DeleteOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(ClsBlackCompanyStatus et, DeleteOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<ClsBlackCompanyStatus> ls, InsertOption<ClsBlackCompanyStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<ClsBlackCompanyStatus> ls, UpdateOption<ClsBlackCompanyStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<ClsBlackCompanyStatus> ls, UpdateOption<ClsBlackCompanyStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<ClsBlackCompanyStatus> ls, DeleteOption<ClsBlackCompanyStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<ClsBlackCompanyStatus> ls, DeleteOption<ClsBlackCompanyStatusCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(ClsBlackCompanyStatus et, ClsBlackCompanyStatusCB inCB, ConditionBean resCB, InsertOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(ClsBlackCompanyStatus et, ClsBlackCompanyStatusCB cb, UpdateOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(ClsBlackCompanyStatusCB cb, DeleteOption<ClsBlackCompanyStatusCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity et) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasUpdateDateValue(Entity et) {
        return false;
    }

    // ===================================================================================
    //                                                                     Downcast Helper
    //                                                                     ===============
    protected ClsBlackCompanyStatus downcast(Entity et) {
        return helpEntityDowncastInternally(et, ClsBlackCompanyStatus.class);
    }

    protected ClsBlackCompanyStatusCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, ClsBlackCompanyStatusCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<ClsBlackCompanyStatus> downcast(List<? extends Entity> ls) {
        return (List<ClsBlackCompanyStatus>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<ClsBlackCompanyStatusCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<ClsBlackCompanyStatusCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<ClsBlackCompanyStatusCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<ClsBlackCompanyStatusCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<ClsBlackCompanyStatusCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<ClsBlackCompanyStatusCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<ClsBlackCompanyStatus, ClsBlackCompanyStatusCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<ClsBlackCompanyStatus, ClsBlackCompanyStatusCB>)sp;
    }
}
