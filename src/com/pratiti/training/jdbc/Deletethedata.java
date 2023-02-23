package com.pratiti.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Deletethedata {
	
	public static void main(String[] args) {
		
		Connection conn=null;
		PreparedStatement stmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/pratitidb","root","12345");
			System.out.println("Connection Established...");
			
			String sql="SELECT * FROM tbl_product where price>=?";
			String sqlDelete="DELETE FROM tbl_product where name=?";
			stmt=conn.prepareStatement(sql);
			
			stmt.setDouble(1, 10000);
			
			//to delete the record
//			stmt.setString(1, "realme xt");
//			int row=stmt.executeUpdate();
//			
//			if(row==1)
//				System.out.println("Successfully deleted the record..");
			
			//to select the data whose price is grater than 10000
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				System.out.print("ID: " + rs.getInt("id"));
	            System.out.print(", Product name: " + rs.getString("name"));
	            System.out.print(", price: " + rs.getDouble("price"));
	            System.out.println(", quantity: " + rs.getInt("quantity"));
				
			}
			
			//to select all the data
//			ResultSet rs=stmt.executeQuery();
//			
//			while(rs.next())
//			{
//				System.out.print("ID: " + rs.getInt("id"));
//	            System.out.print(", Product name: " + rs.getString("name"));
//	            System.out.print(", price: " + rs.getDouble("price"));
//	            System.out.println(", quantity: " + rs.getInt("quantity"));
//			}
			
		}
		catch(ClassNotFoundException e)
		{
			
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		finally {
			try {conn.close();} catch(Exception e) {}
		}
	}

}
