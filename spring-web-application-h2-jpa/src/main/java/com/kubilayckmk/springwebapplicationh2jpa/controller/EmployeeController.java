package com.kubilayckmk.springwebapplicationh2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kubilayckmk.springwebapplicationh2jpa.dao.iProjectRepository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Project;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    // Autowired is used to inject the dependency by type
    @Autowired
    iEmployeesRepository employeesRepository;
    
    @GetMapping("/nuevo")
    public String displayEmployeeForm(Modelo modelo){
        modelo.addAttribute("employee", new Employee());
        return "employees/nuevo-employees";
    }

    @PostMapping("/saving")
    public String createEmployee(Employee employee, Modelo modelo){
        employeesRepository.save(employee);
        return "redirect:/employees/nuevo";
    }
}
