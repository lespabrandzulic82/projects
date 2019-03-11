package console;

import java.util.HashMap;
import java.util.Scanner;

public class Product {
	
	private String productName;
	private String productType;
	int productQuantity;
	
	
	public Product(String productName, String productType, int productQuantity){
		this.productName= productName;
		this.productType = productType;
		this.productQuantity = productQuantity;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName= productName;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType= productType;
	}
	
	public int getProductQuantity() {
		return productQuantity;
	}
	
	public void setProductName(int productQuantity) {
		this.productQuantity= productQuantity;
	}
	
	public static HashMap<Integer, String> products = new HashMap<Integer, String>();
}
