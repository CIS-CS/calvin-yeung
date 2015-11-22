/**
 * Store the details of a music track,
 * such as the artist, title, and file name.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Track
{
    // The artist.
    private String artist;
    // The track's title.
    private String title;
    // Where the track is stored.
    private String filename;
    private String year;
    private int len;
    
    /**
     * Constructor for objects of class Track.
     * @param artist The track's artist.
     * @param title The track's title.
     * @param filename The track file. 
     */
    public Track(String artist, String title, String filename, int len, String year)
    {
        setDetails(artist, title, filename, len, year);
    }
    
    /**
     * Constructor for objects of class Track.
     * It is assumed that the file name cannot be
     * decoded to extract artist and title details.
     * @param filename The track file. 
     */
    public Track(String filename)
    {
        setDetails("unknown", "unknown", filename, 0, "unknown");
    }
    
    /**
     * Return the artist.
     * @return The artist.
     */
    public String getArtist()
    {
        return artist;
    }
    
    /**
     * Return the title.
     * @return The title.
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * Return the file name.
     * @return The file name.
     */
    public String getFilename()
    {
        return filename;
    }
    
    public String getYear() {
        return year;
    }
    
    public int getLength() {
        return len;
    }
    
    public String getDetails()
    {
        String s = artist + ": " + title + "  (file: " + filename + ")  " + len + "  " + year;
        System.out.println(s);
        return s;
    }
    
    private void setDetails(String artist, String title, String filename, int len, String year) {
        this.artist = artist;
        this.title = title;
        this.filename = filename;
        this.len = len;
        this.year = year;
    }
    
}
