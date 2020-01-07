package test;

public class BronzePackage implements Package{
	

	private int pkgBonus = 5000;
	private int upperLimit = 10;
	private int lowerLimit = 5;
	private String pkgName = "Bronze Package";
	
	public int getUpperLimit() {
		return upperLimit;
	}
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
	public int getLowerLimit() {
		return lowerLimit;
	}
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public int getPkgBonus() {
		return pkgBonus;
	}
	public void setPkgBonus(int pkgBonus) {
		this.pkgBonus = pkgBonus;
	}
	public String getPkgName() {
		return pkgName;
	}
	public void setPkgName(String pkgName) {
		this.pkgName = pkgName;
	}
	@Override
	public String toString() {
		return "BronzePackage [pkgBonus=" + pkgBonus + ", upperLimit=" + upperLimit + ", lowerLimit=" + lowerLimit
				+ ", pkgName=" + pkgName + "]";
	}


}
