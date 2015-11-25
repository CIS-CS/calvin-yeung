package page052_ProgramStructure;

import ibio.IBIO;

/**
 *  The Add class with methods to make it more modular.
 *
 *  @author Richard
 *  @version 060903
 */
public class AddModular
{
    // Class variables, available to every method of the Class
    double number1, number2, total;
    
    public static void main(String[] args)
    {
        AddModular am = new AddModular();
        //obtain();
        am.calculate();
        am.display();        
    }
    
    /**
     * Method to obtain two numbers
     */
    public void obtain()
    {
        number1 = IBIO.inputDouble("Please input your first number: ");
        number2 = IBIO.inputDouble("Please input your second number: ");
    }
    
    /**
     * Method to add two numbers
     */
    public void calculate()
    {
        total = number1 + number2;
    }
    
    /**
     * Method to display the total
     */
    public void display()
    {
        IBIO.output("The total is: " + total);
    }
}
