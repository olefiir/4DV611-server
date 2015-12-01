/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.db.model.dao.TpsUserDAO;
import com.lnu.agile.db.model.pojo.TpsUser;
import java.util.List;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nils
 */
@RestController
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
//    @RequestMapping(value = RestURIConstants.CREATE_USER, method = RequestMethod.GET, headers="Accept=application/json")
//    public @ResponseBody int createUser(@PathVariable("email") String email,
//                            @PathVariable("password") String password, 
//                            @PathVariable("confirmPassword") String confirmPassword) {
//        try {
//            logger.info("Start createUser");
//
//            TpsUser user = new TpsUser(); // increment of userid is created in table
//            user.setUserEmail(email);
//            user.setUserPassword(password);
//            
//            TpsUserDAO.insertUser(user);
//
//        } catch (Exception ex) {
//            java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
//            return 0;
//        }
//        
//        return 1;
//    }
    
    @RequestMapping(value = RestURIConstants.USER, method = RequestMethod.GET)
    public @ResponseBody List<TpsUser> userList() {
        return TpsUserDAO.listAllUsers();
    }
    
    @RequestMapping(value = RestURIConstants.USER, method = RequestMethod.POST)
    public @ResponseBody int userCreate( @RequestBody RegUser reguser) {
        try {
            logger.info("Start userCreate");

            if ( reguser.getPassword().equals(reguser.getConfirmPassword()) ) {
                TpsUser user = new TpsUser(); // increment of userid is created in table
                user.setUserEmail(reguser.getEmail());
                user.setUserPassword(reguser.getPassword());
            
                if (TpsUserDAO.insertUser(user)==0) {
                    return 0;
                }
            } else {
                return 0;
            }


        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;  // never do
        }
        
        return 1;
    }
    
}

class RegUser {
    private String email;
    private String password;
    private String confirmPassword;
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
   
    public String getConfirmPassword() {
        return confirmPassword;
    }
    
}