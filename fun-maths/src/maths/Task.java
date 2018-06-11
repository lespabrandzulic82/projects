package maths;

public class Task {
	
	private int id;
	private String description;
	private double result;
	private int level;
	
	public Task (int id, String description, double result, int level) {
		this.id = id;
		this.description = description;
		this.result = result;
		this.level = level;
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescrption(String description) {
		this.description = description;
	}
	
	public double getResult() {
		return result;
	}
	
	public void setResult(double result) {
		this.result = result;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}
