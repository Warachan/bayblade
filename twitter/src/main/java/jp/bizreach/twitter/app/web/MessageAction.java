package jp.bizreach.twitter.app.web;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import jp.bizreach.twitter.dbflute.cbean.MemberCB;
import jp.bizreach.twitter.dbflute.cbean.MessageCB;
import jp.bizreach.twitter.dbflute.exbhv.MemberBhv;
import jp.bizreach.twitter.dbflute.exbhv.MessageBhv;
import jp.bizreach.twitter.dbflute.exentity.Member;
import jp.bizreach.twitter.dbflute.exentity.Message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

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
    protected MemberBhv memberBhv;
    @Resource
    protected MessageBhv messageBhv;
    @Resource
    protected PassDigestLogic passDigestLogic;
    @Resource
    protected HttpServletRequest request;
    // -----------------------------------------------------
    //                                          Display Data
    //                                          ------------
    //public ArrayList<MessageDto> messageList = new ArrayList<>();
    public ArrayList<MessageDto> sentMessageList = new ArrayList<>();
    public ArrayList<MessageDto> receiveMessageList = new ArrayList<>();
    public Integer memberId;
    public String noMessages;
    public String noSentMessages;

    // TODO mayuko.sakaba  返信機能は難しくてまだつけれていないです。代わりに各メッセージ一覧を表示しています。
    // ===================================================================================
    //                                                                             Execute
    //                                                                             =======
    @Execute(validator = false, urlPattern = "{receiver}")
    public String index() {
        TokenProcessor.getInstance().saveToken(request);
        MemberCB memberCb = new MemberCB();
        memberCb.query().setUserName_Equal(messageForm.receiver);
        Member member = memberBhv.selectEntity(memberCb);
        Integer memberId = member.getMemberId();

        /* 相手からメッセージ一覧を表示する　*/
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
        /* 自分からのメッセージ一覧を表示する　*/
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
        if (sentMessageList.isEmpty()) {
            noSentMessages = "No Messages yet";
        }
        if (receiveMessageList.isEmpty()) {
            noMessages = "No Messages yet";
        }
        return "/message.jsp";
    }

    @Execute(validate = "validate", input = "/message/.jsp")
    public String editMessage() {
        if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
            throw new ActionMessagesException("不正なリクエストです", false);
        }
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
        return "/message/" + messageForm.receiver + "/?redirect=true";
    }

    public ActionMessages validate() {
        ActionMessages errors = new ActionMessages();
        if (messageForm.message.length() > 200) {
            errors.add("message", new ActionMessage("文字制限を超えています。", false));
        }
        return errors;
    }
}
