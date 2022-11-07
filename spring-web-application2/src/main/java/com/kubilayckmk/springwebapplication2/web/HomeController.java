/*
 * @author kubilaycakmak
 * @date Nov 07, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplication2.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kubilayckmk.springwebapplication2.domain.User;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("formData", new User());
        // return "pages/index"; //preped pages
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processFormData(User user, RedirectAttributes attr){
        attr.addFlashAttribute("user", user);
        return "redirect:display";
    }

    @RequestMapping(value = "/display")
    public String displayResult(){
        return "result";
    }
    
}
