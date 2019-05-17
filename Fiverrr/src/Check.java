import java.util.Date; // for date 

public class Check {

	// declare all class properties
    private String accountID;
    private String bankID;
    private String userID;
    private int number;
    private String payee;
    private double amount;
    private Date date;


    // constructor method - takes props and assigns them when creating a new instance
    public Check(String userID, String accountID, String bankID, int number, String payee, double amount, Date date) {
    	this.userID = userID;
        this.setAccountID(accountID);
        this.setBankID(bankID);
        this.number = number;
        this.payee = payee;
        this.amount = amount;
        this.date = date;
    }


    // method that returns check info as a string 
    public String getCheckInfo() {
        String result = "CHECK INFO --> " + ", " +userID+ ", " +bankID+ ", " +accountID+ ", " +number+ ", " +payee+ ", " +amount+ ", " +date;
        return result;
    }

    /**
     * @return the date 
     */
    public Date getDate() {
    	return date;
    }
    
    /**
     * @param date set date
     */
    public void setDate(Date date) {
    	this.date = date; 
    }

	//SET USER ID
    public void setUserId(String u_id){
    	this.userID = u_id;
	}

	//GET USER ID
	public String getUserId(){
		return(this.userID);
	}

    /**
     * @return the amount 
     */
    public double getAmount() {
    	return amount;
    }
    
    /**
     * @param amount set the amount
     */
    public void setAmount(double amount) {
    	this.amount = amount; 
    }
    
    /**
     * @return number
     */
    public int getNumber() {
    	return number;
    }
    
    /**
     * @param number the number to be set
     */
    public void setNumber(int number) {
    	this.number = number; 
    }
    
	/**
	 * @return the accountID
	 */
	public String getAccountID() {
		return accountID;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}

	/**
	 * @return the bankID
	 */
	public String getBankID() {
		return bankID;
	}

	/**
	 * @param bankID the bankID to set
	 */
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	

	/**
	 * @return the payee
	 */
	public String getPayee() {
		return payee;
	}

	/**
	 * @param payee the payee to set
	 */
	public void setPayee(String payee) {
		this.payee = payee;
	}

}