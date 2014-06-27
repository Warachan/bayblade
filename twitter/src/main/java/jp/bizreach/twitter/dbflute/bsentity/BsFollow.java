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
 * The entity of follow as TABLE. <br />
 * フォロー
 * <pre>
 * [primary-key]
 *     FOLLOW_ID
 * 
 * [column]
 *     FOLLOW_ID, YOU_ID, ME_ID, FOLLOW_DATETIME
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     FOLLOW_ID
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
 *     memberByMeId, memberByYouId
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer followId = entity.getFollowId();
 * Integer youId = entity.getYouId();
 * Integer meId = entity.getMeId();
 * java.sql.Timestamp followDatetime = entity.getFollowDatetime();
 * entity.setFollowId(followId);
 * entity.setYouId(youId);
 * entity.setMeId(meId);
 * entity.setFollowDatetime(followDatetime);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsFollow implements Entity, Serializable, Cloneable {

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
    /** FOLLOW_ID: {PK, ID, NotNull, INT(10)} */
    protected Integer _followId;

    /** YOU_ID: {UQ, NotNull, INT(10), FK to member} */
    protected Integer _youId;

    /** ME_ID: {IX, NotNull, INT(10), FK to member} */
    protected Integer _meId;

    /** FOLLOW_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _followDatetime;

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
        return "follow";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "follow";
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
        if (getFollowId() == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br />
     * You can update the entity by the key when entity update (NOT batch update).
     * @param youId : UQ, NotNull, INT(10), FK to member. (NotNull)
     */
    public void uniqueBy(Integer youId) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("youId");
        setYouId(youId);
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
    /** member by my ME_ID, named 'memberByMeId'. */
    protected Member _memberByMeId;

    /**
     * [get] member by my ME_ID, named 'memberByMeId'.
     * @return The entity of foreign property 'memberByMeId'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMemberByMeId() {
        return _memberByMeId;
    }

    /**
     * [set] member by my ME_ID, named 'memberByMeId'.
     * @param memberByMeId The entity of foreign property 'memberByMeId'. (NullAllowed)
     */
    public void setMemberByMeId(Member memberByMeId) {
        _memberByMeId = memberByMeId;
    }

    /** member by my YOU_ID, named 'memberByYouId'. */
    protected Member _memberByYouId;

    /**
     * [get] member by my YOU_ID, named 'memberByYouId'.
     * @return The entity of foreign property 'memberByYouId'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMemberByYouId() {
        return _memberByYouId;
    }

    /**
     * [set] member by my YOU_ID, named 'memberByYouId'.
     * @param memberByYouId The entity of foreign property 'memberByYouId'. (NullAllowed)
     */
    public void setMemberByYouId(Member memberByYouId) {
        _memberByYouId = memberByYouId;
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
        if (obj == null || !(obj instanceof BsFollow)) { return false; }
        BsFollow other = (BsFollow)obj;
        if (!xSV(getFollowId(), other.getFollowId())) { return false; }
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
        hs = xCH(hs, getFollowId());
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
        if (_memberByMeId != null)
        { sb.append(li).append(xbRDS(_memberByMeId, "memberByMeId")); }
        if (_memberByYouId != null)
        { sb.append(li).append(xbRDS(_memberByYouId, "memberByYouId")); }
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
        sb.append(dm).append(getFollowId());
        sb.append(dm).append(getYouId());
        sb.append(dm).append(getMeId());
        sb.append(dm).append(getFollowDatetime());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_memberByMeId != null) { sb.append(cm).append("memberByMeId"); }
        if (_memberByYouId != null) { sb.append(cm).append("memberByYouId"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public Follow clone() {
        try {
            return (Follow)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] FOLLOW_ID: {PK, ID, NotNull, INT(10)} <br />
     * フォローID
     * @return The value of the column 'FOLLOW_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getFollowId() {
        return _followId;
    }

    /**
     * [set] FOLLOW_ID: {PK, ID, NotNull, INT(10)} <br />
     * フォローID
     * @param followId The value of the column 'FOLLOW_ID'. (basically NotNull if update: for the constraint)
     */
    public void setFollowId(Integer followId) {
        __modifiedProperties.addPropertyName("followId");
        _followId = followId;
    }

    /**
     * [get] YOU_ID: {UQ, NotNull, INT(10), FK to member} <br />
     * フォローする人のID : 会員のID
     * @return The value of the column 'YOU_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getYouId() {
        return _youId;
    }

    /**
     * [set] YOU_ID: {UQ, NotNull, INT(10), FK to member} <br />
     * フォローする人のID : 会員のID
     * @param youId The value of the column 'YOU_ID'. (basically NotNull if update: for the constraint)
     */
    public void setYouId(Integer youId) {
        __modifiedProperties.addPropertyName("youId");
        _youId = youId;
    }

    /**
     * [get] ME_ID: {IX, NotNull, INT(10), FK to member} <br />
     * フォローされる人のID : 会員のID
     * @return The value of the column 'ME_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMeId() {
        return _meId;
    }

    /**
     * [set] ME_ID: {IX, NotNull, INT(10), FK to member} <br />
     * フォローされる人のID : 会員のID
     * @param meId The value of the column 'ME_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMeId(Integer meId) {
        __modifiedProperties.addPropertyName("meId");
        _meId = meId;
    }

    /**
     * [get] FOLLOW_DATETIME: {NotNull, DATETIME(19)} <br />
     * follow_datetime
     * @return The value of the column 'FOLLOW_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getFollowDatetime() {
        return _followDatetime;
    }

    /**
     * [set] FOLLOW_DATETIME: {NotNull, DATETIME(19)} <br />
     * follow_datetime
     * @param followDatetime The value of the column 'FOLLOW_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setFollowDatetime(java.sql.Timestamp followDatetime) {
        __modifiedProperties.addPropertyName("followDatetime");
        _followDatetime = followDatetime;
    }
}
