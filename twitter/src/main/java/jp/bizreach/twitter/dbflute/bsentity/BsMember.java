package jp.bizreach.twitter.dbflute.bsentity;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;

import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.DBMeta;
import jp.bizreach.twitter.dbflute.allcommon.DBMetaInstanceHandler;
import jp.bizreach.twitter.dbflute.exentity.*;

/**
 * The entity of member as TABLE. <br />
 * 会員
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, EMAIL_ADDRESS, USER_NAME, BIRTHDATE, PROFILE, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ID
 * 
 * [version-no]
 *     
 * 
 * [foreign table]
 *     member_security(AsOne), member_withdraw(AsOne)
 * 
 * [referrer table]
 *     follow, login, tweet, member_security, member_withdraw
 * 
 * [foreign property]
 *     memberSecurityAsOne, memberWithdrawAsOne
 * 
 * [referrer property]
 *     followByYouIdList, followByMemberIdList, loginList, tweetList
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer memberId = entity.getMemberId();
 * String emailAddress = entity.getEmailAddress();
 * String userName = entity.getUserName();
 * java.util.Date birthdate = entity.getBirthdate();
 * String profile = entity.getProfile();
 * java.sql.Timestamp insDatetime = entity.getInsDatetime();
 * java.sql.Timestamp updDatetime = entity.getUpdDatetime();
 * String insTrace = entity.getInsTrace();
 * String updTrace = entity.getUpdTrace();
 * entity.setMemberId(memberId);
 * entity.setEmailAddress(emailAddress);
 * entity.setUserName(userName);
 * entity.setBirthdate(birthdate);
 * entity.setProfile(profile);
 * entity.setInsDatetime(insDatetime);
 * entity.setUpdDatetime(updDatetime);
 * entity.setInsTrace(insTrace);
 * entity.setUpdTrace(updTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMember implements Entity, Serializable, Cloneable {

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
    /** MEMBER_ID: {PK, ID, NotNull, INT(10)} */
    protected Integer _memberId;

    /** EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)} */
    protected String _emailAddress;

    /** USER_NAME: {UQ, NotNull, VARCHAR(50)} */
    protected String _userName;

    /** BIRTHDATE: {DATE(10)} */
    protected java.util.Date _birthdate;

    /** PROFILE: {VARCHAR(200)} */
    protected String _profile;

    /** INS_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _insDatetime;

    /** UPD_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _updDatetime;

    /** INS_TRACE: {NotNull, VARCHAR(256)} */
    protected String _insTrace;

    /** UPD_TRACE: {NotNull, VARCHAR(256)} */
    protected String _updTrace;

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
        return "member";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "member";
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
        if (getMemberId() == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br />
     * You can update the entity by the key when entity update (NOT batch update).
     * @param emailAddress : UQ, NotNull, VARCHAR(100). (NotNull)
     */
    public void uniqueByEmailAddress(String emailAddress) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("emailAddress");
        setEmailAddress(emailAddress);
    }

    /**
     * To be unique by the unique column. <br />
     * You can update the entity by the key when entity update (NOT batch update).
     * @param userName : UQ, NotNull, VARCHAR(50). (NotNull)
     */
    public void uniqueByUserName(String userName) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("userName");
        setUserName(userName);
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
    /** member_security by MEMBER_ID, named 'memberSecurityAsOne'. */
    protected MemberSecurity _memberSecurityAsOne;

    /**
     * [get] member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return the entity of foreign property(referrer-as-one) 'memberSecurityAsOne'. (NullAllowed: when e.g. no data, no setupSelect)
     */
    public MemberSecurity getMemberSecurityAsOne() {
        return _memberSecurityAsOne;
    }

    /**
     * [set] member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @param memberSecurityAsOne The entity of foreign property(referrer-as-one) 'memberSecurityAsOne'. (NullAllowed)
     */
    public void setMemberSecurityAsOne(MemberSecurity memberSecurityAsOne) {
        _memberSecurityAsOne = memberSecurityAsOne;
    }

    /** member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'. */
    protected MemberWithdraw _memberWithdrawAsOne;

    /**
     * [get] member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @return the entity of foreign property(referrer-as-one) 'memberWithdrawAsOne'. (NullAllowed: when e.g. no data, no setupSelect)
     */
    public MemberWithdraw getMemberWithdrawAsOne() {
        return _memberWithdrawAsOne;
    }

    /**
     * [set] member_withdraw by MEMBER_ID, named 'memberWithdrawAsOne'.
     * @param memberWithdrawAsOne The entity of foreign property(referrer-as-one) 'memberWithdrawAsOne'. (NullAllowed)
     */
    public void setMemberWithdrawAsOne(MemberWithdraw memberWithdrawAsOne) {
        _memberWithdrawAsOne = memberWithdrawAsOne;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** follow by YOU_ID, named 'followByYouIdList'. */
    protected List<Follow> _followByYouIdList;

    /**
     * [get] follow by YOU_ID, named 'followByYouIdList'.
     * @return The entity list of referrer property 'followByYouIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Follow> getFollowByYouIdList() {
        if (_followByYouIdList == null) { _followByYouIdList = newReferrerList(); }
        return _followByYouIdList;
    }

    /**
     * [set] follow by YOU_ID, named 'followByYouIdList'.
     * @param followByYouIdList The entity list of referrer property 'followByYouIdList'. (NullAllowed)
     */
    public void setFollowByYouIdList(List<Follow> followByYouIdList) {
        _followByYouIdList = followByYouIdList;
    }

    /** follow by MEMBER_ID, named 'followByMemberIdList'. */
    protected List<Follow> _followByMemberIdList;

    /**
     * [get] follow by MEMBER_ID, named 'followByMemberIdList'.
     * @return The entity list of referrer property 'followByMemberIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Follow> getFollowByMemberIdList() {
        if (_followByMemberIdList == null) { _followByMemberIdList = newReferrerList(); }
        return _followByMemberIdList;
    }

    /**
     * [set] follow by MEMBER_ID, named 'followByMemberIdList'.
     * @param followByMemberIdList The entity list of referrer property 'followByMemberIdList'. (NullAllowed)
     */
    public void setFollowByMemberIdList(List<Follow> followByMemberIdList) {
        _followByMemberIdList = followByMemberIdList;
    }

    /** login by MEMBER_ID, named 'loginList'. */
    protected List<Login> _loginList;

    /**
     * [get] login by MEMBER_ID, named 'loginList'.
     * @return The entity list of referrer property 'loginList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Login> getLoginList() {
        if (_loginList == null) { _loginList = newReferrerList(); }
        return _loginList;
    }

    /**
     * [set] login by MEMBER_ID, named 'loginList'.
     * @param loginList The entity list of referrer property 'loginList'. (NullAllowed)
     */
    public void setLoginList(List<Login> loginList) {
        _loginList = loginList;
    }

    /** tweet by MEMBER_ID, named 'tweetList'. */
    protected List<Tweet> _tweetList;

    /**
     * [get] tweet by MEMBER_ID, named 'tweetList'.
     * @return The entity list of referrer property 'tweetList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Tweet> getTweetList() {
        if (_tweetList == null) { _tweetList = newReferrerList(); }
        return _tweetList;
    }

    /**
     * [set] tweet by MEMBER_ID, named 'tweetList'.
     * @param tweetList The entity list of referrer property 'tweetList'. (NullAllowed)
     */
    public void setTweetList(List<Tweet> tweetList) {
        _tweetList = tweetList;
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
        if (obj == null || !(obj instanceof BsMember)) { return false; }
        BsMember other = (BsMember)obj;
        if (!xSV(getMemberId(), other.getMemberId())) { return false; }
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
        hs = xCH(hs, getMemberId());
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
        if (_memberSecurityAsOne != null)
        { sb.append(li).append(xbRDS(_memberSecurityAsOne, "memberSecurityAsOne")); }
        if (_memberWithdrawAsOne != null)
        { sb.append(li).append(xbRDS(_memberWithdrawAsOne, "memberWithdrawAsOne")); }
        if (_followByYouIdList != null) { for (Entity et : _followByYouIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "followByYouIdList")); } } }
        if (_followByMemberIdList != null) { for (Entity et : _followByMemberIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "followByMemberIdList")); } } }
        if (_loginList != null) { for (Entity et : _loginList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "loginList")); } } }
        if (_tweetList != null) { for (Entity et : _tweetList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "tweetList")); } } }
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
        sb.append(dm).append(getMemberId());
        sb.append(dm).append(getEmailAddress());
        sb.append(dm).append(getUserName());
        sb.append(dm).append(xfUD(getBirthdate()));
        sb.append(dm).append(getProfile());
        sb.append(dm).append(getInsDatetime());
        sb.append(dm).append(getUpdDatetime());
        sb.append(dm).append(getInsTrace());
        sb.append(dm).append(getUpdTrace());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String xfUD(Date date) { // formatUtilDate()
        return FunCustodial.toString(date, xgDP());
    }
    protected String xgDP() { // getDatePattern
        return "yyyy-MM-dd";
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_memberSecurityAsOne != null) { sb.append(cm).append("memberSecurityAsOne"); }
        if (_memberWithdrawAsOne != null) { sb.append(cm).append("memberWithdrawAsOne"); }
        if (_followByYouIdList != null && !_followByYouIdList.isEmpty())
        { sb.append(cm).append("followByYouIdList"); }
        if (_followByMemberIdList != null && !_followByMemberIdList.isEmpty())
        { sb.append(cm).append("followByMemberIdList"); }
        if (_loginList != null && !_loginList.isEmpty())
        { sb.append(cm).append("loginList"); }
        if (_tweetList != null && !_tweetList.isEmpty())
        { sb.append(cm).append("tweetList"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public Member clone() {
        try {
            return (Member)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] MEMBER_ID: {PK, ID, NotNull, INT(10)} <br />
     * 会員ID : 会員のID
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberId() {
        return _memberId;
    }

    /**
     * [set] MEMBER_ID: {PK, ID, NotNull, INT(10)} <br />
     * 会員ID : 会員のID
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Integer memberId) {
        __modifiedProperties.addPropertyName("memberId");
        _memberId = memberId;
    }

    /**
     * [get] EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)} <br />
     * メールアドレス : 会員のメールアドレス
     * @return The value of the column 'EMAIL_ADDRESS'. (basically NotNull if selected: for the constraint)
     */
    public String getEmailAddress() {
        return _emailAddress;
    }

    /**
     * [set] EMAIL_ADDRESS: {UQ, NotNull, VARCHAR(100)} <br />
     * メールアドレス : 会員のメールアドレス
     * @param emailAddress The value of the column 'EMAIL_ADDRESS'. (basically NotNull if update: for the constraint)
     */
    public void setEmailAddress(String emailAddress) {
        __modifiedProperties.addPropertyName("emailAddress");
        _emailAddress = emailAddress;
    }

    /**
     * [get] USER_NAME: {UQ, NotNull, VARCHAR(50)} <br />
     * 会員ユーザ名 : 会員のユーザ名
     * @return The value of the column 'USER_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * [set] USER_NAME: {UQ, NotNull, VARCHAR(50)} <br />
     * 会員ユーザ名 : 会員のユーザ名
     * @param userName The value of the column 'USER_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setUserName(String userName) {
        __modifiedProperties.addPropertyName("userName");
        _userName = userName;
    }

    /**
     * [get] BIRTHDATE: {DATE(10)} <br />
     * 生年月日 : 会員の生年月日
     * @return The value of the column 'BIRTHDATE'. (NullAllowed even if selected: for no constraint)
     */
    public java.util.Date getBirthdate() {
        return _birthdate;
    }

    /**
     * [set] BIRTHDATE: {DATE(10)} <br />
     * 生年月日 : 会員の生年月日
     * @param birthdate The value of the column 'BIRTHDATE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setBirthdate(java.util.Date birthdate) {
        __modifiedProperties.addPropertyName("birthdate");
        _birthdate = birthdate;
    }

    /**
     * [get] PROFILE: {VARCHAR(200)} <br />
     * プロフィール
     * @return The value of the column 'PROFILE'. (NullAllowed even if selected: for no constraint)
     */
    public String getProfile() {
        return _profile;
    }

    /**
     * [set] PROFILE: {VARCHAR(200)} <br />
     * プロフィール
     * @param profile The value of the column 'PROFILE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setProfile(String profile) {
        __modifiedProperties.addPropertyName("profile");
        _profile = profile;
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
}
