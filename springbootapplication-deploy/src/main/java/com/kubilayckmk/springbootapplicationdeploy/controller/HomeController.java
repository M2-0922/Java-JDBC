/*
 * @author kubilaycakmak
 * @date Nov 08, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springbootapplicationdeploy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kubilayckmk.springbootapplicationdeploy.dao.iEmployeeRepository;
import com.kubilayckmk.springbootapplicationdeploy.dao.iProjectRepository;
import com.kubilayckmk.springbootapplicationdeploy.dto.ChartData;
import com.kubilayckmk.springbootapplicationdeploy.dto.EmployeeProject;
import com.kubilayckmk.springbootapplicationdeploy.entity.Employee;
import com.kubilayckmk.springbootapplicationdeploy.entity.Project;

@Controller
public class HomeController {

    @Value("${version}")
    String versionControl;

    @Autowired
    iProjectRepository projectRepository;

    @Autowired
    iEmployeeRepository employeeRepository;
    
    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException{
        List<Project> projects = projectRepository.findAll();
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeProject> employeeProjects = employeeRepository.employeeProjects();
        List<ChartData> chartDatas = projectRepository.getProjectStatus();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonChartData = objectMapper.writeValueAsString(chartDatas);

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        model.addAttribute("employeeProjects", employeeProjects);
        model.addAttribute("jsonChartData", jsonChartData);
        model.addAttribute("version", versionControl);
        
        return "home/index";
    }
}
