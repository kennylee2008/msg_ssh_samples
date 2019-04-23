package cn.com.leadfar.msg.model;

import java.util.Date;

public class DeletedMessage {
	private int id;
	private String title;
	private String content;
	private Date deletedTime;
	private Date sendTime;
	private String senderName;
	private String receiverNames;
	private User owner;
	
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
	public Date getDeletedTime() {
		return deletedTime;
	}
	public void setDeletedTime(Date deletedTime) {
		this.deletedTime = deletedTime;
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
	public String getReceiverNames() {
		return receiverNames;
	}
	public void setReceiverNames(String receiverNames) {
		this.receiverNames = receiverNames;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
}
