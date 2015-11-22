

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MusicOrganizerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MusicOrganizerTest
{
    /**
     * Default constructor for test class MusicOrganizerTest
     */
    public MusicOrganizerTest()
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
    public void testListAllFiles()
    {
        MusicOrganizer musicOrg1 = new MusicOrganizer();
        assertEquals(null, musicOrg1.listAllFiles());
        musicOrg1.addFile("song0");
        assertEquals("\n0: song0", musicOrg1.listAllFiles());
        musicOrg1.addFile("song1");
        assertEquals("\n0: song0\n1: song1", musicOrg1.listAllFiles());
    }

    @Test
    public void testListMatching()
    {
        MusicOrganizer musicOrg2 = new MusicOrganizer();
        assertEquals(null, musicOrg2.listMatching(""));
        assertEquals(null, musicOrg2.listMatching("x"));
        musicOrg2.addFile("song0");
        assertEquals(null, musicOrg2.listMatching("x"));
        assertEquals("song0", musicOrg2.listMatching(""));
        assertEquals("song0", musicOrg2.listMatching("g"));
        musicOrg2.addFile("song1");
        assertEquals(null, musicOrg2.listMatching(" "));
        assertEquals("song0 song1", musicOrg2.listMatching("s"));
        assertEquals("song1", musicOrg2.listMatching("1"));
        assertEquals("song0", musicOrg2.listMatching("0"));
    }
}


