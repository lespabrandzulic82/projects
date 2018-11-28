package gradebook;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;

public class File {

    public static void main( String[] args ) throws IOException {
    
    PrintWriter writer = new PrintWriter("gradebook.txt", "UTF-8");
    writer.println("welcome to gradebook");
    writer.println("Mr Spalovic Branko");
    writer.close();
  }

}
