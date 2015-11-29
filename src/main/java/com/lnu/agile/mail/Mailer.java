/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lnu.agile.mail;

/**
 *
 * @author olefir
 */
public interface Mailer {

    public void sendMail(String to, String subject, String body);

}
