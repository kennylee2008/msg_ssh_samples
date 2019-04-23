package cn.com.leadfar.msg.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.msg.dao.UserDao;
import cn.com.leadfar.msg.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public List<User> findByGroupId(int groupId, int userId) {
		
		String hql = "select u from User u where u.group.id = ? and u.id != ?";
		
		return getSession().createQuery(hql)
					.setParameter(0, groupId)
					.setParameter(1, userId)
					.list();
	}

	@Override
	public List<User> findByUserId(int userId) {
		String hql = "select u from User u where u.id != ?";
		return getSession().createQuery(hql)
				.setParameter(0, userId)
				.list();
	}

	@Override
	public User findByUsername(String username) {
		String hql = "select u from User u where u.username = ?";
		return (User)getSession().createQuery(hql).setParameter(0, username).uniqueResult();
	}

	@Override
	public List<String> findUsernamesByUserIds(Collection userIds) {
		String hql = "select u.username from User u where u.id in (:ids)";
		return getSession().createQuery(hql).setParameterList("ids", userIds).list();
	}

	@Override
	public void save(User user) {
		getSession().save(user);
	}

	@Override
	public User findById(int userId) {
		return (User)getSession().load(User.class, userId);
	}

}
