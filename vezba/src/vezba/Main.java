package vezba;



public class Main {
	 
	 public void main(String[] args) {
		 
		 Tax t = new Tax();
		 t.calcTax();
			
		 double yourTax = t.calcTax();
		 System.out.print("Your tax is " + yourTax);

     }
}
 class Tax {
	 
	    double grasscome;
		String state;
		int dependtents;
		
		  double calcTax() {
			
			return 234.55;
		  }
 }	
	

 
