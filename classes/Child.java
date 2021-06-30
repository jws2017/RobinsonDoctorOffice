package classes;

import java.util.Date;

public class Child extends Patient {

	private Person guardian;

	public Child(String firstName, String lastName, String middleName, String contactNumber, Address address, long trn,
			Sex sex, Date dob, float height, float weight) {
		super(firstName, lastName, middleName, contactNumber, address, trn, sex, dob, height, weight);
		// TODO Auto-generated constructor stub
	}

	public Adult toAdult() {
		return new Adult(this, guardian);
	}
}
