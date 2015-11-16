import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BookTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class BookTest
{
    private Book book1;

    /**
     * Default constructor for test class BookTest
     */
    public BookTest()
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
        book1 = new Book("mark", "java is fun", 100, true);
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
    public void testAccessorMethods()
    {
        assertEquals("mark", book1.getAuthor());
        assertEquals(0, book1.getBorrowed());
        assertEquals(100, book1.getPages());
        assertEquals("", book1.getRefNumber());
        assertEquals("java is fun", book1.getTitle());
        assertEquals(true, book1.isCourseText());
    }

    @Test
    public void testSetRefNumber()
    {
        assertEquals(false, book1.setRefNumber("12"));
        assertEquals(true, book1.setRefNumber("123"));
        assertEquals(true, book1.setRefNumber("1234"));
    }

    @Test
    public void testGetBorrowed()
    {
        book1.borrow();
        assertEquals(1, book1.getBorrowed());
        book1.borrow();
        book1.borrow();
        assertEquals(3, book1.getBorrowed());
    }
}