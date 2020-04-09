package com.spring.dao;

import java.util.List;

import com.spring.hibernate.entity.Account;

public interface AccountDAO {
	void save(Account account);
	void update(Account account);
	List<com.spring.hibernate.entity.Account> read();
	void delete(Account account);

}
