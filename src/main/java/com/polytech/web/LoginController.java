package com.polytech.web;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by User on 17/03/2017.
 */
public class LoginController {
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

}
