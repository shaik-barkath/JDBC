package com.kn.jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/JDBC";
		String username="root";
		String password="root";
	  //String createUser="CREATE TABLE USER (ID INT, PASSWORD VARCHAR(20))";
		String insertUser1="INSERT INTO USER VALUES (1,'Raju@1234')";
		String insertUser2="INSERT INTO USER VALUES (1,'Rani@1234')";
		String insertUser3="INSERT INTO USER VALUES (1,'Police@1234')";
		String insertUser4="INSERT INTO USER VALUES (1,'Chor@1234')";
		Connection con = null;
		
		try {
			//1.Load & Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Registered Successfully");
			
			//2.Establish Connection using DriverMangager
			con=DriverManager.getConnection(url, username, password);
			System.out.println("Connection Established= "+con);
			
			//3.create statement Object
			Statement stmt=con.createStatement();
			
			//4.Send & Execute Query
			//stmt.execute(createUser);
			//System.out.println("*****User Table Created*******");
			int count =stmt.executeUpdate(insertUser1);
			System.out.println(count+"***** records Inserted");
			count =stmt.executeUpdate(insertUser2);
			System.out.println(count+"***** records Inserted");
			count =stmt.executeUpdate(insertUser3);
			System.out.println(count+"***** records Inserted");
			count =stmt.executeUpdate(insertUser4);
			System.out.println(count+"***** records Inserted");
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("==>Failed to load & Register Driver");
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("==> Connection Failed");
		} finally {
			try {
				con.close();
				System.out.println("===>Connection Closed");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
