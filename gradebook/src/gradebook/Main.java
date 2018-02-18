package gradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String studentName1;
		String studentName2;
		String studentName3;
		String studentName4;
		String studentName5;
		
		String studentSurname1;
		String studentSurname2;
		String studentSurname3;
		String studentSurname4;
		String studentSurname5;
		
		int grade1 = 0;
		int grade2 = 0;
		int grade3 = 0;
		int grade4 = 0;
		int grade5 = 0;
		
		try (Scanner sc = new Scanner(System.in)){
			
			System.out.println("Enter first student name:");
			studentName1 = sc.next();
			System.out.println("Enter first student surname:");
			studentSurname1 = sc.next();
			System.out.println("Enter first student grade:");
			grade1 = sc.nextInt();
			
			System.out.println("Enter second student name:");
			studentName2 = sc.next();
			System.out.println("Enter second student surname:");
			studentSurname2 = sc.next();
			System.out.println("Enter second student grade:");
			grade2 = sc.nextInt();
			
			System.out.println("Enter third student name:");
			studentName3 = sc.next();
			System.out.println("Enter third student surname:");
			studentSurname3 = sc.next();
			System.out.println("Enter third student grade:");
			grade3 = sc.nextInt();
			
			System.out.println("Enter fourth student name:");
			studentName4 = sc.next();
			System.out.println("Enter fourth student surname:");
			studentSurname4 = sc.next();
			System.out.println("Enter fourth student grade:");
			grade4 = sc.nextInt();
			
			System.out.println("Enter fifth student name:");
			studentName5 = sc.next();
			System.out.println("Enter fifth student surname:");
			studentSurname5 = sc.next();
			System.out.println("Enter fifth student grade:");
			grade5 = sc.nextInt();
			
			System.out.println("The first student " + studentName1 + " " + studentSurname1 + " has grade " + grade1 + ".");
			System.out.println("The second student " + studentName2 + " " + studentSurname2 + " has grade " + grade2 + ".");
			System.out.println("The third student " + studentName3 + " " + studentSurname3 + " has grade " + grade3 + ".");
			System.out.println("The fourth student " + studentName4 + " " + studentSurname4 +  " has grade " + grade4 + ".");
			System.out.println("The fifth student " + studentName5 + " " + studentSurname5 + " has grade " + grade5 + ".");
			
			double totalGrade = grade1 + grade2 + grade3 + grade4 + grade5;
							
			System.out.println("_________________________________________________");
						
			System.out.println("Total grade of all five students is " + totalGrade);
		
		}

	}
	
}