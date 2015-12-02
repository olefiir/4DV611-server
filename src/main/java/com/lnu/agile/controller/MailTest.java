/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.controller;

import com.lnu.agile.mail.ApplicationMailer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author olefir
 */
public class MailTest {
    @SuppressWarnings("resource")
	public static void main(String args[]) {
 
        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");
         
        //Get the mailer instance
        ApplicationMailer mailer = (ApplicationMailer) context.getBean("mailService");
 
        //Send a composed mail
        mailer.sendMail("xuebo.sun@gmail.com", "Test Subject", "Testing body");
        System.out.println("good");
	}
}
