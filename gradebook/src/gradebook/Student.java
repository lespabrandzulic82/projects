package gradebook;

public class Student {
	
	public String studentNumber;
	public String studentName;
	public String studentSurname;
	public int grade;

	
	public Student (String studentNumber, String studentName, String studentSurname, int grade) {
		
		this.studentNumber= studentNumber;
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.grade = grade;		
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
		
	public String getStudentSurname() {
		return studentSurname;
	}

	public void setStudentSurname(String studentSurname) {
		this.studentSurname = studentSurname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	

	
	
}
