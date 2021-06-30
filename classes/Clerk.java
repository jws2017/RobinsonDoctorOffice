package classes;

import java.util.Date;

public class Clerk extends Employee {

	public Clerk(Person person, float height, float weight, String department) {
		super(person, height, weight, department);
		// TODO Auto-generated constructor stub
	}

	public Clerk(String fname, String mname, String lname, String number, Address address, long trn, Sex sex, Date dob,
			float height, float weight, String department) {
		super(fname, mname, lname, number, address, trn, sex, dob, height, weight, department);
		// TODO Auto-generated constructor stub
	}

}
