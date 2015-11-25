package page109_StringManipulation;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *  Writes some data to a sequential file.
 *  Reads each record from the file and displays the tokens of each record.
 **/
public class FileTokenizer {

    public static void main(String[] args) {
        
        // The name of the file. Note the double backslashes.
        String FILENAME   = "c:\\work\\test.txt";
        
        try {
            // create a PrintWriter for writing to the file
            FileWriter fw = new FileWriter(FILENAME);
            PrintWriter outFile = new PrintWriter(fw);
        
            // write a string to the file.            
            outFile.println("Name Address City Country CountryCode");
            
            // close the file
            outFile.close(); 
            
            // create a BufferedReader to read data from the file
            FileReader fr = new FileReader(FILENAME);
            BufferedReader inFile = new BufferedReader(fr);
            
            // read a line from the file
            String record = inFile.readLine();
            
            // display the whole record
            System.out.println(record);
            
            // here we seperate the individual fields from the record
            StringTokenizer st = new StringTokenizer(record, " ");
            while (st.hasMoreTokens()) {
                System.out.println(st.nextToken());
            }

            // close the file again
            inFile.close();            
        }
        catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
