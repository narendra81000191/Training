 // Explanation: Added CRUD methods for Customer using HibernateUtil's SessionFactory. Methods: save, getAll, getById, getCustomerByOrderId, update, delete. Uses Hibernate Session and Transaction APIs and returns appropriate results or boolean for success.
package com.coforge.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coforge.entities.Customer;
import com.coforge.entities.Order;
import com.coforge.utils.HibernateUtil;

public class CustomerDao {

    public Customer save(Customer customer) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(customer);
            tx.commit();
            return customer;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Customer> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Customer> q = session.createQuery("from Customer", Customer.class);
            return q.list();
        }
    }

    public Customer getById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Customer.class, id);
        }
    }

    public Customer getCustomerByOrderId(long orderId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           
            Query<Customer> q = session.createQuery(
                    "select c from Customer c join c.orders o where o.ordId = :oid", Customer.class);
            q.setParameter("oid", orderId);
            return q.uniqueResult();
        }
    }

    public Customer update(Customer customer) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(customer);
            tx.commit();
            return customer;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public boolean delete(long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Customer c = session.get(Customer.class, id);
            if (c != null) {
                session.delete(c);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
