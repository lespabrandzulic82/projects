package item;

import java.sql.Date;
//import java.text.SimpleDateFormat;

public abstract class Product implements Item {
	
	 int serialNumber;
	 String manufacturer;
	 Date manufacuredOn;
	 String name;
 
	// int currentProductionNumber = new Int(serialNumber);

	 int productNumber;
	 
	 public void setProductionNumber(int productNumber) {
		 this.productNumber = productNumber;
	 }
	 
	 public void setName(String name) {
	 	this.name = name;
	 }
	 
	 public String getName() {
		 return name;
		 
	 }
	 
	 public Date getManufactureDate() {
		 
		 //SimpleDateFormat now = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
	      // dow mon dd hh:mm:ss zzz yyyy
		return manufacuredOn;
	 }
	 
	 public int getSerialNumber(){
		 
		 serialNumber++;
		 return serialNumber;
	 }
	 
	 public Product() {
		 
	 }
}


	
