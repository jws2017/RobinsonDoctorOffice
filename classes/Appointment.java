/**
 * 
 */
package classes;

import java.time.DayOfWeek;
import java.time.LocalTime;

/**
 * @author jws20
 *
 */
public class Appointment {

	private TimeSlot timeSlot;
	private Nurse nurse;
	private Doctor doctor;
	private Patient patient;
	private String room;

	
	/**
	 * @param start
	 * @param end
	 * @param nurse
	 * @param doctor
	 * @param patient
	 * @param room
	 */
	public Appointment(LocalTime start, LocalTime end, DayOfWeek day, Nurse nurse, Doctor doctor, Patient patient, String room) {
		this(new TimeSlot(start, end, day), nurse, doctor, patient);
	}

	/**
	 * @param timeSlot
	 * @param nurse
	 * @param doctor
	 * @param patient
	 */
	public Appointment(TimeSlot timeSlot, Nurse nurse, Doctor doctor, Patient patient) {
		this.timeSlot = timeSlot;
		this.nurse = nurse;
		this.doctor = doctor;
		this.patient = patient;
	}

	public boolean isOngoing() {
		return timeSlot.isOngoing();
	}

	public boolean onBusinessHours() {
		return false;
	}

	/**
	 * <h1>Overlapping Appointments</h1>
	 * <p>An appointment a is said to <b>overlap</b> another appointment b if: 
	 * <ol>
	 * <li>they are scheduled to take place at the exact same time, or</li>
	 * <li>one of the appointments starts before the other finishes</li>
	 * </ol>
	 * In other words, the appointments overlap if, at any point in time, the two appointments are occurring
	 * simultaneously.</p> 
	 * <p>This method is used by an {@code AppointmentManager} to check for scheduling conflicts.</p>
	 * @param b This is the appointment that will be checked for overlapping
	 * @return {@literal true} if a takes place at the same time as b, or a starts while b is still in progress; 
	 * {@literal false} otherwise.
	 */
	public boolean overlaps(Appointment b) {
		// TODO Auto-generated method stub
		return false;
	}

	public void correctSchedulingError() {
		// TODO Auto-generated method stub
		
	}

	public void setNurse(Nurse nurse2) {
		// TODO Auto-generated method stub
		this.nurse = nurse2;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}


}
