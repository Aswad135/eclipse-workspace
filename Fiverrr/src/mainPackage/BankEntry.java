package mainPackage;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lloan
 *
 */
public class BankEntry extends Entry { 
 
	
	public BankEntry() {
		super();
	}

	
	/**
	 * @param entryAmount
	 * @param entryDate
	 * @param entryType
	 */
	public BankEntry(BigDecimal entryAmount, Date entryDate, String entryType) {
		super(entryAmount, entryDate, entryType);
	}

	
	public Entry createEntry(BigDecimal entryAmount, Date entryDate) {
		return new BankEntry( entryAmount,  entryDate, "bank");
	}


}
