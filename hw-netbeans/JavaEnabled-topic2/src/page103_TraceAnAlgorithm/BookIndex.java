package page103_TraceAnAlgorithm;

/**
 *  A Class for storing a book (book number + position in array)
 * @author Richard
 * @version 240903
 */
public class BookIndex
{
    // instance variables - or data members
    private String bookNum;       // book reference number
    private int    pos;           // book details location in main file
    
    /**
     * No argument Constructor
     */
    public BookIndex()
    {
        // initialise instance variables
        this.bookNum = null;
        this.pos = -1;
    }
    
    /**
     * Constructor with data
     */
    public BookIndex(String bookNum, int pos) throws BadBookException
    {
        setBookNum(bookNum);
        setPos(pos);
    }
    
    /**
     *  Set the book number.
     *  Validates the fiction indicator, the shelf unit, and shelf number.
     *
     * @param  bookNum The book number
     * @throws BadBookException if book number is invalid
     */
    public void setBookNum(String bookNum) throws BadBookException
    {
        // check the length
        if (bookNum.length() != 6)
        {
            throw new BadBookException("Book number must have 6 characters");
        }
        char ch0 = bookNum.charAt(0);   // Fiction indicator
        char ch1 = bookNum.charAt(1);   // Shelf unit
        char ch2 = bookNum.charAt(2);   // Shelf number
        
        if ( (ch0 != 'F') && (ch0 != 'N') )
        {
            throw new BadBookException("Book number must start with N or F");
        }
        if ( (ch1 < 'A') && (ch1 > 'H') )
        {
            throw new BadBookException("Shelf Unit must be between A and H");
        }
        if ( (ch2 < '1') && (ch2 > '4') )
        {
            throw new BadBookException("Shelf number must be between 1 and 4");
        }
        this.bookNum = bookNum;
    }
    
    /**
     * Set the position
     *
     * @param  pos  
     */
    public void setPos(int pos)
    {
        this.pos = pos;
    }
    
    //------------------------------------------------------- Accessors
    /**
     * Return the bookNum
     *
     * @return String the Book number
     */
    public String getBookNum()
    {
        return this.bookNum;
    }
    
    /**
     * get the position  of the entry in the main file
     *
     * @return int the position of the book
     */
    public int getPos()
    {
        return this.pos;
    }
    
    //------------------------------------------------------- toString()
    /**
     *
     * @return String the BookIndex object as a String
     */
    public String toString()
    {
        return ( this.getBookNum().trim() + " - " + this.getPos() );
    }
}
