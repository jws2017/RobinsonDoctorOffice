package application_logic;

public class Role {
	private int id; // The user's identification number will be used to retrieve the roles they can play within the system
	private RoleType[] roletype = new RoleType[2]; // Attribute listing user role types. This array attribute as a maximum of two elements, since that is the maximum number of roles a single person may have
	
	public Role (RoleType roletype, int id) {
		this.setRoletype(roletype);
		this.id = id;
	} //Primary Constructor
	
	public int getId() {
		return this.id;
	} //method to get id

	public RoleType[] getRoletype() {
		return roletype;
	} //method to get role type array

	public void setRoletype(RoleType roletype) {
		this.roletype[0] = roletype;
	} // method to set primary user role
	
	public void addRole(RoleType roletype, Role role) {
		role.roletype[1] = roletype;
	} // method to add secondary user roll
	
}
