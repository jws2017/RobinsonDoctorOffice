package classes;

public class Address {

	private String street, city, parish;
	private double xcoord, ycoord;

	public Address(String street, String city, String parish, double xcoord, double ycoord) {
		this.street = street;
		this.city = city;
		this.parish = parish;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", parish=" + parish + ", xcoord=" + xcoord
				+ ", ycoord=" + ycoord + "]";
	}

}
