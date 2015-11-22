

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class HeaterTest.
 *
 * @author  MHayes
 * @version 21-Nov-2015
 */
public class HeaterTest
{
    /**
     * Default constructor for test class HeaterTest
     */
    public HeaterTest()
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
    public void testConstructor()
    {
        Heater heater1 = new Heater(5, 100);
        assertEquals(15.0, heater1.getTemperature(), 0.1);
    }

    @Test
    public void testWarmer()
    {
        Heater heater1 = new Heater(5, 25);
        heater1.warmer();
        assertEquals(20.0, heater1.getTemperature(), 0.1);
        heater1.warmer();
        assertEquals(25.0, heater1.getTemperature(), 0.1);
        heater1.warmer();
        assertEquals(25.0, heater1.getTemperature(), 0.1);
    }

    @Test
    public void testCooler()
    {
        Heater heater1 = new Heater(5, 25);
        assertEquals(15.0, heater1.getTemperature(), 0.1);
        heater1.cooler();
        assertEquals(10.0, heater1.getTemperature(), 0.1);
        heater1.cooler();
        assertEquals(5.0, heater1.getTemperature(), 0.1);
        heater1.cooler();
        assertEquals(5.0, heater1.getTemperature(), 0.1);
    }

    @Test
    public void testSetIncrement()
    {
        Heater heater1 = new Heater(5, 25);
        assertEquals(false, heater1.setIncrement(-1));
        heater1.warmer();
        assertEquals(20.0, heater1.getTemperature(), 0.1);
        assertEquals(false, heater1.setIncrement(0.0));
        heater1.cooler();
        assertEquals(15.0, heater1.getTemperature(), 0.1);
        assertEquals(true, heater1.setIncrement(1.0));
        heater1.warmer();
        assertEquals(16.0, heater1.getTemperature(), 0.1);
        heater1.cooler();
        assertEquals(15.0, heater1.getTemperature(), 0.1);
    }
}





