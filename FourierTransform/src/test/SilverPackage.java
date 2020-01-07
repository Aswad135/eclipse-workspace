package test;

public class SilverPackage implements Package{

	private int pkgBonus = 10000;
	private int upperLimit = 15;
	private int lowerLimit = 10;
	private String pkgName = "Silver Package";
	
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
		return "SilverPackage [pkgBonus=" + pkgBonus + ", upperLimit=" + upperLimit + ", lowerLimit=" + lowerLimit
				+ ", pkgName=" + pkgName + "]";
	}
	
}
