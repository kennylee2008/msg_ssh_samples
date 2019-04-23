package cn.com.leadfar.msg.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.msg.model.Message;
import cn.com.leadfar.msg.model.User;
import cn.com.leadfar.msg.service.MessageService;
import cn.com.leadfar.msg.service.UserService;

import com.opensymphony.xwork2.ActionContext;

@Controller("messageAction")
@Scope("prototype")
public class MessageAction {
	
	private int id;
	private String title;
	private String content;
	private int[] receiverIds;
	
	@Resource
	private MessageService messageService;
	
	@Resource
	private UserService userService;
	
	public String outbox(){
		
		List<Message> msgs = messageService.findSendMessages(currentUser().getId());
		
		ActionContext.getContext().put("msgs", msgs);
		
		return "outbox";
	}
	
	public String inbox(){
		List<Message> msgs = messageService.findReceiveMessages(currentUser().getId());
		
		ActionContext.getContext().put("msgs", msgs);
		return "inbox";
	}
	
	public String trash(){
		List<Message> msgs = messageService.findDeletedMessages(currentUser().getId());
		
		ActionContext.getContext().put("msgs", msgs);
		return "trash";
	}
	
	public String sendInput(){
		
		List<User> users = userService.findUsersExcludeUser(currentUser().getId());
		
		ActionContext.getContext().put("users", users);
		
		return "send_input";
	}
	
	public String send(){
		messageService.sendMessage(title, content, currentUser().getId(), receiverIds);
		return "send_success";
	}
	
	public String del(){
		messageService.deleteMessage(id);
		return "del_success";
	}
	
	public String delReal(){
		messageService.deleteRealMessage(id);
		return "del_success";
	}
	
	public String detail(){
		
		Message m = messageService.readMessage(id);
		
		ActionContext.getContext().put("m", m);
		
		return "detail";
	}
	
	private User currentUser(){
		return (User)ActionContext.getContext().getSession().get("login");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int[] getReceiverIds() {
		return receiverIds;
	}

	public void setReceiverIds(int[] receiverIds) {
		this.receiverIds = receiverIds;
	}
}
