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
}
