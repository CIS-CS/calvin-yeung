// InsertBook.java

package page103_TraceAnAlgorithm;

import original.IBIO;

/**
 *  A class to test the insert book trace chapter 2
 * 
 *  @author Richard 
 *  @version 240903
 */
public class InsertBook
{
    static final int MAX_BOOKS = 8;
    private BookIndex[] bookIndexes = new BookIndex[MAX_BOOKS];
    
    public static void main(String[] args)
    {
        new InsertBook();
    }
    /**
     * Constructor set up data array, call inseretion algorithm
     */
    public InsertBook()
    {
        // input data
        int newPos = 7;
        String bookNum = "FA2139";
        
        setupDataArray(bookIndexes);
        insert(bookNum, newPos);
    }
    
    private void setupDataArray(BookIndex[] bookIndexes)
    {
        try
        {
            bookIndexes[0] = new BookIndex("FA1021", 3);
            bookIndexes[1] = new BookIndex("FA1122", 6);
            bookIndexes[2] = new BookIndex("FA1233", 2);
            bookIndexes[3] = new BookIndex("FA2099", 5);
            bookIndexes[4] = new BookIndex("FA2103", 0);
            bookIndexes[5] = new BookIndex("FA2145", 4);
            bookIndexes[6] = new BookIndex("FA2238", 1);
            bookIndexes[7] = new BookIndex("NB1000", 7);
        }
        catch(BadBookException bbe)
        {
            IBIO.output("oops in setup" + bbe.getMessage());
        }
        
    }
    
    private void insert(String bookNum, int newPos)
    {
        int i = newPos;      // pointer to the array
        //Shuffle up array entries from top end to entry position.
        try
        {
            // set up trace table
            IBIO.output("newPos  bookNum  i  bookIndexes[i]  <condition>");
            while ( (i > 0) && (bookNum.compareTo(bookIndexes[i].getBookNum()) < 0) )
            {
                //output trace data
                IBIO.output( newPos + "  " + bookNum + "  " + i + "  "
                        + bookIndexes[i].getBookNum() + "  "
                        + ( (i >= 0) && (bookNum.compareTo(bookIndexes[i].getBookNum()))>0 ) );
                bookIndexes[i] = bookIndexes[i - 1];
                i = i - 1;
            }
            // Check boundary condition at i = 0
            if (i != 0)
            {
                i = i + 1; // insert above smaller entry
            }
            bookIndexes[i] = new BookIndex(bookNum, newPos);
        }
        catch(BadBookException bbe)
        {
            IBIO.output("oops in insert" + bbe.getMessage());
        }
    }
}
