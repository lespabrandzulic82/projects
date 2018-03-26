package restaurant;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Welcome to our Pizza restaurant");
		System.out.println("Please choose your order and the waiter will bring you as soon as possible");
		System.out.println("========================================================================");
		System.out.println("If you want to PIZA Menu, enter P");
		System.out.println("If you want to PASTA Menu, enter T");
		System.out.println("If you want to DESSERT Menu, enter D");
		System.out.println("If you want to DRINK Menu, enter B");
		System.out.println("If you want to FINISH enter F");
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


