package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;

public class WriterThread implements Runnable{

  protected BlockingQueue<String> blockingQueue = null;

  public WriterThread(BlockingQueue<String> blockingQueue){
    this.blockingQueue = blockingQueue;     
  }

  @Override
  public void run() {
    PrintWriter writer = null;

    try {
        writer = new PrintWriter(new File("C:\\LineTests\\output.txt"));

        while(true){
            String buffer = blockingQueue.take();
            
            if( !Main.isProducerAlive()){ 
                break;
            }
            writer.println(buffer);
        }               


    } catch (FileNotFoundException e) {

        e.printStackTrace();
    } catch(InterruptedException e){

    }finally{
        writer.close();
    } 

  }

}
