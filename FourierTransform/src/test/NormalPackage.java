package test;

public class NormalPackage implements Package {
	private int pkgBonus = 2000;
	private String pkgName = "Normal Package";
	private int upperLimit = 5;
	private int lowerLimit = 3;
	
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
		return "NormalPackage [pkgBonus=" + pkgBonus + ", pkgName=" + pkgName + ", upperLimit=" + upperLimit
				+ ", lowerLimit=" + lowerLimit + "]";
	}
	
}
