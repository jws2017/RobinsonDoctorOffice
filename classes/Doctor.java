package classes;

import java.util.Date;

public class Doctor extends Employee {

	private java.util.ArrayList<Appointment> appointments;
	private java.util.ArrayList<Patient> patientList;

	public Doctor(Person person, float height, float weight, String department) {
		super(person, height, weight, department);
	}

	/**
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param contactNumber
	 * @param address
	 * @param trn
	 * @param sex
	 * @param dob
	 */
	public Doctor(String firstName, String lastName, String middleName, String contactNumber,
			Address address, long trn, Sex sex, Date dob, float height, float weight, String department) {
		super(firstName, lastName, middleName, contactNumber, address, trn, sex, dob, height, weight, department);
		// TODO Auto-generated constructor stub
	}

	public void newAppointment(Patient patient) {
		// TODO Auto-generated method stub
		Appointment appointment = null;
		appointments.add(appointment);
		patientList.add(patient);
	}

	public void changeSchedule(Appointment appointment) {
		// TODO Auto-generated method stub
		appointments.remove(appointment);
	}

}
