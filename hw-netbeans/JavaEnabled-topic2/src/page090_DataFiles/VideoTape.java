package page090_DataFiles;

/**
 *  A class for storing information about a video tape.
 *  Same as previous VideoTape class, except that the constructor 
 *  validates its arguments.
 *
 *  @author Richard
 *  @version 200903
 */
public class VideoTape
{
    // instance variables - or data members
    private   String  title;     // title of the video
    private   int     length;    // in minutes
    private   boolean lent;      // is it lent to someone

    /**
     *  No argument Constructor for objects of class VideoTape
     */
    public VideoTape()
    {
        // initialise instance variables
        this.title  = null;
        this.length = 0;
        this.lent   = false;
    }

    /**
     *  3-arg Constructor.  Arguments are validated.
     */
    public VideoTape(String title, int length, boolean lent)
        throws VideoTapeException
    {
        if (title == null || title.length() == 0)
        {
            throw new VideoTapeException("Invalid video title");
        }
        else if (length < 1)
        {
            throw new VideoTapeException("Invalid video length");
        }
        else if (lent)
        {
            throw new VideoTapeException("Newly-created videos are not lent");
        }
        else
        {
            setTitle(title);
            setLength(length);
            setLent(lent);
        }
    }

    //  Mutator methods change the objects data fields

    /**
     *  set the title
     *
     *  @param  title   The title of the video
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     *  set the length
     *
     *  @param  length The video length in minutes
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     *  set the status of lent
     *
     *  @param  lent    true if the video is on loan, else false.
     */
    public void setLent(boolean lent)
    {
        this.lent = lent;
    }

    //  Accessor methods return the objects data fields

    /**
     *  Return the title
     *
     *  @return String the video title
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * get the length
     *
     * @return int the video length in minutes
     */
    public int getLength()
    {
        return this.length;
    }

    /**
     * get the status of lent
     *
     * @return boolean lent true if the video is on loan
     */
    public boolean isLent()
    {
        return this.lent;
    }

    /**
     * All Classes should override this method (derived from Object)
     *
     * @return String the VideoTape object as a String
     */
    public String toString()
    {
        return ( this.getTitle().trim() + " - " +
                 this.getLength() + " - " +
                 this.isLent() );
    }
}
