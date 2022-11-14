/*
 * @author kubilaycakmak
 * @date Nov 10, 2022
 * @version 1.0
 */
 
package com.kubilayckmk.springwebapplicationh2jpa.dto;

public interface EmployeeProject {
    
    public String getFirstName();
    public String getLastName();
    public String getCountOfProject();

    // JPA will understand that this is a getter method.
    // and it will use this method to get the value of column
}
