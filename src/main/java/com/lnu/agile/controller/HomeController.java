package com.lnu.agile.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import java.util.Locale;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the Home Page
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
        
        @RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		logger.info("Welcome!", locale);
		
		return "home";
	}
	
}
