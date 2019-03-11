package item;

import java.sql.Date;
import java.lang.*;
import java.sql.Date;

public interface Item {
	
	final static String manufacturer = "Production";
	 
	public void setProductionNumber(int productNumber);
	 
    public void setName(String name);
    
    public String getName();
    
     public Date getManufactureDate();
	 	 
     public int getSerialNumber();
     
 

}


