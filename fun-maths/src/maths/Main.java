package maths;

import java.sql.*;
import java.util.Scanner;

import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;

public class Main {
	

	public static void main(String[] args) throws SQLException{
		
		System.out.println("Let's play and learn maths!");
		System.out.println("You'll have 3 levels - easy, medium and hard! When you pass one you'll go to the next one. Good luck!");
		System.out.println("=================================================================================================");
		
		System.out.println("If you want to play with tasks, enter T");
		System.out.println("If you want to see statistics and scores, enter S");
		
		System.out.println("Please, enter the path for your choise:");
		
		try(Scanner scanner = new Scanner(System.in)) {
		
			String choise = scanner.next();
			  
			Child child = null;
			Task task = null;
			if(choise.equalsIgnoreCase("T")) {
				runTask(child, task); 
			} else if(choise.equalsIgnoreCase("S")) {
				StatisticsReport.runStatistics(child, task);
			} else while (!choise.equalsIgnoreCase("T") && !choise.equalsIgnoreCase("S")) {
				System.out.println("The path you entered is inccorect.");
				System.out.println("Please, try again");
				System.out.println();
				choise = scanner.next();
			}
		}
		catch(CommunicationsException e) {
			System.out.println("Failed to communicate with the database server. Please contact the system administrator.");
		}
		catch(Exception e) {
			System.out.println("An unexpected error has occurred.");
			e.printStackTrace();
		}
	}
	
	public static void runTask(Child child, Task task) throws SQLException, ClassNotFoundException {
				
		Connection connection = DatabaseSchema.getConnection();
		
		DatabaseSchema.prepareDatabase(connection);
		
		
		try(Scanner scanner = new Scanner(System.in)) {
					
			child = ChildReader.readChildData(scanner);
						
			//child will go on next level only when succesfully finish previous level
			
			Game.runLevel(scanner, connection, child, task, 1, false);
			Game.runLevel(scanner, connection, child, task, 2, false); 
			Game.runLevel(scanner, connection, child, task, 3, true);
			
		}
	}
	 
	
}
