public class ClockRunner
{
    private static Thread t;
    private static boolean run;
    
    public static void startClock() {
        run = true;
        
        t = new Thread(new Clock());
        t.start();
    }
    
    public static void stopClock() {
        run = false;
    }
    
    public static boolean isRunning() {
        return run;
    }
}
