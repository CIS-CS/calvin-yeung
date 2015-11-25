/*
 * SimpleSeqFile.java
 *
 * Created on May 21, 2008, 1:44 PM
 */
package page090_DataFiles;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;        
import java.io.IOException;
import java.io.FileNotFoundException;
import ibio.IBIO;
import java.util.StringTokenizer;

/**
 * Writes and reads a sequential file.
 * @author MHayes
 * @version May 2008
 */
public class SimpleSeqFileTokenizer {
    
    /**
     *  @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String filename = "h:\\test.txt";
               
        FileWriter fw = null;              // For writing to the file.
        PrintWriter outFile = null;
               
        FileReader fr = null;                // For reading from the file.
        BufferedReader inFile = null;
        
        // Prompt the user for their name
        String name = IBIO.input("What is your name? ");
        String age  = IBIO.input("What is your age? ");
        String city = IBIO.input("What is your city? ");

        // Open the file in append mode. (creates a new one if it does not exist.)
        try {
            fw = new FileWriter(filename, true);        // IOException?

            outFile = new PrintWriter(fw);

            // Write the data to the file
            outFile.println(name + "#" + age + "#" +city);

            // Close the file.
            outFile.close();
        }
        catch (IOException e) {
            IBIO.output("Error opening file for writing: " + e);
            System.exit(0);
        }
        
        // Read the file        
        try {
            // Open the file to read it.
            fr = new FileReader(filename);      
            
            // Create a buffered reader
            inFile = new BufferedReader(fr);
            
            // Read the data. EOF (end of file) is indicated by null.
            String record = "";
            record = inFile.readLine();        // Read the first record 
            while (record != null)
            {
                StringTokenizer st = new StringTokenizer(record, "#");
                System.out.println("Your name is: " + st.nextToken());
                System.out.println("Your age is:  " + st.nextToken());
                System.out.println("Your city is: " + st.nextToken());
                record = inFile.readLine();    // Read the next record
            } 
            
            // Close the file
            inFile.close();                     
        }
        catch (FileNotFoundException e) {
            // Opening the file may cause this error.
            IBIO.output("Error opening file for reading: " + e);
            System.exit(0);            
        }
        catch (IOException e) {
            // Reading or closing may cause this error.
            IBIO.output("Error reading or closing file: " + e);
            System.exit(0);            
        }                                  
    }    
}



