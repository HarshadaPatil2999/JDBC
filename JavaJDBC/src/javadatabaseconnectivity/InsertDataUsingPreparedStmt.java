package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertDataUsingPreparedStmt {
	static Connection conn;
	static ResultSet rs;
	
	void showTables()
	{
		 
		try {
			   PreparedStatement ps = conn.prepareStatement("show tables");
			   rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	void insertData(int id,String name,int marks,int deptId,int spid )
	{
		try {
			PreparedStatement ps=conn.prepareStatement("insert into studentdata values(?,?,?,?,?)");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3,marks);
			ps.setInt(4, deptId);
			ps.setInt(5, spid);
			
			int i=ps.executeUpdate();
			if(i!=0)
			System.out.println("record inserted");
			else
				System.out.println("record not inserted..please check data");
			
			
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
	
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter database");
		String database=sc.next();
		conn=DBConnectivity2.getconnection1(database);
		InsertDataUsingPreparedStmt pse=new InsertDataUsingPreparedStmt();
//		System.out.println("Enter id,name,Marks,dept_id,Sport_id");
//		int id=sc.nextInt();
//		String n=sc.next() ;
//		int m=sc.nextInt();
//		int d=sc.nextInt();
//		int s=sc.nextInt();
		
		pse.showTables();
		//pse.insertData(id, n, m, d, s);
		
//		pse.displayData();
		
		
		

}
}
