package page095_RandomAccessFile;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 *  This class is the bridge between the UI (VideoStore) and the datastore (RAF).
 *  It reads/writes VideoTape objects to the RAF on behalf of VideoStore.
 *  
 *  @author MHayes
 * @version Apr 2008
 */
public class Persister {
    
    private RandomAccessFile raf;
    private final String FILENAME = "c:\\videos-random.dat";    
    
    /** 
     *  Creates a new instance of Persister. Attempts to open the RAF file.
     */
    public Persister() throws IOException {
        try
        {
            raf = new RandomAccessFile(FILENAME, "rw");
        }
        catch(IOException e)
        {
            throw e; 
        }        
    }
    
    /** 
     *  Writes a VideoTape object to the RAF at some offset.
     */    
    public void writeRecord(VideoTape video, long offset) throws IOException
    {
        try 
        {        
            // Seek to the position
            raf.seek(offset);

            // Write the data
            raf.writeBytes(video.getAdjustedTitle());
            raf.writeInt(video.getLength());
            raf.writeBoolean(video.isLent());
        }
        catch(IOException e)
        {
            throw e;
        }
    }
    
    /** 
     *  Reads a VideoTape object from the RAF. 
     */    
    public VideoTape readRecord(long offset) throws IOException
    {
        try
        {        
            // Seek to the position
            raf.seek(offset);

            // Read the title into a byte[]
            byte[] temp = new byte[VideoTape.TITLE_BYTES];
            raf.readFully(temp);

            // Convert the byte[] to a String
            String title = new String(temp);
            title = title.trim();           // remove the trailing blanks

            // Read the video length and the lent flag
            int length = raf.readInt();
            boolean lent = raf.readBoolean();

            // Create a new VideoTape object
            VideoTape video = new VideoTape(title, length, lent);
            
            // Return the video
            return(video);
        }
        catch(IOException e)
        {
            throw e;
        }
    }
    
    /** 
     *  Returns the length of the RAF in bytes. 
     */    
    public long getFileLength() throws IOException
    {
        try
        {
            return raf.length();
        }
        catch(IOException e)
        {
            throw e;
        }
    }
    
    /** 
     *  Returns the name of the RAF. 
     */    
    public String getFileName() 
    {
        return FILENAME;
    }    
    
    /** 
     *  Closes the RAF file. 
     */    
    public void closeFile() throws IOException
    {
        try
        {
            raf.close();
        }
        catch(IOException e)
        {
            throw e;
        }
    }
}
