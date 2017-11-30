package application_logic;

import java.util.Date;

public class Appointment implements Comparable<Appointment> {

	private Date time;

	public Appointment(User patient, Date time) {
		this.time = time;
	}

	@Override
	public int compareTo(Appointment arg0) {
		return this.time.compareTo(arg0.time);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

	public static Appointment constructRequest(User requester, Date requestedTime) {
		return new Appointment(requester, requestedTime);
	}

}
