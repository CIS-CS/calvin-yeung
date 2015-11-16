

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClockDisplayTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClockDisplayTest
{
    /**
     * Default constructor for test class ClockDisplayTest
     */
    public ClockDisplayTest()
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
    public void testDefaultClock()
    {
        ClockDisplay clockDis1 = new ClockDisplay();
        assertEquals("12:00 a.m.", clockDis1.getTime());
    }

    @Test
    public void testRollover()
    {
        ClockDisplay clockDis1 = new ClockDisplay(11, 59, "a.m.");
        assertEquals("11:59 a.m.", clockDis1.getTime());
        clockDis1.timeTick();
        assertEquals("12:00 p.m.", clockDis1.getTime());
        clockDis1.setTime(11, 59, "p.m.");
        assertEquals("11:59 p.m.", clockDis1.getTime());
        clockDis1.timeTick();
        assertEquals("12:00 a.m.", clockDis1.getTime());
    }
}


