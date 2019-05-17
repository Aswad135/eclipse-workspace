package code;

public class silverAccount  extends accounts {


	public String designation = "";
	public int sallary = 0;

	public silverAccount(String desig, int sal) {
		super();
		setDesignation(desig);
		setSallary(sal);
		super.digiVal = true;
		super.freeIntBank = true;
		super.freeSMS = true;
		super.loan = true;
		super.profit = false;
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
		if (sallary >= 0 && sallary <= 500000)
			this.sallary = sallary;
		else 
			System.out.println("invalid Sallary entered");
	}

	@Override
	public String toString() {
		return "silverAccount [designation=" + designation + ", sallary=" + sallary + ", digiVal=" + digiVal
				+ ", freeSMS=" + freeSMS + ", freeIntBank=" + freeIntBank + ", loan=" + loan + ", profit=" + profit
				+ "]";
	}
}
