package page052_ProgramStructure;

import ibio.IBIO;
/**
 *  The AddModular class rewritten in a single statement.
 *
 *  Challenge Exercise: p.59 from book.
 */
public class AddModular2
{
    public static void main(String[] args)
    {
        IBIO.output("The total is: " + 
                    (IBIO.inputDouble("\nPlease input your first number: ") +
                     IBIO.inputDouble("Please input your second number: ")) );
    }
}
