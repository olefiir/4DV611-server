/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.dao.UserService;
import com.lnu.agile.model.TpsUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author olefir
 */
@RestController
public class AuthenticationController {

    //temp variable. should be changed
    private final String secret = "agilehorses";

    @RequestMapping(value = RestURIConstants.AUTH, method = RequestMethod.POST)
    public @ResponseBody
    String createTokenForUser(@RequestBody User reguser, HttpServletResponse response) {
        TpsUser user = new UserService().findByEmailPassword(reguser.getEmail(), reguser.getPassword());

        return Jwts.builder()
                .setSubject(user.getUserId().toString())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}

class User {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
