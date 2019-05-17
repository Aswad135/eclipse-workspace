package mainPackage;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
// all necessary imports
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author lloan
 *
 */
public class BankTest {

	@Test

	/**
	 * Checks that all properties return the correct data
	 */
	public void testExpectedInput() {
		// set test properties
		String id = "04";
		String name = "lloan";
		Address address = new Address("495 S Rexford St", "", "Rialto", "CA", "92376");
		String phoneNumber = "9094365446";

		// create a new check instance with test data from above
		Bank bank = new Bank(id, name, address, phoneNumber);

		String expectedResult = "BANK INFO -> " + id + ", " + ", " + name + ", " + phoneNumber + ", "
				+ address.getMailingAddress();

		// check to make sure expected data is returned
		assertEquals(expectedResult, bank.getBankInfo());

	}

	@Test

	/**
	 * Makes sure phone number is properly formatted.
	 */
	public void validatePhoneFormat() {

		// create a new address to test
		Bank phone = new Bank(null, null, null, "9094365446");

		// check address is returned with two address lines
		assertTrue("Phone is correctly formatted.", phone.validatePhone());

	}

	@Test

	/**
	 * Checks to make sure phone number is the minimum length of 10 characters.
	 */
	public void isNotShortPhone() {
		Bank shortPhone = new Bank(null, null, null, "909436");
		assertFalse("Phone is too short.", shortPhone.validatePhone());
	}

	@Test

	/**
	 * Checks to make sure all characters are digits 
	 */
	public void isAllDigits() {
		Bank incorrectPhone = new Bank(null, null, null, "asE3");
		assertFalse("Phone has letters.", incorrectPhone.validatePhone());

	}

	@Test

	/**
	 * Validates the successful creation of a bank entity
	 */
	public void validateBankCreation() {
		// set test properties
		String id = "04";
		String name = "lloan";
		Address address = new Address("495 S Rexford St", "", "Rialto", "CA", "92376");
		String phoneNumber = "9094365446";

		// create a new check instance with test data from above
		Bank bank = new Bank(id, name, address, phoneNumber);

		// check to make sure expected data is returned
		assertTrue("Bank passes validation.", bank.validateBank());
	}

}