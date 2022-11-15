package com.kubilayckmk.springwebapplicationh2jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;

public interface iEmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();
}
