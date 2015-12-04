/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lambdaworks.crypto.SCryptUtil;
import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.dao.UserDao;
import com.lnu.agile.dao.UserService;
import com.lnu.agile.model.TpsUser;
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
import com.lnu.agile.utility.SymbolGenerator;
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

    @RequestMapping(value = RestURIConstants.USER_CONFIRM, method = RequestMethod.GET)
    public @ResponseBody
    String userConfirm(@PathVariable("randomtoken") String randomtoken) {
        String message = "";
        TpsUser user = new UserService().findByToken(randomtoken);
        if (user.isUserConfirmed()) {
            message = "Failed! user already has been activated!";
        } else {
            user.setUserConfirmed(true);
            new UserService().update(user);
            message = "Congratulations! The account has been activated!";
        }

        return "<html><head><title>Results</title></head><body>" + message + "</body></html>";
    }

    @RequestMapping(value = RestURIConstants.USER, method = RequestMethod.GET)
    public @ResponseBody
    List<TpsUser> userList() {
        return new UserService().findAll();
    }

    @SuppressWarnings("resource")
    @RequestMapping(value = RestURIConstants.USER, method = RequestMethod.POST)
    public @ResponseBody
    TpsUser userCreate(@RequestBody RegUser reguser, HttpServletResponse response) {
        try {
            logger.info("Start userCreate");

            if (reguser.getPassword().equals(reguser.getConfirmPassword())) {
                TpsUser user = new TpsUser(); // increment of userid is created in table
                user.setUserEmail(reguser.getEmail());
                user.setUserPassword(new SymbolGenerator().encodePassword(reguser.getPassword()));
                user.setUserConfirmtoken(new SymbolGenerator().generateToken());

                boolean result = new UserService().persist(user);

                if (result == false) {
                    response.setStatus(403);
                    return null;
                } else {
                    ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");

                    //Get the mailer instance
                    ApplicationMailer sm = (ApplicationMailer) context.getBean("mailService");

                    String to = reguser.getEmail();
                    String subject = "Activate link:";
                    String body = "https://enigmatic-reaches-6021.herokuapp.com/users/confirmation/" + user.getUserConfirmtoken();
                    sm.sendMail(to, subject, body);

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
