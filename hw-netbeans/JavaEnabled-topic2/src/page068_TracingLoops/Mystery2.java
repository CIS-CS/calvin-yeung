
package page068_TracingLoops;

import ibio.IBIO;

/**
 *  Prompt the user for a string, count the occurances of "abc", display the result.
 */
public class Mystery2
{
    public static void main(String[] args)
    {
        new Mystery2();
    }

    public Mystery2()
    {
        // Get a string from the user
        String message = IBIO.input("Enter a string: ");

        // Tell user how many substrings
        IBIO.output("\nOccurances of \"abc\" in your string = " + mystery(message) + "\n");
    }

    // Calculate the number of substrings
    private int mystery(String message)
    {
        int count = 0;
        int length = message.length();

        while(length >= 3)
        {
            if(length == 3 && message.equals("abc"))
            {
                // The input string was "abc"
                count = 1;
                length = 0;
            }
            else if(message.substring(0,3).equals("abc"))
            {
                // Found an occurance. Adjust the string pointer past the hit.
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