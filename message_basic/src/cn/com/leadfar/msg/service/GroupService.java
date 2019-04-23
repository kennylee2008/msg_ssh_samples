package cn.com.leadfar.msg.service;

import java.util.List;

import cn.com.leadfar.msg.model.Group;

public interface GroupService {
	public List<Group> findAllGroups();
	public void addGroup(Group g);
}
