package cn.com.leadfar.msg.web.actions;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.com.leadfar.msg.service.GroupService;
import cn.com.leadfar.msg.service.MessageService;
import cn.com.leadfar.msg.service.UserService;

@Controller("messageAction")
@Scope("prototype")
public class MessageAction {
	
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
		return "send_input";
	}
	
	public String send(){
		return "send_success";
	}
	
	public String inbox(){
		return "inbox";
	}
	
	public String outbox(){
		return "outbox";
	}
	
	public String laji(){
		return "laji";
	}
	
	public String detail(){
		return "detail";
	}
	
	public String delInbox(){
		return "del_success";
	}
	
	public String delOutbox(){
		return "del_success";
	}
	
	public String delLaji(){
		return "del_success";
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
}
