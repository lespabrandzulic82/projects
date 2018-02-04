package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.println("Enter your first number");
			int firstNumber = sc.nextInt();
			
			System.out.println("Choose your operation +, -, * ,/ ");
			String operation = sc.next();
			
			System.out.println("Enter your second number");
			int secondNumber = sc.nextInt();

			System.out.println("Now the system is calculating the result ...");
			int result = 0;
			
			if(operation.equals("+")) {
				result = firstNumber + secondNumber;
			} else if(operation.equals("-")) {
				result = firstNumber - secondNumber;
			} else if(operation.equals("*")) {
				result = firstNumber * secondNumber;		
			} else if(operation.equals("/")) {
				result = firstNumber / secondNumber;			
			}
			
			System.out.println("First number is: " + firstNumber);
			System.out.println("Second number is: " + secondNumber);
			System.out.println("The result is: " + result);
		}
		
	}

}
