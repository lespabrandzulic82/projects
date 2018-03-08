package bankloans;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to Bank loan application");
		System.out.println("Follow the instructions and complete application");
		System.out.println("Select the number of clients and type of credit they want to get information about");		
		
		clientDemo();	
		
	}	
	
	private static void clientDemo() {
	
		ArrayList<Client> clientList = new ArrayList<Client>();		
		
		double totalSalary = 0;
		int countMarried = 0;
		int countEmployee = 0;
		int countCredit = 0;
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
			 
				String name;
				String surname;
				double salary;
				int age;
				boolean isMarried;
				boolean isFullTimeEmployee;
				int credit;
								
				System.out.println("Please enter name of the client:");
				name = sc.next();	
				System.out.println("Please enter surname of the client:");
				surname = sc.next();
				System.out.println("Please enter client's salary in EUR:");
				salary = sc.nextInt();
				System.out.println("Age of the client:");
				age = sc.nextInt();				
				System.out.println("Is he/she married? (if Yes enter true, if No enter false) ");
				isMarried = sc.nextBoolean();
				System.out.println("Is he/she full time employee? (if Yes enter true, if No enter false)");
				isFullTimeEmployee = sc.nextBoolean();
			
				System.out.println("What credit do you want to apply for?");
				System.out.println("If you want house loan enter number 1");
				System.out.println("If you want cash loan enter number 2");
				System.out.println("If you want consumer loan enter number 3");
				credit = sc.nextInt();				
	
				Client client = new Client(name, surname, salary, age, isMarried, isFullTimeEmployee, credit);
				clientList.add(client);
				 
				char quitProgram = 'N';
			
				System.out.println("If you want to finish the program press Y, if not press N");
				quitProgram = sc.next().charAt(0);
			
				if (quitProgram ==  'Y' || quitProgram == 'y') {
					break;
				}
				
					
			}

			 int numClient = clientList.size(); 
			 			 			 
				 for(int i = 0; i < numClient; i++ ) {
					
					Client client = clientList.get(i);
					
					 String creditType = "";
					 					 
					 if (client.getCredit() == 1) {
						 creditType = "House loan"; 
					 }else if (client.getCredit() == 2) {
						 creditType = "Cash loan";
					 }else if (client.getCredit() == 3) {
						 creditType = "Consumer loan";
					 }
					 
					 boolean IsCreditApproved;
					 
					 if (client.getCredit() == 1 && client.getAge() < 40 && client.getSalary() > 700 && client.isMarried() == true && client.isFullTimeEmployee() == true) {
						 IsCreditApproved = true;
					 }else if (client.getCredit() == 2 && client.getAge() > 30 && client.getSalary() > 350) {
						 IsCreditApproved = true;
					 }else if (client.getCredit() == 3  && client.getAge() > 20 && client.getSalary() > 250) {
						 IsCreditApproved = true;
					 }else {
						 IsCreditApproved = false;
					 }
					
				/*if (client.getCredit() == 1 && client.getAge() < 40 && client.getSalary() > 700 && client.isMarried() == true && client.isFullTimeEmployee() == true) {
					System.out.println("=============================================");
					System.out.println("Client applied for credit: " + creditType + "." + " Client's personal data are:");
					System.out.println("Name: " + client.getName());
					System.out.println("Surname: " + client.getSurname());
					System.out.println("Salary: " + client.getSalary() + " EUR");
					System.out.println("Age: " + client.getAge());
					System.out.println("Is married: " + client.isMarried());
					System.out.println("Is employed fulltime: " + client.isFullTimeEmployee());
					System.out.println("Credit for this client will be approved!" );
					System.out.println("=============================================");
					}else if (client.getCredit() == 2 && client.getAge() > 30 && client.getSalary() > 350) {
						System.out.println("=============================================");
						System.out.println("Client applied for credit: " + creditType + "." + " Client's personal data are:");
						System.out.println("Name: " + client.getName());
						System.out.println("Surname: " + client.getSurname());
						System.out.println("Salary: " + client.getSalary() + " EUR");
						System.out.println("Age: " + client.getAge());
						System.out.println("Is married: " + client.isMarried());
						System.out.println("Is employed fulltime: " + client.isFullTimeEmployee());
						System.out.println("Credit for this client will be approved!");
						System.out.println("=============================================");
					}else if (client.getCredit() == 3  && client.getAge() > 20 && client.getSalary() > 250) {
						System.out.println("=============================================");
						System.out.println("Client applied for credit: " + creditType + "." + " Client's personal data are:");
						System.out.println("Name: " + client.getName());
						System.out.println("Surname: " + client.getSurname());
						System.out.println("Salary: " + client.getSalary() + " EUR");
						System.out.println("Age: " + client.getAge());
						System.out.println("Is married: " + client.isMarried());
						System.out.println("Is employed fulltime: " + client.isFullTimeEmployee());
						System.out.println("Credit for this client will be approved!");
						System.out.println("=============================================");
					}else {
						System.out.println("=============================================");
						System.out.println("Client applied for credit: " + creditType + "." + " Client's personal data are:");
						System.out.println("Name: " + client.getName());
						System.out.println("Surname: " + client.getSurname());
						System.out.println("Salary: " + client.getSalary() + " EUR");
						System.out.println("Age: " + client.getAge());
						System.out.println("Is married: " + client.isMarried());
						System.out.println("Is employed fulltime: " + client.isFullTimeEmployee());
						System.out.println("Credit for this client will not be approved!");
						System.out.println("=============================================");
				}*/
					 
					 //if (IsCreditApproved = true) {
					      int x = i + 1;
						 System.out.println("=============================================");
							System.out.println(x + ". Client applied for credit: " + creditType + "." + " Client's personal data are:");
							System.out.println("Name: " + client.getName());
							System.out.println("Surname: " + client.getSurname());
							System.out.println("Salary: " + client.getSalary() + " EUR");
							System.out.println("Age: " + client.getAge());
							System.out.println("Is married: " + client.isMarried());
							System.out.println("Is employed fulltime: " + client.isFullTimeEmployee());
							System.out.println("Approved: " + IsCreditApproved );
							System.out.println("============================================="); 
					/* }else {
						 System.out.println("=============================================");
							System.out.println("Client applied for credit: " + creditType + "." + " Client's personal data are:");
							System.out.println("Name: " + client.getName());
							System.out.println("Surname: " + client.getSurname());
							System.out.println("Salary: " + client.getSalary() + " EUR");
							System.out.println("Age: " + client.getAge());
							System.out.println("Is married: " + client.isMarried());
							System.out.println("Is employed fulltime: " + client.isFullTimeEmployee());
							System.out.println("Credit for this client will not be approved!");
							System.out.println("=============================================");
					 }*/
				
							totalSalary += client.getSalary();				
				 
							if(IsCreditApproved == true) {
								countCredit ++;
							}
							
							if(client.isMarried() == true) {
								countMarried ++;
							}
							
							if(client.isFullTimeEmployee() == true) {
								countEmployee ++;
							}							
				 }
				 
				 System.out.println("Number of clients is " + numClient + ".");
				 System.out.println("Average salary is " + totalSalary/numClient +".");
			     System.out.println("Number of approved credist is " + countCredit + ", and number of rejected credits is " + (numClient - countCredit) + ".");
			     System.out.println("The percentage of approved credits is " + (double)countCredit / numClient * 100 + "%, while percentage of rejected credits is " + (double)(numClient - countCredit) / numClient * 100 + "%.");
			     System.out.println("Number of married clients is " + countMarried + ", and number of single clients is " + (numClient - countMarried) + ".");
			     System.out.println("The percentage of married clients is " + (double)countMarried / numClient * 100 + "%, while percentage of single clients is " + (double)(numClient - countMarried) / numClient * 100 + "%.");
			     System.out.println("Number of clients with full time job is " + countEmployee + ", and number of clients who don't have full time job is " + (numClient - countEmployee) + ".");
			     System.out.println("The percentage of  clients with full time job is " + (double)countEmployee / numClient * 100 + "%, while percentage of clients who don't have full time job is " + (double)(numClient - countEmployee) / numClient * 100 + "%.");

		}
	}
}
	





