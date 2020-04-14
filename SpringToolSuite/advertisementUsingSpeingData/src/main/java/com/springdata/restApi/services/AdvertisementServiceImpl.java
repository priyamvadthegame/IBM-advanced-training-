package com.springdata.restApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.restApi.Utils.AdvertisementUtils;
import com.springdata.restApi.entity.AdvertisementEntity;
import com.springdata.restApi.entity.UserEntity;
import com.springdata.restApi.json.Advertisement;
import com.springdata.restApi.repositories.AdvertisementRepositories;
import com.springdata.restApi.repositories.UserRepositories;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	private  UserRepositories userRepositories;
	
	@Autowired
	private AdvertisementRepositories advertisementRepositories;
	
	
	@Override
	public Advertisement save(Advertisement advertisement, String key) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{	AdvertisementEntity advToPersist=AdvertisementUtils.convertAdvJsonToAdvEntity(advertisement);
			advToPersist.setUserEntity(userEntity);
			advertisementRepositories.save(advToPersist);
			return AdvertisementUtils.convertAdvEntityToAdvJson(advToPersist);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Advertisement> getAUserAdvList(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> getAllAdvertisements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAdv(String key, Advertisement advertisement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAdv(String key, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> getAdvertisementByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> getAdvertisementsByStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> getAdvertisementByCategoryForAParticularUser(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Advertisement> getAdvertisementsByStatusForAParticularUser(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCatogoriesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCatogoriesListForAParticularUser(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	public  UserEntity getUserUsingSessionId(String apiKey)
	{
		if(apiKey==null||apiKey.equals(""))
		{
			return null;
		}
		UserEntity user=userRepositories.findBySessionId(apiKey).get(0);
		if(user==null)
		{
			return null;
		}
		else
		{
			return user;
		}
	}

}
