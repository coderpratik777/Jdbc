package com.pratiti.training.jdbc;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mysql.cj.xdevapi.Statement;

public class InsertData{
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn =null;
		java.sql.Statement stmt=null;
		
		try {
			//Step 1:Loading the JDBC DRIVER ;
			Class.forName("com.mysql.cj.jdbc.Driver");
			//The above loads the package and the required class Driver .Class is a type of a class 
			//and forName is static function .The string depicts the package
			//Step 2:Connecting the database
			conn=DriverManager.getConnection("jdbc:mysql://localhost/pratitidb","root","12345");
			System.out.println("Connection Established...");
			
			stmt=conn.createStatement();
//			stmt.executeUpdate("insert into tbl_product(name,price,quantity) values ('Iphone 10',50000,3)");			
//			stmt.executeUpdate("Select * from tbl_product");
			boolean i;
			do {
				String name;
				double price;
				int quantity;
				
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter the name of the product :");
				name=sc.nextLine();
				System.out.println("Enter the price of the product :");
				price=Double.parseDouble(sc.nextLine());
				System.out.println("Enter the quantity of the product :");
				quantity=Integer.parseInt(sc.nextLine());
				
				String sql="INSERT INTO tbl_product(name,price,quantity) VALUES ('"+name+"',"+price+","+quantity+")";
				
				int count=stmt.executeUpdate(sql);
				if(count==1)
					System.out.println("Record inserted....");
				
				System.out.println("Do you want to add a product : ");
//				System.out.println("1-Yes  0-No");
//			    i=Integer.parseInt(sc.nextLine());
				String s=sc.nextLine();
				i=Pattern.matches("[yY]{1}", s);
				
				
			}while(i);
			
			System.out.println("Thank you products inserted succesfully!");
			
			
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
