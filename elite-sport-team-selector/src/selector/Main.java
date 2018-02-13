package selector;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		 System.out.println("Welcome to our Basketball club info page!");
		 System.out.println("We are looking for new men player.");
		 System.out.println("Position 1 - play.");
		 System.out.println("Position 3 - small forward.");
		 System.out.println("Position 5 - center.");
		 System.out.println("Please submit your application.");
		 
		 try (Scanner sc= new Scanner(System.in)){
			 
			  System.out.println("Please enter your name:");
			  String name = sc.next();
			  System.out.println("Please enter your surname:");
			  String surname = sc.next();
			  System.out.println("Please enter your height in cm:");
			  int height = sc.nextInt();
			  System.out.println("How old you are:");
			  int age = sc.nextInt();
			  System.out.println("What is your average score per game in last season:");
			  double points = sc.nextDouble();
			  System.out.println("What is your average namber of assistentions per game in last season:");
			  double asist = sc.nextDouble();
			  System.out.println("What is  your average number of jumps per game in last season");
			  double jump = sc.nextDouble();
			  
			  System.out.println("Please choose your position: 1,3,5 ");
			  int position= sc.nextInt();
			  
			  if (position == 1 && age >= 25 && height < 200 && asist > 6 ) {
				  System.out.println("Thank you " + name + " " + surname + " for applying for PLAY position." + '\n' + "Your application has been accepted, we will contact you soon!");
			  } else if (position == 3 && age >= 20 && height > 190 && points > 12 ) {
				  System.out.println("Thank you " + name + " " + surname + " for applying for SMALL FORWARD position." + '\n' + "Your application has been accepted, we will contact you soon!");
			  } else if (position == 5  && age >= 28 && height > 205 && jump > 7 ) {
				  System.out.println("Thank you " + name + " " + surname + " for applying for CENTER position." + '\n' + "Your application has been accepted, we will contact you soon!");
			  } else {
				  System.out.println("Thank you " + name + " " + surname + " for applying.");
				  System.out.println("Unfortunatelly, your characteristics are not matching our criteria!");
			  }
	
		}
		
	}

}
