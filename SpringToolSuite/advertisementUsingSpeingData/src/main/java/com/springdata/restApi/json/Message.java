package com.springdata.restApi.json;

import java.time.LocalDateTime;

public class Message {
	private long id;
	private String message;
	private User userSendingMessage;
	private Advertisement forAdvertisement;
	private LocalDateTime dateAndTimeOfMessage;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(long id, String message,LocalDateTime dateAndTimeOfMessage) {
		super();
		this.id = id;
		this.message = message;
		this.dateAndTimeOfMessage=dateAndTimeOfMessage;
		
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
	
	
	public LocalDateTime getDateAndTimeOfMessage() {
		return dateAndTimeOfMessage;
	}
	public void setDateAndTimeOfMessage(LocalDateTime dateAndTimeOfMessage) {
		this.dateAndTimeOfMessage = dateAndTimeOfMessage;
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
		return "Message [id=" + id + ", message=" + message + ", userSendingMessage=" + userSendingMessage
				+ ", forAdvertisement=" + forAdvertisement + ", dateAndTimeOfMessage=" + dateAndTimeOfMessage + "]";
	}
	
	
}
