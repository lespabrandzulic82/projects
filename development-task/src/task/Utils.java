package task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Utils {
	
	public ArrayList<Test>  ReadFileCSV(String fileName) throws IOException {	
		String line;
		
	    FileReader fileReader = new FileReader(fileName);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);

	    ArrayList<Test> lt = new ArrayList<Test>();
	    
	    while ((line = bufferedReader.readLine()) != null) {
	    	
	        String[] temp = line.split(",");
	        Test test = new Test(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
	    	lt.add(test);
	    }
	    bufferedReader.close();
	    return lt;
	}
	
	public ArrayList<Test>  ReadFileJSON(String fileName) throws IOException, ParseException {	
			ObjectMapper mapper = new ObjectMapper();
			String line;
		  	FileReader fileReader = new FileReader(fileName);
		    BufferedReader bufferedReader = new BufferedReader(fileReader);
		    
		    ArrayList<Test> lt = new ArrayList<Test>();
		    
		    while ((line = bufferedReader.readLine()) != null) {
		    		JsonNode jsonNode = mapper.readTree(line);
		   			String id = jsonNode.get("id").asText();
		   			int quantity = jsonNode.get("quantity").asInt();
		   			double price  = jsonNode.get("price").asDouble();			
			        Test test = new Test(id,quantity,price);
			        lt.add(test);
		    }
		    bufferedReader.close();	
		    return lt;
	}

	
	public void writeFile(String fileName, String textForWrite)  throws IOException {
	    
	    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
	    writer.write(textForWrite);
	    writer.append(fileName);     
	    writer.close();
	}
	
	
	public ArrayList<Test>  ReadFile(String fileName, String type) throws IOException {	
		String line;
		
	    FileReader fileReader = new FileReader(fileName);
	    BufferedReader bufferedReader = new BufferedReader(fileReader);

	    ArrayList<Test> lt = new ArrayList<Test>();
	    
	    
	    if (type.equals("csv")) {
	    while ((line = bufferedReader.readLine()) != null) {
	    	
	        String[] temp = line.split(",");
	        Test test = new Test(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
	    	lt.add(test);
	    	}
	    }
	    else if (type.equals("json"))
	    {
			ObjectMapper mapper = new ObjectMapper();
	    	while ((line = bufferedReader.readLine()) != null) {
	    		JsonNode jsonNode = mapper.readTree(line);
	   			String id = jsonNode.get("id").asText();
	   			int quantity = jsonNode.get("quantity").asInt();
	   			double price  = jsonNode.get("price").asDouble();			
		        Test test = new Test(id,quantity,price);
		        lt.add(test);
		        }		    
	    }
    	
	    bufferedReader.close();
	    return lt;
	}
	
}
