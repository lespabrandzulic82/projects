package bankloans;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;


public class RunClient {
	
	public static void runClient(Client client) {		
		
		ArrayList<Client> clientList = new ArrayList<Client>();		
		
		try(Scanner scanner = new Scanner(System.in)){
			
			while(true) {
				client = readClientData(scanner);
									
				//Client client = new Client(name, surname, salary, age, isMarried, isFullTimeEmployee, credit);
				clientList.add(client);
				 
				quitProgram(scanner);
					break;
			}									
		 }

		    creditAprove(clientList);
				
			try {
					Connection connection = DatabaseSchema.getConnection();
					
					DatabaseSchema.createDatabase(connection);
					
					DatabaseSchema.createClientTable(connection);		            
					    				            
					DatabaseSchema.insertClient(connection, client);	
					
			            		            
			 } catch (Exception e) {
					e.printStackTrace();
			 } finally {
					
				}
				
			clientListDataStatistics(clientList);
		}
  
	public static Client readClientData(Scanner scanner) {
		
	
			System.out.println("Please enter name of the client:");
			String name = scanner.next();	
			System.out.println("Please enter surname of the client:");
			String surname = scanner.next();
			System.out.println("Please enter client's salary in EUR:");
			double salary = scanner.nextInt();
			System.out.println("Age of the client:");
			int age = scanner.nextInt();				
			System.out.println("Is he/she married? (if Yes enter true, if No enter false) ");
			boolean isMarried = scanner.nextBoolean();
			System.out.println("Is he/she full time employee? (if Yes enter true, if No enter false)");
			boolean isFullTimeEmployee = scanner.nextBoolean();
		
			System.out.println("What credit do you want to apply for?");
			System.out.println("If you want house loan enter number 1");
			System.out.println("If you want cash loan enter number 2");
			System.out.println("If you want consumer loan enter number 3");
			int credit = scanner.nextInt();	
								
			return new Client(name, surname, salary, age, isMarried, isFullTimeEmployee, credit);
					
	}
	
	public static void quitProgram(Scanner scanner) {
		
		char quitProgram = 'N';
		
		System.out.println("If you want to finish the program press Y, if not press N");
		quitProgram = scanner.next().charAt(0);
	
		if (quitProgram ==  'Y' || quitProgram == 'y') {
			//break;
		}
		
	}
	
	public static void creditAprove(ArrayList<Client> clientList) {
		 
		double totalSalary = 0;
		int countMarried = 0;
		int countEmployee = 0;
		int countCredit = 0;
		
		int numClient = clientList.size(); 
			 
		for(int i = 0; i < numClient; i++ ) {
				
			Client client = clientList.get(i);
				
			String creditType = "";
			
			if(client.getCredit() == 1) {
				creditType = "House loan"; 
			} else if(client.getCredit() == 2) {
				creditType = "Cash loan";
			} else if(client.getCredit() == 3) {
				creditType = "Consumer loan";
			}
				 
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
			
			int x = i + 1;
			System.out.println("=============================================");
			System.out.println(x + ". Client applied for credit: " + creditType + "." + " Client's personal data are:");
			System.out.println("Name: " + client.getName());
			System.out.println("Surname: " + client.getSurname());
			System.out.println("Salary: " + client.getSalary() + " EUR");
			System.out.println("Age: " + client.getAge());
			System.out.println("Is married: " + client.isMarried());
			System.out.println("Is employed fulltime: " + client.isFullTimeEmployee());
			System.out.println("Approved: " + isCreditApproved );
			System.out.println("============================================="); 
			
			totalSalary += client.getSalary();				
			 
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

	}
	
	public static void clientListDataStatistics(ArrayList<Client> clientList) {
		
		double totalSalary = 0;
		int countMarried = 0;
		int countEmployee = 0;
		int countCredit = 0;
		
		int numClient = clientList.size(); 
		
		System.out.println("Number of clients is " + numClient + ".");
		System.out.println("Average salary is " + totalSalary/numClient +".");
		System.out.println("Number of approved credits is " + countCredit + ", and number of rejected credits is " + (numClient - countCredit) + ".");
		System.out.println("The percentage of approved credits is " + (double)countCredit / numClient * 100 + "%, while percentage of rejected credits is " + (double)(numClient - countCredit) / numClient * 100 + "%.");
		System.out.println("Number of married clients is " + countMarried + ", and number of single clients is " + (numClient - countMarried) + ".");
		System.out.println("The percentage of married clients is " + (double)countMarried / numClient * 100 + "%, while percentage of single clients is " + (double)(numClient - countMarried) / numClient * 100 + "%.");
		System.out.println("Number of clients with full time job is " + countEmployee + ", and number of clients who don't have full time job is " + (numClient - countEmployee) + ".");
		System.out.println("The percentage of  clients with full time job is " + (double)countEmployee / numClient * 100 + "%, while percentage of clients who don't have full time job is " + (double)(numClient - countEmployee) / numClient * 100 + "%.");
	}
}
