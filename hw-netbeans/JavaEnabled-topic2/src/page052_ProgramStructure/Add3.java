package page052_ProgramStructure;

import ibio.IBIO;

/**
 *  Prompt user for two numbers, add them, display result.
 *
 *  Creates an instance of itself. Calls a non-static method from a static context.
 *
 *  @author Richard
 *  @version 060903
 */
public class Add3
{
    public static void main(String[] args)
    {
        double result = 0;
        
        // Prompt the user
        double number1 = IBIO.inputDouble("Please input your first number: ");
        double number2 = IBIO.inputDouble("Please input your second number: ");
        
        // Add the numbers
        Add3 add3 = new Add3();       
        result = add3.addTwoNumbers(number1, number2);    // calling a non-static method
        
        // Display the result
        IBIO.output("The total is: " + result);
    }

    /**
     * Add two numbers and return the result.
     */
    public double addTwoNumbers(double number1, double number2)
    {
        return(number1 + number2);        
    }
}