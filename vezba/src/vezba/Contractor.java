package vezba;

public class Contractor extends Person {
	
	
	 public Contractor (String name) {
		super(name);
     }	
	 
	 public boolean increasePay(int percent) {
			
			if(percent < INCREASE_CAP) {
				
				System.out.println("Increase salary by " + percent + "%." + getName());
				return true;
			}else {
				
				System.out.println("Sorry, cant increase haurlu rate by " + INCREASE_CAP + "%." + getName());
				return false;
			}
					
	 }		
 }
	


