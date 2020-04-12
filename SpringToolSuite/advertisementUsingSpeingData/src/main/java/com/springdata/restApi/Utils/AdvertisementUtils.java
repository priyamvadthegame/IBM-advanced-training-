package com.springdata.restApi.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import com.springdata.restApi.entity.AdvertisementEntity;
import com.springdata.restApi.json.Advertisement;

public class AdvertisementUtils {

	public static List<Advertisement> convertAdvEntityListToAdvJson(List<AdvertisementEntity> advEntityList)
	{
		List<Advertisement> newList=new ArrayList<Advertisement>();
		Consumer<AdvertisementEntity> consumer=(AdvertisementEntity adv)->newList.add(convertAdvEntityToAdvJson(adv));
		advEntityList.stream().forEach(consumer);
		return newList;
	}
	
	public static Advertisement convertAdvEntityToAdvJson(AdvertisementEntity advEntity)
	{
		return new Advertisement(advEntity.getId(),advEntity.getName(),advEntity.getTitle(),advEntity.getCategory(),advEntity.getDescription(),advEntity.getPostId(),advEntity.getStatus(),UserUtils.convertUserEntityToUser(advEntity.getUserEntity()));
	}
	public static AdvertisementEntity convertAdvJsonToAdvEntity(Advertisement advJson)
	{
		return new AdvertisementEntity(advJson.getId(),advJson.getName(),advJson.getTitle(),advJson.getCategory(),advJson.getDescription(),advJson.getPostId(),advJson.getStatus(),UserUtils.convertUserToUserEntity(advJson.getUser()));
	}
}
