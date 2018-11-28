package maths;

import java.sql.*;


public class DatabaseSchema {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "";
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		try {
			Class.forName(driver);
			System.out.println("MySQL JDBC Driver Registered.");
		} catch (ClassNotFoundException e) {
			System.out.println("The MySQL JDBC Driver could not be found.");
			e.printStackTrace();
			throw e;
		}
		
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Successfully connected to the database.");
			return connection;
		} catch (SQLException e) {
			System.out.println("Failed to connect to the database, the server may not be running or the credentials are invalid.");
			e.printStackTrace();
			throw e;
		}

	}
	
    public static void prepareDatabase(Connection connection) throws SQLException {
    	
    	createDatabase(connection);
		createTableTask(connection);
		createStatisticTable(connection);
    }
	
	private static void createDatabase(Connection connection) throws SQLException{
		
	
			
			Statement statement = connection.createStatement();
        
			statement.execute("CREATE DATABASE IF NOT EXISTS maths");
		
	}
	
	
	private static void createTableTask(Connection connection) throws SQLException {
		Statement statement = connection.createStatement();
		statement.execute("USE maths");
		
		statement.execute("CREATE TABLE IF NOT EXISTS task (" +
				"id BIGINT NOT NULL AUTO_INCREMENT,"
				+ "description VARCHAR(250),"
				+ "result DOUBLE,"
				+ "level INT,"
				+ "PRIMARY KEY(id)"
				+ ")"); 
		/*//first insert of tasks in table tasks
		stt.execute("INSERT INTO task(description, result, level) VALUES" +
		+ "('If your dad buys you two chocolates, but your brother eats one of them, how many chocolates would you have then?','1',1),"
		+ "('If you have a dog, your brother has a cat, but your mum and dad have 2 fishes, how many pets do you have at home?','4',1),"
		+ "('If you are 7 years old and your best friend is twice older than you, how old is he?','14',2),"
		+ "('If your parents have boy and girl, but their first neighbours have a boy who has twins sisters, how many girls is in the neighbourghood?','3',2),"
		+ "('If you like to play basketball how many football balls will you need for it?', '0',2),"
		+ "('If there is 3 apples, 3 lemons and 3 bananas in the basket and you eat third part od apples and 1 banana, how many fruits would be in the basket?', '7',3),"
		+ "('If you need 10 minutes walk from home to school when you go downhill, but you need twice more time from school to home and your school is finished at 11:40, at which hour you will arrive home?', '12',3),"
		+ "('If you and your brother get 2 chocolates for present, you eat a half from your chocolade and he eats a third part of his and resuming that every chocolate has 9 bars, how many bars would you have together now?', '10.5',3)");
		*/		
			            		            		
	}
	private static void createStatisticTable(Connection connection) throws SQLException{
		
		Statement statement = connection.createStatement();

		statement.execute("USE maths");
		
		statement.execute("CREATE TABLE IF NOT EXISTS statistics (" +
				"id BIGINT NOT NULL AUTO_INCREMENT,"
				+ "name VARCHAR(25),"
				+ "surname VARCHAR(25),"
				+ "date VARCHAR(10),"
				+ "taskId INT,"
				+ "taskResult DOUBLE,"
				+ "correctAnswer BOOLEAN, "
				+ "PRIMARY KEY(id)"
				+ ")");
		
	}
	
	
	public static Task readTask(ResultSet resultSet) throws SQLException {
		

		 
		//showResultSetMetadata(resultSet);
		//double result = 0.00;
		//int id = 0;
		
		int id = resultSet.getInt(1);
		String description = resultSet.getString(2);
		double result = resultSet.getDouble(3);
		int level = resultSet.getInt(4);
		
		return new Task( id, description, result, level);
		
	} 
	
	public static void insertStatistic(Connection connection, Child child) throws SQLException {
			
			String sql3 = "insert into statistics "
	        		+ " ( name, surname, date, taskId, taskResult, correctAnswer)" + " values (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement prep = connection.prepareStatement(sql3);
				
	        prep.setString(1, child.getName());
	        prep.setString(2, child.getSurname());
	        prep.setString(3, child.getDate());
	        prep.setInt(4, child.getTaskId());
	        prep.setDouble(5, child.getTaskResult());
	        prep.setBoolean(6, child.getCorrectAnswer());
	     			         					
	        prep.executeUpdate();
			
	}
	
	public static void showResultSetMetadata(ResultSet resultSet) throws SQLException {
		ResultSetMetaData rsmd = resultSet.getMetaData();
		int numColumns = rsmd.getColumnCount();
		
		for(int i = 1; i <= numColumns; i++) {
			String name = rsmd.getColumnName(i);
			System.out.println(i + " " + name);
		}
	}

}
