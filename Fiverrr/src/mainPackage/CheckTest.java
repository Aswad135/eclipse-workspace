package mainPackage;
// all necessary imports
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class CheckTest {

	@Test

	// this test will check that all properties return the correct data
    public void testGetCheckInfo () throws Throwable{ 
    	 
		// set test properties 
		String userID = "001";
    	String accountID = "1AD324DEW";
    	String bankID = "QWGRE45SSDF1";
   	    int number = 33412;
   	    String payee = "lloan alas";
   	    double amount = 99.99;
   	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("04/07/2019");  

   	    // create a new check instance with test data from above
        Check check = new Check(userID, accountID, bankID, number, payee, amount, date,0); 
        
        String expectedResult = "CHECK INFO --> " + ", " +userID+ ", " +bankID+ ", " +accountID+ ", " +number+ ", " +payee+ ", " +amount+ ", " + date;
        
        
        // check to make sure expected data is returned
        assertEquals(expectedResult, check.getCheckInfo());
         
    } 	
	
	@Test

	/**
	* Validates userID makes sure its not empty (expected) HAPPY TEST
	*/
	public void testUserID() {
	
	Check check = new Check("01H-User", null, null, 0, null, 0, null,0);

	boolean testResult = true;

	
	assertEquals(testResult, check.validateUserID());

	}

	@Test

	/**
	* Validates userID Using Happy Test (Negative)
	*/
	public void testInvalidUserID() {
	
	Check check = new Check("", null, null, 0, null, 0, null,0);

	boolean testResult = false;

	// Makes sure test fails when provided invalid data
	assertEquals(testResult, check.validateUserID());
	}
	
	
	@Test

	/**
	* Validates accountID makes sure its not empty (expected) HAPPY TEST
	*/
	public void testAccountID() {
	
	Check check = new Check("", "HAS87BH", null, 0, null, 0, null,0);

	boolean testResult = true;

	
	assertEquals(testResult, check.validateAccountID());

	}

	@Test

	/**
	* Validates accountID Using Happy Test (Negative)
	*/
	public void testInvalidAccountID() {
	
	Check check = new Check("", null, null, 0, null, 0, null,0);

	boolean testResult = false;

	// Makes sure test fails when provided invalid data
	assertEquals(testResult, check.validateAccountID());

	}
	
	@Test

	/**
	* Validates BankID makes sure its not empty (expected) HAPPY TEST
	*/
	public void testBankID() {
	
	Check check = new Check("", null, "SampleBankId", 0, null, 0, null,0);

	boolean testResult = true;

	
	assertEquals(testResult, check.validateBankID());

	}

	@Test

	/**
	* Validates BankID Using Happy Test (Negative)
	*/
	public void testInvalidBankId() {
	
	Check check = new Check("", null, null, 0, null, 0, null,0);

	boolean testResult = false;

	// Makes sure test fails when provided invalid data
	assertEquals(testResult, check.validateBankID());

	}
	
	@Test

	/**
	* Validates Number makes sure its not empty (expected) HAPPY TEST
	*/
	public void testNumber() {
	
	Check check = new Check("", null, null, 2, null, 0, null,0);

	boolean testResult = true;

	
	assertEquals(testResult, check.validateNumber());

	}

	@Test

	/**
	* Validates Number Using Happy Test (Negative)
	*/
	public void testInvalidNumber() {
	
	Check check = new Check("", null, null, 0, null, 0, null,0);

	boolean testResult = false;

	// Makes sure test fails when provided invalid data
	assertEquals(testResult, check.validateNumber());

	}
	
	@Test

	/**
	* Validates payee makes sure its not empty (expected) HAPPY TEST
	*/
	public void testPayee() {
	
	Check check = new Check("", null, null, 0, "SamplePayee", 0, null,0);

	boolean testResult = true;

	
	assertEquals(testResult, check.validatePayee());

	}

	@Test

	/**
	* Validates payee Using Happy Test (Negative)
	*/
	public void testInvalidPayee() {
	
	Check check = new Check("", null, null, 0, null, 0, null, 0);

	boolean testResult = false;

	// Makes sure test fails when provided invalid data
	assertEquals(testResult, check.validatePayee());

	}
	
	@Test

	/**
	* Validates amount makes sure its not empty (expected) HAPPY TEST
	*/
	public void testAmount() {
	
	Check check = new Check("", null, null, 0, null, 12.98, null,0);

	boolean testResult = true;

	
	assertEquals(testResult, check.validateAmount());

	}

	@Test

	/**
	* Validates amount Using Happy Test (Negative)
	*/
	public void testInvalidAmount() {
	
	Check check = new Check("", null, null, 0, null, 0, null, 0);

	boolean testResult = false;

	// Makes sure test fails when provided invalid data
	assertEquals(testResult, check.validateAmount());

	}
	
	
	@Test

	/**
	* Validates Date makes sure its not empty (expected) HAPPY TEST
	*/
	public void testDate() {
	
	Check check = new Check("", null, null, 0, null, 0, new Date(),0);
	
	boolean testResult = true;

	
	assertEquals(testResult, check.validateDate());

	}

	
	@Test

	/**
	* Validates Date Using Happy Test (Negative)
	*/
	public void testInvalidDate() {
	
	Check check = new Check("", null, null, 0, null, 0, null, 0);
	
	boolean testResult = false;

	// Makes sure test fails when provided invalid data
	assertEquals(testResult, check.validateDate());

	}
	
	@Test
	/**
	 * Tests all the data for Validation Checks
	 * @throws ParseException
	 */
	public void testAllData() throws ParseException {
		// set test properties 
		String userID = "001";
    	String accountID = "1AD324DEW";
    	String bankID = "QWGRE45SSDF1";
   	    int number = 33412;
   	    String payee = "lloan alas";
   	    double amount = 99.99;
   	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse("04/07/2019");  

   	    // create a new check instance with test data from above
        Check check = new Check(userID, accountID, bankID, number, payee, amount, date, 0); 
        boolean test = check.validateAccountID() && check.validateAmount() && check.validateBankID() && 
        		check.validateNumber() && check.validateUserID() && check.validatePayee();
        assertEquals(true,test);
        
	}
	
}