package cn.com.leadfar.msg.service;

import java.util.List;

import cn.com.leadfar.msg.model.Message;

public interface MessageService {
	public List<Message> findSendMessages(int senderId);
	public List<Message> findReceiveMessages(int receiverId);
	public List<Message> findDeletedMessages(int ownerId);
	public Message readMessage(int messageId);
	public void sendMessage(String title,String content,int senderId,int[] receiverIds);
	public void deleteMessage(int messageId);
	public void deleteRealMessage(int messageId);
}
