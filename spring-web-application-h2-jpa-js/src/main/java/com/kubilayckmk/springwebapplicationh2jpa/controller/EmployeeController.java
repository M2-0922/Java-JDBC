/*
 * @author kubilaycakmak
 * @date Nov 09, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplicationh2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kubilayckmk.springwebapplicationh2jpa.dao.iEmployeeRepository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    iEmployeeRepository employeeRepository;
    
    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employee/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        employeeRepository.save(employee);
        return "redirect:/employee/new";
    }
}
