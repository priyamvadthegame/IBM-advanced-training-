package com.springdata.restApi.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_MASTER")
public class UserEntity {

	
	@Id
	@Column(name = "ID")
	private long id;
	
	@Column(name = "USER_NAME")
	private String userName;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	
	@Column(name = "PASSWORD")
	private String password;
	
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private long phone;;
	
	@Column(name="Session_ID")
	private String sessionId;
	
	@OneToMany
	@JoinColumn(name = "user_entity_id")
	private Set<AdvertisementEntity> advertisementEntities;
	
	@OneToMany
	@JoinColumn(name = "from_user")
	private Set<MessageEntity> messageSet;
	
	public UserEntity() {
		this.sessionId="";
	}

	public UserEntity(long id, String userName, String firstName, String lastName, String password, String email,
			long phone) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.sessionId="";
	}

	
	
	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public void setId(long id) {
		this.id = id;
	}
	

	public Set<AdvertisementEntity> getAdvertisementEntities() {
		return advertisementEntities;
	}

	public void setAdvertisementEntities(Set<AdvertisementEntity> advertisementEntities) {
		this.advertisementEntities = advertisementEntities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserEntity other = (UserEntity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
