package sql.crud.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

//import com.mysql.cj.jdbc.CallableStatement;

public class Rectivedata {
	private static final String URL = "jdbc:postgresql://localhost:5432/tnsiftraining";
    private static final String USER = "postgres";
    private static final String PASSWORD = "madhav123";
	public static void main(String[] args) {
	
		        try {
		            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

		            
		            
		            // Create
		          /*  String insertQuery = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
		            try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
		                insertStmt.setString(1, "John Doe");
		                insertStmt.setString(2, "Software");
		                insertStmt.setInt(3, 70000);
		                insertStmt.executeUpdate();
		            }*/

		            // Read
		            String selectQuery = "SELECT * FROM employees\r\n"
		            		+ "ORDER BY id ASC;";
		            try (PreparedStatement selectStmt = connection.prepareStatement(selectQuery);
		                 ResultSet resultSet = selectStmt.executeQuery()) {

		                while (resultSet.next()) {
		                   // int id = resultSet.getInt("id");
		                    String name = resultSet.getString("name");
		                    String position = resultSet.getString("position");
		                    int salary = resultSet.getInt("salary");
		                    System.out.println(
		                    		
		                    		name + ", " + position + ", " + salary);
		                }
		            }

		      
		            connection.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		

		
}
