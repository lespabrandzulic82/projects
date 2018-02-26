package advancedgradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int numStudents = 0;
		int totalGrade = 0;
		double averageGrade = 0;
		
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter number of students in your class:");
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
				int x = i + 1;
				System.out.println(x + ". Student " + names[i] + " " + surnames[i] + " has grade " + grades[i] + "." );
				totalGrade += grades[i];
			}
			
			averageGrade = (double)totalGrade / numStudents;
			
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
			}
       }
  }