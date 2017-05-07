package com.neil.hibernate.utilities;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionfactory;
	
	static{
		
		Configuration config=new Configuration();
		sessionfactory=config.configure("/com/neil/hibernate/config/hibernate.cfg.xml").buildSessionFactory();
	}
	
	
	private HibernateUtil(){
		
	}
	
	
	public static Session getSession(){
		return sessionfactory.openSession();
	}
	
}
