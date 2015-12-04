/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.test;

import com.lnu.agile.dao.UserService;
import com.lnu.agile.model.TpsUser;

/**
 *
 * @author olefir
 */
public class UserDaoTest {

    public static void main(String args[]) {
        UserService userService = new UserService();
        TpsUser user = new TpsUser("12hello@gmail.com", false, "test", "test", "test", "test", "test", "test");

        boolean result = new UserService().persist(user);
    }

}
