package gradebook;

public class Student {
	
	public String studentName;
	public String studentSurname;
	public int grade;

	
	public Student (String studentName, String studentSurname, int grade) {
		
		this.studentName = studentName;
		this.studentSurname = studentSurname;
		this.grade = grade;		
	}
	
	public String getStudentName() {
		return studentName;
	}
	
	public String getStudentSurname() {
		return studentSurname;
	}
	
	public int getGrade() {
		return grade;
	}
}
