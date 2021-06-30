package interfaces;

import classes.Adult;
import classes.Child;
import classes.Patient;

/**
 * Created by Galileo on 03/26/2017.
 */
public interface PatientManager extends CRUDManager<Patient>{

    /**
     * Returns an Adult patient object corresponding to the Child Object that was passed in.
     * Conversion simply creates new Adult object with all the information in the Child Object
     * except for the guardian and asks the user for the information for the Adults nextOfKin
     *
     * @param patient the Child object to be converted
     *
     * @return Adult version of the Child patient passed in.
     */
    public Adult convertChild(Child patient);


    /**
     * Facilitates the process of assigning and re-assigning the primary phisician of a Patient.
     *
     * @param patient the Child object to be converted
     *
     */
    public void AssignPrimaryPhisician(Patient patient);



}
