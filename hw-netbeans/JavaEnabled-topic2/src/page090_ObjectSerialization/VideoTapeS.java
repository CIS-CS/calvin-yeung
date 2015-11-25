// VideoTapeS.java

package page090_ObjectSerialization;

import java.io.Serializable;

/**
 *  This class is a VideoTape that implements the Serializable interface.
 *
 *  @author Richard
 *  @version 200903
 */
public class VideoTapeS implements Serializable
{
    // instance variables - or data members
    private String  title;      // title of the video
    private int     length;     // in minutes
    private boolean lent;       // is it lent to someon
    
    /**
     * No argument Constructor for objects of class VideoTape
     */
    public VideoTapeS()
    {
        // initialise instance variables
        title = null;
        length = 0;
        lent = false;
    }
    /**
     * Constructor for objects of class VideoTape
     */
    public VideoTapeS(String title, int length, boolean lent)
    {
        setTitle(title);
        setLength(length);
        setLent(lent);
    }
    
    /**
     * set the title
     *
     * @param  title    The video title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * set the length
     *
     * @param  length   The video length in minutes
     */
    public void setLength(int length)
    {
        this.length = length;
    }
    
    /**
     * set the status of lent
     *
     * @param  lent true if the video is on loan, else false.
     */
    public void setLent(boolean lent)
    {
        this.lent = lent;
    }
    
    /**
     * Return the title
     *
     * @return String the video title
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
        return (getTitle() + " - " + getLength() + " - " + isLent());
    }
}
