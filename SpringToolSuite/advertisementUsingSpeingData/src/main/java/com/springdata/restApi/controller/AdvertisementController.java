package com.springdata.restApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springdata.restApi.json.Advertisement;

import com.springdata.restApi.services.AdvertisementService;


@RestController
@RequestMapping("/advertise")
public class AdvertisementController {
	
	@Autowired
	private AdvertisementService advertisementService;
	
	@RequestMapping(value="/addadv",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public Advertisement addAdvertisement(@RequestBody Advertisement advertisement,@RequestHeader String apikey) {
		return advertisementService.save(advertisement,apikey);
	}

}
