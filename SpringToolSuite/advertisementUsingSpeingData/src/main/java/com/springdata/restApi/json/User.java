package com.springdata.restApi.json;


	public class User {
		
		private String userName,firstName,lastName,password,email,sessionId;
		private long phone,id;
		
		public User() {
			this.sessionId="";
		}

		public User(long id, String userName, String firstName, String lastName, String password, String email,
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
			User other = (User) obj;
			if (id != other.id)
				return false;
			return true;
		}

		
	}



