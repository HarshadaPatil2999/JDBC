package javadatabaseconnectivity;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;

public class VehicleDatabase {

	static Connection conn;

	void showTables() throws SQLException {
		PreparedStatement pst = conn.prepareStatement("show Tables");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
	}

	void storedProcedure(int id) throws SQLException {
		CallableStatement c = conn.prepareCall("{call FullName(?, ?)}");
		c.setInt(1, id);
		c.registerOutParameter(2, Types.VARCHAR);
		c.execute();
		String s = c.getNString(2);

		System.out.println("FullName:" + s);
	}

	void customerData() throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from customer");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
					+ " " + rs.getString(5) + " " + rs.getString(6));
		}

	}

	void feedback_ratingData() throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from feedback_rating");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}

	}

	void displayData() throws SQLException {
		PreparedStatement pst = conn.prepareStatement("select * from purchase");
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " "
					+ rs.getInt(5) + " " + rs.getDate(6) + " " + rs.getInt(7));
		}
	}

	void noOfComplaints() throws SQLException {
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select count(*) from purchase p inner join feedback_rating f"
				+ "  on p.rating_id=f.rating_id join  model m on"
				+ "  p.model_id=m.model_id"
				+ " where f.rating like 'complaint' and m.model_name like 'Activa 5G'");
		while (rs.next()) {
			System.out.println("NO Of Complaints:" + rs.getInt(1));

		}

	}

	void deleteComplaintsRecord() throws SQLException {
		PreparedStatement pst = conn
				.prepareStatement("delete p from purchase p inner join feedback_rating f on p.rating_id=f.rating_id"
						+ "  where f.rating like 'complaint'");

		int i = pst.executeUpdate();
		if (i != 0) {
			System.out.println("deletion done");
		} else
			System.out.println("please check data");
	}

	void nameOFCustomer() throws SQLException {
		Statement st = conn.createStatement();
		ResultSet rs = st
				.executeQuery(" select c.first_name,c.last_name from purchase p inner join customer c on  p.cust_id=c.cust_id "
						+ "where p.rating_id is null");

		System.out.println("Name of customers who haven't  given rating yet");
		while (rs.next()) {
			System.out.println(rs.getString(1) + "  " + rs.getString(2));
		}
	}

	void updateRating() throws SQLException {
		PreparedStatement pst = conn.prepareStatement("update purchase p "
				+ "   set  p.rating_id =(select rating_id from feedback_rating where rating = 'excellent' )"
				+ "  where p.cust_id=(select cust_id from customer where first_name='Vaibhav')");
		int i = pst.executeUpdate();
		if (i != 0) {
			System.out.println("insertion done");
		} else
			System.out.println("please check data");

	}
  
	 void updateCost() throws SQLException
	 {
		 PreparedStatement pst=conn.prepareStatement(" update  model m inner join purchase p  on m.model_id=p.model_id "
		 		              + " join feedback_rating f on p.rating_id=f.rating_id"
		 		              + "  set m.cost=cost-(cost*0.1)"
		 		             + "   where f.rating like 'bad'");
		 
		 int i=pst.executeUpdate();
		 if (i != 0) {
				System.out.println(" reduce cost by 10%");
			} else
				System.out.println("please check data");
		 
	 }
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter database name");
		String database = sc.next();
		System.out.println("Enter id");
		int id = sc.nextInt();
		conn = DBConnectivity2.getconnection1(database);
		VehicleDatabase v = new VehicleDatabase();
		v.showTables();
		System.out.println("______________________________________________________");

		v.customerData();
		System.out.println("_______________________________________________________");

		v.feedback_ratingData();
		System.out.println("________________________________________________________");

		v.displayData();
		System.out.println("________________________________________________________");

		v.storedProcedure(id);
		System.out.println("_______________________________________________________");

		v.nameOFCustomer();
		System.out.println("_______________________________________________________");

		v.noOfComplaints();
		System.out.println("______________________________________________________");

		v.deleteComplaintsRecord();
		System.out.println("__________________________________________________________");

		v.updateRating();
		System.out.println("_________________________________________________________");
		
		v.updateCost();

	}
}
