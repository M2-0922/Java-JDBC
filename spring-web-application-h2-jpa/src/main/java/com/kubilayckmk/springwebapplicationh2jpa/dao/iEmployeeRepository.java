package com.kubilayckmk.springwebapplicationh2jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubilayckmk.springwebapplicationh2jpa.entity.Employee;

import java.util.List;

public interface iEmployeeRepository extends CrudRepository<Employee, Long>{

  @Override
  public List<Employee> findAll();

}