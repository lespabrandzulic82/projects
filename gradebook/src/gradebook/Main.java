package gradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/*
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
		*/
		Student students[] = new Student[5];
		
		try (Scanner sc = new Scanner(System.in)){
			
			for(int i = 0; i < students.length; i++) {
				
				int position = i+1;
			
				System.out.println("Enter " + position + " student name:");
				String studentName = sc.next();
				System.out.println("Enter " + position + " student surname:");
				String studentSurname = sc.next();
				System.out.println("Enter " + position + " student grade:");
				int grade = sc.nextInt();
		
			
			Student student = new Student(studentName, studentSurname, grade);
			
			students[i] = student;
			
			// students[i] = new Student(studentName, studentSurname, grade);  da se napise odjednom
			
			}
			double totalGrade = 0;
			
			for(int i = 0; i < students.length; i++) {
				
				Student student = students[i];
				double grade = student.getGrade();
				totalGrade += grade;	
			}
			
			double averageGrade = totalGrade / students.length;
			
			for(int i = 0; i < students.length; i++) {
				
				Student student = students[i];
				System.out.println("The first student " + student.getStudentName() + " " +student.getStudentSurname()  + " has grade " + student.getGrade() + ".");
				}							
				System.out.println("_________________________________________________");
							
				System.out.println("Total grade of all five students is " + totalGrade);
				System.out.println("Average grade of all five students is " + averageGrade);
		    
		}
	}
}