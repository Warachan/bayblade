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
 * The entity of cls_black_company_status as TABLE. <br />
 * [区分値]ブラック企業ステータス
 * <pre>
 * [primary-key]
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
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String blackCompanyStatusCd = entity.getBlackCompanyStatusCd();
 * String codeName = entity.getCodeName();
 * String codeAlias = entity.getCodeAlias();
 * Integer codeDisplayNo = entity.getCodeDisplayNo();
 * String codeComment = entity.getCodeComment();
 * String codeAliasEn = entity.getCodeAliasEn();
 * entity.setBlackCompanyStatusCd(blackCompanyStatusCd);
 * entity.setCodeName(codeName);
 * entity.setCodeAlias(codeAlias);
 * entity.setCodeDisplayNo(codeDisplayNo);
 * entity.setCodeComment(codeComment);
 * entity.setCodeAliasEn(codeAliasEn);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsClsBlackCompanyStatus implements Entity, Serializable, Cloneable {

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
    /** BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)} */
    protected String _blackCompanyStatusCd;

    /** CODE_NAME: {NotNull, VARCHAR(30)} */
    protected String _codeName;

    /** CODE_ALIAS: {NotNull, VARCHAR(50)} */
    protected String _codeAlias;

    /** CODE_DISPLAY_NO: {NotNull, INT(10)} */
    protected Integer _codeDisplayNo;

    /** CODE_COMMENT: {NotNull, VARCHAR(256)} */
    protected String _codeComment;

    /** CODE_ALIAS_EN: {NotNull, VARCHAR(50)} */
    protected String _codeAliasEn;

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
        return "cls_black_company_status";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "clsBlackCompanyStatus";
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
        if (getBlackCompanyStatusCd() == null) { return false; }
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
    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyList'. */
    protected List<BlackCompany> _blackCompanyList;

    /**
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyList'.
     * @return The entity list of referrer property 'blackCompanyList'. (NotNull: even if no loading, returns empty list)
     */
    public List<BlackCompany> getBlackCompanyList() {
        if (_blackCompanyList == null) { _blackCompanyList = newReferrerList(); }
        return _blackCompanyList;
    }

    /**
     * black_company by BLACK_COMPANY_STATUS_CD, named 'blackCompanyList'.
     * @param blackCompanyList The entity list of referrer property 'blackCompanyList'. (NullAllowed)
     */
    public void setBlackCompanyList(List<BlackCompany> blackCompanyList) {
        _blackCompanyList = blackCompanyList;
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
        if (obj == null || !(obj instanceof BsClsBlackCompanyStatus)) { return false; }
        BsClsBlackCompanyStatus other = (BsClsBlackCompanyStatus)obj;
        if (!xSV(getBlackCompanyStatusCd(), other.getBlackCompanyStatusCd())) { return false; }
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
        hs = xCH(hs, getBlackCompanyStatusCd());
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
        if (_blackCompanyList != null) { for (Entity et : _blackCompanyList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "blackCompanyList")); } } }
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
        sb.append(dm).append(getBlackCompanyStatusCd());
        sb.append(dm).append(getCodeName());
        sb.append(dm).append(getCodeAlias());
        sb.append(dm).append(getCodeDisplayNo());
        sb.append(dm).append(getCodeComment());
        sb.append(dm).append(getCodeAliasEn());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_blackCompanyList != null && !_blackCompanyList.isEmpty())
        { sb.append(cm).append("blackCompanyList"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public ClsBlackCompanyStatus clone() {
        try {
            return (ClsBlackCompanyStatus)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)} <br />
     * ブラック企業ステータスコード
     * @return The value of the column 'BLACK_COMPANY_STATUS_CD'. (basically NotNull if selected: for the constraint)
     */
    public String getBlackCompanyStatusCd() {
        return _blackCompanyStatusCd;
    }

    /**
     * [set] BLACK_COMPANY_STATUS_CD: {PK, NotNull, CHAR(3)} <br />
     * ブラック企業ステータスコード
     * @param blackCompanyStatusCd The value of the column 'BLACK_COMPANY_STATUS_CD'. (basically NotNull if update: for the constraint)
     */
    public void setBlackCompanyStatusCd(String blackCompanyStatusCd) {
        __modifiedProperties.addPropertyName("blackCompanyStatusCd");
        this._blackCompanyStatusCd = blackCompanyStatusCd;
    }

    /**
     * [get] CODE_NAME: {NotNull, VARCHAR(30)} <br />
     * 区分値識別名
     * @return The value of the column 'CODE_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getCodeName() {
        return _codeName;
    }

    /**
     * [set] CODE_NAME: {NotNull, VARCHAR(30)} <br />
     * 区分値識別名
     * @param codeName The value of the column 'CODE_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setCodeName(String codeName) {
        __modifiedProperties.addPropertyName("codeName");
        this._codeName = codeName;
    }

    /**
     * [get] CODE_ALIAS: {NotNull, VARCHAR(50)} <br />
     * 区分値表示名
     * @return The value of the column 'CODE_ALIAS'. (basically NotNull if selected: for the constraint)
     */
    public String getCodeAlias() {
        return _codeAlias;
    }

    /**
     * [set] CODE_ALIAS: {NotNull, VARCHAR(50)} <br />
     * 区分値表示名
     * @param codeAlias The value of the column 'CODE_ALIAS'. (basically NotNull if update: for the constraint)
     */
    public void setCodeAlias(String codeAlias) {
        __modifiedProperties.addPropertyName("codeAlias");
        this._codeAlias = codeAlias;
    }

    /**
     * [get] CODE_DISPLAY_NO: {NotNull, INT(10)} <br />
     * 区分値表示順
     * @return The value of the column 'CODE_DISPLAY_NO'. (basically NotNull if selected: for the constraint)
     */
    public Integer getCodeDisplayNo() {
        return _codeDisplayNo;
    }

    /**
     * [set] CODE_DISPLAY_NO: {NotNull, INT(10)} <br />
     * 区分値表示順
     * @param codeDisplayNo The value of the column 'CODE_DISPLAY_NO'. (basically NotNull if update: for the constraint)
     */
    public void setCodeDisplayNo(Integer codeDisplayNo) {
        __modifiedProperties.addPropertyName("codeDisplayNo");
        this._codeDisplayNo = codeDisplayNo;
    }

    /**
     * [get] CODE_COMMENT: {NotNull, VARCHAR(256)} <br />
     * 区分値コメント
     * @return The value of the column 'CODE_COMMENT'. (basically NotNull if selected: for the constraint)
     */
    public String getCodeComment() {
        return _codeComment;
    }

    /**
     * [set] CODE_COMMENT: {NotNull, VARCHAR(256)} <br />
     * 区分値コメント
     * @param codeComment The value of the column 'CODE_COMMENT'. (basically NotNull if update: for the constraint)
     */
    public void setCodeComment(String codeComment) {
        __modifiedProperties.addPropertyName("codeComment");
        this._codeComment = codeComment;
    }

    /**
     * [get] CODE_ALIAS_EN: {NotNull, VARCHAR(50)} <br />
     * 区分値表示名（英語）
     * @return The value of the column 'CODE_ALIAS_EN'. (basically NotNull if selected: for the constraint)
     */
    public String getCodeAliasEn() {
        return _codeAliasEn;
    }

    /**
     * [set] CODE_ALIAS_EN: {NotNull, VARCHAR(50)} <br />
     * 区分値表示名（英語）
     * @param codeAliasEn The value of the column 'CODE_ALIAS_EN'. (basically NotNull if update: for the constraint)
     */
    public void setCodeAliasEn(String codeAliasEn) {
        __modifiedProperties.addPropertyName("codeAliasEn");
        this._codeAliasEn = codeAliasEn;
    }
}
