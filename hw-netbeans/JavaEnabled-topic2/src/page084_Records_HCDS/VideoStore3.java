package page084_Records_HCDS;

import original.IBIO;

/**
 *  Stores VideoTape objects in an array.
 *  This version sets deleted items to null, creating a free space in the array.
 *  The Add function adds into the first free space.
 *  The List function has to check every element of the array.
 * 
 *  @author Richard 
 *  @author MHayes
 */
public class VideoStore3
{
    static final int MAX_VIDEOS = 5;    // max videos to store in the array
    private int numVideos = 0;          // number of videos in the array 
    
    // Store the VideoTapes objects in this array
    private VideoTape[] videoTapes = new VideoTape[MAX_VIDEOS]; 

    public static void main(String[] args)
    {
        VideoStore3 store = new VideoStore3();
        char command;
                
        do
        {
            command = store.getCommand();
            store.doCommand(command);
        }
        while(command != 'q');
    }
    
    /**
     *  Prompts the user for a command.
     *  @return The command entered by user. (a) add, (l) list, or (q) quit
     */	
    private char getCommand()
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
     * Executes a command.
     * @param command The command to be executed.
     */
    public void doCommand(char command)
    {
        if (command == 'a')         // Add command
        {
            // see how many videos are in the collection:
            if (numVideos == MAX_VIDEOS)
            {
                IBIO.output("Sorry, no more videos can be stored");
            }
            else
            {
                // Assume we will add at the end
                int placeToAdd = numVideos;
                // See if there is a hole
                for (int i = 0; i < numVideos; i++)
                {
                    if (videoTapes[i] == null)
                    {
                        // We found an empty location in the array
                        placeToAdd = i;
                        break;                      
                    }
                }
                videoTapes[placeToAdd] = inputVideoDetails();
                numVideos++;
            }
        }
        else if (command == 'd')        // Delete command
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
                    if (videoToDelete < 0 || videoToDelete > MAX_VIDEOS-1)
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
            // Delete the video by marking the element as null.
            videoTapes[videoToDelete] = null;
            numVideos--; 
        }
        else if (command == 'l')        // List command
        {
            displayVideos(); 
        }
        else                            // Quit command
        {   
            IBIO.output("Good Bye.");        
        }
    }    
     
    /**
     *  Displays the videos on the screen.
     */     
    public void displayVideos()
    {
        // Loop through the array and display each video
        for(int i = 0; i < MAX_VIDEOS; i++)
        {
            if (videoTapes[i] != null)
            {
                IBIO.output(i + ": " + videoTapes[i].toString());
            }
        }        
    }
    
    /**
     * Prompts the user for the  details of video tape.
     * @return VideoTape A video tape object.
     */
    public VideoTape inputVideoDetails()
    {
        String title = IBIO.input("Enter the title of your video: ");
        int length   = IBIO.inputInt("Enter the length in minutes: ");
        
        return new VideoTape(title, length, false);
    }
}



