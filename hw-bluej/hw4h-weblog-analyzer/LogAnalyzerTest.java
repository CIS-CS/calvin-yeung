import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * The test class LogAnalyzerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LogAnalyzerTest
{
    /**
     * Default constructor for test class LogAnalyzerTest
     */
    public LogAnalyzerTest()
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
        LogfileCreator fileCreator = new LogfileCreator();
        fileCreator.createFile("logfile.txt", 100);
        
        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        
        File file = new File("logfile.txt");
        assertEquals(true, file.exists());
        assertEquals(1700, file.length());
    }
    
    @Test
    public void testNumberOfAccesses()
    {
        LogfileCreator fileCreator = new LogfileCreator();
        fileCreator.createFile("logfile.txt", 50);
        
        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();
        assertEquals(50, logAnalyzer.numberOfAccesses());
        
        fileCreator.createFile("logfile.txt", 25);
        
        logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();
        assertEquals(25, logAnalyzer.numberOfAccesses());        
    }
    
    @Test
    public void testBusiestHour() throws IOException
    {
        File file = new File("logfile.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        }
        catch(IOException e) {
            throw e;
        }
        PrintWriter pw = new PrintWriter(fw);
        
        pw.println("2011 01 17 19 32");
        pw.close();

        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        assertEquals(19, logAnalyzer.busiestHour());
    } 
    
    @Test
    public void testQuietestHour() throws IOException
    {
        File file = new File("logfile.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        }
        catch(IOException e) {
            throw e;
        }
        PrintWriter pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour != 10)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();

        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(10, logAnalyzer.quietestHour());
    } 
    
    @Test
    public void testBusiestTwoHours() throws IOException
    {
        File file = new File("logfile.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        }
        catch(IOException e) {
            throw e;
        }
        PrintWriter pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour == 9 || hour == 10)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();

        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(9, logAnalyzer.busiestTwoHours());
    }    
}

