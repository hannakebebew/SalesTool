package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class DatabaseConnectMySQL {
	
	
//	Host: sql9.freesqldatabase.com
//	Database name: sql9256021
//	Database user: sql9256021
//	Database password: eaLa2KTHR8
//	Port number: 3306
public static void main(String[] args) throws SQLException {
	

	
	String url = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9256021";
	String username = "sql9256021";
	String password = "eaLa2KTHR8";

	System.out.println("Connecting database...");

	try (Connection connection = DriverManager.getConnection(url, username, password)) {
	    System.out.println("Database connected!");
	} catch (SQLException e) {
	    throw new IllegalStateException("Cannot connect the database!", e);
	}
	
	
	Connection conn = DriverManager.getConnection(url, username, password);
	Statement stmt = conn.createStatement();
	
	
	//stmt.execute("CREATE TABLE Test (Name Varchar(255), Address varchar(255) )");
	
	ResultSet rs = stmt.executeQuery("Select * from Test");
	
	
	while(rs.next()) {
		System.out.println(rs.getString(0));
	}
	
	
	
	
	
}
}