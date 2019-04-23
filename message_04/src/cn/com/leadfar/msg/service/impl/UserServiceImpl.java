package cn.com.leadfar.msg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leadfar.msg.dao.UserDao;
import cn.com.leadfar.msg.model.User;
import cn.com.leadfar.msg.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> findUsersExcludeUser(int userId) {
		return userDao.findUsersExcludeUser(userId);
	}

	@Override
	public User validateUser(String username, String password) {
		
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new RuntimeException("用户["+username+"]不存在");
		}
		
		if(!user.getPassword().equals(password)){
			throw new RuntimeException("密码错误");
		}
		
		return user;
	}

}
