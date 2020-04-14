package com.springdata.restApi.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdata.restApi.json.Advertisement;
import com.springdata.restApi.json.Message;
import com.springdata.restApi.services.AdvertisementService;


@RestController
@RequestMapping("/advertise")
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@RequestMapping(value="/addadv",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Advertisement addAdvertisement(@RequestBody Advertisement advertisement,@RequestHeader String apikey) {
		return advertisementService.save(advertisement,apikey);
	}
	@RequestMapping(value="/updateadv",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public String updateAdvertisement(@RequestBody Advertisement advertisement,@RequestHeader String apikey) {
		return advertisementService.update(advertisement,apikey);
	}
	@RequestMapping(value="/getuseradv",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> updateAdvertisement(@RequestHeader String apikey) {
		 List<Advertisement> advlist=new ArrayList<Advertisement>();
		 advlist.addAll(advertisementService.getAUserAdvList(apikey));
		 return advlist;
	}
	@RequestMapping(value="/getuseradvbypostid/{postid}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> getUserAdvByPostId(@RequestHeader String apikey,@PathVariable(name ="postid") String postId) {
		 return advertisementService.getAdvertisementByPostIdForAParticularUser(apikey, postId);
	}
	@RequestMapping(value="/deletedvbypostid/{postid}",method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String DeleteAdvByPostId(@RequestHeader String apikey,@PathVariable(name ="postid") String postId) {
		 return advertisementService.deleteAdvByPostId(apikey, postId);
	}
	
	@RequestMapping(value="/getcategorylist",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Set<String> getCategoryOfAllAdvertisement() {
		 return advertisementService.getCatogoriesList();
	}
	

	@RequestMapping(value="/sendmessage/{postid}",method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public String sendMessageByUser(@RequestHeader String apikey,@PathVariable(name ="postid") String postId,@RequestBody Message message){
		 return advertisementService.sendMessage(postId, message, apikey);
	}
	
	@RequestMapping(value="/getadvbysearchtext/{searchtext}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> sendMessageByUser(@PathVariable(name = "searchtext") String searchText){
		 return advertisementService.getAdvertisementByGivenSearchText(searchText);
	}




}
