package test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.Collections;

public class Main {

	
	public static void main(String[] args) throws IOException{	
		
		AudioPlayer driver = new AudioPlayer("Ipad", "64hz");
		System.out.println(driver.toString());
		
		System.out.println("===========================");
		
		Screen driver1 = new Screen("Resolution",64, 360);
		System.out.println(driver1.toString());
			
		System.out.println("===========================");
		 
		MoviePlayer driver2 = new MoviePlayer("Plazma", "Screen");
		System.out.println(driver2.toString());
		
		System.out.println("===========================");
		
		//#13
		driver.play();
		driver2.play();
	   
		System.out.println("===========================");
		//#14 https://stackoverflow.com/questions/1206073/sorting-a-collection-of-objects*/
		AudioPlayer a1 = new AudioPlayer("Xiomi", "audio specification 1");
		AudioPlayer a2 = new AudioPlayer("Philips", "audio specification 2");
		AudioPlayer a3 = new AudioPlayer("Ipad", "audio specification 3");
		MoviePlayer a4 = new MoviePlayer("Tesla", "LED");
		AudioPlayer a5 = new AudioPlayer("Sony", "audio specification 4");
		ArrayList<Product> listaprodukta = new ArrayList<Product>();
		listaprodukta.add(a1);
		listaprodukta.add(a2);
		listaprodukta.add(a3);
		listaprodukta.add(a4);
		listaprodukta.add(a5);
        
		SortByName comparator = new SortByName();
		Collections.sort(listaprodukta, comparator);		
		
		System.out.println("===========================");
		System.out.println("===========================");
		System.out.println("===========================");
		Product.printType(listaprodukta, "MoviePlayer");
		
		System.out.println("===========================");
		print(listaprodukta);
		
		System.out.println("===========================");
		
		TestProductionLine tpl = new TestProductionLine("product name");
		//System.out.println(tpl.toString());
		
		tpl.writeFiles(listaprodukta);
		System.out.println(tpl.toString());
		
    }


	//#15
	public static void print(ArrayList<Product> listOfPRoducts)
	{
		for(int i=0; i < listOfPRoducts.size();i++) {		
			listOfPRoducts.get(i);
			System.out.println(Item.manufacturer);	
			System.out.println(listOfPRoducts.get(i).name);			
			System.out.println(listOfPRoducts.get(i).serialNumber);	
			System.out.println(listOfPRoducts.get(i).manufacturedOn.toString());		
		}
		
	}	
}
