package classes;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimeSlot implements Comparable<TimeSlot> {

	private LocalTime starttime;
	private LocalTime endtime;
	private DayOfWeek day;

	public TimeSlot(DayOfWeek dayOfWeek) {
		// TODO Auto-generated constructor stub
		this(LocalTime.of(8, 0), LocalTime.of(6, 0), dayOfWeek);
	}

	/**
	 * @param localTime
	 * @param localTime2
	 * @param day
	 */
	public TimeSlot(LocalTime localTime, LocalTime localTime2, DayOfWeek day) {
		this.starttime = localTime;
		this.endtime = localTime2;
		this.day = day;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TimeSlot [starttime=" + starttime + ", endtime=" + endtime + ", day=" + day + "]";
	}

	public boolean isOngoing() {
		LocalTime now = LocalTime.now();
		if (starttime == null || endtime == null || day ==  null) {
			return false;
		}
		return now.isAfter(starttime) && now.isBefore(endtime) && DayOfWeek.from(now).equals(day);
	}

	@Override
	public int compareTo(TimeSlot arg0) {
		if (!day.equals(arg0.day)) {
			return day.compareTo(arg0.day);
		} else if (!starttime.equals(arg0.starttime)) {
			return starttime.compareTo(arg0.starttime);
		} else if (!endtime.equals(arg0.endtime)) {
			return endtime.compareTo(arg0.endtime);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((endtime == null) ? 0 : endtime.hashCode());
		result = prime * result + ((starttime == null) ? 0 : starttime.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeSlot other = (TimeSlot) obj;
		if (day != other.day)
			return false;
		if (endtime == null) {
			if (other.endtime != null)
				return false;
		} else if (!endtime.equals(other.endtime))
			return false;
		if (starttime == null) {
			if (other.starttime != null)
				return false;
		} else if (!starttime.equals(other.starttime))
			return false;
		return true;
	}

}
