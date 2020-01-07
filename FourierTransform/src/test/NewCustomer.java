package test;

public class NewCustomer {

	public Customer createNewCustomer(String Name, int refer, int ID){
		Customer temp = new Customer();
		temp.setCustName(Name);
		temp.setCustaReferels(refer);
		temp.setCustID(ID);
		Package pkg = null;
		if(refer > 20) {
			pkg = new GoldPackage();
		}else if(refer > 10 && refer <15 ) {
			pkg = new SilverPackage();
		}else if(refer > 5 && refer < 10 ) {
			pkg = new BronzePackage();
		}else if(refer > 3 && refer < 5 ) {
			pkg = new NormalPackage();
		}
		temp.custPkg = pkg;
		return temp;
	}
	
}
