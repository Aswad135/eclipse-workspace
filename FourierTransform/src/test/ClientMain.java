package test;

public class ClientMain {

	public static void main(String[] args) {
		
		NewCustomer cust = new NewCustomer();
		Customer temp = cust.createNewCustomer("ABC", 12, 1);
		System.out.println(temp.toString());
		
	}
	
}
