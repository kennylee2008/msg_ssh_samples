package cn.com.leadfar.msg.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.leadfar.msg.dao.InitDao;
import cn.com.leadfar.msg.service.InitService;

@Service("initService")
public class InitServiceImpl implements InitService {

	@Resource
	private InitDao initDao;
	
	@Override
	public void addInitDatas() {
		initDao.addInitDatas();
	}

}
