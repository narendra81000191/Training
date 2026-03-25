// Explanation: Implemented CRUD methods for Order entity using Hibernate SessionFactory from HibernateUtil.
package com.coforge.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.coforge.entities.Order;
import com.coforge.utils.HibernateUtil;

public class OrderDao {

    public Order save(Order order) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(order);
            tx.commit();
            return order;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public List<Order> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> q = session.createQuery("from Order", Order.class);
            return q.list();
        }
    }

    public Order getById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Order.class, id);
        }
    }

    public Order update(Order order) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(order);
            tx.commit();
            return order;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    public boolean delete(long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Order o = session.get(Order.class, id);
            if (o != null) {
                session.delete(o);
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
