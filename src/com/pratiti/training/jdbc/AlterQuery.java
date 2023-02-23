package com.pratiti.training.jdbc;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AlterQuery {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Class not found...");
		}
		
		
		try(Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/pratitidb","root","12345"))
		{
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
