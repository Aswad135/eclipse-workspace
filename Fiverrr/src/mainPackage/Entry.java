package mainPackage;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author lloan
 *
 */
public class Entry implements Printable {
    private BigDecimal entryAmount = null;
    private Date entryDate = null;
    private String entryType = "";


	/**
	 * Empty Constructor
	 */
	
    public Entry() {}

	/**
     * Get initial values
     * 
     * @param entryAmount
     * @param entryDate
     * @param entryType
     */
    public Entry(BigDecimal entryAmount, Date entryDate, String entryType) {
        this.entryAmount = entryAmount;
        this.entryDate = entryDate;
        this.entryType = entryType;
    }

	/**
     * Set entry amount
     * @param entryAmount
     */
    public void setEntryAmount(BigDecimal entryAmount) {
        this.entryAmount = entryAmount;
    }

    /**
     * Set entry date 
     * @param entryDate
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * Set entry type
     * @param entryType
     */
    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    /**
     * 
     * @return boolean
     */
    
    public boolean validateEntryType() {
    	return (this.getEntryType().equalsIgnoreCase("bank") || this.getEntryType().equalsIgnoreCase("user")); 
    }
    
    /**
     * Get entry amount
     * @return
     */
    public BigDecimal getEntryAmount() {
        return entryAmount;
    }

    /**
     * Get entry date
     * @return
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * Get entry type 
     * @return
     */
    public String getEntryType() {
        return entryType;
    }

    /**
     * Create an entry 
     * @return
     */
    public Entry createEntry() {
        return new Entry();
    }
    
    /**
     * 
     * @param entryAmount
     * @param entryDate
     * @param entryType
     * @return EntryObject
     */
    public Entry createEntry(BigDecimal entryAmount, Date entryDate, String entryType) {
    	return new Entry(entryAmount, entryDate, entryType);
        
    }

    /**
     * @return boolean
     */
    public boolean validateDate() {
    	return this.getEntryDate() != null;
    }
     
    /**
	 * @return boolean
	 */
	public boolean validateEntryAmount() {
		return this.entryAmount.intValue() > 0 ;
	}
	    
    @Override
	public String toString() {
		return "Entry [entryAmount=" + entryAmount + ", entryDate=" + entryDate + ", entryType=" + entryType + "]";
	}
    
    @Override
	public void print() {
		print(this, "defaultEntriesFile.txt", true);
	}


	@Override
	public void print(Object printThis, String FILEPATH, boolean Append) {
		try{    
			FileWriter fw=new FileWriter(FILEPATH, Append);    
			fw.write(printThis.toString() + "\n");    
			fw.close();    
		}catch(Exception e)
		{
			System.out.println(e);
		}        

	}
    
}
