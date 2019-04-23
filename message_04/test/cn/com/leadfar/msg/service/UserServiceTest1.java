package cn.com.leadfar.msg.service;

import javax.annotation.Resource;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;

import cn.com.leadfar.msg.model.User;

@ContextConfiguration("classpath*:applicationContext-*.xml")
public class UserServiceTest1 extends AbstractTransactionalJUnit38SpringContextTests {

	@Resource
	private UserService us;
	
	/**
	 * Ĭ�ϱ��������ع�����
	 */
	@Rollback(false) //������ִ�����֮�󣬲��ع���
	public void testSaveUser() {
		
		for(int i=1; i<10; i++){
			User u = new User();
			u.setUsername("u"+i);
			u.setPassword("1");
			us.addUser(u);
		}
		
	}

}
