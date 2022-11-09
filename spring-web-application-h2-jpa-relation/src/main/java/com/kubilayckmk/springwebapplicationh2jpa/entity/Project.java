/*
 * @author kubilaycakmak
 * @date Nov 08, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplicationh2jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
    
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;

    private String projectName;
    private String projectStage; // COMPLETED, CANCELED, IN-PROGRESS
    private String projectDescription;

    @ManyToMany(cascade = {CascadeType.DETACH, 
        CascadeType.MERGE, 
        CascadeType.REFRESH, 
        CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(name="project_employee", 
        joinColumns = @JoinColumn(name = "projectId"),
        inverseJoinColumns = @JoinColumn(name ="employeeId"))
    List<Employee> employees;

    public Project() {
    }

    public Project(String projectName, String projectStage, String projectDescription) {
        this.projectName = projectName;
        this.projectStage = projectStage;
        this.projectDescription = projectDescription;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStage() {
        return projectStage;
    }

    public void setProjectStage(String projectStage) {
        this.projectStage = projectStage;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
