package com.lnu.agile.controller;

/**
 * Created by olefir on 11/22/2015.
 */
import java.util.concurrent.atomic.AtomicLong;

import com.lnu.agile.model.Home;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Test controller for checking connection
 */
@RestController
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Home greeting(@RequestParam(value="name", defaultValue="Test") String name) {
        return new Home(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/greeting/test")
    public Home greetingTest(@RequestParam(value = "name", defaultValue = "Test") String name) {
        return new Home(counter.incrementAndGet(),
                String.format(template, name + "123"));
    }

    /*@RequestMapping(value = "/")
    public String home(Locale locale, Model model) {

        return "homef";
    } */
}
