/*
 * @author kubilaycakmak
 * @date Nov 09, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplicationh2jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;

public interface iEmployeeRepository extends JpaRepository<Employee, Long>{

    @Override
    List<Employee> findAll();

}
