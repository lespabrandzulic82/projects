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
	
	public void setName(String name) {

		this.name = name; 
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {

		this.surname = surname; 
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		
		this.age = age;
	}
	
	public boolean isMarried() {
		return isMarried;
	}
	
	public void setIsMarried(boolean isMarried) {
		
		this.isMarried = isMarried;
	}
	
	public boolean isFullTimeEmployee() {
		return isFullTimeEmployee;
	}
	
	public void setIsFullTimeEmployee(boolean isFullTimeEmployee) {
		
		this.isFullTimeEmployee = isFullTimeEmployee;
	}
	
	public int getCredit() {
		return credit;
	}
	
	public void setCredit(int credit) {
		
		this.credit = credit;
	}

	public int size() {
		
		return 0;
	}
		
}
