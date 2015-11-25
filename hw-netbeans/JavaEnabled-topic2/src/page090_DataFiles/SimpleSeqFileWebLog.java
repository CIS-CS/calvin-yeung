/*
 * SimpleSeqFileWebLog.java
 * Reads weblog.txt which contains YYYY-MM-DD-HH-MM timestamps.
 * Adds an HTTP access code to each record.
 * Writes the data to weblog2.txt
 * See Ex 4.59 in Objects First 3rd Ed
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

/**
 * Writes and reads a sequential file.
 * @author MHayes
 * @version May 2008
 */
public class SimpleSeqFileWebLog {
    
    /**
     *  @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[] accessCodes = {200, 403, 404};
        
        String inputFile  = "c:\\weblog.txt";
        String outputFile = "c:\\weblog2.txt";

        FileReader fr = null;                // To read weblog.txt
        BufferedReader inFile = null;

        FileWriter fw = null;                // To write weblog2.txt
        PrintWriter outFile = null;               
        
        try {
            // Open weblog.txt (input file)
            fr = new FileReader(inputFile);
            inFile = new BufferedReader(fr);

            // Open weblog2.txt (output file)
            fw = new FileWriter(outputFile, true);
            outFile = new PrintWriter(fw);

            // Read weblog.txt, append code, write to weblog2.txt
            String record = inFile.readLine();
            while (record != null)
            {
                int codeNo = (int)(Math.random() * 3);
                record = record + " " + accessCodes[codeNo];
                outFile.println(record);
                record = inFile.readLine();
            }
            // Close the files
            inFile.close();
            outFile.close();
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



