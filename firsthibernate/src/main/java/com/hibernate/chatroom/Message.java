package com.hibernate.chatroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Message")
public class Message {
	@Id
	@Column(name = "message_id")
	private int message_id;
	
	@Column(name="message_value")
	private int message_value;
	@ManyToOne(fetch = FetchType.EAGER)
	private User userInMessageClass;
	@ManyToOne(fetch = FetchType.EAGER)
	private ChatRoom chatRoomInMessageClass;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int message_id, int message_value, User userInMessageClass, ChatRoom chatRoomInMessageClass) {
		super();
		this.message_id = message_id;
		this.message_value = message_value;
		this.userInMessageClass = userInMessageClass;
		this.chatRoomInMessageClass = chatRoomInMessageClass;
	}
	public Message(int message_id, int message_value, User userInMessageClass) {
		super();
		this.message_id = message_id;
		this.message_value = message_value;
		this.userInMessageClass = userInMessageClass;
	}
	public Message(int message_id, int message_value, ChatRoom chatRoomInMessageClass) {
		super();
		this.message_id = message_id;
		this.message_value = message_value;
		this.chatRoomInMessageClass = chatRoomInMessageClass;
	}
	public int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getMessage_value() {
		return message_value;
	}
	public void setMessage_value(int message_value) {
		this.message_value = message_value;
	}
	public User getUserInMessageClass() {
		return userInMessageClass;
	}
	public void setUserInMessageClass(User userInMessageClass) {
		this.userInMessageClass = userInMessageClass;
	}
	public ChatRoom getChatRoomInMessageClass() {
		return chatRoomInMessageClass;
	}
	public void setChatRoomInMessageClass(ChatRoom chatRoomInMessageClass) {
		this.chatRoomInMessageClass = chatRoomInMessageClass;
	}
	
	
}
