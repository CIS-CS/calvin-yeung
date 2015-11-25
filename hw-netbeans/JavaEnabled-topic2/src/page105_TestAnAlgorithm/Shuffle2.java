// Shuffle2.java

package page105_TestAnAlgorithm;

import original.IBIO;

/**
 *  Shuffles strings in an array.  Moves the strings to the left, and "XXXX"
 *  to the right.
 *  This version fixes several problems in the original Shuffle.java
 *  From section 2.1.5 in the book.
 *
 *  @author Richard
 *  @version 021003
 */
public class Shuffle2
{
    static final String MARKER = "XXXX";
    static final int LAST_P = 5;
    //String[] names =
    //    new String[] { MARKER, MARKER, "sayaka", "jithan", MARKER, "andrew" };
    //String[] names =
    //     new String[] { MARKER, MARKER, "phuong", MARKER, "richard", MARKER };
    String[] names =
        new String[] { "bob", MARKER, "sayaka", "jithan", MARKER, "andrew" };

    public static void main(String[] args)
    {
        Shuffle2 s = new Shuffle2();
        s.shuffleArray();
        s.showArray();
    }

    /**
     * shuffles names not matching special marker to front of array
     *
     */
    public void shuffleArray()
    {
        int i = 0;      // pointers to array names
        int j = 0;

        // loop until end of array is reached
        while (j <= LAST_P)
        {
            // Advance pointers to first XXXX entry
            if (!names[i].equals(MARKER))
            {
                i = i + 1;
                j = j + 1;
            }
            else
            {
                // advance pointer to first non-XXXX entry
                while(j <= LAST_P && names[j].equals(MARKER))   // <--
                {
                    j = j + 1;
                }
                // place valid entry in XXXX position
                // replace entry with XXXX
                if (j <= LAST_P) {                              // <--
                    names[i] = names[j];
                    names[j] = MARKER;
                }
            }
            // advance the pointers
            //i = i + 1;                                        // <--
            //j = j + 1;
        }
    }

    /**
     * list the names array on the screen
     */
    public void showArray()
    {
        for(int x = 0; x <= LAST_P; x = x + 1)                  // <--
        {
            IBIO.output(x + "  " + names[x]);
        }
    }
}