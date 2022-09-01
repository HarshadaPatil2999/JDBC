package javadatabaseconnectivity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdataAndDeleteWithResultSetScrollable {
	
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
	
  void updateData( int sid) throws SQLException
  {
	  rs.absolute(4);
	  if(rs.getInt(1)==sid)
	  {
		  rs.updateInt(3, 80);
		  rs.updateRow();
	  }
	  System.out.println("updation Done");
  }
	
  void deleteData() throws SQLException
  {
	  rs.absolute(2);
	  rs.deleteRow();
	  System.out.println("Deletion done");
  }
  
  void insertData() throws SQLException
  {
	  rs.moveToInsertRow();
	  
	  rs.updateInt(1, 1);
	  rs.updateString(2, "Manali");
	  rs.updateInt(3, 77);
	  rs.updateInt(4, 104);
	  rs.updateInt(5, 1005);
	  rs.insertRow();
	
	  System.out.println("insertion done");
  }
	
	public static void main(String[] args) throws SQLException {
		conn=DBConnectivity2.getconnection1("student");
		UpdataAndDeleteWithResultSetScrollable ur=new UpdataAndDeleteWithResultSetScrollable();
		ur.displayData();
//		ur.updateData(6);
//		ur.deleteData();
		ur.insertData();
		System.out.println();
		ur.displayData();
		
	}

}
