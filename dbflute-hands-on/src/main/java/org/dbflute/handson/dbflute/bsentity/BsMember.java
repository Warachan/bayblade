package org.dbflute.handson.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.seasar.dbflute.dbmeta.DBMeta;
import org.seasar.dbflute.dbmeta.AbstractEntity;
import org.seasar.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.handson.dbflute.allcommon.EntityDefinedCommonColumn;
import org.dbflute.handson.dbflute.allcommon.DBMetaInstanceHandler;
import org.dbflute.handson.dbflute.allcommon.CDef;
import org.dbflute.handson.dbflute.exentity.*;

/**
 * The entity of (会員)MEMBER as TABLE. <br />
 * 会員登録時にデータが登録される。<br />
 * 基本的に物理削除はなく、退会したらステータスが退会会員になる。
 * <pre>
 * [primary-key]
 *     MEMBER_ID
 * 
 * [column]
 *     MEMBER_ID, MEMBER_NAME, MEMBER_ACCOUNT, MEMBER_STATUS_CODE, FORMALIZED_DATETIME, BIRTHDATE, REGISTER_DATETIME, REGISTER_USER, UPDATE_DATETIME, UPDATE_USER, VERSION_NO
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MEMBER_ID
 * 
 * [version-no]
 *     VERSION_NO
 * 
 * [foreign table]
 *     member_status, MEMBER_ADDRESS(AsValid), MEMBER_LOGIN(AsLatest), member_security(AsOne), member_service(AsOne), member_withdrawal(AsOne)
 * 
 * [referrer table]
 *     member_address, member_following, member_login, purchase, member_security, member_service, member_withdrawal
 * 
 * [foreign property]
 *     memberStatus, memberAddressAsValid, memberLoginAsLatest, memberSecurityAsOne, memberServiceAsOne, memberWithdrawalAsOne
 * 
 * [referrer property]
 *     memberAddressList, memberFollowingByMyMemberIdList, memberFollowingByYourMemberIdList, memberLoginList, purchaseList
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer memberId = entity.getMemberId();
 * String memberName = entity.getMemberName();
 * String memberAccount = entity.getMemberAccount();
 * String memberStatusCode = entity.getMemberStatusCode();
 * java.sql.Timestamp formalizedDatetime = entity.getFormalizedDatetime();
 * java.util.Date birthdate = entity.getBirthdate();
 * java.sql.Timestamp registerDatetime = entity.getRegisterDatetime();
 * String registerUser = entity.getRegisterUser();
 * java.sql.Timestamp updateDatetime = entity.getUpdateDatetime();
 * String updateUser = entity.getUpdateUser();
 * Long versionNo = entity.getVersionNo();
 * entity.setMemberId(memberId);
 * entity.setMemberName(memberName);
 * entity.setMemberAccount(memberAccount);
 * entity.setMemberStatusCode(memberStatusCode);
 * entity.setFormalizedDatetime(formalizedDatetime);
 * entity.setBirthdate(birthdate);
 * entity.setRegisterDatetime(registerDatetime);
 * entity.setRegisterUser(registerUser);
 * entity.setUpdateDatetime(updateDatetime);
 * entity.setUpdateUser(updateUser);
 * entity.setVersionNo(versionNo);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMember extends AbstractEntity implements DomainEntity, EntityDefinedCommonColumn {

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
    /** (会員ID)MEMBER_ID: {PK, ID, NotNull, INT(10), FK to MEMBER_ADDRESS} */
    protected Integer _memberId;

    /** (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)} */
    protected String _memberName;

    /** (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} */
    protected String _memberAccount;

    /** (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to member_status, classification=MemberStatus} */
    protected String _memberStatusCode;

    /** (正式会員日時)FORMALIZED_DATETIME: {IX, DATETIME(19)} */
    protected java.sql.Timestamp _formalizedDatetime;

    /** (生年月日)BIRTHDATE: {DATE(10)} */
    protected java.util.Date _birthdate;

    /** (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _registerDatetime;

    /** (登録ユーザ)REGISTER_USER: {NotNull, VARCHAR(200)} */
    protected String _registerUser;

    /** (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)} */
    protected java.sql.Timestamp _updateDatetime;

    /** (更新ユーザ)UPDATE_USER: {NotNull, VARCHAR(200)} */
    protected String _updateUser;

    /** (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)} */
    protected Long _versionNo;

    // -----------------------------------------------------
    //                                              Internal
    //                                              --------
    /** Is common column auto set up effective? */
    protected boolean __canCommonColumnAutoSetup = true;

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
     * @param memberAccount (会員アカウント): UQ, NotNull, VARCHAR(50). (NotNull)
     */
    public void uniqueBy(String memberAccount) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("memberAccount");
        setMemberAccount(memberAccount);
    }

    // ===================================================================================
    //                                                             Classification Property
    //                                                             =======================
    /**
     * Get the value of memberStatusCode as the classification of MemberStatus. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to member_status, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * <p>It's treated as case insensitive and if the code value is null, it returns null.</p>
     * @return The instance of classification definition (as ENUM type). (NullAllowed: when the column value is null)
     */
    public CDef.MemberStatus getMemberStatusCodeAsMemberStatus() {
        return CDef.MemberStatus.codeOf(getMemberStatusCode());
    }

    /**
     * Set the value of memberStatusCode as the classification of MemberStatus. <br />
     * (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to member_status, classification=MemberStatus} <br />
     * 入会から退会までの会員のステータスを示す
     * @param cdef The instance of classification definition (as ENUM type). (NullAllowed: if null, null value is set to the column)
     */
    public void setMemberStatusCodeAsMemberStatus(CDef.MemberStatus cdef) {
        setMemberStatusCode(cdef != null ? cdef.code() : null);
    }

    // ===================================================================================
    //                                                              Classification Setting
    //                                                              ======================
    /**
     * Set the value of memberStatusCode as 正式会員 (FML). <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     */
    public void setMemberStatusCode_正式会員() {
        setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.正式会員);
    }

    /**
     * Set the value of memberStatusCode as 退会会員 (WDL). <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     */
    public void setMemberStatusCode_退会会員() {
        setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.退会会員);
    }

    /**
     * Set the value of memberStatusCode as 仮会員 (PRV). <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     */
    public void setMemberStatusCode_仮会員() {
        setMemberStatusCodeAsMemberStatus(CDef.MemberStatus.仮会員);
    }

    // ===================================================================================
    //                                                        Classification Determination
    //                                                        ============================
    /**
     * Is the value of memberStatusCode 正式会員? <br />
     * 正式会員: 正式な会員としてサイトサービスが利用可能
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCode正式会員() {
        CDef.MemberStatus cdef = getMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.正式会員) : false;
    }

    /**
     * Is the value of memberStatusCode 退会会員? <br />
     * 退会会員: 退会が確定した会員でサイトサービスはダメ
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCode退会会員() {
        CDef.MemberStatus cdef = getMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.退会会員) : false;
    }

    /**
     * Is the value of memberStatusCode 仮会員? <br />
     * 仮会員: 入会直後のステータスで一部のサイトサービスが利用可能
     * <p>It's treated as case insensitive and if the code value is null, it returns false.</p>
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCode仮会員() {
        CDef.MemberStatus cdef = getMemberStatusCodeAsMemberStatus();
        return cdef != null ? cdef.equals(CDef.MemberStatus.仮会員) : false;
    }

    /**
     * サービスが利用できる会員 <br />
     * The group elements:[正式会員, 仮会員]
     * @return The determination, true or false.
     */
    public boolean isMemberStatusCode_ServiceAvailable() {
        CDef.MemberStatus cdef = getMemberStatusCodeAsMemberStatus();
        return cdef != null && cdef.isServiceAvailable();
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** (会員ステータス)member_status by my MEMBER_STATUS_CODE, named 'memberStatus'. */
    protected MemberStatus _memberStatus;

    /**
     * [get] (会員ステータス)member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @return The entity of foreign property 'memberStatus'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public MemberStatus getMemberStatus() {
        return _memberStatus;
    }

    /**
     * [set] (会員ステータス)member_status by my MEMBER_STATUS_CODE, named 'memberStatus'.
     * @param memberStatus The entity of foreign property 'memberStatus'. (NullAllowed)
     */
    public void setMemberStatus(MemberStatus memberStatus) {
        _memberStatus = memberStatus;
    }

    /** (会員住所情報)member_address by my MEMBER_ID, named 'memberAddressAsValid'. */
    protected MemberAddress _memberAddressAsValid;

    /**
     * [get] (会員住所情報)member_address by my MEMBER_ID, named 'memberAddressAsValid'. <br />
     * 有効な会員住所 (現在日時を入れれば現在住所)
     * @return The entity of foreign property 'memberAddressAsValid'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public MemberAddress getMemberAddressAsValid() {
        return _memberAddressAsValid;
    }

    /**
     * [set] (会員住所情報)member_address by my MEMBER_ID, named 'memberAddressAsValid'. <br />
     * 有効な会員住所 (現在日時を入れれば現在住所)
     * @param memberAddressAsValid The entity of foreign property 'memberAddressAsValid'. (NullAllowed)
     */
    public void setMemberAddressAsValid(MemberAddress memberAddressAsValid) {
        _memberAddressAsValid = memberAddressAsValid;
    }

    /** (会員ログイン情報)member_login by my MEMBER_ID, named 'memberLoginAsLatest'. */
    protected MemberLogin _memberLoginAsLatest;

    /**
     * [get] (会員ログイン情報)member_login by my MEMBER_ID, named 'memberLoginAsLatest'. <br />
     * 会員の最終ログイン
     * @return The entity of foreign property 'memberLoginAsLatest'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public MemberLogin getMemberLoginAsLatest() {
        return _memberLoginAsLatest;
    }

    /**
     * [set] (会員ログイン情報)member_login by my MEMBER_ID, named 'memberLoginAsLatest'. <br />
     * 会員の最終ログイン
     * @param memberLoginAsLatest The entity of foreign property 'memberLoginAsLatest'. (NullAllowed)
     */
    public void setMemberLoginAsLatest(MemberLogin memberLoginAsLatest) {
        _memberLoginAsLatest = memberLoginAsLatest;
    }

    /** (会員セキュリティ情報)member_security by MEMBER_ID, named 'memberSecurityAsOne'. */
    protected MemberSecurity _memberSecurityAsOne;

    /**
     * [get] (会員セキュリティ情報)member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @return the entity of foreign property(referrer-as-one) 'memberSecurityAsOne'. (NullAllowed: when e.g. no data, no setupSelect)
     */
    public MemberSecurity getMemberSecurityAsOne() {
        return _memberSecurityAsOne;
    }

    /**
     * [set] (会員セキュリティ情報)member_security by MEMBER_ID, named 'memberSecurityAsOne'.
     * @param memberSecurityAsOne The entity of foreign property(referrer-as-one) 'memberSecurityAsOne'. (NullAllowed)
     */
    public void setMemberSecurityAsOne(MemberSecurity memberSecurityAsOne) {
        _memberSecurityAsOne = memberSecurityAsOne;
    }

    /** (会員サービス)member_service by MEMBER_ID, named 'memberServiceAsOne'. */
    protected MemberService _memberServiceAsOne;

    /**
     * [get] (会員サービス)member_service by MEMBER_ID, named 'memberServiceAsOne'.
     * @return the entity of foreign property(referrer-as-one) 'memberServiceAsOne'. (NullAllowed: when e.g. no data, no setupSelect)
     */
    public MemberService getMemberServiceAsOne() {
        return _memberServiceAsOne;
    }

    /**
     * [set] (会員サービス)member_service by MEMBER_ID, named 'memberServiceAsOne'.
     * @param memberServiceAsOne The entity of foreign property(referrer-as-one) 'memberServiceAsOne'. (NullAllowed)
     */
    public void setMemberServiceAsOne(MemberService memberServiceAsOne) {
        _memberServiceAsOne = memberServiceAsOne;
    }

    /** (会員退会情報)member_withdrawal by MEMBER_ID, named 'memberWithdrawalAsOne'. */
    protected MemberWithdrawal _memberWithdrawalAsOne;

    /**
     * [get] (会員退会情報)member_withdrawal by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * @return the entity of foreign property(referrer-as-one) 'memberWithdrawalAsOne'. (NullAllowed: when e.g. no data, no setupSelect)
     */
    public MemberWithdrawal getMemberWithdrawalAsOne() {
        return _memberWithdrawalAsOne;
    }

    /**
     * [set] (会員退会情報)member_withdrawal by MEMBER_ID, named 'memberWithdrawalAsOne'.
     * @param memberWithdrawalAsOne The entity of foreign property(referrer-as-one) 'memberWithdrawalAsOne'. (NullAllowed)
     */
    public void setMemberWithdrawalAsOne(MemberWithdrawal memberWithdrawalAsOne) {
        _memberWithdrawalAsOne = memberWithdrawalAsOne;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    /** (会員住所情報)member_address by MEMBER_ID, named 'memberAddressList'. */
    protected List<MemberAddress> _memberAddressList;

    /**
     * [get] (会員住所情報)member_address by MEMBER_ID, named 'memberAddressList'.
     * @return The entity list of referrer property 'memberAddressList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberAddress> getMemberAddressList() {
        if (_memberAddressList == null) { _memberAddressList = newReferrerList(); }
        return _memberAddressList;
    }

    /**
     * [set] (会員住所情報)member_address by MEMBER_ID, named 'memberAddressList'.
     * @param memberAddressList The entity list of referrer property 'memberAddressList'. (NullAllowed)
     */
    public void setMemberAddressList(List<MemberAddress> memberAddressList) {
        _memberAddressList = memberAddressList;
    }

    /** (会員フォローイング)member_following by MY_MEMBER_ID, named 'memberFollowingByMyMemberIdList'. */
    protected List<MemberFollowing> _memberFollowingByMyMemberIdList;

    /**
     * [get] (会員フォローイング)member_following by MY_MEMBER_ID, named 'memberFollowingByMyMemberIdList'.
     * @return The entity list of referrer property 'memberFollowingByMyMemberIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberFollowing> getMemberFollowingByMyMemberIdList() {
        if (_memberFollowingByMyMemberIdList == null) { _memberFollowingByMyMemberIdList = newReferrerList(); }
        return _memberFollowingByMyMemberIdList;
    }

    /**
     * [set] (会員フォローイング)member_following by MY_MEMBER_ID, named 'memberFollowingByMyMemberIdList'.
     * @param memberFollowingByMyMemberIdList The entity list of referrer property 'memberFollowingByMyMemberIdList'. (NullAllowed)
     */
    public void setMemberFollowingByMyMemberIdList(List<MemberFollowing> memberFollowingByMyMemberIdList) {
        _memberFollowingByMyMemberIdList = memberFollowingByMyMemberIdList;
    }

    /** (会員フォローイング)member_following by YOUR_MEMBER_ID, named 'memberFollowingByYourMemberIdList'. */
    protected List<MemberFollowing> _memberFollowingByYourMemberIdList;

    /**
     * [get] (会員フォローイング)member_following by YOUR_MEMBER_ID, named 'memberFollowingByYourMemberIdList'.
     * @return The entity list of referrer property 'memberFollowingByYourMemberIdList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberFollowing> getMemberFollowingByYourMemberIdList() {
        if (_memberFollowingByYourMemberIdList == null) { _memberFollowingByYourMemberIdList = newReferrerList(); }
        return _memberFollowingByYourMemberIdList;
    }

    /**
     * [set] (会員フォローイング)member_following by YOUR_MEMBER_ID, named 'memberFollowingByYourMemberIdList'.
     * @param memberFollowingByYourMemberIdList The entity list of referrer property 'memberFollowingByYourMemberIdList'. (NullAllowed)
     */
    public void setMemberFollowingByYourMemberIdList(List<MemberFollowing> memberFollowingByYourMemberIdList) {
        _memberFollowingByYourMemberIdList = memberFollowingByYourMemberIdList;
    }

    /** (会員ログイン情報)member_login by MEMBER_ID, named 'memberLoginList'. */
    protected List<MemberLogin> _memberLoginList;

    /**
     * [get] (会員ログイン情報)member_login by MEMBER_ID, named 'memberLoginList'.
     * @return The entity list of referrer property 'memberLoginList'. (NotNull: even if no loading, returns empty list)
     */
    public List<MemberLogin> getMemberLoginList() {
        if (_memberLoginList == null) { _memberLoginList = newReferrerList(); }
        return _memberLoginList;
    }

    /**
     * [set] (会員ログイン情報)member_login by MEMBER_ID, named 'memberLoginList'.
     * @param memberLoginList The entity list of referrer property 'memberLoginList'. (NullAllowed)
     */
    public void setMemberLoginList(List<MemberLogin> memberLoginList) {
        _memberLoginList = memberLoginList;
    }

    /** (購入)purchase by MEMBER_ID, named 'purchaseList'. */
    protected List<Purchase> _purchaseList;

    /**
     * [get] (購入)purchase by MEMBER_ID, named 'purchaseList'.
     * @return The entity list of referrer property 'purchaseList'. (NotNull: even if no loading, returns empty list)
     */
    public List<Purchase> getPurchaseList() {
        if (_purchaseList == null) { _purchaseList = newReferrerList(); }
        return _purchaseList;
    }

    /**
     * [set] (購入)purchase by MEMBER_ID, named 'purchaseList'.
     * @param purchaseList The entity list of referrer property 'purchaseList'. (NullAllowed)
     */
    public void setPurchaseList(List<Purchase> purchaseList) {
        _purchaseList = purchaseList;
    }

    protected <ELEMENT> List<ELEMENT> newReferrerList() {
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                       Common Column
    //                                                                       =============
    /**
     * {@inheritDoc}
     */
    public void enableCommonColumnAutoSetup() {
        __canCommonColumnAutoSetup = true;
    }

    /**
     * {@inheritDoc}
     */
    public void disableCommonColumnAutoSetup() {
        __canCommonColumnAutoSetup = false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean canCommonColumnAutoSetup() {
        return __canCommonColumnAutoSetup;
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsMember) {
            BsMember other = (BsMember)obj;
            if (!xSV(_memberId, other._memberId)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, getTableDbName());
        hs = xCH(hs, _memberId);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_memberStatus != null)
        { sb.append(li).append(xbRDS(_memberStatus, "memberStatus")); }
        if (_memberAddressAsValid != null)
        { sb.append(li).append(xbRDS(_memberAddressAsValid, "memberAddressAsValid")); }
        if (_memberLoginAsLatest != null)
        { sb.append(li).append(xbRDS(_memberLoginAsLatest, "memberLoginAsLatest")); }
        if (_memberSecurityAsOne != null)
        { sb.append(li).append(xbRDS(_memberSecurityAsOne, "memberSecurityAsOne")); }
        if (_memberServiceAsOne != null)
        { sb.append(li).append(xbRDS(_memberServiceAsOne, "memberServiceAsOne")); }
        if (_memberWithdrawalAsOne != null)
        { sb.append(li).append(xbRDS(_memberWithdrawalAsOne, "memberWithdrawalAsOne")); }
        if (_memberAddressList != null) { for (MemberAddress et : _memberAddressList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "memberAddressList")); } } }
        if (_memberFollowingByMyMemberIdList != null) { for (MemberFollowing et : _memberFollowingByMyMemberIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "memberFollowingByMyMemberIdList")); } } }
        if (_memberFollowingByYourMemberIdList != null) { for (MemberFollowing et : _memberFollowingByYourMemberIdList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "memberFollowingByYourMemberIdList")); } } }
        if (_memberLoginList != null) { for (MemberLogin et : _memberLoginList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "memberLoginList")); } } }
        if (_purchaseList != null) { for (Purchase et : _purchaseList)
        { if (et != null) { sb.append(li).append(xbRDS(et, "purchaseList")); } } }
        return sb.toString();
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_memberId));
        sb.append(dm).append(xfND(_memberName));
        sb.append(dm).append(xfND(_memberAccount));
        sb.append(dm).append(xfND(_memberStatusCode));
        sb.append(dm).append(xfND(_formalizedDatetime));
        sb.append(dm).append(xfUD(_birthdate));
        sb.append(dm).append(xfND(_registerDatetime));
        sb.append(dm).append(xfND(_registerUser));
        sb.append(dm).append(xfND(_updateDatetime));
        sb.append(dm).append(xfND(_updateUser));
        sb.append(dm).append(xfND(_versionNo));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_memberStatus != null)
        { sb.append(dm).append("memberStatus"); }
        if (_memberAddressAsValid != null)
        { sb.append(dm).append("memberAddressAsValid"); }
        if (_memberLoginAsLatest != null)
        { sb.append(dm).append("memberLoginAsLatest"); }
        if (_memberSecurityAsOne != null)
        { sb.append(dm).append("memberSecurityAsOne"); }
        if (_memberServiceAsOne != null)
        { sb.append(dm).append("memberServiceAsOne"); }
        if (_memberWithdrawalAsOne != null)
        { sb.append(dm).append("memberWithdrawalAsOne"); }
        if (_memberAddressList != null && !_memberAddressList.isEmpty())
        { sb.append(dm).append("memberAddressList"); }
        if (_memberFollowingByMyMemberIdList != null && !_memberFollowingByMyMemberIdList.isEmpty())
        { sb.append(dm).append("memberFollowingByMyMemberIdList"); }
        if (_memberFollowingByYourMemberIdList != null && !_memberFollowingByYourMemberIdList.isEmpty())
        { sb.append(dm).append("memberFollowingByYourMemberIdList"); }
        if (_memberLoginList != null && !_memberLoginList.isEmpty())
        { sb.append(dm).append("memberLoginList"); }
        if (_purchaseList != null && !_purchaseList.isEmpty())
        { sb.append(dm).append("purchaseList"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Member clone() {
        return (Member)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] (会員ID)MEMBER_ID: {PK, ID, NotNull, INT(10), FK to MEMBER_ADDRESS} <br />
     * 会員を識別するID。連番として基本的に自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMSによって変わる。
     * @return The value of the column 'MEMBER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMemberId() {
        checkSpecifiedProperty("memberId");
        return _memberId;
    }

    /**
     * [set] (会員ID)MEMBER_ID: {PK, ID, NotNull, INT(10), FK to MEMBER_ADDRESS} <br />
     * 会員を識別するID。連番として基本的に自動採番される。<br />
     * （会員IDだけに限らず）採番方法はDBMSによって変わる。
     * @param memberId The value of the column 'MEMBER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMemberId(Integer memberId) {
        registerModifiedProperty("memberId");
        _memberId = memberId;
    }

    /**
     * [get] (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * 会員のフルネームの名称。
     * @return The value of the column 'MEMBER_NAME'. (basically NotNull if selected: for the constraint)
     */
    public String getMemberName() {
        checkSpecifiedProperty("memberName");
        return convertEmptyToNull(_memberName);
    }

    /**
     * [set] (会員名称)MEMBER_NAME: {IX, NotNull, VARCHAR(200)} <br />
     * 会員のフルネームの名称。
     * @param memberName The value of the column 'MEMBER_NAME'. (basically NotNull if update: for the constraint)
     */
    public void setMemberName(String memberName) {
        registerModifiedProperty("memberName");
        _memberName = memberName;
    }

    /**
     * [get] (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * 会員がログイン時に利用するアカウントNO。
     * @return The value of the column 'MEMBER_ACCOUNT'. (basically NotNull if selected: for the constraint)
     */
    public String getMemberAccount() {
        checkSpecifiedProperty("memberAccount");
        return convertEmptyToNull(_memberAccount);
    }

    /**
     * [set] (会員アカウント)MEMBER_ACCOUNT: {UQ, NotNull, VARCHAR(50)} <br />
     * 会員がログイン時に利用するアカウントNO。
     * @param memberAccount The value of the column 'MEMBER_ACCOUNT'. (basically NotNull if update: for the constraint)
     */
    public void setMemberAccount(String memberAccount) {
        registerModifiedProperty("memberAccount");
        _memberAccount = memberAccount;
    }

    /**
     * [get] (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to member_status, classification=MemberStatus} <br />
     * @return The value of the column 'MEMBER_STATUS_CODE'. (basically NotNull if selected: for the constraint)
     */
    public String getMemberStatusCode() {
        checkSpecifiedProperty("memberStatusCode");
        return convertEmptyToNull(_memberStatusCode);
    }

    /**
     * [set] (会員ステータスコード)MEMBER_STATUS_CODE: {IX, NotNull, CHAR(3), FK to member_status, classification=MemberStatus} <br />
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    protected void setMemberStatusCode(String memberStatusCode) {
        registerModifiedProperty("memberStatusCode");
        _memberStatusCode = memberStatusCode;
    }

    /**
     * [get] (正式会員日時)FORMALIZED_DATETIME: {IX, DATETIME(19)} <br />
     * 会員が正式に確定した日時。一度確定したら更新されない。<br />
     * 仮会員のときはnull。
     * @return The value of the column 'FORMALIZED_DATETIME'. (NullAllowed even if selected: for no constraint)
     */
    public java.sql.Timestamp getFormalizedDatetime() {
        checkSpecifiedProperty("formalizedDatetime");
        return _formalizedDatetime;
    }

    /**
     * [set] (正式会員日時)FORMALIZED_DATETIME: {IX, DATETIME(19)} <br />
     * 会員が正式に確定した日時。一度確定したら更新されない。<br />
     * 仮会員のときはnull。
     * @param formalizedDatetime The value of the column 'FORMALIZED_DATETIME'. (NullAllowed: null update allowed for no constraint)
     */
    public void setFormalizedDatetime(java.sql.Timestamp formalizedDatetime) {
        registerModifiedProperty("formalizedDatetime");
        _formalizedDatetime = formalizedDatetime;
    }

    /**
     * [get] (生年月日)BIRTHDATE: {DATE(10)} <br />
     * 必須項目ではないので、このデータがない会員もいる。
     * @return The value of the column 'BIRTHDATE'. (NullAllowed even if selected: for no constraint)
     */
    public java.util.Date getBirthdate() {
        checkSpecifiedProperty("birthdate");
        return _birthdate;
    }

    /**
     * [set] (生年月日)BIRTHDATE: {DATE(10)} <br />
     * 必須項目ではないので、このデータがない会員もいる。
     * @param birthdate The value of the column 'BIRTHDATE'. (NullAllowed: null update allowed for no constraint)
     */
    public void setBirthdate(java.util.Date birthdate) {
        registerModifiedProperty("birthdate");
        _birthdate = birthdate;
    }

    /**
     * [get] (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)} <br />
     * レコードが登録された日時。共通カラムの一つ。
     * @return The value of the column 'REGISTER_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getRegisterDatetime() {
        checkSpecifiedProperty("registerDatetime");
        return _registerDatetime;
    }

    /**
     * [set] (登録日時)REGISTER_DATETIME: {NotNull, DATETIME(19)} <br />
     * レコードが登録された日時。共通カラムの一つ。
     * @param registerDatetime The value of the column 'REGISTER_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterDatetime(java.sql.Timestamp registerDatetime) {
        registerModifiedProperty("registerDatetime");
        _registerDatetime = registerDatetime;
    }

    /**
     * [get] (登録ユーザ)REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * レコードを登録したユーザ。共通カラムの一つ。
     * @return The value of the column 'REGISTER_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getRegisterUser() {
        checkSpecifiedProperty("registerUser");
        return convertEmptyToNull(_registerUser);
    }

    /**
     * [set] (登録ユーザ)REGISTER_USER: {NotNull, VARCHAR(200)} <br />
     * レコードを登録したユーザ。共通カラムの一つ。
     * @param registerUser The value of the column 'REGISTER_USER'. (basically NotNull if update: for the constraint)
     */
    public void setRegisterUser(String registerUser) {
        registerModifiedProperty("registerUser");
        _registerUser = registerUser;
    }

    /**
     * [get] (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)} <br />
     * レコードが（最後に）更新された日時。共通カラムの一つ。
     * @return The value of the column 'UPDATE_DATETIME'. (basically NotNull if selected: for the constraint)
     */
    public java.sql.Timestamp getUpdateDatetime() {
        checkSpecifiedProperty("updateDatetime");
        return _updateDatetime;
    }

    /**
     * [set] (更新日時)UPDATE_DATETIME: {NotNull, DATETIME(19)} <br />
     * レコードが（最後に）更新された日時。共通カラムの一つ。
     * @param updateDatetime The value of the column 'UPDATE_DATETIME'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateDatetime(java.sql.Timestamp updateDatetime) {
        registerModifiedProperty("updateDatetime");
        _updateDatetime = updateDatetime;
    }

    /**
     * [get] (更新ユーザ)UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * レコードを更新したユーザ。
     * @return The value of the column 'UPDATE_USER'. (basically NotNull if selected: for the constraint)
     */
    public String getUpdateUser() {
        checkSpecifiedProperty("updateUser");
        return convertEmptyToNull(_updateUser);
    }

    /**
     * [set] (更新ユーザ)UPDATE_USER: {NotNull, VARCHAR(200)} <br />
     * レコードを更新したユーザ。
     * @param updateUser The value of the column 'UPDATE_USER'. (basically NotNull if update: for the constraint)
     */
    public void setUpdateUser(String updateUser) {
        registerModifiedProperty("updateUser");
        _updateUser = updateUser;
    }

    /**
     * [get] (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)} <br />
     * レコードのバージョンを示すNO。<br />
     * 更新回数と等しく、主に排他制御のために利用される。
     * @return The value of the column 'VERSION_NO'. (basically NotNull if selected: for the constraint)
     */
    public Long getVersionNo() {
        checkSpecifiedProperty("versionNo");
        return _versionNo;
    }

    /**
     * [set] (バージョンNO)VERSION_NO: {NotNull, BIGINT(19)} <br />
     * レコードのバージョンを示すNO。<br />
     * 更新回数と等しく、主に排他制御のために利用される。
     * @param versionNo The value of the column 'VERSION_NO'. (basically NotNull if update: for the constraint)
     */
    public void setVersionNo(Long versionNo) {
        registerModifiedProperty("versionNo");
        _versionNo = versionNo;
    }

    /**
     * For framework so basically DON'T use this method.
     * @param memberStatusCode The value of the column 'MEMBER_STATUS_CODE'. (basically NotNull if update: for the constraint)
     */
    public void mynativeMappingMemberStatusCode(String memberStatusCode) {
        setMemberStatusCode(memberStatusCode);
    }
}
