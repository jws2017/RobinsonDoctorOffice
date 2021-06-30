package system;

import java.util.ArrayList;
import java.util.Date;

import classes.Address;
import classes.Adult;
import classes.Child;
import classes.Patient;
import classes.PermanentResident;
import classes.Person.Sex;
import interfaces.PatientManager;

public class PatientSystem implements PatientManager {

	private ArrayList<Patient> patients;
	
	public PatientSystem() {
		this(new ArrayList<Patient>());
	}
	
	public PatientSystem(ArrayList<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public void add(Patient patient) {
		patients.add(patient);

	}

	@Override
	public Patient findByName(String name) {
		for (Patient patient : patients) {
			if (patient.isName(name)) {
				return patient;
			}
		}
		return null;
	}

	@Override
	public Patient findById(String id) {
		for (Patient patient : patients) {
			if (patient.isPatientID(id)) {
				return patient;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Patient> search(String searchStr) {
		ArrayList<Patient> results = new ArrayList<Patient>();
		for (Patient patient : patients) {
			if (patient.isID(searchStr)||patient.isName(searchStr)||patient.isPatientID(searchStr)) {
				results.add(patient);
			}
		}
		return results;
	}

	@Override
	public void delete(Patient patient) {
		if (patients.contains(patient)) {
			patients.remove(patient);
		}

	}

	@Override
	public Patient update(Patient object) {
		return null;
	}

	@Override
	public Adult convertChild(Child patient) {
		return patient.toAdult();
	}

	@Override
	public void AssignPrimaryPhisician(Patient patient) {
		String firstName = "";
		String lastName = "";
		String middleName = "";
		String contactNumber = "";
		Address address = new Address("", "", "", 0, 0);
		long trn = 0;
		Sex sex = Sex.MALE;
		Date dob = new Date();
		float height = 0;
		float weight = 0;
		String department = "";
		PermanentResident proxy = new PermanentResident(firstName, lastName, middleName, contactNumber, address, trn, sex, dob, height, weight, department);
		patient.setPrimaryPhysician(proxy);

	}

	public boolean contains(Patient patient) {
		return patients.contains(patient);
	}

	public ArrayList<Patient> all() {
		ArrayList<Patient> clone = new ArrayList<Patient>();
		clone.addAll(patients);
		return clone;
	}

}
