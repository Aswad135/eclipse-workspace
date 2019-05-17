package prototypeDesignPattern;

public class mainClass {

	public static void main(String[] args) throws CloneNotSupportedException {
		
		toyShop ts = new toyShop();
		ts.setShopName("Shop 1 (Original Shop)");
		ts.loadData();
		System.out.println(ts);
		
		System.out.println("\n\tShallow Copy Using Built-in Clone Interface\n");
		
		toyShop ts1 = (toyShop) ts.clone();
		ts.getToys().remove(2);
		ts1.setShopName("Shop 2 (Shallow Copy Shop)");
		System.out.println(ts);
		System.out.println(ts1);
		
		System.out.println("\n\tDeep Copy Using Prototype Pattern\n");
		
		toyShop ts2 = (toyShop) ts.clone1();
		ts.getToys().remove(2);
		ts2.setShopName("Shop 3 (Deep Copy Shop) ");
		System.out.println(ts);
		System.out.println(ts2);
		
	}
	
}
