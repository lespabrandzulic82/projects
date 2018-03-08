package bankloans;

public class Client {
	
	 // Attributes for Class Client
	
	private String name;
	private String surname;
	private double salary;
	private int age;
	private boolean isMarried;
	private boolean isFullTimeEmployee;
	private int credit;
		
	// Constructor for a Class Client
	
	public Client(String name, String surname, double salary, int age, boolean isMarried, boolean isFullTimeEmployee, int credit) {
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.age = age;
		this.isMarried = isMarried;
		this.isFullTimeEmployee = isFullTimeEmployee;	
		this.credit = credit;
	}
	
	//Method for Class Client
	
	public String getName() {
		return name;		
	}
	
	public String getSurname() {
		return surname;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean isMarried() {
		return isMarried;
	}
	
	public boolean isFullTimeEmployee() {
		return isFullTimeEmployee;
	}
	
	public int getCredit() {
		return credit;
	}

	public int size() {
		
		return 0;
	}
		
}
