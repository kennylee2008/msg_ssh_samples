package cn.com.leadfar.msg.dao;

import java.util.Collection;
import java.util.List;

import cn.com.leadfar.msg.model.User;

public interface UserDao {
	public User findByUsername(String username);
	
	/**
	 * 查询所有的用户，除了参数指定的用户之外！
	 * @param userId
	 * @return
	 */
	public List<User> findByUserId(int userId);
	
	/**
	 * 查询某个组（groupId）下面的所有用户，但不包括参数指定的用户（userId）
	 * @param groupId
	 * @param userId
	 * @return
	 */
	public List<User> findByGroupId(int groupId,int userId);
	
	/**
	 * 查询对应的用户名称列表
	 * @param userIds
	 * @return
	 */
	public List<String> findUsernamesByUserIds(Collection userIds);
	
	public void save(User user);
	
	public User findById(int userId);
}
