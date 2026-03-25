package com.coforge.Dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.coforge.entities.Address;
import com.coforge.utils.HibernateUtil;
 
public class AddressDao {
 
    public Address save(Address address) {
 
        Transaction tx = null;
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
 
            tx = session.beginTransaction();
            session.save(address);
            tx.commit();
 
            return address;
 
        }catch(Exception e){
 
           e.printStackTrace();
        }
		return address;
    }
 
    public List<Address> getAll(){
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
 
            return session.createQuery("from Address",Address.class).list();
        }
    }
 
    public Address getById(long id){
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
 
            return session.get(Address.class,id);
        }
    }
 
    public void update(Address address){
 
        Transaction tx = null;
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
 
            tx = session.beginTransaction();
            session.update(address);
            tx.commit();
 
        }catch(Exception e){
 
            if(tx!=null) tx.rollback();
        }
    }
 
    public void delete(long id){
 
        Transaction tx = null;
 
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
 
            tx = session.beginTransaction();
 
            Address address = session.get(Address.class,id);
 
            if(address!=null){
                session.delete(address);
            }
 
            tx.commit();
        }
    }
}