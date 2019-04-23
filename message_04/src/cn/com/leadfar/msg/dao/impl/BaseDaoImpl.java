package cn.com.leadfar.msg.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.com.leadfar.msg.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {

	@Resource
	private SessionFactory factory;
	
	@Override
	public void flush() {
		getSession().flush();
	}

	@Override
	public void del(Class entityClass, int id) {
		getSession().delete(findById(entityClass, id));
	}

	@Override
	public void del(Object entity) {
		getSession().delete(entity);
	}

	@Override
	public <T> List<T> findAll(Class<T> entityClass) {
		return getSession().createCriteria(entityClass).list();
	}

	@Override
	public <T> T findById(Class<T> entityClass, int id) {
		return (T)getSession().load(entityClass, id);
	}

	@Override
	public void save(Object entity) {
		getSession().save(entity);
	}

	@Override
	public void update(Object entity) {
		getSession().update(entity);
	}
	
	protected Session getSession(){
		return factory.getCurrentSession();
	}

}
