package page084_Records_HCDS;

import original.IBIO;

/**
 *  Stores VideoTape objects in an array
 *  This version does the delete by shuffling the array.
 * 
 *  @author Richard 
 *  @version 200903
 */
public class VideoStore2
{
    static final int MAX_VIDEOS = 5;    // max videos to store in the array
    private int numVideos = 0;          // number of videos in the array 
    
    // We will store the VideoTapes objects in this array
    private VideoTape[] videoTapes = new VideoTape[MAX_VIDEOS]; 

    public static void main(String[] args)
    {
        VideoStore2 store = new VideoStore2();
        char command;
                
        do
        {
            command = store.getCommand();
            store.doCommand(command);
        }
        while(command != 'q');
    }
    
    /**
     *  Prompt the user for a command.
     * 
     *  @return char, a valid command - either (a) add, (l) list or (q) quit
     */	
    public char getCommand()
    {
        String input;      // input from the user
        char   command;     
        
        // Repeat until a valid command is entered
        do
        {
            IBIO.output("");
            IBIO.output("Would you like to: ");
            IBIO.output("     (a)   Add a video tape to the collection");
            IBIO.output("     (d)   Delete a video tape to the collection");
            IBIO.output("     (l)   List the tapes already in the collection");
            IBIO.output("     (q)   Quit the program");
            IBIO.output("");
            input = IBIO.input("Your choice (a/d/l/q): ");
            
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
                if ((command != 'a') && (command != 'd') 
                                     && (command != 'l') 
                                     && (command != 'q') )
                {
                    IBIO.output("Please enter a valid command (a, d, l or q)!");
                    command = 'n';
                }
            }
        } 
        while (command == 'n');
        
        return command;
    }
    
    /**
     * Method to add a video tape, more commands (search, lend, delete could be added)
     *
     *@param command The command to be invoked by this method.
     */
    public void doCommand(char command)
    {        
        if (command == 'a')
        {
            // see how many videos are in the collection:
            if (numVideos == MAX_VIDEOS)
            {
                IBIO.output("Sorry, no more videos can be stored");
            }
            else
            {
                // Add the video to the array
                videoTapes[numVideos] = inputVideoDetails();
                numVideos = numVideos + 1;
            }
        }
        else if (command == 'd')
        {
            boolean done = false;
            String input = null;
            int videoToDelete = -1;
            
            // Loop here until we get a valid video number from the user
            while (!done)
            {
                displayVideos();
                input = IBIO.input("Select a video to delete: ");
                try 
                {
                    // Convert the input from a String to an int
                    videoToDelete = Integer.parseInt(input);
                    
                    // Validate the int
                    if (videoToDelete < 0 || videoToDelete > numVideos-1)
                    {
                        throw new Exception("Invalid video number");
                    }
                    done = true;
                }
                catch(NumberFormatException e)
                {
                    IBIO.output("ERROR: " + e);     // Input string was not an int
                }
                catch(Exception e)
                {
                    IBIO.output("ERROR: " + e);     // The int is out of range
                }
            }
            // User entered a valid video number. Delete it.
            deleteByShuffle(videoToDelete);
        }
        else if (command == 'l')
        {
            displayVideos(); 
        }
        else 
        {   
            IBIO.output("Good Bye.");        // User wants to quit.
        }
    }
    
    /**
     * Deletes an element from the array; then shuffles other elelments to fill
     * the gap.
     * Think of the array as horizontal, with element 0 on the left.
     * The elements to the right of the deleted one are shuffled left by one.
     * The record to be deleted is overwritten by the one on its right.
     * @param index The index of the VideoTape object to delete.
     */
    public void deleteByShuffle(int index)
    {
        for(int i = index; i < numVideos - 1; i++)
        {
            videoTapes[i] = videoTapes[i + 1];
        }
        numVideos--;        
    }    
     
    /**
     *  Displays the videos on the screen.
     */     
    public void displayVideos()
    {
        // loop through the array and display each video
        for(int i = 0; i < numVideos; i++)
        {
            IBIO.output(i + ": " + videoTapes[i].toString());
        }        
    }
    
    /**
     *  Prompts the user for the details of a video tape.
     *  @return VideoTape - a video tape object
     */
    public VideoTape inputVideoDetails()
    {
        String title = IBIO.input("Enter the title of your video: ");
        int length   = IBIO.inputInt("Enter the length in minutes: ");
        
        return new VideoTape(title, length, false);        
    }
}



