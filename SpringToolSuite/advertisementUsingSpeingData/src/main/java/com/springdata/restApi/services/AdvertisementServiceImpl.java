package com.springdata.restApi.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
	public String update(Advertisement advertise,String key) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{	Optional<AdvertisementEntity> option=userEntity.getAdvertisementEntities().stream().filter((AdvertisementEntity adv)->adv.equals(AdvertisementUtils.convertAdvJsonToAdvEntity(advertise))).findAny();
			if(option.isPresent())
			{	AdvertisementEntity advToPersist=AdvertisementUtils.convertAdvJsonToAdvEntity(advertise);
				advToPersist.setUserEntity(userEntity);
				advertisementRepositories.save(advToPersist);
				return "Update Succesfull\n"+advertisementRepositories.findById(advertise.getId()).toString();
			}
			else
			{
				return "no advertisement present of the given id";
			}
		}
		else
		{
			return "Login to continue session has expired or user not logged in";
		}
	}


	@Override
	public Set<Advertisement> getAUserAdvList(String key) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{
			return AdvertisementUtils.convertAdvEntitySetToAdvJsonSet(userEntity.getAdvertisementEntities());
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Advertisement> getAllAdvertisements() {
		return AdvertisementUtils.convertAdvEntityListToAdvJson(advertisementRepositories.findAll());
	} 
	@Override
	public List<Advertisement> getAdvertisementByPostIdForAParticularUser(String key, String postId) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{
			Optional<AdvertisementEntity> option=userEntity.getAdvertisementEntities().stream().filter((AdvertisementEntity adv)->adv.getPostId().equals(postId)).findAny();
			if(option.isPresent())
			{	
				return AdvertisementUtils.convertAdvEntityListToAdvJson( advertisementRepositories.findByPostId(postId));
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	
	@Override
	public String deleteAdvByPostId(String key, String id) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{
			Optional<AdvertisementEntity> option=userEntity.getAdvertisementEntities().stream().filter((AdvertisementEntity adv)->adv.getPostId().equals(id)).findAny();
			if(option.isPresent())
			{	
				AdvertisementEntity advToBeDeleted=userEntity.getAdvertisementEntities().stream().filter((AdvertisementEntity adv)->adv.getPostId().equals(id)).collect(Collectors.toList()).get(0);
				advertisementRepositories.delete(advToBeDeleted);
				return "Deleted succesfully";
			}
			else
			{
				return "no advertisement present of the given id";
			}
		}
		else
		{
			return "Login to continue session has expired or user not logged in";
		}
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
