// all necessary imports
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Check check = new Check(userID, accountID, bankID, number, payee, amount, date); 
        
        String expectedResult = "CHECK INFO --> " + ", " +userID+ ", " +bankID+ ", " +accountID+ ", " +number+ ", " +payee+ ", " +amount+ ", " + date;
        
        
        // check to make sure expected data is returned
        assertEquals(expectedResult, check.getCheckInfo());
         
    } 	
	
}