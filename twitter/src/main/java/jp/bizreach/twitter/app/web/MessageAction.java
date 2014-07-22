package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.cbean.MessageCB;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.MessageBhv;
import jp.bizreach.twitter.dbflute.exentity.Member;
import jp.bizreach.twitter.dbflute.exentity.Message;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * @author mayuko.sakaba
 */
public class MessageAction {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========

    private static final Log LOG = LogFactory.getLog(IndexAction.class);
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // -----------------------------------------------------
    //                                          DI Component
    //                                          ------------
    @ActionForm
    @Resource
    protected MessageForm messageForm;
    @Resource
    public SessionDto sessionDto;
    @Resource
    protected PassDigestLogic passDigestLogic;
    @Resource
    protected MemberBhv memberBhv;
    @Resource
    protected MessageBhv messageBhv;
    //    @Resource
    //    protected HttpServletRequest request;
    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    public ArrayList<MessageDto> sentMessageList = new ArrayList<>();
    public ArrayList<MessageDto> receiveMessageList = new ArrayList<>();
    public Integer memberId;
    public String noMessages;
    public String noSentMessages;

    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false, urlPattern = "{receiver}")
    public String index() {
        //        TokenProcessor.getInstance().saveToken(request);
        /* メッセージやり取りしている相手を検索　*/
        MemberCB memberCb = new MemberCB();
        memberCb.query().setUserName_Equal(messageForm.receiver);
        Member member = memberBhv.selectEntity(memberCb);
        Integer memberId = member.getMemberId();

        receivedMessages(memberId);
        sentMessages(memberId);
        return "/message.jsp";
    }

    @Execute(validate = "validate", input = "/message/{receiver}/")
    // TODO mayuko.sakaba 頭の空文字を取る仕様をしてもいいかも？→時間切れ
    public String editMessage() {
        //        if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
        //            throw new ActionMessagesException("不正なリクエストです", false);
        //        }
        writeMessage();
        return "/message/" + messageForm.receiver + "/?redirect=true";
    }

    // ===================================================================================
    //                                                                    Extracted Method
    //                                                                            ========
    /* 相手からメッセージ一覧を表示する　*/
    private void receivedMessages(Integer memberId) {
        MessageCB messageCb = new MessageCB();
        messageCb.query().setSenderId_Equal(memberId);
        messageCb.query().setReceiverId_Equal(sessionDto.myId);
        messageCb.query().addOrderBy_MessageId_Desc();
        ListResultBean<Message> selectMessageList = messageBhv.selectList(messageCb);
        for (Message message : selectMessageList) {
            MessageDto messageDto = new MessageDto();
            messageDto.message = message.getMessage();
            messageDto.messageTime = message.getMessageTime();
            sentMessageList.add(messageDto);
        }
        if (sentMessageList.isEmpty()) {
            noSentMessages = "No Messages yet";
        }
    }

    /* 自分からのメッセージ一覧を表示する　*/
    private void sentMessages(Integer memberId) {
        MessageCB messageToCb = new MessageCB();
        messageToCb.query().setReceiverId_Equal(memberId);
        messageToCb.query().setSenderId_Equal(sessionDto.myId);
        messageToCb.query().addOrderBy_MessageId_Desc();
        ListResultBean<Message> messageToList = messageBhv.selectList(messageToCb);
        for (Message message : messageToList) {
            MessageDto messageDto = new MessageDto();
            messageDto.message = message.getMessage();
            messageDto.messageTime = message.getMessageTime();
            receiveMessageList.add(messageDto);
        }
        if (receiveMessageList.isEmpty()) {
            noMessages = "No Messages yet";
        }
    }

    /* メッセージを書く */
    private void writeMessage() {
        Date date = new Date();
        Timestamp messageTime = new Timestamp(date.getTime());
        String formatMessageTime = new SimpleDateFormat("MM月dd日 HH時mm分").format(messageTime);

        MemberCB memberCb = new MemberCB();
        memberCb.query().setUserName_Equal(messageForm.receiver);
        Member member = memberBhv.selectEntity(memberCb);

        Message message = new Message();
        message.setSenderId(sessionDto.myId);
        message.setReceiverId(member.getMemberId());
        message.setMessage(messageForm.message);
        message.setMessageTime(formatMessageTime);
        message.setInsDatetime(messageTime);
        message.setInsTrace(formatMessageTime);
        message.setUpdDatetime(messageTime);
        message.setUpdTrace(formatMessageTime);
        messageBhv.insert(message);
    }

    // ===================================================================================
    //                                                                          Validation
    //                                                                          ==========
    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        if (StringUtils.isEmpty(messageForm.message) || StringUtils.isWhitespace(messageForm.message)) {
            errors.add("message", new ActionMessage("何も入力されていません。", false));
        } else if (messageForm.message.length() >= 256) {
            errors.add("message", new ActionMessage("文字制限(255文字）を超えています。", false));
        }
        return errors;
    }
}
