

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ClubTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ClubTest
{
    /**
     * Default constructor for test class ClubTest
     */
    public ClubTest()
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
        Club club1 = new Club();
        assertEquals(0, club1.numberOfMembers());
        Membership membersh1 = new Membership("bob", 12, 2014);
        assertEquals(true, club1.join(membersh1));
        assertEquals(1, club1.numberOfMembers());
        Membership membersh2 = new Membership("joe", 12, 2014);
        assertEquals(1, club1.numberOfMembers());
        assertEquals(true, club1.join(membersh2));
        assertEquals(2, club1.numberOfMembers());
        assertEquals(false, club1.join(membersh1));
        assertEquals(2, club1.numberOfMembers());
        assertEquals(false, club1.join(membersh2));
        assertEquals(2, club1.numberOfMembers());
    }
}

