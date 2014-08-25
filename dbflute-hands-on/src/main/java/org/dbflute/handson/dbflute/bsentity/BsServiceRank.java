package org.dbflute.handson.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;
import org.dbflute.handson.dbflute.allcommon.DBMetaInstanceHandler;
import org.dbflute.handson.dbflute.allcommon.CDef;
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
    /** SERVICE_RANK_CODE: {PK, NotNull, CHAR(3), classification=ServiceRank} */
    protected String _serviceRankCode;

    /** SERVICE_RANK_NAME: {NotNull, VARCHAR(50)} */
    protected String _serviceRankName;

    /** SERVICE_POINT_INCIDENCE: {NotNull, DECIMAL(5, 3)} */
    protected java.math.BigDecimal _servicePointIncidence;

    /** NEW_ACCEPTABLE_FLG: {NotNull, INT(10), classification=Flg} */
    protected Integer _newAcceptableFlg;

    /** DESCRIPTION: {NotNull, VARCHAR(200)} */
    protected String _description;

    /** DISPLAY_ORDER: {UQ, NotNull, INT(10)} */
    protected Integer _displayOrder;

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

    /**
     * To be unique by the unique column. <br />
     * You can update the entity by the key when entity update (NOT batch update).
     * @param displayOrder : UQ, NotNull, INT(10). (NotNull)
     */
    public void uniqueBy(Integer displayOrder) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("displayOrder");
        setDisplayOrder(displayOrder);
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
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of serviceRankCode as the classification of ServiceRank. <br />
     * SERVICE_RANK_CODE: {PK, NotNull, CHAR(3), classification=ServiceRank} <br />
     * 会員が受けられるサービスのランクを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.ServiceRank getServiceRankCodeAsServiceRank() {
        return CDef.ServiceRank.codeOf(getServiceRankCode());
    }

    /**
     * Set the value of serviceRankCode as the classification of ServiceRank. <br />
     * SERVICE_RANK_CODE: {PK, NotNull, CHAR(3), classification=ServiceRank} <br />
     * 会員が受けられるサービスのランクを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setServiceRankCodeAsServiceRank(CDef.ServiceRank cdef) {
        setServiceRankCode(cdef != null ? cdef.code() : null);
    }

    /**
     * Get the value of newAcceptableFlg as the classification of Flg. <br />
     * NEW_ACCEPTABLE_FLG: {NotNull, INT(10), classification=Flg} <br />
     * フラグを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.Flg getNewAcceptableFlgAsFlg() {
        return CDef.Flg.codeOf(getNewAcceptableFlg());
    }

    /**
     * Set the value of newAcceptableFlg as the classification of Flg. <br />
     * NEW_ACCEPTABLE_FLG: {NotNull, INT(10), classification=Flg} <br />
     * フラグを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setNewAcceptableFlgAsFlg(CDef.Flg cdef) {
        setNewAcceptableFlg(cdef != null ? FunCustodial.toNumber(cdef.code(), Integer.class) : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of serviceRankCode as Platinum (PLT). <br />
     * PLATINUM: platinum rank
     */
    public void setServiceRankCode_Platinum() {
        setServiceRankCodeAsServiceRank(CDef.ServiceRank.Platinum);
    }

    /**
     * Set the value of serviceRankCode as Gold (GLD). <br />
     * GOLD: gold rank
     */
    public void setServiceRankCode_Gold() {
        setServiceRankCodeAsServiceRank(CDef.ServiceRank.Gold);
    }

    /**
     * Set the value of serviceRankCode as Silver (SIL). <br />
     * SILVER: silver rank
     */
    public void setServiceRankCode_Silver() {
        setServiceRankCodeAsServiceRank(CDef.ServiceRank.Silver);
    }

    /**
     * Set the value of serviceRankCode as Bronze (BRZ). <br />
     * BRONZE: bronze rank
     */
    public void setServiceRankCode_Bronze() {
        setServiceRankCodeAsServiceRank(CDef.ServiceRank.Bronze);
    }

    /**
     * Set the value of serviceRankCode as Plastic (PLS). <br />
     * PLASTIC: plastic rank
     */
    public void setServiceRankCode_Plastic() {
        setServiceRankCodeAsServiceRank(CDef.ServiceRank.Plastic);
    }

    /**
     * Set the value of newAcceptableFlg as True (1). <br />
     * はい: 有効を示す
     */
    public void setNewAcceptableFlg_True() {
        setNewAcceptableFlgAsFlg(CDef.Flg.True);
    }

    /**
     * Set the value of newAcceptableFlg as False (0). <br />
     * いいえ: 無効を示す
     */
    public void setNewAcceptableFlg_False() {
        setNewAcceptableFlgAsFlg(CDef.Flg.False);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of serviceRankCode Platinum? <br />
     * PLATINUM: platinum rank
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isServiceRankCodePlatinum() {
        CDef.ServiceRank cdef = getServiceRankCodeAsServiceRank();
        return cdef != null ? cdef.equals(CDef.ServiceRank.Platinum) : false;
    }

    /**
     * Is the value of serviceRankCode Gold? <br />
     * GOLD: gold rank
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isServiceRankCodeGold() {
        CDef.ServiceRank cdef = getServiceRankCodeAsServiceRank();
        return cdef != null ? cdef.equals(CDef.ServiceRank.Gold) : false;
    }

    /**
     * Is the value of serviceRankCode Silver? <br />
     * SILVER: silver rank
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isServiceRankCodeSilver() {
        CDef.ServiceRank cdef = getServiceRankCodeAsServiceRank();
        return cdef != null ? cdef.equals(CDef.ServiceRank.Silver) : false;
    }

    /**
     * Is the value of serviceRankCode Bronze? <br />
     * BRONZE: bronze rank
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isServiceRankCodeBronze() {
        CDef.ServiceRank cdef = getServiceRankCodeAsServiceRank();
        return cdef != null ? cdef.equals(CDef.ServiceRank.Bronze) : false;
    }

    /**
     * Is the value of serviceRankCode Plastic? <br />
     * PLASTIC: plastic rank
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isServiceRankCodePlastic() {
        CDef.ServiceRank cdef = getServiceRankCodeAsServiceRank();
        return cdef != null ? cdef.equals(CDef.ServiceRank.Plastic) : false;
    }

    /**
     * Is the value of newAcceptableFlg True? <br />
     * はい: 有効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isNewAcceptableFlgTrue() {
        CDef.Flg cdef = getNewAcceptableFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.True) : false;
    }

    /**
     * Is the value of newAcceptableFlg False? <br />
     * いいえ: 無効を示す
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isNewAcceptableFlgFalse() {
        CDef.Flg cdef = getNewAcceptableFlgAsFlg();
        return cdef != null ? cdef.equals(CDef.Flg.False) : false;
    }

    // ===================================================================================
    //                                                           Classification Name/Alias
    //                                                           =========================
    /**
     * Get the value of the column 'newAcceptableFlg' as classification name.
     * @return The string of classification name. (NullAllowed: when the column value is null)
     */
    public String getNewAcceptableFlgName() {
        CDef.Flg cdef = getNewAcceptableFlgAsFlg();
        return cdef != null ? cdef.name() : null;
    }

    /**
     * Get the value of the column 'newAcceptableFlg' as classification alias.
     * @return The string of classification alias. (NullAllowed: when the column value is null)
     */
    public String getNewAcceptableFlgAlias() {
        CDef.Flg cdef = getNewAcceptableFlgAsFlg();
        return cdef != null ? cdef.alias() : null;
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
     * [get] member_service by SERVICE_RANK_CODE, named 'memberServiceList'.
     * @return The entity list of referrer property 'memberServiceList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberService> getMemberServiceList() {
        if (_memberServiceList == null) { _memberServiceList = newReferrerList(); }
        return _memberServiceList;
    }

    /**
     * [set] member_service by SERVICE_RANK_CODE, named 'memberServiceList'.
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
        hs = xCH(hs, getServiceRankCode());
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
        if (_memberServiceList != null) { for (Entity et : _memberServiceList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "memberServiceList")); } } }
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
        sb.append(dm).append(getServiceRankCode());
        sb.append(dm).append(getServiceRankName());
        sb.append(dm).append(getServicePointIncidence());
        sb.append(dm).append(getNewAcceptableFlg());
        sb.append(dm).append(getDescription());
        sb.append(dm).append(getDisplayOrder());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_memberServiceList != null && !_memberServiceList.isEmpty())
        { sb.append(cm).append("memberServiceList"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
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
     * [get] SERVICE_RANK_CODE: {PK, NotNull, CHAR(3), classification=ServiceRank} <br />
     * サービスランクコード: サービスランクを識別するコード。
     * @return The value of the column 'SERVICE_RANK_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getServiceRankCode() {
        return _serviceRankCode;
    }

    /**
     * [set] SERVICE_RANK_CODE: {PK, NotNull, CHAR(3), classification=ServiceRank} <br />
     * サービスランクコード: サービスランクを識別するコード。
     * @param serviceRankCode The value of the column 'SERVICE_RANK_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setServiceRankCode(String serviceRankCode) {
        __modifiedProperties.addPropertyName("serviceRankCode");
        _serviceRankCode = serviceRankCode;
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
        _serviceRankName = serviceRankName;
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
        _servicePointIncidence = servicePointIncidence;
    }

    /**
     * [get] NEW_ACCEPTABLE_FLG: {NotNull, INT(10), classification=Flg} <br />
     * 新規受け入れ可能フラグ: このランクへの新規受け入れができるかどうか。
     * @return The value of the column 'NEW_ACCEPTABLE_FLG'. (basically NotNull if selected: for the constraint)
     */
    public Integer getNewAcceptableFlg() {
        return _newAcceptableFlg;
    }

    /**
     * [set] NEW_ACCEPTABLE_FLG: {NotNull, INT(10), classification=Flg} <br />
     * 新規受け入れ可能フラグ: このランクへの新規受け入れができるかどうか。
     * @param newAcceptableFlg The value of the column 'NEW_ACCEPTABLE_FLG'. (basically NotNull if update: for the constraint)
     */
    public void setNewAcceptableFlg(Integer newAcceptableFlg) {
        checkImplicitSet("NEW_ACCEPTABLE_FLG", CDef.DefMeta.Flg, newAcceptableFlg);
        __modifiedProperties.addPropertyName("newAcceptableFlg");
        _newAcceptableFlg = newAcceptableFlg;
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
        _description = description;
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
        _displayOrder = displayOrder;
    }

    protected void checkImplicitSet(String columnDbName, CDef.DefMeta meta, Object value) {
        FunCustodial.checkImplicitSet(this, columnDbName, meta, value);
    }
}
