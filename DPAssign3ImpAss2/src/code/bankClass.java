package code;

import java.util.Scanner;

public class bankClass {

	public static void main(String[] args) throws Exception {
		int temp = 0;
		Scanner input = new Scanner(System.in);
		System.out.println("Sample DATA loading using Polymorphism OR Abstract Factory");
		accounts thisBank = new accounts();
		accounts[] ary = new accounts[10];
		for (int i = 0; i<10;i++) {
			ary[i] = thisBank.createAccount("abc",(400000 *( (i % 2) + 1)));
			System.out.println(ary[i].getAccountNo() + "   " + ary[i].getProfit());
		}

		System.out.println("\n\nHello Sir!\nI hope you are fine today.\nHow may I help you?");
		int temp1 = 0;
		while(true) {
			try {

				System.out.println("1. New account\n2. View account\n3. Exit");
				temp = input.nextInt();
				switch(temp) {
				case 1:
					System.out.println("New Account Creation");
					if(temp1 > 9) {
						System.out.println("Max Account limit reached, New account cannot be created");
						break;
					}
					String tempDesig = "";
					int tempSal = 0;
					input.nextLine();
					System.out.println("Please State your Designation:");
					tempDesig = input.nextLine();
					System.out.println("Please enter your Sallary:");
					tempSal = input.nextInt();
					System.out.println("You Entered \""+tempDesig + "\" and "+tempSal);

					temp1++;
					ary[temp1] = ary[temp1] = thisBank.createAccount(tempDesig,tempSal);
					System.out.println("Account Successfully created\nYour account Number is "+ ary[temp1].getAccountNo());
					System.out.println(ary[temp1].toString());

					break;
				case 2:
					System.out.println("View existing account");
					System.out.println("Please enter account Number");
					int temp2 = input.nextInt();
					for (int i = 0; i<10;i++) {

						if(ary[i].getAccountNo() == temp2) {

							System.out.println(ary[i].toString());
						}
					}

					break;
				case 3:
					System.out.println("Thank you for visiting.\nExiting the Program.");
					input.close();
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Input. Please try again.");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				input.nextLine();
				Thread.sleep(2);
			}
		}

	}

}
