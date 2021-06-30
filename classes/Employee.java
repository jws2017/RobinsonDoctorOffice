package classes;

import java.util.Date;

public class Employee extends Person {
	private String department, employee_id;
	private Person contactPerson;
	private Shift shift; 
	private float height, weight;

	public Employee(String fname, String mnames, String lname, String number,
			long trn, int sex, Date dob, Address address, float height, float weight, String department) {
		this(fname, mnames, lname, number, address, trn, Sex.values()[sex % Sex.values().length], dob, height, weight, department);
	}
	public Employee(Person person, float height, float weight, String department) {
		super(person);
		this.employee_id = super.getID() + department.substring(0, 3).toUpperCase();
		this.department = department;
		this.height = height;
		this.weight = weight;
		this.shift = null;
	}

	public Employee(String fname, String mname, String lname, String number, Address address, long trn, Sex sex, Date dob, 
			float height, float weight, String department) {
		super(fname, mname, lname, number, address, trn, sex, dob);
		this.employee_id = super.getID() + department.substring(0, 3).toUpperCase();
		this.department = department;
		this.height = height;
		this.weight = weight;
		this.shift = null;
	}

	public String toString() {
		return super.toString() + "\temployee ID: " + employee_id + 
				(contactPerson != null ? " , name of contact: " + contactName(): " , no contact")
				+ ", height: " + height + ", weight: " + weight;
	}

	public String contactName() {
		return contactPerson.name();
	}
	
	public void setContactPerson(Person person){
		this.contactPerson = person;
	}

	public Shift getShift() {
		return shift;
	}

	public void setShift(Shift shift) {
		this.shift = shift;
	}

	public boolean onDuty(TimeSlot ts) {
		if (shift == null) {
			return false;
		}
		return shift.getTimeSlots().contains(ts);
	}
	public boolean isEmpID(String id) {
		return employee_id.equals(id);
	}

	public boolean inDepartment(String searchStr) {
		return department.equalsIgnoreCase(searchStr);
	}
}
