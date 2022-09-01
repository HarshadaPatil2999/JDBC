package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteDeptIdRecord {
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
	
	
	
	 void deleteData(int deptid)
	   {
		   try {
			   
			PreparedStatement ps=conn.prepareStatement("delete  s from studentdata s inner join department d on  s.deptid=d.did where d.did=?");
			
			   ps.setInt(1, deptid);
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
			DeleteDeptIdRecord d=new DeleteDeptIdRecord();
			d.displayData();
			System.out.println("Enter deptId");
			int did=sc.nextInt();
			d.deleteData(did);
			
			d.displayData();
			
	}
}
