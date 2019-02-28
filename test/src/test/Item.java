package test;

import java.util.Date;

public interface Item {

	public static final String manufacturer = "Production";
	
	public void setProductionNumber(int productNumber);
	 
    public void setName(String name);
    
    public String getName();
    
     public Date getManufactureDate();
	 	 
     public int getSerialNumber();
}
