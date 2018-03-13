package selector;

public class Player {
	
	private String name;
	private String surname;
	private int height;
	private int age;
	private double points;
	private double assistances;
	private int jumps;
	private int position;
		
	public Player(String name, String surname, int height, int age, double points, double assistances, int jumps, int position) {
		this.name = name;
		this.surname = surname;
		this.height = height;
		this.age = age;
		this.points = points;
		this.assistances = assistances;
		this.jumps = jumps;
		this.position = position;
	}
		
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getAge() {
		return age;
	}
	
	public double getPoints() {
		return points;
	}
	
	public double getAssistances() {
		return assistances;
	}
	
	public int getJumps() {
		return jumps;
	}
	
	public int getPosition() {
		return position;
	}
}
