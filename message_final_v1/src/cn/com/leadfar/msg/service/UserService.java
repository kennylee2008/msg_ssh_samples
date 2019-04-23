package cn.com.leadfar.msg.service;

import java.util.Collection;
import java.util.List;

import cn.com.leadfar.msg.model.User;

public interface UserService {
	public User login(String username,String password);
	
	/**
	 * 查询不包括userId在内的所有用户的列表
	 * @param userId
	 * @return
	 */
	public List<User> findAllUsers(int userId);
	
	/**
	 * 查询某个组（groupId）下面的所有用户，但不包括参数指定的用户（userId）
	 * @param groupId
	 * @param senderId
	 * @return
	 */
	public List<User> findUsersByGroup(int groupId,int senderId);
	
	/**
	 * 查询对应的用户名称列表
	 * @param userId
	 * @return
	 */
	public List<String> findUsernamesByUserIds(Collection userIds);
	
	public void addUser(User user);
	
	public User findUserById(int userId);
}
