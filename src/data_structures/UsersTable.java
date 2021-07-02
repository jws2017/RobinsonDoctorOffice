package data_structures;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersTable implements Table {

	private Connection con; // object representing database connection
	private String dbname; //  string representing name of database

	public UsersTable(Connection con, String dbName, String dbms) {
		this.con = con;
		this.dbname = dbName;
	}

	@Override
	public void createTable() throws SQLException {

		String SQL = UsersTable.class.getResource("createUsersTable.sql").toExternalForm();
		try (PreparedStatement createTableStatement = con.prepareStatement(SQL)) {
			createTableStatement.setString(0, dbname);
			createTableStatement.executeUpdate();
		}

	}

	@Override
	public void populateTable() throws SQLException {

		try (Statement stmt = con.createStatement()) {
			String SQL = UsersTable.class.getResource("populateUsersTable.sql").toExternalForm();
			stmt.executeUpdate(SQL);
		}

	}

	@Override
	public void dropTable() throws SQLException {
		// TODO Auto-generated method stub

	}

	public boolean addNewUser(String name, String newRole) {
		try (Statement stmt = con.createStatement()) {
			stmt.executeUpdate("insert into USERS values(" + name + ", " + newRole + ", " + "oiaugbhnds" + ")");
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean checkLogins(String[] strings) {

		try (Statement stmt = con.createStatement()) {
			ResultSet results = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME=" + strings[0] + "AND PASSWORD=" + strings[1]);
			return results.next();
		} catch (SQLException e) {
			Utils.handleSQLException(e);
			return false;
		}
	}

	public String getRole(String username) {

		try (Statement stmt = con.createStatement()) {
			ResultSet userRole = stmt.executeQuery("SELECT ROLE FROM USERS WHERE USERNAME=" + username);

			String role = "";

			while(userRole.next()) {
				role = userRole.getString("ROLE");
			}

			return role;

		} catch (SQLException e) {
			Utils.handleSQLException(e);
			return "";
		}
	}

}
