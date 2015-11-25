
package page052_ProgramStructure;

import ibio.IBIO;
/**
 *  Prompt user for two numbers, add them, display result.
 *
 *  @author Richard
 *  @version 060903
 */
public class Add
{
    public static void main(String[] args)
    {
        new Add();
    }
    /**
     * Constructor for objects of class Add
     */
    public Add()
    {
        double number1 = IBIO.inputDouble("Please input your first number: ");
        double number2 = IBIO.inputDouble("Please input your second number: ");

        double total = number1 + number2;
        IBIO.output("The total is: " + total);
    }
}
