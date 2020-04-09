package com.spring.utils;



public class AccountEntityConvertor {
	public static com.spring.hibernate.entity.Account convertAccountJsonToHibernate(com.spring.entity.Account empJson) {
		com.spring.hibernate.entity.Account empDB = new com.spring.hibernate.entity.Account();
		empDB.setId(empJson.getId());
		empDB.setBalance(empJson.getBalance());
		empDB.setName(empJson.getName());
		return empDB;
	}
	
	public static com.spring.entity.Account convertAccountHibernateToJson(com.spring.hibernate.entity.Account empDB) {
		com.spring.entity.Account empJson = new com.spring.entity.Account();
		empJson.setId(empDB.getId());
		empJson.setBalance(empDB.getBalance());
		empJson.setName(empDB.getName());
		return empJson;
	}
	

	

}
