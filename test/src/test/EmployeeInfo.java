package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmployeeInfo {
	
	private StringBuilder name = new StringBuilder();
	private String code;
	
	private String deptId;
	private Pattern p;
	private Scanner in;
	
	public StringBuilder getName() {
		return name;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getId() {
		return deptId;
	}
	
	private void setName(StringBuilder name){
		if (checkName(name)) {
			this.name = name;
		}
	}
	
	private void createEmployeeCode(StringBuilder name) {
		String tempName = name.toString();
		if (tempName.toString().contains(" ")) {
			code = tempName.substring(0,1) + tempName.split("\\s+")[1];
		}
		else {
			code = tempName;
		}	
	}
	private StringBuilder inputName(Scanner in){	
		 System.out.print("Enter First Name and then Surname!");
	     String tempName = in.nextLine();
		 StringBuilder name = new StringBuilder();
		 name.append(tempName);
		 return name;
	}
	
	private boolean checkName(StringBuilder name) {
		if (name.toString().contains(" ")) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void setDeptId() {
		this.deptId  = getDeptId();		
	}
	
	private String getDeptId() {
		System.out.println("Please enter id: ");
		String tempDeptId  = in.nextLine();
		if (validId(tempDeptId)) {			
			return reverseString(tempDeptId);
		}
		else {
			return "None01";
		}
	}
	
	private boolean validId(String id) {		
		Matcher matcher = p.matcher(id);

		 if (matcher.find()){
			 
	        	return true;
	        }
	        else
	        {
	        	
	        	return false;
	        }
	}

	public EmployeeInfo(){	
		
		in = new Scanner(System.in);
		
		StringBuilder name = inputName(in);
		setName(name);
		createEmployeeCode(name);
		
		// #19	 
		p = Pattern.compile("[A-Z]{1}[a-z]{3}\\d{2}");
		setDeptId();
		in.close();
	}
	
	// #20
	public String reverseString(String id) {
	      if(id.isEmpty()){
	          return id;
	       } else {
	          return reverseString(id.substring(1))+id.charAt(0);
	       }
	}
	
	
}
