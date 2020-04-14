package com.springdata.restApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springdata.restApi.json.Advertisement;
import com.springdata.restApi.json.User;

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
	
	public MessageEntity() {
		super();
		
	}
	public MessageEntity(long id, String message, UserEntity userSendingMessage, AdvertisementEntity forAdvertisement) {
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
		return "Message [id=" + id + ", message=" + message + ", userSendingMessage=" + userSendingMessage.getUserName()
				+ ", forAdvertisement=" + forAdvertisement.getName() + "]";
	}
	
}
