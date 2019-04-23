package cn.com.leadfar.msg.dao.impl;

import org.springframework.stereotype.Repository;

import cn.com.leadfar.msg.dao.InitDao;
import cn.com.leadfar.msg.model.Group;
import cn.com.leadfar.msg.model.User;

@Repository("initDao")
public class InitDaoImpl extends BaseDao implements InitDao {

	@Override
	public void addInitDatas() {
		
		//ɾ��������Ϣ
		getSession().createQuery("delete ReceiveMessage")
			.executeUpdate();
		getSession().createQuery("delete SendMessage")
		.executeUpdate();
		getSession().createQuery("delete DeletedMessage")
		.executeUpdate();
	
		
		//ɾ�������û�
		getSession().createQuery("delete User")
			.executeUpdate();
		
		//ɾ�����е���
		getSession().createQuery("delete Group")
			.executeUpdate();
		
		Group g1 = new Group();
		g1.setName("OA��Ŀ��");
		getSession().save(g1);
		
		Group g2 = new Group();
		g2.setName("CRM��Ŀ��");
		getSession().save(g2);
		
		Group g3 = new Group();
		g3.setName("ERP��Ŀ��");
		getSession().save(g3);
		
		User u = new User();
		u.setUsername("����");
		u.setPassword("1");
		u.setGroup(g1);
		getSession().save(u);
		
		u = new User();
		u.setUsername("����");
		u.setPassword("1");
		u.setGroup(g1);
		getSession().save(u);
		
		u = new User();
		u.setUsername("����");
		u.setPassword("1");
		u.setGroup(g1);
		getSession().save(u);
		
		u = new User();
		u.setUsername("����");
		u.setPassword("1");
		u.setGroup(g2);
		getSession().save(u);
		
		u = new User();
		u.setUsername("��˼");
		u.setPassword("1");
		u.setGroup(g2);
		getSession().save(u);
		
		u = new User();
		u.setUsername("����");
		u.setPassword("1");
		u.setGroup(g3);
		getSession().save(u);
		
		u = new User();
		u.setUsername("�����");
		u.setPassword("1");
		u.setGroup(g3);
		getSession().save(u);
	}

}
