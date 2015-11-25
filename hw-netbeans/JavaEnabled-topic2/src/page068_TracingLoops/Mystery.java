package page068_TracingLoops;

import ibio.IBIO;

/**
 *  Pronpts the user for a string, counts the number of occurances of 'a'
 *  in the string, displays the count.
 *
 *  See if the user can figure out what the result means.
 * 
 *  This is the original version where the application runs from the constructor.
 *  This is not good programming practice because is runs from the constructor.
 */
public class Mystery
{
    public static void main(String[] args)
    {
        new Mystery();
    }
    
    /**
     * Constructor for objects of class tempCon
     */
    public Mystery()
    {
        String message = IBIO.input("\nPlease type a message: ");
        IBIO.output("\nThe result of mystery is: " + mystery(message));
    }
    
    /**
     *  Count the number of occurances of 'a' in the string
     */    
    public int mystery(String message)
    {
        int count = 0;
        int len = message.length();
        
        for(int p = 0; p < len; p++)
        {
            if (message.charAt(p) == 'a')
            {
                count = count + 1;
            }
        }
        return count;
    }	
}