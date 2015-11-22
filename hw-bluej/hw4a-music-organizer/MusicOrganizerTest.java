
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MusicOrganizerTest.
 *
 * @author  MHayes
 * @version 22-Nov-2015
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
    public void testValidIndex()
    {
        MusicOrganizer musicOrg1 = new MusicOrganizer();
        assertEquals(false, musicOrg1.validIndex(-1));
        assertEquals(false, musicOrg1.validIndex(0));
        assertEquals(false, musicOrg1.validIndex(1));
        musicOrg1.addFile("song1");
        musicOrg1.addFile("song2");
        assertEquals(false, musicOrg1.validIndex(-1));
        assertEquals(true, musicOrg1.validIndex(0));
        assertEquals(true, musicOrg1.validIndex(1));
        assertEquals(false, musicOrg1.validIndex(2));
    }

    @Test
    public void testRemoveFile()
    {
        MusicOrganizer musicOrg1 = new MusicOrganizer();
        musicOrg1.addFile("song1");
        assertEquals(false, musicOrg1.removeFile(-1));
        assertEquals(false, musicOrg1.removeFile(1));
        assertEquals(true, musicOrg1.removeFile(0));
    }

    @Test
    public void testListFile()
    {
        MusicOrganizer musicOrg1 = new MusicOrganizer();
        musicOrg1.addFile("song1");
        assertEquals(false, musicOrg1.listFile(-1));
        assertEquals(true, musicOrg1.listFile(0));
        assertEquals(false, musicOrg1.listFile(1));
    }
}




