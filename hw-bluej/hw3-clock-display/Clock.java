import java.util.Calendar;

/**
 * Uses a ClockDisplay to display the time.
 * 
 * @author MHayes 
 * @version Sep2015
 */
public class Clock implements Runnable
{
    private ClockDisplay clock;
    
    public Clock()
    {
        clock = new ClockDisplay(12,55,20);
    }
    
    public void run() 
    {    
        int previousSecond = -1;
        
        while (ClockRunner.isRunning()) {
            Calendar calendar  = Calendar.getInstance();
            int currentSecond = calendar.get(Calendar.SECOND);
            
            if (currentSecond != previousSecond)
            {
                clock.timeTick();
                System.out.println(clock.getTime());
                previousSecond = currentSecond;
            }
        }
    }
}
    