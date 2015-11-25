/**
 *  Read and write Student objects to a text file.
 */
package page090_DataFiles_4Tier;

import java.io.IOException;
import ibio.*;

public class StudentLogger {
    
    public static void main(String[] args) {
        
        StudentLogger logger = new StudentLogger();
        logger.run();
    }
    
    public void run()
    {
        Persister persist = new Persister();
        String  name = null;
        int     age  = 0;
        Student student = null;
        
        try 
        {
            // Prompt user and write to the file
            persist.init();            
            name = IBIO.inputString("What is your name: ");
            age  = IBIO.inputInt("What is your age: ");
            student = new Student(name, age);
            persist.write(student);
            persist.close();
            
            // Read all records from the file
            persist.init();
            student = persist.read();
            while (student != null)
            {                
                IBIO.output(student.getName() + " : " + student.getAge());
                student = persist.read();
            }            
            persist.close();
        }
        catch(IOException e)
        {
            System.out.println("\n*** " + e.getMessage() + "\n");
        }
        
    }
}
