package classes;

import java.util.Date;

public class Adult extends Patient {

	private Person nextOfKin;

	public Adult(String firstName, String lastName, String middleName, String contactNumber, Address address, long trn,
			Sex sex, Date dob, float height, float weight) {
		super(firstName, lastName, middleName, contactNumber, address, trn, sex, dob, height, weight);
		// TODO Auto-generated constructor stub
	}

	public Adult(Patient patient, Person nextOfKin) {
		super(patient);
		this.nextOfKin = nextOfKin;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Adult [nextOfKin=" + nextOfKin + ", toString()=" + super.toString() + "]";
	}
}
