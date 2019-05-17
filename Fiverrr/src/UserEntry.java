import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author lloan
 *
 */
public class UserEntry extends Entry {

	/**
	 * @param entryAmount
	 * @param entryDate
	 * @param entryType
	 */
	public UserEntry(BigDecimal entryAmount, Date entryDate, String entryType) {
		super(entryAmount, entryDate, entryType);
	}

}
