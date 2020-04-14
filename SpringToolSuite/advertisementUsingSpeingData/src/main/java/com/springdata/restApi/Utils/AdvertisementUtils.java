package com.springdata.restApi.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
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
	public static Set<Advertisement> convertAdvEntitySetToAdvJsonSet(Set<AdvertisementEntity> advEntityList)
	{
		Set<Advertisement> newSet=new TreeSet<Advertisement>();
		Consumer<AdvertisementEntity> consumer=(AdvertisementEntity adv)->newSet.add(convertAdvEntityToAdvJson(adv));
		advEntityList.stream().forEach(consumer);
		return newSet;
	}
	
	public static Advertisement convertAdvEntityToAdvJson(AdvertisementEntity advEntity)
	{
		return new Advertisement(advEntity.getId(),advEntity.getName(),advEntity.getTitle(),advEntity.getCategory(),advEntity.getDescription(),advEntity.getPostId(),advEntity.getStatus(),advEntity.getLastUpdated());
	}
	public static AdvertisementEntity convertAdvJsonToAdvEntity(Advertisement advJson)
	{
		return new AdvertisementEntity(advJson.getId(),advJson.getName(),advJson.getTitle(),advJson.getCategory(),advJson.getDescription(),advJson.getPostId(),advJson.getStatus(),advJson.getLastUpdated());
	}
}
