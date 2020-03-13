package com.hibernate.rrelationshipinhibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateRelationShipOneToOneTest {
	public static void inset(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		Profile p=new Profile("IBM", 5);
		EmployeeHibernate e=new EmployeeHibernate("Hemant",50000,p);
		session.save(e);
		session.save(p);
		t.commit();
		session.close();
	}
	public static void update(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		
		EmployeeHibernate e=session.load(EmployeeHibernate.class,4L);
		e.getProfile().setCompany("TCS");
		t.commit();
		session.close();
		
	}
	public static void remove(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		EmployeeHibernate e=session.load(EmployeeHibernate.class,8L);
		session.delete(e);
		t.commit();
		session.close();
	}
	public static void read(SessionFactory s)
	{

		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		Query q=session.createQuery(" from EmployeeHibernate " );
		System.out.println(q.list());
		
	}

	public static void main(String[] args) {
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.out.xml");
		SessionFactory s=config.buildSessionFactory();
		//inset(s);
		//remove(s);
		//read(s);
		//update(s);
		s.close();
		
	}

}
