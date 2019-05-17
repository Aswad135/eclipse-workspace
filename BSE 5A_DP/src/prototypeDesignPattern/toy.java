package prototypeDesignPattern;

public class toy {

	private String toyName;
	private int toyID;
	
	
	public String getToyName() {
		return toyName;
	}
	public void setToyName(String toyName) {
		this.toyName = toyName;
	}
	public int getToyID() {
		return toyID;
	}
	public void setToyID(int toyID) {
		this.toyID = toyID;
	}
	
	@Override
	public String toString() {
		return "toy [toyID=" + toyID + ", toyName=" + toyName + "]";
	}
	
	
	
	
	
}
