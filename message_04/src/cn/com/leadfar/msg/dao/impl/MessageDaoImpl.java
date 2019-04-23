package cn.com.leadfar.msg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.msg.dao.MessageDao;
import cn.com.leadfar.msg.model.Message;

@Repository("messageDao")
public class MessageDaoImpl extends BaseDaoImpl implements MessageDao {

	@Override
	public List<Message> findDeletedMessages(int ownerId) {
		String hql = "select m from Message m where m.deleted = ? and m.owner.id = ?";
		return getSession().createQuery(hql).setParameter(0, true)
			.setParameter(1, ownerId).list();
	}

	@Override
	public List<Message> findReceiveMessages(int receiverId) {
		String hql = "select m from ReceiveMessage m where m.deleted = false" +
				" and m.owner.id = ?";
		return getSession().createQuery(hql).setParameter(0, receiverId).list();
	}

	@Override
	public List<Message> findSendMessages(int senderId) {
		String hql = "select m from SendMessage m where m.deleted = false and m.owner.id = ?";
		return getSession().createQuery(hql).setParameter(0, senderId).list();
	}

}
