package classes;

import java.util.Date;

public class Person {

	private static java.util.Hashtable<String, Integer> used_ids = new java.util.Hashtable<>();

	/**
		 * @author jws20
		 *
		 */
	public static enum Sex {

		MALE, FEMALE;

	}

	private String id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String contactNumber;
	private Address address;
	private long trn;
	private Sex sex;
	private Date dob;

	public Person(Person p) {
		this(p.firstName, p.lastName, p.middleName, p.contactNumber, p.address, p.trn, p.sex, p.dob);
	}
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param contactNumber
	 * @param address
	 * @param trn
	 * @param sex
	 * @param dob
	 */
	public Person(String firstName, String lastName, String middleName, String contactNumber,
			Address address, long trn, Sex sex, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.trn = trn;
		this.sex = sex;
		this.dob = dob;
		
		this.id = constructNewID();
	}

	public Person(String firstName, String middleName, String lastName, String contactNumber,
			long trn, int sex, Address address, Date dob) {
		this(firstName, lastName, middleName, contactNumber,
				address, trn, Sex.values()[sex % Sex.values().length], dob);
	}

	private String constructNewID() {
		String id = "";
		id += firstName.substring(0, 3).toUpperCase();
		id += !middleName.isEmpty() ? middleName.charAt(0): '0';
		id += lastName.substring(0, 3).toUpperCase();
		Integer timesUsed = used_ids.getOrDefault(id, 0);
		used_ids.put(id, ++timesUsed);
		id += "000".substring(0, 2 - timesUsed / 10) + timesUsed;
		return id;
	}
	
	public String getID() {
		return id;
	}
	
	public final String name() {
		// TODO Auto-generated method stub
		return firstName + " " + middleName + " " + lastName;
	}
	
	public boolean isID(String id) {
		return this.id.equals(id);
	}
	
	public boolean isName(String name) {
		return this.name().equals(name);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName
				+ ", contactNumber=" + contactNumber + ", address=" + address + ", trn=" + trn + ", sex=" + sex
				+ ", dob=" + dob + "]";
	}

}
