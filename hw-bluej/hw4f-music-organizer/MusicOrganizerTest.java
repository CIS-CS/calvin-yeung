

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
    public void test() {
        MusicOrganizer m = new MusicOrganizer();
        while(m.getNumberOfTracks() > 0) m.removeTrack(0);
        assertEquals(null, m.playAllRandom());
        m.addTrack(new Track("bob", "hi", "a.mp3"));
        assertEquals("a.mp3", m.playRandom(1));
        m.addTrack(new Track("", "", "b.mp3"));
        m.addTrack(new Track("", "", "c.mp3"));
        assertEquals(null, m.playRandom(10));
        assertEquals(2, m.playRandom(2).split(" ").length);
    }
}
