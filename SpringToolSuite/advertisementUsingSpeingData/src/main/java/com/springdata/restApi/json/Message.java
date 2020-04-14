package com.springdata.restApi.json;

public class Message {
	private long id;
	private String message;
	private User userSendingMessage;
	private Advertisement forAdvertisement;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(long id, String message, User userSendingMessage, Advertisement forAdvertisement) {
		super();
		this.id = id;
		this.message = message;
		this.userSendingMessage = userSendingMessage;
		this.forAdvertisement = forAdvertisement;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUserSendingMessage() {
		return userSendingMessage;
	}
	public void setUserSendingMessage(User userSendingMessage) {
		this.userSendingMessage = userSendingMessage;
	}
	public Advertisement getForAdvertisement() {
		return forAdvertisement;
	}
	public void setForAdvertisement(Advertisement forAdvertisement) {
		this.forAdvertisement = forAdvertisement;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", userSendingMessage=" + userSendingMessage.getUserName()
				+ ", forAdvertisement=" + forAdvertisement.getName() + "]";
	}
	
	
}
