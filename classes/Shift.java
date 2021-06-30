package classes;

import java.util.ArrayList;

public class Shift {

	private int id;
	private String name;
	private ArrayList<TimeSlot> timeSlots;

	/**
	 * @param id a unique identifier that distinguishes this {@code Shift} from others
	 * @param name the name of the person assigned to this {@code Shift}
	 * @param timeSlots a list of {@code TimeSlot} objects
	 */
	public Shift(int id, String name, ArrayList<TimeSlot> timeSlots) {
		this.id = id;
		this.name = name;
		this.timeSlots = timeSlots;
	}

	public Shift() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shift [id=" + id + ", name=" + name + ", timeSlots=" + timeSlots + "]";
	}

	/**
	 * @return the timeSlots
	 */
	public ArrayList<TimeSlot> getTimeSlots() {
		return timeSlots;
	}

	/**
	 * @param timeSlots the timeSlots to set
	 */
	public void setTimeSlots(ArrayList<TimeSlot> timeSlots) {
		this.timeSlots = timeSlots;
	}

}
