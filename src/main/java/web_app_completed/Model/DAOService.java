package web_app_completed.Model;

import java.sql.ResultSet;

public interface DAOService {

	public void connectionDB();

	public boolean verifyCreditial(String emailId, String password);

	public void saveData(String name, String emailId, String mobile, String password);

	public ResultSet allData();

	public void deleteData(String emailId);

	public void updateData(String emailId, String mobile, String name, String password);

}
