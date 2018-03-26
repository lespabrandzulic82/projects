package maths;

public class Child {
	
	private String name;
	private String surname;
	private String date;
	private int taskId;
	private double taskResult;
	private boolean correctAnswer;
	
	public Child(String name, String surname, String date, int taskId, double taskResult, boolean correctAnswer) {
		
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.taskId = taskId;
		this.taskResult = taskResult;
		this.correctAnswer = correctAnswer;
	}
	
	public String getName() {
		return name;		
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getDate() {
		return date;
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public double getTaskResult() {
		return taskResult;
	}
	
	public boolean getCorrectAnswer() {
		return correctAnswer;
	}	

}
