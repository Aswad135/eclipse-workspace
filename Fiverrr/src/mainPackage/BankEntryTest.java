package mainPackage;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
// all necessary imports

/**
 * 
 * @author lloan
 *
 */
public class BankEntryTest {

	@Test

	/**
	 * Test creation of bank entry 
	 */
	public void testCreateEntry() {
		BigDecimal amount = new BigDecimal("90.80");
		Date date = new Date();
		String type = "bank";

		BankEntry entry1 = new BankEntry(amount, date, type);

		String expectedResult = "Entry{" + "entryAmount=" + amount + ", entryDate=" + date + ", entryType=" + type
				+ '}';

		assertEquals(expectedResult, entry1.createEntry());

	}

	@Test

	/**
	 * Test entry type to make sure its set to bank
	 */
	public void testEntryType() {
		BigDecimal amount = new BigDecimal("90.80");
		Date date = new Date();
		String type = "bank";

		BankEntry entry1 = new BankEntry(amount, date, type);

		String expectedResult = "bank";

		assertEquals(expectedResult, entry1.getEntryType());
	}

}
