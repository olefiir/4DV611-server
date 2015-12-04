/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.utility;

import com.lambdaworks.crypto.SCryptUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author olefir
 */
public class SymbolGenerator {
    
    public String encodePassword(String password) {
        return SCryptUtil.scrypt(password, 16, 16, 16);
    }

    public String generateToken() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String randomToken = dateFormat.format(date);

        int[] letterStart = new int[2];
        letterStart[0] = 65;
        letterStart[1] = 97;
        Random rand = new Random();
        for (int i = 0; i < 40; i++) {
            int index = rand.nextInt(2);
            int ascii = letterStart[index] + rand.nextInt(26);
            randomToken = randomToken + ((char) ascii);
        }
        return randomToken;
    }
}
