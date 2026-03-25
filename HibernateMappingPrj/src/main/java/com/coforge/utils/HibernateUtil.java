package com.coforge.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = sessionFactory();
	public static SessionFactory sessionFactory()
	{
		return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
	}
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}

}
