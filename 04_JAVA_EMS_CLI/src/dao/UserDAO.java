/*
 * @author kubilaycakmak
 * @date Nov 03, 2022
 * @version 1.0
 */
 
package dao;

import java.util.List;

import dto.User;

public interface UserDAO {

    public static final String URL = "jdbc:mysql://127.0.0.1:3306/user";
    public static final String USER = "root";
    public static final String PASSWORD = "jumpeiyamana";

    public void insert(User user);
    public void update(User user);
    public void delete(int id);
    public User getById(int id);
    public List<User> getAll();
    public User getByEmailAndPassword(String email, String password);
}