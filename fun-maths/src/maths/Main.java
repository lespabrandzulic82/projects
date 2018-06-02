package maths;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
			  
			if(choise.equalsIgnoreCase("T")) {
				runTasks(); 
			} else if(choise.equalsIgnoreCase("S")) {
				StatisticsReport.runStatistics();
			} else while (!choise.equalsIgnoreCase("T") && !choise.equalsIgnoreCase("S")) {
				System.out.println("The path you entered is inccorect.");
				System.out.println("Please, try again");
				System.out.println();
				choise = scanner.next();
			}
		}
	}
	
	public static void runTasks() throws SQLException {
				
		Connection connection = DatabaseSchema.getConnection();
		
		DatabaseSchema.prepareDatabase(connection);
		
		
		try(Scanner scanner = new Scanner(System.in)) {
					
			Child child = ChildReader.readChildData(scanner);
						
			//child will go on next level only when succesfully finish previous level
			
			Game.runLevel(child, 1, false);
			Game.runLevel(child, 2, false); 
			Game.runLevel(child, 3, true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	
}
