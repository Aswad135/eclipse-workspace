import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lloan
 *
 */
public class BankEntry extends Entry { 
 
	/**
	 * @param entryAmount
	 * @param entryDate
	 * @param entryType
	 */
	public BankEntry(BigDecimal entryAmount, Date entryDate, String entryType) {
		super(entryAmount, entryDate, entryType);
	}



}
