/*
 * @author kubilaycakmak
 * @date Nov 02, 2022
 * @version 1.0
 */
 
package dao;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import dto.Employee;
import exception.EmployeeNotFoundException;

public class EmployeeDAOMysqlimpl implements EmployeeDAO {
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    // CREATE, READ, UPDATE, DELETE = CRUD

    // ? is placeholder for dynamic data;
    private static final String INSERT_EMPLOYEE = 
        "INSERT INTO employee_table" +
        "(id, name, department, dayAbsent, salary)" +
        "VALUES (?, ?, ?, ?, ?)";

    private static final String DELETE_EMPLOYEE = 
        "DELETE FROM employee_table WHERE id = ?";

    private static final String FIND_EMPLOYEE = 
        "SELECT * FROM employee_table WHERE id = ?";

    private static final String FIND_ALL = "SELECT * FROM employee_table";

    private static final String update_employee = "update employee_table set name = ?, department = ?, dayAbsent = ?, salary = ? where id = ?";
    private static final String update_all_employee = "update employee_table set name = ?, department = ?, dayAbsent = ?, salary = ?";
    private static final String update_all_employee_name = "update employee_table set name = ?";
    private static final String update_all_employee_department = "update employee_table set department = ?";
    private static final String update_all_employee_dayAbsent = "update employee_table set dayAbsent = ?";
    private static final String update_all_employee_salary = "update employee_table set salary = ?";


    public EmployeeDAOMysqlimpl (){
        try {
            connection = DriverManager
                .getConnection(EmployeeDAO.URL, EmployeeDAO.USER, EmployeeDAO.PASSWORD);

            System.out.println("Connection success!");
        } catch (SQLException e) {
            System.out.println("Unable to connect!");
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(Employee e) {
        int rowAffected = 0;

        try {
            preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE);
            preparedStatement.setInt(1, e.getId());
            preparedStatement.setString(2, e.getName());
            preparedStatement.setString(3, e.getDepartment());
            preparedStatement.setInt(4, e.getDayAbsent());
            preparedStatement.setInt(5, e.getSalary());

            // executeUpdate for adding, deleting, and updating some records on db
            // executeQuery will return you a ResultSet type value;
            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected!");

        } catch (SQLException exception) {
            System.out.println("Unable to add the employee");
            exception.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e1) {
                System.out.println("Unable to close the statement!");
                e1.printStackTrace();
            }
        }

        if(rowAffected > 0) {
            System.out.println("Employee added successfully");
        }
    }

    @Override
    public void deleteEmployee(int id) {
        int rowAffected = 0;

        try {
            preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id);

            rowAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Unable to delete this employee!");
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
            System.out.println("Employee deleted successfully");
        }
    }

    @Override
    public Employee findEmployee(int id) throws EmployeeNotFoundException {
        
        Employee employee = null;

        try {
            preparedStatement = connection.prepareStatement(FIND_EMPLOYEE);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();
            
            if(!resultSet.next()){
                throw new EmployeeNotFoundException(id);
            }

            employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setName(resultSet.getString("name"));
            employee.setDepartment(resultSet.getString("department"));
            employee.setDayAbsent(resultSet.getInt("dayAbsent"));
            employee.setSalary(resultSet.getInt("salary"));

        } catch (SQLException e) {
            System.out.println("Unable to find the employee with id: " + id);
        } finally{ 
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        return employee;
    }

    @Override
    public List<Employee> findAllEmployees() throws EmployeeNotFoundException {
        
        Employee employee = null;
        List<Employee> employees = new LinkedList<>();

        try {
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setDepartment(resultSet.getString("department"));
                employee.setDayAbsent(resultSet.getInt("dayAbsent"));
                employee.setSalary(resultSet.getInt("salary"));
                employees.add(employee);
            }

        } catch (SQLException e) {
            System.out.println("Unable to find all employees");
            e.printStackTrace();
        } finally{
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Unable to close the statement!");
                e.printStackTrace();
            }
        }

        return employees;
    }

    @Override
    public void updateEmployee(Employee e) throws EmployeeNotFoundException {
        int rowAffected = 0;

        try {
            
            preparedStatement = connection.prepareStatement(FIND_ALL);
            preparedStatement.setInt(1, e.getId());

            resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                throw new EmployeeNotFoundException(e.getId());
            }

            preparedStatement = connection.prepareStatement(update_employee);
            preparedStatement.setString(1, e.getName());
            preparedStatement.setString(2, e.getDepartment());
            preparedStatement.setInt(3, e.getDayAbsent());
            preparedStatement.setInt(4, e.getSalary());
            preparedStatement.setInt(5, e.getId());

            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected");

        }catch(SQLException e1){
            System.out.println("Unable to update the employee with id: " + e.getId());
            e1.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e2) {
                System.out.print("Unable to close the statement");
                e2.printStackTrace();
            }
        }

        if(rowAffected > 0) {
            System.out.println("Succeed in updating employee");
        }        
    }

    @Override
    public void updateAllEmployee(Employee e) throws EmployeeNotFoundException {
        int rowAffected = 0;

        try {
            
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                throw new EmployeeNotFoundException();
            }

            preparedStatement = connection.prepareStatement(update_all_employee);
            preparedStatement.setString(1, e.getName());
            preparedStatement.setString(2, e.getDepartment());
            preparedStatement.setInt(3, e.getDayAbsent());
            preparedStatement.setInt(4, e.getSalary());

            rowAffected = preparedStatement.executeUpdate();
            System.out.println(rowAffected + " row(s) affected");

        }catch(SQLException e1){
            System.out.println("Unable to update the employees");
            e1.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e2) {
                System.out.print("Unable to close the statement");
                e2.printStackTrace();
            }
        }

        if(rowAffected > 0) {
            System.out.println("Succeed in updating employee");
        }
    }

    @Override
    public void updateAllColumnEmployee(Employee e, String... column) throws EmployeeNotFoundException {
        int rowAffected = 0;

        try {
            
            preparedStatement = connection.prepareStatement(FIND_ALL);
            resultSet = preparedStatement.executeQuery();

            if(!resultSet.next()){
                throw new EmployeeNotFoundException();
            }

            for(String col: column){
                if(col.equals("name")){
                    preparedStatement = connection.prepareStatement(update_all_employee_name);
                    preparedStatement.setString(1, e.getName());
                }else if(col.equals("department")){
                    preparedStatement = connection.prepareStatement(update_all_employee_department);
                    preparedStatement.setString(1, e.getDepartment());
                }else if(col.equals("dayAbsent")){
                    preparedStatement = connection.prepareStatement(update_all_employee_dayAbsent);
                    preparedStatement.setInt(1, e.getDayAbsent());
                }else if(col.equals("salary")){
                    preparedStatement = connection.prepareStatement(update_all_employee_salary);
                    preparedStatement.setInt(1, e.getSalary());
                }else{
                    continue;
                }
                
                rowAffected = preparedStatement.executeUpdate();
                System.out.println(rowAffected + " row(s) affected with column: " + col);
            }

        }catch(SQLException e1){
            System.out.println("Unable to update the employees");
            e1.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
            }catch (SQLException e2) {
                System.out.print("Unable to close the statement");
                e2.printStackTrace();
            }
        }

        if(rowAffected > 0) {
            System.out.println("Succeed in updating employee");
        } 
    }

}
