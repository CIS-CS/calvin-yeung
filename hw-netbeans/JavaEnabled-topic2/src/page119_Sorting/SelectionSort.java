package page119_Sorting;
import original.IBIO;

/**
 * Selection sort
 * Sorts data in ascending order using selection sort.
 * Sorted data is on the L; unsorted data is on the R.*
 *
 * @author Richard Jones. Modified by MHayes.
 * @version April 2010
 */
public class SelectionSort
{         
    public static void main(String args[])
    {
        int[] data = new int[45];   // store data here

        fill(data);                 // get some random numbers
        display(data);              // display unsorted data
        sortAsc(data);                 // sort the data
        display(data);              // display sorted data
    }    

    /* Fill the array with random numbers from 0 to n-1
       Math.random() returns 0.0 to 0.9999
       Multiply random number by n to move the decimal pt to the right.
       Cast to an int to get rid of fractional part.
    */
    private static void fill(int data[])
    {
        for (int i = 0; i < data.length; i++)
        {
            data[i] = (int)(Math.random() * data.length);
        }
    }

    /**
     *  Sorts the data in ascending order.
     *  Sorted data is on the L; unsorted data is on the R.
     *  1. set the boundary to the first element on the left.
     *  2. select the smallest element in the list.
     *  3. swap the smallest item with the item at the boundary.
     *  4. move the boundary one to the R.
     *  5. repeat until boundary cannot be moved anymore.
     *
     *  @param the array to be sorted
     */
    private static void sortAsc(int[] data)
    {        
        IBIO.output("sorting...");
        
        for (int boundary = 0; boundary < data.length; boundary++)
        {            
            // Get the indes of the smallest element to the R of the boundary
            int indexMin = findSmallest(data, boundary, data.length - 1);
            
            // Swap smallest and boundary
            int temp = data[indexMin];
            data[indexMin] = data[boundary];
            data[boundary] = temp;
        }
        IBIO.output("finished");
    }
    
    /**
     * Finds the index of the smallest item, to the right of the boundary.
     * No data is moved. Just get the index (position) of the smallest one.
     *
     * @param the array to be examined
     * @param the start element
     * @param the end element
     * @return The index of the smallest item.
     */
    private static int findSmallest(int[] data, int start, int end)
    {
        int index   = start;
        int minumum = data[start];      // assumes the minimum is the first one
        
        for(int i = start; i <= end; i++)
        {
            if (data[i] < minumum)
            {
                // Found a new mimimum
                minumum = data[i];
                index = i;
            }
        }
        return index;
    }

    // Display the sorted data
    private static void display(int data[])
    {
        StringBuffer output = new StringBuffer();

        for (int i = 0; i < data.length; i++)
        {
            output.append(data[i] + " ");
        }
        IBIO.output(output.toString());
    }
}
