package data_structures;

import java.sql.SQLException;

public class Database extends java.util.ArrayList<Table> {

	private static final long serialVersionUID = 1L;
	private UsersTable users;

	public static void main(String[] args) {

		Utils utils = new Utils("derby", "testdb", "jjLOL", "jjLOL");
		java.sql.Connection connection = null;
		
		try {
			connection = utils.getConnection();
		} catch (java.sql.SQLException e) {
			Utils.handleSQLException(e);
			return;
		}
		
		Table[] tables = null;
		
		assert(connection != null);
		
		if (connection != null) {
			try {
				tables = utils.initializeTables(connection, "testdb", "derby");
			} catch (SQLException e) {
				Utils.handleSQLException(e);
				e.printStackTrace();
				return;
			}
		}
		
		Database database = new Database();
		
		assert(tables != null);
		
		if (tables != null) {
			for (int i = 0; i < tables.length; i++) {
				Table table = tables[i];
				database.add(table);
				if (table.getClass() == UsersTable.class) {
					database.users = (UsersTable) table;
				}
			}
		}
		
		assert(database.users != null);
		
		if (database.users != null) {
			database.registerNewUser("JohnMarcus", "DOCTOR");
			String role = database.getRole("JohnMarcus");
			System.out.println(role);
		}

	}

	// calls to users

	public boolean registerNewUser(String name, String newRole) {
		return users.addNewUser(name, newRole);
	}

	private boolean checkForMatchingLogin(String[] strings) {
		return users.checkLogins(strings);
	}

	private boolean checkForMatchingLogin(String username, String password) {
		return this.checkForMatchingLogin(new String[]{username, password});
	}

	private String getRole(String username) {
		return users.getRole(username);
	}

	public String login(String username, String password) {
		if (checkForMatchingLogin(username, password)) {
			String role = getRole(username);
			return role;
		} else {
			return "";
		}
	}

}
