package page080_ObjectReferences;

import ibio.IBIO;
import page073_UserDefinedClasses.Time;
import page077_Exceptions.TimeException;

/**
 * Demonstrates how two variables can reference the same object.
 * 1. Prompts user for an hour and meridian.
 * 2. Creates a Time object and a reference to it.
 * 3. Creates a second reference to the Time object.
 * 4. Displays the contents of the Time object using the second reference.
 * 
 *  @author Richard 
 *  @version 070903
 */
public class TimeApp
{
    public static void main(String[] args)
    {
        // Prompt the user for the time of day
        String hour     = IBIO.input("\nInput the hour (1-12): ");
        String meridian = IBIO.input("Input the meridian (am, pm): ");
        
        try
        {
            // Create a Time object and a reference to it
            Time t1 = new Time(hour, meridian);
            IBIO.output("\nThe time is: " + t1.toString());
            
            // Create a second reference to the Time2 object
            Time t2 = t1;
            
            // Change the Time2 object via the second reference
            t2.setTimeMidnight();
            
            // Display the updated time via the first reference
            IBIO.output("The new time: " + t1.toString());
        }
        catch( TimeException e )
        {
            IBIO.output("Something wrong " + e.getMessage());
        }
    }
}
