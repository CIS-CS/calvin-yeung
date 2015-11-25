package page095_RandomAccessFile;

import java.io.RandomAccessFile;
import java.io.IOException;
import ibio.IBIO;

/**
 *  A simple example of using a random access file (RAF).
 *  The main() method writes some long's to the RAF, and then uses the seek 
 *  operation to read the long's in reverse order.
 *
 *  @author MHayes
 */
public class SimpleRAF {
    
    public static void main(String[] args) {

        // The file we will use
        RandomAccessFile raf = null;        
        String filename = "c:\\work\\package095.dat";

        // Data to be written to file
        long[] data = {100, 200, 300, 400, 500};

        // Each "record" (long) is 8 bytes wide
        final int RECORD_SIZE = 8;        
        
        try
        {
            // Open the file for R/W. If it does not exist, create it.
            raf = new RandomAccessFile(filename, "rw");
            
            // Write the data to the file at the byte offset
            for (int offset = 0; offset < data.length; offset++)
            {
                raf.writeLong(data[offset]);
            }
            
            // Close the file
            raf.close();
            
            // Open the file. 
            raf = new RandomAccessFile(filename, "rw"); 
            
            // Determine how many "records" are in the file
            long recordCount = raf.length() / RECORD_SIZE;

            // Read the "records", starting with the last record
            for (long recNo = recordCount - 1; recNo >= 0; recNo--)
            {
                raf.seek(recNo * RECORD_SIZE);      // seek
                long record = raf.readLong();       // read
                System.out.println(record);         // display
            }
            
            // Close the file
            raf.close();            
        }
        catch( IOException e)
        {
            IBIO.output("ERROR: " + e);
        }                                         
    }    
}



