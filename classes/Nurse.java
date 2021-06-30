/**
 * 
 */
package classes;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author jws20
 *
 */
public class Nurse extends Employee {

	private ArrayList<Appointment> appointments;
	/**
	 * @param fname
	 * @param mname
	 * @param lname
	 * @param number
	 * @param address
	 * @param trn
	 * @param sex
	 * @param dob
	 * @param height
	 * @param weight
	 * @param department
	 */
	public Nurse(String fname, String mname, String lname, String number, Address address, long trn, Sex sex, Date dob,
			float height, float weight, String department) {
		super(fname, mname, lname, number, address, trn, sex, dob, height, weight, department);
		// TODO Auto-generated constructor stub
	}

	public void signup(Appointment appointment) {
		appointment.setNurse(this);
		appointments.add(appointment);
	}
}
