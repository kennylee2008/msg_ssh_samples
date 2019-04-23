package cn.com.leadfar.msg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.com.leadfar.msg.dao.MessageDao;
import cn.com.leadfar.msg.model.DeletedMessage;
import cn.com.leadfar.msg.model.ReceiveMessage;
import cn.com.leadfar.msg.model.SendMessage;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDao implements MessageDao {

	@Override
	public void delDeletedMessage(int deletedMessageId) {
		Session session = getSession();
		session.delete(session.load(DeletedMessage.class, deletedMessageId));
	}

	@Override
	public void delReceiveMessage(int receiveMessageId) {
		Session session = getSession();
		session.delete(session.load(ReceiveMessage.class, receiveMessageId));
	}

	@Override
	public void delSendMessage(int sendMessageId) {
		Session session = getSession();
		session.delete(session.load(SendMessage.class, sendMessageId));
	}

	@Override
	public List<DeletedMessage> findDeletedMessagesByOwnerId(int ownerId) {
		
		String hql = "select m from DeletedMessage m where m.owner.id = ?";
		
		return getSession().createQuery(hql).setParameter(0, ownerId).list();
	}

	@Override
	public ReceiveMessage findReceiveMessageById(int receiveMessageId) {
		return (ReceiveMessage)getSession().load(ReceiveMessage.class, receiveMessageId);
	}

	@Override
	public SendMessage findSendMessageById(int sendMessageId) {
		return (SendMessage)getSession().load(SendMessage.class, sendMessageId);
	}

	@Override
	public List<ReceiveMessage> findReceiveMessagesByReceiverId(int receiverId) {
		String hql = "select m from ReceiveMessage m where m.receiver.id = ?";
		
		return getSession().createQuery(hql).setParameter(0, receiverId).list();
	}

	@Override
	public List<SendMessage> findSendMessagesBySenderId(int senderId) {
		String hql = "select m from SendMessage m where m.sender.id = ?";
		
		return getSession().createQuery(hql).setParameter(0, senderId).list();
	}

	@Override
	public void saveDeletedMessage(DeletedMessage deletedMessage) {
		getSession().save(deletedMessage);
	}

	@Override
	public void saveReceiveMessage(ReceiveMessage receiveMessage) {
		getSession().save(receiveMessage);
	}

	@Override
	public void saveSendMessage(SendMessage sendMsg) {
		getSession().save(sendMsg);
	}

}
