package test;

import java.io.IOException;
import java.util.ArrayList;

public class TestProductionLine extends Product{
	
	EmployeeInfo employee = new EmployeeInfo();
	
	public TestProductionLine(String name) {
		super(name);
		
	}
	
	@Override
	public String toString() {
	
		String output = super.toString();		
			
		return output + "\nEmployee code: " + employee.getCode() +  "\nEmpolyee deptID: " + employee.getId();
	}
	
	public void writeFiles(ArrayList<Product> listOfProducts) throws IOException {		
		ProcessFiles pf = new ProcessFiles();
		pf.WriteFile(listOfProducts);	
		pf.WriteFile(employee);
	}
	
}
