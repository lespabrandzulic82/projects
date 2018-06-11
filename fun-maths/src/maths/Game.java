package maths;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	
	
	private static final int LAST_NUM_ANSWERS = 3;
	
	public static void runLevel(Scanner scanner, Connection connection, Child child, Task task, int level, boolean showReplayMessage) throws SQLException, ClassNotFoundException {
		
		//ArrayList<Child> taskList = new ArrayList<Child>();
		ArrayList<Double> childAnswers = new ArrayList<Double>();
		ArrayList<Double> selectedChildAnswers = new ArrayList<Double>();
		ArrayList<Double> expectedAnswers = new ArrayList<Double>();
		ArrayList<Double> selectedExpectedAnswers = new ArrayList<Double>();
		 
		boolean success = false;

		while(!success) {

			String sql = "SELECT id, description, result, level FROM task "
				+ "WHERE level =" + level;	
			
			// TODO: Pending check if write statement here or outside of method
			Statement statement = connection.createStatement();
		
			ResultSet resultSet = statement.executeQuery(sql);	
		
			resultSet.beforeFirst();
			while(resultSet.next()) {
				 
				task = DatabaseSchema.readTask(resultSet);
				
				System.out.println("Task number " + task.getId() + ":");
				//taskId = id;
				child.setTaskId(task.getId());
				System.out.println(task.getDescription());		
				System.out.println("The child answer is: ");
	          
				child.setTaskResult(scanner.nextDouble());
	            
	            boolean isCorrectAnswer = task.getId() == child.getTaskId() && task.getResult()
	            == child.getTaskResult();
	            child.setCorrectAnswer(isCorrectAnswer);
                                   				 
	          //  taskList.add(child);       			
         		
				DatabaseSchema.insertStatistic(connection, child);
      		         			            
				childAnswers.add(child.getTaskResult());	
	           
	            expectedAnswers.add(task.getResult());
			}			
            	int numTask = childAnswers.size();	 
            	int num = numTask - LAST_NUM_ANSWERS;
        			
            	
            	// TODO: Make code work for all levels
            	
            	selectedChildAnswers = new ArrayList<Double>(childAnswers.subList(num, numTask));
            	selectedExpectedAnswers = new ArrayList<Double>(expectedAnswers.subList(0, LAST_NUM_ANSWERS));
			//}
		
		boolean res = Arrays.equals(selectedChildAnswers.toArray(),selectedExpectedAnswers.toArray());
		
		if(res == true) {
		
			success = true;
			System.out.println("Well done! You've passed Level " + level + " !");
			 
			if(showReplayMessage) {
				
				System.out.println("If you want to play again with tasks, enter T");
				System.out.println("If you want to see statistics and scores, enter S");

				
				try(Scanner scc = new Scanner(System.in)) {
					
					String choise = scc.next();
		  
					if(choise.equals("T") || choise.equals("t")) {
						Main.runTask(child,task);  
					} else if(choise.equals("S") || choise.equals("s") ) {
						StatisticsReport.runStatistics(child, task);
					} else while (!choise.equals("T") && !choise.equals("t") && !choise.equals("S") && !choise.equals("s")) {
						System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
						System.out.println("Please, TRY AGAIN!");
						System.out.println();
						choise = scc.next();
					}
				
				} 
				
			}
			
			} else {
				
				System.out.println("Let's try again Level " + level);
			
			}
		
		}
 	}

	
}


