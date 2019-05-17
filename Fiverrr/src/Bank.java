/**
 * 
 * @author lloan
 *
 */
public class Bank {
    private String id;
    private String name;
    private Address address;
    private String phoneNumber;

    /**
     * 
     * @param id
     * @param name
     * @param address
     * @param phoneNumber
     */
    public Bank(String id, String name, Address address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    //get ID
    public String getId() {
        return id;
    }

    //set ID
    public void setId(String id) {
        this.id = id;
    }

    //get name
    public String getName() {
        return name;
    }

    //set name
    public void setName(String name) {
        this.name = name;
    }
    
    public boolean validateName() {
    	return this.name.length() != 0;
    }

    //get address
    public Address getAddress() {
        return address;
    }

    //set address
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public boolean validateAddress() {
    	return this.address.validateAddress();
    }

    //get phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    //set phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Validate Phone Number
     * @return
     */
    public boolean validatePhone() { 
        // validate phone is composed of only digits and greater than or equal to 10 digits
    	return phoneNumber.matches("-?\\d+") && phoneNumber.length() >= 10;
    }
    
    /**
     * Validate Bank
     * @return
     */
    public boolean validateBank() {
    	return this.validateAddress() && this.validatePhone() && this.validateName();
    }

    //get bank information
    public String getBankInfo(){
        return ("BANK INFO -> "+this.id +", "+", "+this.name+", "+ this.getPhoneNumber() + ", " + this.address.getMailingAddress());
    }
}

