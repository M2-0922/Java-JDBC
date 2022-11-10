package com.kubilayckmk.springwebapplicationh2jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kubilayckmk.springwebapplicationh2jpa.dao.EmployeeRepository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;

@Controller
@RequestMapping("/employee")

public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, RedirectAttributes redir) {
        Employee saved = employeeRepository.save(employee);
        // redir.addAttribute("employeeId", saved.getEmployeeId());
        return "redirect:/employee/new";
    }

}
