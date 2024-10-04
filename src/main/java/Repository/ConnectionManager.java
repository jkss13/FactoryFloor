package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/factory_floor";
	private static final String USER = "root";
	private static final String PASSWORD = "";
	
	private static Connection conn = null;
	
	protected static Connection getCurrentConnection() throws SQLException {
		
		if (conn == null)
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		
		return conn;
		
	}
	
	protected static Connection getNewConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
}