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
 * The entity of member as TABLE. <br />
 * 会員
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, MEMBER_STATUS_CODE, USER_NAME, ACCOUNT_NAME, GROUP_NAME, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE, RECRUITING_NUMBER, INTERESTED_INDUSTRY, GRADUATION_YEAR
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
 *     member_status, member_security(AsOne)
 * 
 * [referrer table]
 *     follow, login, message, tweet, member_security
 * 
 * [foreign property]
 *     memberStatus, memberSecurityAsOne
 * 
 * [referrer property]
 *     followByYouIdList, followByMemberIdList, loginList, messageBySenderIdList, messageByReceiverIdList, tweetList
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer memberId = entity.getMemberId();
 * Integer memberStatusCode = entity.getMemberStatusCode();
 * String userName = entity.getUserName();
 * String accountName = entity.getAccountName();
 * String groupName = entity.getGroupName();
 * java.sql.Timestamp insDatetime = entity.getInsDatetime();
 * java.sql.Timestamp updDatetime = entity.getUpdDatetime();
 * String insTrace = entity.getInsTrace();
 * String updTrace = entity.getUpdTrace();
 * String recruitingNumber = entity.getRecruitingNumber();
 * String interestedIndustry = entity.getInterestedIndustry();
 * Integer graduationYear = entity.getGraduationYear();
 * entity.setMemberId(memberId);
 * entity.setMemberStatusCode(memberStatusCode);
 * entity.setUserName(userName);
 * entity.setAccountName(accountName);
 * entity.setGroupName(groupName);
 * entity.setInsDatetime(insDatetime);
 * entity.setUpdDatetime(updDatetime);
 * entity.setInsTrace(insTrace);
 * entity.setUpdTrace(updTrace);
 * entity.setRecruitingNumber(recruitingNumber);
 * entity.setInterestedIndustry(interestedIndustry);
 * entity.setGraduationYear(graduationYear);
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

    /** MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status} */
    protected Integer _memberStatusCode;

    /** USER_NAME: {UQ, NotNull, VARCHAR(100)} */
    protected String _userName;

    /** ACCOUNT_NAME: {NotNull, VARCHAR(20)} */
    protected String _accountName;

    /** GROUP_NAME: {NotNull, VARCHAR(100)} */
    protected String _groupName;

    /** INS_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _insDatetime;

    /** UPD_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _updDatetime;

    /** INS_TRACE: {NotNull, VARCHAR(256)} */
    protected String _insTrace;

    /** UPD_TRACE: {NotNull, VARCHAR(256)} */
    protected String _updTrace;

    /** RECRUITING_NUMBER: {VARCHAR(20)} */
    protected String _recruitingNumber;

    /** INTERESTED_INDUSTRY: {VARCHAR(50)} */
    protected String _interestedIndustry;

    /** GRADUATION_YEAR: {INT(10)} */
    protected Integer _graduationYear;

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
     * @param userName : UQ, NotNull, VARCHAR(100). (NotNull)
     */
    public void uniqueBy(String userName) {
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
    /** member_status by my MEMBER_STATUS_CODE, named 'memberStatus'. */
    protected MemberStatus _memberStatus;

    /**
     * [get] member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The entity of foreign property 'memberStatus'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public MemberStatus getMemberStatus() {
        return _memberStatus;
    }

    /**
     * [set] member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param memberStatus The entity of foreign property 'memberStatus'. (NullAllowed)
     */
    public void setMemberStatus(MemberStatus memberStatus) {
        _memberStatus = memberStatus;
    }

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

    /** message by SENDER_ID, named 'messageBySenderIdList'. */
    protected List<Message> _messageBySenderIdList;

    /**
     * [get] message by SENDER_ID, named 'messageBySenderIdList'.
     * @return The entity list of referrer property 'messageBySenderIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Message> getMessageBySenderIdList() {
        if (_messageBySenderIdList == null) { _messageBySenderIdList = newReferrerList(); }
        return _messageBySenderIdList;
    }

    /**
     * [set] message by SENDER_ID, named 'messageBySenderIdList'.
     * @param messageBySenderIdList The entity list of referrer property 'messageBySenderIdList'. (NullAllowed)
     */
    public void setMessageBySenderIdList(List<Message> messageBySenderIdList) {
        _messageBySenderIdList = messageBySenderIdList;
    }

    /** message by RECEIVER_ID, named 'messageByReceiverIdList'. */
    protected List<Message> _messageByReceiverIdList;

    /**
     * [get] message by RECEIVER_ID, named 'messageByReceiverIdList'.
     * @return The entity list of referrer property 'messageByReceiverIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Message> getMessageByReceiverIdList() {
        if (_messageByReceiverIdList == null) { _messageByReceiverIdList = newReferrerList(); }
        return _messageByReceiverIdList;
    }

    /**
     * [set] message by RECEIVER_ID, named 'messageByReceiverIdList'.
     * @param messageByReceiverIdList The entity list of referrer property 'messageByReceiverIdList'. (NullAllowed)
     */
    public void setMessageByReceiverIdList(List<Message> messageByReceiverIdList) {
        _messageByReceiverIdList = messageByReceiverIdList;
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
        if (_memberStatus != null)
        { sb.append(li).append(xbRDS(_memberStatus, "memberStatus")); }
        if (_memberSecurityAsOne != null)
        { sb.append(li).append(xbRDS(_memberSecurityAsOne, "memberSecurityAsOne")); }
        if (_followByYouIdList != null) { for (Entity et : _followByYouIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "followByYouIdList")); } } }
        if (_followByMemberIdList != null) { for (Entity et : _followByMemberIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "followByMemberIdList")); } } }
        if (_loginList != null) { for (Entity et : _loginList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "loginList")); } } }
        if (_messageBySenderIdList != null) { for (Entity et : _messageBySenderIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "messageBySenderIdList")); } } }
        if (_messageByReceiverIdList != null) { for (Entity et : _messageByReceiverIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "messageByReceiverIdList")); } } }
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
        sb.append(dm).append(getMemberStatusCode());
        sb.append(dm).append(getUserName());
        sb.append(dm).append(getAccountName());
        sb.append(dm).append(getGroupName());
        sb.append(dm).append(getInsDatetime());
        sb.append(dm).append(getUpdDatetime());
        sb.append(dm).append(getInsTrace());
        sb.append(dm).append(getUpdTrace());
        sb.append(dm).append(getRecruitingNumber());
        sb.append(dm).append(getInterestedIndustry());
        sb.append(dm).append(getGraduationYear());
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_memberStatus != null) { sb.append(cm).append("memberStatus"); }
        if (_memberSecurityAsOne != null) { sb.append(cm).append("memberSecurityAsOne"); }
        if (_followByYouIdList != null && !_followByYouIdList.isEmpty())
        { sb.append(cm).append("followByYouIdList"); }
        if (_followByMemberIdList != null && !_followByMemberIdList.isEmpty())
        { sb.append(cm).append("followByMemberIdList"); }
        if (_loginList != null && !_loginList.isEmpty())
        { sb.append(cm).append("loginList"); }
        if (_messageBySenderIdList != null && !_messageBySenderIdList.isEmpty())
        { sb.append(cm).append("messageBySenderIdList"); }
        if (_messageByReceiverIdList != null && !_messageByReceiverIdList.isEmpty())
        { sb.append(cm).append("messageByReceiverIdList"); }
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
     * [get] MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status} <br />
     * メンバーステータスコード : 企業か学生か
     * @return The value of the column 'MEMBER_STATUS_CODE'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberStatusCode() {
        return _memberStatusCode;
    }

    /**
     * [set] MEMBER_STATUS_CODE: {IX, NotNull, INT(10), FK to member_status} <br />
     * メンバーステータスコード : 企業か学生か
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    public void setMemberStatusCode(Integer memberStatusCode) {
        __modifiedProperties.addPropertyName("memberStatusCode");
        _memberStatusCode = memberStatusCode;
    }

    /**
     * [get] USER_NAME: {UQ, NotNull, VARCHAR(100)} <br />
     * 会員ユーザ名 : 会員のユーザ名
     * @return The value of the column 'USER_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * [set] USER_NAME: {UQ, NotNull, VARCHAR(100)} <br />
     * 会員ユーザ名 : 会員のユーザ名
     * @param userName The value of the column 'USER_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setUserName(String userName) {
        __modifiedProperties.addPropertyName("userName");
        _userName = userName;
    }

    /**
     * [get] ACCOUNT_NAME: {NotNull, VARCHAR(20)} <br />
     * アカウント名
     * @return The value of the column 'ACCOUNT_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getAccountName() {
        return _accountName;
    }

    /**
     * [set] ACCOUNT_NAME: {NotNull, VARCHAR(20)} <br />
     * アカウント名
     * @param accountName The value of the column 'ACCOUNT_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setAccountName(String accountName) {
        __modifiedProperties.addPropertyName("accountName");
        _accountName = accountName;
    }

    /**
     * [get] GROUP_NAME: {NotNull, VARCHAR(100)} <br />
     * 所属団体名 : 学校、もしくは企業名を登録
     * @return The value of the column 'GROUP_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getGroupName() {
        return _groupName;
    }

    /**
     * [set] GROUP_NAME: {NotNull, VARCHAR(100)} <br />
     * 所属団体名 : 学校、もしくは企業名を登録
     * @param groupName The value of the column 'GROUP_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setGroupName(String groupName) {
        __modifiedProperties.addPropertyName("groupName");
        _groupName = groupName;
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
     * [get] RECRUITING_NUMBER: {VARCHAR(20)} <br />
     * 採用数 : 企業の採用予定数
     * @return The value of the column 'RECRUITING_NUMBER'. (NullAllowed even if selected: for no constraint)
     */
    public String getRecruitingNumber() {
        return _recruitingNumber;
    }

    /**
     * [set] RECRUITING_NUMBER: {VARCHAR(20)} <br />
     * 採用数 : 企業の採用予定数
     * @param recruitingNumber The value of the column 'RECRUITING_NUMBER'. (NullAllowed: null update allowed for no constraint)
     */
    public void setRecruitingNumber(String recruitingNumber) {
        __modifiedProperties.addPropertyName("recruitingNumber");
        _recruitingNumber = recruitingNumber;
    }

    /**
     * [get] INTERESTED_INDUSTRY: {VARCHAR(50)} <br />
     * 希望業界 : 学生が希望している業界。
     * @return The value of the column 'INTERESTED_INDUSTRY'. (NullAllowed even if selected: for no constraint)
     */
    public String getInterestedIndustry() {
        return _interestedIndustry;
    }

    /**
     * [set] INTERESTED_INDUSTRY: {VARCHAR(50)} <br />
     * 希望業界 : 学生が希望している業界。
     * @param interestedIndustry The value of the column 'INTERESTED_INDUSTRY'. (NullAllowed: null update allowed for no constraint)
     */
    public void setInterestedIndustry(String interestedIndustry) {
        __modifiedProperties.addPropertyName("interestedIndustry");
        _interestedIndustry = interestedIndustry;
    }

    /**
     * [get] GRADUATION_YEAR: {INT(10)} <br />
     * 卒業年 : 卒業年もしくは卒業予定年
     * @return The value of the column 'GRADUATION_YEAR'. (NullAllowed even if selected: for no constraint)
     */
    public Integer getGraduationYear() {
        return _graduationYear;
    }

    /**
     * [set] GRADUATION_YEAR: {INT(10)} <br />
     * 卒業年 : 卒業年もしくは卒業予定年
     * @param graduationYear The value of the column 'GRADUATION_YEAR'. (NullAllowed: null update allowed for no constraint)
     */
    public void setGraduationYear(Integer graduationYear) {
        __modifiedProperties.addPropertyName("graduationYear");
        _graduationYear = graduationYear;
    }
}
