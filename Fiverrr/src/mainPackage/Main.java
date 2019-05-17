package mainPackage;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author lloan
 *
 */
public class Main {
	public static Scanner in = new Scanner(System.in);
	static Bank Banks = new Bank();
	static User Users = new User();
	static Entry Entries = new Entry();
	static int b = 0; // counts
	//static int u = 0; // users
	//static int e = 0; // entries
	private static Scanner s;

	/**
	 * 
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		int ch = 0; // choice
		while (ch != 11) {
			// let user choose what action to take
			System.out.println("Press 1 to create new Bank");
			System.out.println("Press 2 to create new User");
			System.out.println("Press 3 to create new Entry");
			System.out.println("Press 4 to display all user(s) info");
			System.out.println("Press 5 to display all bank info");
			System.out.println("Press 6 to display all entries");
			System.out.println("Press 7 to Terminate ");
			ch = in.nextInt();



			// choices
			if (ch == 1) {
				createNewBank();
			} else if (ch == 2) {
				createUser();
			} else if (ch == 3) {
				createEntry();
			} else if (ch == 4) {
				displayUsers();
			} else if (ch == 5) {
				displayBanks();
			} else if (ch == 6) {
				displayEntries();
			} else if (ch == 7) {
				System.out.println("Goodbye!");
				return;
			}

		}
	}

	/**
	 * Creates an entry with an amount, date and type (bank/user)
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Entry createEntry() throws ParseException {
		// Let user know we're creating an entry
		System.out.println("#####CREATING ENTRY######");
		s = new Scanner(System.in);

		// Declaring variables we will use
		BigDecimal entryAmount = new BigDecimal(0.0);
		Date entryDate;
		String entryType = null;


		while (true) {
			// Give user choice between bank and user entry
			System.out.print("Enter \"user\" for User entry or \"bank\" for Bank entry. And \"exit\" to exit");

			// Captured user input as integer
			entryType = s.next();

			//checking for validity of input
			if(entryType.equalsIgnoreCase("user") || entryType.equalsIgnoreCase("bank")) 
				break;
			//checking if user is interested anymore
			else if(entryType.equalsIgnoreCase("exit"))
				return null;
			System.out.println("Invalid choice entered. Please try again.");
		}
		// Validate user choice
		if (entryType.equalsIgnoreCase("user")) 				// treat as user
			System.out.println("User entry type selected.");
		else if (entryType.equalsIgnoreCase("bank"))  			// treat as bank
			System.out.println("Bank entry type selected.");


		// Get entry amount user input
		try {
			System.out.print("Enter Entry Amount : ");
			entryAmount = s.nextBigDecimal(); // assign to bigDecimal
			entryDate = new Date(); // using date as a time stamp - today's date
		} catch (Exception e){
			System.out.println("##### Invalid input for entry amount, please try again. ######");
			return null;
		}

		// Create a new entry using entryAmount, today's date and entryType
		Entry ENTRY = new Entry((BigDecimal) entryAmount, (Date) entryDate, (String) entryType);

		//printing the entries into a file
		ENTRY.print();

		Entries = ENTRY; // push entry in to the array of entries

		//e += 1; // increase count of total entries

		// Let user know entry was created successfully
		System.out.println("##### Entry Created Successfully ######");

		// Return the entry
		return ENTRY;


	}

	/**
	 * Displays all entries. Iterates through entries and displays all information.
	 */
	public static void displayEntries() {
		// iterate through all users and display information
		//		for (int i = 0; i < Entries.length; i++) {
		System.out.println("#########################");

		//			if (Entries == null) {
		//				break;
		//			}

		//System.out.println("Entry Number: " + (i + 1));
		System.out.println("Amount: " + Entries.getEntryAmount());
		System.out.println("Date: " + Entries.getEntryDate());
		System.out.println("Type: " + Entries.getEntryType());
	}
	//	}
	
	@SuppressWarnings("unused")
	/**
	 * Creates a new address
	 * 
	 * @return
	 */
	public static Address createAddress() {
		System.out.println("#####CREATING ADDRESS######");
		String streetOne, streetTwo, city, state, zip;

		// Get input from user to create address
		String s = in.nextLine();

		System.out.println("Enter Street 1 : ");
		streetOne = in.nextLine();

		// optional entry
		System.out.println("Enter Street 2 : (Optional) ");
		streetTwo = in.nextLine();

		System.out.println("Enter City : ");
		city = in.nextLine();

		System.out.println("Enter State : (Abbreviation, Ex: CA) ");
		state = in.nextLine();

		System.out.println("Enter Zip code: (Five digit zip code, Ex: 92376)");
		zip = in.nextLine();

		// Create new address with user input
		Address address = new Address((String) streetOne, (String) streetTwo, (String) city, (String) state,
				(String) zip);

		// Validate address
		if (address.validateAddress()) { // if true, create new address
			// Let user know address has been created
			System.out.println("##### Address Created Successfully ######\n");
			return address; // return address
		} else {
			// if validation fails return null and let user know
			System.out.println("##### Address Provided is Invalid ######\n");
			return null;
		}

	}

	/**
	 * Creates a new bank
	 * @return 
	 */
	public static Bank createNewBank() {
		// Let user know they need to create an address for the new bank
		System.out.println("### To create a bank, first create a bank address ####");
		// create new address
		Address address = createAddress(); // get user to create an address

		// if user fails to create an address, return early
		if (address == null) {
			return null;
		}

		// let user know we're working on creating the bank
		System.out.println("##### CREATING BANK ######");

		String id, name, phone;

		// get user input for bank information
		System.out.println("Enter ID : ");
		id = in.nextLine();
		System.out.println("Enter Name : ");
		name = in.nextLine();
		System.out.println("Enter Phone number (10 characters: ");
		phone = in.nextLine();

		// Create new bank with user input
		Bank BANK = new Bank(id, name, address, phone);

		if (BANK.validateBank()) {
			Banks = BANK; // add bank to banks array

			//			b += 1; // increase count of total banks

			// Let user know bank has been created successfully.
			System.out.println("##### Bank created Successfully ######");

			return BANK;
		} else {
			// Let user know bank has been created successfully.
			System.out.println("##### Bank creation failed ######");

			return null;

		}

	}

	/**
	 * Create user
	 */
	public static void createUser() {
		// Let user know a new address is needed for the new user
		System.out.println("#### To create a user, first create an user address ####");

		// create new address
		Address address = createAddress();

		// if user fails to create an address, return early
		if (address == null) {
			return;
		}

		// Let user know the new user is being created
		System.out.println("#####CREATING USER ######");

		// get user input for new user
		String id, first, last;
		System.out.println("Enter USER ID : ");
		id = in.nextLine();

		// validate user ID
		try {
			// make sure new user doesn't exists
			//			for (int i = 0; i < Users.length; i++) {
			// traverse users array
			if (Users.getId().equalsIgnoreCase(id) && Users != null) {
				// create random user ID
				Random rand = new Random();
				// set ID to new random ID -
				// TODO: must come up with better way to create random ID
				id = String.valueOf(rand.nextInt(50));
				//					break;
			}
			//			}
		} catch (NullPointerException n) {
			// handle error
			// TODO: figure out what to do if we catch an error
		}

		// Get user input for new user
		System.out.println("Enter First Name : ");
		first = in.nextLine();
		System.out.println("Enter Last Name :");
		last = in.nextLine();
		System.out.println("Initial number of checks to create :");

		int numberOfChecks = in.nextInt();
		Check[] CHECKS = new Check[numberOfChecks];

		// create initial checks
		for (int j = 0; j < numberOfChecks; j++) {
			System.out.println("CREATING CHECK NUMBER " + (j + 1));
			CHECKS[j] = createCheck(id);
		}

		// create the new user
		User user = new User(id, first, last, address);

		// add to list of users
		Users = user;

		// increase user count
		//		u += 1;

		// let user know operation was successful
		System.out.println("##### User Created Successfully ######");

	}

	/**
	 * Creates a check for user
	 * 
	 * @param userID
	 * @return
	 */
	public static Check createCheck(String userID) {
		// Let user know check is being created
		System.out.println("##### CREATING CHECK ######");

		// All variables to be used
		String accountID, bankID, userId, payee;
		int number;
		double amount;
		Date date;

		// Make sure user ID is provided
		if (userID.equalsIgnoreCase("0")) {
			System.out.println("Enter USER ID : ");
			userId = in.nextLine();
		} else {
			userId = userID;
		}

		// get information for check
		System.out.println("Enter Bank Id: ");
		bankID = in.nextLine();
		in.nextLine();
		System.out.println("Enter account id : ");
		accountID = in.nextLine();
		System.out.println("Enter Payee : ");
		payee = in.nextLine();

		// get number - try/catch as these types are tricky
		try {
			System.out.println("Enter number (Must be integer): ");
			number = in.nextInt();
			System.out.println("Enter amount (Must be double): ");
			amount = in.nextDouble();
			date = new Date();
		} catch (InputMismatchException e) {
			// TODO: find better way to move forward than setting values
			System.out.println("Input missmatch exception occur.");
			number = 0;
			amount = 0.0;
			date = new Date();
		}

		// create new check
		Check newCheck = new Check(userId, accountID, bankID, number, payee, amount, date, b);

		//printing the checks into a file
		newCheck.print();
		b++;

		// Let user know check was created successfully
		System.out.println("##### Check Created Successfully ######");

		// return the new check
		return newCheck;
	}

	/**
	 * Displays all users Traverse through users array, log all user info to console
	 */
	public static void displayUsers() {

		// iterate through all users and display information
		//		for (int i = 0; i < Users.length; i++) {
		// separator
		System.out.println("#########################");

		// is user is set to null
		//			if (Users[i] == null) {
		//				break;
		//			}

		// Display user number and user information
		//			System.out.println("USER NO: " + (i + 1));
		System.out.println(Users.getUserInfo());
	}

	//	}

	/**
	 * Display all banks information
	 */
	public static void displayBanks() {

		// iterate through all banks and print out information
		//		for (int i = 0; i < Banks.length; i++) {
		System.out.println("+++++++++++++++++++++++");

		// if bank is null, skip it
		//			if (Banks[i] == null) {
		//				break;
		//			}

		// Log bank number and information
		//			System.out.println("Bank No : " + (i + 1));
		System.out.println(Banks.getBankInfo());
	}
}
//}