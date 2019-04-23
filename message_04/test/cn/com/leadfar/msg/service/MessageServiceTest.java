package cn.com.leadfar.msg.service;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractTransactionalJUnit38SpringContextTests;

import cn.com.leadfar.msg.model.Message;

@ContextConfiguration("classpath*:applicationContext-*.xml")
public class MessageServiceTest extends AbstractTransactionalJUnit38SpringContextTests {

	@Resource
	private MessageService ms;
	
	public void testFindSendMessages() {
		List<Message> msgs = ms.findSendMessages(1);
		for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
			Message m = (Message) iterator.next();
			System.out.println(m.getId()+","+m.getThread().getTitle()+
					","+m.getThread().getSenderName()+","+
					m.getThread().getReceiverNames()
					);
		}
	}

	public void testFindReceiveMessages() {
		List<Message> msgs = ms.findReceiveMessages(2);
		for (Iterator iterator = msgs.iterator(); iterator.hasNext();) {
			Message m = (Message) iterator.next();
			System.out.println(m.getId()+","+m.getThread().getTitle()+
					","+m.getThread().getSenderName()+","+
					m.getThread().getReceiverNames()
					);
		}
	}

	public void testFindDeletedMessages() {
		fail("Not yet implemented");
	}

	@Rollback(false)
	public void testReadMessage() {
		try {
			Message m = ms.readMessage(7);
			System.out.println(m.getId()+","+m.getThread().getTitle()+
					","+m.getThread().getSenderName()+","+
					m.getThread().getReceiverNames()
					);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} 
	}

	@Rollback(false)
	public void testSendMessage() {
		ms.sendMessage("测试消息"+r(), "消息内容"+r(), 1, new int[]{2,3,4});
	}

	@Rollback(false)
	public void testDeleteMessage() {
		ms.deleteMessage(5);
	}

	@Rollback(false)
	public void testDeleteRealMessage() {
		ms.deleteRealMessage(8);
	}
	
	private int r(){
		return new Random().nextInt(99999999);
	}

}
