package bankloans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		public static void createDatabase(Connection connection) throws SQLException{
					
			Statement statement = connection.createStatement();
        
			statement.execute("CREATE DATABASE IF NOT EXISTS bank");
		
		}
		
		public static void createClientTable(Connection connection) throws SQLException{
			
			Statement statement = connection.createStatement();

			statement.execute("USE bank");
			
			statement.execute("CREATE TABLE IF NOT EXISTS client (" +
					"id BIGINT NOT NULL AUTO_INCREMENT,"
					+ "name VARCHAR(25),"
					+ "surname VARCHAR(25),"
					+ "salary DOUBLE,"
					+ "age INT,"
					+ "isMarried BOOLEAN,"
					+ "isFullTimeEmployee BOOLEAN,"
					+ "credit INT,"
					+ "PRIMARY KEY(id)"
					+ ")");
			
		}
		
		public static void insertClient(Connection connection, Client client) throws SQLException {
			
			String sql = "insert into client "
					+ " (name, surname, salary, age, isMarried, isFullTimeEmployee, credit)" + " values (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement prep = connection.prepareStatement(sql);

			prep.setString(1, client.getName());
			prep.setString(2, client.getSurname());
			prep.setDouble(3, client.getSalary());
			prep.setInt(4, client.getAge());
			prep.setBoolean(5, client.isMarried());
			prep.setBoolean(6, client.isFullTimeEmployee());
			prep.setInt(7, client.getCredit());
			
			prep.executeUpdate();	
		}
		

}
