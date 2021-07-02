package data_structures;

public class Database {

	private UsersTable users;

	public static void connect() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?user=jws20&password=MSacctp33d");
			con.close();
			System.out.println("Connection successful");
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
			System.exit(1);
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
