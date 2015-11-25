package page110_StringMethods;
import original.IBIO;

/**
 *  A class to do illustrate some methods of the String Class
 *  Prompts the user for a string, then prompts for a command.
 *  Commands are entered in uppercase.
 *  If user enters the command in lowercase, the program checks to see
 *  if that letter exists in the input string.
 *
 *  @author Richard
 *  @version 041003
 */
public class StringMethods2
{
    private String message  = "Default Text Message for Use with this application";
    private String commands = "SULTCEHQ";
    private char   command  = ' ';

    // Entry point to application
    public static void main(String[] args)
    {
        StringMethods2 sm2 = new StringMethods2();
        sm2.run();
    }
    
    public void run()
    {
        message = getMessage();     // Prompt the user for a string
        
        while (command != 'Q')      // Process user commands until 'Q' pressed
        {
            command = getCommand();
            doCommand(command);
        }
    }
    
    // Prompt the user for a string
    private String getMessage()
    {
        // User enterd a message, if not, default is used
        String msg = IBIO.input("Enter a string: ");
        if (msg.length() == 0)
        {
            msg = message;
        }
        return msg;
    }
    
    // Prompt the user for a command
    private char getCommand()
    {
        String cmd = IBIO.input("\nEnter a command (H for help): ");
        if (cmd.length() == 0)
        {
            return ' ';         // indicates unknown command
        }
        else
        {
            return cmd.charAt(0);
        }
    }
    
    // Execute the user's command
    private void doCommand(char cmd)
    {
        //  If input is lowercase, return the position of the 
        //  first occurance of that letter in the String.
        if ( (cmd >= 'a') && (cmd <= 'z') )
        {
            String temp = message.toLowerCase();
            int pos = temp.indexOf(cmd);
            IBIO.output("That letter is found at position " + pos);
            
            // Count the number of occurances of the character in the string
            int index = 0;
            int count = 0;
            while(index != -1 && index < temp.length())
            {
                index = temp.indexOf(cmd, index);
                if (index >= 0)
                {
                    count++;
                    index = index + 1;
                }
            }
            IBIO.output("The letter '" +  cmd + "' occurs " + count + " times.");
            
        }
        else if (commands.indexOf(cmd) < 0)
        {
            IBIO.output("Unknown command: " + cmd);
        }
        else if (cmd == 'S')                            // Show
        {
            // Show the original string
            IBIO.output(message);
        }
        else if (cmd == 'U')                            // Uppercase
        {
            // Convert original string to uppercase
            message = message.toUpperCase();
        }
        else if (cmd == 'L')                            // L<owercase
        {
            // Convert original string to lowercase
            message = message.toLowerCase();
        }
        else if (cmd == 'T')                            // Tokenize the string
        {
            // Tokenize the string
            String[] tokens = message.split(" ");       // the split method
            for (int i = 0; i < tokens.length; i++)
            {
                IBIO.output(tokens[i]);
            }
        }
        else if (cmd == 'C')                            // CamelCase
        {
            StringBuffer result = new StringBuffer();
            
            // Convert the string to camelcase
            String[] tokens = message.split(" ");      // the split method
            
            for (int i = 0; i < tokens.length; i++)
            {
                char c = tokens[i].charAt(0);
                if (c >= 'a' && c <= 'z')
                {
                    c = Character.toUpperCase(c);
                    tokens[i] = c + tokens[i].substring(1);
                }
                result.append(tokens[i] + " ");
            }
            IBIO.output(result.toString());
        }
        else if (cmd == 'E')                    // Get a new string from user
        {
            // Get a new string from the user
            String msg = null;
            do
            {
                msg = getMessage();
                //msg = "";
                //System.out.println("length = " + msg.length());
            }
            while (msg.length() == 0);
            message = msg;
        }
        else if (cmd == 'H')                    // Show the Help menu
        {            
            IBIO.output("\n");
            IBIO.output("S - show the string");
            IBIO.output("U - convert string to Uppercase");
            IBIO.output("L - convert string to Lowercase");
            IBIO.output("T - tokenize the string");
            IBIO.output("C - convert to Camelcase");
            IBIO.output("E - edit the string");
            IBIO.output("H - show this list");
            IBIO.output("Q - end the program");
        }
        else if (cmd == 'Q')                    // quit
        {
            // Quit the appplication
            IBIO.output("bye then");
        }
    }
}
