import java.sql.*;

public class DBControllerImpl implements IDBController {

	private static Connection	verbindung	= null;
	private Statement			abfrage		= null;

	@Override
	public void closeConnection() throws SQLException {
		if (verbindung != null) {
			verbindung.close();
			System.out.println("connection closed");
		}
	}

	@Override
	public void openConnection(String server, String port, String datenbank,
			String benutzer, String passwort) throws SQLException {
		verbindung = DriverManager.getConnection(
				getUrl(server, port, datenbank), benutzer, passwort);

		abfrage = verbindung.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);

		System.out.println("connection opened");

	}

	@Override
	public void openConnection() throws SQLException {

		try {
			Class.forName("org.sqlite.JDBC");
			verbindung = DriverManager.getConnection("jdbc:sqlite:fitness.db");
			abfrage = (Statement) verbindung.createStatement();

			System.out.println("connection opened");
		}
		catch (ClassNotFoundException e) {
			System.out.println("connection not openedÏ");
			System.out.println(e.toString());
		}

	}
	
	public void openConnection(String path) throws SQLException {

		try {
			Class.forName("org.sqlite.JDBC");
		}
		catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
		verbindung = DriverManager.getConnection("jdbc:sqlite:" + path);
		abfrage = (Statement) verbindung.createStatement();
	}

	public ResultSet executeSelect(String query) throws SQLException {
		ResultSet rs = null;
		rs = abfrage.executeQuery(query);
		return rs;
	}

	public ResultSet executeSelectSqlLite(String query) throws SQLException {
		ResultSet rs = null;
		rs = abfrage.executeQuery(query);
		return rs;
	}

	public int executeInsert(String query) throws SQLException {
		int id = 0;
//		id = abfrage.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		
		abfrage.executeUpdate(query);
		
		ResultSet rs = abfrage.executeQuery("select last_insert_rowid()");
		if (rs.next()) {
			id = rs.getInt(1);
		}

//		ResultSet rs = abfrage.getGeneratedKeys();
//		if (rs.next()) {
//			id = rs.getInt(1);
//		}
		return id;
	}

	/**
	 * @return Url-string for mysqlSQL-database connection
	 */
	private String getUrl(String host, String port, String database) {
		String url = "jdbc:mysql:" + "//" + host + "/" + database;
		System.out.println(url);

		return url;
	}

	@Override
	public int executeDelete(String query) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String query) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}