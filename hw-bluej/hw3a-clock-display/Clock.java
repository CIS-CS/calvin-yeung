import java.util.Calendar;

public class Clock {
    private ClockDisplay clock;
    
    public Clock() {
        clock = new ClockDisplay();
    }
    
    public Clock(int h, int m, String mer) {
        clock = new ClockDisplay(h, m, mer);
    }
    
    public void run() 
    {    
        int previousMinute = -1;
        
        while (true) {
            Calendar calendar  = Calendar.getInstance();
            int currentMinute = calendar.get(Calendar.MINUTE);
            
            if (currentMinute != previousMinute)
            {
                clock.timeTick();
                previousMinute = currentMinute;
            }
        }
    }
}
