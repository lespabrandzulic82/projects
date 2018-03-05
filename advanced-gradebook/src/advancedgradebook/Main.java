package advancedgradebook;


import java.util.Scanner;
import java.util.logging.*;

public class Main {
	
	private static final Logger logger = Logger.getLogger( Main.class.getName());
	
	public static void main(String[] args) {
		
		logger.info("Logging an INFO-level message");
		 
		int totalGrade = 0;
		double averageGrade = 0;
		
		try (Scanner sc = new Scanner(System.in)) {
			 
			while(true) {
				
			int numStudents = 0;
			 
			 while(numStudents < 1) {
				 
				 try {
				
					 System.out.println("Enter the number of students in your class: ");
					 numStudents = sc.nextInt();
				
					 if (numStudents <= 0) {
						 throw new Exception();		
					 }
				 }
				 
				 catch (Exception e) {
					logger.log( Level.SEVERE, "You have an exception", e );
					System.out.println("The number of students must be 1 or greater.");						
					
				 }
				 
			 }	 
		
			String[] names = new String[numStudents];
			String[] surnames = new String[numStudents];
			int[] grades = new int[numStudents];			
			
			for(int i = 0; i < numStudents; i++) {
				
				boolean successName = false;	
				
				while (!successName) {
				 
				try {
					System.out.println("Enter student's name");
					names[i] = sc.next();						
					
					if (names[i].matches("[a-zA-Z]+")) {
						successName = true;
						
					}else {
						throw new Exception();
					}
					
				}
				
				catch (Exception e) {
						logger.log( Level.SEVERE, "You have an exception", e );
						System.out.println("Student's name can contains only letters.");						
						
				 }
					}
				
				boolean successSurname = false;
				
				while(!successSurname) {
					try {				
						System.out.println("Enter student's surname");
						surnames[i] = sc.next();
						
						if(surnames[i].matches("[a-zA-Z]+")) {
							successSurname = true;
							
						}else {
							throw new Exception();
						}
						
					}
					catch (Exception e) {
						logger.log( Level.SEVERE, "You have an exception", e );
						System.out.println("Student's surname can contains only letters.");						
						
					}
				}
				
				boolean successGrade = false;
				
				while(!successGrade) {
					try{
						System.out.println("Enter student's grade");
						grades[i] = sc.nextInt();
						
						if( grades[i] > 4 & grades[i] < 11) {
							successGrade = true;
							
						}else {
							throw new Exception();
						}
						
					}
					catch(Exception e) {
						logger.log( Level.SEVERE, "You have an exception", e );
						System.out.println("Student's grade must be between 5 and 10.");						
						
					}
				}
					
			}
			
			for(int i = 0; i < numStudents; i++) {
				int x = i + 1;
				System.out.println(x + ". Student " + names[i] + " " + surnames[i] + " has grade " + grades[i] + "." );
				totalGrade += grades[i];
			}
			
			averageGrade = (double) totalGrade / numStudents;
			
			int max = grades[0];
			for(int i = 0; i < numStudents; i++) {
				if(grades[i] > max) {
					max = grades[i];
				}
			}
			
			int min = grades[0];
			for(int i = 0; i < numStudents; i++) {
				if(grades[i] < min ) {
					min = grades[i];
				}
			}
			
			System.out.println("===========================================");
			System.out.println("Total number of  students for grading is " + numStudents + ".");
			System.out.println("Total grade of all students is " + totalGrade + ".");
			System.out.println("Average grade of all students is " + averageGrade + ".");
			System.out.println("Minimum grade of all students is " + min + ".");
			System.out.println("Maximum grade of all students is " + max + ".");
			
			char quitProgram = 'N';
			
			System.out.println("If you want to finish the program press Y, if not press N");
			quitProgram = sc.next().charAt(0);
			
			if (quitProgram ==  'Y' || quitProgram == 'y') {
					System.exit(0);
			}
			}
		}
	}
}	
