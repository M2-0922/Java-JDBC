package com.kubilayckmk.springwebapplicationh2jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kubilayckmk.springwebapplicationh2jpa.dao.iEmployeeRepository;
import com.kubilayckmk.springwebapplicationh2jpa.dao.iProjectRepository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;


@Controller
@RequestMapping("/employee")
public class EmpController {

    // Autowired is used to inject the dependency by type
    @Autowired
    iEmployeeRepository employeeRepository;

    @GetMapping("/addEmployee")
    public String displayEmpForm(Model model){
        model.addAttribute("employee", new Employee());
        return "project/new-employee";
    }

    @PostMapping("/save")
    public String createProject(Employee employee, Model model){
      employeeRepository.save(employee);
        return "redirect:/employee/addEmployee";
    }
}
