

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TicketMachineTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TicketMachineTest
{
    /**
     * Default constructor for test class TicketMachineTest
     */
    public TicketMachineTest()
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
    public void testPrintTicket()
    {
        TicketMachine ticketMa1 = new TicketMachine(100);
        assertEquals(false, ticketMa1.printTicket());
        assertEquals(true, ticketMa1.insertMoney(100));
        assertEquals(true, ticketMa1.printTicket());
        assertEquals(0, ticketMa1.getBalance());
        assertEquals(true, ticketMa1.insertMoney(101));
        assertEquals(true, ticketMa1.printTicket());
        assertEquals(1, ticketMa1.getBalance());
    }

    @Test
    public void testInsertMoney()
    {
        TicketMachine ticketMa1 = new TicketMachine(100);
        assertEquals(true, ticketMa1.insertMoney(100));
        assertEquals(false, ticketMa1.insertMoney(0));
        assertEquals(false, ticketMa1.insertMoney(-1));
    }
}



