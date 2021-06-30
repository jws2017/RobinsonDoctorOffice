package system;

import java.util.ArrayList;

import classes.Doctor;
import classes.Employee;
import classes.Nurse;
import classes.Shift;
import interfaces.EmployeeManager;

public class EmployeeSystem implements EmployeeManager {

	private ArrayList<Employee> employees;

	public EmployeeSystem() {
		this(new ArrayList<Employee>());
	}

	public EmployeeSystem(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public void add(Employee employee) {
		if (!employees.contains(employee)) {
			employees.add(employee);
		}
	}

	@Override
	public Employee findByName(String name) {
		for (Employee employee : employees) {
			if (employee.isName(name)) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public Employee findById(String id) {
		for (Employee employee : employees) {
			if (employee.isID(id) || employee.isEmpID(id)) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Employee> search(String searchStr) {
		ArrayList<Employee> results = new ArrayList<Employee>();
		Employee idMatch = findById(searchStr);
		Employee nameMatch = findByName(searchStr);
		if (idMatch != null) {
			results.add(idMatch);
		}
		if (nameMatch != null) {
			results.add(nameMatch);
		}
		for (Employee employee : employees) {
			if (employee.inDepartment(searchStr)) {
				results.add(employee);
			}
			if (employee.contactName() != null && searchStr.equals(employee.contactName())) {
				results.add(employee);
			}
		}
		return results;
	}

	@Override
	public void delete(Employee employee) {
		employees.removeIf(employee::equals);

	}

	@Override
	public Employee update(Employee employee) {
		return null;
	}

	/**
	 * @param employee
	 */
	public void assignShift(Employee employee) {
		Shift shift = new Shift();
		employee.setShift(shift);
	}

	/**
	 * <p>Assigns the first available nurse to the appointment
	 * @param appointment the appointment that should be assigned a nurse
	 */
	public void assignNurse(classes.Appointment appointment) {
		for (Employee employee : employees) {
			if (employee.getClass() == Nurse.class && employee.onDuty(appointment.getTimeSlot())) {
				appointment.setNurse((Nurse) employee);
				break;
			}
		}
	}

	public boolean contains(Employee employee) {
		return employees.contains(employee);
	}

	public ArrayList<Employee> all() {
		ArrayList<Employee> clone = new ArrayList<Employee>();
		clone.addAll(employees);
		return clone;
	}

	public ArrayList<Doctor> doctors() {
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		for (Employee employee : employees) {
			if (employee.getClass() == Doctor.class) {
				Doctor d = (Doctor) employee;
				doctors.add(d);
			}
		}
		return doctors;
	}
}
