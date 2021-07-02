package application_logic;

import java.util.PriorityQueue;

public class AppointmentManager extends PriorityQueue<Appointment> implements ServiceManager<Appointment> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean receive(Node<Appointment> requester, Appointment request, RequestType requestType) {
		switch (requestType) {
		case CREATE:
			return appointmentCreate(requester, request);
		case DELETE:
			return appointmentCancel(requester, request);
		default:
			return false;
		}

	}

	private boolean appointmentCancel(Node<Appointment> requester, Appointment request) {
		return remove(request);
	}

	private boolean appointmentCreate(Node<Appointment> requester, Appointment request) {
		if (!contains(request)) {
			add(request);
			return true;
		}
		return false;
	}

	@Override
	public boolean respond() {
		// TODO Auto-generated method stub
		return false;
	}

}
