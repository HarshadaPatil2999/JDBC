package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity2 {
	
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/";
	static  String username="root";
	static String password="root";
	static Connection conn;
	
	static Connection getconnection1(String database)
	{ 
		
 try {
		
		Class.forName(driver);//load driver
		System.out.println("Driver loaded");
		url=url+database;
		conn=DriverManager.getConnection(url, username, password);//create connection
		System.out.println("Connection successful");
	}
	catch(ClassNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
		return conn;
		
	}


}
