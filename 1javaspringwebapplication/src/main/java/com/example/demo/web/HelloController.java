/*
 * @author kubilaycakmak
 * @date Nov 04, 2022
 * @version 1.0
 */
 
package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "<div><h1 style='color: red'>Hello Class</h1></div>";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(){
        return "<h1>About Page</h1>";
    }

}
