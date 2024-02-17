import java.sql.*;

public class SQLInjectionProtectionExample {
    public static void main(String[] args) {
        try {
            // Issue: Vulnerable to SQL injection due to lack of prepared statements
            String username = "user123";
            String password = "' OR '1'='1"; // Malicious input

            // Connection establishment code here
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");

            // SQL query construction without prepared statements
            String query = "SELECT * FROM users WHERE username='" + username + "' AND password='" + password + "'";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Authentication logic here
            if (resultSet.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//The example is vulnerable to SQL injection attacks due to the direct concatenation of user input into SQL queries.
//Using prepared statements with parameterized queries is a secure way to protect against SQL injection attacks by separating SQL code from user data.
