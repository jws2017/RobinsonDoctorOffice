package user_interface;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import application_logic.*;

public class Main {

	public static void main(String[] args) {
		
		User patient = new User();
		User patient2 = new User();
		AppointmentManager amain = new AppointmentManager();
		
		Calendar calendar = Calendar.getInstance();
		Date now = calendar.getTime();
		
		int todayDate = calendar.get(Calendar.DATE);
		int todayMonth = calendar.get(Calendar.MONTH);
		int todayYear = calendar.get(Calendar.YEAR);
		
		if (todayDate != 1) {
			calendar.set(Calendar.DAY_OF_MONTH, todayDate - 1);
		} else if (todayMonth != 1) {
			calendar.set(Calendar.MONTH, todayMonth - 1);
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		} else {
			calendar.set(Calendar.YEAR, todayYear - 1);
			calendar.set(Calendar.MONTH, calendar.getActualMaximum(Calendar.MONTH));
			calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		}
		
		Date yesterday = calendar.getTime();
		
		patient.scheduleAppointment(amain, now);
		patient.scheduleAppointment(amain, now);
		patient2.scheduleAppointment(amain, yesterday);
		
		int count = 0;
		for (Iterator<Appointment> iterator = amain.iterator(); iterator.hasNext();) {
			iterator.next();
			count++;
		}
		
		System.out.println(count);
	}

}
