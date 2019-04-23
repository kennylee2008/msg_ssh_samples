package cn.com.leadfar.msg.dao;

import java.util.List;

public interface BaseDao {
	public void save(Object entity);
	public void update(Object entity);
	public void del(Class entityClass,int id);
	public void del(Object entity);
	public <T> T findById(Class<T> entityClass,int id);
	public <T> List<T> findAll(Class<T> entityClass);
	public void flush();
}
