

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * The test class AuctionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AuctionTest
{
    /**
     * Default constructor for test class AuctionTest
     */
    public AuctionTest()
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
    public void testMakeABid()
    {
        Auction auction2 = new Auction();
        Person mark = new Person("mark");
        auction2.enterLot("dog");
        assertEquals(true, auction2.makeABid(1, mark, 10));
        assertEquals(false, auction2.makeABid(1, mark, 9));
    }

    @Test
    public void testClose()
    {
        Auction auction1 = new Auction();
        Person mark = new Person("mark");
        auction1.enterLot("aaa");
        auction1.enterLot("bbb");
        auction1.enterLot("ccc");
        assertEquals(0, auction1.close());
        assertEquals(true, auction1.makeABid(1, mark, 100));
        auction1.showLots();
        assertEquals(1, auction1.close());
        assertEquals(true, auction1.makeABid(2, mark, 200));
        assertEquals(2, auction1.close());
        auction1.showLots();
        assertEquals(true, auction1.makeABid(3, mark, 300));
        assertEquals(3, auction1.close());
    }


    @Test
    public void testGetUnsold()
    {
        Auction auction1 = new Auction();
        Person mark = new Person("mark");
        auction1.enterLot("aaa");
        auction1.enterLot("bbb");
        
        ArrayList<Lot> unsoldLots = auction1.getUnsold();
        assertEquals(2, unsoldLots.size());
        
        assertEquals(true, auction1.makeABid(1, mark, 100));
        unsoldLots = auction1.getUnsold();
        assertEquals(1, unsoldLots.size());
        
        assertEquals(true, auction1.makeABid(2, mark, 100));
        unsoldLots = auction1.getUnsold();
        assertEquals(0, unsoldLots.size()); 
    }

    @Test
    public void testRemove()
    {
        Auction auction1 = new Auction();
        auction1.enterLot("aaa");
        auction1.enterLot("bbb");
        auction1.enterLot("ccc");
        
        assertEquals(false, auction1.removeLot(0));
        assertEquals(false, auction1.removeLot(4));
        assertEquals(true, auction1.removeLot(2));
        assertEquals(true, auction1.removeLot(3));
        assertEquals(true, auction1.removeLot(1));        
        auction1.enterLot("ddd");
        assertEquals(true, auction1.removeLot(4));
        assertEquals(0, auction1.close());
    }

    @Test
    public void testGetLot()
    {
        Auction auction1 = new Auction();
        auction1.enterLot("aaa");
        auction1.enterLot("bbb");
        auction1.enterLot("ccc");
        
        Lot lot = auction1.getLot(2);
        assertEquals(2, lot.getNumber());
        assertEquals(true, auction1.removeLot(2));
        
        lot = auction1.getLot(3);
        assertEquals(3, lot.getNumber());
        assertEquals(true, auction1.removeLot(3));
        
        auction1.enterLot("ddd");
        lot = auction1.getLot(4);
        assertEquals(4, lot.getNumber());
        assertEquals(true, auction1.removeLot(4));        
    }
}






