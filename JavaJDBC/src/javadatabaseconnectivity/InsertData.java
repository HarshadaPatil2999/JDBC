package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	
	static Connection conn;
	static ResultSet rs;
	
	void insertStudentData()
	{
		try {
			Statement stmt=conn.createStatement();
			int i= stmt.executeUpdate("insert into studentdata value(18,'Manasi',89,102,1005)");
			if(i!=0)
			{
				System.out.println("Data inserted");
			}
			else
				System.out.println("data is not inserted..please check data");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
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
	
	public static void main(String[] args) {
		
		conn=DBConnectivity.getconnection1();
		InsertData in=new InsertData();
		in.insertStudentData();
		in.displayStudentData();
		
	}

}
