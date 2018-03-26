package maths;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "";

	public static void main(String[] args){
		
		System.out.println("Let's play and learn maths!");
		System.out.println("You'll have 3 levels - easy, medium and hard! When you pass one you'll go to the next one. Good luck!");
		System.out.println("=================================================================================================");
		
		System.out.println("If you want to play with tasks, enter T");
		System.out.println("If you want to see statistics and scores, enter S");
		
		System.out.println("Please, enter the path for your choise!");
		
		try(Scanner scc = new Scanner(System.in)) {
		
			String choise = scc.next();
			  
			if(choise.equals("T") || choise.equals("t")) {
				runTasks(); 
			} else if(choise.equals("S") || choise.equals("s") ) {
				runStatistics();
			} else while (!choise.equals("T") && !choise.equals("t") && !choise.equals("S") && !choise.equals("s")) {
				System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
				System.out.println("Please, TRY AGAIN!");
				System.out.println();
				choise = scc.next();
			}
		}
	}
	
	private static void runTasks() {
		
		ArrayList<Child> taskList = new ArrayList<Child>();
		ArrayList<Double> list = new ArrayList<Double>();
		ArrayList<Double> list2 = new ArrayList<Double>();
		ArrayList<Double> listdb = new ArrayList<Double>();
		ArrayList<Double> listdb2 = new ArrayList<Double>();
		
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
	        			            
			stt.execute("CREATE DATABASE IF NOT EXISTS maths");
			stt.execute("USE maths");
			
			stt.execute("CREATE TABLE IF NOT EXISTS task (" +
					"id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "description VARCHAR(250),"
					+ "result DOUBLE,"
					+ "level INT,"
					+ "PRIMARY KEY(id)"
					+ ")");
			
	        /*//first insert of tasks in table tasks
			stt.execute("INSERT INTO task(description, result, level) VALUES" +
			"('If you have one apple and your brother has 2 bananas, how many fruits do you have together?','3',1),"
			+ "('If your dad buys you two chocolates, but your brother eats one of them, how many chocolates would you have then?','1',1),"
			+ "('If you have a dog, your brother has a cat, but your mum and dad have 2 fishes, how many pets do you have at home?','4',1),"
			+ "('If you are 7 years old and your best friend is twice older than you, how old is he?','14',2),"
			+ "('If your parents have boy and girl, but their first neighbours have a boy who has twins sisters, how many girls is in the neighbourhood?','3',2),"
			+ "('If you like to play basketball how many football balls will you need for it?', '0',2),"
			+ "('If there is 3 apples, 3 lemons and 3 bananas in the basket and you eat third part od apples and 1 banana, how many fruits would be in the basket?', '7',3),"
			+ "('If you need 10 minutes walk from home to school when you go downhill, but you need twice more time from school to home and your school is finished at 11:40, at which hour you will arrive home?', '12',3),"
			+ "('If you and your brother get 2 chocolates for present, you eat a half from your chocolade and he eats a third part of his and resuming that every chocolate has 9 bars, how many bars would you have together now?', '10.5',3)");
			*/		
				            		            
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		try(Scanner sc = new Scanner(System.in)) {
			
			Statement stt = conn.createStatement();

			stt.execute("USE maths");
			
			boolean success = false;
			double result = 0.00;
			int taskId = 0;
			double taskResult = 0.00;
			int id = 0;	
			boolean correctAnswer = false;
		
			System.out.println("Enter your name:");	
			String name = sc.next();
			System.out.println("Enter your surname:");	
			String surname = sc.next();
			System.out.println("Enter date in format dd/MM/yyyy");	
			String date = sc.next();
			System.out.println("Let's begin:");
				
			stt.execute("CREATE TABLE IF NOT EXISTS statistics (" +
					"id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "name VARCHAR(25),"
					+ "surname VARCHAR(25),"
					+ "date VARCHAR(10),"
					+ "taskId INT,"
					+ "taskResult DOUBLE,"
					+ "correctAnswer BOOLEAN, "
					+ "PRIMARY KEY(id)"
					+ ")");
			
			//child will go on next level only when succesfully finish previous level
			while(!success) {
										
				String sql = "SELECT id, description, result FROM task "
					+ "WHERE level = 1 ";	
			
				ResultSet rs = stt.executeQuery(sql);	
			
				rs.beforeFirst();
				while(rs.next()) {
			
				id = rs.getInt(1);
				String description = rs.getString(2);
				result = rs.getDouble(3);
				System.out.println("Task number " + id + ":");
				taskId = id;
				System.out.println(description);		
				System.out.println("The result is: ");
	            taskResult = sc.nextDouble();
            
	            if(id == taskId && result == taskResult) {
		            	correctAnswer = true;
	            } else {
	            	correctAnswer = false;
	            }
	                                   				
	            Child child = new Child( name, surname, date, taskId, taskResult, correctAnswer);
	            taskList.add(child);       			
         			  
	            String sql3 = "insert into statistics "
	            		+ " ( name, surname, date, taskId, taskResult, correctAnswer)" + " values (?, ?, ?, ?, ?, ?)";
         			
	            PreparedStatement prep = conn.prepareStatement(sql3);
         			
	            prep.setString(1, child.getName());
	            prep.setString(2, child.getSurname());
	            prep.setString(3, child.getDate());
	            prep.setInt(4, child.getTaskId());
	            prep.setDouble(5, child.getTaskResult());
	            prep.setBoolean(6, child.getCorrectAnswer());
	         			         					
	            prep.executeUpdate();
		         			
	            list.add(taskResult);	
	            listdb.add(result);
         				
	            try {
         				
	            	int numTask = list.size();	 
	            	int num = numTask - 3;
	        			
	            	list2 = new ArrayList<Double>(list.subList(num,numTask));
	            	listdb2 = new ArrayList<Double>(listdb.subList(0,3));
         			
	            } catch (IndexOutOfBoundsException e) {

	            	continue;
	            }
				}
			
			boolean res = Arrays.equals(list2.toArray(),listdb2.toArray());
			
			if(res == true) {
			
				success = true;
				System.out.println("Well done! You've passed Level 1!");

				} else {
					
					System.out.println("Let's try again Level 1");
				
				}
			
			}
			  		
			String sql1 = "SELECT id, description, result FROM task "
					+ "WHERE level = 2 ";
			
			ResultSet rs1 = stt.executeQuery(sql1);
			
			boolean success1 = false;
			
			while(!success1) {
				
			rs1.beforeFirst();
			while(rs1.next()) {
			
			id = rs1.getInt(1);
			String description = rs1.getString(2);
			result = rs1.getDouble(3);
			System.out.println("Task number " + id + ":");
			taskId = id;
			System.out.println(description);		
			System.out.println("The result is: ");
            taskResult = sc.nextDouble();
            
            if(id == taskId && result == taskResult) {
            	correctAnswer = true;
            } else {
            	correctAnswer = false;
            }
                  
            Child child = new Child( name, surname, date, taskId, taskResult, correctAnswer);
	        taskList.add(child);
	         			
	        	String sql3 = "insert into statistics "
	         	+ " ( name, surname, date, taskId, taskResult, correctAnswer)" + " values (?, ?, ?, ?, ?, ?)";
	         			
	         	PreparedStatement prep = conn.prepareStatement(sql3);
	         			
	         	prep.setString(1, child.getName());
	         	prep.setString(2, child.getSurname());
	         	prep.setString(3, child.getDate());
	         	prep.setInt(4, child.getTaskId());
	         	prep.setDouble(5, child.getTaskResult());
	         	prep.setBoolean(6, child.getCorrectAnswer());
	         					
	         	prep.executeUpdate();
            
	         	list.add(taskResult);	
     			listdb.add(result);     			
     				
     			try {
     				
     				int numTask = list.size();	 
     			
     	        	int num = numTask - 3;
     	        	
     	        	int numTaskDb = listdb.size();	 
         			
     	        	int numDb = numTaskDb - 3;
    			
     	        	list2 = new ArrayList<Double>(list.subList(num,numTask));
     	        	listdb2 = new ArrayList<Double>(listdb.subList(numDb,numTaskDb));
	     			
	     			//System.out.println("tr " + list2);
	     			//System.out.println("trdb " + listdb2);
     			
     			} catch (IndexOutOfBoundsException e) {

     				continue;
     			}
			}
		
				boolean res = Arrays.equals(list2.toArray(),listdb2.toArray());
		
				if(res == true) {
		
					success1 = true;
					System.out.println("Well done! You've passed Level 2!");

				} else {
				
					System.out.println("Let's try again Level 2");
			
				}
		
			}
			
			String sql2= "SELECT id, description, result FROM task "
					+ "WHERE level = 3 ";
					
			ResultSet rs2 = stt.executeQuery(sql2);
			
			boolean success2 = false;
			
			while(!success2) {
				
				rs2.beforeFirst();
				while(rs2.next()) {
			
				id = rs2.getInt(1);
				String description = rs2.getString(2);
				result = rs2.getDouble(3);
				System.out.println("Task number " + id + ":");
				taskId = id;
				System.out.println(description);		
				System.out.println("The result is: ");
	            taskResult = sc.nextDouble();
            
	            if(id == taskId && result == taskResult) {
	            	correctAnswer = true;
	            } else {
	            	correctAnswer = false;
	            }
            
	            Child child = new Child( name, surname, date, taskId, taskResult, correctAnswer);
	            taskList.add(child);
			
	            String sql3 = "insert into statistics "
	            		+ " ( name, surname, date, taskId, taskResult, correctAnswer)" + " values (?, ?, ?, ?, ?, ?)";
			
	            PreparedStatement prep = conn.prepareStatement(sql3);
			
	            prep.setString(1, child.getName());
				prep.setString(2, child.getSurname());
				prep.setString(3, child.getDate());
				prep.setInt(4, child.getTaskId());
				prep.setDouble(5, child.getTaskResult());
				prep.setBoolean(6, child.getCorrectAnswer());
					
				prep.executeUpdate();
            
				list.add(taskResult);	
				listdb.add(result);
 				
				try {
	 				
	 				int numTask = list.size();	 
	 			
	 	        	int num = numTask - 3;
				
	 	         	int numTaskDb = listdb.size();	 
	     			
	 	        	int numDb = numTaskDb - 3;
				
	 	        	list2 = new ArrayList<Double>(list.subList(num,numTask));
	 	        	listdb2 = new ArrayList<Double>(listdb.subList(numDb,numTaskDb));
 			
				} catch (IndexOutOfBoundsException e) {
					continue;
				}
				}
	
				boolean res = Arrays.equals(list2.toArray(),listdb2.toArray());
	
				if(res == true) {
	
					success2 = true;
					System.out.println("Well done! You've passed Level 3!");
				
					System.out.println("If you want to play again with tasks, enter T");
					System.out.println("If you want to see statistics and scores, enter S");
		
					try(Scanner scc = new Scanner(System.in)) {
			
						String choise = scc.next();
			  
						if(choise.equals("T") || choise.equals("t")) {
							runTasks(); 
						} else if(choise.equals("S") || choise.equals("s") ) {
							runStatistics();
						} else while (!choise.equals("T") && !choise.equals("t") && !choise.equals("S") && !choise.equals("s")) {
							System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
							System.out.println("Please, TRY AGAIN!");
							System.out.println();
							choise = scc.next();
						}
					}
		
		    

				} else {
			
					System.out.println("Let's try again Level 3");
		
				}
	
			}
		
			stt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	private static void runStatistics() {
		
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
             	int id = rs.getInt(6);
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
