import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test; 

/**
 * 
 * @author lloan
 *
 */
public class UserEntryTest {
	
    @Test

    /**
     * Test the creation of an entry
     */
    public void testCreateEntry() { 
		BigDecimal amount = new BigDecimal("90.80");
		Date date= new Date();
		String type="user";
		
		UserEntry entry1 = new UserEntry(amount,date,type);
		  
		String expectedResult = "Entry{" + "entryAmount=" + amount + ", entryDate=" + date + ", entryType=" + type + '}';
		
		assertEquals(expectedResult, entry1.createEntry());
         
    } 	
    
    @Test

    /**
     * Test entry type to make sure its set to bank
     */
	public void testEntryType() {
		BigDecimal amount = new BigDecimal("90.80");
		Date date = new Date();
		String type = "user";

		UserEntry entry1 = new UserEntry(amount, date, type);

		String expectedResult = "user";

		assertEquals(expectedResult, entry1.getEntryType());
	}


}
