package code;

public class accounts {

	private int accountNo;
	boolean digiVal;
	boolean freeSMS;
	boolean freeIntBank;
	boolean loan;
	boolean profit;

	public accounts(){	
		accountNo = 0;
		digiVal = false;
		freeSMS = false;
		freeIntBank = false;
		loan = false;
		profit = false;

	}
	
	public accounts createAccount(String Designation, int Sallary) {
		accounts temp;
		if (Designation.equals("CEO") || Sallary >= 500000) {
			temp = new goldAccount(Designation, Sallary);
			
		} else {
			temp = new silverAccount(Designation, Sallary);
			
		}
		temp.accountNo = accountNo;
		accountNo++;
		return temp;
	}

	
	
	public int getAccountNo() {
		return accountNo;
	}

	public boolean getDigiVallet() {
		return this.digiVal;
	}
	public boolean getFreeSMS() {
		return this.freeSMS;
	}
	public boolean getFreeInternetBanking() {
		return this.freeIntBank;
	}
	public boolean getLoan() {
		return this.loan;
	}
	public boolean getProfit() {
		return this.profit;
	}




}
