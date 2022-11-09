package com.kubilayckmk.springwebapplicationh2jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kubilayckmk.springwebapplicationh2jpa.dao.*;
import com.kubilayckmk.springwebapplicationh2jpa.entity.*;

@Controller
public class HomeController {

    @Autowired
    iProjectRepository projectRepository;
    EmployeeRepository employeeRepository;
    
    @GetMapping("/")
    public String displayHome(Model model){     
        List<Project> projects = projectRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        
        return "home/index";
    }
}
