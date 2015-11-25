/*
 * VideoTapeFile.java
 *
 * Created on October 21, 2006, 6:04 PM
 */
package page095_RandomAccessFileGUI;
import java.io.*;

public class VideoTapeFile extends VideoTape
{
    static final int TITLE_BYTES  = 25;  // length of the video title
    static final int LENGTH_BYTES = 4;   // an int will be stored as four bytes (MH: was 2)
    static final int LENT_BYTES   = 1;   // lent is boolean - 1 byte

    // Length of a record - used to seek to correct position in the data file.
    static final int RECORD_BYTES = TITLE_BYTES + LENGTH_BYTES + LENT_BYTES;

    /**
     * 	No argument Constructor, calls VideoTape constructor
     * 	super = a call to the super class constructor
     */
    public VideoTapeFile()
    {
        super();
    }

    /**
     * Constructor for objects of class VideoTape
     */
    public VideoTapeFile(String title, int length, boolean lent)
    {
      	super(title, length, lent);
      	super.setTitle(fixLength(title, TITLE_BYTES));
    }

    /**
     * 	Method to add item to data file
     *
     * 	@param theFile   The file to add to - must be open for writing
     * 	@param theVideo  The object to be written into the file
     * 	@param posToAdd  Position to add the record in the file
     *
     * 	@throws IOException if unable to complete the write operation
     */
    public static void writeRecord( RandomAccessFile theFile,
                                    VideoTapeFile theVideo,
                                    long posToAdd ) throws IOException
    {	// Seek to the position
      	theFile.seek(posToAdd);

      	// Write the data
      	theFile.writeBytes(theVideo.getTitle());
      	theFile.writeInt(theVideo.getLength());
      	theFile.writeBoolean(theVideo.isLent());
    }

    /**
     * 	Method to read item from data file
     *
     * 	@param theFile   The file to add to - must be open
     * 	@param posToRead The position to start reading in the file
     *
     * 	@return a VideoTapeFile object (null if not read)
     *
     * 	@throws IOException if unable to complete the read operation
     */
    public static VideoTapeFile readRecord( RandomAccessFile theFile, long posToRead )
    		throws IOException
    {
		// Seek to the position
      	theFile.seek(posToRead);

      	// Read the title into a byte[]
      	byte[] theTitle = new byte[TITLE_BYTES];
      	theFile.readFully(theTitle);

      	// Convert the byte[] to a String
      	String title = new String(theTitle);

      	// Read the video length and the lent flag
      	int length = theFile.readInt();
      	boolean lent = theFile.readBoolean();

      	// Return a VideoTapeFile
      	return new VideoTapeFile(title, length, lent);
    }

    /**
     * 	Method to fix length of title String
     *
     * 	@param title The original String
     * 	@param size  The fixed length size in bytes
     *
     * 	@return a String of exactly size bytes
     */
    private String fixLength(String title, int size)
    {
      	StringBuffer sb = new StringBuffer(title);
      	sb.setLength(size);
      	return sb.toString();
    }

    /**
     * 	Method to return record length
     *
     * 	@return length of a VideoTapeFile object in bytes
     */
    public static int length()
    {
      	return RECORD_BYTES;
    }

}
