import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * @author lloan
 *
 */
public class Entry {
    private BigDecimal entryAmount;
    private Date entryDate;
    private String entryType;

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
    public String createEntry() {
        return "Entry{" + "entryAmount=" + entryAmount + ", entryDate=" + entryDate + ", entryType=" + entryType + '}';
    }
     
   
    
}
