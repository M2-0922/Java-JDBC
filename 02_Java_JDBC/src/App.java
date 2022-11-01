import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {

        try {
            getConnection();
        } catch (SQLException e) {
            System.out.println("Unable to connect!");
        }

    }

    public static void getConnection() throws SQLException {
        // credentials
        String url = "jdbc:mysql://127.0.0.1:3306/employee_database";
        String user = "root";
        String password = "toortoor";

        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        ResultSet resultSet = null;
        int rowAffected = 0;

        System.out.println("Connection Successful");
        resultSet = statement.executeQuery("SELECT * FROM employee_table");

        while(resultSet.next()){
            System.out.println(
                resultSet.getInt("id") + 
                "~ Name: " + 
                resultSet.getString("name") + " | Department:  " +
                resultSet.getString("department") + " | Salary:  " +
                resultSet.getInt("salary")
            );
        }

        // rowAffected = statement.executeUpdate("INSERT INTO employee_table (name, department, salary) VALUES ('Alex', 'IT', 50000)");
        // System.out.println(rowAffected + " row(s) affected!");
        // resultSet = statement

        // rowAffected = statement.executeUpdate("DELETE FROM employee_table WHERE id = 7");
        // rowAffected = statement.executeUpdate("DELETE FROM employee_table WHERE employee_table.name = 'Alex'");
        
        rowAffected = statement.executeUpdate("UPDATE employee_table SET salary = 100000 WHERE id = 3");
        System.out.println(rowAffected + " row(s) affected!");

        resultSet = statement.executeQuery("SELECT * FROM employee_table");

        while(resultSet.next()){
            System.out.println(
                resultSet.getInt("id") + 
                "~ Name: " + 
                resultSet.getString("name") + " | Department:  " +
                resultSet.getString("department") + " | Salary:  " +
                resultSet.getInt("salary")
            );
        }
        // resultSet.close();
    }
}