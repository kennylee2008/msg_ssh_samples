package cn.com.leadfar.msg.service;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.leadfar.msg.model.Group;
import cn.com.leadfar.msg.model.User;

public class UserServiceTest extends TestCase {
	
	public void testAddUsersAndGroup(){
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		UserService us = (UserService)factory.getBean("userService");
		
		for(int i=1; i<4; i++){
			Group g = new Group();
			g.setId(i);
			
			for(int j=0; j<8; j++){
				
				User u = new User();
				u.setUsername("组"+i+"下的用户"+j);
				u.setPassword("1");
				u.setGroup(g);
				
				us.addUser(u);
			}
		}
	}
}
