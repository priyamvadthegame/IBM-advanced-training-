package com.hibernate.rrelationshipinhibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateRelationShipManyToManyTest {
	public static void insert(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		List<Course> courseList=new ArrayList<Course>();
		Course c1=new Course("Mathematics");
		Course c2=new Course("Physics");
		courseList.add(c1);
		courseList.add(c2);
		Student newStudent=new Student("Hemant",courseList);
		session.persist(newStudent);
		t.commit();
		session.close();
	}
	public static void update(SessionFactory s)
	{
		Session session=s.openSession();
		Transaction t=session.beginTransaction();
		t.begin();
		Course courseUpdate=session.load(Course.class,25L);
		courseUpdate.setCourseName("Chemistry");
		System.out.println("Course updated successfully");
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
		Query q=session.createQuery(" from Student " );
		System.out.println(q.list());
		t.commit();
		session.close();
		
	}
	public static void main(String[] args) {
		
		Configuration config=new Configuration();
		config.configure("hibernate.cfg.out.xml");
		SessionFactory s=config.buildSessionFactory();
		//insert(s);
		//update(s);
		//remove(s);
		read(s);
		s.close();
	}

}
