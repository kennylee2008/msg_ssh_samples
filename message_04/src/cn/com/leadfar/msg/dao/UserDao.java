package cn.com.leadfar.msg.dao;

import java.util.List;

import cn.com.leadfar.msg.model.User;

public interface UserDao extends BaseDao {
	public User findByUsername(String username);
	public List<User> findUsersExcludeUser(int userId);
}
