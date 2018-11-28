package restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RestaurantMenu {
	
	static int numbTable;
	static int numbPerson;
	
	public static void welcomeMenu() {
		
		System.out.println("Welcome to our Pizza restaurant");
        System.out.println("Please choose your order and the waiter will bring you as soon as possible");
        System.out.println("========================================================================");
        
        try(Scanner scanner = new Scanner(System.in)) {
        	
	        System.out.println("Plese eneter the number of table you are:");
	        numbTable = scanner.nextInt();
	        System.out.println("Enter the number of person which are on table:");
	        numbPerson = scanner.nextInt();
	        		
	        System.out.println("If you want to PIZA Menu, enter P");
	        System.out.println("If you want to PASTA Menu, enter T");
	        System.out.println("If you want to DESSERT Menu, enter D");
	        System.out.println("If you want to DRINK Menu, enter B");
	        System.out.println("If you want to FINISH your order enter F");
	        System.out.println("Please, enter the path for your choise!");
	    
	       // try(Scanner scc = new Scanner(System.in)) {
    
        
        }
	}
	
private static void runPizza() {
		
		System.out.println("Welcome to Pizza menu");
        System.out.println("Please choose your pizza:");
        

		try {
			
			Class.forName(driver);
			
		
			
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
		
		try	 {
						
			Statement stt =conn.createStatement();
        	
			stt.execute("USE restaurant");
        	
			String sql = "SELECT * FROM menu WHERE menu_type = 'pizza' ";
        
        	ResultSet rs = stt.executeQuery(sql);
        	while(rs.next()) {
        	int id = rs.getInt(1);
        	String name = rs.getString(2);
        	String menu_type = rs.getString(3);
        	double price = rs.getDouble(4);
        	
        	System.out.println(id + ". " + name+ "-------" + price + " $.");
        	
        	
		         	
        	}
        	
        	try(Scanner sc1 = new Scanner(System.in)){
        		int id = 0;
        		while(true) {
        			
        			System.out.println("Please enter the number of pizza you would to order:");	
        			 id = sc1.nextInt();
        			
        			 String sql1 = "insert into orders "
     	    	         	+ " ( numbtable, id_menu, numbperson)" + " values (?, ?, ?)";
     	    	         			
     	    	         	PreparedStatement prep = conn.prepareStatement(sql1);
     	    	         			
     	    	         	prep.setInt(1, numbTable);
     	    	         	prep.setInt(2, id);
     	    	         	prep.setInt(3, numbPerson);
     	    	         	
     	    	         	prep.executeUpdate();
        			 
        			char quitProgram = 'N';
        			
    				System.out.println("If you finish with Pizza menu press Y, if not press N");
    				quitProgram = sc1.next().charAt(0);
    			
    				if (quitProgram ==  'Y' || quitProgram == 'y') {
    					break;
    				}  				
    				
        		}
        		  	
        		System.out.println("If you want to something else, continue with ordering:");
        		System.out.println("If you want to PASTA Menu, enter T");
        		System.out.println("If you want to DESSERT Menu, enter D");
        		System.out.println("If you want to DRINK Menu, enter B");
        		System.out.println("If you want to FINISH your order enter F");
            
        		try(Scanner scc = new Scanner(System.in)) {
                
        			String choise = scc.next();
                  
        			if(choise.equals("T") || choise.equals("t") ) {
        				runPasta();
        			} else if(choise.equals("D") || choise.equals("d") ) {
        				runDessert();
        			} else if(choise.equals("B") || choise.equals("b") ) {
        				runDrinks();
        			} else if(choise.equals("F") || choise.equals("f") ) {
        				runFinishOrder();
        			} else while (!choise.equals("T") && !choise.equals("t") && !choise.equals("D") && !choise.equals("d") && !choise.equals("B") && !choise.equals("b") && !choise.equals("F") && !choise.equals("f")) {
        				System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
        				System.out.println("Please, TRY AGAIN!");
        				System.out.println();
        				choise = scc.next();
        			}
        		}
        	}	
        	stt.close();
        	conn.close();
			
        } catch (Exception e) {
        	e.printStackTrace();
        }        
	}

}
