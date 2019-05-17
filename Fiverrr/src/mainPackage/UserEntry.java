package mainPackage;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author lloan
 *
 */
public class UserEntry extends Entry {

	public UserEntry() {
		super();
	}

	/**
	 * @param entryAmount
	 * @param entryDate
	 * @param entryType
	 */
	public UserEntry(BigDecimal entryAmount, Date entryDate, String entryType) {
		super(entryAmount, entryDate, entryType);
	}

	
	public Entry createEntry(BigDecimal entryAmount, Date entryDate) {
		return new UserEntry(entryAmount, entryDate, "user");
	}
	
}
