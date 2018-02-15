package advancedgradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String [][] students = null;
		int [] grades = null;
		int numbStudents;
		double totalGrade = 0;
		double averageGrade = 0;
		
		try (Scanner sc = new Scanner(System.in)) {

			System.out.println("Enter number of students in your class");
			numbStudents = sc.nextInt();
			
			students = new String[numbStudents][2];
			grades = new int[numbStudents];
			for(int i = 0; i < numbStudents; i++) {
				System.out.println("Enter student name");
				students[i][0] = sc.next();
				System.out.println("Enter student surname");
				students[i][1] = sc.next();
				System.out.println("Enter student grade");
				grades[i] = sc.nextInt();
				
			}
			
			for(int t = 0; t < numbStudents; t++) {
				System.out.println("Student " + students[t][0] + " " + students[t][1] + " has grade " + grades[t] + "." );
				totalGrade += grades[t];
				
				
			}
				averageGrade = totalGrade/numbStudents; 
				System.out.println("Total grade of all students is " + totalGrade + " and average is " + averageGrade + ".");
			
			 
			
		}
		
	}

}