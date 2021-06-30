package classes;

import java.util.Date;

public class PermanentResident extends Doctor {

	public PermanentResident(String firstName, String lastName, String middleName, String contactNumber,
			Address address, long trn, Sex sex, Date dob, float height, float weight, String department) {
		super(firstName, lastName, middleName, contactNumber, address, trn, sex, dob, height, weight, department);
		
	}

}
