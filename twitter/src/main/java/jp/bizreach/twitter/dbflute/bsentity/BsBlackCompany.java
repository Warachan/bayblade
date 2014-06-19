package jp.bizreach.twitter.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.Entity;
import jp.bizreach.twitter.dbflute.allcommon.DBMetaInstanceHandler;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The entity of black_company as TABLE. <br />
 * ブラック企業(黒い企業) : 取引先のブラックな企業。<br />
 * ブラックブランドとしてブラックさに磨きをかけるよう提案する。
 * <pre>
 * [primary-key]
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
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Long blackCompanyId = entity.getBlackCompanyId();
 * String blackCompanyName = entity.getBlackCompanyName();
 * String agentCompanyName = entity.getAgentCompanyName();
 * String zipCode = entity.getZipCode();
 * String address1 = entity.getAddress1();
 * String address2 = entity.getAddress2();
 * String blackCompanyStatusCd = entity.getBlackCompanyStatusCd();
 * java.sql.Timestamp insDatetime = entity.getInsDatetime();
 * java.sql.Timestamp updDatetime = entity.getUpdDatetime();
 * String insTrace = entity.getInsTrace();
 * String updTrace = entity.getUpdTrace();
 * Long versionNo = entity.getVersionNo();
 * entity.setBlackCompanyId(blackCompanyId);
 * entity.setBlackCompanyName(blackCompanyName);
 * entity.setAgentCompanyName(agentCompanyName);
 * entity.setZipCode(zipCode);
 * entity.setAddress1(address1);
 * entity.setAddress2(address2);
 * entity.setBlackCompanyStatusCd(blackCompanyStatusCd);
 * entity.setInsDatetime(insDatetime);
 * entity.setUpdDatetime(updDatetime);
 * entity.setInsTrace(insTrace);
 * entity.setUpdTrace(updTrace);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsBlackCompany implements Entity, Serializable, Cloneable {

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
    /** BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)} */
    protected Long _blackCompanyId;

    /** BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)} */
    protected String _blackCompanyName;

    /** AGENT_COMPANY_NAME: {VARCHAR(128)} */
    protected String _agentCompanyName;

    /** ZIP_CODE: {NotNull, VARCHAR(32)} */
    protected String _zipCode;

    /** ADDRESS1: {NotNull, VARCHAR(1024)} */
    protected String _address1;

    /** ADDRESS2: {VARCHAR(1024)} */
    protected String _address2;

    /** BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status} */
    protected String _blackCompanyStatusCd;

    /** INS_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _insDatetime;

    /** UPD_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _updDatetime;

    /** INS_TRACE: {NotNull, VARCHAR(256)} */
    protected String _insTrace;

    /** UPD_TRACE: {NotNull, VARCHAR(256)} */
    protected String _updTrace;

    /** VERSION_NO: {NotNull, BIGINT(19)} */
    protected Long _versionNo;

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
        return "black_company";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "blackCompany";
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
        if (getBlackCompanyId() == null) { return false; }
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
    /** cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'. */
    protected ClsBlackCompanyStatus _clsBlackCompanyStatus;

    /**
     * cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'.
     * @return The entity of foreign property 'clsBlackCompanyStatus'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public ClsBlackCompanyStatus getClsBlackCompanyStatus() {
        return _clsBlackCompanyStatus;
    }

    /**
     * cls_black_company_status by my BLACK_COMPANY_STATUS_CD, named 'clsBlackCompanyStatus'.
     * @param clsBlackCompanyStatus The entity of foreign property 'clsBlackCompanyStatus'. (NullAllowed)
     */
    public void setClsBlackCompanyStatus(ClsBlackCompanyStatus clsBlackCompanyStatus) {
        _clsBlackCompanyStatus = clsBlackCompanyStatus;
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
        if (obj == null || !(obj instanceof BsBlackCompany)) { return false; }
        BsBlackCompany other = (BsBlackCompany)obj;
        if (!xSV(getBlackCompanyId(), other.getBlackCompanyId())) { return false; }
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
        hs = xCH(hs, getBlackCompanyId());
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
        if (_clsBlackCompanyStatus != null)
        { sb.append(li).append(xbRDS(_clsBlackCompanyStatus, "clsBlackCompanyStatus")); }
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
        sb.append(dm).append(getBlackCompanyId());
        sb.append(dm).append(getBlackCompanyName());
        sb.append(dm).append(getAgentCompanyName());
        sb.append(dm).append(getZipCode());
        sb.append(dm).append(getAddress1());
        sb.append(dm).append(getAddress2());
        sb.append(dm).append(getBlackCompanyStatusCd());
        sb.append(dm).append(getInsDatetime());
        sb.append(dm).append(getUpdDatetime());
        sb.append(dm).append(getInsTrace());
        sb.append(dm).append(getUpdTrace());
        sb.append(dm).append(getVersionNo());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_clsBlackCompanyStatus != null) { sb.append(cm).append("clsBlackCompanyStatus"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public BlackCompany clone() {
        try {
            return (BlackCompany)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * ブラック企業ID
     * @return The value of the column 'BLACK_COMPANY_ID'. (basically NotNull if selected: for the constraint)
     */
    public Long getBlackCompanyId() {
        return _blackCompanyId;
    }

    /**
     * [set] BLACK_COMPANY_ID: {PK, ID, NotNull, BIGINT(19)} <br />
     * ブラック企業ID
     * @param blackCompanyId The value of the column 'BLACK_COMPANY_ID'. (basically NotNull if update: for the constraint)
     */
    public void setBlackCompanyId(Long blackCompanyId) {
        __modifiedProperties.addPropertyName("blackCompanyId");
        this._blackCompanyId = blackCompanyId;
    }

    /**
     * [get] BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)} <br />
     * ブラック企業名
     * @return The value of the column 'BLACK_COMPANY_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getBlackCompanyName() {
        return _blackCompanyName;
    }

    /**
     * [set] BLACK_COMPANY_NAME: {NotNull, VARCHAR(128)} <br />
     * ブラック企業名
     * @param blackCompanyName The value of the column 'BLACK_COMPANY_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setBlackCompanyName(String blackCompanyName) {
        __modifiedProperties.addPropertyName("blackCompanyName");
        this._blackCompanyName = blackCompanyName;
    }

    /**
     * [get] AGENT_COMPANY_NAME: {VARCHAR(128)} <br />
     * 営業代行会社名 : 契約企業名と違う名称で　営業代行会社として利用する場合には設定する。<br />
     * 未設定の場合は契約企業名を営業代行会社名として使用する。
     * @return The value of the column 'AGENT_COMPANY_NAME'. (NullAllowed even if selected: for no constraint)
     */
    public String getAgentCompanyName() {
        return _agentCompanyName;
    }

    /**
     * [set] AGENT_COMPANY_NAME: {VARCHAR(128)} <br />
     * 営業代行会社名 : 契約企業名と違う名称で　営業代行会社として利用する場合には設定する。<br />
     * 未設定の場合は契約企業名を営業代行会社名として使用する。
     * @param agentCompanyName The value of the column 'AGENT_COMPANY_NAME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setAgentCompanyName(String agentCompanyName) {
        __modifiedProperties.addPropertyName("agentCompanyName");
        this._agentCompanyName = agentCompanyName;
    }

    /**
     * [get] ZIP_CODE: {NotNull, VARCHAR(32)} <br />
     * 郵便番号 : 基本的に半角数字＋ハイフン。日本語文字列が入ってしまっている場合がある。
     * @return The value of the column 'ZIP_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getZipCode() {
        return _zipCode;
    }

    /**
     * [set] ZIP_CODE: {NotNull, VARCHAR(32)} <br />
     * 郵便番号 : 基本的に半角数字＋ハイフン。日本語文字列が入ってしまっている場合がある。
     * @param zipCode The value of the column 'ZIP_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setZipCode(String zipCode) {
        __modifiedProperties.addPropertyName("zipCode");
        this._zipCode = zipCode;
    }

    /**
     * [get] ADDRESS1: {NotNull, VARCHAR(1024)} <br />
     * 住所1
     * @return The value of the column 'ADDRESS1'. (basically NotNull if selected: for the constraint)
     */
    public String getAddress1() {
        return _address1;
    }

    /**
     * [set] ADDRESS1: {NotNull, VARCHAR(1024)} <br />
     * 住所1
     * @param address1 The value of the column 'ADDRESS1'. (basically NotNull if update: for the constraint)
     */
    public void setAddress1(String address1) {
        __modifiedProperties.addPropertyName("address1");
        this._address1 = address1;
    }

    /**
     * [get] ADDRESS2: {VARCHAR(1024)} <br />
     * 住所2
     * @return The value of the column 'ADDRESS2'. (NullAllowed even if selected: for no constraint)
     */
    public String getAddress2() {
        return _address2;
    }

    /**
     * [set] ADDRESS2: {VARCHAR(1024)} <br />
     * 住所2
     * @param address2 The value of the column 'ADDRESS2'. (NullAllowed: null update allowed for no constraint)
     */
    public void setAddress2(String address2) {
        __modifiedProperties.addPropertyName("address2");
        this._address2 = address2;
    }

    /**
     * [get] BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status} <br />
     * ブラック企業ステータスコード
     * @return The value of the column 'BLACK_COMPANY_STATUS_CD'. (basically NotNull if selected: for the constraint)
     */
    public String getBlackCompanyStatusCd() {
        return _blackCompanyStatusCd;
    }

    /**
     * [set] BLACK_COMPANY_STATUS_CD: {IX, NotNull, CHAR(3), FK to cls_black_company_status} <br />
     * ブラック企業ステータスコード
     * @param blackCompanyStatusCd The value of the column 'BLACK_COMPANY_STATUS_CD'. (basically NotNull if update: for the constraint)
     */
    public void setBlackCompanyStatusCd(String blackCompanyStatusCd) {
        __modifiedProperties.addPropertyName("blackCompanyStatusCd");
        this._blackCompanyStatusCd = blackCompanyStatusCd;
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
        this._insDatetime = insDatetime;
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
        this._updDatetime = updDatetime;
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
        this._insTrace = insTrace;
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
        this._updTrace = updTrace;
    }

    /**
     * [get] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * バージョン番号
     * @return The value of the column 'VERSION_NO'. (basically NotNull if selected: for the constraint)
     */
    public Long getVersionNo() {
        return _versionNo;
    }

    /**
     * [set] VERSION_NO: {NotNull, BIGINT(19)} <br />
     * バージョン番号
     * @param versionNo The value of the column 'VERSION_NO'. (basically NotNull if update: for the constraint)
     */
    public void setVersionNo(Long versionNo) {
        __modifiedProperties.addPropertyName("versionNo");
        this._versionNo = versionNo;
    }
}
