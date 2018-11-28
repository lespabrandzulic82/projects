package gradebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Scanner;

public class Main {

	//CRUD app
	//Menu
	//Add student
	//Edit student
	//Delete student
	//Find student( by index or name)
	//View all students
	//View summery(statictics)
	//Save and Exit (in file or database)
	//Quit without saving
	
	public static void main(String[] args) {
		
		//Student students[] = new Student[5];
		System.out.println("Welcome to the student gradebook");
		ArrayList<Student> studentList = new ArrayList<Student>();
		//int numberOfStudents = studentList.size();	
		
		
		try (Scanner sc = new Scanner(System.in)){
			
			while(true) {
				boolean continueExecute = executeMenuOption(sc,studentList);
				
				if(!continueExecute) {
					break;
				}
			}		    
		}
	}
	
	public static void addStudent(Scanner sc, ArrayList<Student> studentList) {
		
		while(true) {
			
			System.out.println("Enter student number:");
			String studentNumber = sc.next();
			System.out.println("Enter student first name:");
			String studentName = sc.next();
			System.out.println("Enter student surname:");
			String studentSurname = sc.next();
			System.out.println("Enter student grade:");
			int grade = sc.nextInt();
				
			Student student = new Student(studentNumber, studentName, studentSurname, grade);			
			//students[i] = student;
			studentList.add(student);
			
			char quitProgram = 'N';
			
			System.out.println("If you want to finish the entered students Y, if not press N");
			quitProgram = sc.next().charAt(0);
		
			if (quitProgram ==  'Y' || quitProgram == 'y') {
				break;
			}
		
		}
		
		System.out.println("=======================");
		System.out.println("What do you want now?");
		System.out.println("=======================");
		
		while(true) {
			boolean continueExecute = executeMenuOption(sc,studentList);
			
			if(!continueExecute) {
				break;
			}
		}

		 
	 }
	
	public static void editStudent(Scanner sc, ArrayList<Student> studentList) {
		
		System.out.println("Entered number of student you want to edit");
		String studentNumber = sc.next();
		
		Optional<Student> optional = studentList.stream()
				.filter(x -> x.getStudentNumber().equals(studentNumber)).findFirst();

		if(optional.isPresent()) {
			
			Student student = optional.get();	
			
			
			System.out.println("Enter student name:");
			String studentName = sc.next();
			System.out.println("Enter student surname:");
			String studentSurname = sc.next();
			System.out.println("Enter student grade:");
			int grade = sc.nextInt();
			
			student.setStudentName(studentName);
			student.setStudentSurname(studentSurname);
			student.setGrade(grade);
							
		}
		
		System.out.println("=======================");
		System.out.println("What do you want now?");
		System.out.println("=======================");
		
		while(true) {
			boolean continueExecute = executeMenuOption(sc,studentList);
			
			if(!continueExecute) {
				break;
			}
		}


		 
	 }
	
	public static void deleteStudent() {
		 
	 }
	
	public static void findStudent() {
		 
	 }
	
	public static void viewAllStudent(ArrayList<Student> studentList, Scanner sc) {
		
	
		int numberOfStudents = studentList.size();
		
		
		for(int i = 0; i < numberOfStudents; i++) {
			 
			Student student = studentList.get(i);
						
			int position = i + 1;
			System.out.println("The " + position + ". student " + student.getStudentName() + " " +student.getStudentSurname()  + " who's student number is " + student.getStudentNumber() + " has grade " + student.getGrade() + ".");
			}
		
		while(true) {
			boolean continueExecute = executeMenuOption(sc,studentList);
			
			if(!continueExecute) {
				break;
			}
		}
		 
	 }
	
	public static void viewSummery(Scanner sc, ArrayList<Student> studentList) {
		
		double totalGrade = 0;
		double averageGrade = 0;
		int numberOfStudents = studentList.size();
		
		
		for(int i = 0; i < numberOfStudents; i++) {
			 
			Student student = studentList.get(i);
			
			totalGrade += student.getGrade();
			averageGrade = totalGrade / numberOfStudents;
			
		}
		
			System.out.println("_________________________________________________");
						
			System.out.println("Total grade of all students is " + totalGrade);
			System.out.println("Average grade of all students is " + averageGrade);
			
			System.out.println("=======================");
			System.out.println("What do you want now?");
			System.out.println("=======================");
			
			while(true) {
				boolean continueExecute = executeMenuOption(sc,studentList);
				
				if(!continueExecute) {
					break;
				}
			}
		 
	 }
	
	public static void saveAndExit() {
		 
	 }
	
	public static void quitWithoutSaving() {
		 
	 }
	
	public static boolean executeMenuOption(Scanner sc, ArrayList<Student> studentList) {
		
		boolean continueExecuton = true;
		System.out.println("");
		System.out.println("=======================");
		System.out.println("Pleae select a menu option:");
		System.out.println("=======================");
		System.out.println("");
		System.out.println("1. Add a student");
		System.out.println("2. Edit a student");
		System.out.println("3. Delete a student");
		System.out.println("4. Find a student");
		System.out.println("5. View all students");
		System.out.println("6. View a summery - statistic");
		System.out.println("7. Save and Exit");
		System.out.println("8. Quit without saving");

		int menuOption = sc.nextInt();

		switch (menuOption) {
		
        case 1:  addStudent(sc, studentList); 
                 break;
        case 2:  editStudent(sc, studentList);
                 break;
        case 3:  deleteStudent();
                 break;
        case 4:  findStudent();
                 break;
        case 5:  viewAllStudent(studentList, sc);
        		 break;
        case 6:  viewSummery(sc,studentList);
                 break;
        case 7:  saveAndExit();
        		 continueExecuton = false;
                 break;
        case 8:  quitWithoutSaving();
                 continueExecuton = false;
                 break;
                 default: System.out.println("Invalid option");

		}
		
		return continueExecuton;
		
		
	}
	
	
}