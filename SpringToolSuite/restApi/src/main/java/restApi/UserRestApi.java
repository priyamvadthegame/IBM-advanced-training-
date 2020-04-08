package restApi;

import java.util.List;
import java.util.ArrayList;

public class UserRestApi {
	private String firstName,lastName,userName,password,email;
	private long phone;
	List<Advertisement> advertisementList=new ArrayList<Advertisement>();
	
	public UserRestApi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRestApi(String firstName, String lastName, String userName, String password, String email, long phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public void setAdvertisementList(Advertisement advertisement)
	{
		this.advertisementList.add(advertisement);
	}
	public boolean deleteAdvertisementList(Advertisement advertisement)
	{
		if(this.advertisementList.contains(advertisement))
		{
			this.advertisementList.remove(advertisement);
			return true;
		}
		return false;
	}
	public boolean updateExistingAdvertisement(Advertisement advertisement)
	{
		if(this.advertisementList.contains(advertisement))
		{
			this.advertisementList.remove(advertisement);
			this.setAdvertisementList(advertisement);
			return true;
		}
		return false;
	}
	public List<Advertisement> getAdvertisementList()
	{
		return this.advertisementList;
	}

	@Override
	public String toString() {
		return "UserRestApi [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+  ", email=" + email + ", phone=" + phone + ", advertisementList="
				+ advertisementList + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRestApi other = (UserRestApi) obj;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
}
