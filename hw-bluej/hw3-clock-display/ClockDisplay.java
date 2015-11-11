public class ClockDisplay {
    
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private String meridien;
    private String displayString;
    
    public ClockDisplay() {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(12, 0, 0, "a.m.");
    }

    public ClockDisplay(int hour, int minute, int second, String mer) {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        setTime(hour, minute, second, mer);
    }

    public void timeTick() {
        seconds.increment();
        if(seconds.getValue() == 0) {
            minutes.increment();
            
            if(minutes.getValue() == 0) {
                hours.increment();
                
                if(hours.getValue() == 0)
                    toggleMeridien();
            }
        }
        
        updateDisplay();
    }
    
    public void setTime(int hour, int minute, int second, String mer) {
        if(hour == 12)
            hour = 0;
        
        hours.setValue(hour);
        System.out.println(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        meridien = mer;
        
        updateDisplay();
    }
    
    public void toggleMeridien() {
        meridien = (meridien == "a.m.") ? "p.m." : "a.m.";
    }

    public String getTime() {
        updateDisplay();
        return displayString;
    }
    
    private void updateDisplay() {
        String h = hours.getDisplayValue();
        String m = minutes.getDisplayValue();
        String s = seconds.getDisplayValue();
        
        if(h.equals("00")) h = "12";
        displayString = String.format("%s:%s:%s %s", h, m, s, meridien);
    }
}
