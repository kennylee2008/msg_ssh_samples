package cn.com.leadfar.msg.dao;

import java.util.List;

import cn.com.leadfar.msg.model.Group;

public interface GroupDao {
	public List<Group> findAll();
	public void save(Group g);
	public void update(Group g);
	public void delete(int gid);
	public Group findById(int gid);
}
