package bankloans;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "";

	public static void main(String[] args) {
		
		System.out.println("Welcome to Bank loan application");
		
		System.out.println("If you want to INSERT CLIENT, enter I");
		System.out.println("If you want to UPDATE CLIENT, enter U");
		System.out.println("If you want to DELETE CLIENT, enter D");
		System.out.println("If you want to SEE ALL CLIENTS, enter C");		
		
		System.out.println("Please, enter the path for your choise!");
		
		try(Scanner scc = new Scanner(System.in)) {
		
			String choise = scc.next();
			  
			if(choise.equals("I") || choise.equals("i")) {
				runClient(); 
			} else if(choise.equals("U") || choise.equals("u") ) {
				updateClient();
			} else if(choise.equals("D") || choise.equals("d")) {
				deleteClient();		
			} else if(choise.equals("C") || choise.equals("c")) {
				readClient();
			} else while (!choise.equals("I") && !choise.equals("i") && !choise.equals("U") && !choise.equals("u") && !choise.equals("D") && !choise.equals("d") && !choise.equals("C") && !choise.equals("c")) {
				System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
				System.out.println("Please, TRY AGAIN!");
				System.out.println();
				choise = scc.next();
			}
		}	
	}	
	
	private static void runClient() {		
	
		ArrayList<Client> clientList = new ArrayList<Client>();		
		
		double totalSalary = 0;
		int countMarried = 0;
		int countEmployee = 0;
		int countCredit = 0;
		
		try(Scanner sc = new Scanner(System.in)){
			
			while(true) {
				System.out.println("Please enter name of the client:");
				String name = sc.next();	
				System.out.println("Please enter surname of the client:");
				String surname = sc.next();
				System.out.println("Please enter client's salary in EUR:");
				double salary = sc.nextInt();
				System.out.println("Age of the client:");
				int age = sc.nextInt();				
				System.out.println("Is he/she married? (if Yes enter true, if No enter false) ");
				boolean isMarried = sc.nextBoolean();
				System.out.println("Is he/she full time employee? (if Yes enter true, if No enter false)");
				boolean isFullTimeEmployee = sc.nextBoolean();
			
				System.out.println("What credit do you want to apply for?");
				System.out.println("If you want house loan enter number 1");
				System.out.println("If you want cash loan enter number 2");
				System.out.println("If you want consumer loan enter number 3");
				int credit = sc.nextInt();	
									
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
				
				try {
					Class.forName(driver);
					Connection con = DriverManager.getConnection(url, user, password);
					
					Statement stt = con.createStatement();
					            
					stt.execute("CREATE DATABASE IF NOT EXISTS bank");
					stt.execute("USE bank");
					
					stt.execute("CREATE TABLE IF NOT EXISTS client (" +
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
					
					// stt.execute("INSERT INTO client(name, surname, salary, age, isMarried, isFullTimeEmployee, credit) VALUES" +
					//"('Branko','Spalovic','150',36,1,0,2), ('Marko','Markovic','700',56,1,1,1)");			            
					    				            
					String sql = "insert into client "
							+ " (name, surname, salary, age, isMarried, isFullTimeEmployee, credit)" + " values (?, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement prep = con.prepareStatement(sql);

					prep.setString(1, client.getName());
					prep.setString(2, client.getSurname());
					prep.setDouble(3, client.getSalary());
					prep.setInt(4, client.getAge());
					prep.setBoolean(5, client.isMarried());
					prep.setBoolean(6, client.isFullTimeEmployee());
					prep.setInt(7, client.getCredit());
					
					prep.executeUpdate();	
					
					stt.close();
					prep.close();
					con.close();
			            		            
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					
				}
				
			}
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
	
		private static void updateClient() {		
						
			try(Scanner userUpdate = new Scanner(System.in)) {
				Class.forName(driver);
				Connection con = DriverManager.getConnection(url, user, password);
	            
				Statement stt = con.createStatement();
	            
				stt.execute("USE bank");				
		           
				System.out.println("Please enter client id to update: ");
	            int id = userUpdate.nextInt();	     
	            System.out.println("Please enter client name: ");
	            String name = userUpdate.next();	 
	            System.out.println("Please enter client surname: ");
	            String surname = userUpdate.next();
	            System.out.println("Please enter client's salary in EUR:");
				double salary = userUpdate.nextInt();
				System.out.println("Age of the client:");
				int age = userUpdate.nextInt();				
				System.out.println("Is he/she married? (if Yes enter true, if No enter false) ");
				boolean isMarried = userUpdate.nextBoolean();
				System.out.println("Is he/she full time employee? (if Yes enter true, if No enter false)");
				boolean isFullTimeEmployee = userUpdate.nextBoolean();			
				System.out.println("What credit do you want to apply for?");
				System.out.println("If you want house loan enter number 1");
				System.out.println("If you want cash loan enter number 2");
				System.out.println("If you want consumer loan enter number 3");
				int credit = userUpdate.nextInt();	
	            
				String sql = "UPDATE client SET name = ?, surname = ?, salary = ?, age = ?, isMarried = ?, isFullTimeEmployee = ?, credit = ?"
						+ " WHERE id = '" + id + "'";

				PreparedStatement prep = con.prepareStatement(sql);

	            prep.setString(1, name);
	            prep.setString(2, surname);
	            prep.setDouble(3, salary);
	            prep.setInt(4, age);
	            prep.setBoolean(5, isMarried);
	            prep.setBoolean(6, isFullTimeEmployee);
	            prep.setInt(7, credit);

	            prep.executeUpdate();
	            
	            stt.close();
				prep.close();
				con.close();
	                		            
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	
		private static void deleteClient() {		
		
		try(Scanner userDelete = new Scanner(System.in)) {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            
        	Statement stt = con.createStatement();
            
			stt.execute("USE bank");
           
            System.out.println("Please enter client id to delete: ");
            int id = userDelete.nextInt();	     
            
            String sql = "DELETE from client"
        			+ " WHERE id = '" + id + "'";

            PreparedStatement prep = con.prepareStatement(sql);

            prep.executeUpdate();
            
            stt.close();
			prep.close();
			con.close();
                 		            
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}
	
	private static void readClient() {		
		
		 int countCredit = 0;
		 int countMarried = 0;
		 int countEmployee = 0;
		
		try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, password);
            
        	Statement stt = con.createStatement();
            
			stt.execute("USE bank");
			
			System.out.println("List of clients who applied for loans: ");
			System.out.println("========================================");
            
            String sql = "SELECT * from client";
                    			
            ResultSet rs = stt.executeQuery(sql);           
            
            int numClient = 0;
            double totalSalary = 0.00;
            
            while(rs.next()) {
            	
            	int id = rs.getInt(1);
             	String name = rs.getString(2);
             	String surname = rs.getString(3);
             	double salary = rs.getDouble(4);
             	int age = rs.getInt(5);
             	Boolean isMarried = rs.getBoolean(6);
             	Boolean isFullTimeEmployee = rs.getBoolean(7);
             	int credit = rs.getInt(8);             	
             	
            	System.out.println(id + " " + name + " " + surname + ", Salary: " + salary + ", Age: " + age + ", Is married: " + isMarried + ", Is full time employee: " + isFullTimeEmployee + ", Credit type: " + credit);
            
             	numClient ++;
             	totalSalary += salary;
             	
             	boolean isCreditApproved; 					 		
				 
             	if(credit == 1 && age < 40 && salary > 700 && isMarried == true && isFullTimeEmployee == true) {
             		isCreditApproved = true;
             	} else if(credit == 2 && age > 30 && salary > 350) {
             		isCreditApproved = true;
             	} else if(credit == 3  && age > 20 && salary > 250) {
					 isCreditApproved = true;
             	} else {
             		isCreditApproved = false;
             	}		 
				
             	if(isCreditApproved == true) {
             		countCredit ++;
             	}
					
             	if(isMarried == true) {
             		countMarried ++;
             	}
             	
             	if(isFullTimeEmployee == true) {
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
           
            stt.close();
			rs.close();
			con.close();
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	





