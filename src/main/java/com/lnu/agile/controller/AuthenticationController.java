/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.db.model.dao.TpsUserDAO;
import com.lnu.agile.db.model.pojo.TpsUser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author olefir
 */


@Controller
public class AuthenticationController {
    
    private String secret = "agilehorses";
    
    
    //review
    /*@RequestMapping(value = RestURIConstants.USER, method = RequestMethod.POST)
    public @ResponseBody TpsUser parseUserFromToken(@PathVariable("token") String token) {
       String username = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
        return TpsUserDAO.findUserByEmail(username);//.loadUserByUsername(username);
    } */
    
    /*@RequestMapping(value = RestURIConstants.AUTH, method = RequestMethod.POST)
    public @ResponseBody String createTokenForUser(@RequestBody TestUser tpsUser, HttpServletResponse response) {
       
        List<TpsUser> users = TpsUserDAO.checkUserByEmail(tpsUser.getEmail(), tpsUser.getPassword());
        if(!users.isEmpty()) {
            TpsUser user = users.get(0);
            return Jwts.builder()
                .setSubject(user.getUserId().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        } 
        
        else {
            response.setStatus(403);
            return null;
        }
        
    } */
    
    @RequestMapping(value = RestURIConstants.AUTH, method = RequestMethod.GET)
    public @ResponseBody String createTokenForUser(@PathVariable("email") String email, @PathVariable("password") String password) {
       
        List<TpsUser> users = TpsUserDAO.checkUserByEmail(email, password);
        if(!users.isEmpty()) {
            TpsUser user = users.get(0);
            return Jwts.builder()
                .setSubject(user.getUserId().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        } 
        return "error";
        
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    
    public @ResponseBody String update(@RequestBody TestUser test) {

        return "test";
    }
 
    class TestUser {
    private String email;
    private String password;
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
   
    
}
}
