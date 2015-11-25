
package page068_TracingLoops;

import ibio.IBIO;

/**
 *  Same as Mystery2 except the code is moved from the constructor to main(), and
 *  the program loops until user quits.
 */
public class Mystery3
{
    public static void main(String[] args)
    {
        boolean done = false;
        
        // Keep prompting the user until they enter a 'q'
        while (!done)
        {
            String message = IBIO.input("Enter a string: ");
            if (message.equals("q"))
            {
                done = true;
            }
            else
            {
                IBIO.output("\nOccurances of \"abc\" in your string = " + mystery(message) + "\n");
            }
        }
    }

    // Calculate the number of substrings
    private static int mystery(String message)
    {
        int count = 0;
        int length = message.length();

        while (length >= 3)
        {
            if (length == 3 && message.equals("abc"))
            {
                // The input string was "abc"
                count = 1;
                length = 0;
            }
            else if (message.substring(0,3).equals("abc"))
            {
                // Found an occurance. Adjust the string pointer past the occurance.
                count++;
                message = message.substring(3);
                length = length - 3;
            }
            else
            {
                // Not found. Increment the string pointer.
                message = message.substring(1);
                length = length - 1;
            }
        }
        return count;
    }
}