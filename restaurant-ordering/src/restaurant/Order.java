package restaurant;

public class Order {
	
	private int id;
	private int numbTable;
	private int numbPerson;
	private int idMenu;
	 
	public Order (int id,int numbTable, int numbPerson,int idMenu) { 
		this.id = id;
		this.numbTable = numbTable;
		this.numbPerson = numbPerson;			
	}
	
	public int getId() {
		return id;
	}
	
	public int getNumbTable() {
		return numbTable;
	}
	
	public int getNumbPerson() {
		return numbPerson;
	}
	
	public int getIdMenu() {
		return idMenu;
	}
	
	
}
