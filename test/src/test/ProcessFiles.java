package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
//import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ProcessFiles {
	
	private Path p;
	private Path p2;
	private Path p3;
	
	public ProcessFiles() throws IOException{
		this.p = Paths.get("c:\\LineTests");
		this.p2 = Paths.get("TestResults.txt");
		this.p3 = Paths.get(p.toString(), p2.toString());		
		CreateDirectory();
	}
	
	private void CreateDirectory() {
		//create directory
	    File directory = new File(p.toString());
	    if (!directory.exists()){
	        directory.mkdir();
	    }	
	}
	
	public void WriteFile(EmployeeInfo emp) throws IOException{
	    File file = new File(p3.toString());
	    if (!file.exists()){
	    	file.createNewFile();
	    }		    
	    BufferedWriter writer = new BufferedWriter(new FileWriter(p3.toString(),true));
	    writer.write(emp.toString());
	    writer.close();	    
	}	
	
	public void WriteFile(ArrayList<Product> products) throws IOException{
	    File file = new File(p3.toString());
	    if (!file.exists()){
	    	file.createNewFile();
	    }
		
	    BufferedWriter writer = new BufferedWriter(new FileWriter(p3.toString(),true));
	    for (int i=0; i< products.size(); i++)
	    {
	    	Product p = products.get(i);
		    writer.write(p.toString());
	    }  
	    writer.close();	
	}
	
}
