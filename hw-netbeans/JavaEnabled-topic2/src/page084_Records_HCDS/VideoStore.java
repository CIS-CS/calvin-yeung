package page084_Records_HCDS;

import original.IBIO;

/**
 *  Stores VideoTape objects in an array
 * 
 *  @author Richard 
 *  @version 200903
 */
public class VideoStore
{
    private static final int MAX_VIDEOS = 5;    // max videos to store in the array
    private int numVideos = 0;                  // number of videos in the array
    
    // We will store the VideoTapes objects in this array
    private VideoTape[] videoTapes = new VideoTape[MAX_VIDEOS]; 

    public static void main(String[] args)
    {
        VideoStore store = new VideoStore();
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
    private char getCommand()
    {
        String input;        // input from user
        char   command;      
        
        // Repeat until a valid command is entered
        do
        {
            IBIO.output("");
            IBIO.output("Would you like to: ");
            IBIO.output("     (a)   Add a video tape to the collection");
            IBIO.output("     (l)   List the tapes already in the collection");
            IBIO.output("     (q)   Quit the program");
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
                if ((command != 'a') && (command != 'l') && (command != 'q'))
                {
                    IBIO.output("Please enter a valid command (a, l or q)!");
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
     *@param command char - the command to be carried out by this method
     */
    private void doCommand(char command)
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
        else if (command == 'l')
        {
            // loop through the array and display each video
            for(int i = 0; i < numVideos; i++)
            {
                IBIO.output(i + ": " + videoTapes[i].toString());
            }
        }
        else 
        {   
            IBIO.output("Good Bye.");        // User wants to quit.
        }
    }
    
    /**
     *  Method to get details of tape
     *
     *  @return VideoTape - a video tape object
     */
    private VideoTape inputVideoDetails()
    {
        String title = IBIO.input("Enter the title of your video: ");
        int length   = IBIO.inputInt("Enter the length in minutes: ");

        return new VideoTape(title, length, false);
    }
}



