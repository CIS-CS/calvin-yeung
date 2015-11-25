// Shuffle.java

package page105_TestAnAlgorithm;

import original.IBIO;

/**
 *  Shuffles strings in an array.  Moves the strings to the left, and "XXXX"
 *  to the right.
 *  From section 2.1.5 in the book.
 * 
 * @author Richard 
 * @version 021003
 */
public class Shuffle
{
    private String MARKER = "XXXX";
    /*
    private String[] names =        // Data from p105
            new String[] { MARKER, MARKER, "sayaka", "jithan", MARKER, "andrew" };
    */
    private String[] names =        // Data from p107
            new String[] { MARKER, MARKER, "phuong", MARKER, "richard", MARKER };
    
    public static void main(String[] args)
    {
        Shuffle s = new Shuffle();
        
        s.shuffleArray();
        s.displayArray();
    }

    /**
     *  Moves names to the left, MARKER's to the right.
     */
    public void shuffleArray()
    {
        int i = 0;      // pointer to the left-most MARKER
        int j = 0;         
        
        while (j < names.length)
        {
            if (!names[i].equals(MARKER))
            {
                // Current entry is a name. Skip it. Advance pointers.
                i++;
                j++;
            }
            else
            {
                // i is pointing at a MARKER. Move j right, to the next name.
                while (names[j].equals(MARKER))
                {
                    j++;
                }
                // 'Swap' the name and the MARKER
                names[i] = names[j];
                names[j] = MARKER;
            }
            // Advance both pointers
            i++;
            j++;
        }
    }
    
    /**
     *  Display the contents of the array 
     */
    public void displayArray()
    {
        for(int i = 0; i < names.length; i++)
        {
            IBIO.output(i + ":  " + names[i]);
        }
    }
}




