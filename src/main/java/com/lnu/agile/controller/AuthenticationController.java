/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.model.TpsUser;
import com.lnu.agile.security.token.TokenAuthenticationService;
import com.lnu.agile.security.AuthUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author olefir
 */
@RestController
public class AuthenticationController {

    @RequestMapping(value = RestURIConstants.AUTH, method = RequestMethod.POST)
    public @ResponseBody
    String createTokenForUser(@RequestBody User user, HttpServletResponse response) {
        TpsUser authUser = new AuthUserService().loadUserByUsername(user.getEmail(), user.getPassword());
        if (authUser != null) {
            return new TokenAuthenticationService().addAuthentication(response, authUser);
        } else {
            return "User isn't found";
        }
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
