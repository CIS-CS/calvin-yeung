import java.util.Calendar;

public class Clock {
    private ClockDisplay clock;
    
    public Clock() {
        clock = new ClockDisplay();
    }
    
    public Clock(int h, int m, int s, String mer) {
        clock = new ClockDisplay(h, m, s, mer);
    }
    
    public void run() 
    {    
        int previousSecond = -1;
        
        while (true) {
            Calendar calendar  = Calendar.getInstance();
            int currentSecond = calendar.get(Calendar.SECOND);
            
            if (currentSecond != previousSecond)
            {
                clock.timeTick();
                previousSecond = currentSecond;
            }
        }
    }
}
