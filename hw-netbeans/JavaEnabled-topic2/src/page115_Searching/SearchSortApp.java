package page115_Searching;
import ibio.IBIO;

/**
 * Illustrates the required search and sort methods for CS HL.
 * Revised a bit by MH.
 * @author Richard
 * @version 041003
 */
public class SearchSortApp
{
    // basic data array
    private int[] data = new int[20];
    private static final int MAX = 998;
    private static final int INTERVAL = 6;

    public static void main(String[] args)
    {
        SearchSortApp app = new SearchSortApp();

        app.bubbleSort();
        app.selectionSort();
        app.insertionSort();

        int searchValue = IBIO.inputInt("Enter search value : ");
        app.linearSearch(searchValue);

        searchValue = IBIO.inputInt("Enter search value : ");
        app.binarySearch(searchValue);
    }

    //--------------------------------------------------------------------------

    // Used by the sort methods
    private void fillDataRandom()
    {
        // Puts random values from 1 to MAX into the array
        for (int i = 0; i < data.length; i = i + 1)
        {
            data[i] = (int) (Math.random() * MAX) + 1;
        }
    }

    // Used by the search methods
    private void fillDataSorted()
    {
        // Puts ordered random values into the array
        data[0] = (int) (Math.random() * INTERVAL) + 1;
        for (int i = 1; i < data.length; i = i + 1)
        {
            data[i] = data[i - 1] + (int) (Math.random() * INTERVAL) + 1;
        }
    }

    // Display the data
    private void displayData()
    {
        StringBuffer line = new StringBuffer(data.length*5);
        for (int i = 0; i < data.length; i = i + 1)
        {
            line.append(data[i] + " ");
        }
        IBIO.output(new String(line));
    }

    //--------------------------------------------------------------------------

    // Sort the data using BubbleSort
    private void bubbleSort()
    {
        IBIO.output("\nbubble sorting...");
        fillDataRandom();
        displayData();

        // top is the boundary between the sorted and unsorted portion
        for (int top = (data.length - 1); top > 0; top = top - 1)
        {
            for (int upper = 1; upper <= top; upper = upper + 1)
            {
                // upper and lower are the neighbours being compared
                int lower = upper - 1;
                if (data[upper] < data[lower])
                {
                    //swap
                    int temp = data[upper];
                    data[upper] = data[lower];
                    data[lower] = temp;
                }
            }
        }
        displayData();
    }

    //--------------------------------------------------------------------------

    // Sort the data using SelectionSort
    private void selectionSort()
    {
        IBIO.output("\nselection sorting...");
        fillDataRandom();
        displayData();

        // pos is the boundary between sorted and unsorted parts of the array
        for (int pos = 0; pos < data.length; pos = pos + 1)
        {
            // find the position of the smallest value in the unsorted part
            // then swap it with the value at the current position
            int smallPos = getIndexOfMinValue(data, pos, data.length - 1);
            int temp = data[smallPos];
            data[smallPos] = data[pos];
            data[pos] = temp;
        }
        displayData();
    }

    // Get the index of the smallest value between start and end
    // Called by selectionSort()
    private int getIndexOfMinValue( int[] data, int start, int end)
    {
        int minSoFar = data[start];  // mimimum value found so far
        int minPos = start;          // position of minSoFar in array
        
        for(int pos = start + 1; pos <= end; pos = pos + 1)
        {
            if (data[pos] < minSoFar)
            {
                // found a new mimimum
                minSoFar = data[pos];
                minPos = pos;
            }
        }
        return minPos;
    }

    //--------------------------------------------------------------------------

    // Sort the data with InsertionSort
    private void insertionSort()
    {
        IBIO.output("insertion sorting...");
        fillDataRandom();
        displayData();

        int cp = 0; // current position - value in unsorted list being examined
        int pt;     // pointer to number in sorted part being compared with cp
        int tm;     // temporary store for number to be inserted
        
        while ( cp != (data.length - 1) )  //while not at end of array
        {
            cp = cp + 1;     // increment current position to first in unsorted
            pt = cp;         // pointer into sorted part - starts at top
            tm = data[cp];   // temp store for element to insert
            // while not at start, and next value is still too big,
            // shuffle up current element by 1
            while ( (pt > 0) && (data[pt-1] > tm) )
            {
                data[pt] = data[pt - 1];
                pt = pt - 1;
            }
            // insert the temp value into the sorted part
            data[pt] = tm;
        }
        displayData();
    }
    
    //--------------------------------------------------------------------------
    
    // Use linear search to find the item
    private void linearSearch(int searchValue)
    {
        IBIO.output("\nLinear search...");
        fillDataSorted();
        displayData();

        boolean found = false;  // flag to indicate end of search
        int pos = 0;            // current position in array
        
        while ( (pos < data.length) && !found )
        {
            found = (data[pos] == searchValue);
            pos = pos + 1;
        }
        if (found)
        {
            // NB: gives position in the list rather than array element
            //     (which would be (pos-1))!
            
            IBIO.output("Found the item at position: " + pos);
        }
        else
        {
            IBIO.output("The item " + searchValue + " was not found.");
        }
    }

    //--------------------------------------------------------------------------
    
    /**
     * This method carries out a binary search by examining the mid element
     * in the list and then discarding half.
     *
     * @param the array to be searched
     * @param the wanted item
     */
    private void binarySearch(int searchValue)
    {
        IBIO.output("\nBinary search...");
        fillDataSorted();
        displayData();

        boolean found = false;  // flag to indicate end of search
        int start = 0;          // first element of part to be searched
        int end = (data.length - 1);   // last element of part to be searched
        
        // loop until found or no more elements to search
        while ( (end >= start) && !found )
        {
            // find mid point of current list
            int mid = (start + end) / 2;
            found = (data[mid] == searchValue);
            if (found)
            {
                IBIO.output("Found the item at element: " + mid);
            }
            else
            {
                // discard half of the array and try again
                if (data[mid] < searchValue)
                {
                    start = mid + 1;
                }
                else
                {
                    end = mid - 1;
                }
            }
        }
        if (!found)
        {
            IBIO.output("The item " + searchValue + " was not found.");
        }
    }
}
