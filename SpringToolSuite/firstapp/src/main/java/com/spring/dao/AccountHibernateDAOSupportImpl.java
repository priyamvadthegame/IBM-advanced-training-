package com.spring.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.entity.Account;


public class AccountHibernateDAOSupportImpl extends HibernateDaoSupport implements AccountDAO{
	@Transactional
	public void save(Account account) {
		getHibernateTemplate().save(account);
	}
	@Transactional
	public void update(Account account) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().update(account);
		
	}

	@Transactional
	public List<com.spring.hibernate.entity.Account> read() {
		Query query=getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from Account");
		return query.list();
		
	}
	@Transactional
	public void delete(Account account) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
		getHibernateTemplate().delete(account);
		
	}
	
}
