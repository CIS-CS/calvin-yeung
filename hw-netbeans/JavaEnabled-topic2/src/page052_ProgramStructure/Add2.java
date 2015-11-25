package page052_ProgramStructure;

import ibio.IBIO;
/**
 *  Same as Add class. Code moved from the constructor to the main method.
 *
 *  @author Richard
 *  @version 060903
 */
public class Add2
{    
    public Add2() {        
    }
    
    public static void main(String[] args)
    {
        double number1 = IBIO.inputDouble("Please input your first number: ");
        double number2 = IBIO.inputDouble("Please input your second number: ");

        double total = number1 + number2;
        IBIO.output("The total is: " + total);
    }
}