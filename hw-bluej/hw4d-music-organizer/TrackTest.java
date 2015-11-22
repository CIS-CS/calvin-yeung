

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TrackTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TrackTest
{
    /**
     * Default constructor for test class TrackTest
     */
    public TrackTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAllMethods()
    {
        MusicOrganizer musicOrg2 = new MusicOrganizer();
        musicOrg2.addFile("s5");
        musicOrg2.addTrack(new Track("s6"));
        assertEquals(6, musicOrg2.getNumberOfTracks());
        Track track1 = new Track("s7");
        Track track2 = new Track("bob", "bluebird", "s8", 3, "1987");
        assertEquals("unknown", track1.getArtist());
        assertEquals("unknown", track1.getYear());
        track1.getYear();
        assertEquals("unknown: unknown  (file: s7)  0  unknown", track1.getDetails());
        assertEquals("s7", track1.getFilename());
        assertEquals(0, track1.getLength());
        assertEquals("unknown", track1.getYear());
        assertEquals("bob", track2.getArtist());
        assertEquals("bob: bluebird  (file: s8)  3  1987", track2.getDetails());
        assertEquals("s8", track2.getFilename());
        assertEquals("bluebird", track2.getTitle());
        assertEquals("1987", track2.getYear());
    }
}

