package jp.bizreach.twitter.dbflute.bsbhv;

import java.util.List;

import org.seasar.dbflute.*;
import org.seasar.dbflute.bhv.*;
import org.seasar.dbflute.cbean.*;
import org.seasar.dbflute.cbean.chelper.HpSLSExecutor;
import org.seasar.dbflute.cbean.chelper.HpSLSFunction;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.exception.*;
import org.seasar.dbflute.optional.OptionalEntity;
import org.seasar.dbflute.outsidesql.executor.*;
import jp.bizreach.twitter.dbflute.exbhv.*;
import jp.bizreach.twitter.dbflute.bsbhv.loader.*;
import jp.bizreach.twitter.dbflute.exentity.*;
import jp.bizreach.twitter.dbflute.bsentity.dbmeta.*;
import jp.bizreach.twitter.dbflute.cbean.*;

/**
 * The behavior of member_withdraw as TABLE. <br />
 * <pre>
 * [primary key]
 *     MEMBER_ID
 *
 * [column]
 *     MEMBER_ID, WITHDRAWAL_REASON_ID, WITHDRAWAL_REASON_INPUT_TEXT, WITHDRAWAL_DATETIME
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
 *     member
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     member
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMemberWithdrawBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "member_withdraw"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** {@inheritDoc} */
    public DBMeta getDBMeta() { return MemberWithdrawDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public MemberWithdrawDbm getMyDBMeta() { return MemberWithdrawDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public MemberWithdraw newEntity() { return new MemberWithdraw(); }

    /** {@inheritDoc} */
    public MemberWithdrawCB newConditionBean() { return new MemberWithdrawCB(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public MemberWithdraw newMyEntity() { return new MemberWithdraw(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public MemberWithdrawCB newMyConditionBean() { return new MemberWithdrawCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * int count = memberWithdrawBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(MemberWithdrawCB cb) {
        return facadeSelectCount(cb);
    }

    protected int facadeSelectCount(MemberWithdrawCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(MemberWithdrawCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(MemberWithdrawCB cb) { // called by selectPage(cb)
        assertCBStateValid(cb);
        return delegateSelectCountPlainly(cb);
    }

    protected int doReadCount(ConditionBean cb) { return facadeSelectCount(downcast(cb)); }

    // ===================================================================================
    //                                                                       Entity Select
    //                                                                       =============
    /**
     * Select the entity by the condition-bean. #beforejava8 <br />
     * <span style="color: #AD4747; font-size: 120%">The return might be null if no data, so you should have null check.</span> <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, use selectEntityWithDeletedCheck().</span>
     * <pre>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * MemberWithdraw memberWithdraw = memberWithdrawBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (memberWithdraw != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = memberWithdraw.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberWithdraw selectEntity(MemberWithdrawCB cb) {
        return facadeSelectEntity(cb);
    }

    protected MemberWithdraw facadeSelectEntity(MemberWithdrawCB cb) {
        return doSelectEntity(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberWithdraw> ENTITY doSelectEntity(MemberWithdrawCB cb, Class<ENTITY> tp) {
        return helpSelectEntityInternally(cb, tp);
    }

    protected <ENTITY extends MemberWithdraw> OptionalEntity<ENTITY> doSelectOptionalEntity(MemberWithdrawCB cb, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectEntity(cb, tp), cb);
    }

    protected Entity doReadEntity(ConditionBean cb) { return facadeSelectEntity(downcast(cb)); }

    /**
     * Select the entity by the condition-bean with deleted check. <br />
     * <span style="color: #AD4747; font-size: 120%">If the data always exists as your business rule, this method is good.</span>
     * <pre>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * MemberWithdraw memberWithdraw = memberWithdrawBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = memberWithdraw.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberWithdraw selectEntityWithDeletedCheck(MemberWithdrawCB cb) {
        return facadeSelectEntityWithDeletedCheck(cb);
    }

    protected MemberWithdraw facadeSelectEntityWithDeletedCheck(MemberWithdrawCB cb) {
        return doSelectEntityWithDeletedCheck(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberWithdraw> ENTITY doSelectEntityWithDeletedCheck(MemberWithdrawCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp);
    }

    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) { return facadeSelectEntityWithDeletedCheck(downcast(cb)); }

    /**
     * Select the entity by the primary-key value.
     * @param memberId : PK, NotNull, INT(10), FK to member. (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberWithdraw selectByPKValue(Integer memberId) {
        return facadeSelectByPKValue(memberId);
    }

    protected MemberWithdraw facadeSelectByPKValue(Integer memberId) {
        return doSelectByPK(memberId, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberWithdraw> ENTITY doSelectByPK(Integer memberId, Class<ENTITY> tp) {
        return doSelectEntity(xprepareCBAsPK(memberId), tp);
    }

    protected <ENTITY extends MemberWithdraw> OptionalEntity<ENTITY> doSelectOptionalByPK(Integer memberId, Class<ENTITY> tp) {
        return createOptionalEntity(doSelectByPK(memberId, tp), memberId);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param memberId : PK, NotNull, INT(10), FK to member. (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public MemberWithdraw selectByPKValueWithDeletedCheck(Integer memberId) {
        return doSelectByPKWithDeletedCheck(memberId, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberWithdraw> ENTITY doSelectByPKWithDeletedCheck(Integer memberId, Class<ENTITY> tp) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(memberId), tp);
    }

    protected MemberWithdrawCB xprepareCBAsPK(Integer memberId) {
        assertObjectNotNull("memberId", memberId);
        return newConditionBean().acceptPK(memberId);
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;MemberWithdraw&gt; memberWithdrawList = memberWithdrawBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (MemberWithdraw memberWithdraw : memberWithdrawList) {
     *     ... = memberWithdraw.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<MemberWithdraw> selectList(MemberWithdrawCB cb) {
        return facadeSelectList(cb);
    }

    protected ListResultBean<MemberWithdraw> facadeSelectList(MemberWithdrawCB cb) {
        return doSelectList(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberWithdraw> ListResultBean<ENTITY> doSelectList(MemberWithdrawCB cb, Class<ENTITY> tp) {
        return helpSelectListInternally(cb, tp);
    }

    protected ListResultBean<? extends Entity> doReadList(ConditionBean cb) { return facadeSelectList(downcast(cb)); }

    // ===================================================================================
    //                                                                         Page Select
    //                                                                         ===========
    /**
     * Select the page as result bean. <br />
     * (both count-select and paging-select are executed)
     * <pre>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;MemberWithdraw&gt; page = memberWithdrawBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (MemberWithdraw memberWithdraw : page) {
     *     ... = memberWithdraw.get...();
     * }
     * </pre>
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<MemberWithdraw> selectPage(MemberWithdrawCB cb) {
        return facadeSelectPage(cb);
    }

    protected PagingResultBean<MemberWithdraw> facadeSelectPage(MemberWithdrawCB cb) {
        return doSelectPage(cb, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberWithdraw> PagingResultBean<ENTITY> doSelectPage(MemberWithdrawCB cb, Class<ENTITY> tp) {
        return helpSelectPageInternally(cb, tp);
    }

    protected PagingResultBean<? extends Entity> doReadPage(ConditionBean cb) { return facadeSelectPage(downcast(cb)); }

    // ===================================================================================
    //                                                                       Cursor Select
    //                                                                       =============
    /**
     * Select the cursor by the condition-bean.
     * <pre>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * memberWithdrawBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;MemberWithdraw&gt;() {
     *     public void handle(MemberWithdraw entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @param entityRowHandler The handler of entity row of MemberWithdraw. (NotNull)
     */
    public void selectCursor(MemberWithdrawCB cb, EntityRowHandler<MemberWithdraw> entityRowHandler) {
        facadeSelectCursor(cb, entityRowHandler);
    }

    protected void facadeSelectCursor(MemberWithdrawCB cb, EntityRowHandler<MemberWithdraw> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, typeOfSelectedEntity());
    }

    protected <ENTITY extends MemberWithdraw> void doSelectCursor(MemberWithdrawCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp);
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * memberWithdrawBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(MemberWithdrawCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> HpSLSFunction<MemberWithdrawCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return facadeScalarSelect(resultType);
    }

    protected <RESULT> HpSLSFunction<MemberWithdrawCB, RESULT> facadeScalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newConditionBean());
    }

    protected <RESULT, CB extends MemberWithdrawCB> HpSLSFunction<CB, RESULT> doScalarSelect(final Class<RESULT> tp, final CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        HpSLSExecutor<CB, RESULT> executor = createHpSLSExecutor(); // variable to resolve generic
        return createSLSFunction(cb, tp, executor);
    }

    protected <RESULT> HpSLSFunction<? extends ConditionBean, RESULT> doReadScalar(Class<RESULT> tp) { return facadeScalarSelect(tp); }

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
     * Load referrer by the the referrer loader. <br />
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().set...
     * List&lt;Member&gt; memberList = memberBhv.selectList(cb);
     * memberBhv.<span style="color: #DD4747">load</span>(memberList, loader -&gt; {
     *     loader.<span style="color: #DD4747">loadPurchaseList</span>(purchaseCB -&gt; {
     *         purchaseCB.query().set...
     *         purchaseCB.query().addOrderBy_PurchasePrice_Desc();
     *     }); <span style="color: #3F7E5E">// you can also load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedList(purchaseLoader -&gt {</span>
     *     <span style="color: #3F7E5E">//    purchaseLoader.loadPurchasePaymentList(...);</span>
     *     <span style="color: #3F7E5E">//});</span>
     *
     *     <span style="color: #3F7E5E">// you can also pull out foreign table and load its referrer</span>
     *     <span style="color: #3F7E5E">// (setupSelect of the foreign table should be called)</span>
     *     <span style="color: #3F7E5E">//loader.pulloutMemberStatus().loadMemberLoginList(...)</span>
     * }
     * for (Member member : memberList) {
     *     List&lt;Purchase&gt; purchaseList = member.<span style="color: #DD4747">getPurchaseList()</span>;
     *     for (Purchase purchase : purchaseList) {
     *         ...
     *     }
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has order by FK before callback.
     * @param memberWithdrawList The entity list of memberWithdraw. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(List<MemberWithdraw> memberWithdrawList, ReferrerLoaderHandler<LoaderOfMemberWithdraw> handler) {
        xassLRArg(memberWithdrawList, handler);
        handler.handle(new LoaderOfMemberWithdraw().ready(memberWithdrawList, _behaviorSelector));
    }

    /**
     * Load referrer of ${referrer.referrerJavaBeansRulePropertyName} by the referrer loader. <br />
     * <pre>
     * MemberCB cb = new MemberCB();
     * cb.query().set...
     * Member member = memberBhv.selectEntityWithDeletedCheck(cb);
     * memberBhv.<span style="color: #DD4747">load</span>(member, loader -&gt; {
     *     loader.<span style="color: #DD4747">loadPurchaseList</span>(purchaseCB -&gt; {
     *         purchaseCB.query().set...
     *         purchaseCB.query().addOrderBy_PurchasePrice_Desc();
     *     }); <span style="color: #3F7E5E">// you can also load nested referrer from here</span>
     *     <span style="color: #3F7E5E">//}).withNestedList(purchaseLoader -&gt {</span>
     *     <span style="color: #3F7E5E">//    purchaseLoader.loadPurchasePaymentList(...);</span>
     *     <span style="color: #3F7E5E">//});</span>
     *
     *     <span style="color: #3F7E5E">// you can also pull out foreign table and load its referrer</span>
     *     <span style="color: #3F7E5E">// (setupSelect of the foreign table should be called)</span>
     *     <span style="color: #3F7E5E">//loader.pulloutMemberStatus().loadMemberLoginList(...)</span>
     * }
     * for (Member member : memberList) {
     *     List&lt;Purchase&gt; purchaseList = member.<span style="color: #DD4747">getPurchaseList()</span>;
     *     for (Purchase purchase : purchaseList) {
     *         ...
     *     }
     * }
     * </pre>
     * About internal policy, the value of primary key (and others too) is treated as case-insensitive. <br />
     * The condition-bean, which the set-upper provides, has order by FK before callback.
     * @param memberWithdraw The entity of memberWithdraw. (NotNull)
     * @param handler The callback to handle the referrer loader for actually loading referrer. (NotNull)
     */
    public void load(MemberWithdraw memberWithdraw, ReferrerLoaderHandler<LoaderOfMemberWithdraw> handler) {
        xassLRArg(memberWithdraw, handler);
        handler.handle(new LoaderOfMemberWithdraw().ready(xnewLRAryLs(memberWithdraw), _behaviorSelector));
    }

    // ===================================================================================
    //                                                                   Pull out Relation
    //                                                                   =================
    /**
     * Pull out the list of foreign table 'Member'.
     * @param memberWithdrawList The list of memberWithdraw. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<MemberWithdraw> memberWithdrawList)
    { return helpPulloutInternally(memberWithdrawList, "member"); }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key memberId.
     * @param memberWithdrawList The list of memberWithdraw. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberIdList(List<MemberWithdraw> memberWithdrawList)
    { return helpExtractListInternally(memberWithdrawList, "memberId"); }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * MemberWithdraw memberWithdraw = new MemberWithdraw();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberWithdraw.setFoo...(value);
     * memberWithdraw.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberWithdraw.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberWithdraw.set...;</span>
     * memberWithdrawBhv.<span style="color: #DD4747">insert</span>(memberWithdraw);
     * ... = memberWithdraw.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param memberWithdraw The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(MemberWithdraw memberWithdraw) {
        doInsert(memberWithdraw, null);
    }

    protected void doInsert(MemberWithdraw et, InsertOption<MemberWithdrawCB> op) {
        assertObjectNotNull("memberWithdraw", et); prepareInsertOption(op); delegateInsert(et, op);
    }

    protected void prepareInsertOption(InsertOption<MemberWithdrawCB> op) {
        if (op == null) { return; } assertInsertOptionStatus(op);
        if (op.hasSpecifiedInsertColumn()) { op.resolveInsertColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected void doCreate(Entity et, InsertOption<? extends ConditionBean> op) { doInsert(downcast(et), downcast(op)); }

    /**
     * Update the entity modified-only. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * MemberWithdraw memberWithdraw = new MemberWithdraw();
     * memberWithdraw.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberWithdraw.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberWithdraw.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberWithdraw.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberWithdraw.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberWithdrawBhv.<span style="color: #DD4747">update</span>(memberWithdraw);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberWithdraw The entity of update. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(MemberWithdraw memberWithdraw) {
        doUpdate(memberWithdraw, null);
    }

    protected void doUpdate(MemberWithdraw et, UpdateOption<MemberWithdrawCB> op) {
        assertObjectNotNull("memberWithdraw", et); prepareUpdateOption(op); helpUpdateInternally(et, op);
    }

    protected void prepareUpdateOption(UpdateOption<MemberWithdrawCB> op) {
        if (op == null) { return; } assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) { op.resolveSelfSpecification(createCBForVaryingUpdate()); }
        if (op.hasSpecifiedUpdateColumn()) { op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate()); }
    }

    protected MemberWithdrawCB createCBForVaryingUpdate()
    { MemberWithdrawCB cb = newConditionBean(); cb.xsetupForVaryingUpdate(); return cb; }

    protected MemberWithdrawCB createCBForSpecifiedUpdate()
    { MemberWithdrawCB cb = newConditionBean(); cb.xsetupForSpecifiedUpdate(); return cb; }

    protected void doModify(Entity et, UpdateOption<? extends ConditionBean> op) { doUpdate(downcast(et), downcast(op)); }

    protected void doModifyNonstrict(Entity et, UpdateOption<? extends ConditionBean> op)
    { doModify(et, op); }

    /**
     * Insert or update the entity modified-only. (DefaultConstraintsEnabled, NonExclusiveControl) <br />
     * if (the entity has no PK) { insert() } else { update(), but no data, insert() } <br />
     * <p><span style="color: #DD4747; font-size: 120%">Attention, you cannot update by unique keys instead of PK.</span></p>
     * @param memberWithdraw The entity of insert or update. (NotNull, ...depends on insert or update)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(MemberWithdraw memberWithdraw) {
        doInsertOrUpdate(memberWithdraw, null, null);
    }

    protected void doInsertOrUpdate(MemberWithdraw et, InsertOption<MemberWithdrawCB> iop, UpdateOption<MemberWithdrawCB> uop) {
        assertObjectNotNull("memberWithdraw", et); helpInsertOrUpdateInternally(et, iop, uop);
    }

    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop)
    { doInsertOrUpdate(downcast(et), downcast(iop), downcast(uop)); }

    protected void doCreateOrModifyNonstrict(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop)
    { doCreateOrModify(et, iop, uop); }

    /**
     * Delete the entity. (ZeroUpdateException, NonExclusiveControl)
     * <pre>
     * MemberWithdraw memberWithdraw = new MemberWithdraw();
     * memberWithdraw.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberWithdraw.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     memberWithdrawBhv.<span style="color: #DD4747">delete</span>(memberWithdraw);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberWithdraw The entity of delete. (NotNull, PrimaryKeyNotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(MemberWithdraw memberWithdraw) {
        doDelete(memberWithdraw, null);
    }

    protected void doDelete(MemberWithdraw et, final DeleteOption<MemberWithdrawCB> op) {
        assertObjectNotNull("memberWithdraw", et); prepareDeleteOption(op); helpDeleteInternally(et, op);
    }

    protected void prepareDeleteOption(DeleteOption<MemberWithdrawCB> op) { if (op != null) { assertDeleteOptionStatus(op); } }

    protected void doRemove(Entity et, DeleteOption<? extends ConditionBean> op) { doDelete(downcast(et), downcast(op)); }

    protected void doRemoveNonstrict(Entity et, DeleteOption<? extends ConditionBean> op)
    { doRemove(et, op); }

    // ===================================================================================
    //                                                                        Batch Update
    //                                                                        ============
    /**
     * Batch-insert the entity list modified-only of same-set columns. (DefaultConstraintsEnabled) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <p><span style="color: #DD4747; font-size: 120%">The columns of least common multiple are registered like this:</span></p>
     * <pre>
     * for (... : ...) {
     *     MemberWithdraw memberWithdraw = new MemberWithdraw();
     *     memberWithdraw.setFooName("foo");
     *     if (...) {
     *         memberWithdraw.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     memberWithdrawList.add(memberWithdraw);
     * }
     * memberWithdrawBhv.<span style="color: #DD4747">batchInsert</span>(memberWithdrawList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param memberWithdrawList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<MemberWithdraw> memberWithdrawList) {
        return doBatchInsert(memberWithdrawList, null);
    }

    protected int[] doBatchInsert(List<MemberWithdraw> ls, InsertOption<MemberWithdrawCB> op) {
        assertObjectNotNull("memberWithdrawList", ls);
        InsertOption<MemberWithdrawCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainInsertOption(); }
        prepareBatchInsertOption(ls, rlop); // required
        return delegateBatchInsert(ls, rlop);
    }

    protected void prepareBatchInsertOption(List<MemberWithdraw> ls, InsertOption<MemberWithdrawCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(ls);
        prepareInsertOption(op);
    }

    protected int[] doLumpCreate(List<Entity> ls, InsertOption<? extends ConditionBean> op) { return doBatchInsert(downcast(ls), downcast(op)); }

    /**
     * Batch-update the entity list modified-only of same-set columns. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement. <br />
     * <span style="color: #DD4747; font-size: 120%">You should specify same-set columns to all entities like this:</span>
     * <pre>
     * for (... : ...) {
     *     MemberWithdraw memberWithdraw = new MemberWithdraw();
     *     memberWithdraw.setFooName("foo");
     *     if (...) {
     *         memberWithdraw.setFooPrice(123);
     *     } else {
     *         memberWithdraw.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//memberWithdraw.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     memberWithdrawList.add(memberWithdraw);
     * }
     * memberWithdrawBhv.<span style="color: #DD4747">batchUpdate</span>(memberWithdrawList);
     * </pre>
     * @param memberWithdrawList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberWithdraw> memberWithdrawList) {
        return doBatchUpdate(memberWithdrawList, null);
    }

    protected int[] doBatchUpdate(List<MemberWithdraw> ls, UpdateOption<MemberWithdrawCB> op) {
        assertObjectNotNull("memberWithdrawList", ls);
        UpdateOption<MemberWithdrawCB> rlop; if (op != null) { rlop = op; } else { rlop = createPlainUpdateOption(); }
        prepareBatchUpdateOption(ls, rlop); // required
        return delegateBatchUpdate(ls, rlop);
    }

    protected void prepareBatchUpdateOption(List<MemberWithdraw> ls, UpdateOption<MemberWithdrawCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(ls);
        prepareUpdateOption(op);
    }

    protected int[] doLumpModify(List<Entity> ls, UpdateOption<? extends ConditionBean> op) { return doBatchUpdate(downcast(ls), downcast(op)); }

    /**
     * Batch-update the entity list specified-only. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * <pre>
     * <span style="color: #3F7E5E">// e.g. update two columns only</span>
     * memberWithdrawBhv.<span style="color: #DD4747">batchUpdate</span>(memberWithdrawList, new SpecifyQuery<MemberWithdrawCB>() {
     *     public void specify(MemberWithdrawCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * memberWithdrawBhv.<span style="color: #DD4747">batchUpdate</span>(memberWithdrawList, new SpecifyQuery<MemberWithdrawCB>() {
     *     public void specify(MemberWithdrawCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param memberWithdrawList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<MemberWithdraw> memberWithdrawList, SpecifyQuery<MemberWithdrawCB> updateColumnSpec) {
        return doBatchUpdate(memberWithdrawList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op)
    { return doLumpModify(ls, op); }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param memberWithdrawList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<MemberWithdraw> memberWithdrawList) {
        return doBatchDelete(memberWithdrawList, null);
    }

    protected int[] doBatchDelete(List<MemberWithdraw> ls, DeleteOption<MemberWithdrawCB> op) {
        assertObjectNotNull("memberWithdrawList", ls);
        prepareDeleteOption(op);
        return delegateBatchDelete(ls, op);
    }

    protected int[] doLumpRemove(List<Entity> ls, DeleteOption<? extends ConditionBean> op) { return doBatchDelete(downcast(ls), downcast(op)); }

    protected int[] doLumpRemoveNonstrict(List<Entity> ls, DeleteOption<? extends ConditionBean> op)
    { return doLumpRemove(ls, op); }

    // ===================================================================================
    //                                                                        Query Update
    //                                                                        ============
    /**
     * Insert the several entities by query (modified-only for fixed value).
     * <pre>
     * memberWithdrawBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;MemberWithdraw, MemberWithdrawCB&gt;() {
     *     public ConditionBean setup(memberWithdraw entity, MemberWithdrawCB intoCB) {
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
     *         <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     *         <span style="color: #3F7E5E">//entity.setVersionNo(value);</span>
     *
     *         return cb;
     *     }
     * });
     * </pre>
     * @param setupper The setup-per of query-insert. (NotNull)
     * @return The inserted count.
     */
    public int queryInsert(QueryInsertSetupper<MemberWithdraw, MemberWithdrawCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<MemberWithdraw, MemberWithdrawCB> sp, InsertOption<MemberWithdrawCB> op) {
        assertObjectNotNull("setupper", sp); prepareInsertOption(op);
        MemberWithdraw et = newEntity(); MemberWithdrawCB cb = createCBForQueryInsert();
        return delegateQueryInsert(et, cb, sp.setup(et, cb), op);
    }

    protected MemberWithdrawCB createCBForQueryInsert()
    { MemberWithdrawCB cb = newConditionBean(); cb.xsetupForQueryInsert(); return cb; }

    protected int doRangeCreate(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> setupper, InsertOption<? extends ConditionBean> op)
    { return doQueryInsert(downcast(setupper), downcast(op)); }

    /**
     * Update the several entities by query non-strictly modified-only. (NonExclusiveControl)
     * <pre>
     * MemberWithdraw memberWithdraw = new MemberWithdraw();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberWithdraw.setPK...(value);</span>
     * memberWithdraw.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//memberWithdraw.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//memberWithdraw.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberWithdraw.setVersionNo(value);</span>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * memberWithdrawBhv.<span style="color: #DD4747">queryUpdate</span>(memberWithdraw, cb);
     * </pre>
     * @param memberWithdraw The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(MemberWithdraw memberWithdraw, MemberWithdrawCB cb) {
        return doQueryUpdate(memberWithdraw, cb, null);
    }

    protected int doQueryUpdate(MemberWithdraw et, MemberWithdrawCB cb, UpdateOption<MemberWithdrawCB> op) {
        assertObjectNotNull("memberWithdraw", et); assertCBStateValid(cb); prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(et, cb, op) : 0;
    }

    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op)
    { return doQueryUpdate(downcast(et), downcast(cb), downcast(op)); }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * memberWithdrawBhv.<span style="color: #DD4747">queryDelete</span>(memberWithdraw, cb);
     * </pre>
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(MemberWithdrawCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(MemberWithdrawCB cb, DeleteOption<MemberWithdrawCB> op) {
        assertCBStateValid(cb); prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) { return doQueryDelete(downcast(cb), downcast(op)); }

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
     * MemberWithdraw memberWithdraw = new MemberWithdraw();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * memberWithdraw.setFoo...(value);
     * memberWithdraw.setBar...(value);
     * InsertOption<MemberWithdrawCB> option = new InsertOption<MemberWithdrawCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * memberWithdrawBhv.<span style="color: #DD4747">varyingInsert</span>(memberWithdraw, option);
     * ... = memberWithdraw.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param memberWithdraw The entity of insert. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(MemberWithdraw memberWithdraw, InsertOption<MemberWithdrawCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(memberWithdraw, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * MemberWithdraw memberWithdraw = new MemberWithdraw();
     * memberWithdraw.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * memberWithdraw.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of concurrency column is required</span>
     * memberWithdraw.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;MemberWithdrawCB&gt; option = new UpdateOption&lt;MemberWithdrawCB&gt;();
     *     option.self(new SpecifyQuery&lt;MemberWithdrawCB&gt;() {
     *         public void specify(MemberWithdrawCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     memberWithdrawBhv.<span style="color: #DD4747">varyingUpdate</span>(memberWithdraw, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param memberWithdraw The entity of update. (NotNull, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(MemberWithdraw memberWithdraw, UpdateOption<MemberWithdrawCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(memberWithdraw, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param memberWithdraw The entity of insert or update. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(MemberWithdraw memberWithdraw, InsertOption<MemberWithdrawCB> insertOption, UpdateOption<MemberWithdrawCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInsertOrUpdate(memberWithdraw, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param memberWithdraw The entity of delete. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(MemberWithdraw memberWithdraw, DeleteOption<MemberWithdrawCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(memberWithdraw, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param memberWithdrawList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<MemberWithdraw> memberWithdrawList, InsertOption<MemberWithdrawCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(memberWithdrawList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param memberWithdrawList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<MemberWithdraw> memberWithdrawList, UpdateOption<MemberWithdrawCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(memberWithdrawList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param memberWithdrawList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<MemberWithdraw> memberWithdrawList, DeleteOption<MemberWithdrawCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(memberWithdrawList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<MemberWithdraw, MemberWithdrawCB> setupper, InsertOption<MemberWithdrawCB> option) {
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
     * MemberWithdraw memberWithdraw = new MemberWithdraw();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//memberWithdraw.setPK...(value);</span>
     * memberWithdraw.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of concurrency column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//memberWithdraw.setVersionNo(value);</span>
     * MemberWithdrawCB cb = new MemberWithdrawCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;MemberWithdrawCB&gt; option = new UpdateOption&lt;MemberWithdrawCB&gt;();
     * option.self(new SpecifyQuery&lt;MemberWithdrawCB&gt;() {
     *     public void specify(MemberWithdrawCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * memberWithdrawBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(memberWithdraw, cb, option);
     * </pre>
     * @param memberWithdraw The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(MemberWithdraw memberWithdraw, MemberWithdrawCB cb, UpdateOption<MemberWithdrawCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(memberWithdraw, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of MemberWithdraw. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(MemberWithdrawCB cb, DeleteOption<MemberWithdrawCB> option) {
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
    public OutsideSqlBasicExecutor<MemberWithdrawBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                       Assist Helper
    //                                                                       =============
    protected Class<MemberWithdraw> typeOfSelectedEntity() { return MemberWithdraw.class; }
    protected MemberWithdraw downcast(Entity et) { return helpEntityDowncastInternally(et, MemberWithdraw.class); }
    protected MemberWithdrawCB downcast(ConditionBean cb) { return helpConditionBeanDowncastInternally(cb, MemberWithdrawCB.class); }
    @SuppressWarnings("unchecked")
    protected List<MemberWithdraw> downcast(List<? extends Entity> ls) { return (List<MemberWithdraw>)ls; }
    @SuppressWarnings("unchecked")
    protected InsertOption<MemberWithdrawCB> downcast(InsertOption<? extends ConditionBean> op) { return (InsertOption<MemberWithdrawCB>)op; }
    @SuppressWarnings("unchecked")
    protected UpdateOption<MemberWithdrawCB> downcast(UpdateOption<? extends ConditionBean> op) { return (UpdateOption<MemberWithdrawCB>)op; }
    @SuppressWarnings("unchecked")
    protected DeleteOption<MemberWithdrawCB> downcast(DeleteOption<? extends ConditionBean> op) { return (DeleteOption<MemberWithdrawCB>)op; }
    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<MemberWithdraw, MemberWithdrawCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp)
    { return (QueryInsertSetupper<MemberWithdraw, MemberWithdrawCB>)sp; }
}
