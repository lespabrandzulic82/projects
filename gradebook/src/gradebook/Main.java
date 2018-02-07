package gradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String studentName1;
		String studentName2;
		String studentName3;
		String studentName4;
		String studentName5;
		
		String studentSuranme1;
		String studentSuranme2;
		String studentSuranme3;
		String studentSuranme4;
		String studentSuranme5;
		
		int grade1=0;
		int grade2=0;
		int grade3=0;
		int grade4=0;
		int grade5=0;
		
		try (Scanner sc= new Scanner(System.in)){
			
			System.out.println("Enter first student name:");
			 studentName1 = sc.next();
			System.out.println("Enter first  surname:");
			studentSuranme1=sc.next();
			 System.out.println("Enter first student grade:");
			grade1=sc.nextInt();
			
			System.out.println("Enter second student name:");
			 studentName2 = sc.next();
			System.out.println("Enter second  surname:");
			studentSuranme2=sc.next();
			 System.out.println("Enter second student grade:");
			grade2=sc.nextInt();
			
			System.out.println("Enter third student name:");
			 studentName3 = sc.next();
			System.out.println("Enter third  surname:");
			studentSuranme3=sc.next();
			 System.out.println("Enter third student grade:");
			grade3=sc.nextInt();
			
			System.out.println("Enter fourth student name:");
			 studentName4 = sc.next();
			System.out.println("Enter fourth  surname:");
			studentSuranme4=sc.next();
			 System.out.println("Enter fourth student grade:");
			grade4=sc.nextInt();
			
			System.out.println("Enter five student name:");
			 studentName5 = sc.next();
			System.out.println("Enter five  surname:");
			studentSuranme5=sc.next();
			 System.out.println("Enter five student grade:");
			grade5=sc.nextInt();
			
			
			
			
			System.out.println("The first student " + studentName1 +" "+ studentSuranme1 + " has grade " + grade1 +".");
			System.out.println("The second student " + studentName2 +" "+ studentSuranme2 + " has grade " + grade2 +".");
			System.out.println("The third student " + studentName3 +" "+ studentSuranme3 + " has grade " + grade3 +".");
			System.out.println("The fourth student " + studentName4 +" "+studentSuranme4 +  " has grade " + grade4 +".");
			System.out.println("The fifth student " + studentName5 +" "+ studentSuranme5 + " has grade " + grade5 +".");
			
			double totalGrade = grade1 + grade2 + grade3 + grade4 + grade5;
			
			
			
			System.out.println("_________________________________________________");
			
			
			System.out.println("Total grade of all fifth students is " + totalGrade);
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
	  
	}
}