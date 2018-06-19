package gradebook;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
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