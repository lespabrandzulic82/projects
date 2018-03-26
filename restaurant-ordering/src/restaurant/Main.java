package restaurant;

import java.sql.*;
import java.util.Scanner;

public class Main {
	
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String user = "root";
	private static final String password = "";

	public static void main(String[] args) {
		 
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
                    + "description VARCHAR(50),"
                    + "menu_type VARCHAR(25),"
                    + "price DOUBLE,"
                    + "PRIMARY KEY(id)"
                    + ")");
        } catch (Exception e) {
            
            e.printStackTrace();
        }
	
	  System.out.println("Welcome to our Pizza restaurant");
        System.out.println("Please choose your order and the waiter will bring you as soon as possible");
        System.out.println("========================================================================");
        System.out.println("If you want to PIZA Menu, enter P");
        System.out.println("If you want to PASTA Menu, enter T");
        System.out.println("If you want to DESSERT Menu, enter D");
        System.out.println("If you want to DRINK Menu, enter B");
        System.out.println("If you want to FINISH your order enter F");
        System.out.println("Please, enter the path for your choise!");
        
        try(Scanner scc = new Scanner(System.in)) {
        
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
		
	}
	
	private static void runPasta() {
		
	}
	
	private static void runDessert() {
		
	}
	
	private static void runDrinks() {
		
	}
	
	private static void runFinishOrder() {
		
	}

}


