package mainPackage;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * 
 * @author lloan
 *
 */
public class AddressTest {

	@Test

	// this test will check that one address line is returned
	public void validateStreet1() {

		// set test properties
		String street1 = "1506 W Gage Ave";
		String city = "Rialto";
		String state = "CA";
		String zip = "90003";

		// create a new check instance with test data from above
		Address address = new Address(street1, "", city, state, zip);
		String expectedResult = city + ", " + state + ", " + zip;
		String oneStreet = street1 + ", " + expectedResult;

		// check address is returned with just one address line
		assertEquals(oneStreet, address.getMailingAddress());

	}

	@Test

	/**
	 * Makes sure city, state and zip code are set
	 */
	public void validateAddress() {
		// set test properties
		String street1 = "1506 W Gage Ave";
		String street2 = "Apt 2A";
		String city = "Rialto";
		String state = "CA";
		String zip = "90003";

		// create a new check instance with test data from above
		Address address = new Address(street1, street2, city, state, zip);

		assertTrue("City, state and zip code are properly set.", address.validateAddress());
	}

	@Test

	/**
	 * Validates zip code, makes sure its 5 digits long (expected)
	 * HAPPY TEST
	 */
	public void testValidZipCode() {

		// create a new address to test
		Address address = new Address(null, null, null, null, "90003"); 

		boolean testResult = true;
		// check address is returned with two address lines
		assertEquals(testResult, address.validateZip()); 
	}
	@Test
	/**
	 * Validates zip Code Using Happy Test (Negative)
	 */
	public void testInvalidZipCpde() {
		// create a new address to test
		Address address = new Address(null, null, null, null, "90"); 

		boolean testResult = false;
		// check address is returned with two address lines
		assertEquals(testResult, address.validateZip()); 

	}


	
}