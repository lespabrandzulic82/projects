package bankloans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadClient {
	
	public static void readClient(Client client) {		
		
		 int countCredit = 0;
		 int countMarried = 0;
		 int countEmployee = 0;
		
		try {
			Connection connection = DatabaseSchema.getConnection();
           
       	    Statement statement = connection.createStatement();
           
			statement.execute("USE bank");
			
			System.out.println("List of clients who applied for loans: ");
			System.out.println("========================================");
           
           String sql = "SELECT * from client";
                   			
           ResultSet resultSet = statement.executeQuery(sql);           
           
           int numClient = 0;
           double totalSalary = 0.00;
           
           while(resultSet.next()) {
           	
           		int id = resultSet.getInt(1);
            	client.setName(resultSet.getString(2));
            	client.setSurname(resultSet.getString(3));
            	client.setSalary(resultSet.getDouble(4));
            	client.setAge(resultSet.getInt(5));
            	client.setIsMarried(resultSet.getBoolean(6));
            	client.setIsFullTimeEmployee(resultSet.getBoolean(7));
            	client.setCredit(resultSet.getInt(8));             	
            	
           	System.out.println(id + " " + client.getName() + " " +client.getSurname() + ", Salary: " + client.getSalary() + ", Age: " + client.getAge() + ", Is married: " + client.isMarried() + ", Is full time employee: " + client.isFullTimeEmployee() + ", Credit type: " + client.getCredit());
           
            	numClient ++;
            	totalSalary += client.getSalary();
            	
            	boolean isCreditApproved; 					 		
				 
            	if(client.getCredit() == 1 && client.getAge() < 40 && client.getSalary() > 700 && client.isMarried() == true && client.isFullTimeEmployee() == true) {
            		isCreditApproved = true;
            	} else if(client.getCredit() == 2 && client.getAge() > 30 && client.getSalary() > 350) {
            		isCreditApproved = true;
            	} else if(client.getCredit() == 3  && client.getAge() > 20 && client.getSalary() > 250) {
					 isCreditApproved = true;
            	} else {
            		isCreditApproved = false;
            	}		 
				
            	if(isCreditApproved == true) {
            		countCredit ++;
            	}
					
            	if(client.isMarried() == true) {
            		countMarried ++;
            	}
            	
            	if(client.isFullTimeEmployee() == true) {
            		countEmployee ++;
            	}	
           }
           
           System.out.println("========================================");
           System.out.println("Statistics: "); 
           System.out.println("========================================");
           System.out.println("Number of clients is " + numClient + ".");
           System.out.println("Average salary is " + totalSalary/numClient +".");
           System.out.println("Number of approved credist is " + countCredit + ", and number of rejected credits is " + (numClient - countCredit) + ".");
           System.out.println("The percentage of approved credits is " + (double)countCredit / numClient * 100 + "%, while percentage of rejected credits is " + (double)(numClient - countCredit) / numClient * 100 + "%.");
           System.out.println("Number of married clients is " + countMarried + ", and number of single clients is " + (numClient - countMarried) + ".");
           System.out.println("The percentage of married clients is " + (double)countMarried / numClient * 100 + "%, while percentage of single clients is " + (double)(numClient - countMarried) / numClient * 100 + "%.");
           System.out.println("Number of clients with full time job is " + countEmployee + ", and number of clients who don't have full time job is " + (numClient - countEmployee) + ".");
           System.out.println("The percentage of  clients with full time job is " + (double)countEmployee / numClient * 100 + "%, while percentage of clients who don't have full time job is " + (double)(numClient - countEmployee) / numClient * 100 + "%.");
          
           statement.close();
			resultSet.close();
			connection.close();
           
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
