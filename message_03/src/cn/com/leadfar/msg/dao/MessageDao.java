package cn.com.leadfar.msg.dao;

import java.util.List;

import cn.com.leadfar.msg.model.Message;

public interface MessageDao extends BaseDao {
	public List<Message> findSendMessages(int senderId);
	public List<Message> findReceiveMessages(int receiverId);
	public List<Message> findDeletedMessages(int ownerId);
}
