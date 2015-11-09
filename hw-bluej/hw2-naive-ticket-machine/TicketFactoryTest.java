

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TicketFactoryTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TicketFactoryTest
{
    /**
     * Default constructor for test class TicketFactoryTest
     */
    public TicketFactoryTest()
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
    public void testTicketMachineConstructor()
    {
        TicketFactory factory = new TicketFactory();
        assertNotNull(factory.getTicketMachine(1));
        assertEquals(null, factory.getTicketMachine(0));
        assertEquals(null, factory.getTicketMachine(-1));
    }
}

