package cn.com.leadfar.msg.service;

import java.util.List;

import cn.com.leadfar.msg.model.User;

public interface UserService {
	public void addUser(User user);
	public List<User> findUsersExcludeUser(int userId);
	public User validateUser(String username,String password);
}
