package sql.crud.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertData {

	private static final String URL = "jdbc:postgresql://localhost:5432/tnsiftraining";
    private static final String USER = "postgres";
    private static final String PASSWORD = "madhav123";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create table if it does not exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS employees (" +
                                      "id SERIAL PRIMARY KEY, " +
                                      "name VARCHAR(50), " +
                                      "position VARCHAR(40), " +
                                      "salary INT)";
            try (PreparedStatement createTableStmt = connection.prepareStatement(createTableQuery)) {
                createTableStmt.executeUpdate();
            }

            // Insert a new employee
            String insertQuery = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
                insertStmt.setString(1, "John Doe");
                insertStmt.setString(2, "Software Engineer");
                insertStmt.setInt(3, 70000);
                insertStmt.executeUpdate();
                
                insertStmt.setString(1, "ram");
                insertStmt.setString(2, "Doctor");
                insertStmt.setInt(3, 100000);
                insertStmt.executeUpdate();
                insertStmt.setString(1, "dimple");
                insertStmt.setString(2, "Engineer");
                insertStmt.setInt(3, 79000);
                insertStmt.executeUpdate();
            }

            // Read employees
            String selectQuery = "SELECT * FROM employees\r\n"
            		+ "ORDER BY id ASC;";
            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
                 ResultSet resultSet = selectStmt.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String position = resultSet.getString("position");
                    int salary = resultSet.getInt("salary");
                    System.out.println(id + ", " + name + ", " + position + ", " + salary);
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
