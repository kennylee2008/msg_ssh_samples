package cn.com.leadfar.msg.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class MessageServiceTest extends TestCase {

	public void testSendMessage() {
		BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		MessageService ms = (MessageService)factory.getBean("messageService");
		
		ms.sendMessage("测试消息", "世界，你好", 1, new int[]{2,3,4,5}, 0);
		
	}

	public void testDelSendMessage() {
		fail("Not yet implemented");
	}

	public void testDelReceiveMessage() {
		fail("Not yet implemented");
	}

	public void testDelDeletedMessage() {
		fail("Not yet implemented");
	}

	public void testFindSendMessagesBySenderId() {
		fail("Not yet implemented");
	}

	public void testFindReceiveMessagesByReceiverId() {
		fail("Not yet implemented");
	}

	public void testFindDeletedMessagesByOwnerId() {
		fail("Not yet implemented");
	}

	public void testUpdateFindReceiveMessageById() {
		fail("Not yet implemented");
	}

}
