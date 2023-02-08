package web_app_completed.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	private Connection con;
	private Statement stm;

	@Override
	public void connectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/completedLog", "root", "test");
			System.out.println(con);
			stm = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean verifyCreditial(String emailId, String password) {
		try {
			ResultSet result = stm.executeQuery(
					"select * from newlogin where EmailId = '" + emailId + "' and Password = '" + password + "'");
			return result.next();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	@Override
	public void saveData(String name, String emailId, String mobile, String password) {
		try {
			stm.executeUpdate("insert into newreg value ('" + name + "', '" + emailId + "', '" + mobile + "' , '"
					+ password + "' )");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResultSet allData() {
		try {
			ResultSet result = stm.executeQuery("select * from newreg");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteData(String emailId) {
		try {
			stm.executeUpdate("delete from newreg where EmailId = '" + emailId + "' ");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateData(String emailId, String mobile, String name, String password) {
		try {
			stm.executeUpdate("update newreg set MobileNumber = '" + mobile + "',Name = '" + name + "' , Password = '"
					+ password + "' where EmailId = '" + emailId + "' ");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
