import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {

        final String URL = "jdbc:postgresql://localhost:5432/m20922";
        final String USER = "postgres";
        final String PASSWORD = "toor";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            
            System.out.println("Connected!");
            String insertQuery = "INSERT INTO user_table (name, email) VALUES ('John', 'john@test.com')";
            String deleteQuery = "DELETE FROM user_table WHERE id = 3";
            // statement.executeUpdate(insertQuery);
            // System.out.println("Insert success!");

            statement.executeUpdate(deleteQuery);
            System.out.println("Delete is success!");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_table");
            System.out.println("Read success!");

            while(resultSet.next()){
                System.out.println(resultSet.getString("name") + " | " + resultSet.getString("email"));
            }
            
        } catch (SQLException e) {
            System.out.println("Unable to connect!");
            e.printStackTrace();
        }
    }
}
