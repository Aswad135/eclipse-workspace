package test;

public class Customer {
	private String custName;	  
	private int custaReferels;
	private int custID;
	Package custPkg;
	
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getCustaReferels() {
		return custaReferels;
	}
	public void setCustaReferels(int custaReferels) {
		this.custaReferels = custaReferels;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public Package getCustPkg() {
		return custPkg;
	}
	public void setCustPkg(Package custPkg) {
		this.custPkg = custPkg;
	}
	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custaReferels=" + custaReferels + ", custID=" + custID
				+ ", custPkg=" + custPkg + "]";
	}
	
}
