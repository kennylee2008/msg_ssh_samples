package cn.com.leadfar.msg.dao;

import java.util.Collection;
import java.util.List;

import cn.com.leadfar.msg.model.User;

public interface UserDao {
	public User findByUsername(String username);
	
	/**
	 * ��ѯ���е��û������˲���ָ�����û�֮�⣡
	 * @param userId
	 * @return
	 */
	public List<User> findByUserId(int userId);
	
	/**
	 * ��ѯĳ���飨groupId������������û���������������ָ�����û���userId��
	 * @param groupId
	 * @param userId
	 * @return
	 */
	public List<User> findByGroupId(int groupId,int userId);
	
	/**
	 * ��ѯ��Ӧ���û������б�
	 * @param userIds
	 * @return
	 */
	public List<String> findUsernamesByUserIds(Collection userIds);
	
	public void save(User user);
	
	public User findById(int userId);
}
