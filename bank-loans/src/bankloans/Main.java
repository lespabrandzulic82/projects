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
			while(true) {
					
				
				int i = 0;
				String[] names = new String[i];
				String[] surnames = new String[i];
				double[] salaries = new double[i];
				int[] ages = new int[i];
				boolean[] isMarrieds = new boolean[i];
				boolean[] isFullTimeEmployees = new boolean[i];
				int[] credits = new int[i];

				
			System.out.println("Please enter your name:");
			 names[i] = sc.next();	
			
			System.out.println("Please enter your surname:");
			 surnames[i] = sc.next();
			System.out.println("Please enter your salary in EU:");
			 salaries[i] = sc.nextInt();
			System.out.println("How old you are:");
			ages[i] = sc.nextInt();
			System.out.println("Are you married? (if Yes enter true, if No enter false) ");
			isMarrieds[i] = sc.nextBoolean();
			System.out.println("Are you full time employee? (if Yes enter true, if No enter false)");
			 isFullTimeEmployees[i] = sc.nextBoolean();
			
			System.out.println("What credit do you want to apply for?");
			System.out.println("If you want house loan enter number 1.");
			System.out.println("If you want cash loan enter number 2");
			System.out.println("If you want consumer loan enter number 3");
			 credits[i] = sc.nextInt();
			 
					
				 
			char quitProgram = 'N';
			
			System.out.println("If you want to finish the program press Y, if not press N");
			quitProgram = sc.next().charAt(0);
			
			if (quitProgram ==  'Y' || quitProgram == 'y') {
				System.exit(0);
			}	
			
		
			Client clients[] = new Client[i];
		
		
			
			
			
		}
	}
 }
}



