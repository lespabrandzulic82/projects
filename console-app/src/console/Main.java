package console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

        System.out.println("Welcome to application!");
		
		System.out.println("If you want add Product enter 1");
		System.out.println("If you want to Show Product  enter 2");
		System.out.println("If you want to Show Products Specific Type  enter 3");
		System.out.println("If you want to see Product Total enter 4");	
		System.out.println("If you want to see Product Name Per Type enter 5");				
		System.out.println("If you want to see Product Name Per Quantity enter 6");
		System.out.println("Please, enter the path for your choise!");
		
		try(Scanner scc = new Scanner(System.in)) {
			
		  while(true) {
			String productType = "";
			Integer requestedQuantity = 0;
			String choise = scc.next();
			  
			if(choise.equals("1")) {
				Store.addProduct();
				
			}else if(choise.equals("2")) {
				Store.showProducts();
				
			}else if(choise.equals("3")) {
				System.out.println("Please, enter the type of product!");
				//productType = scc.next();
				Store.showProductsOfSpecificType(productType = scc.next());
			}	
			else if(choise.equals("4")) {
				Store.getProductTotal();
					
			}else if(choise.equals("5")) {
				Store.getProductNumberPerType();
				
			} else if (choise.equals("6")){ 
				System.out.println("Please, enter the number quantity of product: ");
		         Store.getProductNamePerQuantity(requestedQuantity = scc.nextInt());
			} else while (!choise.equals("1") && !choise.equals("2") && !choise.equals("3") && !choise.equals("4") && !choise.equals("5") && !choise.equals("6")){
				System.out.println("THE PATH YOU ENTERED IS INCORRECT!");
				System.out.println("Please, TRY AGAIN!");
				System.out.println();
				choise = scc.next();
			}
			
			char quitProgram = 'N';
			
			System.out.println("If you want to finish the program press Y, if not press N");
			quitProgram = scc.next().charAt(0);
			
			if (quitProgram ==  'Y' || quitProgram == 'y') {
				break;
			}
	     }	
    }
}
}
