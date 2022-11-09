package com.kubilayckmk.springwebapplicationh2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kubilayckmk.springwebapplicationh2jpa.dao.iEmployeeRespository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    iEmployeeRespository employeeRepository;

    @GetMapping("/addEmployee")
    public String getEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "pronject/new-employee";
    }

    @PostMapping("/save")
    public String createProject(Employee employee, Model model) {
        employeeRepository.save(employee);
        return "redirect:/employee/addEmployee";
    }
}
