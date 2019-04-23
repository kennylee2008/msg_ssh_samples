package cn.com.leadfar.msg.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.msg.dao.InitDao;
import cn.com.leadfar.msg.model.Group;
import cn.com.leadfar.msg.model.User;

@Repository("initDao")
public class InitDaoImpl extends BaseDao implements InitDao {

	@Override
	public void addInitDatas() {
		
		//删除所有消息
		getSession().createQuery("delete ReceiveMessage")
			.executeUpdate();
		getSession().createQuery("delete SendMessage")
		.executeUpdate();
		getSession().createQuery("delete DeletedMessage")
		.executeUpdate();
	
		
		//删除所有用户
		getSession().createQuery("delete User")
			.executeUpdate();
		
		//删除所有的组
		getSession().createQuery("delete Group")
			.executeUpdate();
		
		Group g1 = new Group();
		g1.setName("OA项目组");
		getSession().save(g1);
		
		Group g2 = new Group();
		g2.setName("CRM项目组");
		getSession().save(g2);
		
		Group g3 = new Group();
		g3.setName("ERP项目组");
		getSession().save(g3);
		
		User u = new User();
		u.setUsername("张三");
		u.setPassword("1");
		u.setGroup(g1);
		getSession().save(u);
		
		u = new User();
		u.setUsername("李四");
		u.setPassword("1");
		u.setGroup(g1);
		getSession().save(u);
		
		u = new User();
		u.setUsername("王五");
		u.setPassword("1");
		u.setGroup(g1);
		getSession().save(u);
		
		u = new User();
		u.setUsername("赵毅");
		u.setPassword("1");
		u.setGroup(g2);
		getSession().save(u);
		
		u = new User();
		u.setUsername("陈思");
		u.setPassword("1");
		u.setGroup(g2);
		getSession().save(u);
		
		u = new User();
		u.setUsername("刘备");
		u.setPassword("1");
		u.setGroup(g3);
		getSession().save(u);
		
		u = new User();
		u.setUsername("诸葛亮");
		u.setPassword("1");
		u.setGroup(g3);
		getSession().save(u);
	}

}
