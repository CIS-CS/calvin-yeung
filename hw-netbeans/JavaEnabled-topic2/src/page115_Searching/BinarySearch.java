package page115_Searching;
import ibio.IBIO;

/**
 * Performs a binary search on an array of random int's.
 * @author Richard, modified by MHayes
 * @version 041003
 */
public class BinarySearch
{
    private int[] data = new int[20];

    public static void main(String[] args)
    {        
        BinarySearch bs = new  BinarySearch();

        // Fill the array with random int's
        bs.fillData();
        bs.displayData();

        // Prompt user for a number to search for
        int searchValue = IBIO.inputInt("\nEnter the search value>: ");
        while (searchValue != 0)
        {
            bs.binarySearch(searchValue);
            searchValue = IBIO.inputInt("> ");
        }
    }
   
    // Fill the array with sorted data
    private void fillData()
    {    
        for (int i = 0; i < data.length; i++)
        {
            data[i] = i;
        }
    }
    
    /**
     *  Display the contents of data[] 
     *  @param data The array to be shown
     */
    private void displayData()
    {
        StringBuffer line = new StringBuffer();
        
        for (int i = 0; i < data.length; i++)
        {
            line.append(data[i] + " ");
        }
        IBIO.output("\nData = " + line.toString());
    }
    
    /**
     *  Perform a binary search for 'wanted' in data[].
     *  data[] must be sorted in ascending order.
     *  1. Compare 'wanted' to the mid-point of data[]
     *  2. Discard that half of the list that does not contain 'wanted'.  
     *  3. Repeat.
     *
     *  @param data   The array to be searched.
     *  @param wanted The item to search for.
     */
    private void binarySearch(int searchValue)
    {
        boolean found = false;           // flag to indicate end of search
        int start  = 0;                  // first element of part to be searched
        int end = (data.length - 1);     // last element of part to be searched
        int middle = 0;
        int iterations = 0;              // number of elements visited.
        
        // Loop until found or no more elements to search
        while (!found && end >= start)
        {
            // Calculate the middle index of the array
            middle = (start + end) / 2;
            
            // Compare searchValue to the middle element
            if (searchValue == data[middle])
            {
                found = true;
            }
            else
            {
                // Keep half of the array and try again
                if (searchValue > data[middle])
                {
                    start = middle + 1;         // Keep the upper half
                }
                else
                {
                    end = middle - 1;           // Keep the lower half
                }
            }
            iterations++;
        }

        // Display results
        if (found)
        {
            IBIO.output(searchValue + " found at element " + (middle + 1));
            IBIO.output(iterations + " elements visited.");
        }
        else
        {
            IBIO.output(searchValue + " not found.");
        }
    }   
}
