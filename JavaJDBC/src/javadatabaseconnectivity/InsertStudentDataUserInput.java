package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertStudentDataUserInput {
	
	static Connection conn;
	static ResultSet rs;
	
	void insertStudentData(int id,String n,int m,int d,int s)
	{
		try {
			Statement stmt=conn.createStatement();
			String query="insert into studentdata values("+id+",'"+n+"',"+m+","+d+","+s+")";
//			int i= stmt.executeUpdate("insert into studentdata value(15,'Smita',89,102,1005)");
               int i=stmt.executeUpdate(query);
               System.out.println(i);
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
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter id,name,marks,dept,sid");
		int id=sc.nextInt();
		String n=sc.next();
		int m=sc.nextInt();
		int d=sc.nextInt();
		int s=sc.nextInt();
		conn=DBConnectivity.getconnection1();
		InsertStudentDataUserInput is=new InsertStudentDataUserInput();
		is.insertStudentData(id, n, m, d, s);
		is.displayStudentData();
		
	}

}
