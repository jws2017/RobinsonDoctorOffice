package system;

import classes.Employee;
import classes.Patient;

public interface UserInterface extends Runnable {

	Patient promptForPatient();

	Employee promptForEmployee();	

}
