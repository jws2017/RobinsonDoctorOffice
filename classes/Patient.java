package classes;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person {

	private static int counter = 0;
	private String patient_id;
	private float height, weight;
	private PermanentResident primaryPhysician;
	private ArrayList<Appointment> appointments;
	private ArrayList<Medicament> medications;
	private ArrayList<Diagnosis> illnesses;
	
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
	 */
	public Patient(String firstName, String lastName, String middleName, String contactNumber,
			Address address, long trn, Sex sex, Date dob, float height, float weight) {
		super(firstName, lastName, middleName, contactNumber, address, trn, sex, dob);
		this.patient_id = getID() + counter++;
		this.height = height;
		this.weight = weight;
		this.appointments = new ArrayList<Appointment>();
		this.medications = new ArrayList<Medicament>();
		this.illnesses = new ArrayList<Diagnosis>();
	}

	public Patient(String fname, String mnames,
			String lname, String number, long trn, int sex,
			Date dob, Address address, float height, float
			weight) {
		super(fname, mnames, lname, number, trn, sex, address, dob);
		this.height = height;
		this.weight = weight;
	}

	public Patient(Person person, float height, float weight) {
		super(person);
		this.patient_id = person.getID() + counter++;
		this.height = height;
		this.weight = weight;
		this.appointments = new ArrayList<Appointment>();
		this.medications = new ArrayList<Medicament>();
		this.illnesses = new ArrayList<Diagnosis>();
	}

	public Patient(Patient patient) {
		this(patient, patient.height, patient.weight);
	}

	public String toString() {
		return super.toString() + "\tpatient ID: " + patient_id + " , height: " + height + " , weight: " + weight;
	}

	public void setPrimaryPhysician(PermanentResident primaryPhysician) {
		this.primaryPhysician = primaryPhysician;
	}
	
	public boolean isPatientID(String patientID) {
		return patient_id.equals(patientID);
	}

	public Appointment requestAppointment(TimeSlot requestedTime) {
		Nurse empty = null;
		Appointment requested = new Appointment(requestedTime, empty, primaryPhysician, this);
		appointments.add(requested);
		return requested;
	}

	public void changeSchedule(Appointment a) {
		appointments.remove(a);
	}

}
