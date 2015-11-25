// VideoStoreRandom.java

package page095_RandomAccessFile;

import original.IBIO;
import java.io.*;

/**
 *  File I/0: Random Access 
 *  Store VideoTape objects in a random access file.
 *  Records are not in any sequence; new records are added at the end.
 *
 *  @author Richard (improved by MHayes)
 *  @version Apr 2008
 */
public class VideoStore
{
    //--------------------------------------------- Instance variables
    private Persister persister = null;
    private int numVideos = 0;          //  number of videos in the file

    /**
     * Constructor tries to create the Persister. If it fails, the application
     * is aborted.
     */
    public VideoStore()
    {
        try
        {
            // Create persister and open the RAF
            persister = new Persister();

            // Calculate the number of records in the RAF
            numVideos = (int)(persister.getFileLength() / VideoTape.RECORD_SIZE);
        }
        catch(IOException e)
        {
            System.out.println("ERROR: Unable to create Persister: " + e);
            System.exit(0);
        }        
    }
    
    /**
     * Entry point to the application.
     */
    public static void main(String[] args)
    {
        VideoStore store = new VideoStore();
        
        IBIO.output("\nData file = " + store.persister.getFileName() + ",  " +
                    store.numVideos + " records in file.\n");
        
        char command;
        do
        {
            command = store.getCommand();
            store.doCommand(command);
        }
        while (command != 'q');
    }   

    /**
     * Method to get a valid command from the user
     * @return char, a valid command - either (a) add, (l) list or (q) quit
     */
    private char getCommand()
    {
        String input;       // input from the user
        char command;       // input commmand as a char
        
        // repeat until a valid command is entered
        do
        {
            IBIO.output("");
            IBIO.output("Would you like to: ");
            IBIO.output("     (a)   add a video tape to the collection");
            IBIO.output("     (l)   list the tapes already in the collection");
            IBIO.output("     (q)   or quit the program");
            IBIO.output("");
            input = IBIO.input("Your choice (a/l/q): ");
            
            // check if anything was input
            if (input.length() == 0)
            {
                IBIO.output("Please enter a command!");
                command = 'n';
            }
            else
            {
                // check if the value input was a valid command
                command = input.charAt(0);
                if ((command != 'a') && (command != 'q') && (command != 'l'))
                {
                    IBIO.output("Please enter a valid command (a, l or q)!");
                    command = 'n';
                }
            }
        } while (command == 'n');
        
        return command;
    }
    
    /**
     * 	Method to carry out requested operations
     *
     *	@param command char - the command to be carried out by this method
     */
    private void doCommand(char command)
    {
        // Uses an else if chain...
        // A more elegant way would be to use a switch statement
        
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
    }
    
    /**
     * 	Add a VideoTape object to the end of the file.
     */
    private void add()
    {
        try
        {
            VideoTape video = getVideoDetails();            
            long positionToAdd = numVideos * VideoTape.RECORD_SIZE;
            
            persister.writeRecord(video, positionToAdd);            
            numVideos = numVideos + 1;
        }
        catch(IOException e)
        {
            IBIO.output("Error adding record: " + e.getMessage());
        }
    }
    
    /**
     * 	Display the VideoTape objects that are in the file.
     */
    private void list()
    {
        try
        {
            // Loop through datafile
            for(int i = 0; i < numVideos; i++)
            {
                long positionToRead = i * VideoTape.RECORD_SIZE;
                VideoTape video = persister.readRecord(positionToRead);
                IBIO.output(i + ": " + video.toString());
            }
        }
        catch(IOException io)
        {
            IBIO.output("Error during read: " + io.getMessage());
        }
    }
    
    /**
     * Closes the file and says good bye.
     * Program stops in the main() method.
     */
    private void quit()
    {
        try
        {
            persister.closeFile();
        }
        catch(IOException io)
        {
            IBIO.output("Some error closing data file:  " + io.getMessage());
        }
        finally
        {
            IBIO.output("Good Bye.");
        }
    }
    
    /**
     * 	Prompt the user for tape details. Create a VideoTape object.
     *	@return	A VideoTape object with Lent set to false.
     */
    private VideoTape getVideoDetails()
    {
        String title = IBIO.input("Enter the title of your video: ");
        int length   = IBIO.inputInt("Enter the length in minutes: ");

        // Note, the default value for Lent is false
        return(new VideoTape(title, length, false));
    }
}