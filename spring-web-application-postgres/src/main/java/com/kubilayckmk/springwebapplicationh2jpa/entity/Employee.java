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
import javax.persistence.SequenceGenerator;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "employee_sequence")
    private long employeeId;
    
    private String firstName; 
    private String lastName;
    private String email;

    @ManyToMany(cascade = 
    {CascadeType.DETACH, 
        CascadeType.MERGE, 
        CascadeType.REFRESH, 
        CascadeType.PERSIST},
        fetch = FetchType.EAGER)
    @JoinTable(name="project_employee", 
    joinColumns = @JoinColumn(name = "employeeId"),
    inverseJoinColumns = @JoinColumn(name ="projectId"))
    private List<Project> projects;
    
    public Employee() {
    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return firstName;
        // John Doe
    }
}