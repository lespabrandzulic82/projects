package task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class ReaderCSVThread implements Runnable{

  protected BlockingQueue<String> blockingQueue = null;
  int time;
  public ReaderCSVThread(BlockingQueue<String> blockingQueue,int time){
    this.blockingQueue = blockingQueue;
    this.time = time;
  }

  @Override
  public void run() {
    BufferedReader br = null;
     try {
            br = new BufferedReader(new FileReader(new File("C:\\LineTests\\inputA.csv")));
            String buffer =null;
    	    ArrayList<Test> lista = new ArrayList<Test>();

            while((buffer=br.readLine())!=null){
            	String[] temp = buffer.split(",");
    	        Test test = new Test(temp[0], Integer.parseInt(temp[1]), Double.parseDouble(temp[2]));
    	        lista.add(test);
                blockingQueue.put("\"InputA\"," + buffer);
                Thread.sleep(time);
            }
            

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