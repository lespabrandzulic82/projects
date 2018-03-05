package football;

public class Player {
	
	private String name;
	private String surname;
	private int age;
	private String position;
	
	
	public Player(String name, String surname,int age, String position) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.position = position;
	}	
	
	
		public String getName() {
			return name;		
		}
		
		public String getSur() {
			return surname;		
		}
		
		public int getAge() {
			return age;		
		}
		
		public String getPosition() {
			return position;		
		}
}
