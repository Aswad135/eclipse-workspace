/**
 * 
 * @author lloan
 *
 */
public class Address {

	// declare all class properties
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String zip;

	// constructor method - takes props and assigns them when creating a new
	// instance
	public Address(String street1, String street2, String city, String state, String zip) {
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * @return street1
	 */
	public String getStreet1() {
		return street1;
	}

	// set street1
	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	/**
	 * Checks that street1 is not empty
	 * 
	 * @return
	 */
	public boolean validateStreet1() {
		return street1.length() != 0;
	}

	/**
	 * @return street2
	 */
	public String getStreet2() {
		return street2;
	}

	// set Street2
	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public boolean validateStreet2() {
		return street2.length() != 0;
	}

	/**
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	public boolean validateCity() {
		return city.length() != 0 && city.matches("^[a-zA-Z]*$");
	}

	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}

	// set state
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Validate State
	 * 
	 * @return
	 */
	public boolean validateState() {
		// validating state field before assigning
		return state.length() == 2;
	}

	/**
	 * @return zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip set zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return bool
	 */
	public boolean validateZip() {
		// validate zip is 5 digits long and that all characters are digits
		return zip.length() >= 5 && zip.matches("-?\\d+");
	}

	/**
	 * @return bool
	 */
	public boolean validateAddress() {
		return this.validateState() && this.validateZip() && this.validateCity();
	}

	/**
	 * @return mailing address
	 */
	public String getMailingAddress() {
		String result = this.getCity() + ", " + this.getState() + ", " + this.getZip();

		if (this.validateStreet2()) {
			return this.getStreet1() + ", " + this.getStreet2() + ", " + result;
		} else {
			return this.getStreet1() + ", " + result;
		}  
	}
}