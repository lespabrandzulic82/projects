package vezba;

import java.lang.*;

import javafx.concurrent.Worker;


public abstract class Person {
	
	 String name;
	 String address;
	
	int INCREASE_CAP = 20; 
	
	public Person (String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return "Persons name is " + name;
	}
	
	public void changeAdress(String address) {
		
		this.address = address;
		System.out.println("New address is " + address);
		
	}
	
	public void giveDayOff() {
		
		System.out.println("Giving the day off to " + name);
	}
	
	public void  promote(int percent) {
		
		
		System.out.println("Promoting a Worker...");
		giveDayOff();
		
		increasePay(percent);
	}
	
	public abstract boolean increasePay(int percent);
		
		

}



 
	

 
