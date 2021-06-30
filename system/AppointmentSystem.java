package system;

import java.util.ArrayList;

import classes.Appointment;
import interfaces.AppointmentManager;

public class AppointmentSystem implements AppointmentManager {

	private ArrayList<Appointment> appointments;

	public AppointmentSystem() {
		this(new ArrayList<Appointment>());
	}
	public AppointmentSystem(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public void add(Appointment appointment) {
		appointments.add(appointment);

	}

	@Override
	public Appointment findByName(String name) {
		return null;
	}

	@Override
	public Appointment findById(String id) {
		return null;
	}

	@Override
	public ArrayList<Appointment> search(String searchStr) {
		return null;
	}

	@Override
	public void delete(Appointment appointment) {
		if (appointments.contains(appointment)) {
			appointments.remove(appointment);
		}

	}

	@Override
	public Appointment update(Appointment appointment) {
		classes.Nurse nurse = null;
		appointment.setNurse(nurse);
		return appointment;
	}

	public ArrayList<Appointment> ongoingAppointments() {
		ArrayList<Appointment> ongoing = new ArrayList<Appointment>();
		for (Appointment appointment : appointments) {
			if (appointment.isOngoing()) {
				ongoing.add(appointment);
			}
		}
		return ongoing;
	}
	public ArrayList<Appointment> all() {
		ArrayList<Appointment> clone = new ArrayList<Appointment>();
		clone.addAll(appointments);
		return clone;
	}

}
