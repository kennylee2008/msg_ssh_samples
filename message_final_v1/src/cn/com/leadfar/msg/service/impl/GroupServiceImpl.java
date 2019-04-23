package cn.com.leadfar.msg.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leadfar.msg.dao.GroupDao;
import cn.com.leadfar.msg.model.Group;
import cn.com.leadfar.msg.service.GroupService;

@Service("groupService")
public class GroupServiceImpl implements GroupService {

	@Resource
	private GroupDao groupDao;
	
	@Override
	public void addGroup(Group g) {
		groupDao.save(g);
	}

	@Override
	public List<Group> findAllGroups() {
		return groupDao.findAll();
	}

}
