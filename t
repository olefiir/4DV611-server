[1mdiff --git a/pom.xml b/pom.xml[m
[1mindex e7ed23a..d7618af 100644[m
[1m--- a/pom.xml[m
[1m+++ b/pom.xml[m
[36m@@ -10,6 +10,7 @@[m
     <properties>[m
         <java-version>1.8</java-version>[m
         <org.springframework-version>4.0.0.RELEASE</org.springframework-version>[m
[32m+[m[32m        <spring.security.version>3.2.5.RELEASE</spring.security.version>[m
         <org.aspectj-version>1.7.4</org.aspectj-version>[m
         <org.slf4j-version>1.7.5</org.slf4j-version>[m
         <jackson.databind-version>2.2.3</jackson.databind-version>[m
[36m@@ -150,6 +151,33 @@[m
             <artifactId>mysql-connector-java-5.1.23-bin</artifactId>[m
             <version>SNAPSHOT</version>[m
         </dependency>[m
[32m+[m[32m        <dependency>[m
[32m+[m[32m            <groupId>com.lambdaworks</groupId>[m
[32m+[m[32m            <artifactId>scrypt</artifactId>[m
[32m+[m[32m            <version>1.4.0</version>[m
[32m+[m[32m            <type>jar</type>[m
[32m+[m[32m        </dependency>[m
[32m+[m[32m        <!-- Spring Security -->[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.springframework.security</groupId>[m
[32m+[m			[32m<artifactId>spring-security-web</artifactId>[m
[32m+[m			[32m<version>${spring.security.version}</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.springframework.security</groupId>[m
[32m+[m			[32m<artifactId>spring-security-config</artifactId>[m
[32m+[m			[32m<version>${spring.security.version}</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m		[32m<dependency>[m
[32m+[m			[32m<groupId>org.springframework.security.oauth</groupId>[m
[32m+[m			[32m<artifactId>spring-security-oauth2</artifactId>[m
[32m+[m			[32m<version>1.0.0.RELEASE</version>[m
[32m+[m		[32m</dependency>[m
[32m+[m[32m                <dependency>[m[41m  [m
[32m+[m[32m                    <groupId>org.springframework</groupId>[m[41m  [m
[32m+[m[32m                    <artifactId>spring-jdbc</artifactId>[m[41m  [m
[32m+[m[32m                    <version>${org.springframework-version}</version>[m[41m  [m
[32m+[m[32m                </dependency>[m[41m [m
     </dependencies>[m
     <build>[m
         <plugins>[m
[1mdiff --git a/src/main/java/com/lnu/agile/controller/MailTest.java b/src/main/java/com/lnu/agile/controller/MailTest.java[m
[1mdeleted file mode 100644[m
[1mindex b580a09..0000000[m
[1m--- a/src/main/java/com/lnu/agile/controller/MailTest.java[m
[1m+++ /dev/null[m
[36m@@ -1,29 +0,0 @@[m
[31m-/*[m
[31m- * To change this license header, choose License Headers in Project Properties.[m
[31m- * To change this template file, choose Tools | Templates[m
[31m- * and open the template in the editor.[m
[31m- */[m
[31m-package com.lnu.agile.controller;[m
[31m-[m
[31m-import com.lnu.agile.mail.ApplicationMailer;[m
[31m-import org.springframework.context.ApplicationContext;[m
[31m-import org.springframework.context.support.ClassPathXmlApplicationContext;[m
[31m-[m
[31m-/**[m
[31m- *[m
[31m- * @author olefir[m
[31m- */[m
[31m-public class MailTest {[m
[31m-    @SuppressWarnings("resource")[m
[31m-	public static void main(String args[]) {[m
[31m- [m
[31m-        ApplicationContext context = new ClassPathXmlApplicationContext("servlet-context.xml");[m
[31m-         [m
[31m-        //Get the mailer instance[m
[31m-        ApplicationMailer mailer = (ApplicationMailer) context.getBean("mailService");[m
[31m- [m
[31m-        //Send a composed mail[m
[31m-        mailer.sendMail("xuebo.sun@gmail.com", "Test Subject", "Testing body");[m
[31m-        System.out.println("good");[m
[31m-	}[m
[31m-}[m
[1mdiff --git a/src/main/java/com/lnu/agile/controller/TrackController.java b/src/main/java/com/lnu/agile/controller/TrackController.java[m
[1mindex c19de38..4d7fc3f 100644[m
[1m--- a/src/main/java/com/lnu/agile/controller/TrackController.java[m
[1m+++ b/src/main/java/com/lnu/agile/controller/TrackController.java[m
[36m@@ -15,6 +15,7 @@[m [mimport org.slf4j.Logger;[m
 import org.slf4j.LoggerFactory;[m
 import org.springframework.core.io.DefaultResourceLoader;[m
 import org.springframework.core.io.Resource;[m
[32m+[m[32mimport org.springframework.security.access.prepost.PreAuthorize;[m[41m[m
 import org.springframework.web.bind.annotation.PathVariable;[m
 import org.springframework.web.bind.annotation.RequestMapping;[m
 import org.springframework.web.bind.annotation.RequestMethod;[m
[36m@@ -25,12 +26,15 @@[m [mimport org.springframework.web.bind.annotation.RestController;[m
  *[m
  * @author olefir[m
  */[m
[32m+[m[41m[m
[32m+[m[41m[m
 @RestController[m
 public class TrackController {[m
     //trmporary location![m
     private final String PATH = "classpath:trackInfoArray.xml";[m
     private static final Logger logger = LoggerFactory.getLogger(TrackController.class);[m
 [m
[32m+[m[41m    [m
     @RequestMapping(value = RestURIConstants.GET_ALL_TRACK, method = RequestMethod.GET, headers="Accept=application/json")[m
     public TrackInfoArray getAllTracks() {[m
         try {[m
[1mdiff --git a/src/main/java/com/lnu/agile/controller/UserController.java b/src/main/java/com/lnu/agile/controller/UserController.java[m
[1mindex 2e6b41e..5dc0e27 100644[m
[1m--- a/src/main/java/com/lnu/agile/controller/UserController.java[m
[1m+++ b/src/main/java/com/lnu/agile/controller/UserController.java[m
[36m@@ -5,6 +5,7 @@[m
  */[m
 package com.lnu.agile.controller;[m
 [m
[32m+[m[32mimport com.lambdaworks.crypto.SCryptUtil;[m[41m[m
 import com.lnu.agile.config.RestURIConstants;[m
 import com.lnu.agile.db.model.dao.TpsUserDAO;[m
 import com.lnu.agile.db.model.pojo.TpsUser;[m
[36m@@ -61,13 +62,14 @@[m [mpublic class UserController {[m
     @RequestMapping(value = RestURIConstants.USER_CONFIRM, method = RequestMethod.GET)[m
     public @ResponseBody String userConfirm(@PathVariable("randomtoken") String randomtoken) {[m
         [m
[31m-        String webpage="<html><head>Results</head><body>Congratulations! The account has been activated!</body></html>";[m
[31m-        if (TpsUserDAO.updateUsersConfirmed(randomtoken) == 0) {[m
[31m-            [m
[31m-        } else if (TpsUserDAO.updateUsersConfirmed(randomtoken) == 2) {[m
[31m-            [m
[32m+[m[32m        String webpage="";[m[41m[m
[32m+[m[32m        int result = TpsUserDAO.updateUsersConfirmed(randomtoken);[m[41m[m
[32m+[m[32m        if (result == 0) {[m[41m[m
[32m+[m[32m            webpage = "<html><head><title>Results</title></head><body>Failed! user already has been activated!</body></html>";[m[41m[m
[32m+[m[32m        } else if (result == 2) {[m[41m[m
[32m+[m[32m            webpage = "<html><head><title>Results</title></head><body>Failed! service not available!</body></html>";[m[41m[m
         } else {[m
[31m-            [m
[32m+[m[32m            webpage = "<html><head><title>Results</title></head><body>Congratulations! The account has been activated!</body></html>";[m[41m[m
         }[m
         return webpage;[m
     }[m
[36m@@ -86,7 +88,11 @@[m [mpublic class UserController {[m
             if ( reguser.getPassword().equals(reguser.getConfirmPassword()) ) {[m
                 TpsUser user = new TpsUser(); // increment of userid is created in table[m
                 user.setUserEmail(reguser.getEmail());[m
[31m-                user.setUserPassword(reguser.getPassword());[m
[32m+[m[41m                [m
[32m+[m[32m                //Using SCrypt to encode password[m[41m [m
[32m+[m[32m                String generatedSecuredPasswordHash = SCryptUtil.scrypt(reguser.getPassword(), 16, 16, 16);[m[41m[m
[32m+[m[32m                //Sboolean matched = SCryptUtil.check(reguser.getPassword(), generatedSecuredPasswordHash);[m[41m[m
[32m+[m[32m                user.setUserPassword(generatedSecuredPasswordHash);[m[41m[m
    warning: LF will be replaced by CRLF in pom.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in src/main/resources/servlet-context.xml.
The file will have its original line endings in your working directory.
             [m
                 //random token[m
                 String randomToken = "";[m
[36m@@ -108,11 +114,12 @@[m [mpublic class UserController {[m
                 [m
                 user.setUserConfirmtoken(randomToken);[m
                [m
[32m+[m[32m                int result = TpsUserDAO.insertUser(user);[m[41m[m
             [m
[31m-                if (TpsUserDAO.insertUser(user)==0) {[m
[32m+[m[32m                if (result==0) {[m[41m[m
                     response.setStatus(403);[m
                     return null;[m
[31m-                } else if (TpsUserDAO.insertUser(user)==2) {[m
[32m+[m[32m                } else if (result==2) {[m[41m[m
                     response.setStatus(500);[m
                     return null;[m
 [m
[36m@@ -122,9 +129,9 @@[m [mpublic class UserController {[m
                     //Get the mailer instance[m
                     ApplicationMailer sm =  (ApplicationMailer) context.getBean("mailService");[m
                     [m
[31m-                    String to = "xuebo.sun@gmail.com";[m
[31m-                    String subject = "activate";[m
[31m-                    String body = "https://enigmatic-reaches-6021.herokuapp.com/users/u/"+randomToken;[m
[32m+[m[32m                    String to = reguser.getEmail();[m[41m[m
[32m+[m[32m                    String subject = "Activate link:";[m[41m[m
[32m+[m[32m                    String body = "https://enigmatic-reaches-6021.herokuapp.com/users/confirmation/"+randomToken;[m[41m[m
                     sm.sendMail(to, subject, body);[m
 [m
                     response.setStatus(200);[m
[1mdiff --git a/src/main/resources/servlet-context.xml b/src/main/resources/servlet-context.xml[m
[1mindex 51ea9cc..fa59084 100644[m
[1m--- a/src/main/resources/servlet-context.xml[m
[1m+++ b/src/main/resources/servlet-context.xml[m
[36m@@ -8,7 +8,7 @@[m
 		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">[m
 [m
 	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->[m
[31m-	[m
[32m+[m
 	<!-- Enables the Spring MVC @Controller programming model -->[m
 	<annotation-driven />[m
 [m
[1mdiff --git a/src/main/webapp/WEB-INF/spring/appServlet/mvc-dispatcher-servlet.xml b/src/main/webapp/WEB-INF/spring/appServlet/mvc-dispatcher-servlet.xml[m
[1mnew file mode 100644[m
[1mindex 0000000..0124bb2[m
[1m--- /dev/null[m
[1m+++ b/src/main/webapp/WEB-INF/spring/appServlet/mvc-dispatcher-servlet.xml[m
[36m@@ -0,0 +1,22 @@[m
[32m+[m[32m<?xml version="1.0" encoding="UTF-8"?>[m
[32m+[m[32m<beans xmlns="http://www.springframework.org/schema/beans"[m
[32m+[m[32m       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:context="http://www.springframework.org/schema/context"[m
[32m+[m[32m       xmlns:util="http://www.springframework.org/schema/util" xmlns:mvc="http://www.springframework.org/schema/mvc"[m
[32m+[m[32m       xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.2.xsd[m
[32m+[m[32m  http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd[m
[32m+[m[32m  http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util-3.2.xsd[m
[32m+[m[32m  http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.2.xsd">[m
[32m+[m[32m    <!-- @author Nagesh.Chauhan(neel4soft@gmail.com) -->[m
[32m+[m[32m    <context:component-scan base-package="com.beingjavaguys" />[m
[32m+[m[32m    <mvc:annotation-driven />[m
[32m+[m[41m        [m
[32m+[m[32m    <bean id="dataSource"[m[41m  [m
[32m+[m[32m            class="org.springframework.jdbc.datasource.DriverManagerDataSource">[m[41m  [m
[32m+[m[41m   [m
[32m+[m[32m        <property name="driverClassName" value="com.mysql.jdbc.Driver" />[mwarning: LF will be replaced by CRLF in src/main/webapp/WEB-INF/spring/appServlet/mvc-dispatcher-servlet.xml.
The file will have its original line endings in your working directory.
warning: LF will be replaced by CRLF in src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml.
The file will have its original line endings in your working directory.
