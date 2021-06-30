/**
 * 
 */
package classes;

import java.util.Date;

/**
 * @author jws20
 *
 */
public class VisitingResident extends Doctor {

	/**
	 * @param person
	 * @param height
	 * @param weight
	 * @param department
	 */
	public VisitingResident(Person person, float height, float weight, String department) {
		super(person, height, weight, department);
		// TODO Auto-generated constructor stub
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
	 * @param height
	 * @param weight
	 * @param department
	 */
	public VisitingResident(String firstName, String lastName, String middleName, String contactNumber, Address address,
			long trn, Sex sex, Date dob, float height, float weight, String department) {
		super(firstName, lastName, middleName, contactNumber, address, trn, sex, dob, height, weight, department);
		// TODO Auto-generated constructor stub
	}

}
