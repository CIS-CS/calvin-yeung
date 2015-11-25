package page115_Searching;
import ibio.IBIO;

/**
 * Performs a linear (sequential) search on an array of int's.
 *
 * @author Richard, modified by MHayes
 * @version May 2010
 */
public class LinearSearch
{
    private int[] data = new int[20];     // Store the data here

    /**
     * Entry point to application.
     * @param args command line arguments
     */
    public static void main(String[] args)
    {
        IBIO.output("\nLinear (sequential) Search:");
        LinearSearch ls = new LinearSearch();        
        ls.fillData();                    
        ls.displayData();
        
        // Prompt user for search value. Q to quit.
        int searchValue = IBIO.inputInt("\nEnter search item. 0 to quit> ");
        while (searchValue != 0)
        {        
            ls.linearSearch(searchValue);
            searchValue = IBIO.inputInt("> ");
        }
    }
    
    // Fill data[] with random numbers.
    private void fillData()
    {
        for (int i = 0; i < data.length; i++)
        {
            data[i] = (int)(Math.random() * 1000);
        }
    }
    
    // Display the data
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
     * Performs a linear (sequential) search.
     * Each element in the array is inspected.
     * Terminate early if the item is found.
     *
     * @param searchValue The number to search for.
     */
    private void linearSearch(int searchValue)
    {
        boolean found = false;

        // Compare 'wanted' to each element in the array
        for (int i = 0; i < data.length; i++)
        {
            if (data[i] == searchValue)
            {
                IBIO.output(searchValue + " found at element " + i);
                found = true;
                break;
            }
        }
        if (!found)
        {
            IBIO.output(searchValue + " not found.");
        }
    }    
}
