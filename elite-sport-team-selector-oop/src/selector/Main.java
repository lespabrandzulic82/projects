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
		 
		 playerDemo();
		 
}
		private static void playerDemo() {
								
			try (Scanner sc = new Scanner(System.in)){
			 
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
			  double assistances = sc.nextDouble();
			  System.out.println("What is your average number of jumps per game in last season:");
			  int jumps = sc.nextInt();
			  
			  System.out.println("Please choose your position: 1,3,5 ");
			  int position = sc.nextInt();
			  
			  Player player = new Player(name,  surname,  height,  age,  points,  assistances, jumps,  position);
			  
			  if (position == 1 && age > 25 && height < 200 && assistances > 6) {
				  System.out.println("Thank you " + player.getName() + " " + player.getSurname() + " for applying for PLAY position.");
				  System.out.println("Your charateristics is: height - " + player.getHeight() + "cm, years - " + player.getAge() + ", points - " + player.getPoints() + " per game, assistances - " + player.getAssistances() + " per game and jumps - " + player.getJumps() + " per game.");
				  System.out.println("Your application has been accepted, we will contact you soon!");
			  } else if (position == 3 && player.getAge() > 20 && player.getHeight() > 190 && player.getPoints() > 12) {
				  System.out.println("Thank you " + player.getName() + " " + player.getSurname() + " for applying for SMALL FORWARD position.");
				  System.out.println("Your charateristics is: height - " + player.getHeight() + "cm, years - " + player.getAge() + ", points - " + player.getPoints() + " per game, assistances - " + player.getAssistances() + " per game and jumps - " + player.getJumps() + " per game.");
				  System.out.println("Your application has been accepted, we will contact you soon!");
			  } else if (position == 5  && player.getAge() > 28 && player.getHeight() > 205 && player.getJumps() > 7) {
				  System.out.println("Thank you " + player.getName() + " " + player.getSurname() + " for applying for CENTER position.");
				  System.out.println("Your charateristics is: height - " + player.getHeight() + "cm, years - " + player.getAge() + ", points - " + player.getPoints() + " per game, assistances - " + player.getAssistances() + " per game and jumps - " + player.getJumps() + " per game.");
				  System.out.println("Your application has been accepted, we will contact you soon!");
			  } else {
				  System.out.println("Thank you " + player.getName() + " " + player.getSurname() + " for applying.");
				  System.out.println("Your charateristics is: height - " + player.getHeight() + "cm, years - " + player.getAge() + ", points - " + player.getPoints() + " per game, assistances - " + player.getAssistances() + " per game and jumps - " + player.getJumps() + " per game.");
				  System.out.println("Unfortunately, your characteristics are not matching our criteria!");
			  }
		 }
	 }
}

