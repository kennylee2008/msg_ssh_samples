package cn.com.leadfar.msg.model;

import java.util.Date;

public class SendMessage {
	private int id;
	private String title;
	private String content;
	private Date sendTime;
	private String receiveNames;
	private User sender;
	
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
	public String getReceiveNames() {
		return receiveNames;
	}
	public void setReceiveNames(String receiveNames) {
		this.receiveNames = receiveNames;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
}
