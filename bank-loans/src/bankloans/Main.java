package bankloans;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to our Bank loan application");
		System.out.println("Follow the instructions and complete our application:");
		System.out.println("Select the kind of credit you want to get information about");
				
		clientDemo();
	}
	
	private static void clientDemo() {
		
		try(Scanner sc = new Scanner(System.in)){
			
			System.out.println("Please enter your name:");
			String name = sc.next();
			System.out.println("Please enter your surname:");
			String surname = sc.next();
			System.out.println("Please enter your salary in EU:");
			double salary = sc.nextInt();
			System.out.println("How old you are:");
			int age = sc.nextInt();
			System.out.println("Are you married? (if Yes enter true, if No enter false) ");
			boolean isMarried = sc.nextBoolean();
			System.out.println("Are you full time employee? (if Yes enter true, if No enter false)");
			boolean isFullTimeEmployee = sc.nextBoolean();
			
			System.out.println("What credit do you want to apply for?");
			System.out.println("If you want house loan enter number 1.");
			System.out.println("If you want cash loan enter number 2");
			System.out.println("If you want consumer loan enter number 3");
			int credit = sc.nextInt();
			
			
			Client client = new Client(name, surname, salary, age, isMarried, isFullTimeEmployee, credit);
			
			if (credit == 1 && client.getAge() < 40 && client.getSalary() > 700 && isMarried == true && isFullTimeEmployee == true) {
				  System.out.println("Thank you for applying for credit.");
				  System.out.println("Your personal data are: name and surname -" + client.getName() + " " + client.getSurname() +  ", your salary is - " + client.getSalary() + " eu, you are -" + client.getAge() + " year old.");
				  System.out.println("Your credit  will be approved!");
			  } else if (credit == 2 && client.getAge() > 30 && client.getSalary() > 350) {
				  System.out.println("Thank you for applying for credit.");
				  System.out.println("Your personal data are: name and surname - " + client.getName() + " " + client.getSurname() +  ", your salary is - " + client.getSalary() + " eu, you are -" + client.getAge() + " year old.");
				  System.out.println("Your credit  will be approved!");
			  } else if (credit == 3  && client.getAge() > 20 && client.getSalary() > 250) {
				  System.out.println("Thank you for applying for credit.");	
				  System.out.println("Your personal data are: name and surname -" + client.getName() + " " + client.getSurname() +  ", your salary is - " + client.getSalary() + " eu, you are -" + client.getAge() + " year old.");
				  System.out.println("Your credit  will be approved!");
			  } else {
				  System.out.println("Thank you for applying for credit.");
				  System.out.println("Your personal data are: name and surname -" + client.getName() + " " + client.getSurname() +  ", your salary is - " + client.getSalary() + " eu, you are -" + client.getAge() + " year old.");
				  System.out.println("Unfortunately, your credit will not be aproved");
		      }
			
			
		 }
	 }
}
