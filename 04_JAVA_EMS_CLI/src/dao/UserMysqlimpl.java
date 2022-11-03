/*
 * @author kubilaycakmak
 * @date Nov 03, 2022
 * @version 1.0
 */
 
package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import dto.User;

public class UserMysqlimpl implements UserDAO{

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static final String INSERT = "INSERT INTO user_table (name, lastname, email, password) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user_table SET name = ?, lastname = ?, password = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM user_table WHERE id = ?";
    private static final String GET_BY_ID = "SELECT * FROM user_table WHERE id = ?";
    private static final String GET_ALL = "SELECT * FROM user_table";
    private static final String GET_BY_EMAIL_AND_PASSWORD = "SELECT * FROM user_table WHERE email = ? AND password = ?";

    public UserMysqlimpl() {
        try {
            connection = DriverManager.getConnection(UserDAO.URL, UserDAO.USER, UserDAO.PASSWORD);
            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println("Unable to connect!");
            e.printStackTrace();
        }
    }

    @Override
    public void insert(User user) {
        int rowAffected = 0;

        try {
            preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());

            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected!");
            // executeUpdate returns 1 or 2 (int)
            // executeQuery it will return the data from database; (String)

        } catch (SQLException e) {
            System.out.println("Unable to insert!");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        if(rowAffected > 0){
            System.out.println("Insert is success!");
        }
    }

    @Override
    public void update(User user) {
        int rowAffected = 0;

        try {
            preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastname());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getId());

            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected!");

        } catch (SQLException e) {
            System.out.println("Unable to update!");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        if(rowAffected > 0){
            System.out.println("Update is success!");
        }
    }

    @Override
    public void delete(int id) {
        int rowAffected = 0;

        try {
            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1, id);

            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected!");

        } catch (SQLException e) {
            System.out.println("Unable to delete!");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
            }
        }

        if(rowAffected > 0){
            System.out.println("Delete is sucess!");
        }

    }

    @Override
    public User getById(int id) {
        User user = null;

        try {
            preparedStatement = connection.prepareStatement(GET_BY_ID);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Unable to find the user!");
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new LinkedList<>();
        try {
            preparedStatement = connection.prepareStatement(GET_ALL);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override
    public User getByEmailAndPassword(String email, String password) {
        User user = null;

        try {
            preparedStatement = connection.prepareStatement(GET_BY_EMAIL_AND_PASSWORD);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLastname(resultSet.getString("lastname"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        return user;
    }
    
}
