package application_logic;

import java.util.Date;

/**
 * @author jws20
 * A User object executes tasks by sending a Request to a ServiceManager object, which will execute the specified task on behalf of the User object
 */
public class User implements Node<Appointment> {

	private Role role;

	public User(Role userRole) {
		role = userRole;
	}

	public User() {
		this(new Role(RoleType.PATIENT, 0)); // 0 is a placeholder id
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void scheduleAppointment(ServiceManager<Appointment> manager, Date requestedTime) {

		/* TODO implement according to the description below:
		 * The idea is that a User object will send a Request to a ServiceManager object
		 * (in this case, the request would be to create a new appointment)
		 * the ServiceManager object will, upon receiving the request, execute it on behalf of the User object
		 * (in this case, a new appointment would be created)
		 */

		// the createAppointmentRequest is, essentially, the message that will be sent to the manager
		// so that the manager can create the new appointment
		// so the request will likely need to contain the requestedTime of the appointment somehow

		Appointment createAppointmentRequest = Appointment.constructRequest(this, requestedTime);

		sendRequest(manager, createAppointmentRequest, RequestType.CREATE);

	}

	public void cancelAppointment(ServiceManager<Appointment> manager, Appointment toBeCancelled) {

		/* same deal as above
		 * User sends a Request to a ServiceManager to handle the cancellation of the appointment
		 * */
		 // TODO fix according to description

		sendRequest(manager, toBeCancelled, RequestType.DELETE);

	}

	// I'm wondering if this should be a UI function
	// This should change the displayed status of the doctor, that is, whether the system shows the doctor as
	// available or busy
	/**
	 * Change the displayed status of the doctor, that is, whether the system shows the doctor as available or busy
	 * @param doctor the doctor that one wishes to change the display status for
	 */
	public void setDoctorAvailablilty(User doctor) {
		if (true) { //set some authorization
			// TODO
		}
	}

	// only a user with the DOCTOR role can add patient records
	public void addPatientRecord(Record newRecord, User patient) {
		// TODO implement this function to allow a DOCTOR (and only a DOCTOR) to add patient records
		// this function will need to access the database to append the new record to the list of patients
	}

	// patients are allowed to view their personal records
	public Record[] viewMyRecords() {
		// TODO call database and retrieve records for the current user
		return null;
	}

	// only a user with the DOCTOR role can generate referrals
	public void generateReferral() {

	}

	@Override
	public void sendRequest(ServiceManager<Appointment> manager, Appointment request, RequestType requestType) {
		// TODO Auto-generated method stub
		manager.receive(this, request, requestType);
	}

}
