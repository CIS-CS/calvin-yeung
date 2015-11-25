// PassFail.java

package page069_PassFail;

import ibio.IBIO;

/**
 *  Read two scores from the keyboard, calculates a total score, display the result.
 */
public class PassFail2
{
    public static void main(String[] args)
    {
        int mark1 = IBIO.inputInt("Please input the first mark: ");
        int mark2 = IBIO.inputInt("Please input the second mark: ");
        
        double m1 = mark1 * 0.75;
        double m2 = mark2 * 0.25;
        
        int total = (int) (mark1 + mark2);
        
        if (total >= 45)
            IBIO.output("\nScore = " + total + ". You passed. Passing is 45.");
        else
            IBIO.output("\nScore = " + total + ". You failed. Passing is 45.");
    }
}



