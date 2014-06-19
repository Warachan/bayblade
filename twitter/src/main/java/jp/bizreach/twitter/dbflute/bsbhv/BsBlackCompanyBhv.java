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
 * The behavior of black_company as TABLE. <br />
 * <pre>
 * [primary key]
 *     BLACK_COMPANY_ID
 *
 * [column]
 *     BLACK_COMPANY_ID, BLACK_COMPANY_NAME, AGENT_COMPANY_NAME, ZIP_CODE, ADDRESS1, ADDRESS2, BLACK_COMPANY_STATUS_CD, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE, VERSION_NO
 *
 * [sequence]
 *     
 *
 * [identity]
 *     BLACK_COMPANY_ID
 *
 * [version-no]
 *     VERSION_NO
 *
 * [foreign table]
 *     cls_black_company_status
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     clsBlackCompanyStatus
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsBlackCompanyBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "black_company"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return BlackCompanyDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public BlackCompanyDbm getMyDBMeta() { return BlackCompanyDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public BlackCompany newMyEntity() { return new BlackCompany(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public BlackCompanyCB newMyConditionBean() { return new BlackCompanyCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * int count = blackCompanyBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(BlackCompanyCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(BlackCompanyCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(BlackCompanyCB cb) { // called by selectPage(cb)
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
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * BlackCompany blackCompany = blackCompanyBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (blackCompany != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = blackCompany.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public BlackCompany selectEntity(BlackCompanyCB cb) {
        return doSelectEntity(cb, BlackCompany.class);
    }

    protected <ENTITY extends BlackCompany> ENTITY doSelectEntity(BlackCompanyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, BlackCompanyCB>() {
            public List<ENTITY> callbackSelectList(BlackCompanyCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends BlackCompany> OptionalEntity<ENTITY> doSelectOptionalEntity(BlackCompanyCB cb, Class<ENTITY> tp) {
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
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * BlackCompany blackCompany = blackCompanyBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = blackCompany.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public BlackCompany selectEntityWithDeletedCheck(BlackCompanyCB cb) {
        return doSelectEntityWithDeletedCheck(cb, BlackCompany.class);
    }

    protected <ENTITY extends BlackCompany> ENTITY doSelectEntityWithDeletedCheck(BlackCompanyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, BlackCompanyCB>() {
            public List<ENTITY> callbackSelectList(BlackCompanyCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param blackCompanyId : PK, ID, NotNull, BIGINT(19). (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public BlackCompany selectByPKValue(Long blackCompanyId) {
        return doSelectByPK(blackCompanyId, BlackCompany.class);
    }

    protected <ENTITY extends BlackCompany> ENTITY doSelectByPK(Long blackCompanyId, Class<ENTITY> entityType) {
        return doSelectEntity(xprepareCBAsPK(blackCompanyId), entityType);
    }

    protected <ENTITY extends BlackCompany> OptionalEntity<ENTITY> doSelectOptionalByPK(Long blackCompanyId, Class<ENTITY> entityType) {
        return createOptionalEntity(doSelectByPK(blackCompanyId, entityType), blackCompanyId);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param blackCompanyId : PK, ID, NotNull, BIGINT(19). (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public BlackCompany selectByPKValueWithDeletedCheck(Long blackCompanyId) {
        return doSelectByPKWithDeletedCheck(blackCompanyId, BlackCompany.class);
    }

    protected <ENTITY extends BlackCompany> ENTITY doSelectByPKWithDeletedCheck(Long blackCompanyId, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(blackCompanyId), entityType);
    }

    protected BlackCompanyCB xprepareCBAsPK(Long blackCompanyId) {
        assertObjectNotNull("blackCompanyId", blackCompanyId);
        BlackCompanyCB cb = newMyConditionBean(); cb.acceptPrimaryKey(blackCompanyId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;BlackCompany&gt; blackCompanyList = blackCompanyBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (BlackCompany blackCompany : blackCompanyList) {
     *     ... = blackCompany.get...();
     * }
     * </pre>
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<BlackCompany> selectList(BlackCompanyCB cb) {
        return doSelectList(cb, BlackCompany.class);
    }

    protected <ENTITY extends BlackCompany> ListResultBean<ENTITY> doSelectList(BlackCompanyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, BlackCompanyCB>() {
            public List<ENTITY> callbackSelectList(BlackCompanyCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;BlackCompany&gt; page = blackCompanyBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (BlackCompany blackCompany : page) {
     *     ... = blackCompany.get...();
     * }
     * </pre>
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<BlackCompany> selectPage(BlackCompanyCB cb) {
        return doSelectPage(cb, BlackCompany.class);
    }

    protected <ENTITY extends BlackCompany> PagingResultBean<ENTITY> doSelectPage(BlackCompanyCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, BlackCompanyCB>() {
            public int callbackSelectCount(BlackCompanyCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(BlackCompanyCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * blackCompanyBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;BlackCompany&gt;() {
     *     public void handle(BlackCompany entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @param entityRowHandler The handler of entity row of BlackCompany. (NotNull)
     */
    public void selectCursor(BlackCompanyCB cb, EntityRowHandler<BlackCompany> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, BlackCompany.class);
    }

    protected <ENTITY extends BlackCompany> void doSelectCursor(BlackCompanyCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, BlackCompanyCB>() {
            public void callbackSelectCursor(BlackCompanyCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(BlackCompanyCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * blackCompanyBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(BlackCompanyCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<BlackCompanyCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends BlackCompanyCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends BlackCompanyCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
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
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'ClsBlackCompanyStatus'.
     * @param blackCompanyList The list of blackCompany. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<ClsBlackCompanyStatus> pulloutClsBlackCompanyStatus(List<BlackCompany> blackCompanyList) {
        return helpPulloutInternally(blackCompanyList, new InternalPulloutCallback<BlackCompany, ClsBlackCompanyStatus>() {
            public ClsBlackCompanyStatus getFr(BlackCompany et)
            { return et.getClsBlackCompanyStatus(); }
            public boolean hasRf() { return true; }
            public void setRfLs(ClsBlackCompanyStatus et, List<BlackCompany> ls)
            { et.setBlackCompanyList(ls); }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key blackCompanyId.
     * @param blackCompanyList The list of blackCompany. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Long> extractBlackCompanyIdList(List<BlackCompany> blackCompanyList) {
        return helpExtractListInternally(blackCompanyList, new InternalExtractCallback<BlackCompany, Long>() {
            public Long getCV(BlackCompany et) { return et.getBlackCompanyId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * BlackCompany blackCompany = new BlackCompany();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * blackCompany.setFoo...(value);
     * blackCompany.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//blackCompany.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//blackCompany.set...;</span>
     * blackCompanyBhv.<span style="color: #DD4747">insert</span>(blackCompany);
     * ... = blackCompany.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param blackCompany The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(BlackCompany blackCompany) {
        doInsert(blackCompany, null);
    }

    protected void doInsert(BlackCompany blackCompany, InsertOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompany", blackCompany);
        prepareInsertOption(op);
        delegateInsert(blackCompany, op);
    }

    protected void prepareInsertOption(InsertOption<BlackCompanyCB> op) {
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
     * Update the entity modified-only. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * BlackCompany blackCompany = new BlackCompany();
     * blackCompany.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * blackCompany.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//blackCompany.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//blackCompany.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * blackCompany.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     blackCompanyBhv.<span style="color: #DD4747">update</span>(blackCompany);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param blackCompany The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final BlackCompany blackCompany) {
        doUpdate(blackCompany, null);
    }

    protected void doUpdate(BlackCompany blackCompany, final UpdateOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompany", blackCompany);
        prepareUpdateOption(op);
        helpUpdateInternally(blackCompany, new InternalUpdateCallback<BlackCompany>() {
            public int callbackDelegateUpdate(BlackCompany et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<BlackCompanyCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected BlackCompanyCB createCBForVaryingUpdate() {
        BlackCompanyCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected BlackCompanyCB createCBForSpecifiedUpdate() {
        BlackCompanyCB cb = newMyConditionBean();
        cb.xsetupForSpecifiedUpdate();
        return cb;
    }

    @Override
    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { update(downcast(et)); }
        else { varyingUpdate(downcast(et), downcast(op)); }
    }

    /**
     * Update the entity non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * BlackCompany blackCompany = new BlackCompany();
     * blackCompany.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * blackCompany.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//blackCompany.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//blackCompany.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//blackCompany.setVersionNo(value);</span>
     * blackCompanyBhv.<span style="color: #DD4747">updateNonstrict</span>(blackCompany);
     * </pre>
     * @param blackCompany The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void updateNonstrict(final BlackCompany blackCompany) {
        doUpdateNonstrict(blackCompany, null);
    }

    protected void doUpdateNonstrict(BlackCompany blackCompany, final UpdateOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompany", blackCompany);
        prepareUpdateOption(op);
        helpUpdateNonstrictInternally(blackCompany, new InternalUpdateNonstrictCallback<BlackCompany>() {
            public int callbackDelegateUpdateNonstrict(BlackCompany et) { return delegateUpdateNonstrict(et, op); } });
    }

    @Override
    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { updateNonstrict(downcast(et)); }
        else { varyingUpdateNonstrict(downcast(et), downcast(op)); }
    }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, ExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param blackCompany The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(BlackCompany blackCompany) {
        doInesrtOrUpdate(blackCompany, null, null);
    }

    protected void doInesrtOrUpdate(BlackCompany blackCompany, final InsertOption<BlackCompanyCB> iop, final UpdateOption<BlackCompanyCB> uop) {
        helpInsertOrUpdateInternally(blackCompany, new InternalInsertOrUpdateCallback<BlackCompany, BlackCompanyCB>() {
            public void callbackInsert(BlackCompany et) { doInsert(et, iop); }
            public void callbackUpdate(BlackCompany et) { doUpdate(et, uop); }
            public BlackCompanyCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(BlackCompanyCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<BlackCompanyCB>();
            uop = uop != null ? uop : new UpdateOption<BlackCompanyCB>();
            varyingInsertOrUpdate(downcast(et), downcast(iop), downcast(uop));
        }
    }

    /**
     * Insert or update the entity non-strictly modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() }
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param blackCompany The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdateNonstrict(BlackCompany blackCompany) {
        doInesrtOrUpdateNonstrict(blackCompany, null, null);
    }

    protected void doInesrtOrUpdateNonstrict(BlackCompany blackCompany, final InsertOption<BlackCompanyCB> iop, final UpdateOption<BlackCompanyCB> uop) {
        helpInsertOrUpdateInternally(blackCompany, new InternalInsertOrUpdateNonstrictCallback<BlackCompany>() {
            public void callbackInsert(BlackCompany et) { doInsert(et, iop); }
            public void callbackUpdateNonstrict(BlackCompany et) { doUpdateNonstrict(et, uop); }
        });
    }

    @Override
    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdateNonstrict(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<BlackCompanyCB>();
            uop = uop != null ? uop : new UpdateOption<BlackCompanyCB>();
            varyingInsertOrUpdateNonstrict(downcast(et), downcast(iop), downcast(uop));
        }
    }

    /**
     * Delete the entity. (ZeroUpdateException, ExclusiveControl)
     * <pre>
     * BlackCompany blackCompany = new BlackCompany();
     * blackCompany.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * blackCompany.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     blackCompanyBhv.<span style="color: #DD4747">delete</span>(blackCompany);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param blackCompany The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(BlackCompany blackCompany) {
        doDelete(blackCompany, null);
    }

    protected void doDelete(BlackCompany blackCompany, final DeleteOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompany", blackCompany);
        prepareDeleteOption(op);
        helpDeleteInternally(blackCompany, new InternalDeleteCallback<BlackCompany>() {
            public int callbackDelegateDelete(BlackCompany et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<BlackCompanyCB> op) {
        if (op == null) { return; }
        assertDeleteOptionStatus(op);
    }

    @Override
    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { delete(downcast(et)); }
        else { varyingDelete(downcast(et), downcast(op)); }
    }

    /**
     * Delete the entity non-strictly. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * BlackCompany blackCompany = new BlackCompany();
     * blackCompany.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//blackCompany.setVersionNo(value);</span>
     * blackCompanyBhv.<span style="color: #DD4747">deleteNonstrict</span>(blackCompany);
     * </pre>
     * @param blackCompany The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrict(BlackCompany blackCompany) {
        doDeleteNonstrict(blackCompany, null);
    }

    protected void doDeleteNonstrict(BlackCompany blackCompany, final DeleteOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompany", blackCompany);
        prepareDeleteOption(op);
        helpDeleteNonstrictInternally(blackCompany, new InternalDeleteNonstrictCallback<BlackCompany>() {
            public int callbackDelegateDeleteNonstrict(BlackCompany et) { return delegateDeleteNonstrict(et, op); } });
    }

    /**
     * Delete the entity non-strictly ignoring deleted. {ZeroUpdateException, NonExclusiveControl}
     * <pre>
     * BlackCompany blackCompany = new BlackCompany();
     * blackCompany.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//blackCompany.setVersionNo(value);</span>
     * blackCompanyBhv.<span style="color: #DD4747">deleteNonstrictIgnoreDeleted</span>(blackCompany);
     * <span style="color: #3F7E5E">// if the target entity doesn't exist, no exception</span>
     * </pre>
     * @param blackCompany The entity of delete target. (NotNull, PrimaryKeyNotNull)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void deleteNonstrictIgnoreDeleted(BlackCompany blackCompany) {
        doDeleteNonstrictIgnoreDeleted(blackCompany, null);
    }

    protected void doDeleteNonstrictIgnoreDeleted(BlackCompany blackCompany, final DeleteOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompany", blackCompany);
        prepareDeleteOption(op);
        helpDeleteNonstrictIgnoreDeletedInternally(blackCompany, new InternalDeleteNonstrictIgnoreDeletedCallback<BlackCompany>() {
            public int callbackDelegateDeleteNonstrict(BlackCompany et) { return delegateDeleteNonstrict(et, op); } });
    }

    @Override
    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { deleteNonstrict(downcast(et)); }
        else { varyingDeleteNonstrict(downcast(et), downcast(op)); }
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
     *     BlackCompany blackCompany = new BlackCompany();
     *     blackCompany.setFooName("foo");
     *     if (...) {
     *         blackCompany.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     blackCompanyList.add(blackCompany);
     * }
     * blackCompanyBhv.<span style="color: #DD4747">batchInsert</span>(blackCompanyList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<BlackCompany> blackCompanyList) {
        InsertOption<BlackCompanyCB> op = createInsertUpdateOption();
        return doBatchInsert(blackCompanyList, op);
    }

    protected int[] doBatchInsert(List<BlackCompany> blackCompanyList, InsertOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompanyList", blackCompanyList);
        prepareBatchInsertOption(blackCompanyList, op);
        return delegateBatchInsert(blackCompanyList, op);
    }

    protected void prepareBatchInsertOption(List<BlackCompany> blackCompanyList, InsertOption<BlackCompanyCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(blackCompanyList);
        prepareInsertOption(op);
    }

    @Override
    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) {
        if (op == null) { return batchInsert(downcast(ls)); }
        else { return varyingBatchInsert(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list modified-only of same-set columns. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     BlackCompany blackCompany = new BlackCompany();
     *     blackCompany.setFooName("foo");
     *     if (...) {
     *         blackCompany.setFooPrice(123);
     *     } else {
     *         blackCompany.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//blackCompany.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     blackCompanyList.add(blackCompany);
     * }
     * blackCompanyBhv.<span style="color: #DD4747">batchUpdate</span>(blackCompanyList);
     * </pre>
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<BlackCompany> blackCompanyList) {
        UpdateOption<BlackCompanyCB> op = createPlainUpdateOption();
        return doBatchUpdate(blackCompanyList, op);
    }

    protected int[] doBatchUpdate(List<BlackCompany> blackCompanyList, UpdateOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompanyList", blackCompanyList);
        prepareBatchUpdateOption(blackCompanyList, op);
        return delegateBatchUpdate(blackCompanyList, op);
    }

    protected void prepareBatchUpdateOption(List<BlackCompany> blackCompanyList, UpdateOption<BlackCompanyCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(blackCompanyList);
        prepareUpdateOption(op);
    }

    @Override
    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdate(downcast(ls)); }
        else { return varyingBatchUpdate(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-update the entity list specified-only. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * blackCompanyBhv.<span style="color: #DD4747">batchUpdate</span>(blackCompanyList, new SpecifyQuery<BlackCompanyCB>() {
     *     public void specify(BlackCompanyCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * blackCompanyBhv.<span style="color: #DD4747">batchUpdate</span>(blackCompanyList, new SpecifyQuery<BlackCompanyCB>() {
     *     public void specify(BlackCompanyCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchUpdate(List<BlackCompany> blackCompanyList, SpecifyQuery<BlackCompanyCB> updateColumnSpec) {
        return doBatchUpdate(blackCompanyList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    /**
     * Batch-update the entity list non-strictly modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 140%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     BlackCompany blackCompany = new BlackCompany();
     *     blackCompany.setFooName("foo");
     *     if (...) {
     *         blackCompany.setFooPrice(123);
     *     } else {
     *         blackCompany.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//blackCompany.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     blackCompanyList.add(blackCompany);
     * }
     * blackCompanyBhv.<span style="color: #DD4747">batchUpdate</span>(blackCompanyList);
     * </pre>
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<BlackCompany> blackCompanyList) {
        UpdateOption<BlackCompanyCB> option = createPlainUpdateOption();
        return doBatchUpdateNonstrict(blackCompanyList, option);
    }

    protected int[] doBatchUpdateNonstrict(List<BlackCompany> blackCompanyList, UpdateOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompanyList", blackCompanyList);
        prepareBatchUpdateOption(blackCompanyList, op);
        return delegateBatchUpdateNonstrict(blackCompanyList, op);
    }

    /**
     * Batch-update the entity list non-strictly specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * blackCompanyBhv.<span style="color: #DD4747">batchUpdateNonstrict</span>(blackCompanyList, new SpecifyQuery<BlackCompanyCB>() {
     *     public void specify(BlackCompanyCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * blackCompanyBhv.<span style="color: #DD4747">batchUpdateNonstrict</span>(blackCompanyList, new SpecifyQuery<BlackCompanyCB>() {
     *     public void specify(BlackCompanyCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).</p>
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdateNonstrict(List<BlackCompany> blackCompanyList, SpecifyQuery<BlackCompanyCB> updateColumnSpec) {
        return doBatchUpdateNonstrict(blackCompanyList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return batchUpdateNonstrict(downcast(ls)); }
        else { return varyingBatchUpdateNonstrict(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-delete the entity list. (ExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception BatchEntityAlreadyUpdatedException When the entity has already been updated. This exception extends EntityAlreadyUpdatedException.
     */
    public int[] batchDelete(List<BlackCompany> blackCompanyList) {
        return doBatchDelete(blackCompanyList, null);
    }

    protected int[] doBatchDelete(List<BlackCompany> blackCompanyList, DeleteOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompanyList", blackCompanyList);
        prepareDeleteOption(op);
        return delegateBatchDelete(blackCompanyList, op);
    }

    @Override
    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDelete(downcast(ls)); }
        else { return varyingBatchDelete(downcast(ls), downcast(op)); }
    }

    /**
     * Batch-delete the entity list non-strictly. {NonExclusiveControl} <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDeleteNonstrict(List<BlackCompany> blackCompanyList) {
        return doBatchDeleteNonstrict(blackCompanyList, null);
    }

    protected int[] doBatchDeleteNonstrict(List<BlackCompany> blackCompanyList, DeleteOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompanyList", blackCompanyList);
        prepareDeleteOption(op);
        return delegateBatchDeleteNonstrict(blackCompanyList, op);
    }

    @Override
    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return batchDeleteNonstrict(downcast(ls)); }
        else { return varyingBatchDeleteNonstrict(downcast(ls), downcast(op)); }
    }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * blackCompanyBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;BlackCompany, BlackCompanyCB&gt;() {
     *     public ConditionBean setup(blackCompany entity, BlackCompanyCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<BlackCompany, BlackCompanyCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<BlackCompany, BlackCompanyCB> sp, InsertOption<BlackCompanyCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        BlackCompany e = new BlackCompany();
        BlackCompanyCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected BlackCompanyCB createCBForQueryInsert() {
        BlackCompanyCB cb = newMyConditionBean();
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
     * BlackCompany blackCompany = new BlackCompany();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//blackCompany.setPK...(value);</span>
     * blackCompany.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//blackCompany.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//blackCompany.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//blackCompany.setVersionNo(value);</span>
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * blackCompanyBhv.<span style="color: #DD4747">queryUpdate</span>(blackCompany, cb);
     * </pre>
     * @param blackCompany The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(BlackCompany blackCompany, BlackCompanyCB cb) {
        return doQueryUpdate(blackCompany, cb, null);
    }

    protected int doQueryUpdate(BlackCompany blackCompany, BlackCompanyCB cb, UpdateOption<BlackCompanyCB> op) {
        assertObjectNotNull("blackCompany", blackCompany); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(blackCompany, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (BlackCompanyCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (BlackCompanyCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * blackCompanyBhv.<span style="color: #DD4747">queryDelete</span>(blackCompany, cb);
     * </pre>
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(BlackCompanyCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(BlackCompanyCB cb, DeleteOption<BlackCompanyCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((BlackCompanyCB)cb); }
        else { return varyingQueryDelete((BlackCompanyCB)cb, downcast(op)); }
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
     * BlackCompany blackCompany = new BlackCompany();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * blackCompany.setFoo...(value);
     * blackCompany.setBar...(value);
     * InsertOption<BlackCompanyCB> option = new InsertOption<BlackCompanyCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * blackCompanyBhv.<span style="color: #DD4747">varyingInsert</span>(blackCompany, option);
     * ... = blackCompany.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param blackCompany The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(BlackCompany blackCompany, InsertOption<BlackCompanyCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(blackCompany, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, ExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * BlackCompany blackCompany = new BlackCompany();
     * blackCompany.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * blackCompany.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * blackCompany.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;BlackCompanyCB&gt; option = new UpdateOption&lt;BlackCompanyCB&gt;();
     *     option.self(new SpecifyQuery&lt;BlackCompanyCB&gt;() {
     *         public void specify(BlackCompanyCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     blackCompanyBhv.<span style="color: #DD4747">varyingUpdate</span>(blackCompany, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param blackCompany The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(BlackCompany blackCompany, UpdateOption<BlackCompanyCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(blackCompany, option);
    }

    /**
     * Update the entity with varying requests non-strictly modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as updateNonstrict(entity).
     * <pre>
     * <span style="color: #3F7E5E">// ex) you can update by self calculation values</span>
     * BlackCompany blackCompany = new BlackCompany();
     * blackCompany.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * blackCompany.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//blackCompany.setVersionNo(value);</span>
     * UpdateOption&lt;BlackCompanyCB&gt; option = new UpdateOption&lt;BlackCompanyCB&gt;();
     * option.self(new SpecifyQuery&lt;BlackCompanyCB&gt;() {
     *     public void specify(BlackCompanyCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * blackCompanyBhv.<span style="color: #DD4747">varyingUpdateNonstrict</span>(blackCompany, option);
     * </pre>
     * @param blackCompany The entity of update target. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdateNonstrict(BlackCompany blackCompany, UpdateOption<BlackCompanyCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdateNonstrict(blackCompany, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param blackCompany The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(BlackCompany blackCompany, InsertOption<BlackCompanyCB> insertOption, UpdateOption<BlackCompanyCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(blackCompany, insertOption, updateOption);
    }

    /**
     * Insert or update the entity with varying requests non-strictly. (NonExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdateNonstrict(entity).
     * @param blackCompany The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdateNonstrict(BlackCompany blackCompany, InsertOption<BlackCompanyCB> insertOption, UpdateOption<BlackCompanyCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdateNonstrict(blackCompany, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, ExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param blackCompany The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyUpdatedException When the entity has already been updated.
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(BlackCompany blackCompany, DeleteOption<BlackCompanyCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(blackCompany, option);
    }

    /**
     * Delete the entity with varying requests non-strictly. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as deleteNonstrict(entity).
     * @param blackCompany The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDeleteNonstrict(BlackCompany blackCompany, DeleteOption<BlackCompanyCB> option) {
        assertDeleteOptionNotNull(option);
        doDeleteNonstrict(blackCompany, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<BlackCompany> blackCompanyList, InsertOption<BlackCompanyCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(blackCompanyList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<BlackCompany> blackCompanyList, UpdateOption<BlackCompanyCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(blackCompanyList, option);
    }

    /**
     * Batch-update the list with varying requests non-strictly. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdateNonstrict(List<BlackCompany> blackCompanyList, UpdateOption<BlackCompanyCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdateNonstrict(blackCompanyList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<BlackCompany> blackCompanyList, DeleteOption<BlackCompanyCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(blackCompanyList, option);
    }

    /**
     * Batch-delete the list with varying requests non-strictly. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDeleteNonstrict(entityList).
     * @param blackCompanyList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDeleteNonstrict(List<BlackCompany> blackCompanyList, DeleteOption<BlackCompanyCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDeleteNonstrict(blackCompanyList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<BlackCompany, BlackCompanyCB> setupper, InsertOption<BlackCompanyCB> option) {
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
     * BlackCompany blackCompany = new BlackCompany();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//blackCompany.setPK...(value);</span>
     * blackCompany.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//blackCompany.setVersionNo(value);</span>
     * BlackCompanyCB cb = new BlackCompanyCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;BlackCompanyCB&gt; option = new UpdateOption&lt;BlackCompanyCB&gt;();
     * option.self(new SpecifyQuery&lt;BlackCompanyCB&gt;() {
     *     public void specify(BlackCompanyCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * blackCompanyBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(blackCompany, cb, option);
     * </pre>
     * @param blackCompany The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(BlackCompany blackCompany, BlackCompanyCB cb, UpdateOption<BlackCompanyCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(blackCompany, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of BlackCompany. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(BlackCompanyCB cb, DeleteOption<BlackCompanyCB> option) {
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
    public OutsideSqlBasicExecutor<BlackCompanyBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(BlackCompanyCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(BlackCompanyCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends BlackCompany> void delegateSelectCursor(BlackCompanyCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends BlackCompany> List<ENTITY> delegateSelectList(BlackCompanyCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(BlackCompany et, InsertOption<BlackCompanyCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(BlackCompany et, UpdateOption<BlackCompanyCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateEntityCommand(et, op)); }
    protected int delegateUpdateNonstrict(BlackCompany et, UpdateOption<BlackCompanyCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(BlackCompany et, DeleteOption<BlackCompanyCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteEntityCommand(et, op)); }
    protected int delegateDeleteNonstrict(BlackCompany et, DeleteOption<BlackCompanyCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<BlackCompany> ls, InsertOption<BlackCompanyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<BlackCompany> ls, UpdateOption<BlackCompanyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchUpdateNonstrict(List<BlackCompany> ls, UpdateOption<BlackCompanyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<BlackCompany> ls, DeleteOption<BlackCompanyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteCommand(processBatchInternally(ls, op, false), op)); }
    protected int[] delegateBatchDeleteNonstrict(List<BlackCompany> ls, DeleteOption<BlackCompanyCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(BlackCompany et, BlackCompanyCB inCB, ConditionBean resCB, InsertOption<BlackCompanyCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(BlackCompany et, BlackCompanyCB cb, UpdateOption<BlackCompanyCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(BlackCompanyCB cb, DeleteOption<BlackCompanyCB> op)
    { if (!processBeforeQueryDelete(cb, op)) { return 0; } return invoke(createQueryDeleteCBCommand(cb, op));  }

    // ===================================================================================
    //                                                                Optimistic Lock Info
    //                                                                ====================
    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean hasVersionNoValue(Entity et) {
        return !(downcast(et).getVersionNo() + "").equals("null");// For primitive type
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
    protected BlackCompany downcast(Entity et) {
        return helpEntityDowncastInternally(et, BlackCompany.class);
    }

    protected BlackCompanyCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, BlackCompanyCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<BlackCompany> downcast(List<? extends Entity> ls) {
        return (List<BlackCompany>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<BlackCompanyCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<BlackCompanyCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<BlackCompanyCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<BlackCompanyCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<BlackCompanyCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<BlackCompanyCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<BlackCompany, BlackCompanyCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<BlackCompany, BlackCompanyCB>)sp;
    }
}
