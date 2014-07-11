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
 * The entity of message as TABLE. <br />
 * メッセージテーブル
 * <pre>
 * [primary-key]
 *     MESSAGE_ID
 * 
 * [column]
 *     MESSAGE_ID, SENDER_ID, RECEIVER_ID, MESSAGE_TIME, MESSAGE, INS_DATETIME, UPD_DATETIME, INS_TRACE, UPD_TRACE
 * 
 * [sequence]
 *     
 * 
 * [identity]
 *     MESSAGE_ID
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
 *     memberBySenderId, memberByReceiverId
 * 
 * [referrer property]
 *     
 * 
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer messageId = entity.getMessageId();
 * Integer senderId = entity.getSenderId();
 * Integer receiverId = entity.getReceiverId();
 * String messageTime = entity.getMessageTime();
 * String message = entity.getMessage();
 * java.sql.Timestamp insDatetime = entity.getInsDatetime();
 * java.sql.Timestamp updDatetime = entity.getUpdDatetime();
 * String insTrace = entity.getInsTrace();
 * String updTrace = entity.getUpdTrace();
 * entity.setMessageId(messageId);
 * entity.setSenderId(senderId);
 * entity.setReceiverId(receiverId);
 * entity.setMessageTime(messageTime);
 * entity.setMessage(message);
 * entity.setInsDatetime(insDatetime);
 * entity.setUpdDatetime(updDatetime);
 * entity.setInsTrace(insTrace);
 * entity.setUpdTrace(updTrace);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsMessage implements Entity, Serializable, Cloneable {

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
    /** MESSAGE_ID: {PK, ID, NotNull, INT(10)} */
    protected Integer _messageId;

    /** SENDER_ID: {IX, NotNull, INT(10), FK to member} */
    protected Integer _senderId;

    /** RECEIVER_ID: {IX, NotNull, INT(10), FK to member} */
    protected Integer _receiverId;

    /** MESSAGE_TIME: {NotNull, VARCHAR(100)} */
    protected String _messageTime;

    /** MESSAGE: {NotNull, VARCHAR(255)} */
    protected String _message;

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
        return "message";
    }

    /**
     * {@inheritDoc}
     */
    public String getTablePropertyName() { // according to Java Beans rule
        return "message";
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
        if (getMessageId() == null) { return false; }
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
    /** member by my SENDER_ID, named 'memberBySenderId'. */
    protected Member _memberBySenderId;

    /**
     * [get] member by my SENDER_ID, named 'memberBySenderId'.
     * @return The entity of foreign property 'memberBySenderId'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMemberBySenderId() {
        return _memberBySenderId;
    }

    /**
     * [set] member by my SENDER_ID, named 'memberBySenderId'.
     * @param memberBySenderId The entity of foreign property 'memberBySenderId'. (NullAllowed)
     */
    public void setMemberBySenderId(Member memberBySenderId) {
        _memberBySenderId = memberBySenderId;
    }

    /** member by my RECEIVER_ID, named 'memberByReceiverId'. */
    protected Member _memberByReceiverId;

    /**
     * [get] member by my RECEIVER_ID, named 'memberByReceiverId'.
     * @return The entity of foreign property 'memberByReceiverId'. (NullAllowed: when e.g. null FK column, no setupSelect)
     */
    public Member getMemberByReceiverId() {
        return _memberByReceiverId;
    }

    /**
     * [set] member by my RECEIVER_ID, named 'memberByReceiverId'.
     * @param memberByReceiverId The entity of foreign property 'memberByReceiverId'. (NullAllowed)
     */
    public void setMemberByReceiverId(Member memberByReceiverId) {
        _memberByReceiverId = memberByReceiverId;
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
        if (obj == null || !(obj instanceof BsMessage)) { return false; }
        BsMessage other = (BsMessage)obj;
        if (!xSV(getMessageId(), other.getMessageId())) { return false; }
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
        hs = xCH(hs, getMessageId());
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
        if (_memberBySenderId != null)
        { sb.append(li).append(xbRDS(_memberBySenderId, "memberBySenderId")); }
        if (_memberByReceiverId != null)
        { sb.append(li).append(xbRDS(_memberByReceiverId, "memberByReceiverId")); }
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
        sb.append(dm).append(getMessageId());
        sb.append(dm).append(getSenderId());
        sb.append(dm).append(getReceiverId());
        sb.append(dm).append(getMessageTime());
        sb.append(dm).append(getMessage());
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
    protected String buildRelationString() {
        StringBuilder sb = new StringBuilder();
        String cm = ",";
        if (_memberBySenderId != null) { sb.append(cm).append("memberBySenderId"); }
        if (_memberByReceiverId != null) { sb.append(cm).append("memberByReceiverId"); }
        if (sb.length() > cm.length()) {
            sb.delete(0, cm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    /**
     * Clone entity instance using super.clone(). (shallow copy) 
     * @return The cloned instance of this entity. (NotNull)
     */
    public Message clone() {
        try {
            return (Message)super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Failed to clone the entity: " + toString(), e);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] MESSAGE_ID: {PK, ID, NotNull, INT(10)} <br />
     * メッセージID
     * @return The value of the column 'MESSAGE_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getMessageId() {
        return _messageId;
    }

    /**
     * [set] MESSAGE_ID: {PK, ID, NotNull, INT(10)} <br />
     * メッセージID
     * @param messageId The value of the column 'MESSAGE_ID'. (basically NotNull if update: for the constraint)
     */
    public void setMessageId(Integer messageId) {
        __modifiedProperties.addPropertyName("messageId");
        _messageId = messageId;
    }

    /**
     * [get] SENDER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * 送信者ID : メッセー送信する会員のID
     * @return The value of the column 'SENDER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getSenderId() {
        return _senderId;
    }

    /**
     * [set] SENDER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * 送信者ID : メッセー送信する会員のID
     * @param senderId The value of the column 'SENDER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setSenderId(Integer senderId) {
        __modifiedProperties.addPropertyName("senderId");
        _senderId = senderId;
    }

    /**
     * [get] RECEIVER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * 受信者ID : 受信する会員のID
     * @return The value of the column 'RECEIVER_ID'. (basically NotNull if selected: for the constraint)
     */
    public Integer getReceiverId() {
        return _receiverId;
    }

    /**
     * [set] RECEIVER_ID: {IX, NotNull, INT(10), FK to member} <br />
     * 受信者ID : 受信する会員のID
     * @param receiverId The value of the column 'RECEIVER_ID'. (basically NotNull if update: for the constraint)
     */
    public void setReceiverId(Integer receiverId) {
        __modifiedProperties.addPropertyName("receiverId");
        _receiverId = receiverId;
    }

    /**
     * [get] MESSAGE_TIME: {NotNull, VARCHAR(100)} <br />
     * 送信受信時間
     * @return The value of the column 'MESSAGE_TIME'. (basically NotNull if selected: for the constraint)
     */
    public String getMessageTime() {
        return _messageTime;
    }

    /**
     * [set] MESSAGE_TIME: {NotNull, VARCHAR(100)} <br />
     * 送信受信時間
     * @param messageTime The value of the column 'MESSAGE_TIME'. (basically NotNull if update: for the constraint)
     */
    public void setMessageTime(String messageTime) {
        __modifiedProperties.addPropertyName("messageTime");
        _messageTime = messageTime;
    }

    /**
     * [get] MESSAGE: {NotNull, VARCHAR(255)} <br />
     * message : メッセージ
     * @return The value of the column 'MESSAGE'. (basically NotNull if selected: for the constraint)
     */
    public String getMessage() {
        return _message;
    }

    /**
     * [set] MESSAGE: {NotNull, VARCHAR(255)} <br />
     * message : メッセージ
     * @param message The value of the column 'MESSAGE'. (basically NotNull if update: for the constraint)
     */
    public void setMessage(String message) {
        __modifiedProperties.addPropertyName("message");
        _message = message;
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
