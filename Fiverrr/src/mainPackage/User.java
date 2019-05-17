package mainPackage;
/**
 * 
 * @author lloan
 *
 */
public class User {
	private String id = "";
	private String first = "";
	private String last = "";
	private Address address = null;


	/**
	 * Empty Constructor
	 */
	
	
	public User() {}
	
	/**
	 * 
	 * @param id
	 * @param first
	 * @param last
	 * @param address
	 */
	public User(String id, String first, String last, Address address) {
		this.id = id;
		this.first = first;
		this.last = last;
		this.address = address;
	}


	
	
	/**
	 * Get user ID
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set user ID
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get first name
	 * @return
	 */
	public String getFirst() {
		return first;
	}

	/**
	 * Set first name
	 * @param first
	 */
	public void setFirst(String first) {
		this.first = first;
	}

	/**
	 * Get last name
	 * @return
	 */
	public String getLast() {
		return last;
	}

	/**
	 * Set last name
	 * @param last
	 */
	public void setLast(String last) {
		this.last = last;
	}

	/**
	 * Get address
	 * @return
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Set address
	 * @param address
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * Get all user information
	 * @return
	 */
	public String getUserInfo() {
		String result = "User --> " + this.id + ", " + this.first + ", " + this.last + "\nAddress --> ";
		result += this.address.getMailingAddress();
		return result;
	}
	
	/**
	 * @return boolean
	 */
	public boolean validateUserID() {
		return this.getId() != "";
	}
	
	/**
	 * @return boolean
	 */
	public boolean validateUserName() {
		return this.getFirst() != "" && this.getLast() != "";
	}

	/**
	 * @return boolean
	 */
	public boolean validateUserAddress() {
		return this.getAddress() != null && this.getAddress().validateAddress();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", first=" + first + ", last=" + last + ", address=" + address + "]";
	}
	
	
}