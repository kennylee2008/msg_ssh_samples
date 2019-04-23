package cn.com.leadfar.msg.service;

import java.util.Collection;
import java.util.List;

import cn.com.leadfar.msg.model.User;

public interface UserService {
	public User login(String username,String password);
	
	/**
	 * ��ѯ������userId���ڵ������û����б�
	 * @param userId
	 * @return
	 */
	public List<User> findAllUsers(int userId);
	
	/**
	 * ��ѯĳ���飨groupId������������û���������������ָ�����û���userId��
	 * @param groupId
	 * @param senderId
	 * @return
	 */
	public List<User> findUsersByGroup(int groupId,int senderId);
	
	/**
	 * ��ѯ��Ӧ���û������б�
	 * @param userId
	 * @return
	 */
	public List<String> findUsernamesByUserIds(Collection userIds);
	
	public void addUser(User user);
	
	public User findUserById(int userId);
}
