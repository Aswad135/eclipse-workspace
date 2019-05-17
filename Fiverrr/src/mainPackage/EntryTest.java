package mainPackage;
// all necessary imports
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class EntryTest {	
	@Test

	/**
	 * Validates entryType makes sure its not empty (expected) HAPPY TEST
	 */
	public void testEntryType() {

		Entry entry = new Entry(new BigDecimal(90),new Date(),"user");

		boolean testResult = true;


		assertEquals(testResult, entry.validateEntryType());

	}

	@Test

	/**
	 * Validates type Using Happy Test (Negative)
	 */
	public void testInvalidEntryType() {

		Entry entry = new Entry(new BigDecimal(0),new Date(),"invalidType");

		boolean testResult = false;

		// Makes sure test fails when provided invalid data
		assertEquals(testResult, entry.validateEntryType());

	}






	@Test

	/**
	 * Validates amount makes sure its not empty (expected) HAPPY TEST
	 */
	public void testAmount() {

		Entry entry = new Entry(new BigDecimal(90),new Date(),"user");

		boolean testResult = true;


		assertEquals(testResult, entry.validateEntryAmount());

	}

	@Test

	/**
	 * Validates amount Using Happy Test (Negative)
	 */
	public void testInvalidAmount() {

		Entry entry = new Entry(new BigDecimal(0),new Date(),"user");

		boolean testResult = false;

		// Makes sure test fails when provided invalid data
		assertEquals(testResult, entry.validateEntryAmount());

	}

	
	@Test

	/**
	 * Validates Date makes sure its not empty (expected) HAPPY TEST
	 */
	public void testDate() {

		Entry entry = new Entry(new BigDecimal(90),new Date(),"user");
		
		boolean testResult = true;

		// Makes sure test fails when provided invalid data
		assertEquals(testResult,entry.validateDate());

	}

	
	@Test

	/**
	 * Validates Date Using Happy Test (Negative)
	 */
	public void testInvalidDate() {

		Entry entry = new Entry(new BigDecimal(90),null,"user");
		boolean testResult = false;

		// Makes sure test fails when provided invalid data
		assertEquals(testResult,entry.validateDate());

	}

	
	@Test
	/**
	 * Tests all the data for Validation Checks
	 * @throws ParseException
	 */
	public void testAllData() throws ParseException {
		// create a new check instance with test data from above
		Entry entry = new Entry();
		entry.setEntryAmount(new BigDecimal(90));
		entry.setEntryDate(new Date());
		entry.setEntryType("user");
		boolean test = entry.validateDate() && entry.validateEntryAmount() && entry.validateEntryType();
		assertEquals(true,test);

	}

}