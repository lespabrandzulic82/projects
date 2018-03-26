package restaurant;

public class Order {
	
	private int numbTable;
	private int numbPerson;
	private String pizza;
	private String pasta;
	private String dessert;
	private String drink;
	 
	public Order (int numbTable ,int numbPerson,String pizza, String pasta, String dessert, String drink) { 
		this.numbTable = numbTable;
		this.numbPerson = numbPerson;
		this.pizza = pizza;
		this.pasta = pasta;
		this.dessert = dessert;
		this.drink = drink;
		
	}
	
	public int getNumbTable() {
		return numbTable;
	}
	
	public int getNumbPerson() {
		return numbPerson;
	}
	
	public String getPizza() {
		return pizza;
	}
	
	public String getPasta() {
		return pasta;
	}
	
	public String getDessert() {
		return dessert;
	}
	
	public String getDrink() {
		return drink;
	}

}
