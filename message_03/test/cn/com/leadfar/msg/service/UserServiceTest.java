package cn.com.leadfar.msg.service;

import junit.framework.TestCase;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.leadfar.msg.model.User;

public class UserServiceTest extends TestCase {

	public void testSaveUser() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		UserService us = factory.getBean(UserService.class);
		
		for(int i=1; i<10; i++){
			User u = new User();
			u.setUsername("u"+i);
			u.setPassword("1");
			us.addUser(u);
		}
		
	}

}
