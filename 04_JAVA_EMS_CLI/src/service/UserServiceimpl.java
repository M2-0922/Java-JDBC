/*
 * @author kubilaycakmak
 * @date Nov 03, 2022
 * @version 1.0
 */
 
package service;

import java.util.List;

import dao.UserDAO;
import dao.UserMysqlimpl;
import dto.User;

public class UserServiceimpl implements UserService {

    private UserDAO userDAO = new UserMysqlimpl();

    @Override
    public void insert(User user) {
        userDAO.insert(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    @Override
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        return userDAO.getByEmailAndPassword(email, password);
    }
    
}
