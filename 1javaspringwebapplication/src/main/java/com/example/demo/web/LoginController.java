package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController{ 

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login(){
        return "<h1>Login Page</h1>";
    }
}