package org.dbflute.handson.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.Entity;
import org.dbflute.handson.dbflute.allcommon.DBMetaInstanceHandler;
import org.dbflute.handson.dbflute.exentity.*;

/**
 * The entity of service_rank as TABLE. <br />
 * サービスランク: 会員のサービスレベルを表現するランク。<br />
 * （ゴールドとかプラチナとか）
 * <pre>
 * [primary-key]
 *     SERVICE_RANK_CODE
 * 
 * [column]
 *     SERVICE_RANK_CODE, SERVICE_RANK_NAME, SERVICE_POINT_INCIDENCE, NEW_ACCEPTABLE_FLG, DESCRIPTION, DISPLAY_ORDER
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
 *     member_service
 * 
 * [foreign property]
 *     
 * 
 * [referrer property]
 *     memberServiceList
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String serviceRankCode = entity.getServiceRankCode();
 * String serviceRankName = entity.getServiceRankName();
 * java.math.BigDecimal servicePointIncidence = entity.getServicePointIncidence();
 * Integer newAcceptableFlg = entity.getNewAcceptableFlg();
 * String description = entity.getDescription();
 * Integer displayOrder = entity.getDisplayOrder();
 * entity.setServiceRankCode(serviceRankCode);
 * entity.setServiceRankName(serviceRankName);
 * entity.setServicePointIncidence(servicePointIncidence);
 * entity.setNewAcceptableFlg(newAcceptableFlg);
 * entity.setDescription(description);
 * entity.setDisplayOrder(displayOrder);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsServiceRank implements Entity, Serializable, Cloneable {

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
    /** SERVICE_RANK_CODE: {PK, NotNull, CHAR(3)} */
    protected String _serviceRankCode;

    /** SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} */
    protected String _serviceRankName;

    /** SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} */
    protected java.math.BigDecimal _servicePointIncidence;

    /** NEW_ACCEPTABLE_FLG: {NotNull, INT(10)} */
    protected Integer _newAcceptableFlg;

    /** DESCRIPTION: {NotNull, VARCHAR(200)} */
    protected String _description;

    /** DISPLAY_ORDER: {UQ, NotNull, INT(10)} */
    protected Integer _displayOrder;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
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
        return "service_rank";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "serviceRank";
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
        if (getServiceRankCode() == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** member_service by SERVICE_RANK_CODE, named 'memberServiceList'. */
    protected List<MemberService> _memberServiceList;

    /**
     * member_service by SERVICE_RANK_CODE, named 'memberServiceList'.
     * @return The entity list of referrer property 'memberServiceList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberService> getMemberServiceList() {
        if (_memberServiceList == null) { _memberServiceList = newReferrerList(); }
        return _memberServiceList;
    }

    /**
     * member_service by SERVICE_RANK_CODE, named 'memberServiceList'.
     * @param memberServiceList The entity list of referrer property 'memberServiceList'. (NullAllowed)
     */
    public void setMemberServiceList(List<MemberService> memberServiceList) {
        _memberServiceList = memberServiceList;
    }

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
        if (obj == null || !(obj instanceof BsServiceRank)) { return false; }
        BsServiceRank other = (BsServiceRank)obj;
        if (!xSV(getServiceRankCode(), other.getServiceRankCode())) { return false; }
        return true;
    }
    protected boolean xSV(Object value1, Object value2) {
        return FunCustodial.isSameValue(value1, value2);
    }

    /**
     * Calculate the hash-code from primary-keys or columns.
     * @return The hash-code from primary-key or columns.
     */
    public int hashCode() {
        int result = 17;
        result = xCH(result, getTableDbName());
        result = xCH(result, getServiceRankCode());
        return result;
    }
    protected int xCH(int result, Object value) {
        return FunCustodial.calculateHashcode(result, value);
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
        String l = "\n  ";
        if (_memberServiceList != null) { for (Entity e : _memberServiceList)
        { if (e != null) { sb.append(l).append(xbRDS(e, "memberServiceList")); } } }
        return sb.toString();
    }
    protected String xbRDS(Entity e, String name) { // buildRelationDisplayString()
        return e.buildDisplayString(name, true, true);
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
        String delimiter = ", ";
        sb.append(delimiter).append(getServiceRankCode());
        sb.append(delimiter).append(getServiceRankName());
        sb.append(delimiter).append(getServicePointIncidence());
        sb.append(delimiter).append(getNewAcceptableFlg());
        sb.append(delimiter).append(getDescription());
        sb.append(delimiter).append(getDisplayOrder());
        if (sb.length() > delimiter.length()) {
            sb.delete(0, delimiter.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String c = ",";
        if (_memberServiceList != null && !_memberServiceList.isEmpty())
        { sb.append(c).append("memberServiceList"); }
        if (sb.length() > c.length()) {
            sb.delete(0, c.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public ServiceRank clone() {
        try {
            return (ServiceRank)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] SERVICE_RANK_CODE: {PK, NotNull, CHAR(3)} <br />
     * サービスランクコード: サービスランクを識別するコード。
     * @return The value of the column 'SERVICE_RANK_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getServiceRankCode() {
        return _serviceRankCode;
    }

    /**
     * [set] SERVICE_RANK_CODE: {PK, NotNull, CHAR(3)} <br />
     * サービスランクコード: サービスランクを識別するコード。
     * @param serviceRankCode The value of the column 'SERVICE_RANK_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setServiceRankCode(String serviceRankCode) {
        __modifiedProperties.addPropertyName("serviceRankCode");
        this._serviceRankCode = serviceRankCode;
    }

    /**
     * [get] SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} <br />
     * サービスランク名称: サービスランクの名称。<br />
     * （ゴールドとかプラチナとか基本的には威厳のある名前）
     * @return The value of the column 'SERVICE_RANK_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getServiceRankName() {
        return _serviceRankName;
    }

    /**
     * [set] SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} <br />
     * サービスランク名称: サービスランクの名称。<br />
     * （ゴールドとかプラチナとか基本的には威厳のある名前）
     * @param serviceRankName The value of the column 'SERVICE_RANK_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setServiceRankName(String serviceRankName) {
        __modifiedProperties.addPropertyName("serviceRankName");
        this._serviceRankName = serviceRankName;
    }

    /**
     * [get] SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} <br />
     * サービスポイント発生率: 購入ごとのサービスポイントの発生率。<br />
     * 購入価格にこの値をかけた数が発生ポイント。
     * @return The value of the column 'SERVICE_POINT_INCIDENCE'. (basically NotNull if selected: for the constraint)
     */
    public java.math.BigDecimal getServicePointIncidence() {
        return _servicePointIncidence;
    }

    /**
     * [set] SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} <br />
     * サービスポイント発生率: 購入ごとのサービスポイントの発生率。<br />
     * 購入価格にこの値をかけた数が発生ポイント。
     * @param servicePointIncidence The value of the column 'SERVICE_POINT_INCIDENCE'. (basically NotNull if update: for the constraint)
     */
    public void setServicePointIncidence(java.math.BigDecimal servicePointIncidence) {
        __modifiedProperties.addPropertyName("servicePointIncidence");
        this._servicePointIncidence = servicePointIncidence;
    }

    /**
     * [get] NEW_ACCEPTABLE_FLG: {NotNull, INT(10)} <br />
     * 新規受け入れ可能フラグ: このランクへの新規受け入れができるかどうか。
     * @return The value of the column 'NEW_ACCEPTABLE_FLG'. (basically NotNull if selected: for the constraint)
     */
    public Integer getNewAcceptableFlg() {
        return _newAcceptableFlg;
    }

    /**
     * [set] NEW_ACCEPTABLE_FLG: {NotNull, INT(10)} <br />
     * 新規受け入れ可能フラグ: このランクへの新規受け入れができるかどうか。
     * @param newAcceptableFlg The value of the column 'NEW_ACCEPTABLE_FLG'. (basically NotNull if update: for the constraint)
     */
    public void setNewAcceptableFlg(Integer newAcceptableFlg) {
        __modifiedProperties.addPropertyName("newAcceptableFlg");
        this._newAcceptableFlg = newAcceptableFlg;
    }

    /**
     * [get] DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * @return The value of the column 'DESCRIPTION'. (basically NotNull if selected: for the constraint)
     */
    public String getDescription() {
        return _description;
    }

    /**
     * [set] DESCRIPTION: {NotNull, VARCHAR(200)} <br />
     * @param description The value of the column 'DESCRIPTION'. (basically NotNull if update: for the constraint)
     */
    public void setDescription(String description) {
        __modifiedProperties.addPropertyName("description");
        this._description = description;
    }

    /**
     * [get] DISPLAY_ORDER: {UQ, NotNull, INT(10)} <br />
     * @return The value of the column 'DISPLAY_ORDER'. (basically NotNull if selected: for the constraint)
     */
    public Integer getDisplayOrder() {
        return _displayOrder;
    }

    /**
     * [set] DISPLAY_ORDER: {UQ, NotNull, INT(10)} <br />
     * @param displayOrder The value of the column 'DISPLAY_ORDER'. (basically NotNull if update: for the constraint)
     */
    public void setDisplayOrder(Integer displayOrder) {
        __modifiedProperties.addPropertyName("displayOrder");
        this._displayOrder = displayOrder;
    }
}
