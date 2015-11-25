package page077_Exceptions;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Prompts user for a number; handles any exceptions that occur.
 * Note that this class does not use the IB input/output methods, but it
 * could.
 */
public class ExceptionApp
{
    /**
     * Entry point to application.
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        ExceptionApp app = new ExceptionApp();
        app.getNumberFromUser();
    }

    /**
     * Prompt the user for a number. Catch any exceptions.
     */
    public void getNumberFromUser()
    {
        String userInput = "";
        int number = 0;
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bReader   = new BufferedReader(reader);

        System.out.print("Enter a number: ");
        try
        {
            // readLine() can throw IOException
            userInput = bReader.readLine();

            // parseInt() can throw NumberFormatException
            number = Integer.parseInt(userInput);

            // Everything ok
            System.out.println(number + " is a valid number.");
        }
        catch (IOException e)
        {
            System.out.println("Error: " + e);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Error " + e);
        }
        finally {

        }
        return;                         
    }     
}
