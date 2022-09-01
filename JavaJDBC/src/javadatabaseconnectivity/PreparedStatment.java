package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatment {
	
	static Connection conn;
	static ResultSet rs;
	
	void displayData()
	{
		try {
			PreparedStatement ps=conn.prepareStatement("select * from studentdata");
			rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString("sname")+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter database");
		String database=sc.next();
		conn=DBConnectivity2.getconnection1(database);
		PreparedStatment pse=new PreparedStatment();
		pse.displayData();
		
	}

}
