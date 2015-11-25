// VideoStoreRandom.java

package page095_RandomAccessFile;

import original.IBIO;
import java.io.*;

/**
 *  File I/0: Random Access 
 *  Store VideoTapeFile objects in a random access file.
 *  Uses methods of the RandomAccessFile class to manipulate the file.
 *
 *  @author Richard
 *  @version 210903
 */
public class VideoStoreRandom
{
    private RandomAccessFile theFile;
    static final String FILENAME = "c:\\work\\videos-random.dat";
    private int numVideos = 0;			//  The number of videos in the file.

    public static void main(String[] args)
    {
        VideoStoreRandom store = new VideoStoreRandom();
        
        if (store.checkForFile())
        {
            IBIO.output("Data file located. " + store.numVideos + " records found.\n");
        }
        else
        {
            IBIO.output("No data file found, starting new collection\n");
        }
        
        char command;
        do
        {
            command = store.getCommand();
            store.doCommand(command);
        }
        while (command != 'q');
    }
    
    /**
     * Method to check for existing file
     *
     * @return boolean true if there is an existing file
     */
    private boolean checkForFile()
    {
        // See if a file already exists
        try
        {
            theFile = new RandomAccessFile(FILENAME, "rw");
            numVideos = (int) theFile.length() / VideoTapeFile.length();
            return true;
        }
        catch(IOException io)
        {
            IBIO.output("Error trying to open file " + io.getMessage());
        }
        return false;
    }

    /**
     * Method to get a valid command from the user
     *
     * @return char, a valid command - either (a) add, (l) list or (q) quit
     */
    private char getCommand()
    {
        String cs; // input command as a String
        char ch;   // input commmand as a char
        
        // repeat until a valid command is entered
        do
        {
            IBIO.output("");
            IBIO.output("Would you like to: ");
            IBIO.output("     (a)   add a video tape to the collection");
            IBIO.output("     (l)   list the tapes already in the collection");
            IBIO.output("     (q)   or quit the program");
            IBIO.output("");
            cs = IBIO.input("Your choice (a/l/s/q): ");
            
            // check if anything was input
            if (cs.length() == 0)
            {
                IBIO.output("Please enter a command!");
                ch = 'n';
            }
            else
            {
                // check if the value input was a valid command
                ch = cs.charAt(0);
                if ( (ch != 'a') && (ch != 'q') && (ch != 'l') )
                {
                    IBIO.output("Please enter a valid command (a, l or q)!");
                    ch = 'n';
                }
            }
        } while (ch == 'n');
        
        return ch;
    }
    
    /**
     * 	Method to carry out requested operations
     *
     *	@param command char - the command to be carried out by this method
     */
    private void doCommand(char command)
    {
        // using an else if chain...
        
        if (command == 'a')
        {
            add();
        }
        else if (command == 'l')
        {
            list();
        }
        else if (command == 'q')
        {
            quit();
        }
        else
        {
            IBIO.output("Some internal error in doCommand()");
        }
    }
    
    /**
     * 	Add a VideoTapeFile object to the file
     */
    private void add()
    {
        try
        {
            VideoTapeFile theVideo = getVideoDetails();
            
            long posToAdd = numVideos * VideoTapeFile.length();
            
            VideoTapeFile.writeRecord(theFile, theVideo, posToAdd);
            
            numVideos = numVideos + 1;
        }
        catch(IOException io)
        {
            IBIO.output("Error adding record " + io.getMessage());
        }
    }
    
    /**
     * 	Display the VideoTapeFile objects that are in the file
     */
    private void list()
    {
        try
        {
            // loop through datafile
            for(int x = 0; x < numVideos; x = x + 1)
            {
                int posToRead = x * VideoTapeFile.length();
                IBIO.output(x + ": " + VideoTapeFile.readRecord(theFile, posToRead).toString());
            }
        }
        catch(IOException io)
        {
            IBIO.output("Error during read - " + io.getMessage());
        }
    }
    
    /**
     * 	quit the program
     */
    private void quit()
    {
        try
        {
            theFile.close();
        }
        catch(IOException io)
        {
            IBIO.output("Some error closing data file -  " + io.getMessage());
        }
        finally
        {
            IBIO.output("Bye then");
        }
    }
    
    /**
     * 	Prompt the user for tape details. Create a VideoTapeFile object.
     *
     *	@return	VideoTapeFile	A new VideoTapeFile object
     */
    private VideoTapeFile getVideoDetails()
    {
        String title = IBIO.input("Please enter the title of your video: ");
        int length = IBIO.inputInt("Please enter the length in minutes: ");
        
        return new VideoTapeFile(title, length, false);
    }
}