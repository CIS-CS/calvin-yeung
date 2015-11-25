// VideoStoreS.java

package page090_ObjectSerialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import original.IBIO;

/**
 *  Object serialization:
 *  An array of VideoTapeS objects is read from a sequential file, in one go.
 *  Use a FileInputStream + ObjectInputStream to read the array.
 *
 *  The VideoTapeS objects are stored in an array.
 *  Each VideoTapeS object is Serializable. Even the array itself is
 *
 *  The array of VideoTapeS objects is written to the sequential file, in one go.
 *  Uses a FileOutputStream + ObjectOutputStream to write the array.
 *
 *  @author Richard 
 *  @version 210903
 */
public class VideoStoreS
{
    static final String FILENAME = "c:\\videos-serialized.dat";
    static final int MAX_VIDEOS = 5;
    private VideoTapeS[] videoTapes = new VideoTapeS[MAX_VIDEOS];
    private int numVideos = 0;  // number of videos currently in the array
    
    public static void main(String[] args)
    {
        // Create an instance of ourself
        VideoStoreS store = new VideoStoreS();
        
        if (store.checkForFile())
        {
            IBIO.output("\nData file located: " + store.numVideos + " records found.\n");
        }
        else
        {
            IBIO.output("Data file not found\n");
        }
        // Loop here until the user selects 'q' to quit.
        char command;
        do
        {
            command = store.getCommand();
            store.doCommand(command);
        }
        while (command != 'q');
    }
        
    /**
     *  Read an array of VideoTapeS objects from the file, if file exists.
     *
     * @return boolean  true if there is an existing file
     */
    private boolean checkForFile()
    {
        // See if a file already exists
        try
        {
            // Create a stream for reading in objects
            FileInputStream theFileID = new FileInputStream(FILENAME);
            ObjectInputStream inFile  = new ObjectInputStream(theFileID);
            
            // Read all the objects in one go, and put them in the array
            videoTapes = (VideoTapeS[]) inFile.readObject();
            
            // Close the stream
            inFile.close();
            
            // get the number of non-null entries
            int x = 0;
            boolean last = false;
            while ( (x < MAX_VIDEOS) && !(last) )
            {
                if (videoTapes[x] != null)
                {
                    x = x + 1;
                }
                else
                {
                    last = true;
                }
            }
            numVideos = x;
            return true;
        }
        catch( IOException io)
        {
            IBIO.output("Error trying to open file " + io.getMessage());
        }
        catch( ClassNotFoundException cnf)
        {
            IBIO.output("Error trying to open file " + cnf.getMessage());
        }
        return false;
    }
    
    /**
     *  Prompt the user for a command.
     *
     *  @return char, a valid command - either (a) add, (l) list or (q) quit
     */
    private char getCommand()
    {
        String input;     // input from the user
        char command;   
        
        // repeat until a valid command is entered
        do
        {
            IBIO.output("");
            IBIO.output("Would you like to: ");
            IBIO.output("     (a)   add a video tape to the collection");
            IBIO.output("     (l)   list the tapes already in the collection");
            IBIO.output("     (s)   save the tapes to a data file");
            IBIO.output("     (q)   or quit the program");
            IBIO.output("");
            input = IBIO.input("Your choice (a/l/s/q): ");
            
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
                if ((command != 'a') && (command != 'q') 
                                     && (command != 'l')  
                                     && (command != 's') )
                {
                    IBIO.output("Please enter a valid command (a, l, s or q)!");
                    command = 'n';
                }
            }
        } while (command == 'n');
        return command;
    }
    
    /**
     *  Run the command that the user selected.
     *
     *  @param command char - the command to be carried out by this method
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
        else if (command == 's')
        {
            save();
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
     *  Prompt user for a video and add it to the array of VideoTapeS objects.
     */
    private void add()
    {
        // see how many videos are in the collection:
        if (numVideos >= MAX_VIDEOS)
        {
            IBIO.output("Sorry, no more videos can be stored");
        }
        else
        {
            // Prompt user for details. Get an object back.
            videoTapes[numVideos] = getVideoDetails();
            numVideos = numVideos + 1;
        }
    }
    
    /**
     *  Display the videos that are in the array.
     */
    private void list()
    {
        // loop through array
        for(int x = 0; x < numVideos; x = x + 1)
        {
            IBIO.output("" + x + ": " + videoTapes[x].toString());
        }
    }
    
    /**
     *  Write the array of videos to the file.  
     *  The entire array is written as a single object.
     */
    private void save()
    {
        FileOutputStream theFileID;
        ObjectOutputStream outFile;
        
        try
        {
            // Create the output stream
            theFileID = new FileOutputStream(FILENAME);
            outFile   = new ObjectOutputStream(theFileID);
            
            // Write the array to the file
            outFile.writeObject(videoTapes);
            
            // Close the file
            outFile.close();
        }
        catch (IOException io)
        {
            IBIO.output("Error writing to data file: " + io.getMessage());
        }
    }
    
    /**
     * quit the program message
     */
    private void quit()
    {
        IBIO.output("Good Bye.");
    }
    
    /**
     * Method to get details of tape
     *
     *@return VideoTapeS - a video tape serializable object (well, how neat!)
     */
    private VideoTapeS getVideoDetails()
    {
        String title = IBIO.input("Please enter the title of your video: ");
        int length = IBIO.inputInt("Please enter the length in minutes: ");
        // We assume it is not yet lent
        return new VideoTapeS(title, length, false);
    }
}