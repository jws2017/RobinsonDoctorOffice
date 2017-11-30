package application_logic;

public class LoginData {

	private String userName;
	private String password;

	LoginData(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", password=" + password + "]";
	}

	public String[] toStrings() {
		// TODO Auto-generated method stub
		return new String[]{userName, password};
	}

}
