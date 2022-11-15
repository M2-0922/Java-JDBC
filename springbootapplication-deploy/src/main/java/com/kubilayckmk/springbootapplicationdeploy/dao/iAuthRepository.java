/*
 * @author kubilaycakmak
 * @date Nov 15, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springbootapplicationdeploy.dao;

import org.springframework.data.repository.CrudRepository;

import com.kubilayckmk.springbootapplicationdeploy.entity.User;

public interface iAuthRepository extends CrudRepository<User, Long> {

    User findByEmailAndPassword(String email, String password);
    
}
