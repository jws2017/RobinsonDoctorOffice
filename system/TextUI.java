package system;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Person;
import classes.Address;
import classes.Employee;
import classes.Patient;

public class TextUI implements UserInterface {

	private Scanner UIScanner;
	private PrimarySystem main;

	public TextUI() {
		UIScanner = new Scanner(System.in);
		main = new PrimarySystem(this);
	}

	@Override
	public void run() {
		System.out.println("Welcome to the User Interface!");
		System.out.println("*****************************");
		boolean running = true;
		do {
			System.out.println(
					"Please enter the word \"patient\" to create a new patient in the system or view patients,");
			System.out.println("or enter the word \"employee\" to create a new employee or view current patients.");
			System.out.println("Enter the word \"appointment\" to see a list of all appointments.");
			System.out.println("Enter the word\"doctor\" to see a list of all doctors.");
			System.out.println("Enter \"exit\" to exit the program.");
			String userInput = UIScanner.nextLine();

			switch (userInput) {
			case "patient":
				showAllPatients();
				System.out.println("Would you like to create a new patient?");
				userInput = UIScanner.nextLine();
				if (userInput.startsWith("Y") || userInput.startsWith("y"))
					main.newPatient();
				else {
					System.out.println("Enter a patient id and/or name to display options for that patient");
					String search = UIScanner.nextLine();
					Patient result = main.searchForPatient(search);
					if (result == null) {
						System.out.println("Patient not found.");
					} else {
						runPatientMenu(result);
					}
				}
				break;

			case "employee":
				showAllEmployees();
				System.out.println("Would you like to create a new employee?");
				userInput = UIScanner.nextLine();
				if (userInput.startsWith("y") || userInput.startsWith("Y"))
					main.newEmployee();
				else {
					System.out.println("Enter a employee id and/or name to display options for that employee");
					String search = UIScanner.nextLine();
					Employee result = main.searchForEmployee(search);
					if (result == null) {
						System.out.println("Employee not found.");
					} else {
						runEmployeeMenu(result);
					}
				}
				break;

			case "appointment":
				showAllAppointments();
				break;

			case "doctor":
				showAllDoctors();
				break;

			case "exit":
				running = false;
				break;

			case "quit":
				running = false;
				break;

			default:
				break;
			}
		} while (running);
		shutDown();
	}

	@Override
	public Patient promptForPatient() {

		Scanner scanner = UIScanner;

		Person person = promptForPerson();

		float height;
		while (true)
			try {
				System.out.println("Please enter the height of the employee (as a number).");
				height = scanner.nextFloat();
				if (height <= 0) {
					System.out.println("Height has to be positive.");
					scanner.nextLine();
					continue;
				}
				break;
			} catch (java.util.InputMismatchException ime) {
				scanner.nextLine();
				System.out.println("Height has to be a number.");
				continue;
			}
		scanner.nextLine();

		float weight;
		while (true)
			try {
				System.out.println("Please enter the weight of the employee (as a number).");
				weight = scanner.nextFloat();
				if (weight <= 0) {
					System.out.println("Weight has to be positive.");
					scanner.nextLine();
					continue;
				}
				break;
			} catch (java.util.InputMismatchException ime) {
				scanner.nextLine();
				System.out.println("Weight has to be a number");
				continue;
			}
		scanner.nextLine();

		return new Patient(person, height, weight);
	}

	private Address promptForAddress() {
		Scanner scanner = UIScanner;

		System.out.println("Please enter the street of the address.");
		String street = scanner.nextLine();

		System.out.println("Please enter the city of the address.");
		String city = scanner.nextLine();

		System.out.println("Please enter the parish of the address.");
		String parish = scanner.nextLine();

		double xcoord;
		while (true)
			try {
				System.out.println("Please enter the x-coordinate of the address.");
				xcoord = scanner.nextDouble();
				break;
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("The x-coordinate has to be a number.");
			}
		scanner.nextLine();

		double ycoord;
		while (true)
			try {
				System.out.println("Please enter the y-coordinate of the address.");
				ycoord = scanner.nextDouble();
				break;
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("The y-coordinate has to be a number.");
			}
		scanner.nextLine();

		return new Address(street, city, parish, xcoord, ycoord);
	}

	public Date promptForDate() {
		Date date = null;
		DateFormat df = DateFormat.getDateInstance();
		do {
			System.out.println("Please enter the date in the form " + df.format(new Date()));
			String string = UIScanner.nextLine();
			try {
				date = df.parse(string);
			} catch (ParseException e) {
				System.out.println("There was an error in parsing the string, please reenter the value.");
				date = null;
			}
		} while (date  == null);
		return date;
	}

	@Override
	public Employee promptForEmployee() {
		Scanner scanner = UIScanner;

		Person person = promptForPerson();

		float height;
		while (true)
			try {
				System.out.println("Please enter the height of the employee (as a number).");
				height = scanner.nextFloat();
				if (height <= 0) {
					System.out.println("Height has to be positive.");
					scanner.nextLine();
					continue;
				}
				break;
			} catch (java.util.InputMismatchException ime) {
				scanner.nextLine();
				System.out.println("Height has to be a number.");
				continue;
			}
		scanner.nextLine();

		float weight;
		while (true)
			try {
				System.out.println("Please enter the weight of the employee (as a number).");
				weight = scanner.nextFloat();
				if (weight <= 0) {
					System.out.println("Weight has to be positive.");
					scanner.nextLine();
					continue;
				}
				break;
			} catch (java.util.InputMismatchException ime) {
				scanner.nextLine();
				System.out.println("Weight has to be a number");
				continue;
			}
		scanner.nextLine();

		System.out.println("Please enter the name of the department that this employee belongs to");
		String department = scanner.nextLine();
		return new Employee(person, height, weight, department);
	}

	private Person promptForPerson() {

		Scanner scanner = UIScanner;

		String fname;
		do {
			System.out.println("Please enter the first name of the person.");
			fname = scanner.nextLine();
		} while (fname.equals("") || fname == null);
		System.out.println("Please enter the middle name of the person.");
		String mname = scanner.nextLine();
		String lname;
		do {
			System.out.println("Please enter the last name of the person.");
			lname = scanner.nextLine();
		} while (lname.equals("") || lname == null);
		System.out.println("Please enter the contact number of the person.");
		String number = scanner.nextLine();

		long trn;
		while (true)
			try {
				System.out.println("Please enter the tax registration number (trn) of the person.");
				trn = scanner.nextLong();
				break;
			} catch (java.util.InputMismatchException ime) {
				scanner.nextLine();
				System.out.println("TRN must be a number.");
				continue;
			}
		scanner.nextLine();

		int sex;
		while (true)
			try {
				System.out.println("Please enter the sex of the employee. Enter 0 for male or 1 for female.");
				sex = scanner.nextInt();
				if (sex != 0 && sex != 1) {
					System.out.println("You should enter either 0 or 1 for the sex.");
					scanner.nextLine();
					continue;
				}
				break;
			} catch (java.util.InputMismatchException ime) {
				System.out.println("Sex should be entered as an integer, either 0 or 1.");
				scanner.nextLine();
				continue;
			}
		scanner.nextLine();

		Date dob = promptForDate();

		Address address = promptForAddress();

		return new Person(fname, mname, lname, number, trn, sex, address, dob);

	}

	private void showAll(Object[] all) {
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
	}

	public void showAllPatients() {
		showAll(main.getAllPatients().toArray());
	}

	public void showAllEmployees() {
		showAll(main.getAllEmployees().toArray());
	}

	public void showAllAppointments() {
		showAll(main.getAllAppointments().toArray());
	}

	public void showAllDoctors() {
		showAll(main.getDoctors().toArray());
	}

	private void runPatientMenu(Patient result) {
		System.out.println("What would you like to do with this patient?");
		System.out.println("Enter \"view\" to view this patient, \"delete\" to remove this patient from records,"
				+ "or anything else to return to the main menu");
		String userInput = UIScanner.nextLine();
		switch (userInput) {
		case "view":
			System.out.println(result);
			break;

		case "delete":
			boolean success = main.removePatient(result);
			if (success) {
				System.out.println("Patient successfully removed.");
			} else {
				System.out.println("Error, patient not registered in database. Sorry about that.");
				System.err.println("Registration Error: Patient " + result + "was not registered in database when it should have been.");
			}

		default:
			System.out.println("Invalid option.");
			break;
		}
	}

	private void runEmployeeMenu(Employee employee) {
		System.out.println("What would you like to do with this employee?");
		System.out.println("Enter \"view\" to view this employee, \"delete\" to remove this employee from records,"
				+ "or anything else to return to the main menu");
		String userInput = UIScanner.nextLine();
		switch (userInput) {
		case "view":
			System.out.println(employee);
			break;

		case "delete":
			boolean success = main.removeEmployee(employee);
			if (success) {
				System.out.println("Employee successfully removed.");
			} else {
				System.out.println("Error, employee not registered in database. Sorry about that.");
				System.err.println("Registration Error: Employee " + employee + "was not registered in database when it should have been.");
			}

		default:
			System.out.println("Invalid option.");
			break;
		}
		
	}

	public void shutDown() {
		System.out.println("Thank you for using the program!");
		UIScanner.close();
	}
}
