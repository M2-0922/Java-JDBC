/*
 * @author kubilaycakmak
 * @date Nov 08, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springbootapplicationdeploy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kubilayckmk.springbootapplicationdeploy.dto.ChartData;
import com.kubilayckmk.springbootapplicationdeploy.entity.Project;

public interface iProjectRepository extends CrudRepository<Project, Long> {
    
    @Override
    public List<Project> findAll();

    @Query(nativeQuery = true, value = "SELECT project_stage as label, COUNT(*) as count from project group by project_stage;")
    public List<ChartData> getProjectStatus();
    
}
