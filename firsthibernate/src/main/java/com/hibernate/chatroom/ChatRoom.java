package com.hibernate.chatroom;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ChatRoom")
public class ChatRoom {
@Id
@Column(name="chatroom_id")
private int id;
@Column(name="chatroom_name")
private String name;
@ManyToMany(fetch = FetchType.EAGER)
private Set<User> userList;
@OneToMany(fetch = FetchType.EAGER,mappedBy = "chatRoomInMessageClass")
private List<Message> messageList;
public ChatRoom() {
	
}


public ChatRoom(int id, String name, List<Message> messageList) {
	super();
	this.id = id;
	this.name = name;
	this.messageList = messageList;
}


public ChatRoom(int id, String name, Set<User> userList) {
	super();
	this.id = id;
	this.name = name;
	this.userList = userList;
}


public ChatRoom(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}

public ChatRoom(int id, String name, Set<User> userList, List<Message> messageList) {
	super();
	this.id = id;
	this.name = name;
	this.userList = userList;
	this.messageList = messageList;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Set<User> getUserList() {
	return userList;
}

public void setUserList(Set<User> userList) {
	this.userList = userList;
}

public List<Message> getMessageList() {
	return messageList;
}

public void setMessageList(List<Message> messageList) {
	this.messageList = messageList;
}

@Override
public String toString() {
	return "ChatRoom [id=" + id + ", name=" + name + ", messageList=" + messageList + "]";
}


}
