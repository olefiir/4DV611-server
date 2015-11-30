/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.config.RestURIConstants;
import com.lnu.agile.json.FileParser;
import com.lnu.agile.json.XmlToJsonParser;
import com.lnu.agile.model.mapped.TrackInfoArray;
import java.io.IOException;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Nils
 */
@RestController
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
    @RequestMapping(value = RestURIConstants.GET_ALL_USER, method = RequestMethod.GET, headers="Accept=application/json")
    public int getAllUsers() {
        try {
            logger.info("Start getAllUsers");
            
//            Resource resource = new DefaultResourceLoader().getResource(PATH);
//            FileParser parser = new XmlToJsonParser();
//            TrackInfoArray allTracks = parser.parseFile(resource.getFile().getAbsolutePath());
            
            System.out.println("Hello all users");
            
            return 0;
        //} catch (IOException ex) {
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
        
    @RequestMapping(value = RestURIConstants.CREATE_USER, method = RequestMethod.GET, headers="Accept=application/json")
    public int getCreatUser(@PathVariable("email") String email) {
//                            @PathVariable("password") String password, 
//                            @PathVariable("confirmpassword") String confirmpassword) {
        try {
            logger.info("Start getAllUsers");
            
//            Resource resource = new DefaultResourceLoader().getResource(PATH);
//            FileParser parser = new XmlToJsonParser();
//            TrackInfoArray allTracks = parser.parseFile(resource.getFile().getAbsolutePath());
            
            System.out.println("email: " + email);
//            System.out.println("mpassword: " + password);
//            System.out.println("confirmpassword: " + confirmpassword);
            
            return 0;
        //} catch (IOException ex) {
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
}
