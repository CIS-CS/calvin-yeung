package page119_Sorting;
import original.IBIO;

/**
 * Sorts random integers using the InsertionSort algorithm.
 * Take each item from the unsorted portion (R) and INSERT it into the
 * sorted portion (L).
 *
 * @author Richard Jones. Modified by MHayes.
 * @version April 2010
 */
public class InsertionSort
{   
    public static void main(String args[])
    {
        int[] data = new int[100];         // store data here

        fill(data);
        display(data);
        sort(data);
        display(data);
    }    


    /* Fill the array with random numbers)
       Math.random() returns 0.0 to 0.9999
       Multiply random number by n to move decimal pt to the right.
       Cast to an int to get rid of fractional part.
    */
    private static void fill(int data[])
    {
        // Fill data[] with random integers between 0 and data.length
        for (int i = 0; i < data.length; i = i + 1)
        {
            data[i] = (int)(Math.random() * data.length);
        }
    }

    /**
     *  1. Boundary starts on the left, and moves right.
     *     Sorted portion is on the L; unsorted portion on the R.
     *  2. Move the first unsorted item to temp.
     *  3. Starting from the R-side of the sorted portion, and moving L,
     *     right-shift all values that are > temp.
     *     Note, this will overwrite the first element in the unsorted portion (R).
     *     That first element is the one that was moved to temp.
     *  5. Insert temp into the empty spot of the sorted portion (L).
     *  6. Move boundary to the right; repeat from step 2.
     *
     *  @param the array to be sorted
     */
    private static void sort(int[] data)
    {
        IBIO.output("sorting...");

        int indexSorted;           // Pointer into the sorted portion (left)
        int indexUnsorted = 0;     // Pointer into the unsorted portion (rigt)
        int temp;                  // Temp spot for the value to be inserted

        // The index for the unsorted portion will move from L to R
        while (indexUnsorted < (data.length - 1))
        {
            // increment current position to first in unsorted item
            indexUnsorted = indexUnsorted + 1;

            // pointer into sorted part; points to the right-most item
            indexSorted = indexUnsorted;

            // get the next unsorted item
            temp = data[indexUnsorted];           
            
            /* We need to determine where to insert temp into the sorted portion.
               Work from R to L thru the sorted portion.
               Shift-right the sorted values that are > temp
               NB: the right-shifting will overwrite the first item in the
                   unsorted portion.
                   this is ok because we have already saved that value in temp.
            */
            while ( (indexSorted > 0) && (data[indexSorted - 1] > temp) )
            {
                // shuffle the sorted item one to th R
                data[indexSorted] = data[indexSorted - 1];
                // move the index one to the L
                indexSorted = indexSorted - 1;
            }
            // Insert the temp value into the 'empty spot' of the sorted portion
            data[indexSorted] = temp;
        }
        IBIO.output("finished");
    }

    // Display the sorted data
    private static void display(int data[])
    {
        StringBuffer output = new StringBuffer();

        for (int i = 0; i < data.length; i = i + 1)
        {
            output.append(data[i] + " ");
        }
        IBIO.output(output.toString());
    }
}
