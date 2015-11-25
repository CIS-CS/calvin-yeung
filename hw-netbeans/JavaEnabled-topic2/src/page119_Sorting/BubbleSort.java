package page119_Sorting;
import original.IBIO;

/**
 * Bubble sort
 * Sorts data in an array. The data is sorted 'in place', that is,
 * we do not create a second array to help do the sort.
 *
 * 1. The notion here is to separate the data into two portions, the unsorted
 *    portion 'on the left' and the sorted portion 'on the right'.
 * 2. As the algorithm runs, the highest value on the left bubbles to the
 *    right-most position, just left of the boundary.
 * 3. Shift boundary left, one position.
 * 4. Repeat until one item remaining on the left.
 *
 * @author Richard Jones. Modified by MHayes
 * @version April 2010
 */
public class BubbleSort
{             
    public static void main(String args[])
    {
        int[] data = new int[10];    // store data here

        fill(data);
        display(data);
        sortAsc(data);                  // sort the data
        display(data);
    }

    /* Fill the array with random numbers from 0 to n-1
       Math.random() returns 0.0 to 0.9999
       Multiply the random number by n to move decimal pt to the right.
       Cast to an int to get rid of fractional part.
    */
    private static void fill(int data[])
    {
        for (int i = 0; i < data.length; i++)
        {
            //data[i] = (int)(Math.random() * data.length);
            data[i] = i;
        }       
    }

    /*
     * Sorts the data in ascending order.
     * 1. Set the boundary to point the right-most element.
     *    Set the current pointer to point to the left-most element.
     * 2. Compare current to current+1.
     *    If the current > current+1, swap them.
     * 3. Increment current.
     * 4. Repeat until current reaches the boundary.
     * 5. Move the boundary one to the left.
     * 6. Repeat steps 2-5 until current hits the boundary.
     */
    private static void sortAsc(int[] data)
    {
        System.out.println("sorting...");
        for (int boundary = (data.length - 1); boundary > 0; boundary--)
        {
            int swapCount = 0;
            for (int current = 0; current < boundary; current++)
            {
                if (data[current] > data[current+1])
                {
                    // Swap the two elements
                    int temp = data[current];
                    data[current] = data[current+1];
                    data[current+1] = temp;
                    swapCount++;
                }
                display(data);          // show the data after each swap
            }
            if (swapCount == 0) break;  // terminate early is data is sorted
        }
        System.out.println("finished");
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



















