package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Account;
import com.spring.services.AccountService;

@RestController
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/account", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addAccount(@RequestBody Account account) {
		accountService.save(account);
		return "{ \"result\": \"Success\"}";
	}

	@RequestMapping(value="/account",method=RequestMethod.PUT,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String updateAccount(@RequestBody Account account) {
		accountService.update(account);
		return "{ \"result\": \"Success\"}";
	}
	@RequestMapping(value="/account",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<com.spring.hibernate.entity.Account> readAccount() {
		return accountService.read();
		
	}
	@RequestMapping(value="/account",method=RequestMethod.DELETE,consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String deleteAccount(@RequestBody Account account) {
		accountService.delete(account);
		return "{ \"result\": \"Success\"}";
	}
}
