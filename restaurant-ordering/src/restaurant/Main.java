 package restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "";
	
	
	static int numbTable;
	static int numbPerson;
	//static int id_menu;
	
	public static void main(String[] args) throws SQLException {
		//ArrayList<Order> orderList = new ArrayList<Order>();
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
        
        try {
            
            Statement stt = conn.createStatement();
                                    
            stt.execute("CREATE DATABASE IF NOT EXISTS restaurant");
            stt.execute("USE restaurant");
            
            stt.execute("CREATE TABLE IF NOT EXISTS menu (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT,"
                    + "name VARCHAR(50),"
                    + "menu_type VARCHAR(25),"
                    + "price DOUBLE,"
                    + "PRIMARY KEY(id)"
                    + ")");
            
            stt.execute("CREATE TABLE IF NOT EXISTS orders (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT,"
                    + "numbtable INT,"
                    + "id_menu BIGINT,"
                    + "numbperson INT,"
                    + "PRIMARY KEY(id),"
                    + "FOREIGN KEY(id_menu) REFERENCES menu(id)"
                    + ")");
            
            stt.execute("CREATE TABLE IF NOT EXISTS receivedOrders (" +
                    "id BIGINT NOT NULL AUTO_INCREMENT,"
                    + "numbtable INT,"
                    + "numbperson INT,"
                    + "name VARCHAR(50),"
                    + "PRIMARY KEY(id)"
                    + ")");
            
            
            stt.close();
			conn.close();
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        
try {
            
            Class.forName(driver);
            
        } catch (ClassNotFoundException e) {
            //System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        //System.out.println("MySQL JDBC Driver Registered!");
       
        
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
        
 
        System.out.println("Welcome to our Pizza restaurant");
        System.out.println("Please choose your order and the waiter will bring you as soon as possible");
        System.out.println("========================================================================");
        try(Scanner scc = new Scanner(System.in)) {
        System.out.println("Plese eneter the number of table you are:");
        numbTable = scc.nextInt();
        System.out.println("Enter the number of person which are on table:");
        numbPerson = scc.nextInt();
        
        
		
        System.out.println("If you want to PIZA Menu, enter P");
        System.out.println("If you want to PASTA Menu, enter T");
        System.out.println("If you want to DESSERT Menu, enter D");
        System.out.println("If you want to DRINK Menu, enter B");
        System.out.println("If you want to FINISH your order enter F");
        System.out.println("Please, enter the path for your choise!");
        
       // try(Scanner scc = new Scanner(System.in)) {
        
            String choise = scc.next();
              
            if(choise.equals("P") || choise.equals("p")) {
                runPizza(); 
            } else if(choise.equals("T") || choise.equals("t") ) {
                runPasta();
            } else if(choise.equals("D") || choise.equals("d") ) {
                runDessert();
            } else if(choise.equals("B") || choise.equals("b") ) {
                runDrinks();
            } else if(choise.equals("F") || choise.equals("f") ) {
                runFinishOrder();
            } else while (!choise.equals("P") && !choise.equals("p") && !choise.equals("T") && !choise.equals("t") && !choise.equals("D") && !choise.equals("d") && !choise.equals("B") && !choise.equals("b") && !choise.equals("F") && !choise.equals("f")) {
                System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
                System.out.println("Please, TRY AGAIN!");
                System.out.println();
                choise = scc.next();
            }
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
	
	private static void runPasta() {
		
		System.out.println("Welcome to Pasta menu");
        System.out.println("Please choose your pasta:");
        

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
		
        try {
        	Statement stt =conn.createStatement();
        	
        	stt.execute("USE restaurant");
        	
        	String sql = "SELECT * FROM menu WHERE menu_type = 'pasta' ";
        
        	ResultSet rs = stt.executeQuery(sql);
        	while(rs.next()) {
        	int id = rs.getInt(1);
        	String name = rs.getString(2);
        	String menu_type = rs.getString(3);
        	double price = rs.getDouble(4);
        	
        	System.out.println(id+ ". " + name + "-------" + price + " $.");
        	}
        	
        	try(Scanner sc1 = new Scanner(System.in)){
        		int id = 0;
        		while(true) {
        			
        			System.out.println("Please enter the number of pasta you would like to order:");	
        			id = sc1.nextInt();
        			
        			String sql1 = "insert into orders "
    	    	         	+ " ( numbtable, id_menu, numbperson)" + " values (?, ?, ?)";
    	    	         			
    	    	         	PreparedStatement prep = conn.prepareStatement(sql1);
    	    	         			
    	    	         	prep.setInt(1, numbTable);
    	    	         	prep.setInt(2, id);
    	    	         	prep.setInt(3, numbPerson);
    	    	         	
    	    	         	prep.executeUpdate();
        			
        			char quitProgram = 'N';
        			
    				System.out.println("If you finish with Pasta menu press Y, if not press N");
    				quitProgram = sc1.next().charAt(0);
    			
    				if (quitProgram ==  'Y' || quitProgram == 'y') {
    					break;
    				}
        		}
        	
        		
        	System.out.println("If you want to something else, continue with ordering:");
            System.out.println("If you want to PIZZA Menu, enter P");
            System.out.println("If you want to DESSERT Menu, enter D");
            System.out.println("If you want to DRINK Menu, enter B");
            System.out.println("If you want to FINISH your order enter F");
            
            try(Scanner scc = new Scanner(System.in)) {
                
                String choise = scc.next();
                  
                if(choise.equals("P") || choise.equals("p") ) {
                    runPasta();
                } else if(choise.equals("D") || choise.equals("d") ) {
                    runDessert();
                } else if(choise.equals("B") || choise.equals("b") ) {
                    runDrinks();
                } else if(choise.equals("F") || choise.equals("f") ) {
                    runFinishOrder();
                } else while (!choise.equals("P") && !choise.equals("p") && !choise.equals("D") && !choise.equals("d") && !choise.equals("B") && !choise.equals("b") && !choise.equals("F") && !choise.equals("f")) {
                    System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
                    System.out.println("Please, TRY AGAIN!");
                    System.out.println();
                    choise = scc.next();
                }
            }
        	   	
        	stt.close();
			conn.close();
        	}	
        } catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
			
	private static void runDessert() {
		
		System.out.println("Welcome to Desert menu");
        System.out.println("Please choose your desert:");
        
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
		
		try {
			Statement stt =conn.createStatement();
        	
        	stt.execute("USE restaurant");
        	
        	String sql = "SELECT * FROM menu WHERE menu_type = 'dessert' ";
        
        	ResultSet rs = stt.executeQuery(sql);
        	while(rs.next()) {
        	int id = rs.getInt(1);
        	String name = rs.getString(2);
        	String menu_type = rs.getString(3);
        	double price = rs.getDouble(4);
        	
        	System.out.println(id+ ". " + name + "-------" + price + " $.");
        	}
        	
        	try(Scanner sc1 = new Scanner(System.in)){
        		int id = 0;
        		while(true) {
        			
        			System.out.println("Please enter the number of desert you would like to order:");	
        			 id = sc1.nextInt();
        			
        			 String sql1 = "insert into orders "
     	    	         	+ " ( numbtable, id_menu, numbperson)" + " values (?, ?, ?)";
     	    	         			
     	    	         	PreparedStatement prep = conn.prepareStatement(sql1);
     	    	         			
     	    	         	prep.setInt(1, numbTable);
     	    	         	prep.setInt(2, id);
     	    	         	prep.setInt(3, numbPerson);
     	    	         	
     	    	         	prep.executeUpdate();
        			 
        			char quitProgram = 'N';
        			
    				System.out.println("If you finish with Desert menu press Y, if not press N");
    				quitProgram = sc1.next().charAt(0);
    			
    				if (quitProgram ==  'Y' || quitProgram == 'y') {
    					break;
    				}
        		}
        			
        	
        	System.out.println("If you want to something else, continue with ordering:");
            System.out.println("If you want to PIZZA Menu, enter P");
            System.out.println("If you want to DESSERT Menu, enter D");
            System.out.println("If you want to DRINK Menu, enter B");
            System.out.println("If you want to FINISH your order enter F");
            
            try(Scanner scc = new Scanner(System.in)) {
                
                String choise = scc.next();
                  
                if(choise.equals("P") || choise.equals("p") ) {
                    runPasta();
                } else if(choise.equals("D") || choise.equals("d") ) {
                    runDessert();
                } else if(choise.equals("B") || choise.equals("b") ) {
                    runDrinks();
                } else if(choise.equals("F") || choise.equals("f") ) {
                    runFinishOrder();
                } else while (!choise.equals("P") && !choise.equals("p") && !choise.equals("D") && !choise.equals("d") && !choise.equals("B") && !choise.equals("b") && !choise.equals("F") && !choise.equals("f")) {
                    System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
                    System.out.println("Please, TRY AGAIN!");
                    System.out.println();
                    choise = scc.next();
                }
            }
        	
        	stt.close();
			conn.close();
        	
        	}	
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	
	private static void runDrinks() {
		

		System.out.println("Welcome to Drink menu");
        System.out.println("Please choose your drinks:");
        

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
        	
			String sql = "SELECT * FROM menu WHERE menu_type = 'drink' ";
        
        	ResultSet rs = stt.executeQuery(sql);
        	while(rs.next()) {
        	int id = rs.getInt(1);
        	String name = rs.getString(2);
        	String menu_type = rs.getString(3);
        	double price = rs.getDouble(4);
        	
        	System.out.println(id+ ". " + name+ "-------" + price + " $.");
        	}
        	
        	try(Scanner sc1 = new Scanner(System.in)){
        		int id = 0;
        		while(true) {
        			
        			System.out.println("Please enter the number of drink you would to order:");	
        			id  = sc1.nextInt();
        			
        			String sql1 = "insert into orders "
    	    	         	+ " ( numbtable, id_menu, numbperson)" + " values (?, ?, ?)";
    	    	         			
    	    	         	PreparedStatement prep = conn.prepareStatement(sql1);
    	    	         			
    	    	         	prep.setInt(1, numbTable);
    	    	         	prep.setInt(2, id);
    	    	         	prep.setInt(3, numbPerson);
    	    	         	
    	    	         	prep.executeUpdate();
        			
        			char quitProgram = 'N';
        			
    				System.out.println("If you finish with Drink menu press Y, if not press N");
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
	
	private static void runFinishOrder() {
		
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
		
		
		System.out.println("You finished your order");
		System.out.println("This is your order:");
		
		try	 {
			Statement stt =conn.createStatement();
        	
			stt.execute("USE restaurant");
			String sql = "SELECT numbtable,numbperson,name,price "
					+ "FROM ORDERS "
					+ "INNER JOIN MENU ON MENU.ID=ORDERS.ID_MENU "
					+ "WHERE numbtable = '" + numbTable + "'";
			
			ResultSet rs = stt.executeQuery(sql);  
            
        	while(rs.next()) {
        	
            	int numbtable = rs.getInt(1);
            	int numbperson = rs.getInt(2);
             	String name = rs.getString(3);
             	double price = rs.getDouble(4);
             	
	     	
	     	System.out.println("Table number: " + numbtable + ", Number of person: " + numbperson + " " + name + "-------" + price + " $.");
	     	
	     	String sql1 = "insert into receivedOrders "
            		+ " (numbtable, numbperson, name)" + " values (?, ?, ?)";
        	
        	PreparedStatement prep = conn.prepareStatement(sql1);
			
            prep.setInt(1, numbtable);
			prep.setInt(2, numbperson);
			prep.setString(3, name);
			
			
				
			prep.executeUpdate();
	     	
	     	 String sql2 = "DELETE from orders"
	        			+ " WHERE numbtable = '" + numbTable + "'";

	            PreparedStatement prep2 = conn.prepareStatement(sql2);

	            prep2.executeUpdate();
	            
	            
			
        	}
        	
        	
        	
        	stt.close();
			//prep.close();
			conn.close();
			
		}catch (Exception e) {
            	e.printStackTrace();
            }        
		
	
     	
		System.out.println("We will bring your order as soon as we can.");
	}

}


