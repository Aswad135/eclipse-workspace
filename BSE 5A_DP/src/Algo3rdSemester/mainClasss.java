package Algo3rdSemester;

import java.util.Scanner;

public class mainClasss {

	
	public static void main(String[] args) {
		String expression = "";
		infixToPostfix obj = new infixToPostfix();		
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to input your own expression?\t(1/0)");
		int a = input.nextInt();
		if (a == 0) {
			expression = "87+7*5(5+6)";	
		}else {
			input.nextLine();
			System.out.println("Please write Expression: ");
			expression = input.nextLine();
		}
		System.out.println("Input String = " + expression);
		String expressionInPostfix = obj.doIt(expression);
		System.out.println("Processed String = " + expressionInPostfix);
		System.out.println("Answer = " + obj.solve());
		
		input.close();
	}

}
