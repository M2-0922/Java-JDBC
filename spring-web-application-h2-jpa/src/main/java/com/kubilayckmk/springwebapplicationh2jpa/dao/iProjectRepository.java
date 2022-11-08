/*
 * @author kubilaycakmak
 * @date Nov 08, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplicationh2jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.kubilayckmk.springwebapplicationh2jpa.entity.Project;

public interface iProjectRepository extends CrudRepository<Project, Long> {
    
    @Override
    public List<Project> findAll();
}
