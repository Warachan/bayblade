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
 * The behavior of followers as TABLE. <br />
 * <pre>
 * [primary key]
 *     FOLLOWERSID
 *
 * [column]
 *     FOLLOWERSID, MEMBER_ID
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
public abstract class BsFollowersBhv extends AbstractBehaviorWritable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /*df:beginQueryPath*/
    /*df:endQueryPath*/

    // ===================================================================================
    //                                                                          Table name
    //                                                                          ==========
    /** @return The name on database of table. (NotNull) */
    public String getTableDbName() { return "followers"; }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /** @return The instance of DBMeta. (NotNull) */
    public DBMeta getDBMeta() { return FollowersDbm.getInstance(); }

    /** @return The instance of DBMeta as my table type. (NotNull) */
    public FollowersDbm getMyDBMeta() { return FollowersDbm.getInstance(); }

    // ===================================================================================
    //                                                                        New Instance
    //                                                                        ============
    /** {@inheritDoc} */
    public Entity newEntity() { return newMyEntity(); }

    /** {@inheritDoc} */
    public ConditionBean newConditionBean() { return newMyConditionBean(); }

    /** @return The instance of new entity as my table type. (NotNull) */
    public Followers newMyEntity() { return new Followers(); }

    /** @return The instance of new condition-bean as my table type. (NotNull) */
    public FollowersCB newMyConditionBean() { return new FollowersCB(); }

    // ===================================================================================
    //                                                                        Count Select
    //                                                                        ============
    /**
     * Select the count of uniquely-selected records by the condition-bean. {IgnorePagingCondition, IgnoreSpecifyColumn}<br />
     * SpecifyColumn is ignored but you can use it only to remove text type column for union's distinct.
     * <pre>
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * int count = followersBhv.<span style="color: #DD4747">selectCount</span>(cb);
     * </pre>
     * @param cb The condition-bean of Followers. (NotNull)
     * @return The count for the condition. (NotMinus)
     */
    public int selectCount(FollowersCB cb) {
        return doSelectCountUniquely(cb);
    }

    protected int doSelectCountUniquely(FollowersCB cb) { // called by selectCount(cb)
        assertCBStateValid(cb);
        return delegateSelectCountUniquely(cb);
    }

    protected int doSelectCountPlainly(FollowersCB cb) { // called by selectPage(cb)
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
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * Followers followers = followersBhv.<span style="color: #DD4747">selectEntity</span>(cb);
     * if (followers != null) { <span style="color: #3F7E5E">// null check</span>
     *     ... = followers.get...();
     * } else {
     *     ...
     * }
     * </pre>
     * @param cb The condition-bean of Followers. (NotNull)
     * @return The entity selected by the condition. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Followers selectEntity(FollowersCB cb) {
        return doSelectEntity(cb, Followers.class);
    }

    protected <ENTITY extends Followers> ENTITY doSelectEntity(FollowersCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityInternally(cb, tp, new InternalSelectEntityCallback<ENTITY, FollowersCB>() {
            public List<ENTITY> callbackSelectList(FollowersCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    protected <ENTITY extends Followers> OptionalEntity<ENTITY> doSelectOptionalEntity(FollowersCB cb, Class<ENTITY> tp) {
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
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * Followers followers = followersBhv.<span style="color: #DD4747">selectEntityWithDeletedCheck</span>(cb);
     * ... = followers.get...(); <span style="color: #3F7E5E">// the entity always be not null</span>
     * </pre>
     * @param cb The condition-bean of Followers. (NotNull)
     * @return The entity selected by the condition. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Followers selectEntityWithDeletedCheck(FollowersCB cb) {
        return doSelectEntityWithDeletedCheck(cb, Followers.class);
    }

    protected <ENTITY extends Followers> ENTITY doSelectEntityWithDeletedCheck(FollowersCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectEntityWithDeletedCheckInternally(cb, tp, new InternalSelectEntityWithDeletedCheckCallback<ENTITY, FollowersCB>() {
            public List<ENTITY> callbackSelectList(FollowersCB lcb, Class<ENTITY> ltp) { return doSelectList(lcb, ltp); } });
    }

    @Override
    protected Entity doReadEntityWithDeletedCheck(ConditionBean cb) {
        return selectEntityWithDeletedCheck(downcast(cb));
    }

    /**
     * Select the entity by the primary-key value.
     * @param followersid : PK, NotNull, INT(10). (NotNull)
     * @return The entity selected by the PK. (NullAllowed: if no data, it returns null)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Followers selectByPKValue(Integer followersid) {
        return doSelectByPK(followersid, Followers.class);
    }

    protected <ENTITY extends Followers> ENTITY doSelectByPK(Integer followersid, Class<ENTITY> entityType) {
        return doSelectEntity(xprepareCBAsPK(followersid), entityType);
    }

    protected <ENTITY extends Followers> OptionalEntity<ENTITY> doSelectOptionalByPK(Integer followersid, Class<ENTITY> entityType) {
        return createOptionalEntity(doSelectByPK(followersid, entityType), followersid);
    }

    /**
     * Select the entity by the primary-key value with deleted check.
     * @param followersid : PK, NotNull, INT(10). (NotNull)
     * @return The entity selected by the PK. (NotNull: if no data, throws exception)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public Followers selectByPKValueWithDeletedCheck(Integer followersid) {
        return doSelectByPKWithDeletedCheck(followersid, Followers.class);
    }

    protected <ENTITY extends Followers> ENTITY doSelectByPKWithDeletedCheck(Integer followersid, Class<ENTITY> entityType) {
        return doSelectEntityWithDeletedCheck(xprepareCBAsPK(followersid), entityType);
    }

    protected FollowersCB xprepareCBAsPK(Integer followersid) {
        assertObjectNotNull("followersid", followersid);
        FollowersCB cb = newMyConditionBean(); cb.acceptPrimaryKey(followersid);
        return cb;
    }

    /**
     * Select the entity by the unique-key value.
     * @param memberId : UQ, NotNull, INT(10), FK to member. (NotNull)
     * @return The optional entity selected by the unique key. (NotNull: if no data, empty entity)
     * @exception EntityAlreadyDeletedException When get(), required() of return value is called and the value is null, which means entity has already been deleted (not found).
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception SelectEntityConditionNotFoundException When the condition for selecting an entity is not found.
     */
    public OptionalEntity<Followers> selectByUniqueOf(Integer memberId) {
        return doSelectByUniqueOf(memberId, Followers.class);
    }

    protected <ENTITY extends Followers> OptionalEntity<ENTITY> doSelectByUniqueOf(Integer memberId, Class<ENTITY> entityType) {
        return createOptionalEntity(doSelectEntity(xprepareCBAsUniqueOf(memberId), entityType), memberId);
    }

    protected FollowersCB xprepareCBAsUniqueOf(Integer memberId) {
        assertObjectNotNull("memberId", memberId);
        FollowersCB cb = newMyConditionBean(); cb.acceptUniqueOf(memberId);
        return cb;
    }

    // ===================================================================================
    //                                                                         List Select
    //                                                                         ===========
    /**
     * Select the list as result bean.
     * <pre>
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * ListResultBean&lt;Followers&gt; followersList = followersBhv.<span style="color: #DD4747">selectList</span>(cb);
     * for (Followers followers : followersList) {
     *     ... = followers.get...();
     * }
     * </pre>
     * @param cb The condition-bean of Followers. (NotNull)
     * @return The result bean of selected list. (NotNull: if no data, returns empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public ListResultBean<Followers> selectList(FollowersCB cb) {
        return doSelectList(cb, Followers.class);
    }

    protected <ENTITY extends Followers> ListResultBean<ENTITY> doSelectList(FollowersCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        return helpSelectListInternally(cb, tp, new InternalSelectListCallback<ENTITY, FollowersCB>() {
            public List<ENTITY> callbackSelectList(FollowersCB lcb, Class<ENTITY> ltp) { return delegateSelectList(lcb, ltp); } });
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
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * cb.query().addOrderBy_Bar...();
     * cb.<span style="color: #DD4747">paging</span>(20, 3); <span style="color: #3F7E5E">// 20 records per a page and current page number is 3</span>
     * PagingResultBean&lt;Followers&gt; page = followersBhv.<span style="color: #DD4747">selectPage</span>(cb);
     * int allRecordCount = page.getAllRecordCount();
     * int allPageCount = page.getAllPageCount();
     * boolean isExistPrePage = page.isExistPrePage();
     * boolean isExistNextPage = page.isExistNextPage();
     * ...
     * for (Followers followers : page) {
     *     ... = followers.get...();
     * }
     * </pre>
     * @param cb The condition-bean of Followers. (NotNull)
     * @return The result bean of selected page. (NotNull: if no data, returns bean as empty list)
     * @exception DangerousResultSizeException When the result size is over the specified safety size.
     */
    public PagingResultBean<Followers> selectPage(FollowersCB cb) {
        return doSelectPage(cb, Followers.class);
    }

    protected <ENTITY extends Followers> PagingResultBean<ENTITY> doSelectPage(FollowersCB cb, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityType", tp);
        return helpSelectPageInternally(cb, tp, new InternalSelectPageCallback<ENTITY, FollowersCB>() {
            public int callbackSelectCount(FollowersCB cb) { return doSelectCountPlainly(cb); }
            public List<ENTITY> callbackSelectList(FollowersCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
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
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * followersBhv.<span style="color: #DD4747">selectCursor</span>(cb, new EntityRowHandler&lt;Followers&gt;() {
     *     public void handle(Followers entity) {
     *         ... = entity.getFoo...();
     *     }
     * });
     * </pre>
     * @param cb The condition-bean of Followers. (NotNull)
     * @param entityRowHandler The handler of entity row of Followers. (NotNull)
     */
    public void selectCursor(FollowersCB cb, EntityRowHandler<Followers> entityRowHandler) {
        doSelectCursor(cb, entityRowHandler, Followers.class);
    }

    protected <ENTITY extends Followers> void doSelectCursor(FollowersCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) {
        assertCBStateValid(cb); assertObjectNotNull("entityRowHandler", handler); assertObjectNotNull("entityType", tp);
        assertSpecifyDerivedReferrerEntityProperty(cb, tp);
        helpSelectCursorInternally(cb, handler, tp, new InternalSelectCursorCallback<ENTITY, FollowersCB>() {
            public void callbackSelectCursor(FollowersCB cb, EntityRowHandler<ENTITY> handler, Class<ENTITY> tp) { delegateSelectCursor(cb, handler, tp); }
            public List<ENTITY> callbackSelectList(FollowersCB cb, Class<ENTITY> tp) { return doSelectList(cb, tp); }
        });
    }

    // ===================================================================================
    //                                                                       Scalar Select
    //                                                                       =============
    /**
     * Select the scalar value derived by a function from uniquely-selected records. <br />
     * You should call a function method after this method called like as follows:
     * <pre>
     * followersBhv.<span style="color: #DD4747">scalarSelect</span>(Date.class).max(new ScalarQuery() {
     *     public void query(FollowersCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooDatetime()</span>; <span style="color: #3F7E5E">// required for a function</span>
     *         cb.query().setBarName_PrefixSearch("S");
     *     }
     * });
     * </pre>
     * @param <RESULT> The type of result.
     * @param resultType The type of result. (NotNull)
     * @return The scalar function object to specify function for scalar value. (NotNull)
     */
    public <RESULT> SLFunction<FollowersCB, RESULT> scalarSelect(Class<RESULT> resultType) {
        return doScalarSelect(resultType, newMyConditionBean());
    }

    protected <RESULT, CB extends FollowersCB> SLFunction<CB, RESULT> doScalarSelect(Class<RESULT> tp, CB cb) {
        assertObjectNotNull("resultType", tp); assertCBStateValid(cb);
        cb.xsetupForScalarSelect(); cb.getSqlClause().disableSelectIndex(); // for when you use union
        return createSLFunction(cb, tp);
    }

    protected <RESULT, CB extends FollowersCB> SLFunction<CB, RESULT> createSLFunction(CB cb, Class<RESULT> tp) {
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
     * Pull out the list of foreign table 'Member'.
     * @param followersList The list of followers. (NotNull, EmptyAllowed)
     * @return The list of foreign table. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Member> pulloutMember(List<Followers> followersList) {
        return helpPulloutInternally(followersList, new InternalPulloutCallback<Followers, Member>() {
            public Member getFr(Followers et)
            { return et.getMember(); }
            public boolean hasRf() { return true; }
            public void setRfLs(Member et, List<Followers> ls)
            { if (!ls.isEmpty()) { et.setFollowersAsOne(ls.get(0)); } }
        });
    }

    // ===================================================================================
    //                                                                      Extract Column
    //                                                                      ==============
    /**
     * Extract the value list of (single) primary key followersid.
     * @param followersList The list of followers. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractFollowersidList(List<Followers> followersList) {
        return helpExtractListInternally(followersList, new InternalExtractCallback<Followers, Integer>() {
            public Integer getCV(Followers et) { return et.getFollowersid(); }
        });
    }

    /**
     * Extract the value list of (single) unique key memberId.
     * @param followersList The list of followers. (NotNull, EmptyAllowed)
     * @return The list of the column value. (NotNull, EmptyAllowed, NotNullElement)
     */
    public List<Integer> extractMemberIdList(List<Followers> followersList) {
        return helpExtractListInternally(followersList, new InternalExtractCallback<Followers, Integer>() {
            public Integer getCV(Followers et) { return et.getMemberId(); }
        });
    }

    // ===================================================================================
    //                                                                       Entity Update
    //                                                                       =============
    /**
     * Insert the entity modified-only. (DefaultConstraintsEnabled)
     * <pre>
     * Followers followers = new Followers();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * followers.setFoo...(value);
     * followers.setBar...(value);
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//followers.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//followers.set...;</span>
     * followersBhv.<span style="color: #DD4747">insert</span>(followers);
     * ... = followers.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * <p>While, when the entity is created by select, all columns are registered.</p>
     * @param followers The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insert(Followers followers) {
        doInsert(followers, null);
    }

    protected void doInsert(Followers followers, InsertOption<FollowersCB> op) {
        assertObjectNotNull("followers", followers);
        prepareInsertOption(op);
        delegateInsert(followers, op);
    }

    protected void prepareInsertOption(InsertOption<FollowersCB> op) {
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
     * Followers followers = new Followers();
     * followers.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * followers.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//followers.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//followers.set...;</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * followers.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     followersBhv.<span style="color: #DD4747">update</span>(followers);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param followers The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void update(final Followers followers) {
        doUpdate(followers, null);
    }

    protected void doUpdate(Followers followers, final UpdateOption<FollowersCB> op) {
        assertObjectNotNull("followers", followers);
        prepareUpdateOption(op);
        helpUpdateInternally(followers, new InternalUpdateCallback<Followers>() {
            public int callbackDelegateUpdate(Followers et) { return delegateUpdate(et, op); } });
    }

    protected void prepareUpdateOption(UpdateOption<FollowersCB> op) {
        if (op == null) { return; }
        assertUpdateOptionStatus(op);
        if (op.hasSelfSpecification()) {
            op.resolveSelfSpecification(createCBForVaryingUpdate());
        }
        if (op.hasSpecifiedUpdateColumn()) {
            op.resolveUpdateColumnSpecification(createCBForSpecifiedUpdate());
        }
    }

    protected FollowersCB createCBForVaryingUpdate() {
        FollowersCB cb = newMyConditionBean();
        cb.xsetupForVaryingUpdate();
        return cb;
    }

    protected FollowersCB createCBForSpecifiedUpdate() {
        FollowersCB cb = newMyConditionBean();
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
     * @param followers The entity of insert or update target. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void insertOrUpdate(Followers followers) {
        doInesrtOrUpdate(followers, null, null);
    }

    protected void doInesrtOrUpdate(Followers followers, final InsertOption<FollowersCB> iop, final UpdateOption<FollowersCB> uop) {
        helpInsertOrUpdateInternally(followers, new InternalInsertOrUpdateCallback<Followers, FollowersCB>() {
            public void callbackInsert(Followers et) { doInsert(et, iop); }
            public void callbackUpdate(Followers et) { doUpdate(et, uop); }
            public FollowersCB callbackNewMyConditionBean() { return newMyConditionBean(); }
            public int callbackSelectCount(FollowersCB cb) { return selectCount(cb); }
        });
    }

    @Override
    protected void doCreateOrModify(Entity et, InsertOption<? extends ConditionBean> iop, UpdateOption<? extends ConditionBean> uop) {
        if (iop == null && uop == null) { insertOrUpdate(downcast(et)); }
        else {
            iop = iop != null ? iop : new InsertOption<FollowersCB>();
            uop = uop != null ? uop : new UpdateOption<FollowersCB>();
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
     * Followers followers = new Followers();
     * followers.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * followers.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     followersBhv.<span style="color: #DD4747">delete</span>(followers);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param followers The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void delete(Followers followers) {
        doDelete(followers, null);
    }

    protected void doDelete(Followers followers, final DeleteOption<FollowersCB> op) {
        assertObjectNotNull("followers", followers);
        prepareDeleteOption(op);
        helpDeleteInternally(followers, new InternalDeleteCallback<Followers>() {
            public int callbackDelegateDelete(Followers et) { return delegateDelete(et, op); } });
    }

    protected void prepareDeleteOption(DeleteOption<FollowersCB> op) {
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
     *     Followers followers = new Followers();
     *     followers.setFooName("foo");
     *     if (...) {
     *         followers.setFooPrice(123);
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are registered</span>
     *     <span style="color: #3F7E5E">// FOO_PRICE not-called in any entities are registered as null without default value</span>
     *     <span style="color: #3F7E5E">// columns not-called in all entities are registered as null or default value</span>
     *     followersList.add(followers);
     * }
     * followersBhv.<span style="color: #DD4747">batchInsert</span>(followersList);
     * </pre>
     * <p>While, when the entities are created by select, all columns are registered.</p>
     * <p>And if the table has an identity, entities after the process don't have incremented values.
     * (When you use the (normal) insert(), you can get the incremented value from your entity)</p>
     * @param followersList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNullAllowed: when auto-increment)
     * @return The array of inserted count. (NotNull, EmptyAllowed)
     */
    public int[] batchInsert(List<Followers> followersList) {
        InsertOption<FollowersCB> op = createInsertUpdateOption();
        return doBatchInsert(followersList, op);
    }

    protected int[] doBatchInsert(List<Followers> followersList, InsertOption<FollowersCB> op) {
        assertObjectNotNull("followersList", followersList);
        prepareBatchInsertOption(followersList, op);
        return delegateBatchInsert(followersList, op);
    }

    protected void prepareBatchInsertOption(List<Followers> followersList, InsertOption<FollowersCB> op) {
        op.xallowInsertColumnModifiedPropertiesFragmented();
        op.xacceptInsertColumnModifiedPropertiesIfNeeds(followersList);
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
     *     Followers followers = new Followers();
     *     followers.setFooName("foo");
     *     if (...) {
     *         followers.setFooPrice(123);
     *     } else {
     *         followers.setFooPrice(null); <span style="color: #3F7E5E">// updated as null</span>
     *         <span style="color: #3F7E5E">//followers.setFooDate(...); // *not allowed, fragmented</span>
     *     }
     *     <span style="color: #3F7E5E">// FOO_NAME and FOO_PRICE (and record meta columns) are updated</span>
     *     <span style="color: #3F7E5E">// (others are not updated: their values are kept)</span>
     *     followersList.add(followers);
     * }
     * followersBhv.<span style="color: #DD4747">batchUpdate</span>(followersList);
     * </pre>
     * @param followersList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<Followers> followersList) {
        UpdateOption<FollowersCB> op = createPlainUpdateOption();
        return doBatchUpdate(followersList, op);
    }

    protected int[] doBatchUpdate(List<Followers> followersList, UpdateOption<FollowersCB> op) {
        assertObjectNotNull("followersList", followersList);
        prepareBatchUpdateOption(followersList, op);
        return delegateBatchUpdate(followersList, op);
    }

    protected void prepareBatchUpdateOption(List<Followers> followersList, UpdateOption<FollowersCB> op) {
        op.xacceptUpdateColumnModifiedPropertiesIfNeeds(followersList);
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
     * followersBhv.<span style="color: #DD4747">batchUpdate</span>(followersList, new SpecifyQuery<FollowersCB>() {
     *     public void specify(FollowersCB cb) { <span style="color: #3F7E5E">// the two only updated</span>
     *         cb.specify().<span style="color: #DD4747">columnFooStatusCode()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *         cb.specify().<span style="color: #DD4747">columnBarDate()</span>; <span style="color: #3F7E5E">// should be modified in any entities</span>
     *     }
     * });
     * <span style="color: #3F7E5E">// e.g. update every column in the table</span>
     * followersBhv.<span style="color: #DD4747">batchUpdate</span>(followersList, new SpecifyQuery<FollowersCB>() {
     *     public void specify(FollowersCB cb) { <span style="color: #3F7E5E">// all columns are updated</span>
     *         cb.specify().<span style="color: #DD4747">columnEveryColumn()</span>; <span style="color: #3F7E5E">// no check of modified properties</span>
     *     }
     * });
     * </pre>
     * <p>You can specify update columns used on set clause of update statement.
     * However you do not need to specify common columns for update
     * and an optimistic lock column because they are specified implicitly.</p>
     * <p>And you should specify columns that are modified in any entities (at least one entity).
     * But if you specify every column, it has no check.</p>
     * @param followersList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param updateColumnSpec The specification of update columns. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchUpdate(List<Followers> followersList, SpecifyQuery<FollowersCB> updateColumnSpec) {
        return doBatchUpdate(followersList, createSpecifiedUpdateOption(updateColumnSpec));
    }

    @Override
    protected int[] doLumpModifyNonstrict(List<Entity> ls, UpdateOption<? extends ConditionBean> op) {
        return doLumpModify(ls, op);
    }

    /**
     * Batch-delete the entity list. (NonExclusiveControl) <br />
     * This method uses executeBatch() of java.sql.PreparedStatement.
     * @param followersList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     */
    public int[] batchDelete(List<Followers> followersList) {
        return doBatchDelete(followersList, null);
    }

    protected int[] doBatchDelete(List<Followers> followersList, DeleteOption<FollowersCB> op) {
        assertObjectNotNull("followersList", followersList);
        prepareDeleteOption(op);
        return delegateBatchDelete(followersList, op);
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
     * followersBhv.<span style="color: #DD4747">queryInsert</span>(new QueryInsertSetupper&lt;Followers, FollowersCB&gt;() {
     *     public ConditionBean setup(followers entity, FollowersCB intoCB) {
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
    public int queryInsert(QueryInsertSetupper<Followers, FollowersCB> setupper) {
        return doQueryInsert(setupper, null);
    }

    protected int doQueryInsert(QueryInsertSetupper<Followers, FollowersCB> sp, InsertOption<FollowersCB> op) {
        assertObjectNotNull("setupper", sp);
        prepareInsertOption(op);
        Followers e = new Followers();
        FollowersCB cb = createCBForQueryInsert();
        return delegateQueryInsert(e, cb, sp.setup(e, cb), op);
    }

    protected FollowersCB createCBForQueryInsert() {
        FollowersCB cb = newMyConditionBean();
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
     * Followers followers = new Followers();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//followers.setPK...(value);</span>
     * followers.setFoo...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set values of common columns</span>
     * <span style="color: #3F7E5E">//followers.setRegisterUser(value);</span>
     * <span style="color: #3F7E5E">//followers.set...;</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//followers.setVersionNo(value);</span>
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * followersBhv.<span style="color: #DD4747">queryUpdate</span>(followers, cb);
     * </pre>
     * @param followers The entity that contains update values. (NotNull, PrimaryKeyNullAllowed)
     * @param cb The condition-bean of Followers. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition.
     */
    public int queryUpdate(Followers followers, FollowersCB cb) {
        return doQueryUpdate(followers, cb, null);
    }

    protected int doQueryUpdate(Followers followers, FollowersCB cb, UpdateOption<FollowersCB> op) {
        assertObjectNotNull("followers", followers); assertCBStateValid(cb);
        prepareUpdateOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryUpdate(followers, cb, op) : 0;
    }

    @Override
    protected int doRangeModify(Entity et, ConditionBean cb, UpdateOption<? extends ConditionBean> op) {
        if (op == null) { return queryUpdate(downcast(et), (FollowersCB)cb); }
        else { return varyingQueryUpdate(downcast(et), (FollowersCB)cb, downcast(op)); }
    }

    /**
     * Delete the several entities by query. (NonExclusiveControl)
     * <pre>
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * followersBhv.<span style="color: #DD4747">queryDelete</span>(followers, cb);
     * </pre>
     * @param cb The condition-bean of Followers. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition.
     */
    public int queryDelete(FollowersCB cb) {
        return doQueryDelete(cb, null);
    }

    protected int doQueryDelete(FollowersCB cb, DeleteOption<FollowersCB> op) {
        assertCBStateValid(cb);
        prepareDeleteOption(op);
        return checkCountBeforeQueryUpdateIfNeeds(cb) ? delegateQueryDelete(cb, op) : 0;
    }

    @Override
    protected int doRangeRemove(ConditionBean cb, DeleteOption<? extends ConditionBean> op) {
        if (op == null) { return queryDelete((FollowersCB)cb); }
        else { return varyingQueryDelete((FollowersCB)cb, downcast(op)); }
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
     * Followers followers = new Followers();
     * <span style="color: #3F7E5E">// if auto-increment, you don't need to set the PK value</span>
     * followers.setFoo...(value);
     * followers.setBar...(value);
     * InsertOption<FollowersCB> option = new InsertOption<FollowersCB>();
     * <span style="color: #3F7E5E">// you can insert by your values for common columns</span>
     * option.disableCommonColumnAutoSetup();
     * followersBhv.<span style="color: #DD4747">varyingInsert</span>(followers, option);
     * ... = followers.getPK...(); <span style="color: #3F7E5E">// if auto-increment, you can get the value after</span>
     * </pre>
     * @param followers The entity of insert target. (NotNull, PrimaryKeyNullAllowed: when auto-increment)
     * @param option The option of insert for varying requests. (NotNull)
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsert(Followers followers, InsertOption<FollowersCB> option) {
        assertInsertOptionNotNull(option);
        doInsert(followers, option);
    }

    /**
     * Update the entity with varying requests modified-only. (ZeroUpdateException, NonExclusiveControl) <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification), disableCommonColumnAutoSetup(). <br />
     * Other specifications are same as update(entity).
     * <pre>
     * Followers followers = new Followers();
     * followers.setPK...(value); <span style="color: #3F7E5E">// required</span>
     * followers.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// if exclusive control, the value of exclusive control column is required</span>
     * followers.<span style="color: #DD4747">setVersionNo</span>(value);
     * try {
     *     <span style="color: #3F7E5E">// you can update by self calculation values</span>
     *     UpdateOption&lt;FollowersCB&gt; option = new UpdateOption&lt;FollowersCB&gt;();
     *     option.self(new SpecifyQuery&lt;FollowersCB&gt;() {
     *         public void specify(FollowersCB cb) {
     *             cb.specify().<span style="color: #DD4747">columnXxxCount()</span>;
     *         }
     *     }).plus(1); <span style="color: #3F7E5E">// XXX_COUNT = XXX_COUNT + 1</span>
     *     followersBhv.<span style="color: #DD4747">varyingUpdate</span>(followers, option);
     * } catch (EntityAlreadyUpdatedException e) { <span style="color: #3F7E5E">// if concurrent update</span>
     *     ...
     * }
     * </pre>
     * @param followers The entity of update target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingUpdate(Followers followers, UpdateOption<FollowersCB> option) {
        assertUpdateOptionNotNull(option);
        doUpdate(followers, option);
    }

    /**
     * Insert or update the entity with varying requests. (ExclusiveControl: when update) <br />
     * Other specifications are same as insertOrUpdate(entity).
     * @param followers The entity of insert or update target. (NotNull)
     * @param insertOption The option of insert for varying requests. (NotNull)
     * @param updateOption The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     * @exception EntityAlreadyExistsException When the entity already exists. (unique constraint violation)
     */
    public void varyingInsertOrUpdate(Followers followers, InsertOption<FollowersCB> insertOption, UpdateOption<FollowersCB> updateOption) {
        assertInsertOptionNotNull(insertOption); assertUpdateOptionNotNull(updateOption);
        doInesrtOrUpdate(followers, insertOption, updateOption);
    }

    /**
     * Delete the entity with varying requests. (ZeroUpdateException, NonExclusiveControl) <br />
     * Now a valid option does not exist. <br />
     * Other specifications are same as delete(entity).
     * @param followers The entity of delete target. (NotNull, PrimaryKeyNotNull, ConcurrencyColumnRequired)
     * @param option The option of update for varying requests. (NotNull)
     * @exception EntityAlreadyDeletedException When the entity has already been deleted. (not found)
     * @exception EntityDuplicatedException When the entity has been duplicated.
     */
    public void varyingDelete(Followers followers, DeleteOption<FollowersCB> option) {
        assertDeleteOptionNotNull(option);
        doDelete(followers, option);
    }

    // -----------------------------------------------------
    //                                          Batch Update
    //                                          ------------
    /**
     * Batch-insert the list with varying requests. <br />
     * For example, disableCommonColumnAutoSetup()
     * , disablePrimaryKeyIdentity(), limitBatchInsertLogging(). <br />
     * Other specifications are same as batchInsert(entityList).
     * @param followersList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of insert for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchInsert(List<Followers> followersList, InsertOption<FollowersCB> option) {
        assertInsertOptionNotNull(option);
        return doBatchInsert(followersList, option);
    }

    /**
     * Batch-update the list with varying requests. <br />
     * For example, self(selfCalculationSpecification), specify(updateColumnSpecification)
     * , disableCommonColumnAutoSetup(), limitBatchUpdateLogging(). <br />
     * Other specifications are same as batchUpdate(entityList).
     * @param followersList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The array of updated count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchUpdate(List<Followers> followersList, UpdateOption<FollowersCB> option) {
        assertUpdateOptionNotNull(option);
        return doBatchUpdate(followersList, option);
    }

    /**
     * Batch-delete the list with varying requests. <br />
     * For example, limitBatchDeleteLogging(). <br />
     * Other specifications are same as batchDelete(entityList).
     * @param followersList The list of the entity. (NotNull, EmptyAllowed, PrimaryKeyNotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The array of deleted count. (NotNull, EmptyAllowed)
     */
    public int[] varyingBatchDelete(List<Followers> followersList, DeleteOption<FollowersCB> option) {
        assertDeleteOptionNotNull(option);
        return doBatchDelete(followersList, option);
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
    public int varyingQueryInsert(QueryInsertSetupper<Followers, FollowersCB> setupper, InsertOption<FollowersCB> option) {
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
     * Followers followers = new Followers();
     * <span style="color: #3F7E5E">// you don't need to set PK value</span>
     * <span style="color: #3F7E5E">//followers.setPK...(value);</span>
     * followers.setOther...(value); <span style="color: #3F7E5E">// you should set only modified columns</span>
     * <span style="color: #3F7E5E">// you don't need to set a value of exclusive control column</span>
     * <span style="color: #3F7E5E">// (auto-increment for version number is valid though non-exclusive control)</span>
     * <span style="color: #3F7E5E">//followers.setVersionNo(value);</span>
     * FollowersCB cb = new FollowersCB();
     * cb.query().setFoo...(value);
     * UpdateOption&lt;FollowersCB&gt; option = new UpdateOption&lt;FollowersCB&gt;();
     * option.self(new SpecifyQuery&lt;FollowersCB&gt;() {
     *     public void specify(FollowersCB cb) {
     *         cb.specify().<span style="color: #DD4747">columnFooCount()</span>;
     *     }
     * }).plus(1); <span style="color: #3F7E5E">// FOO_COUNT = FOO_COUNT + 1</span>
     * followersBhv.<span style="color: #DD4747">varyingQueryUpdate</span>(followers, cb, option);
     * </pre>
     * @param followers The entity that contains update values. (NotNull) {PrimaryKeyNotRequired}
     * @param cb The condition-bean of Followers. (NotNull)
     * @param option The option of update for varying requests. (NotNull)
     * @return The updated count.
     * @exception NonQueryUpdateNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryUpdate(Followers followers, FollowersCB cb, UpdateOption<FollowersCB> option) {
        assertUpdateOptionNotNull(option);
        return doQueryUpdate(followers, cb, option);
    }

    /**
     * Delete the several entities by query with varying requests non-strictly. <br />
     * For example, allowNonQueryDelete(). <br />
     * Other specifications are same as batchUpdateNonstrict(entityList).
     * @param cb The condition-bean of Followers. (NotNull)
     * @param option The option of delete for varying requests. (NotNull)
     * @return The deleted count.
     * @exception NonQueryDeleteNotAllowedException When the query has no condition (if not allowed).
     */
    public int varyingQueryDelete(FollowersCB cb, DeleteOption<FollowersCB> option) {
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
    public OutsideSqlBasicExecutor<FollowersBhv> outsideSql() {
        return doOutsideSql();
    }

    // ===================================================================================
    //                                                                     Delegate Method
    //                                                                     ===============
    // [Behavior Command]
    // -----------------------------------------------------
    //                                                Select
    //                                                ------
    protected int delegateSelectCountUniquely(FollowersCB cb) { return invoke(createSelectCountCBCommand(cb, true)); }
    protected int delegateSelectCountPlainly(FollowersCB cb) { return invoke(createSelectCountCBCommand(cb, false)); }
    protected <ENTITY extends Followers> void delegateSelectCursor(FollowersCB cb, EntityRowHandler<ENTITY> rh, Class<ENTITY> tp)
    { invoke(createSelectCursorCBCommand(cb, rh, tp)); }
    protected <ENTITY extends Followers> List<ENTITY> delegateSelectList(FollowersCB cb, Class<ENTITY> tp)
    { return invoke(createSelectListCBCommand(cb, tp)); }

    // -----------------------------------------------------
    //                                                Update
    //                                                ------
    protected int delegateInsert(Followers et, InsertOption<FollowersCB> op)
    { if (!processBeforeInsert(et, op)) { return 0; }
      return invoke(createInsertEntityCommand(et, op)); }
    protected int delegateUpdate(Followers et, UpdateOption<FollowersCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return delegateUpdateNonstrict(et, op); }
    protected int delegateUpdateNonstrict(Followers et, UpdateOption<FollowersCB> op)
    { if (!processBeforeUpdate(et, op)) { return 0; }
      return invoke(createUpdateNonstrictEntityCommand(et, op)); }
    protected int delegateDelete(Followers et, DeleteOption<FollowersCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return delegateDeleteNonstrict(et, op); }
    protected int delegateDeleteNonstrict(Followers et, DeleteOption<FollowersCB> op)
    { if (!processBeforeDelete(et, op)) { return 0; }
      return invoke(createDeleteNonstrictEntityCommand(et, op)); }

    protected int[] delegateBatchInsert(List<Followers> ls, InsertOption<FollowersCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchInsertCommand(processBatchInternally(ls, op), op)); }
    protected int[] delegateBatchUpdate(List<Followers> ls, UpdateOption<FollowersCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchUpdateNonstrict(ls, op); }
    protected int[] delegateBatchUpdateNonstrict(List<Followers> ls, UpdateOption<FollowersCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchUpdateNonstrictCommand(processBatchInternally(ls, op, true), op)); }
    protected int[] delegateBatchDelete(List<Followers> ls, DeleteOption<FollowersCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return delegateBatchDeleteNonstrict(ls, op); }
    protected int[] delegateBatchDeleteNonstrict(List<Followers> ls, DeleteOption<FollowersCB> op)
    { if (ls.isEmpty()) { return new int[]{}; }
      return invoke(createBatchDeleteNonstrictCommand(processBatchInternally(ls, op, true), op)); }

    protected int delegateQueryInsert(Followers et, FollowersCB inCB, ConditionBean resCB, InsertOption<FollowersCB> op)
    { if (!processBeforeQueryInsert(et, inCB, resCB, op)) { return 0; } return invoke(createQueryInsertCBCommand(et, inCB, resCB, op));  }
    protected int delegateQueryUpdate(Followers et, FollowersCB cb, UpdateOption<FollowersCB> op)
    { if (!processBeforeQueryUpdate(et, cb, op)) { return 0; } return invoke(createQueryUpdateCBCommand(et, cb, op));  }
    protected int delegateQueryDelete(FollowersCB cb, DeleteOption<FollowersCB> op)
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
    protected Followers downcast(Entity et) {
        return helpEntityDowncastInternally(et, Followers.class);
    }

    protected FollowersCB downcast(ConditionBean cb) {
        return helpConditionBeanDowncastInternally(cb, FollowersCB.class);
    }

    @SuppressWarnings("unchecked")
    protected List<Followers> downcast(List<? extends Entity> ls) {
        return (List<Followers>)ls;
    }

    @SuppressWarnings("unchecked")
    protected InsertOption<FollowersCB> downcast(InsertOption<? extends ConditionBean> op) {
        return (InsertOption<FollowersCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected UpdateOption<FollowersCB> downcast(UpdateOption<? extends ConditionBean> op) {
        return (UpdateOption<FollowersCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected DeleteOption<FollowersCB> downcast(DeleteOption<? extends ConditionBean> op) {
        return (DeleteOption<FollowersCB>)op;
    }

    @SuppressWarnings("unchecked")
    protected QueryInsertSetupper<Followers, FollowersCB> downcast(QueryInsertSetupper<? extends Entity, ? extends ConditionBean> sp) {
        return (QueryInsertSetupper<Followers, FollowersCB>)sp;
    }
}
