import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDBController {
	
	public ResultSet executeSelect(String query) throws SQLException;
	
	public int executeInsert(String query) throws SQLException;
	
	public int executeDelete(String query) throws SQLException;
	
	public int executeUpdate(String query) throws SQLException;
	
	public void closeConnection() throws SQLException;
	
	public void openConnection() throws SQLException;
	
	public void openConnection(String server, String port, String datenbank,
			String benutzer, String passwort) throws SQLException;
}
