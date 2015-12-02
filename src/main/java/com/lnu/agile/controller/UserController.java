/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.db.model.dao.TpsUserDAO;
import com.lnu.agile.db.model.pojo.TpsUser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lnu.agile.mail.ApplicationMailer;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
    @RequestMapping(value = RestURIConstants.USER_CONFIRM, method = RequestMethod.GET)
    public @ResponseBody String userConfirm(@PathVariable("randomtoken") String randomtoken) {
        
        String webpage="<html><head>Results</head><body>Congratulations! The account has been activated!</body></html>";
        if (TpsUserDAO.updateUsersConfirmed(randomtoken) == 0) {
            
        } else if (TpsUserDAO.updateUsersConfirmed(randomtoken) == 2) {
            
        } else {
            
        }
        return webpage;
    }
    
    @RequestMapping(value = RestURIConstants.USER, method = RequestMethod.GET)
    public @ResponseBody List<TpsUser> userList() {
        return TpsUserDAO.listAllUsers();
    }
    
    @SuppressWarnings("resource")
    @RequestMapping(value = RestURIConstants.USER, method = RequestMethod.POST)
    public @ResponseBody TpsUser userCreate( @RequestBody RegUser reguser, HttpServletResponse response) {
        try {
            logger.info("Start userCreate");

            if ( reguser.getPassword().equals(reguser.getConfirmPassword()) ) {
                TpsUser user = new TpsUser(); // increment of userid is created in table
                user.setUserEmail(reguser.getEmail());
                user.setUserPassword(reguser.getPassword());
                
                //random token
                String randomToken = "";
                //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                Date date = new Date();
                randomToken = randomToken + dateFormat.format(date);
                
                int[] letterStart = new int[2];
                letterStart[0] = 65;
                letterStart[1] = 97;
                Random rand = new Random();
                for (int i=0; i<40; i++) {
                    int index = rand.nextInt(2);
                    int ascii = letterStart[index] + rand.nextInt(26);
                    randomToken = randomToken + ((char) ascii);
                }
                //System.out.println("randomToken: "+randomToken);
                
                user.setUserConfirmtoken(randomToken);
               
            
                if (TpsUserDAO.insertUser(user)==0) {
                    response.setStatus(403);
                    return null;
                } else if (TpsUserDAO.insertUser(user)==2) {
                    response.setStatus(500);
                    return null;

                } else {
//                    ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
//                    
//                    //Get the mailer instance
//                    ApplicationMailer sm =  (ApplicationMailer) context.getBean("mailService");
//                    
//                    String to = "xuebo.sun@gmail.com";
//                    String subject = "activate";
//                    String body = "https://enigmatic-reaches-6021.herokuapp.com/users/u/"+randomToken;
//                    sm.sendMail(to, subject, body);

                    response.setStatus(200);
                    TpsUser userResponse = new TpsUser(); 
                    userResponse.setUserEmail(reguser.getEmail());
                    return userResponse;
                }
 
                
            } else {
                response.setStatus(400);
                return null;
            }


        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(500);
            return null;
        }
        
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