package com.coforge.Dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.coforge.entities.Employee;
import com.coforge.utils.HibernateUtil;

public class EmployeeDao {
	public List<Employee> getAllEmployee() throws HibernateException
	{
		try(Session session  = HibernateUtil.getSessionFactory().openSession())
		{
			return session.createQuery("From Employee", Employee.class).list();
			
		}
	}
	public void insertEmployee(Employee employee)
	{
		Transaction txTransaction = null;
		try(Session session  = HibernateUtil.getSessionFactory().openSession())
		{
			txTransaction = session.beginTransaction();
			session.persist(employee);
			txTransaction.commit();
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
	public Employee getEmployeeById(long eid)
	{
		//Transaction txTransaction = null;
		try(Session session =  HibernateUtil.getSessionFactory().openSession())
		{
			return session.get(Employee.class,eid );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public void deleteEmployee(long eid)
	{
		try(Session session = HibernateUtil.getSessionFactory().openSession())
		{
			Transaction txTransaction = session.beginTransaction();
			session.delete(getEmployeeById(eid));
			txTransaction.commit();
			System.out.println("Employee Deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void updateEmployee(Employee employee) {
		 
	    Transaction tx = null;
	 
	    try(Session session = HibernateUtil.getSessionFactory().openSession()) {
	 
	        tx = session.beginTransaction();
	 
	        session.update(employee);
	 
	        tx.commit();
	    }
	    catch(Exception e) {
	 
	        if(tx != null) {
	            tx.rollback();
	        }
	 
	        e.printStackTrace();
	    }
	}
	

}