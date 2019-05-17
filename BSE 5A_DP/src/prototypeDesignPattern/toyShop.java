package prototypeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class toyShop implements Cloneable {

	private String shopName;
	private List<toy> toys = new ArrayList<toy>();
	
	
	public void loadData() {
		
		for(int i = 1; i<=5 ; i++) {
			toy t = new toy();
			t.setToyID(i);
			t.setToyName("toy "+i);
			this.getToys().add(t);
		}
	}
	
	
	@Override
	public String toString() {
		return "toyShop [shopName=" + shopName + ", toys=" + toys + "]";
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public List<toy> getToys() {
		return toys;
	}
	public void setToys(List<toy> toys) {
		this.toys = toys;
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	protected toyShop clone1() {
		toyShop newShop = new toyShop(); 
		for(toy t : this.getToys())
		{
			newShop.getToys().add(t);
		}
		return newShop;
	}
	
	
	
}
