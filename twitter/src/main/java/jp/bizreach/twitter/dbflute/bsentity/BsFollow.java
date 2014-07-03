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
 *     FOLLOW_ID, YOU_ID, MEMBER_ID, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE, DEL_FLG
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
 *     memberByYouId, memberByMemberId
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer followId = entity.getFollowId();
 * Integer youId = entity.getYouId();
 * Integer memberId = entity.getMemberId();
 * java.sql.Timestamp insDatetime = entity.getInsDatetime();
 * java.sql.Timestamp updDatetime = entity.getUpdDatetime();
 * String insTrace = entity.getInsTrace();
 * String updTrace = entity.getUpdTrace();
 * String delFlg = entity.getDelFlg();
 * entity.setFollowId(followId);
 * entity.setYouId(youId);
 * entity.setMemberId(memberId);
 * entity.setInsDatetime(insDatetime);
 * entity.setUpdDatetime(updDatetime);
 * entity.setInsTrace(insTrace);
 * entity.setUpdTrace(updTrace);
 * entity.setDelFlg(delFlg);
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

    /** YOU_ID: {IX, NotNull, INT(10), FK to member} */
    protected Integer _youId;

    /** MEMBER_ID: {IX, NotNull, INT(10), FK to member} */
    protected Integer _memberId;

    /** INS_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _insDatetime;

    /** UPD_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _updDatetime;

    /** INS_TRACE: {NotNull, VARCHAR(256)} */
    protected String _insTrace;

    /** UPD_TRACE: {NotNull, VARCHAR(256)} */
    protected String _updTrace;

    /** DEL_FLG: {NotNull, CHAR(1), default=[N]} */
    protected String _delFlg;

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

    /** member by my MEMBER_ID, named 'memberByMemberId'. */
    protected Member _memberByMemberId;

    /**
     * [get] member by my MEMBER_ID, named 'memberByMemberId'.
     * @return The entity of foreign property 'memberByMemberId'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMemberByMemberId() {
        return _memberByMemberId;
    }

    /**
     * [set] member by my MEMBER_ID, named 'memberByMemberId'.
     * @param memberByMemberId The entity of foreign property 'memberByMemberId'. (NullAllowed)
     */
    public void setMemberByMemberId(Member memberByMemberId) {
        _memberByMemberId = memberByMemberId;
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
        if (_memberByYouId != null)
        { sb.append(li).append(xbRDS(_memberByYouId, "memberByYouId")); }
        if (_memberByMemberId != null)
        { sb.append(li).append(xbRDS(_memberByMemberId, "memberByMemberId")); }
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
        sb.append(dm).append(getMemberId());
        sb.append(dm).append(getInsDatetime());
        sb.append(dm).append(getUpdDatetime());
        sb.append(dm).append(getInsTrace());
        sb.append(dm).append(getUpdTrace());
        sb.append(dm).append(getDelFlg());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_memberByYouId != null) { sb.append(cm).append("memberByYouId"); }
        if (_memberByMemberId != null) { sb.append(cm).append("memberByMemberId"); }
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
     * [get] YOU_ID: {IX, NotNull, INT(10), FK to member} <br />
     * フォローする人のID : 会員のID
     * @return The value of the column 'YOU_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getYouId() {
        return _youId;
    }

    /**
     * [set] YOU_ID: {IX, NotNull, INT(10), FK to member} <br />
     * フォローする人のID : 会員のID
     * @param youId The value of the column 'YOU_ID'. (basically NotNull if update: for the constraint)
     */
    public void setYouId(Integer youId) {
        __modifiedProperties.addPropertyName("youId");
        _youId = youId;
    }

    /**
     * [get] MEMBER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * フォローされる人のID : フォローしている自分のID
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * フォローされる人のID : フォローしている自分のID
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.addPropertyName("memberId");
        _memberId = memberId;
    }

    /**
     * [get] INS_DATETIME: {NotNull, DATETIME(19)} <br />
     * insert日時
     * @return The value of the column 'INS_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getInsDatetime() {
        return _insDatetime;
    }

    /**
     * [set] INS_DATETIME: {NotNull, DATETIME(19)} <br />
     * insert日時
     * @param insDatetime The value of the column 'INS_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setInsDatetime(java.sql.Timestamp insDatetime) {
        __modifiedProperties.addPropertyName("insDatetime");
        _insDatetime = insDatetime;
    }

    /**
     * [get] UPD_DATETIME: {NotNull, DATETIME(19)} <br />
     * UPD_DATETIME
     * @return The value of the column 'UPD_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getUpdDatetime() {
        return _updDatetime;
    }

    /**
     * [set] UPD_DATETIME: {NotNull, DATETIME(19)} <br />
     * UPD_DATETIME
     * @param updDatetime The value of the column 'UPD_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdDatetime(java.sql.Timestamp updDatetime) {
        __modifiedProperties.addPropertyName("updDatetime");
        _updDatetime = updDatetime;
    }

    /**
     * [get] INS_TRACE: {NotNull, VARCHAR(256)} <br />
     * Insertトレース
     * @return The value of the column 'INS_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getInsTrace() {
        return _insTrace;
    }

    /**
     * [set] INS_TRACE: {NotNull, VARCHAR(256)} <br />
     * Insertトレース
     * @param insTrace The value of the column 'INS_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setInsTrace(String insTrace) {
        __modifiedProperties.addPropertyName("insTrace");
        _insTrace = insTrace;
    }

    /**
     * [get] UPD_TRACE: {NotNull, VARCHAR(256)} <br />
     * UPD トレース
     * @return The value of the column 'UPD_TRACE'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdTrace() {
        return _updTrace;
    }

    /**
     * [set] UPD_TRACE: {NotNull, VARCHAR(256)} <br />
     * UPD トレース
     * @param updTrace The value of the column 'UPD_TRACE'. (basically NotNull if update: for the constraint)
     */
    public void setUpdTrace(String updTrace) {
        __modifiedProperties.addPropertyName("updTrace");
        _updTrace = updTrace;
    }

    /**
     * [get] DEL_FLG: {NotNull, CHAR(1), default=[N]} <br />
     * DEL_FLG : 削除フラグ Y=削除　N=削除していない
     * @return The value of the column 'DEL_FLG'. (basically NotNull if selected: for the constraint)
     */
    public String getDelFlg() {
        return _delFlg;
    }

    /**
     * [set] DEL_FLG: {NotNull, CHAR(1), default=[N]} <br />
     * DEL_FLG : 削除フラグ Y=削除　N=削除していない
     * @param delFlg The value of the column 'DEL_FLG'. (basically NotNull if update: for the constraint)
     */
    public void setDelFlg(String delFlg) {
        __modifiedProperties.addPropertyName("delFlg");
        _delFlg = delFlg;
    }
}
