package cn.com.leadfar.msg.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import cn.com.leadfar.msg.dao.GroupDao;
import cn.com.leadfar.msg.model.Group;

@Repository("groupDao")
public class GroupDaoImpl extends BaseDao implements GroupDao {

	@Override
	public void delete(int gid) {
		Session session = getSession();
		session.delete(findById(gid));
	}

	@Override
	public List<Group> findAll() {
		Session session = getSession();
		return session.createQuery("from Group").list();
	}

	@Override
	public Group findById(int gid) {
		Session session = getSession();
		return (Group)session.load(Group.class, gid);
	}

	@Override
	public void save(Group g) {
		Session session = getSession();
		session.save(g);
	}

	@Override
	public void update(Group g) {
		Session session = getSession();
		session.update(g);
	}

}
