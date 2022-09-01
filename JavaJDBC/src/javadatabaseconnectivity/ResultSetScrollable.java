package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetScrollable {
	static Connection conn;
	static ResultSet rs;
	
	
	void displayData() throws SQLException
	{
	PreparedStatement p= conn.prepareStatement("select * from studentdata",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE );
		 rs=p.executeQuery();
		 
		while(rs.next())
		{
			System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
		}
		System.out.println("__________________________________________________");
		
	}
	void forwardDirection() throws SQLException
	{
		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
        }
		System.out.println("________________________________________________________");
		
	}
	
	void backwordDirection() throws SQLException 
	{
		rs.afterLast();
		while(rs.previous())
		{
			System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
		}
		System.out.println("_________________________________________________________________");
		
	}
	
	void FirstAndLast() throws SQLException
	{
		rs.first();
	
		{
			System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
        }
		
		rs.last();
		
		{
			System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
        }
		
		System.out.println("____________________________________________________");
	}
	
	
	void randomData() throws SQLException
	{
		rs.absolute(5);
       while(rs.next())
		{
			System.out.println(+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getInt(5));
        }
		
		
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		conn=DBConnectivity2.getconnection1("student");
		ResultSetScrollable r=new ResultSetScrollable();
		r.displayData();
		r.forwardDirection();
		r.backwordDirection();
		r.FirstAndLast();
		r.randomData();
		
	}

}
