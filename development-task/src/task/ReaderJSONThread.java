package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReaderJSONThread implements Runnable{

  protected BlockingQueue<String> blockingQueue = null;
   int time;//
   
  public ReaderJSONThread(BlockingQueue<String> blockingQueue,int time){
    this.blockingQueue = blockingQueue; 
    this.time = time;
  }

  @Override
  public void run() {
    BufferedReader br = null;
     try {
            br = new BufferedReader(new FileReader(new File("C:\\LineTests\\inputB.json")));
           ObjectMapper mapper = new ObjectMapper();
            String buffer =null;
            
            while((buffer=br.readLine())!=null){
    	    		JsonNode jsonNode = mapper.readTree(buffer);
    	   			String id = jsonNode.get("id").asText();
    	   			int quantity = jsonNode.get("quantity").asInt();
    	   			double price  = jsonNode.get("price").asDouble();	        	
                blockingQueue.put("\"InputB\","  + id + "," + quantity + "," + price);
                Thread.sleep(time); //
            }
            //blockingQueue.put("EOF"); //kraj fajla

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch(InterruptedException e){

        }finally{
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


  }



}