package cn.com.leadfar.msg.model;

import java.util.Set;

public class User {
	private int id;
	private String username;
	private String password;

	private Set<Message> sendMessages;
	
	private Set<Message> deletedMessages;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Message> getSendMessages() {
		return sendMessages;
	}
	public void setSendMessages(Set<Message> sendMessages) {
		this.sendMessages = sendMessages;
	}
	public Set<Message> getDeletedMessages() {
		return deletedMessages;
	}
	public void setDeletedMessages(Set<Message> deletedMessages) {
		this.deletedMessages = deletedMessages;
	}

}
