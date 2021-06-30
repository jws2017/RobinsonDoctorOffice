/**
 * 
 */
package system;

import java.util.ArrayList;

import classes.Adult;
import classes.Appointment;
import classes.Child;
import classes.Doctor;
import classes.Employee;
import classes.Patient;

/**
 * @author jws20
 *
 */
public class PrimarySystem {

	private AppointmentSystem appointmentSystem;
	private EmployeeSystem employeeSystem;
	private PatientSystem patientSystem;
	private UserInterface ui;
	
	/**
	 * This primary system acts as the primary layer providing functionality to the system. 
	 * It uses the subsystem types to run this database.
	 */
	public PrimarySystem(AppointmentSystem asys, EmployeeSystem esys, PatientSystem psys, UserInterface ui) {
		this.appointmentSystem = asys;
		this.employeeSystem = esys;
		this.patientSystem = psys;
		this.ui = ui;
	}

	public PrimarySystem(UserInterface ui) {
		this(new AppointmentSystem(), new EmployeeSystem(), new PatientSystem(), ui);
	}

	public void newPatient() {
		classes.Patient l1 = ui.promptForPatient();
		patientSystem.add(l1);
	}

	public void newEmployee() {
		Employee e = ui.promptForEmployee();
		employeeSystem.add(e);
	}
	
	public void processAppointmentRequest(Appointment request) {
		Appointment complete = appointmentSystem.update(request);
		appointmentSystem.add(complete);
	}

	public boolean removePatient(Patient patient) {
		if (patientSystem.contains(patient)) {
			patientSystem.delete(patient);
			return true;
		} else {
			return false;
		}
	}

	public boolean removeEmployee(Employee employee) {
		if (employeeSystem.contains(employee)) {
			employeeSystem.delete(employee);
			return true;
		} else {
			return false;
		}
	}

	public void descheduleAppointment(Appointment appointment) {
		appointmentSystem.delete(appointment);
	}

	public Employee searchForEmployee(String search) {
		if (!employeeSystem.search(search).isEmpty()) {
			return employeeSystem.search(search).get(0);
		} else {
			return null;
		}
	}

	public Patient searchForPatient(String search) {
		if (!patientSystem.search(search).isEmpty()) {
			return patientSystem.search(search).get(0);
		} else {
			return null;
		}
	}

	public Adult turnChildToAdult(Child c) {
		return patientSystem.convertChild(c);
	}

	public Appointment[] presentAppointments() {
		return appointmentSystem.ongoingAppointments().toArray(new Appointment[0]);
	}

	public void begin() {
		ui.run();
	}

	public static void main(String[] args) {
		PrimarySystem app = new PrimarySystem(new TextUI());
		app.begin();
	}

	public ArrayList<Patient> getAllPatients() {
		return patientSystem.all();
	}

	public ArrayList<Employee> getAllEmployees() {
		return employeeSystem.all();
	}

	public ArrayList<Doctor> getDoctors() {
		return employeeSystem.doctors();
	}

	public ArrayList<Appointment> getAllAppointments() {
		return appointmentSystem.all();
	}
}

