package cn.com.leadfar.msg.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.msg.dao.UserDao;
import cn.com.leadfar.msg.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	public User findByUsername(String username) {
		String hql = "select u from User u where u.username = ?";
		return (User)getSession().createQuery(hql)
			.setParameter(0, username).uniqueResult();
	}

	@Override
	public List<User> findUsersExcludeUser(int userId) {
		String hql = "select u from User u where u.id != ?";
		return getSession().createQuery(hql).setParameter(0, userId).list();
	}

}
