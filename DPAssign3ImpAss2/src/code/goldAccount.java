package code;

public class goldAccount extends accounts {

	private String designation = "";
	private int sallary = 0;

	public goldAccount(String desig, int sal) {
		super();
		setDesignation(desig);
		setSallary(sal);
		super.digiVal = true;
		super.freeIntBank = true;
		super.freeSMS = true;
		super.loan = true;
		super.profit = true;
	}
	
	public int getAccountNo(){
		return super.getAccountNo();
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSallary() {
		return sallary;
	}
	public void setSallary(int sallary) {
		if (sallary >= 0)
			this.sallary = sallary;
		else 
			System.out.println("invalid Sallary entered");
	}

	@Override
	public String toString() {
		return "goldAccount [designation=" + designation + ", sallary=" + sallary + ", digiVal=" + digiVal
				+ ", freeSMS=" + freeSMS + ", freeIntBank=" + freeIntBank + ", loan=" + loan + ", profit=" + profit
				+ "]";
	}
	
	
}
