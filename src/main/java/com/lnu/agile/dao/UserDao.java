/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.dao;

import com.lnu.agile.model.TpsUser;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author olefir
 */
public class UserDao implements UserDaoInterface<TpsUser, String> {

    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

    private static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public boolean persist(TpsUser entity) {
        System.out.println("com.lnu.agile.dao.UserDao.persist()");
        if (findByEmail(entity.getUserEmail()) == null) {
            getCurrentSession().save(entity);
            return true;
        }
        return false;
    }

    @Override
    public void update(TpsUser entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public TpsUser findById(String id) {
        TpsUser user = (TpsUser) getCurrentSession().get(TpsUser.class, id);
        return user;
    }

    @Override
    public void delete(TpsUser entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<TpsUser> findAll() {
        List<TpsUser> users = (List<TpsUser>) getCurrentSession().createQuery("from TpsUser").list();
        return users;
    }

    @Override
    public void deleteAll() {
        List<TpsUser> entityList = findAll();
        for (TpsUser entity : entityList) {
            delete(entity);
        }
    }

    public TpsUser findByEmail(String email) {
        Query query = getCurrentSession().
                createQuery("from TpsUser where user_email = :user_email");
        query.setParameter("user_email", email);

        if (query.list().isEmpty()) {
            return null;
        } else {
            return (TpsUser) query.list().get(0);
        }
    }

    public TpsUser findByEmailPassword(String email, String password) {
        Query query = getCurrentSession().
                createQuery("from TpsUser where user_email = :user_email and user_password = :user_password");
        query.setParameter("user_email", email);
        query.setParameter("user_password", password);

        if (!query.list().isEmpty()) {
            return (TpsUser) query.list().get(0);
        } else {
            return null;
        }
    }

    public TpsUser findByEmailId(String email, String id) {
        Query query = getCurrentSession().
                createQuery("from TpsUser where user_email = :user_email and user_id = :user_id");
        query.setParameter("user_email", email);
        query.setParameter("user_id", id);
        return (TpsUser) query.list().get(0);
    }

    public TpsUser findByToken(String token) {
        Query query = getCurrentSession().
                createQuery("from TpsUser where user_confirmtoken = :user_confirmtoken");
        query.setParameter("user_confirmtoken", token);
        return (TpsUser) query.list().get(0);
    }
}
