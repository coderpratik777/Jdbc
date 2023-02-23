package com.pratiti.training.jdbc;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mysql.cj.xdevapi.Statement;

public class InsertData2version2{
	
	public static void main(String[] args) {
		
		Connection conn =null;
		PreparedStatement stmt=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost/pratitidb","root","12345");
			System.out.println("Connection Established...");
			
			String sql="insert into tbl_product (name,price,quantity) values(?,?,?)";
			stmt=conn.prepareStatement(sql,java.sql.Statement.RETURN_GENERATED_KEYS);
			String ans;
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
				
				
				
				stmt.setString(1, name);
				stmt.setDouble(2,price);
				stmt.setInt(3, quantity);
				int count=stmt.executeUpdate();
				
				
				if(count==1) {
					ResultSet res=stmt.getGeneratedKeys();
					if(res.next())
					  System.out.println("Record inserted....Your product id is "+res.getInt(1));
				}
				
				System.out.println("Do you want to add a product : ");
				System.out.println("y-Yes  n-No");
			    ans=sc.nextLine();
				
				
				
			}while(ans.equals("y"));
			
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
