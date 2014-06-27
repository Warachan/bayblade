package jp.bizreach.twitter.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;
import jp.bizreach.twitter.dbflute.allcommon.DBMetaInstanceHandler;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The entity of login as TABLE. <br />
 * ログイン
 * <pre>
 * [primary-key]
 *     LOGIN_ID
 * 
 * [column]
 *     LOGIN_ID, MEMBER_ID, LOGIN_DATETIME
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     LOGIN_ID
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
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer loginId = entity.getLoginId();
 * Integer memberId = entity.getMemberId();
 * java.sql.Timestamp loginDatetime = entity.getLoginDatetime();
 * entity.setLoginId(loginId);
 * entity.setMemberId(memberId);
 * entity.setLoginDatetime(loginDatetime);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsLogin implements Entity, Serializable, Cloneable {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** Serial version UID. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                                Column
    //                                                ------
    /** LOGIN_ID: {PK, ID, NotNull, INT(10)} */
    protected Integer _loginId;

    /** MEMBER_ID: {IX, NotNull, INT(10), FK to member} */
    protected Integer _memberId;

    /** LOGIN_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _loginDatetime;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** The unique-driven properties for this entity. (NotNull) */
    protected final EntityUniqueDrivenProperties __uniqueDrivenProperties = newUniqueDrivenProperties();

    /** The modified properties for this entity. (NotNull) */
    protected final EntityModifiedProperties __modifiedProperties = newModifiedProperties();

    /** Is the entity created by DBFlute select process? */
    protected boolean __createdBySelect;

    // ===================================================================================
    //                                                                          Table Name
    //                                                                          ==========
    /**
     * {@inheritDoc}
     */
    public String getTableDbName() {
        return "login";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "login";
    }

    // ===================================================================================
    //                                                                              DBMeta
    //                                                                              ======
    /**
     * {@inheritDoc}
     */
    public DBMeta getDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(getTableDbName());
    }

    // ===================================================================================
    //                                                                         Primary Key
    //                                                                         ===========
    /**
     * {@inheritDoc}
     */
    public boolean hasPrimaryKeyValue() {
        if (getLoginId() == null) { return false; }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    public Set<String> myuniqueDrivenProperties() {
        return __uniqueDrivenProperties.getPropertyNames();
    }

    protected EntityUniqueDrivenProperties newUniqueDrivenProperties() {
        return new EntityUniqueDrivenProperties();
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** member by my MEMBER_ID, named 'member'. */
    protected Member _member;

    /**
     * [get] member by my MEMBER_ID, named 'member'.
     * @return The entity of foreign property 'member'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMember() {
        return _member;
    }

    /**
     * [set] member by my MEMBER_ID, named 'member'.
     * @param member The entity of foreign property 'member'. (NullAllowed)
     */
    public void setMember(Member member) {
        _member = member;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                 Modified Properties
    //                                                                 ===================
    /**
     * {@inheritDoc}
     */
    public Set<String> modifiedProperties() {
        return __modifiedProperties.getPropertyNames();
    }

    /**
     * {@inheritDoc}
     */
    public void clearModifiedInfo() {
        __modifiedProperties.clear();
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasModification() {
        return !__modifiedProperties.isEmpty();
    }

    protected EntityModifiedProperties newModifiedProperties() {
        return new EntityModifiedProperties();
    }

    // ===================================================================================
    //                                                                     Birthplace Mark
    //                                                                     ===============
    /**
     * {@inheritDoc}
     */
    public void markAsSelect() {
        __createdBySelect = true;
    }

    /**
     * {@inheritDoc}
     */
    public boolean createdBySelect() {
        return __createdBySelect;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    /**
     * Determine the object is equal with this. <br />
     * If primary-keys or columns of the other are same as this one, returns true.
     * @param obj The object as other entity. (NullAllowed: if null, returns false fixedly)
     * @return Comparing result.
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof BsLogin)) { return false; }
        BsLogin other = (BsLogin)obj;
        if (!xSV(getLoginId(), other.getLoginId())) { return false; }
        return true;
    }
    protected boolean xSV(Object v1, Object v2) {
        return FunCustodial.isSameValue(v1, v2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    public int hashCode() {
        int hs = 17;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, getLoginId());
        return hs;
    }
    protected int xCH(int hs, Object vl) {
        return FunCustodial.calculateHashcode(hs, vl);
    }

    /**
     * {@inheritDoc}
     */
    public int instanceHash() {
        return super.hashCode();
    }

    /**
     * Convert to display string of entity's data. (no relation data)
     * @return The display string of all columns and relation existences. (NotNull)
     */
    public String toString() {
        return buildDisplayString(FunCustodial.toClassTitle(this), true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String toStringWithRelation() {
        StringBuilder sb = new StringBuilder();
        sb.append(toString());
        String li = "\n  ";
        if (_member != null)
        { sb.append(li).append(xbRDS(_member, "member")); }
        return sb.toString();
    }
    protected String xbRDS(Entity et, String name) { // buildRelationDisplayString()
        return et.buildDisplayString(name, true, true);
    }

    /**
     * {@inheritDoc}
     */
    public String buildDisplayString(String name, boolean column, boolean relation) {
        StringBuilder sb = new StringBuilder();
        if (name != null) { sb.append(name).append(column || relation ? ":" : ""); }
        if (column) { sb.append(buildColumnString()); }
        if (relation) { sb.append(buildRelationString()); }
        sb.append("@").append(Integer.toHexString(hashCode()));
        return sb.toString();
    }
    protected String buildColumnString() {
        StringBuilder sb = new StringBuilder();
        String dm = ", ";
        sb.append(dm).append(getLoginId());
        sb.append(dm).append(getMemberId());
        sb.append(dm).append(getLoginDatetime());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_member != null) { sb.append(cm).append("member"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public Login clone() {
        try {
            return (Login)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] LOGIN_ID: {PK, ID, NotNull, INT(10)} <br />
     * ログインID : ログインした瞬間のID
     * @return The value of the column 'LOGIN_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getLoginId() {
        return _loginId;
    }

    /**
     * [set] LOGIN_ID: {PK, ID, NotNull, INT(10)} <br />
     * ログインID : ログインした瞬間のID
     * @param loginId The value of the column 'LOGIN_ID'. (basically NotNull if update: for the constraint)
     */
    public void setLoginId(Integer loginId) {
        __modifiedProperties.addPropertyName("loginId");
        _loginId = loginId;
    }

    /**
     * [get] MEMBER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * 会員ID : 会員のID
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * 会員ID : 会員のID
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.addPropertyName("memberId");
        _memberId = memberId;
    }

    /**
     * [get] LOGIN_DATETIME: {NotNull, DATETIME(19)} <br />
     * ログイン日時
     * @return The value of the column 'LOGIN_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getLoginDatetime() {
        return _loginDatetime;
    }

    /**
     * [set] LOGIN_DATETIME: {NotNull, DATETIME(19)} <br />
     * ログイン日時
     * @param loginDatetime The value of the column 'LOGIN_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setLoginDatetime(java.sql.Timestamp loginDatetime) {
        __modifiedProperties.addPropertyName("loginDatetime");
        _loginDatetime = loginDatetime;
    }
}
