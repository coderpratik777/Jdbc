package com.pratiti.training.jdbc;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class Connecttodb{
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn =null;
		
		try {
			//Step 1:Loading the JDBC DRIVER ;
			Class.forName("com.mysql.cj.jdbc.Driver");
			//The above loads the package and the required class Driver .Class is a type of a class 
			//and forName is static function .The string depicts the package
			//Step 2:Connecting the database
			conn=DriverManager.getConnection("jdbc:mysql://localhost/hrdb","root","12345");
			System.out.println("Connection Established...");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver not Found");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {conn.close();} catch(Exception e) {}
		}
		
		
		
		
	}
}
