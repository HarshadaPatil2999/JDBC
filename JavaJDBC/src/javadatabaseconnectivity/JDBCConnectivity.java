package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectivity {
	
	static Connection conn;
	static ResultSet rs;
	
	
	void displayStudentData() 
	{
		try {
			Statement stat=conn.createStatement();
			
			rs=stat.executeQuery("Select * from studentdata");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString("sname")+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void displayDepartmentData() 
	{
		try {
			Statement stat=conn.createStatement();
			
			rs=stat.executeQuery("Select * from department");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void displaySportsData() 
	{
		try {
			Statement stat=conn.createStatement();
			
			rs=stat.executeQuery("Select * from sports");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		conn=DBConnectivity.getconnection1();
		
		JDBCConnectivity j=new JDBCConnectivity();
		System.out.println("------Student Data----------");
		
		j.displayStudentData();
		
		System.out.println();
		
		System.out.println("-------Department Data-------");
		
		j.displayDepartmentData();
		
		System.out.println("----Sports Data------");
		
		j.displaySportsData();
	}
	
	

}
