package gradebook;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Student students[] = new Student[5];
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		//int numberOfStudents = studentList.size();	
		
		double totalGrade = 0;
		double averageGrade = 0;
		try (Scanner sc = new Scanner(System.in)){
			
			while(true) {
			
				System.out.println("Enter student name:");
				String studentName = sc.next();
				System.out.println("Enter student surname:");
				String studentSurname = sc.next();
				System.out.println("Enter student grade:");
				int grade = sc.nextInt();
					
				Student student = new Student(studentName, studentSurname, grade);			
				//students[i] = student;
				studentList.add(student);
				
				char quitProgram = 'N';
				
				System.out.println("If you want to finish the entered students Y, if not press N");
				quitProgram = sc.next().charAt(0);
			
				if (quitProgram ==  'Y' || quitProgram == 'y') {
					break;
				}
			
			}
			
			int numberOfStudents = studentList.size();
			/*for(int i = 0; i < numberOfStudents; i++) {
				
				Student student = studentList.get(i);
				double grade = student.getGrade();
				totalGrade += sgrade;	
			}
			*/
			// double averageGrade = totalGrade / numberOfStudents;
			
			for(int i = 0; i < numberOfStudents; i++) {
				 
				Student student = studentList.get(i);
				
				totalGrade += student.getGrade();
				averageGrade = totalGrade / numberOfStudents;
				
				int position = i + 1;
				System.out.println("The " + position + ". student " + student.getStudentName() + " " +student.getStudentSurname()  + " has grade " + student.getGrade() + ".");
				}							
				System.out.println("_________________________________________________");
							
				System.out.println("Total grade of all five students is " + totalGrade);
				System.out.println("Average grade of all five students is " + averageGrade);
		    
		}
	}
}