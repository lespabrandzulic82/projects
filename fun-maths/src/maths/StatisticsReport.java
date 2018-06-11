package maths;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatisticsReport {
		
	public static  void runStatistics(Child child, Task task) throws SQLException, ClassNotFoundException {
		
		Connection connection = DatabaseSchema.getConnection();	
				
		Statement statement = connection.createStatement();
        
		statement.execute("USE maths");
		
		System.out.println("========================================");
		System.out.println("Children and their scores: ");
		System.out.println("========================================");
        
        String sql = "SELECT statistics.name, statistics.surname, statistics.date, statistics.taskId, statistics.taskResult, task.id, task.result, task.level "  
        		+ "FROM statistics " 
        		+ "JOIN task ON task.id = statistics.taskId " 
        		+ "ORDER BY statistics.date, statistics.surname, statistics.taskId ";
                			
        ResultSet resultSet = statement.executeQuery(sql);  
        
            while(resultSet.next()) {
            	String name = resultSet.getString(1);
             	String surname = resultSet.getString(2);
             	String date = resultSet.getString(3);
             	int taskId = resultSet.getInt(4);
             	double taskResult = resultSet.getDouble(5);
             	double result = resultSet.getDouble(7);
             	int level = resultSet.getInt(8);

         	System.out.println(name + " " + surname + ", date: " + date + ", task number: " + taskId + ", entered result: " + taskResult + ", correct result: " + result + ", level: " + level);
         	
                 }
        System.out.println("========================================");
        System.out.println("Children with best scores: ");
		System.out.println("========================================");
		
	    String sql1 = "SELECT statistics.name, statistics.surname, (CASE when statistics.correctAnswer = 1 THEN COUNT(distinct statistics.taskId) END) as numOfCorrectAnswer, COUNT(statistics.taskId) as numOfRows, statistics.date "  
        		+ "FROM statistics " 
	    		+ "GROUP BY statistics.name, statistics.surname, statistics.date "
        		+ "ORDER BY numOfCorrectAnswer DESC, numOfRows ASC, statistics.date ";
                			
        ResultSet resultSet1 = statement.executeQuery(sql1);  
        
        	while(resultSet1.next()) {
        	
        		String name = resultSet1.getString(1);
             	String surname = resultSet1.getString(2);
             	int numOfCorrectAnswer = resultSet1.getInt(3);
             	int numOfRows = resultSet1.getInt(4);
             	String date = resultSet1.getString(5);
  
         	System.out.println(name + " " + surname + ", number of correct answers: " + numOfCorrectAnswer + ", number of tries: " + numOfRows + ", date: " + date);
        	}
		}
}


