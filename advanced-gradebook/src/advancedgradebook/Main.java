package advancedgradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int numStudents = 0;
		double totalGrade = 0;
		double averageGrade = 0;
		
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter number of students in your class");
			numStudents = sc.nextInt();
			String[] names = new String[numStudents];
			String[] surnames = new String[numStudents];
			int[] grades = new int[numStudents];
			
			for(int i = 0; i < numStudents; i++) {
				System.out.println("Enter student's name");
				names[i] = sc.next();
				System.out.println("Enter student's surname");
				surnames[i] = sc.next();
				System.out.println("Enter student's grade");
				grades[i] = sc.nextInt();	
			}
			
			for(int i = 0; i < numStudents; i++) {
				System.out.println("Student " + names[i] + " " + surnames[i] + " has grade " + grades[i] + "." );
				totalGrade += grades[i];
			}
			
				averageGrade = totalGrade / numStudents; 
				System.out.println("Total grade of all students is " + totalGrade + " and average is " + averageGrade + ".");
			}
       }
  }