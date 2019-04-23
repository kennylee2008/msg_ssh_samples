package cn.com.leadfar.msg.dao;

import java.util.List;

import cn.com.leadfar.msg.model.DeletedMessage;
import cn.com.leadfar.msg.model.ReceiveMessage;
import cn.com.leadfar.msg.model.Message;

public interface MessageDao {
	public void saveSendMessage(Message sendMsg);
	public void saveReceiveMessage(ReceiveMessage receiveMessage);
	public void saveDeletedMessage(DeletedMessage deletedMessage);
	public void delSendMessage(int sendMessageId);
	public void delReceiveMessage(int receiveMessageId);
	public void delDeletedMessage(int deletedMessageId);
	public List<Message> findSendMessagesBySenderId(int senderId);
	public List<ReceiveMessage> findReceiveMessagesByReceiverId(int receiverId);
	public List<DeletedMessage> findDeletedMessagesByOwnerId(int ownerId);
	public ReceiveMessage findReceiveMessageById(int receiveMessageId);
	public Message findSendMessageById(int sendMessageId);
	public int findUnreadedMessages(int receiverId);
}
