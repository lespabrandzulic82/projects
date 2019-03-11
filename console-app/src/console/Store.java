package console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Store {

	static ArrayList<Product> listOfProducts = new ArrayList<Product>();
	
	public Store() {
	}
	
	public static void  addProduct () {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please type product Type!");
		String productType = scanner.next();
		System.out.println("Please type product Name!");
		String productName = scanner.next();
		System.out.println("Please type product quantity!");
		int productQuantity = scanner.nextInt();
		//scanner.close();
		Product p = new Product(productName, productType, productQuantity);
		listOfProducts.add(p);
	}
	
	
	public static void showProducts()
	{
		 for(int i=0; i< listOfProducts.size(); i++) {
			 Product p = listOfProducts.get(i);			 
			 System.out.println("Product name: " + p.getProductName() + " Product type:" + p.getProductType() + " quantity: " + p.getProductQuantity());
		 }
	}
	
	public static void showProductsOfSpecificType(String productType)
	{
		if(listOfProducts.size() > 0) {
			 System.out.println("List of " + productType + " products");
		}
		
		 for(int i=0; i< listOfProducts.size(); i++) {
			 
			 Product p = listOfProducts.get(i);		
			 if (p.getProductType().equals(productType)) {
			 System.out.println("Product name: " + p.getProductName() + " Product type:" + p.getProductType() + " quantity: " + p.getProductQuantity());
		 }
	 }
	}
	
	public static Integer getProductTotal()
	{
		int number= 0;
		 for(int i=0; i< listOfProducts.size(); i++) {
			 
			 Product p = listOfProducts.get(i);		
			 number += p.getProductQuantity();
		 }
		// System.out.println("Total number of products is: " + number);
		 return number;
	}
	
	public static void getProductNumberPerType()
	{
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		
		 for(int i=0; i< listOfProducts.size(); i++) {
			 
			 Product p = listOfProducts.get(i);		
			 
			 if(hash.containsKey(p.getProductType())){
				hash.put(p.getProductType(), hash.get(p.getProductType()) + p.getProductQuantity());	
			}
			 else {
				 hash.put(p.getProductType(), p.getProductQuantity());				 
			 }
				 
		}
		 
		 for (HashMap.Entry<String, Integer> entry : hash.entrySet()) {
			    System.out.println("Product type = " + entry.getKey() + ", Number of products: = " + entry.getValue());
		 }
	}
	
	
	public static void getProductNamePerQuantity(Integer requestedQuantity){
	
		 for(int i=0; i< listOfProducts.size(); i++) {			 
			 Product p = listOfProducts.get(i);		
			 
			 if(p.getProductQuantity() == requestedQuantity){
				 System.out.println(p.getProductName());
			 }				 
		}
	}
	
	
	
}
