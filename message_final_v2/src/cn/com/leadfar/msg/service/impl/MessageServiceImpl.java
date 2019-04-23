package cn.com.leadfar.msg.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leadfar.msg.dao.MessageDao;
import cn.com.leadfar.msg.model.DeletedMessage;
import cn.com.leadfar.msg.model.ReceiveMessage;
import cn.com.leadfar.msg.model.Message;
import cn.com.leadfar.msg.model.User;
import cn.com.leadfar.msg.service.MessageService;
import cn.com.leadfar.msg.service.UserService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Resource
	private UserService userService;
	
	@Resource
	private MessageDao messageDao;
	
	@Override
	public void delDeletedMessage(int deletedMessageId) {
		messageDao.delDeletedMessage(deletedMessageId);
	}

	@Override
	public void delReceiveMessage(int receiveMessageId) {
		
		ReceiveMessage rm = messageDao.findReceiveMessageById(receiveMessageId);
	
		//添加DeletedMessage对象
		DeletedMessage dm = new DeletedMessage();
		dm.setTitle(rm.getTitle());
		dm.setContent(rm.getContent());
		dm.setDeletedTime(new Date());
		dm.setOwner(rm.getReceiver());
		dm.setReceiverNames(rm.getReceiver().getUsername());
		dm.setSenderName(rm.getSenderName());
		dm.setSendTime(rm.getReceiveTime());
		messageDao.saveDeletedMessage(dm);
		
		//删除消息
		messageDao.delReceiveMessage(receiveMessageId);
	}

	@Override
	public void delSendMessage(int sendMessageId) {

		Message sm = messageDao.findSendMessageById(sendMessageId);
	
		//添加DeletedMessage对象
		DeletedMessage dm = new DeletedMessage();
		dm.setTitle(sm.getTitle());
		dm.setContent(sm.getContent());
		dm.setDeletedTime(new Date());
		dm.setOwner(sm.getSender());
		dm.setReceiverNames(sm.getReceiveNames());
		dm.setSenderName(sm.getSender().getUsername());
		dm.setSendTime(sm.getSendTime());
		messageDao.saveDeletedMessage(dm);
		
		//删除消息
		messageDao.delSendMessage(sendMessageId);
	}

	@Override
	public List<DeletedMessage> findDeletedMessagesByOwnerId(int ownerId) {
		return messageDao.findDeletedMessagesByOwnerId(ownerId);
	}

	@Override
	public int findUnreadedMessages(int receiverId) {
		return messageDao.findUnreadedMessages(receiverId);
	}

	@Override
	public ReceiveMessage updateFindReceiveMessageById(int receiveMessageId) {
		ReceiveMessage rm = messageDao.findReceiveMessageById(receiveMessageId);
		rm.setHasRead(true);
		return rm;
	}

	@Override
	public List<ReceiveMessage> findReceiveMessagesByReceiverId(int receiverId) {
		return messageDao.findReceiveMessagesByReceiverId(receiverId);
	}

	@Override
	public List<Message> findSendMessagesBySenderId(int senderId) {
		return messageDao.findSendMessagesBySenderId(senderId);
	}

	@Override
	public void sendMessage(String title, String content, int senderId,
			int[] receiverIds, int groupId) {
		
		Map allReceiverIds = new HashMap();
		
		List<User> receivers = userService.findUsersByGroup(groupId, senderId);
		for(User u:receivers){
			allReceiverIds.put(u.getId(),null);
		}
		
		if(receiverIds != null){
			for(int id:receiverIds){
				allReceiverIds.put(id,null);
			}
		}
		
		//所有接收者ID列表
		Set recs = allReceiverIds.keySet();
		
		//得到所有接收者的姓名
		List<String> receiverNames = userService.findUsernamesByUserIds(recs);
		
		//创建SendMessage对象
		Message sm = new Message();
		sm.setTitle(title);
		sm.setContent(content);
		sm.setReceiveNames(receiverNames.toString());
		User sender = userService.findUserById(senderId);
		sm.setSender(sender);
		sm.setSendTime(new Date());
		messageDao.saveSendMessage(sm);
		
		//创建系列ReceiveMessage对象
		for (Iterator iterator = recs.iterator(); iterator.hasNext();) {
			Integer receiverId = (Integer) iterator.next();
			
			ReceiveMessage rm = new ReceiveMessage();
			rm.setTitle(title);
			rm.setContent(content);
			rm.setHasRead(false);
			rm.setReceiver(userService.findUserById(receiverId));
			rm.setReceiveTime(new Date());
			rm.setSenderName(sender.getUsername());
			
			messageDao.saveReceiveMessage(rm);
		}
	}

}
