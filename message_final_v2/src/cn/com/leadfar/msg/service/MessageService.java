package cn.com.leadfar.msg.service;

import java.util.List;

import cn.com.leadfar.msg.model.DeletedMessage;
import cn.com.leadfar.msg.model.ReceiveMessage;
import cn.com.leadfar.msg.model.Message;

public interface MessageService {
	public void sendMessage(String title,String content,int senderId,int[] receiverIds,int groupId);
	public void delSendMessage(int sendMessageId);
	public void delReceiveMessage(int receiveMessageId);
	public void delDeletedMessage(int deletedMessageId);
	public List<Message> findSendMessagesBySenderId(int senderId);
	public List<ReceiveMessage> findReceiveMessagesByReceiverId(int receiverId);
	public List<DeletedMessage> findDeletedMessagesByOwnerId(int ownerId);
	public ReceiveMessage updateFindReceiveMessageById(int receiveMessageId);
	public int findUnreadedMessages(int receiverId);
}
