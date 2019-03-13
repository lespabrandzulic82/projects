package task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.json.simple.parser.ParseException;

//import thread.Test;
//import thread.Utils;

public class Main{

    private static ArrayList<Thread> allThreadCollection;
	public static void main(String[] args) throws IOException, ParseException  {
          
		   BlockingQueue<String> queue = new ArrayBlockingQueue<String>(2);
           allThreadCollection = new ArrayList<Thread>();
		   // ReaderCSVThread readerCSV = new ReaderCSVThread(queue);
		   // ReaderJSONThread readerJSON = new ReaderJSONThread(queue);
		    WriterThread writer = new WriterThread(queue);

		    		    
		    Thread csvA = new Thread(new ReaderCSVThread(queue,3));
		    Thread jsonB = new Thread(new ReaderJSONThread(queue,5));
		   // new Thread(readerJSON).start();
		   // new Thread(readerCSV).start();
		   allThreadCollection.add(csvA);
		   allThreadCollection.add(jsonB);
		   
		   csvA.start();
		   jsonB.start();
		    	
		    new Thread(writer).start();
	}
	
	 public static boolean isProducerAlive() {
		 
		 for(Thread t : allThreadCollection) {
			 if(t.isAlive()) 
				 
			  return true;
		 } 
			  return false;
	 }	  
	 
}
	

				
  