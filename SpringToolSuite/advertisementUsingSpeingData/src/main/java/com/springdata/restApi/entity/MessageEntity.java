package com.springdata.restApi.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class MessageEntity {
	
	@Id
	@Column(name = "message_id")
	private long id;
	
	@Column(name = "message_content")
	private String message;
	
	@ManyToOne
	private UserEntity userSendingMessage;
	
	@ManyToOne
	private AdvertisementEntity forAdvertisement;
	
	@Column(name ="date_of_message")
	private LocalDateTime dateAndTimeOfMessage;
	
	public MessageEntity() {
		super();
		
	}
	public MessageEntity(long id, String message,LocalDateTime dateAndTimeOfMessage) {
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
	public UserEntity getUserSendingMessage() {
		return userSendingMessage;
	}
	public void setUserSendingMessage(UserEntity userSendingMessage) {
		this.userSendingMessage = userSendingMessage;
	}
	public AdvertisementEntity getForAdvertisement() {
		return forAdvertisement;
	}
	public void setForAdvertisement(AdvertisementEntity forAdvertisement) {
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
		MessageEntity other = (MessageEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MessageEntity [id=" + id + ", message=" + message + ", userSendingMessage=" + userSendingMessage
				+ ", forAdvertisement=" + forAdvertisement + ", dateAndTimeOfMessage=" + dateAndTimeOfMessage + "]";
	}
	
}
