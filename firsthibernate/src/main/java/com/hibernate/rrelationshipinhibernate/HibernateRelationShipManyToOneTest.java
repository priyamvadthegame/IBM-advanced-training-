package com.hibernate.rrelationshipinhibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateRelationShipManyToOneTest {
	public static void insert(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		List<Stock> stockList=new ArrayList<Stock>();
		Stock stock=new Stock("market3Stock",600.0);
		stockList.add(stock);
		Market m=new Market("market3",stockList);
		stock.setMarket(m);
		session.persist(m);
		t.commit();
		session.close();
	}
	public static void update(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		Stock stockUpdate=session.load(Stock.class,22);
		stockUpdate.getMarket().setName("market4");
		System.out.println("Stock updated successfully");
		t.commit();
		session.close();
		
	}
	public static void remove(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		Stock stockUpdate=session.load(Stock.class,22);
		session.delete(stockUpdate);
		t.commit();
		session.close();
	}
	public static void read(SessionFactory s)
	{

		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		Query q=session.createQuery(" from Stock " );
		System.out.println(q.list());
		t.commit();
		session.close();
		
	}
	public static void main(String[] args) {
	
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.out.xml");
		SessionFactory s=config.buildSessionFactory();
		//insert(s);
		//read(s);
		//update(s);
		//remove(s);
		s.close();

	}

}
