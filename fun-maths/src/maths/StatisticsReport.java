package maths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatisticsReport {
	
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "";
	
	public static void runStatistics() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			//System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		//System.out.println("MySQL JDBC Driver Registered!");
		Connection conn = null;
		
		try {
			
			conn = DriverManager.getConnection(url,user, password);

		} catch (SQLException e) {
			//System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (conn != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		try {
			
			Statement stt = conn.createStatement();
            
			stt.execute("USE maths");
			
			System.out.println("========================================");
			System.out.println("Children and their scores: ");
			System.out.println("========================================");
            
            String sql = "SELECT statistics.name, statistics.surname, statistics.date, statistics.taskId, statistics.taskResult, task.id, task.result, task.level "  
            		+ "FROM statistics " 
            		+ "JOIN task ON task.id = statistics.taskId " 
            		+ "ORDER BY statistics.date, statistics.surname, statistics.taskId ";
                    			
            ResultSet rs = stt.executeQuery(sql);  
            
                while(rs.next()) {
            	
            	String name = rs.getString(1);
             	String surname = rs.getString(2);
             	String date = rs.getString(3);
             	int taskId = rs.getInt(4);
             	double taskResult = rs.getDouble(5);
             	double result = rs.getDouble(7);
             	int level = rs.getInt(8);

             	System.out.println(name + " " + surname + ", date: " + date + ", task number: " + taskId + ", entered result: " + taskResult + ", correct result: " + result + ", level: " + level);
             	
                     }
            System.out.println("========================================");
            System.out.println("Children with best scores: ");
			System.out.println("========================================");
			
		    String sql1 = "SELECT statistics.name, statistics.surname, (CASE when statistics.correctAnswer = 1 THEN COUNT(distinct statistics.taskId) END) as numOfCorrectAnswer, COUNT(statistics.taskId) as numOfRows, statistics.date "  
            		+ "FROM statistics " 
		    		+ "GROUP BY statistics.name, statistics.surname, statistics.date "
            		+ "ORDER BY numOfCorrectAnswer DESC, numOfRows ASC, statistics.date ";
                    			
            ResultSet rs1 = stt.executeQuery(sql1);  
            
            	while(rs1.next()) {
            	
	            	String name = rs1.getString(1);
	             	String surname = rs1.getString(2);
	             	int numOfCorrectAnswer = rs1.getInt(3);
	             	int numOfRows = rs1.getInt(4);
	             	String date = rs1.getString(5);
      
             	System.out.println(name + " " + surname + ", number of correct answers: " + numOfCorrectAnswer + ", number of tries: " + numOfRows + ", date: " + date);
            	}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
