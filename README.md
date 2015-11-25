# 4DV611-server

Backend structure:
Framework: Spring
Build (management) tool: Maven
Servlet container: Apache Tomcat 8
Spring 4

The Spring Framework provides a comprehensive programming and configuration model for modern Java-based enterprise applications - on any kind of deployment platform. A key element of Spring is infrastructural support at the application level: Spring focuses on the "plumbing" of enterprise applications so that teams can focus on application-level business logic, without unnecessary ties to specific deployment environments.

#Project structure (packages):

*controller - in Spring’s approach to building RESTful web services, HTTP requests are handled by a controller. These components are easily identified by the @RestController annotation;

*model - entities;

*security - user authentication;

*utility - handle connections to database;

*dao - classes that performs data access operations to get data from database;

*json - parsing data.

Maven

Project management and comprehension tool. Maven provides developers a complete build lifecycle framework. Development team can automate the project's build infrastructure in almost no time as Maven uses a standard directory layout and a default build lifecycle. The pom.xml file is the core of a project's configuration in Maven. It is a single configuration file that contains the majority of information required to build a project in just the way you want

Tomcat

Web container used for deploying and running web application based on Java. Tomcat can also work as a basic web server. Most of the modern Java web frameworks are based on servlets, e.g. JavaServer Faces, Struts, Spring. If you use IDE Intellij IDEA, Apache Tomcat 8 is embedded to it. So you don't need to install it separately in such case

Java (jvm)

Project requires Java 8

##URL conventions

GET: GET_ALL_TRACK = "/tracks";

GET: GET_TRACK = "/tracks/{id}";

POST: CREATE_TRACK = "/tracks/create";

DELETE: DELETE_TRACK = "/tracks/delete/{id}";

PUT: UPDATE_TRACK = "/tracks/update/{id}";

