package firstSpringApp;

import java.util.List;

public class ChatRoomSpring {
	private String id;
	private List<String> userList;
	private List<String> messageList;
	public ChatRoomSpring() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatRoomSpring(String id, List<String> userList, List<String> messageList) {
		super();
		this.id = id;
		this.userList = userList;
		this.messageList = messageList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getUserList() {
		return userList;
	}
	public void setUserList(List<String> userList) {
		this.userList = userList;
	}
	public List<String> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}
	@Override
	public String toString() {
		return "ChatRoomSpring [id=" + id + ", userList=" + userList + ", messageList=" + messageList + "]";
	}
	
}
