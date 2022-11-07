/*
 * @author kubilaycakmak
 * @date Nov 07, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplication1.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(){
        return 
        "<form action=\"/home\" method=\"POST\" >" +
        "<label for=\"fname\">First name:</label><br>" +
        "<input type='text' name='firstName' placeholder='Ex. Joe Doe'/> </br>" +
        "<label for=\"lname\">Password:</label><br>" +
        "<input type='password' name='password' placeholder='********'/> </br></br>" +
        "<input type='submit' value='Register'/>" +
        "</form>";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String home(@RequestParam String firstName, @RequestParam String password){
        return "<h1>Hello " + firstName + " | password: " + password + "</h1>";
    }

    // /order/123
    @RequestMapping(value = "/order/{id}")
    public String order(@PathVariable String id){
        return "<h1> Order id: " + id + "</h1>";
    }

}
