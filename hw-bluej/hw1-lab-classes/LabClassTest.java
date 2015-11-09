import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class LabClassTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LabClassTest
{
    /**
     * Default constructor for test class LabClassTest
     */
    public LabClassTest()
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
    public void testSetAdvisoryGroup()
    {
        LabClass labClass1 = new LabClass(10);
        labClass1.setAdvisory("12G1");
        assertEquals("12G1", labClass1.getAdvisory());
        assertNotSame(false, labClass1.getAdvisory());
    }
}
