package cn.com.leadfar.msg.model;

import java.util.Date;
import java.util.Map;
import java.util.Set;

public class MessageThread {
	private int id;
	private String title;
	private String content;
	private Date sendTime;
	private String senderName;
	private Map<String,Boolean> receiverNames;
	private Set<Message> messages;
	
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
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public Map<String, Boolean> getReceiverNames() {
		return receiverNames;
	}
	public void setReceiverNames(Map<String, Boolean> receiverNames) {
		this.receiverNames = receiverNames;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
}
