package page110_StringMethods;

import ibio.IBIO;

/**
 * A class to illustrate some methods of the String class.
 * Prompts the user for a string, and then shows a menu of commands
 * for manipulating the string.
 * 
 * @author Richard (edited by Mark Hayes)
 * @version 041003
 */
public class StringMethods
{
    private String message = "Default Text Message for Use with the Class";
    private String commands = "SULHQ";
    private char   command = ' ';
   
    public static void main(String[] args)
    {
        StringMethods sm = new StringMethods();        
        sm.run();
    }

    public void run()
    {
        message = IBIO.input("Enter a string: ");

        while (command != 'Q')
        {
            command = getCommand();
            doCommand(command);
        }

    }
        
    private char getCommand()
    {
        String cmd = IBIO.input("Enter a command (H for help): ");
        if (cmd.length() == 0)
        {
            return ' ';
        }
        else
        {
            return cmd.charAt(0);
        }	  
    }
    
    private void doCommand(char cmd)
    {
        // lowercase letter returns first position of that letter in the String, if any
        // matches both lower and uppercase letters in target String
        if ( (cmd >= 'a') && (cmd <= 'z') )
        {
            String testMessage = message.toLowerCase();
            int pos = testMessage.indexOf(cmd);
            IBIO.output("That letter is found at position " + pos);
        }
        else
        {
            // check for valid command
            if (commands.indexOf(cmd) < 0)
            {
                IBIO.output("Unknown command: " + cmd);
            }
            else if (cmd == 'S')        // Show the original string
            {
                IBIO.output(message);
            }
            else if (cmd == 'U')        // Convert to uppercase
            {
                message = message.toUpperCase();
            }
            else if (cmd == 'L')        // Conver to lowercase
            {
                message = message.toLowerCase();
            }
            else if (cmd == 'H')        // Help menu
            {
                IBIO.output("a-z - find this character in the string");
                IBIO.output("S - show the string");
                IBIO.output("U - convert string to Uppercase");
                IBIO.output("L - convert string to Lowercase");
                IBIO.output("H - show this list");
                IBIO.output("Q - quit");
            }
            else if (cmd == 'Q')
            {
                IBIO.output("bye then");
            }
        }
    }    
}




