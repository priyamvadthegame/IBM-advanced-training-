package com.spring.services;

import java.util.List;

import com.spring.entity.Account;

public interface AccountService {
	public void save(Account account);
	public void update(Account account);
	public List<com.spring.hibernate.entity.Account> read();
	public void delete(Account account);
}
