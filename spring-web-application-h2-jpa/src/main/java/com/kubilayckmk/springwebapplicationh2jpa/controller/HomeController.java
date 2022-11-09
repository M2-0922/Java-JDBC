package com.kubilayckmk.springwebapplicationh2jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kubilayckmk.springwebapplicationh2jpa.dao.iEmployeeRepository;
import com.kubilayckmk.springwebapplicationh2jpa.dao.iProjectRepository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Project;

@Controller
public class HomeController {
    @Autowired
    iProjectRepository projectRepository;
    @Autowired
    iEmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model){
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);

        List<Employee> employee = employeeRepository.findAll();
        model.addAttribute("employee", employee);

        return "home/index";
    }
}
