package page073_UserDefinedClasses;

import page077_Exceptions.TimeException;

/**
 *  Store the time as an hour-of-day + an AM/PM indicator.
 *  Valid times are 1-12 AM, 1-12 PM
 *  Invalid times are set to midnight - 12 AM
 */
public class Time
{
    // Properties of the Time Class
    private int    hour;        // hour as an int
    private String meridian;    // indicator for am/pm
    
    /**
     * No-arg constructor; sets the time to midnight.
     */
    public Time()
    {
        // initialise instance variables to midnight
        setTimeMidnight();        
    }

    /**
     * Two-arg constructor; validates the args; sets the time.
     * @param hour Hour of the day. Must be 1-12.
     * @param meridian Must be "AM" or "PM"
     * @throws TimeException If either argument is invalid.
     */
    public Time(String hour, String meridian) throws TimeException
    {
        // Process the parameters
        this.hour     = Integer.parseInt(hour.trim());
        this.meridian = meridian.toUpperCase().trim();

        // Validate the two parameters
        if (this.hour < 1 || this.hour > 12 || 
            !(this.meridian.equals("AM") || this.meridian.equals("PM")))
        {
            // Invalid time, set time to midnight.
            setTimeMidnight();

            // Throw an exception to the caller.
            throw new TimeException("Error, invalid time: " +
                    hour + " " + meridian + ". " +
                    "The time has been set to midnight.");
        }
    }
    
    public void setTimeMidnight()
    {
        hour = 12;
        meridian = "AM";
    }
    
    /**
     *  Method to return the time as a String
     */
    public String toString()
    {
        return(hour + " " + meridian);
    }
}

