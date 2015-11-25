package page077_Exceptions;

import ibio.IBIO;
import page073_UserDefinedClasses.Time;

/**
 * Prompt the user for an hour and an AM/PM indicator.
 * Store the data in a Time2 object.  Display the time.
 */
public class TimeApp
{
     public static void main(String[] args) throws TimeException
    {
        // Prompt the user for an hour and indicator  
        String hour     = IBIO.input("\nInput the hour (1-12): ");
        String meridian = IBIO.input("Input the meridian (am, pm): ");
      
        // Validate the time and display it
        try
        {
            Time now = new Time(hour, meridian);
            IBIO.output("\nThe time is " + now.toString());
        }
        catch( TimeException e )
        {
            IBIO.output("\nSomething wrong: " + e.getMessage());
        }              
    }
}







