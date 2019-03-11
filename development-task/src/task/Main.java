package task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.json.simple.parser.ParseException;

//import thread.Test;
//import thread.Utils;

public class Main{


	public static void main(String[] args) throws IOException, ParseException  {
          
		   BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);

		    ReaderCSVThread readerCSV = new ReaderCSVThread(queue);
		    ReaderJSONThread readerJSON = new ReaderJSONThread(queue);
		    WriterThread writer = new WriterThread(queue);

		    new Thread(readerJSON).start();
		    new Thread(readerCSV).start();
		    /*
		    try 
		    {
		    	new Thread(readerCSV).join();
		    	new Thread(readerJSON).join();
		    	}catch (InterruptedException e) {
		    		
		    }
		    	*/
		    new Thread(writer).start();
		   
	    
	   }
	

				
   }