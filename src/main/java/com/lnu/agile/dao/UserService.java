/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.dao;

import com.lnu.agile.model.TpsUser;
import java.util.List;

/**
 *
 * @author olefir
 */
public class UserService {

    private static UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean persist(TpsUser entity) {
        userDao.openCurrentSessionwithTransaction();
        boolean result = userDao.persist(entity);
        userDao.closeCurrentSessionwithTransaction();

        return result;
    }

    public void update(TpsUser entity) {
        userDao.openCurrentSessionwithTransaction();
        userDao.update(entity);
        userDao.closeCurrentSessionwithTransaction();
    }

    public TpsUser findById(String id) {
        userDao.openCurrentSession();
        TpsUser user = userDao.findById(id);
        userDao.closeCurrentSession();
        return user;
    }

    public TpsUser findByEmailPassword(String email, String password) {
        userDao.openCurrentSession();
        TpsUser user = userDao.findByEmailPassword(email, password);
        userDao.closeCurrentSession();
        return user;
    }
    
    public TpsUser findByToken(String token) {
        userDao.openCurrentSession();
        TpsUser user = userDao.findByToken(token);
        userDao.closeCurrentSession();
        return user;
    }

    public void delete(String id) {
        userDao.openCurrentSessionwithTransaction();
        TpsUser user = userDao.findById(id);
        userDao.delete(user);
        userDao.closeCurrentSessionwithTransaction();
    }

    public List<TpsUser> findAll() {
        userDao.openCurrentSession();
        List<TpsUser> users = userDao.findAll();
        userDao.closeCurrentSession();
        return users;
    }

    public void deleteAll() {
        userDao.openCurrentSessionwithTransaction();
        userDao.deleteAll();
        userDao.closeCurrentSessionwithTransaction();
    }

    public UserDao userDao() {
        return userDao;
    }
}
