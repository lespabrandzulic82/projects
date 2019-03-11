package helloworld;



public class Main {

	public static void main(String[] args) {
		
		double grossInCome;
		String state;
		int dependtents;
		
		grossInCome = 5000;
		state = "NJ";
		dependtents = 2;
		
		Tax t = new Tax (grossInCome, state, dependtents);
		double yourTax = t.calcTax();
		System.out.println("Your tax is " + yourTax);
		
		Tax t2 = new Tax(65000, "TX", 4);
		double hisTax = t2.calcTax();
		System.out.println("his tax is " + hisTax);
		
		 t.convertToEuros(yourTax);
		 t.convertToEuros(hisTax);
		
		 Radnik radnik = new Radnik("dordje","Stojanovic");
		 radnik.prikaz();
		 
		 Manager zaposlen = new Manager("Marko", "Jankovic", "menadzer");
		 zaposlen.prikaz2();
		 System.out.println("===============================================");
		 
		  zaposlen.setTitula("Direktor");
		  zaposlen.prikaz2();
		System.out.println("===============================================");
		
		

		  
	}

}

class Tax {
	 
      double grossInCome;
	  String state;
	  int dependtents;
	  static int customerCounter;
	  // cons
	  Tax(double grossInCome, String state, int dependtents){
		  
		  this.grossInCome = grossInCome;
		  this.state = state;
		  this.dependtents = dependtents;	
		  customerCounter++;
		  System.out.println("Preparing the tax data for customer #" + customerCounter);
	  }
	  
	  double calcTax() {
		  return (grossInCome * 0.33 - dependtents * 100);
	  }
	  
	  public static void convertToEuros(double taxInDollars) {
		  System.out.println("Tax is EU: " + taxInDollars/1.25);
		  
	  }
}	

class NJTax extends Tax{
	
	NJTax(double gi, String st, int depen) {
		super(gi, st, depen);
		// TODO Auto-generated constructor stub
	}

	double adjustForStudents(double stateTax) {
		
		double adjustTax = stateTax - 500;
		return adjustTax;
	}
}

   class Radnik{
	   
	   protected String ime;
	   protected String prezime;
	   private int godRodj;
	   private int godZap;
	     
	   public Radnik (String ime, String prezime, int godRodj, int godZap) {
	   
	   			this.ime = ime;
	   			this.prezime = prezime;
	   			this.godRodj = godRodj;
	   			this.godZap = godZap;
	   			
	   	
	   }
	   
	   public Radnik (String ime, String prezime) {
		   
		   this(ime,prezime,1,1);
		   
	   }
	   
       public Radnik (String ime, String prezime, int godRodj) {
    	   
    	   this(ime, prezime,godRodj, 1);
		   
	   }
       
       public Radnik (String ime, int godRodj, int godZap) {
		   this(ime,"Kovic",godRodj,godZap);
    	   
	   }
       
       public void prikaz() {
    	   
    	   System.out.println("Ime radnika je " + ime + " " + prezime + " ,rodjen " + godRodj + ",u firmi zapolen " + godZap);
       }
   }
   
   class Manager extends Radnik {
	   
	   private String titula;
	   
	   public Manager (String ime, String prezime,String titula) {
		   super(ime, prezime);
		   this.titula = titula;
		   
	   }

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		
		this.titula = titula;
	}
	
	public void prikaz2() {
		
		System.out.println("Ime zaposlenog je " + ime +" " + prezime + " one je " + titula);
	}
	   
   }
   
  


	
	
	