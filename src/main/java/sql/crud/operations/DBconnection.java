package sql.crud.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	public static void main(String[] args) {
		String dbURL = "jdbc:postgresql://localhost:5432/tnsiftraining";
		String username = "postgres";
		String password = "madhav123";
		 
		try {
		 
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
		    if (conn != null) {
		        System.out.println("Connected to the database");
		        conn.close();
		    }
		} catch (SQLException ex) {
			ex.printStackTrace();
		    		

		}
}
}
