package sql.crud.operations;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class CallableDemo {
	private static final String URL = "jdbc:postgresql://localhost:5432/tnsiftraining";
    private static final String USER = "postgres";
    private static final String PASSWORD = "madhav123";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

	
      //  try {
        	 Class.forName("org.postgresql.Driver");
		            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		            // SQL to call the function
		            String sql = "SELECT add_numbers(?, ?)";

		            // Prepare statement
		         //  CallableStatement  pstmt = conn.prepareStatement(sql);
		            CallableStatement  pstmt=conn.prepareCall(sql);
		            pstmt.setInt(1, 2); // First parameter
		            pstmt.setInt(2, 10); // Second parameter
		            pstmt.registerOutParameter(Types.INTEGER);
		            // Execute query
		             pstmt.execute();
		             pstmt.close();
		            // Process the result
		        /*    if (((ResultSet) pstmt).next()) {
		                int result = pstmt.getInt(1);
		                System.out.println("Result of add_numbers(5, 10): " + result);
		            }

		         

     conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    
        
        
		        }
}