package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


	
public class ViewFileInfo {
		
		 public static void main(String[] args) { 
		
		     try {
		
	              File file= new File("C:\\LineTests\\TestResults.txt");
	               Scanner sc = new Scanner(file);
	     	  
	             	while (sc.hasNextLine()) {
	     		
	     		        System.out.println(sc.nextLine());
	     	        }
	     	   sc.close();
	         } catch (FileNotFoundException fnfe  ) { 	  
	   		      System.out.println("file not find");
	         }
	    }	
 }


