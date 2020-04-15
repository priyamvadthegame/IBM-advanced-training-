package com.springdata.restApi.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdata.restApi.Utils.AdvertisementUtils;
import com.springdata.restApi.Utils.MessageUtils;
import com.springdata.restApi.entity.AdvertisementEntity;
import com.springdata.restApi.entity.MessageEntity;
import com.springdata.restApi.entity.UserEntity;
import com.springdata.restApi.json.Advertisement;
import com.springdata.restApi.json.Message;
import com.springdata.restApi.repositories.AdvertisementRepositories;
import com.springdata.restApi.repositories.MessageRepositories;
import com.springdata.restApi.repositories.UserRepositories;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

	@Autowired
	private  UserRepositories userRepositories;
	
	@Autowired
	private AdvertisementRepositories advertisementRepositories;
	
	@Autowired
	private MessageRepositories messageRepositories;
	
	
	@Override
	public Advertisement save(Advertisement advertisement, String key) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{	AdvertisementEntity advToPersist=AdvertisementUtils.convertAdvJsonToAdvEntity(advertisement);
			advToPersist.setLastUpdated(LocalDateTime.now());
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
				advToPersist.setLastUpdated(LocalDateTime.now());
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
	public String sendMessage(String postId, Message message,String key) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{	AdvertisementEntity advEntity=getAdvertisementByPostId(postId);
			if(advEntity!=null)
			{	MessageEntity messageEntity=MessageUtils.convertMessageJsonToMessageEntity(message);
				messageEntity.setDateAndTimeOfMessage(LocalDateTime.now());
				messageEntity.setForAdvertisement(advEntity);
				messageEntity.setUserSendingMessage(userEntity);
				messageRepositories.save(messageEntity);
				
				return "Message Sent Successfully";
			}
			else
			{
				return "Adversitement for the given post id is not present";
			}
		}
		else
		{
			return "Login to continue session has expired or user not logged in";
		}

	}
	
	@Override
	public Set<String> getCatogoriesList() {
		return getAllAdvertisements().stream().map(Advertisement::getCategory).collect(Collectors.toCollection(()->new TreeSet<String>()));
	}
	
	@Override
	public List<Advertisement> getAdvertisementByGivenSearchText(String searchText) {
		Optional<Advertisement> option= getAllAdvertisements().stream().filter((Advertisement adv)->adv.getCategory().contains(searchText)||adv.getDescription().contains(searchText)||adv.getName().contains(searchText)||adv.getTitle().contains(searchText)).findAny();
		if(option.isPresent())
		{
			return  getAllAdvertisements().stream().filter((Advertisement adv)->adv.getCategory().contains(searchText)||adv.getDescription().contains(searchText)||adv.getName().contains(searchText)||adv.getTitle().contains(searchText)).collect(Collectors.toList());
		}
		else
		{
			return null;
		}
	}
	@Override
	public List<Advertisement> getAdvertisementAfterTheGivenDateOfAUser(String date,String key) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{	
			System.out.println(date);
			
			LocalDate localDate=LocalDate.parse(date);
			System.out.println(localDate);
			Predicate<AdvertisementEntity> predicate=(AdvertisementEntity adv)->adv.getLastUpdated().toLocalDate().isAfter(localDate);
			if(userEntity.getAdvertisementEntities().stream().filter(predicate).findAny().isPresent())
			{
				return AdvertisementUtils.convertAdvEntityListToAdvJson(userEntity.getAdvertisementEntities().stream().filter(predicate).collect(Collectors.toList()));
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
	public List<Advertisement> getAdvertisementBeforeTheGivenDateOfAUser(String date,String key) {
		UserEntity userEntity=this.getUserUsingSessionId(key);
		if(userEntity!=null)
		{	LocalDate localDate=LocalDate.parse(date);
			Predicate<AdvertisementEntity> predicate=(AdvertisementEntity adv)->adv.getLastUpdated().toLocalDate().isBefore(localDate);
			if(userEntity.getAdvertisementEntities().stream().filter(predicate).findAny().isPresent())
			{
				return AdvertisementUtils.convertAdvEntityListToAdvJson(userEntity.getAdvertisementEntities().stream().filter(predicate).collect(Collectors.toList()));
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
	public List<Advertisement> getAdvertisementBetweenTheGivenDateOfAUser(String date,String key) {
		String dates[]=date.trim().split(" ");
		if(dates.length!=2)
		{
			return null;
		}
		else
		{
			UserEntity userEntity=this.getUserUsingSessionId(key);
			if(userEntity!=null)
			{	LocalDate localDate1=LocalDate.parse(dates[0]);
				LocalDate localDate2=LocalDate.parse(dates[1]);
				Predicate<AdvertisementEntity> predicate=(AdvertisementEntity adv)->adv.getLastUpdated().toLocalDate().isAfter(localDate1)&&adv.getLastUpdated().toLocalDate().isBefore(localDate2);
				if(userEntity.getAdvertisementEntities().stream().filter(predicate).findAny().isPresent())
				{
					return AdvertisementUtils.convertAdvEntityListToAdvJson(userEntity.getAdvertisementEntities().stream().filter(predicate).collect(Collectors.toList()));
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

	}
	@Override
	public List<Advertisement> getAdvertisementEqualToTheGivenDateOfAUser(String date,String key) {
				
			UserEntity userEntity=this.getUserUsingSessionId(key);
			if(userEntity!=null)
			{	LocalDate localDate=LocalDate.parse(date);
				
				Predicate<AdvertisementEntity> predicate=(AdvertisementEntity adv)->adv.getLastUpdated().toLocalDate().compareTo(localDate)==0;
				if(userEntity.getAdvertisementEntities().stream().filter(predicate).findAny().isPresent())
				{
					return AdvertisementUtils.convertAdvEntityListToAdvJson(userEntity.getAdvertisementEntities().stream().filter(predicate).collect(Collectors.toList()));
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
	public List<Advertisement> getAdvertisementByCategory(String category) {
		Optional<Advertisement> option= getAllAdvertisements().stream().filter((Advertisement adv)->adv.getCategory().toLowerCase().equals(category.toLowerCase())).findAny();
		if(option.isPresent())
		{
			return getAllAdvertisements().stream().filter((Advertisement adv)->adv.getCategory().toLowerCase().equals(category.toLowerCase())).collect(Collectors.toList());
		}
		else
		{
			return null;
		}
	}
	@Override
	public Set<String> getActionsList() {
		Set<String> actionsSet=new TreeSet<>();
		actionsSet.add("get advertisement list");
		actionsSet.add("get advertisement list by search text");
		actionsSet.add("get advertisement list by date conditons  < > =");
		actionsSet.add("get advertisement list by category");
		actionsSet.add("send message to advertising owner");
		actionsSet.add("delete advertisement list by postid");
		actionsSet.add("get advertisement list by post id");
		actionsSet.add("get category list of advertisement");
		actionsSet.add("get advertisement of a particular user");
		actionsSet.add("add advertisement by user");
		actionsSet.add("update advertisement of a user");
		actionsSet.add("register user");
		actionsSet.add("login user");
		actionsSet.add("logout user");
		return actionsSet;
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
	public List<String> getCatogoriesListForAParticularUser(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public AdvertisementEntity getAdvertisementByPostId(String postId)
	{	List<AdvertisementEntity> advEntityList=advertisementRepositories.findByPostId(postId);
		if(advEntityList!=null&&advEntityList.size()>0)
		{
			AdvertisementEntity adv=advEntityList.get(0);
			return adv;
		}
		else
		{
			return null;
		}
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
