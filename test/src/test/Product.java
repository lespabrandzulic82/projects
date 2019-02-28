/**
 * 
 */
package test;

import java.util.ArrayList;
import java.util.Date;


public abstract class Product implements Item {

	int serialNumber;
	Date manufacturedOn;
	String name;
	public static Integer currentProductionNumber = 0;
	
	public Product(String name) {
		this.name = name;
		
		currentProductionNumber++ ;
		serialNumber = currentProductionNumber;
		manufacturedOn = new Date();
	}
	
	@Override
	public void setProductionNumber(int productNumber) {
		
	}

	
	@Override
	public void setName(String name) {
		
	}

	
	@Override
	public String getName() {
	
		return null;
	}

	
	@Override
	public Date getManufactureDate() {
		
		return null;
	}

	
	@Override
	public int getSerialNumber() {
		
		return 0;
	}

	public String toString() {
		return "Manufacturer: " + manufacturer + "\n" + "Serial Number: " + serialNumber + "\n" + "Date: " + manufacturedOn.toString() + "\n" + "Name: " + name;		
	}
	
	//#17
	public static void printType(ArrayList<Product> listOfProduct, String productType) {
		
	  for(int i = 0; i < listOfProduct.size(); i++) {
		  
		  Product item = listOfProduct.get(i);
		  if (item.getClass().getName().equals("test."+productType))
		  {
			  
			  System.out.println(item.name + " Serial number: " + item.serialNumber);
		  }
	  }
	}
}

