package task;

public class Test {
	
	private String id;
	private int quantity;
	private double price;
	
	public Test(String id, int quantity, double price) {		
		this.id = id;
		this.quantity = quantity;
		this.price = price;		
	}

	public String getid() {
		   return id;
		}
	
	public void setId ( String id ) {
		   this.id = id;
	}  
	
	public int getQantity () {		
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		
		this.quantity = quantity;
	}
	
    public double getPrice () {
		
		return price;
	}
	
	public void setPrice(int price) {
		
		this.price = price;
	}
	
	
	

}
