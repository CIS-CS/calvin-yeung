

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
    public void testGetNumberOfFiles2()
    {
        MusicOrganizer musicOrg1 = new MusicOrganizer();
        musicOrg1.stopPlaying();
        assertEquals(0, musicOrg1.getNumberOfFiles2());
        musicOrg1.addFile("s1");
        assertEquals(1, musicOrg1.getNumberOfFiles2());
        musicOrg1.addFile("s2");
        musicOrg1.addFile("s3");
        assertEquals(3, musicOrg1.getNumberOfFiles2());
    }
}

