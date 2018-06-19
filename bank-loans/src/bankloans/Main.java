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
				RunClient.runClient(null); 
			} else if(choise.equals("U") || choise.equals("u") ) {
				updateClient();
			} else if(choise.equals("D") || choise.equals("d")) {
				deleteClient();		
			} else if(choise.equals("C") || choise.equals("c")) {
				ReadClient.readClient(null);
			} else while (!choise.equals("I") && !choise.equals("i") && !choise.equals("U") && !choise.equals("u") && !choise.equals("D") && !choise.equals("d") && !choise.equals("C") && !choise.equals("c")) {
				System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
				System.out.println("Please, TRY AGAIN!");
				System.out.println();
				choise = scc.next();
			}
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
	
	
}

	





