package cn.com.leadfar.msg.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leadfar.msg.dao.MessageDao;
import cn.com.leadfar.msg.dao.UserDao;
import cn.com.leadfar.msg.model.Message;
import cn.com.leadfar.msg.model.MessageThread;
import cn.com.leadfar.msg.model.ReceiveMessage;
import cn.com.leadfar.msg.model.SendMessage;
import cn.com.leadfar.msg.model.User;
import cn.com.leadfar.msg.service.MessageService;

@Service("messageService")
public class MessageServiceImpl implements MessageService {

	@Resource
	private MessageDao messageDao;
	
	@Resource
	private UserDao userDao;
	
	@Override
	public void deleteMessage(int messageId) {
		Message m = messageDao.findById(Message.class, messageId);
		m.setDeleted(true);
	}

	@Override
	public void deleteRealMessage(int messageId) {
		Message m = messageDao.findById(Message.class, messageId);
		MessageThread mt = m.getThread();
		messageDao.del(m);
		
		messageDao.flush();
		
		if(mt.getMessages().size() == 0){
			messageDao.del(mt);
		}
	}

	@Override
	public List<Message> findDeletedMessages(int ownerId) {
		return messageDao.findDeletedMessages(ownerId);
	}

	@Override
	public List<Message> findReceiveMessages(int receiverId) {
		return messageDao.findReceiveMessages(receiverId);
	}

	@Override
	public List<Message> findSendMessages(int senderId) {
		return messageDao.findSendMessages(senderId);
	}

	@Override
	public Message readMessage(int messageId) {
		Message m = messageDao.findById(Message.class, messageId);
		
		m.getThread().updateRecieverReaded(m.getOwner().getUsername());
		
		return m;
	}

	@Override
	public void sendMessage(String title, String content, int senderId,
			int[] receiverIds) {
		
		User sender = userDao.findById(User.class, senderId);
		
		//创建MessageThread对象
		MessageThread mt = new MessageThread();
		mt.setTitle(title);
		mt.setContent(content);
		mt.setSendTime(new Date());
		mt.setSenderName(sender.getUsername());
		
		//创建SendMessage对象
		SendMessage sm = new SendMessage();
		sm.setOwner(sender);
		mt.addMessage(sm);
		
		//创建ReceiveMessage对象
		for(int receiverId:receiverIds){
			User receiver = userDao.findById(User.class, receiverId);
			ReceiveMessage rm = new ReceiveMessage();
			rm.setOwner(receiver);
			mt.addMessage(rm);
		}
		
		messageDao.save(mt);
	}

}
