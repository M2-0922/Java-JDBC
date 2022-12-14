/*
 * @author kubilaycakmak
 * @date Nov 08, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplicationh2jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kubilayckmk.springwebapplicationh2jpa.dao.iEmployeeRepository;
import com.kubilayckmk.springwebapplicationh2jpa.dao.iProjectRepository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Project;

@Controller
@RequestMapping("/project")
public class ProjectController {

    // Autowired is used to inject the dependency by type
    @Autowired
    iProjectRepository projectRepository;

    @Autowired
    iEmployeeRepository employeeRepository;
    
    @GetMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project", new Project());
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employees", employees);
        return "project/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        projectRepository.save(project);
        return "redirect:/project/new";
    }
}
