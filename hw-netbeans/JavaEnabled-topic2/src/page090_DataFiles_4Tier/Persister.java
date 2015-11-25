package page090_DataFiles_4Tier;

// For writing to the file
import java.io.FileWriter;
import java.io.PrintWriter;

// For reading from the file
import java.io.FileReader;
import java.io.BufferedReader;

// Other I/O stuff
import java.io.IOException;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;

/**
 * Persister manages the I/O between the application and the text file.
 * @author MHayes
 */
public class Persister {
    
    private String         filename = "c:\\test.txt";       
    private FileWriter     fw = null;                // For writing to the file.
    private PrintWriter    outFile = null;
    private FileReader     fr = null;                // For reading from the file.
    private BufferedReader inFile = null;    

    public void init() throws IOException
    {
        String msg = "Error initializing Persister: ";
        // Open the file in append mode. 
        // Creates a new file if it does not exist.
        try {
            // For writing to the file
            fw = new FileWriter(filename, true); 
            outFile = new PrintWriter(fw); 
            
            // For reading from the file
            fr = new FileReader(filename);
            inFile = new BufferedReader(fr);
        }
        catch (FileNotFoundException e) {
            throw new FileNotFoundException(msg + e);
        }         
        catch (IOException e) {
            throw new IOException(msg + e);
        }       
    }
    
    public void write(Student s)
    {
        // write the student to the file
        outFile.println(s.getName() + ";" + s.getAge());
    }
    
    public Student read() throws IOException
    {
        String record = null;
        String name = null;
        int age = 0;
        
        try
        {
            record = inFile.readLine();
            if (record != null)
            {
                /*
                StringTokenizer st = new StringTokenizer(record, ";");
                name = st.nextToken();
                age  = Integer.parseInt(st.nextToken());
                return (new Student(name, age));
                */
                String[] fields = record.split(";");
                name = fields[0];
                age  = Integer.parseInt(fields[1]);
                return (new Student(name, age));
            }
            else
            {
                return null;
            }
        }
        catch(IOException e)
        {
            throw new IOException("Error reading file: " + e);
        }
        catch(NoSuchElementException e)
        {
            throw new NoSuchElementException("Error reading file: " + e);
        }
        catch(NumberFormatException e)
        {
            throw new NumberFormatException("Error reading file: " + e);
        }        
    }
    
    public void close()
    {
        outFile.close();
    }
}








