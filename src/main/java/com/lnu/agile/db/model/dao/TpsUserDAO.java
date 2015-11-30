/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.db.model.dao;

import java.util.List;
import com.lnu.agile.db.model.pojo.TpsUser;
import com.lnu.agile.db.model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Nils
 */
public class TpsUserDAO {
    public static List<TpsUser> layDS() {
        List<TpsUser> lst = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from TpsUser";
            Query query = session.createQuery(hql);
            lst = query.list();
            
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lst;
    }
    
    public static int insertUser(Object obj) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            
            
            session.saveOrUpdate(obj);
            
            tx.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
}
