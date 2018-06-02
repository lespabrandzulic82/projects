package maths;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
	
	public static void runLevel(Child child, int level, boolean showReplayMessage) throws SQLException {
		
		ArrayList<Child> taskList = new ArrayList<Child>();
		ArrayList<Double> childResulList = new ArrayList<Double>();
		ArrayList<Double> chidlResultListSub = new ArrayList<Double>();
		ArrayList<Double> resultListDb = new ArrayList<Double>();
		ArrayList<Double> resultListDbSub = new ArrayList<Double>();
		 
		boolean success = false;

		while(!success) {

			String sql = "SELECT id, description, result FROM task "
				+ "WHERE level =" + level;	
		
			ResultSet resultSet = statement.executeQuery(sql);	
		
			resultSet.beforeFirst();
			while(resultSet.next()) {
				 
				Task task = DatabaseSchema.readTask(resultSet);
				
				System.out.println("Task number " + task.getId() + ":");
				child.setTaskResult(task.getId());
				System.out.println(task.getDescription());		
				System.out.println("The result is: ");
	          
				child.setTaskResult(scanner.nextDouble());
	            
	            boolean isCorrectAnswer = task.getId() == child.getTaskId() && task.getResult()
	            == child.getTaskResult();
	            child.setCorrectAnswer(isCorrectAnswer);
                                   				 
	            taskList.add(child);       			
         		
				DatabaseSchema.insertStatistic(connection, child);
      		         			            
	            childResulList.add(child.getTaskResult());	
	           
	            resultListDb.add(task.getResult());
         				
	            try {
         				
	            	int numTask = childResulList.size();	 
	            	int num = numTask - 3;
	        			
	            	chidlResultListSub = new ArrayList<Double>(childResulList.subList(num,numTask));
	            	resultListDbSub = new ArrayList<Double>(resultListDb.subList(0,3));
         			
	            } catch (IndexOutOfBoundsException e) {

	            	continue;
	            }
			}
		
		boolean res = Arrays.equals(chidlResultListSub.toArray(),resultListDbSub.toArray());
		
		if(res == true) {
		
			success = true;
			System.out.println("Well done! You've passed Level " + level + " !");
			 
			if(showReplayMessage) {
				
				System.out.println("If you want to play again with tasks, enter T");
				System.out.println("If you want to see statistics and scores, enter S");

				
				try(Scanner scc = new Scanner(System.in)) {
					
					String choise = scc.next();
		  
					if(choise.equals("T") || choise.equals("t")) {
						Main.runTasks(); 
					} else if(choise.equals("S") || choise.equals("s") ) {
						StatisticsReport.runStatistics();
					} else while (!choise.equals("T") && !choise.equals("t") && !choise.equals("S") && !choise.equals("s")) {
						System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
						System.out.println("Please, TRY AGAIN!");
						System.out.println();
						choise = scc.next();
					}
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			} else {
				
				System.out.println("Let's try again Level " + level);
			
			}
		
		}
 	}

	
}


