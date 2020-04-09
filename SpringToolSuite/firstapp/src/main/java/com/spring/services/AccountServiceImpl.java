package com.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.spring.dao.AccountDAO;
import com.spring.entity.Account;
import com.spring.utils.AccountEntityConvertor;

public class AccountServiceImpl implements AccountService {
	
	@Autowired
	@Qualifier("account_1")
	private AccountDAO accountDAO;

	public void save(Account accJson) {
		accountDAO.save(AccountEntityConvertor.convertAccountJsonToHibernate(accJson));
	}

	public void update(Account accJson) {
		accountDAO.update(AccountEntityConvertor.convertAccountJsonToHibernate(accJson));
		
	}

	public List<com.spring.hibernate.entity.Account> read() {
		
		return accountDAO.read();
		
	}

	public void delete(Account accJson) {
		accountDAO.delete(AccountEntityConvertor.convertAccountJsonToHibernate(accJson));
		
	}

	
	

}
