// VideoStore2.java

package page090_DataFiles;

import ibio.IBIO;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *  Sequential File I/O:
 *  Read VideoTape objects from a file, store them in an array, save them back to the file.
 *
 *  Uses a BufferedReader to read the file.
 *  Uses a PrintWriter to write to the file.
 *
 *  @author Richard
 *  @version 200903
 */
public class VideoStore
{
    private static final int    MAX_VIDEOS = 5;                            // Max size of videoTapes
    private static final String FILENAME   = "c:\\work\\video-tapes.txt";  // Output file

    private VideoTape[] videoTapes = new VideoTape[MAX_VIDEOS];    // Store the videos here
    private int         numVideos   = 0;                           // number of videos in collection

    /**
     *  Loop until user types 'q' to quit
     */
    public static void main(String[] args)
    {
        char command;
        VideoStore store = new VideoStore();

        // Display banner
        IBIO.output("VideoStore v1.0\n");

        // Read the data file
        if (store.checkForFile())
        {
            IBIO.output(FILENAME + " located. " + store.numVideos + " records found.\n");
        }
        else
        {
            IBIO.output("Warning: " + FILENAME + " not found.\n");
        }

        // Run commands until user quits
        do
        {
            command = store.getCommand();
            store.doCommand(command);
        }
        while (command != 'q');
    }

    /**
     *  Prompt the user for a command
     *
     *  @return char, a valid command - either (a) add, (d) delete, (l) list or (q) quit
     */
    public char getCommand()
    {
        String cs; // input command as a String
        char ch;   // input commmand as a char
        String commands = "adlsq";

        // repeat until a valid command is entered
        do
        {
            IBIO.output("");
            IBIO.output("What would you like to: ");
            IBIO.output("     (a)   add a video tape to the collection");
            IBIO.output("     (d)   delete a video from the collection");
            IBIO.output("     (l)   list the tapes already in the collection");
            IBIO.output("     (s)   save the tapes to " + FILENAME);
            IBIO.output("     (q)   or quit the program");
            IBIO.output("");
            cs = IBIO.input("Your choice (a/d/l/s/q): ");

            // check if anything was input
            if (cs.length() == 0)
            {
                IBIO.output("Please enter a command!");
                ch = 'n';
            }
            else
            {
                // check if the value input was a valid command                
                //if ( (ch != 'a') && (ch != 'd') && (ch != 'l') && (ch != 's') && (ch != 'q'))
                // Instead of using the above if statement, we can simply check to see
                // if the command entered is in the list of commands.
                if (commands.indexOf(cs) == -1)
                {
                    IBIO.output("Please enter a valid command (a, d, l, s or q)!");
                    ch = 'n';
                }
                else
                {
                    ch = cs.charAt(0);      // user entered a valid command
                }
            }
        }
        while (ch == 'n');

        return ch;
    }

    /**
     *  Executes the user's command
     *
     *  @param command char - the command to be carried out by this method
     */
    public void doCommand(char command)
    {
        // using an else if chain...

        if (command == 'a')
        {
            addVideo();
        }
        else if (command == 'd')
        {
            deleteVideo();
        }
        else if (command == 'l')
        {
            listVideos();
        }
        else if (command == 's')
        {
            saveVideos();
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
     *  Prompt user for details and create a VideoTape
     *
     *  @return VideoTape - a video tape object (well, how neat!)
     */
    public VideoTape getVideoDetails() throws VideoTapeException
    {
        String title = IBIO.input("Please enter the title of your video: ");
        int length   = IBIO.inputInt("Please enter the length in minutes: ");
        // We assume it is not yet lent

        return new VideoTape(title, length, false);
    }

    /**
     *  Adds a VideoTape to videoTapes[]
     */
    public void addVideo()
    {
        // see how many videos are in the collection:
        if (numVideos >= MAX_VIDEOS)
        {
            IBIO.output("Sorry, no more videos can be stored");
        }
        else
        {
            try
            {
                videoTapes[numVideos] = getVideoDetails();
                numVideos = numVideos + 1;
            }
            catch (VideoTapeException e)
            {
                IBIO.output("Error: " + e);
            }
        }
    }

    /**
     *  Deletes a VideoTape from videoTapes[] by shuffling.
     */
    public void deleteVideo()
    {
        String  input;
        boolean done  = false;
        int     index = -1;

        if (numVideos == 0)
        {
            IBIO.output("Collection is empty. Nothing to delete.");
        }
        else
        {
            while (!done)
            {
                listVideos();
                try
                {
                    input = IBIO.input("Select a video, or 'c' to cancel: ");
                    if (input.equals("c"))
                    {
                        done = true;
                    }
                    else if ((index = Integer.parseInt(input)) > (numVideos - 1) ||
                            index < 0)
                    {
                        throw new NumberFormatException();
                    }
                    else
                    {
                        // Delete the VideoTape by the shuffle technique
                        shuffle(index);
                        numVideos = numVideos - 1;
                        if (numVideos == 0) done = true;
                    }
                }
                catch(NumberFormatException e)
                {
                    IBIO.output("Invalid entry");
                }
            }
        }
    }

    /**
     *  After deleting a tape from the array, shuffle the rest of the tapes to the 'left'.
     */    
    public void shuffle(int index)
    {
        for (int i = index; i < (numVideos - 1); i++)
        {
            videoTapes[i] = videoTapes[i + 1];
        }
    }

    /**
     *  Display all the VideoTape's that are in videoTapes[]
     */
    public void listVideos()
    {
        IBIO.output("\n");
        // loop through array
        for(int x = 0; x < numVideos; x = x + 1)
        {
            IBIO.output(x + ": " + videoTapes[x].toString());
        }
    }

    /**
     *  Save videoTapes[] to a file. Note, file is overwritten.
     */
    public void saveVideos()
    {
        FileWriter fw;
        PrintWriter outFile;

        try
        {
            // set up data file for writing
            fw = new FileWriter(FILENAME);
            outFile = new PrintWriter(fw);

            // loop through array, writing out records
            for(int x = 0; x < numVideos; x = x + 1)
            {
                /*
                outFile.println(videoTapes[x].getTitle());
                outFile.println(videoTapes[x].getLength());
                outFile.println(videoTapes[x].isLent());
                */
            }
            outFile.close();
            IBIO.output("\n" + numVideos + " Videotape(s) saved to " + FILENAME);
        }
        catch (IOException io)
        {
            IBIO.output("Some error writing to the data file - " + io.getMessage());
        }
    }

    /**
     *  Reads VideoTape's from a file.  File should be present, even if empty.
     */
    public boolean checkForFile()
    {
        boolean result = true;          // Assume the file is there

        try
        {
            FileReader fr = new FileReader(FILENAME);
            BufferedReader inFile = new BufferedReader(fr);

            String  title;          // Video title read from file
            int     length;         // length converted to int
            boolean lent;           // lent converted to boolean
            int     count = 0;      // counter for number of VideoTape's in the file

            // The title is in the first line
            // readln returns null if the eof is reached
            while ( (title = inFile.readLine()) != null )
            {
                // get the next two fields and construct a new object
                length = Integer.parseInt(inFile.readLine());
                lent   = Boolean.getBoolean(inFile.readLine());

                videoTapes[count] = new VideoTape(title, length, lent);
                count = count + 1;                      // Why not just increment numVideos?
            }
            numVideos = count;
            inFile.close();
        }
        catch( IOException io)
        {
            //IBIO.output("Error trying to open file " + io.getMessage());
            result = false;
        }
        catch(VideoTapeException e)
        {
            //IBIO.output("Error: " + FILENAME + " contains invalid data.");
            //result = false;
	}
        return result;
    }

    /**
     *  Say goodbye
     */
    public void quit()
    {
        IBIO.output("Bye then");
    }
}