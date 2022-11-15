/*
 * @author kubilaycakmak
 * @date Nov 09, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springbootapplicationdeploy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kubilayckmk.springbootapplicationdeploy.dto.EmployeeProject;
import com.kubilayckmk.springbootapplicationdeploy.entity.Employee;

public interface iEmployeeRepository extends JpaRepository<Employee, Long>{

    @Override
    List<Employee> findAll();

    @Query(nativeQuery = true, value = "SELECT e.first_name as firstName, e.last_name as lastName, " +
    "COUNT(pe.employee_id) as countofproject " +
    "FROM employee e " +
    "LEFT JOIN project_employee pe " +
    "ON e.employee_id = pe.employee_id " +
    "GROUP BY e.first_name, e.last_name " +
    "ORDER BY 3 DESC;")
    public List<EmployeeProject> employeeProjects();

}
