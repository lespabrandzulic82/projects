package guessingGame;

import java.util.Random;
import java.util.Scanner;

public class Main {
	
	

    public static void main(String[] args) {      
        
    	
    	    int randNum = 0;
    	    int max = 101;
    	    int min = -1;
    	    String userChoise = "";
    	    int numOfTries = 0;
    	    boolean win = false;

    	    try(Scanner sc = new Scanner(System.in)){
    	    	String playAgain = "";
    	    	do {
    	    	System.out.println("What is your name?");
    	        String name = sc.next();
    	        System.out.println("Welcome, " + name + "! We will now start the number guessing game. Please think of a number between 1 and 100, and I will try to guess your number. Did you think of a number? (Y/N)");
    	        userChoise = sc.next();
    	    	
    	              while(true) {           		
    	        	   
            		
    	            	  if (userChoise.equals("Y") || userChoise.equals("y")) {
    	            		  System.out.println("Ok, let's start!");    	        		
    	            		  //userChoise = sc.next();
    	            		  break;
    	            	  } else if(userChoise.equals("N") || userChoise.equals("n")) {
    	            		  System.out.println("If you don't want to play, please exit!");
    	            		  userChoise = sc.next();
    	            		  break;
    	            	  }
    	           }
    	              
    	             while (!win) {
    	      	    	
    	      	    	randNum = (max + min + 1) / 2;
    	        		     	        		 
    	      	        System.out.println("Is your number " + randNum + "? (Y/H/L) (Yes / Higher / Lower)?");
    	      	        userChoise = sc.next(); 
    	      	        numOfTries++;
    	      	        
    	      	        if(userChoise.equals("Y") || userChoise.equals("y")) {
    	      	        	win = true;
    	      	        }
    	      	        if(userChoise.equals("L") || userChoise.equals("l")) {  
    	      	            max = randNum + 1;
    	      	        } 
    	      	        else if(userChoise.equals("H") || userChoise.equals("h")) { 
    	      	            min = randNum - 1;
    	      	        }       	      	        
    	      	   } 
    	    	        	 
    	     		   System.out.println("Thanks " + name + ", this means I have guessed that your number is "  + randNum + "! I was able to guess your number with just " + numOfTries + " questions. Would you like to play again? (Y/N)");
    	     		   
    	     		/*   char quitProgram = 'N';
    	     		   System.out.println("If you want to finish pres 'Y', if not press 'N'!");
    	     		  quitProgram = sc.next().charAt(0);
    	     		   if (quitProgram == 'Y' || quitProgram == 'y') {
        	     		   System.out.println("Goodbuy !");
        	     		   
    	     		   } */
    	     		   System.out.println("Would you play again y/n ?");
    	     		   playAgain = sc.next();
    	    	} while (playAgain.equalsIgnoreCase("y")) ;
    	    }   	
    }   
}  