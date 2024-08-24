package sql.crud.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deletedata {
	private static final String URL = "jdbc:postgresql://localhost:5432/tnsiftraining";
    private static final String USER = "postgres";
    private static final String PASSWORD = "madhav123";
    public static void main(String[] args) {
	
	         try {
	             Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

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

	                      
	             // Delete an employee
	             String deleteQuery = "DELETE FROM employees WHERE name = ?";
	             try (PreparedStatement deleteStmt = connection.prepareStatement(deleteQuery)) {
	                 deleteStmt.setString(1, "John Doe");
	                 deleteStmt.executeUpdate();
	             }

	             connection.close();
	         } catch (SQLException e) {
	             e.printStackTrace();
	         }
	     }
	 }
