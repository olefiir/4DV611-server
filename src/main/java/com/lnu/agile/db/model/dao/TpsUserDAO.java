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
    public static List<TpsUser> listAllUsers() {
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
    
    public static int insertUser(TpsUser tpsuser) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hql = "from TpsUser tu where tu.userEmail='"+tpsuser.getUserEmail()+"'";
            Query query = session.createQuery(hql);
            //System.out.println("number of same emails: "+query.list().size());
            if (query.list().size()!=0) {
                session.close();
                return 0;
            } 
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(tpsuser);
            tx.commit();

            session.close();
            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }

    }
    
    public static int updateUsersConfirmed(String randomtoken) {
        try {
            
            Session session = HibernateUtil.getSessionFactory().openSession();
            
            String hqlsearch = "from TpsUser tu where tu.userConfirmed=1 and tu.userConfirmtoken='"+randomtoken+"'";
            Query verification = session.createQuery(hqlsearch);
            //System.out.println("number of same emails: "+query.list().size());
            if (verification.list().size()!=0) {
                session.close();
                return 0;
            } 
            
            Transaction tx = session.beginTransaction();
            String hqlUpdate = "update TpsUser tu set tu.userConfirmed = :status where tu.userConfirmtoken = :token";   
            int query = session.createQuery( hqlUpdate ).setString( "status", "1" ).setString( "token", randomtoken ).executeUpdate();
            tx.commit();
            session.close();
            
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 2;
        }
        
    }
    
}
