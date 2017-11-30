package data_structures;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Utils {

	private String dbms;
	private String dbName; 
	private String userName;
	private String password;

	private String serverName;
	private int portNumber;

	public Utils(String dbms, String dbName, String username, String password) {

		this.dbms = dbms;
		this.dbName = dbName;
		this.userName = username;
		this.password = password;

	}

	public Connection getConnection() throws SQLException {

		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);

		if (this.dbms.equals("mysql")) {
			conn = DriverManager.getConnection(
					"jdbc:" + this.dbms + "://" +
							this.serverName +
							":" + this.portNumber + "/",
							connectionProps);
		} else if (this.dbms.equals("derby")) {

			conn = DriverManager.getConnection(
					"jdbc:" + this.dbms + ":" +
							this.dbName +
							";create=true",
							connectionProps);
		}
		System.out.println("Connected to database");
		return conn;
	}


	public Table[] initializeTables(Connection con, String dbName, String dbms) throws SQLException {

		UsersTable myUsersTable = new UsersTable(con, dbName, dbms);

		// Dropping existing tables
		myUsersTable.dropTable();
		// creating users table
		myUsersTable.createTable();
		//populating users table
		myUsersTable.populateTable();

		return new Table[]{myUsersTable};
	}

	public static void handleSQLException(SQLException e) {
		for (Throwable throwable : e) {
			if (throwable instanceof SQLException) {
				if (ignoreSQLException(((SQLException)throwable).getSQLState()) == false) {
					throwable.printStackTrace(System.err);
					System.err.println("SQLState: " + ((SQLException)throwable).getSQLState());
					System.err.println("Error Code: " + ((SQLException)throwable).getErrorCode());
					System.err.println("Message: " + throwable.getMessage());
					Throwable t = e.getCause();
					while (t != null) {
						System.out.println("Cause: " + t);
						t = t.getCause();
					}
				}
			}
		}
	}

	public static boolean ignoreSQLException(String sqlState) {
		if (sqlState == null) {
			System.out.println("The SQL state is not defined!");
			return false;
		}
		// X0Y32: Jar file already exists in schema
		if (sqlState.equalsIgnoreCase("X0Y32"))
			return true;
		// 42Y55: Table already exists in schema
		if (sqlState.equalsIgnoreCase("42Y55"))
			return true;
		return false;
	}

	// closes the database connection at the end of the session
	public void closeConnection(Connection connection) {

		try {
			if (!connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			handleSQLException(e);
		}	
	}

}
