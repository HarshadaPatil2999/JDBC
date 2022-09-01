package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateAndDeleteUsingPreparedStmt {
   static Connection conn;
   static ResultSet rs;
   
   
   void UpdataData(int m, int d, int id)
   {
	   try {
		PreparedStatement ps=conn.prepareStatement("update studentdata set smarks=?,deptid=? where sid=?");
		ps.setInt(1, m);
		ps.setInt(2, d);
		ps.setInt(3, id);
		int i=ps.executeUpdate();
		if(i!=0)
			System.out.println("update data");
		else
			System.out.println("not updated");
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   
   
   
   
   
   
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
   
   void deleteData(int id)
   {
	   try {
		PreparedStatement ps=conn.prepareStatement("delete from studentdata where sid=?");
		
		   ps.setInt(1, id);
		   int i=ps.executeUpdate();
		   if(i!=0)
				System.out.println("delete data");
			else
				System.out.println("not deleted");
			
		
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
		UpdateAndDeleteUsingPreparedStmt up=new UpdateAndDeleteUsingPreparedStmt();
		System.out.println("Enter marks ,deptid, id");
		int m=sc.nextInt();
		int d=sc.nextInt();
		int id=sc.nextInt();
		up.displayData();
		up.UpdataData(m,d,id);
		up.deleteData(id);
		up.displayData();
	}
}
