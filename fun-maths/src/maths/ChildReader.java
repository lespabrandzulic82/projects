package maths;

import java.util.Scanner;

public class ChildReader {
	
	public static Child readChildData(Scanner scanner) {
		
		int taskId = 0;
		double taskResult = 0.00;			
		boolean correctAnswer = false;
	
		System.out.println("Enter your name:");	
		String name = scanner.next();
		System.out.println("Enter your surname:");	
		String surname = scanner.next();
		System.out.println("Enter date in format dd/MM/yyyy");	
		String date = scanner.next();
		System.out.println("Let's begin:");
		
		// 	public Child(String name, String surname, String date, int taskId, double taskResult, boolean correctAnswer) {

		return new Child (name, surname, date, taskId, taskResult, correctAnswer);
	}

}
