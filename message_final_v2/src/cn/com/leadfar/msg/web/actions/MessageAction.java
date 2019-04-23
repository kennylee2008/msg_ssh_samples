package cn.com.leadfar.msg.web.actions;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.msg.model.Group;
import cn.com.leadfar.msg.model.User;
import cn.com.leadfar.msg.service.GroupService;
import cn.com.leadfar.msg.service.MessageService;
import cn.com.leadfar.msg.service.UserService;

import com.opensymphony.xwork2.ActionContext;

@Controller("messageAction")
@Scope("prototype")
public class MessageAction {
	
	private int id;
	private String title;
	private String content;
	private int senderId;
	private int[] receiverIds;
	private int groupId;
	
	@Resource
	private MessageService messageService;
	
	@Resource
	private GroupService groupService;
	
	@Resource
	private UserService userService;
	
	public String index(){
		return "back_index";
	}
	
	public String sendInput(){
		
		List<User> users = userService.findAllUsers(getLoginUser().getId());
		
		ActionContext.getContext().put("users", users);
		
		List<Group> groups = groupService.findAllGroups();
		
		ActionContext.getContext().put("groups", groups);
		
		return "send_input";
	}
	
	public String send(){
		
		if((receiverIds == null || receiverIds.length == 0 ) && groupId == 0){
			throw new RuntimeException("您必须选择一个以上的接收者或接收组进行消息发送！");
		}
		
		messageService.sendMessage(title, content, getLoginUser().getId(), receiverIds, groupId);
		
		return "send_success";
	}
	
	public String inbox(){
		ActionContext.getContext().put(
				"msgs", 
				messageService.findReceiveMessagesByReceiverId(getLoginUser().getId())
		);
		
		return "inbox";
	}
	
	public String outbox(){
		ActionContext.getContext().put(
				"msgs", 
				messageService.findSendMessagesBySenderId(getLoginUser().getId())
		);
		return "outbox";
	}
	
	public String laji(){
		
		ActionContext.getContext().put(
				"msgs", 
				messageService.findDeletedMessagesByOwnerId(getLoginUser().getId())
		);
		
		return "laji";
	}
	
	public String detail(){
		
		ActionContext.getContext().put(
				"msg", 
				messageService.updateFindReceiveMessageById(id)
		);
		
		return "detail";
	}
	
	public String delInbox(){
		
		messageService.delReceiveMessage(id);
		
		return "del_success";
	}
	
	public String delOutbox(){
		
		messageService.delSendMessage(id);
		
		return "del_success";
	}
	
	public String delLaji(){
		
		messageService.delDeletedMessage(id);
		
		return "del_success";
	}
	
	public int getNewmsg(){
		return messageService.findUnreadedMessages(getLoginUser().getId());
	}
	
	protected User getLoginUser(){
		User current = (User)ServletActionContext.getRequest().getSession().getAttribute("login");
		if(current == null){
			throw new RuntimeException("您尚未登录！无法继续执行！");
		}
		return current;
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
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int[] getReceiverIds() {
		return receiverIds;
	}
	public void setReceiverIds(int[] receiverIds) {
		this.receiverIds = receiverIds;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
