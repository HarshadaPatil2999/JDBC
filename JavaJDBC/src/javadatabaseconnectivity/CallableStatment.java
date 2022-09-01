package javadatabaseconnectivity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class CallableStatment {
	
	static Connection conn;
	
	
	void functionCall(int id) throws SQLException
	{
		CallableStatement c=conn.prepareCall("{?=call FullName(?) }");
		c.registerOutParameter(1, Types.VARCHAR);
		c.setInt(2, id);
		
	    c.execute();
	    String s=c.getNString(1);
	    System.out.println(s);
		
	}
	
	void storedProcedure1() throws SQLException
	{
		CallableStatement c=conn.prepareCall("{call DeptEmpCount()}");
		ResultSet rs= c.executeQuery();
		System.out.println("______________________________________________________");
		System.out.println("DeptId      EmployeeCount");
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"       "+rs.getInt(2));
		}
		
		
	}
	
	void storedProcedure2(int id) throws SQLException
	{
		CallableStatement c=conn.prepareCall("{call EmployeeData(?,?,?)}");
		c.setInt(1, id);
		c.registerOutParameter(2, Types.VARCHAR);
		c.registerOutParameter(3, Types.DECIMAL);
		c.execute();
		String s=c.getNString(2);
		double d=c.getDouble(3);
		System.out.println("_______________________________________________________________");
		System.out.println(s+"  "+d);
	}
	
	void storedProcedure3() throws SQLException
	{
		CallableStatement c=conn.prepareCall("{call AllEmpExprience()}");
		ResultSet rs=c.executeQuery();
		
		System.out.println("---------------------------------------------------------------------");
		System.out.println("EmployeeName      Exprience");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"          "+rs.getInt(2));
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter database");
		String database=sc.next();
		System.out.println("Enter id");
		int id=sc.nextInt();
		conn=DBConnectivity2.getconnection1(database);
		
		CallableStatment cs= new CallableStatment();
//		cs.functionCall(id);
//		cs.storedProcedure1();
//		cs.storedProcedure2(id);
		cs.storedProcedure3();
	}

}
