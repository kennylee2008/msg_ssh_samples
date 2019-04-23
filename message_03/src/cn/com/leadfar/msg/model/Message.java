package cn.com.leadfar.msg.model;

public class Message {
	private int id;
	private boolean deleted;
	private User owner;
	private MessageThread thread;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public MessageThread getThread() {
		return thread;
	}
	public void setThread(MessageThread thread) {
		this.thread = thread;
	}
}
