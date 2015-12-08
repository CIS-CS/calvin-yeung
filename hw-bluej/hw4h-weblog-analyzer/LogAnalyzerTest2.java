

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * The test class LogAnalyzerTest2.
 *
 * @author  MHayes
 * @version 2015-12-08
 */
public class LogAnalyzerTest2
{
    private File file = null;
    private FileWriter fw = null;
    private PrintWriter pw = null;
    
    /**
     * Default constructor for test class LogAnalyzerTest
     */
    public LogAnalyzerTest2()
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

    private void createLogFile() 
    {
        // Create a log file
        file = new File("logfile.txt");
        fw = null;
        try {
            fw = new FileWriter(file);
        }
        catch(IOException e) {
             System.out.println(e);
        }        
    }
    
    @Test
    public void testConstructor()
    {
        LogfileCreator fileCreator = new LogfileCreator();
        fileCreator.createFile("logfile.txt", 100);
        
        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        
        file = new File("logfile.txt");
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
    public void testBusiestHour()
    {

        
        // Make hour 0 the busiest
        createLogFile();
        pw = new PrintWriter(fw);
        pw.println("2011 01 17 0 32");
        pw.close();

        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        assertEquals(0, logAnalyzer.busiestHour());
        
        // Make hour 19 the busiest
        createLogFile();
        pw = new PrintWriter(fw);
        pw.println("2011 01 17 19 32");
        pw.close(); 
        logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        assertEquals(19, logAnalyzer.busiestHour()); 
        
        // Make hour 23 the busiest
        createLogFile();
        pw = new PrintWriter(fw);
        pw.println("2011 01 17 23 32");
        pw.close(); 
        logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        assertEquals(23, logAnalyzer.busiestHour());
    } 
    
    @Test
    public void testQuietestHour() throws IOException
    {
        // Make hour 0 the quiest hour
        createLogFile();
        pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour != 0)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();
        
        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(0, logAnalyzer.quietestHour());        
        
        // Make hour 10 the quiest hour
        createLogFile();
        pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour != 10)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();

        logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(10, logAnalyzer.quietestHour());
        
        // Make hour 23 the quiest hour
        createLogFile();
        pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour != 23)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();

        logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(23, logAnalyzer.quietestHour());
    } 
    
    @Test
    public void testBusiestTwoHours() throws IOException
    {
        // Make hours 0-1 the busiest
        createLogFile();
        pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour == 0 || hour == 1)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();

        LogAnalyzer logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(0, logAnalyzer.busiestTwoHours());
        
        // Make hours 9-10 the busiest
        createLogFile();
        pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour == 9 || hour == 10)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();

        logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(9, logAnalyzer.busiestTwoHours());
        
        // Make hours 22-23 the busiest
        createLogFile();
        pw = new PrintWriter(fw);
        
        for (int hour = 0; hour < 24; hour++)
        {
            pw.println("2011 01 17 " + hour + " 00");
            if (hour == 22 || hour == 23)
            {
                pw.println("2011 01 17 " + hour + " 01");
            }
        }
        pw.close();

        logAnalyzer = new LogAnalyzer("logfile.txt");
        logAnalyzer.analyzeHourlyData();        
        //System.out.println(logAnalyzer.busiestHour());
        assertEquals(22, logAnalyzer.busiestTwoHours());        
    }    
}

