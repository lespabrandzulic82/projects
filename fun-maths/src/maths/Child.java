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
	
	public void setName(String name) {

		this.name = name; 
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {

		this.surname = surname; 
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {

		this.date = date; 
	}
	
	public int getTaskId() {
		return taskId;
	}
	
	public double getTaskResult() {
		return taskResult;
	}
	
	public boolean getCorrectAnswer() {
		
		return correctAnswer ;
	}
	
	public void setCorrectAnswer(boolean correctAnswer) {
		
		this.correctAnswer = correctAnswer;
	}

	public void setTaskId(int taskId) {

		this.taskId = taskId; 
		
	}
	
	public void setTaskResult(double taskResult) {
		
		this.taskResult = taskResult;
	}

		

}
