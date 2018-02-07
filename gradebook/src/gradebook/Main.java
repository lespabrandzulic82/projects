package gradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		
		try( Scanner sc= new Scanner(System.in)){
			
			System.out.println("Enter a name of first studendt: ");
			String firstStudentName = sc.next();
			System.out.println("Enter a surname of first studendt: ");
			String firstStudentserName = sc.next();
			System.out.println("Enter a grade of first studendt: ");
			int firstStudentGrade= sc.nextInt();
			
			System.out.println("Enter a name of second studendt: ");
			String secondStudentName = sc.next();
			System.out.println("Enter a surname of second studendt: ");
			String secondStudentserName = sc.next();
			System.out.println("Enter a grade of second studendt: ");
			int secondStudentGrade= sc.nextInt();
			
			System.out.println("Enter a name of third studendt: ");
			String thirdStudentName = sc.next();
			System.out.println("Enter a surname of third studendt: ");
			String thirdStudentserName = sc.next();
			System.out.println("Enter a grade of third studendt: ");
			int thirdStudentGrade= sc.nextInt();
			
			System.out.println("Enter a name of fourth studendt: ");
			String fourthStudentName = sc.next();
			System.out.println("Enter a surname of fourth studendt: ");
			String fourthStudentserName = sc.next();
			System.out.println("Enter a grade of fourth studendt: ");
			int fourthStudentGrade= sc.nextInt();
			
			System.out.println("Enter a name of fifth studendt: ");
			String fifthStudentName = sc.next();
			System.out.println("Enter a surname of fifth studendt: ");
			String fifthStudentserName = sc.next();
			System.out.println("Enter a grade of fifth studendt: ");
			int fifthStudentGrade= sc.nextInt();
			
			double totalGrade= firstStudentGrade+secondStudentGrade +thirdStudentGrade +fourthStudentGrade+fifthStudentGrade;
			double averageGrade= totalGrade/ 5;
			
			System.out.println("Total grade of all fifth student is"+ totalGrade);
			System.out.println();
			System.out.println("Average grade is:"+ averageGrade);
			
			
			
			
			
			
			
		   
		
		

	  }
	}
}