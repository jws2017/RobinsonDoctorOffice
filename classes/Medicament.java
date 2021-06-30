package classes;

public class Medicament {

	private String name;
	private String dosage;
	private Doctor prescribedBy;

	public Medicament(String name, String dosage, Doctor prescribedBy) {
		this.name = name;
		this.dosage = dosage;
		this.prescribedBy = prescribedBy;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Medicament [name=" + name + ", dosage=" + dosage + ", prescribedBy=" + prescribedBy + "]";
	}

}
