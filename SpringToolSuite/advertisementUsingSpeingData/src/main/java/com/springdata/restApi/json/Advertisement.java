package com.springdata.restApi.json;

import java.time.LocalDateTime;

public class Advertisement implements Comparable<Advertisement> {
	private String postId,status,title,name,category,description;
	private long id;
	private LocalDateTime lastUpdated;

	public Advertisement() {
		super();
		// TODO Auto-generated constructor stub
		this.postId="";
		this.status="closed";
	}
	
	

	
	public Advertisement(long id,String name,String title, String category, String description,String postId, String status,LocalDateTime lastUpdated) {
		super();
		this.id=id;
		this.postId = postId;
		this.status = status;
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.lastUpdated=lastUpdated;
	}
	


	public Advertisement(long id,String name,String title, String category, String description,LocalDateTime lastUpdated) {
		super();
		this.title = title;
		this.name = name;
		this.category = category;
		this.description = description;
		this.id=id;
		this.postId="";
		this.status="closed";
		this.lastUpdated=lastUpdated;
	}
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}




	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Advertisement other = (Advertisement) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public int compareTo(Advertisement adv) {
		
		if(this.getId()>adv.getId())
		{
			return 1;
		}
		else if(this.getId()==adv.getId())
		{
			return 0;
		}
		else
		{
			return -1;
		}
	}




	@Override
	public String toString() {
		return "Advertisement [postId=" + postId + ", status=" + status + ", title=" + title + ", name=" + name
				+ ", category=" + category + ", description=" + description + ", id=" + id + ", lastUpdated="
				+ lastUpdated + "]";
	}





	

}
