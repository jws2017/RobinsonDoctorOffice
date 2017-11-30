package application_logic;

public class UserManager implements ServiceManager<User> {

	private data_structures.Database database;

	UserManager(data_structures.Database database) {
		this.database = database;
	}

	@Override
	public boolean receive(Node<User> requestor, User request, RequestType requestType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean respond() {
		// TODO Auto-generated method stub
		return false;
	}

	public void registerNewUser(String name, Role newUserRole) {
		database.registerNewUser(name, newUserRole.toString());
	}

	public User login(LoginData loginInfo) {
		String[] logindata = loginInfo.toStrings();
		String username = logindata[0], password = logindata[1];
		
		String dbRole = database.login(username, password);
		Role role = new Role(RoleType.valueOf(dbRole), 0);
		return new User(role);
	}

}
