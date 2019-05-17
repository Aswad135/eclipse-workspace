package mainPackage;
import java.io.FileWriter;
import java.util.Date; // for date 

public class Check implements Printable{

	// declare all class properties
	private String accountID = "";
	private String bankID = "";
	private String userID = "";
	private int number = 0;
	private String payee = "";
	private double amount = 0;
	private Date date = null;
	private int checkID = 0;


	// constructor method - takes props and assigns them when creating a new instance
	public Check(String userID, String accountID, String bankID, int number, String payee, double amount, Date date , int checkID) {
		this.userID = userID;
		this.setAccountID(accountID);
		this.setBankID(bankID);
		this.number = number;
		this.payee = payee;
		this.amount = amount;
		this.date = date;
		this.checkID = checkID;
		
	}
	
	/**
	 * empty constructor	
	 */
	
	public Check() {}




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

	/**
	 * @return boolean
	 */
	public boolean validateDate() {
		return this.getDate() != null;
	}
	/**
	 * 
	 * @param u_id
	 */
	//SET USER ID
	public void setUserId(String u_id){
		this.userID = u_id;
	}

	//GET USER ID
	public String getUserId(){
		return(this.userID);
	}
	
	/**
	 * @return boolean
	 */
	public boolean validateUserID() {
		return this.userID != "" && this.userID != null;
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
	 * @return boolean
	 */
	public boolean validateAmount() {
		return this.amount >0;
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
	 * @return boolean
	 */
	public boolean validateNumber() {
		return this.number > 0;
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
	 * @return boolean
	 */
	public boolean validateAccountID() {
		return this.accountID != "" && this.accountID != null;
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
	 * @return boolean
	 */
	public boolean validateBankID() {
		return this.bankID != "" && this.bankID != null;
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

	/**
	 * @return boolean
	 */
	public boolean validatePayee() {
		return this.payee != "" && this.payee != null;
	}
	

	
	@Override
	public String toString() {
		return "Check [accountID=" + accountID + ", bankID=" + bankID + ", userID=" + userID + ", number=" + number
				+ ", payee=" + payee + ", amount=" + amount + ", date=" + date + "]";
	}

	@Override
	public void print() {
		print(this, "defaultChecksFile"+checkID+".txt", false);
	}


	@Override
	public void print(Object printThis, String FILEPATH, boolean Append) {
		try{    
			FileWriter fw=new FileWriter(FILEPATH, Append);    
			fw.write(printThis.toString() + "\n");    
			fw.close();    
		}catch(Exception e)
		{
			System.out.println(e);
		}        

	}

}