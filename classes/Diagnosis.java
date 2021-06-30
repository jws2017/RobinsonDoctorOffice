package classes;

public class Diagnosis {

	private String illness;
	private String description;
	private String severity;
	private Doctor diagnosedBy;

	public Doctor getDiagnosedBy() {
		return diagnosedBy;
	}

	public void setDiagnosedBy(Doctor diagnosedBy) {
		this.diagnosedBy = diagnosedBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Diagnosis [illness=" + illness + ", description=" + description + ", severity=" + severity
				+ ", diagnosedBy=" + diagnosedBy + "]";
	}

}
