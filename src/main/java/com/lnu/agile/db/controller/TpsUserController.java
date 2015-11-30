/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.db.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lnu.agile.db.model.dao.TpsUserDAO;
import com.lnu.agile.db.model.pojo.TpsUser;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author Nils
 */
public class TpsUserController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
               ModelAndView mv = new ModelAndView("tpsuser");
        
        try {
            List<TpsUser> lst = TpsUserDAO.layDS();
            mv.addObject("users",lst);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return mv;
    }
    
}
