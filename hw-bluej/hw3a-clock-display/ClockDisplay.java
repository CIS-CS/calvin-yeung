public class ClockDisplay {
    
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String meridien;
    private String displayString;
    
    public ClockDisplay() {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(12, 0, "a.m.");
    }

    public ClockDisplay(int hour, int minute, String mer) {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        setTime(hour, minute, mer);
    }

    public void timeTick() {
        minutes.increment();
        
        if(minutes.getValue() == 0) {
            hours.increment();
            
            if(hours.getValue() == 0)
                toggleMeridien();
        }
        
        updateDisplay();
    }
    
    public void setTime(int hour, int minute, String mer) {
        hours.setValue(hour);
        minutes.setValue(minute);
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
        
        if(h.equals("00")) h = "12";
        displayString = String.format("%s:%s %s", h, m, meridien);
    }
}
