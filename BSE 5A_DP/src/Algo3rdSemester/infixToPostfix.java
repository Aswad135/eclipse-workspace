package Algo3rdSemester;

import java.util.StringTokenizer;

public class infixToPostfix {
	private stack<Character> s1;
	private String postFixString;

	public static void main(String[] args) {
		infixToPostfix obj = new infixToPostfix();
		String exression = "87+7*5(5+6)";
		System.out.println("Input String = " + exression);
		String expressionInPostfix = obj.doIt(exression);
		System.out.println("Processed String = " + expressionInPostfix);
		System.out.println("Answer = " + obj.solve());
	}

	public infixToPostfix() {
		s1 = new stack<Character>();
		postFixString = "";
	}

	public String doIt(String input) {
		char curr_ch;
		char flag;
		flag = '1';
		for (int i = 0; i < input.length(); i++) {

			curr_ch = input.charAt(i);
			if (Character.isAlphabetic(curr_ch) || Character.isDigit(curr_ch)) {
				if (Character.isAlphabetic(flag) || Character.isDigit(flag)) {
					postFixString = postFixString + curr_ch;
				} else
					postFixString = postFixString + "`" + curr_ch;
				// System.out.println(postFixString);
			} else if (s1.isEmpty()) {
				s1.push(curr_ch);
			} else if (curr_ch == '(') {
				s1.push('(');
			} else if (curr_ch == ')') {
				while (s1.getTop() != '(') {
					postFixString = postFixString + "`" + s1.pop();
					// System.out.println(postFixString);
				}
				s1.pop();
				s1.push('*');
			} else if (s1.getTop() == '(') {
				s1.push(curr_ch);
			} else if (precedenceLevel(curr_ch) == precedenceLevel(s1.getTop())

					|| precedenceLevel(s1.getTop()) > precedenceLevel(curr_ch)) {
				do {
					postFixString = postFixString + "`" + s1.pop();
					// System.out.println(postFixString);
				} while (precedenceLevel(curr_ch) >= precedenceLevel(s1.getTop())
						|| precedenceLevel(s1.getTop()) > precedenceLevel(curr_ch));

			} else {
				s1.push(curr_ch);
			}
			flag = curr_ch;
		}
		while (!s1.isEmpty())
			postFixString = postFixString + "`" + s1.pop();
		// System.out.println(postFixString);

		return postFixString;
	}

	int precedenceLevel(char op) {
		switch (op) {
		case '+':
			return 0;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 3;
		case '^':
			return 4;
		default:
			throw new IllegalArgumentException("Operator unknown: " + op);
		}
	}

	public double solve(String postString) {
		char curr_ch;
		stack<Double> stack = new stack<Double>();
		StringTokenizer stk = new StringTokenizer(postString, "`");
		int count = stk.countTokens();
		// System.out.println(count);
		for (int i = 0; i < count; i++) {
			String token = stk.nextToken();
			curr_ch = token.charAt(0);
			if (Character.isAlphabetic(curr_ch)) {
				System.out.print("Variables not allowed");
				return 0.0000;
			} else if (Character.isDigit(curr_ch)) {
				stack.push(Double.parseDouble(token));
			} else {
				Double op1, op2;
				op2 = stack.pop();
				op1 = stack.pop();
				switch (curr_ch) {
				case '+':
					stack.push(op1 + op2);
					continue;
				case '-':
					stack.push(op1 - op2);
					continue;
				case '*':
					stack.push(op1 * op2);
					continue;
				case '/':
					stack.push(op1 / op2);
					continue;
				case '^':
					stack.push(Math.pow(op1, op2));
					continue;
				default:
					throw new IllegalArgumentException("Operator unknown: " + curr_ch);
				}
			}
			// System.out.println(token);
			// System.out.println(stack.getTop());
		}

		return stack.getTop();
	}

	public double solve() {
		if (postFixString != "") {
			return solve(postFixString);
		} else
			System.out.println("please Enter your String");
		return 0;
	}

	/*
	 * boolean prec(char ch1, char ch2) { boolean check = true; if(ch1 == ch2) {
	 * check = false; }else if(ch1 == '^') { check = true; }else if(ch1 == '+' &&
	 * ch2 == '-' || ch1 == '-' && ch2 == '+') check = false; else if(ch1 == '(') {
	 * 
	 * }else if(ch2 == '(') check = true;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * return check; }
	 */
}
