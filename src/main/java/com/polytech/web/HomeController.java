package com.polytech.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by User on 15/03/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String home(){
        System.out.println("home");
        return "forward:index.html";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        System.out.println("login");
        return "login";
    }

}
