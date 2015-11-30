package com.lnu.agile.config;

public class RestURIConstants {

	public static final String DUMMY_EMP = "/rest/emp/dummy";
	public static final String GET_EMP = "/rest/emp/{id}";
	public static final String GET_ALL_EMP = "/rest/emps";
	public static final String CREATE_EMP = "/rest/emp/create";
	public static final String DELETE_EMP = "/rest/emp/delete/{id}";
        
        public static final String GET_ALL_PROD = "/products";
        public static final String GET_PROD = "/products/{id}";
        public static final String CREATE_PROD = "/products/create";
        public static final String DELETE_PROD = "/products/delete/{id}";
        public static final String UPDATE_PROD = "/products/update/{id}";
        
        public static final String GET_ALL_TRACK = "/tracks";
        public static final String GET_TRACK = "/tracks/{id}";
        public static final String CREATE_TRACK = "/tracks/create";
        public static final String DELETE_TRACK = "/tracks/delete/{id}";
        public static final String UPDATE_TRACK = "/tracks/update/{id}";
        
        public static final String GET_ALL_USER = "/users";
        public static final String CREATE_USER = "/users/create/enduser?email={email}";
        
}
