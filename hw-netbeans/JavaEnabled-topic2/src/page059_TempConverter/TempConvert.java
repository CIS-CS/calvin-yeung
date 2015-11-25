// TempConvert.java

package page059_TempConverter;

import ibio.IBIO;

/**
 *  A class which converts temperatures between C and F
 * 
 *  @author Richard 
 *  @version 060903
 */
public class TempConvert
{
    public static void main(String[] args)
    {
        TempConvert tc = new TempConvert();
        tc.convert();
    }
    
    /**
     * Constructor for objects of class tempCon
     */
    public void convert()
    {
        String tempType = IBIO.input("Enter C or F: ");
        double temp     = IBIO.inputDouble("Enter the temperature: ");
        String result;

        if ((tempType.equals("C")) || tempType.equals("c"))
        {
            result = (temp * (9 / 5) + 32.0) + " F";
        }
        else
        {
            result = ((temp - 32.0) * (5 / 9)) + " C";;
        }

        IBIO.output("The converted temperature is: " + result);
    }
}

