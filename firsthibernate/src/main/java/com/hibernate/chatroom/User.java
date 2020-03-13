package com.hibernate.chatroom;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

public class User {
	
@Id
@Column(name="user_id")
private int id;
@Column(name="user_name",unique = true)
private String userName;
@Column(name="password")
private String password;
@OneToMany(fetch = FetchType.EAGER,mappedBy = "userInMessageClass")
private List<Message>  userMessage;
@ManyToMany(fetch = FetchType.EAGER)
private Set<ChatRoom> userChatRoom;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, String userName, String password) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
}
public User(int id, String userName, String password, List<Message> userMessage) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.userMessage = userMessage;
}
public User(int id, String userName, String password, Set<ChatRoom> userChatRoom) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.userChatRoom = userChatRoom;
}
public User(int id, String userName, String password, List<Message> userMessage, Set<ChatRoom> userChatRoom) {
	super();
	this.id = id;
	this.userName = userName;
	this.password = password;
	this.userMessage = userMessage;
	this.userChatRoom = userChatRoom;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Message> getUserMessage() {
	return userMessage;
}
public void setUserMessage(List<Message> userMessage) {
	this.userMessage = userMessage;
}
public Set<ChatRoom> getUserChatRoom() {
	return userChatRoom;
}
public void setUserChatRoom(Set<ChatRoom> userChatRoom) {
	this.userChatRoom = userChatRoom;
}

@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", userMessage=" + userMessage
			+ "]";
}

}
