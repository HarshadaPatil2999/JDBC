package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateAndDeleteData {
	static Connection conn;
	ResultSet rs;
	
	void displyUpdateData()
	{
		try {
			Statement stmt=conn.createStatement();
			int i=stmt.executeUpdate("update  studentdata set smarks=smarks+5 where sid=1");
			if(i!=0)
				System.out.println("update data");
			else
				System.out.println("not update data..please check data");
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
	
	void displayDeleteData()
	{
		try {
			Statement stmt=conn.createStatement();
			int i=stmt.executeUpdate("delete  from  studentdata where sid=14" );
			if(i!=0)
				System.out.println("deleted data");
			else
				System.out.println("not deleted data..please check data");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static void main(String[] args) {
		conn=DBConnectivity.getconnection1();
		UpdateAndDeleteData u=new UpdateAndDeleteData();
		u.displyUpdateData();
		u.displayDeleteData();
		u.displayStudentData();
		
		
	}

}
