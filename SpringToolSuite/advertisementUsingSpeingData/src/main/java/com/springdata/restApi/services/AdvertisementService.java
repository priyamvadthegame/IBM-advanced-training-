package com.springdata.restApi.services;

import java.util.List;
import java.util.Set;

import com.springdata.restApi.json.Advertisement;
import com.springdata.restApi.json.Message;


public interface AdvertisementService {
	
	public Advertisement save(Advertisement advertisement,String key);
	
	public Set<Advertisement> getAUserAdvList(String key);
	
	public List<Advertisement> getAllAdvertisements();
	
	public String deleteAdvByPostId(String key,String id);
	
	public List<Advertisement> getAdvertisementByCategory();
	
	public List<Advertisement> getAdvertisementsByStatus();
	
	public List<Advertisement> getAdvertisementByCategoryForAParticularUser(String key);
	
	public List<Advertisement> getAdvertisementsByStatusForAParticularUser(String key);
	
	public String sendMessage(String postId,Message message,String key);
	
	public Set<String> getCatogoriesList();
	
	public List<String> getCatogoriesListForAParticularUser(String key);
	
	public String update(Advertisement advertise,String key);
	public List<Advertisement> getAdvertisementByPostIdForAParticularUser(String key,String postId);

	public List<Advertisement> getAdvertisementByGivenSearchText(String searchText);
	
	
	

}
